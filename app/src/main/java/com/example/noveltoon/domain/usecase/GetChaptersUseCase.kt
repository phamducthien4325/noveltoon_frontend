package com.example.noveltoon.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.noveltoon.domain.model.Chapter
import com.example.noveltoon.domain.repository.ChapterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//class GetChaptersUseCase @Inject constructor(
//    private val repository: ChapterRepository
//) {
//    operator fun invoke(): Flow<PagingData<Chapter>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 20,
//                initialLoadSize = 20,
//                prefetchDistance = 3,
//                enablePlaceholders = false
//            )
//        ) {
//            repository.getChapters()
//        }.flow
//    }
//}

class GetChaptersUseCase @Inject constructor(
    private val repository: ChapterRepository
) {
    operator fun invoke(novelId: String) =
        repository.getChapters(novelId)
}