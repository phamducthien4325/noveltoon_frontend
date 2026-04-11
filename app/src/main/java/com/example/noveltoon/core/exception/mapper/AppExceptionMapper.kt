package com.example.noveltoon.core.exception.mapper

import com.example.noveltoon.core.exception.AppException

fun AppException.toMessage(): String {
    return when (this) {
        is AppException.Network -> "Không có mạng"
        is AppException.Api -> "Lỗi server"
        is AppException.Validation -> message
        is AppException.Unauthorized -> "Hết phiên đăng nhập"
        else -> "Có lỗi xảy ra"
    }
}