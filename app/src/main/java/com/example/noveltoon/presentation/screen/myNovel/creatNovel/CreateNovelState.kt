package com.example.noveltoon.presentation.screen.myNovel.creatNovel

import com.example.noveltoon.core.utils.ActionState
import com.example.noveltoon.domain.model.Novel

data class CreateNovelState (
    val showTitleSheet : Boolean = false,
    val titleText : String = "",
    val descriptionText: String = "",
    val showDescriptionSheet : Boolean = false,
    val createState : ActionState<Novel> = ActionState.Idle
)
