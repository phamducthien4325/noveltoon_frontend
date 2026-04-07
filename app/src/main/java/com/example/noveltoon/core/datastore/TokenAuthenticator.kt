package com.example.noveltoon.core.datastore

import android.util.Log
import com.example.noveltoon.data.remote.api.AuthApi
import com.example.noveltoon.data.remote.dto.RefreshRequest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Authenticator
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.Route
import org.json.JSONObject
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager
) : Authenticator {

    private val mutex = Mutex()

    override fun authenticate(route: Route?, response: Response): Request? {

        if (responseCount(response) >= 2) {
            return null
        }

        Log.d("AUTH_DEBUG", "Token expired → trying refresh")

        val refreshToken = runBlocking {
            tokenManager.getRefreshToken()
        } ?: return null

        Log.d("AUTH_DEBUG", "Refresh token: $refreshToken")

        val newTokens = runBlocking {
            mutex.withLock {
                refreshToken(refreshToken)
            }
        } ?: return null

        runBlocking {
            tokenManager.saveTokens(
                newTokens.first,
                newTokens.second
            )
        }

        return response.request.newBuilder()
            .header("Authorization", "Bearer ${newTokens.first}")
            .build()
    }

    private fun refreshToken(refreshToken: String): Pair<String, String>? {

        val client = OkHttpClient()

        val json = """
            {
                "refreshToken": "$refreshToken"
            }
        """.trimIndent()

        val body = json.toRequestBody(
            "application/json".toMediaType()
        )

        val request = Request.Builder()
            .url("https://your-api.com/auth/refresh")
            .post(body)
            .build()

        val response = client.newCall(request).execute()

        if (!response.isSuccessful) return null

        val responseBody = response.body?.string() ?: return null

        val jsonObject = JSONObject(responseBody)

        val accessToken = jsonObject.getString("accessToken")
        val newRefreshToken = jsonObject.getString("refreshToken")

        return Pair(accessToken, newRefreshToken)
    }

    private fun responseCount(response: Response): Int {
        var count = 1
        var res = response.priorResponse

        while (res != null) {
            count++
            res = res.priorResponse
        }

        return count
    }
}