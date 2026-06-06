# Noveltoon Mobile App

Ứng dụng đọc truyện trực tuyến hiện đại dành cho nền tảng Android, được xây dựng hoàn toàn bằng **Kotlin**, **Jetpack Compose** và áp dụng kiến trúc **Clean Architecture** kết hợp với **MVVM**. Dự án được thiết kế để mang lại trải nghiệm đọc truyện mượt mà, tối ưu hiệu năng và dễ dàng bảo trì, mở rộng.

---

## Tính năng nổi bật

- **Xác thực người dùng (Auth):** Hỗ trợ Đăng nhập và Đăng ký tài khoản để đồng bộ dữ liệu cá nhân.
- **Trang chủ trực quan (Home):** Hiển thị danh sách truyện đề xuất, truyện hot, truyện mới cập nhật và các hashtag xu hướng.
- **Trình đọc truyện chuyên nghiệp (Reader):**
  - Đọc nội dung chương truyện mượt mà với hiệu năng tối ưu.
  - Hỗ trợ xem video/trailer đi kèm trực tiếp trong ứng dụng thông qua trình phát **YouTube Player**.
- **Thư viện cá nhân (Library):** Lưu trữ lịch sử đọc truyện và danh sách các tác phẩm đang theo dõi.
- **Sáng tác truyện (My Novel):** Tính năng cho phép người dùng tự sáng tác, tạo mới và quản lý các tác phẩm của riêng mình.
- **Tìm kiếm thông minh (Hashtag):** Lọc và tìm kiếm truyện nhanh chóng theo các hashtag hoặc thể loại liên quan.
- **Định vị & Cá nhân hóa (Location):** Sử dụng dịch vụ định vị để tối ưu hóa gợi ý nội dung theo khu vực.

---

## Công nghệ & Thư viện sử dụng (Tech Stack)

Dự án sử dụng các công nghệ và thư viện hiện đại nhất theo khuyến nghị của Google dành cho phát triển ứng dụng Android:

