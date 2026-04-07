package com.example.noveltoon.domain.repository

import androidx.paging.PagingSource
import com.example.noveltoon.domain.model.Novel

interface NovelRepository {
    fun getNovels(): PagingSource<Int, Novel>
}