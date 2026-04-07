package com.example.noveltoon.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noveltoon.presentation.components.UserAvatar

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
//            .padding(padding)
    ) {
        item { TopActionButtons() }
        // 1. Header: Avatar, Tên, Level
        item { ProfileHeader() }

        // 2. Stats: Xu, Điểm, Phiếu
        item { UserStatsRow() }

        // 3. Quick Actions: Trở thành tác giả, Phúc lợi...
//            item { QuickActionsGrid() }

        // 4. List Options
        item {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                MenuListItem(Icons.Default.ShoppingCart, "Toon Mall")
                MenuListItem(Icons.Default.Star, "VIP")
                MenuListItem(
                    Icons.Default.Search,
                    "Tìm tiểu thuyết trên Internet",
                    hasNotification = true
                )
                MenuListItem(
                    Icons.Default.AccountBalanceWallet,
                    "Nạp tiền",
                    textColor = Color(0xFFFFA500)
                )
                MenuListItem(Icons.Default.Description, "Phiếu đọc truyện của tôi")
            }
        }

        // Các nhóm Menu tiếp theo... (tương tự như trên)
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar
        UserAvatar(
            avatarUrl = null,
            username = "Phạm Đức Thiện",
            modifier = Modifier.size(64.dp)
        )
//        Image(
//            painter = painterResource(id = R.drawable.avatar_placeholder),
//            contentDescription = null,
//            modifier = Modifier
//                .size(64.dp)
//                .clip(CircleShape)
//        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = "Phạm Đức Thiện", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Surface(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(
                    text = "Lv0",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Nút điểm danh
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(20.dp)
        ) {
            Icon(
                Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Text(" 0 ngày", fontSize = 12.sp)
        }
    }
}

@Composable
fun UserStatsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(number = "0", label = "Xu của tôi")
        StatItem(number = "1", label = "Điểm của tôi")
        StatItem(number = "1", label = "Phiếu")
    }
}

@Composable
fun StatItem(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = number, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = label, fontSize = 12.sp, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
fun MenuListItem(
    icon: ImageVector,
    title: String,
    textColor: Color = Color.Black,
    hasNotification: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.DarkGray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, modifier = Modifier.weight(1f), color = textColor, fontSize = 15.sp)

        if (hasNotification) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
        }
    }
    Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        thickness = 0.5.dp,
        color = Color.LightGray
    )
}

@Composable
fun TopActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Xử lý mở tin nhắn */ }) {
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = "Tin nhắn",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Nút Cài đặt (Settings)
        IconButton(onClick = { /* Xử lý mở cài đặt */ }) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Cài đặt",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}