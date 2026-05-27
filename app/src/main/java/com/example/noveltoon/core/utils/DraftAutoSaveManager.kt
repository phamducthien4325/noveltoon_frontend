package com.example.noveltoon.core.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DraftAutoSaveManager(
    private val saveDraft: suspend () -> Unit
) {
    private var job: Job? = null
    private var isDirty = false

    fun onContentChanged() {
        isDirty = true

        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            delay(60_000) // 60s

            if (isDirty) {
                saveDraft()
                isDirty = false
            }
        }
    }
}