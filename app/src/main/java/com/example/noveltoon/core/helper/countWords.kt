package com.example.noveltoon.core.helper

fun countWords(text: String): Int {
    val regex = "\\b\\p{L}+\\b".toRegex()
    return regex.findAll(text).count()
}