*   **Ngôn ngữ lập trình:** [Kotlin](https://kotlinlang.org/) (phiên bản mới nhất, tương thích JVM 17).
*   **UI Framework:** [Jetpack Compose](https://developer.android.com/compose) với hệ thống thiết kế [Material 3](https://m3.material.io/) hiện đại, mượt mà và trực quan.
*   **Kiến trúc:** **Clean Architecture** chia tách rõ ràng thành 3 lớp riêng biệt (`data`, `domain`, `presentation`) kết hợp với mô hình **MVVM (Model-View-ViewModel)**.
*   **Dependency Injection (DI):** [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) kết hợp với **KSP (Kotlin Symbol Processing)** giúp tăng tốc độ build.
*   **Kết nối mạng (Networking):** [Retrofit 2](https://square.github.io/retrofit/) & [OkHttp 3](https://square.github.io/okhttp/) để giao tiếp với API RESTful, tích hợp *Logging Interceptor* cho việc debug.
*   **Cơ sở dữ liệu cục bộ (Local Storage):**
    *   [Room Database](https://developer.android.com/training/data-storage/room) để lưu trữ ngoại tuyến dữ liệu truyện, chương, lịch sử.
    *   [Preferences DataStore](https://developer.android.com/topic/libraries/architecture/datastore) để quản lý cấu hình người dùng và token bảo mật.
*   **Xử lý bất đồng bộ:** Kotlin [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [StateFlow / SharedFlow](https://kotlinlang.org/docs/flow.html) quản lý luồng dữ liệu thời gian thực.
*   **Phân trang dữ liệu:** [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) giúp tải danh sách truyện vô hạn (Infinite Scroll) cực kỳ mượt mà, tránh tràn bộ nhớ.
*   **Tải ảnh:** [Coil Compose](https://coil-kt.github.io/coil/) tải ảnh không đồng bộ và tối ưu hóa bộ nhớ đệm cache.
*   **Tính năng bổ sung:**
    *   *Google Play Services Location* hỗ trợ lấy vị trí địa lý của người dùng.
    *   *Accompanist Permissions* quản lý việc yêu cầu quyền một cách dễ dàng trong Compose.
    *   *Android YouTube Player* tích hợp phát video YouTube trực tiếp.
    *   *Core Splashscreen API* tạo hiệu ứng màn hình chào chuẩn Android 12+.

---

## Kiến trúc dự án & Cấu trúc thư mục

Ứng dụng tuân thủ nghiêm ngặt **Clean Architecture** được tổ chức như sau:

```text
com.example.noveltoon
│
├── core/                # Các thành phần dùng chung toàn app (UI Theme, tiện ích, hằng số)
│
├── di/                  # Cấu hình Dagger Hilt Module cung cấp dependencies (Retrofit, Room, Preferences)
│
├── domain/              # Lớp nghiệp vụ cốt lõi (Core Business Logic) - Hoàn toàn thuần Kotlin
│   ├── model/           # Các Entity/Model nghiệp vụ chính
│   ├── repository/      # Các Interface định nghĩa phương thức truy xuất dữ liệu
│   └── usecase/         # Các Use Cases (Nhiệm vụ cụ thể của ứng dụng như GetBooksUseCase, LoginUseCase)
│
├── data/                # Lớp xử lý dữ liệu (Cục bộ & Từ xa)
│   ├── local/           # Cấu hình Room DB, Entities, DAOs và DataStore Preferences
│   ├── remote/          # Định nghĩa Retrofit API Services, DTOs (Data Transfer Objects), PagingSource
│   ├── mapper/          # Chuyển đổi qua lại giữa DTO (lớp data) và Model (lớp domain)
│   └── repository/      # Triển khai thực tế (Implementation) của các Interface Repository ở lớp Domain
│
└── presentation/        # Lớp giao diện người dùng (UI Layer)
    ├── components/      # Các Jetpack Compose UI Components dùng chung (Button, Card, Loader...)
    ├── navigation/      # Cấu hình đồ thị điều hướng (RootNavHost, Screen Routes)
    └── screen/          # Các màn hình chức năng của ứng dụng (mỗi màn hình đi kèm ViewModel tương ứng)
        ├── auth/        # Đăng ký, đăng nhập
        ├── home/        # Trang chủ ứng dụng
        ├── library/     # Thư viện cá nhân
        ├── reader/      # Trình đọc truyện & Xem video
        ├── profile/     # Trang cá nhân
        ├── myNovel/     # Quản lý truyện sáng tác
        └── ...
```

---

## Hướng dẫn cấu hình & Khởi chạy dự án

### 1. Yêu cầu hệ thống trước khi cài đặt

- **Java Development Kit (JDK):** Yêu cầu phiên bản **JDK 17**.
- **Android SDK:** Hỗ trợ thiết bị chạy hệ điều hành Android từ **API 24** (Android 7.0) trở lên.
- **Android Studio:** Khuyến nghị sử dụng phiên bản mới nhất (ví dụ: Ladybug hoặc Jellyfish) để tương thích tốt nhất với Kotlin 2.0 và Compose.

### 2. Cấu hình biến môi trường `BASE_URL`

Dự án yêu cầu cung cấp địa chỉ API (Base URL) thông qua cấu hình hệ thống Gradle. Để thực hiện, vui lòng làm theo một trong hai cách dưới đây:

**Cách 1: Cấu hình thông qua file `gradle.properties` (Khuyến nghị)**
Mở hoặc tạo file `gradle.properties` ở thư mục gốc của dự án và thêm dòng sau:
```properties
BASE_URL=https://your-api-domain.com/api/
```

**Cách 2: Truyền qua tham số dòng lệnh khi Build**
Nếu build bằng Command Line, bạn có thể truyền trực tiếp:
```bash
./gradlew assembleDebug -PBASE_URL="https://your-api-domain.com/api/"
```

### 3. Các bước khởi chạy dự án

1.  **Clone dự án về máy cá nhân:**
    ```bash
    git clone <url-repository-cua-ban>
    cd noveltoon
    ```
2.  **Mở dự án bằng Android Studio:**
    - Chọn **File > Open** và dẫn tới thư mục dự án vừa clone.
    - Chờ đợi Android Studio đồng bộ hóa các file Gradle (Gradle Sync) và tải các dependencies cần thiết.
3.  **Cấu hình local.properties (Nếu cần):**
    Thông thường Android Studio sẽ tự động tạo file `local.properties` chứa đường dẫn đến SDK. Nếu chưa có, hãy tạo mới file này ở thư mục gốc với nội dung:
    ```properties
    sdk.dir=C\:\\Users\\<ten-user-cua-ban>\\AppData\\Local\\Android\\Sdk
    # (Đường dẫn có thể thay đổi tùy thuộc vào hệ điều hành của bạn)
    ```
4.  **Chạy ứng dụng:**
    - Kết nối thiết bị Android thật (đã bật chế độ Gỡ lỗi USB - USB Debugging) hoặc khởi chạy một thiết bị ảo (Emulator).
    - Chọn cấu hình chạy là `app` và nhấn nút **Run** (biểu tượng Play màu xanh) trên thanh công cụ của Android Studio.
    - Hoặc chạy thông qua dòng lệnh Gradle:
      ```bash
      ./gradlew installDebug
      ```