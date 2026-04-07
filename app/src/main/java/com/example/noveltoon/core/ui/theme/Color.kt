package com.example.noveltoon.core.ui.theme

import androidx.compose.ui.graphics.Color

// Gốc màu NovelToon
val NovelToonBlue = Color(0xFF1F92EA)

// ===== LIGHT THEME (Ưu tiên sự sạch sẽ, trắng sáng) =====

val primaryLight = NovelToonBlue
val onPrimaryLight = Color(0xFFFFFFFF)
// Container nhạt để làm nền cho các ô nhập liệu hoặc label nhẹ
val primaryContainerLight = Color(0xFFE1F0FF)
val onPrimaryContainerLight = Color(0xFF001D34)

val secondaryLight = Color(0xFF535F70) // Xanh xám trung tính
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFD7E3F7)
val onSecondaryContainerLight = Color(0xFF101C2B)

val tertiaryLight = Color(0xFF6B5778) // Tím nhạt để cân bằng với xanh
val onTertiaryLight = Color(0xFFFFFFFF)
val tertiaryContainerLight = Color(0xFFF2DAFF)
val onTertiaryContainerLight = Color(0xFF251431)

val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF410002)

val backgroundLight = Color(0xFFF8F9FF) // Nền hơi xanh cực nhẹ cho hiện đại
val onBackgroundLight = Color(0xFF9A9C9C)

val surfaceLight = Color(0xFFFFFFFF) // Bảng trắng tinh khiết
val onSurfaceLight = Color(0xFF9A9C9C)

// Dành cho Placeholder và các icon mờ
val surfaceVariantLight = Color(0xFFDEE3EB)
val onSurfaceVariantLight = Color(0xFF42474E)

val outlineLight = Color(0xFF72777F) // Viền ô input
val outlineVariantLight = Color(0xFFC2C7CF) // Đường kẻ divider "Hoặc"

val inverseSurfaceLight = Color(0xFF2E3033)
val inverseOnSurfaceLight = Color(0xFFF0F0F4)
val inversePrimaryLight = Color(0xFFA5C8FF)

// Hệ thống Container cho bề mặt (Surface)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF2F3F9)
val surfaceContainerLight = Color(0xFFECEEF4)
val surfaceContainerHighLight = Color(0xFFE7E8EE) // Dùng cho nền ô Input
val surfaceContainerHighestLight = Color(0xFFE1E2E8)


// ===== DARK THEME (Dành cho chế độ đọc ban đêm) =====

val primaryDark = Color(0xFFA5C8FF) // Xanh nhạt hơn để không chói
val onPrimaryDark = Color(0xFF003159)
val primaryContainerDark = Color(0xFF00487E)
val onPrimaryContainerDark = Color(0xFFD3E4FF)

val secondaryDark = Color(0xFFBBC7DB)
val onSecondaryDark = Color(0xFF253140)
val secondaryContainerDark = Color(0xFF3B4858)
val onSecondaryContainerDark = Color(0xFFD7E3F7)

val backgroundDark = Color(0xFF111418)
val onBackgroundDark = Color(0xFFE1E2E8)

val surfaceDark = Color(0xFF111418)
val onSurfaceDark = Color(0xFFE1E2E8)

val surfaceVariantDark = Color(0xFF42474E)
val onSurfaceVariantDark = Color(0xFFC2C7CF)

val outlineDark = Color(0xFF8C9199)
val outlineVariantDark = Color(0xFF42474E)

// Màu phủ (lớp mờ phía sau bảng đăng nhập)
// 0x52 là độ alpha ~32%, tạo hiệu ứng mờ đen vừa phải không quá tối
val scrimLight = Color(0xFF000000)

// Bề mặt tông trầm (dùng cho nền phía sau khi bảng hiện lên)
val surfaceDimLight = Color(0xFFD8DAE0)

// Bề mặt tông sáng (dùng cho bảng trắng đăng nhập để nó thực sự nổi bật)
val surfaceBrightLight = Color(0xFFF8F9FF)


// ===== DARK THEME BỔ SUNG =====

// Trong chế độ tối, Scrim thường đậm hơn để tách biệt các lớp
val scrimDark = Color(0xFF000000)

// Bề mặt tối sâu hơn
val surfaceDimDark = Color(0xFF111418)

// Bề mặt tối nhưng có chút ánh sáng để phân biệt với nền đen tuyệt đối
val surfaceBrightDark = Color(0xFF37393E)