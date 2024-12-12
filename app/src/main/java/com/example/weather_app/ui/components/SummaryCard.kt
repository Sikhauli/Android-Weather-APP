package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder
import com.example.weather_app.R
import com.example.weather_app.ui.theme.Weather_AppTheme

@Composable
fun SummaryCard() {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 6.dp
    ),
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
    ) {
      Image(
        painter = rememberAsyncImagePainter(
          Builder(LocalContext.current).data(
            data = R.drawable.weather
          ).apply<Builder>(block = fun Builder.() {
            crossfade(true)
          }).build()
        ),
        contentDescription = "Add Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxWidth()
          .height(200.dp)
      )
      Column(
        modifier = Modifier
          .padding(16.dp),
      ) {
        Text(
          color = Color.DarkGray,
          fontWeight = FontWeight.SemiBold,
          text = "Today, 25 Dec",
          fontSize = 14.sp,
        )
        Text(
          text = "Clear and sunny",
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.SansSerif
        )
      }
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .align(Alignment.BottomCenter)
          .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(
          text = "23°C",
          color = Color.White,
          fontSize = 50.sp,
          fontWeight = FontWeight.ExtraBold,
          fontFamily = FontFamily.Monospace,
          modifier = Modifier.padding(start = 8.dp, top = 5.dp )
        )
        Text(
          text = "26°/12°",
          color = Color.White,
          fontWeight = FontWeight.SemiBold,
          modifier = Modifier.padding(start = 8.dp, top = 35.dp )
        )
        Icon(
          imageVector = Filled.Refresh,
          contentDescription = "Menu Icon",
          tint = Color.Red,
          modifier = Modifier
            .size(width = 60.dp, height = 60.dp)
            .padding(top = 30.dp)
        )
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SummaryCardPreview() {
  Weather_AppTheme {
    SummaryCard()
  }
}