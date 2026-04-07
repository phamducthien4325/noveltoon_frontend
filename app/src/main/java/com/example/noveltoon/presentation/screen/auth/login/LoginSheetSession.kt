package com.example.noveltoon.presentation.screen.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginSheetContent(
    state: LoginState,
    onClose: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- HEADER ---
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Đăng nhập", style = MaterialTheme.typography.titleMedium)
            IconButton(
                onClick = onClose,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- ILLUSTRATION (Bong bóng & Chibi) ---
        // Phần này bạn nên dùng Image hoặc Canvas vẽ, ở đây mình giả lập bố cục
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            // Box giả lập bong bóng chat
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFF4E342E), RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Text(
                    "Hi! Chào mừng đến với NovelToon, Người dùng mới đăng nhập lần đầu có thể nhận gói quà bất ngờ đó!",
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            }

            // Ảnh nhân vật (Thay bằng Painter của bạn)
//            Image(
//                painter = painterResource(id = R.drawable.chibi_character),
//                contentDescription = null,
//                modifier = Modifier.size(80.dp)
//            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- INPUT FIELDS ---
        CustomLoginTextField(
            value = state.email,
            onValueChange = onEmailChange,
            placeholder = "Vui lòng nhập email của bạn",
            leadingIcon = Icons.Default.Email
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomLoginTextField(
            value = state.password,
            onValueChange = onPasswordChange,
            placeholder = "Vui lòng nhập mật khẩu",
            leadingIcon = Icons.Default.Lock,
            isPassword = true
        )

        Text(
            text = "Lấy lại mật khẩu",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 8.dp)
                .clickable { /* Handle */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- BUTTONS ---
        Button(
            onClick = onLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = CircleShape
        ) {
            Text("Đăng nhập", color = Color.White, fontWeight = FontWeight.Bold)
        }

        TextButton(onClick = { /* Register */ }) {
            Text("Đăng ký", color = Color(0xFF64B5F6))
        }

        Text(
            text = "Gặp vấn đề khi đăng nhập?",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp,
            modifier = Modifier.clickable { /* Handle */ }
        )
    }
}