package com.example.noveltoon.presentation.screen.myNovel.myNovelDetail

import com.example.noveltoon.core.utils.ActionState
import com.example.noveltoon.domain.model.Chapter

data class MyNovelDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val novelId: String = "",
    val createChapterState: ActionState<Chapter> = ActionState.Idle,
)