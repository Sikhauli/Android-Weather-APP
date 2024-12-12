package com.example.weather_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.Weather_AppTheme

@Composable
fun HumidityCard() {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 4.dp
    ),
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(
          modifier = Modifier
            .padding(16.dp)
        ) {
          Text(
            color = Color.LightGray,
            fontWeight = FontWeight.SemiBold,
            text = "Feels like",
            fontSize = 14.sp,
          )
          Row(
            modifier = Modifier
              .padding(top = 4.dp)
          ) {
            Icon(
              imageVector = Filled.Thermostat,
              contentDescription = "Menu Icon",
              tint = Color.Red,
              modifier = Modifier.size(22.dp)
            )
            Text(
              text = "18°C",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.SansSerif,
              modifier = Modifier.padding(bottom = 16.dp)
            )
          }
        }
        Text(
          text = "Hello everyone i can tell your life is miserable, yes your life is miserable",
          fontSize = 14.sp,
          fontFamily = FontFamily.SansSerif
        )
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HumidityCardPreview() {
  Weather_AppTheme {
    HumidityCard()
  }
}