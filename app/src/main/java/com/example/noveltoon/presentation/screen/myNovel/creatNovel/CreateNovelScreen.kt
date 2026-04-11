package com.example.noveltoon.presentation.screen.myNovel.creatNovel

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noveltoon.core.utils.ActionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNovelScreen(
    viewModel: CreateNovelViewModel = hiltViewModel(),
    onCreateNovelSuccess: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                CreateNovelScreenEvent.CreateNovelEvent.Success -> {
                    onCreateNovelSuccess()
                }

                else -> {}
            }
        }
    }

    if (state.showTitleSheet) {
        ModalBottomSheet(
            onDismissRequest = { viewModel.toggleTitleSheet() },
            containerColor = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            BottomSheet(
                text = state.titleText,
                heading = "Tiêu đề",
                placeHolder = "Tiêu đề",
                onSave = {
                    viewModel.updateTitleText(it)
                    viewModel.toggleTitleSheet()

                }
            )
        }
    }

    if (state.showDescriptionSheet) {
        ModalBottomSheet(
            onDismissRequest = { viewModel.toggleDescriptionSheet() },
            containerColor = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            BottomSheet(
                text = state.descriptionText,
                heading = "Giới thiệu",
                placeHolder = "Vui lòng viết sơ lược về tác phẩm của bạn",
                onSave = {
                    viewModel.updateDescriptionText(it)
                    viewModel.toggleDescriptionSheet()

                }
            )
        }
    }

    when (state.createState) {
        is ActionState.Loading -> {
            CircularProgressIndicator()
        }

        is ActionState.Error -> {
            Text(
                text = (state.createState as ActionState.Error).message,
                color = Color.Red
            )
        }

        else -> {}
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        Spacer(Modifier.height(16.dp))

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Tiêu đề và ảnh bìa đẹp là một nửa của thành công",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))

        CreateNovelCard(
            onShowTitleSheet = viewModel::toggleTitleSheet,
            onShowDescriptionSheet = viewModel::toggleDescriptionSheet,
            titleText = state.titleText,
            descriptionText = state.descriptionText,
            onCreateNovel = viewModel::createNovel
        )
    }
}

@Composable
fun BottomSheet(
    text: String,
    heading: String,
    placeHolder: String,
    onSave: (String) -> Unit
) {

    var value by remember { mutableStateOf(text) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { }) {
                Icon(Icons.Default.ArrowBack, null)
            }

            Text(
                text = heading,
                style = MaterialTheme.typography.titleMedium
            )

            Button(
                onClick = { onSave(value) }
            ) {
                Text("Lưu lại")
            }
        }

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            placeholder = {
                Text(placeHolder)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
    }
}

@Composable
fun CreateNovelCard(
    onShowTitleSheet: () -> Unit,
    onShowDescriptionSheet: () -> Unit,
    titleText: String,
    descriptionText: String,
    onCreateNovel: (title: String, description: String) -> Unit
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            CoverSection()

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            FormRow(
                title = "* Tiêu đề",
                value = titleText.ifEmpty { "Tiêu đề" },
                onClick = onShowTitleSheet
            )

            Divider()

            FormRow(
                title = "* Giới thiệu",
                value = descriptionText.ifEmpty { "Vui lòng viết sơ lược về tác phẩm của bạn" },
                onClick = onShowDescriptionSheet
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "Sau khi tạo tác phẩm thành công, cần sửa đổi thông tin tác phẩm...",
                fontSize = 13.sp,
                color = Color.Gray
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = { onCreateNovel(titleText, descriptionText) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50)
            ) {
                Text("Tạo tác phẩm")
            }
        }
    }
}

@Composable
fun CoverSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text("Ảnh bìa")

        Box(
            modifier = Modifier
                .size(90.dp)
                .border(
                    1.dp,
                    Color.LightGray,
                    RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )

                Text(
                    text = "Thêm bìa",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun FormRow(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(title)

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                modifier = Modifier
                    .weight(1f, fill = false),
                text = value,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}