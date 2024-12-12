package com.example.weather_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Opacity
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
fun HumidAndWindCard() {
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
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(
          modifier = Modifier
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
            .size(width = 150.dp, height = 80.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
        ) {
          Text(
            color = Color.LightGray,
            fontWeight = FontWeight.SemiBold,
            text = "Wind Speed",
            fontSize = 14.sp,
          )
          Row(
            modifier = Modifier
              .padding(top = 4.dp)
          ) {
            Icon(
              imageVector = Filled.Air,
              contentDescription = "Menu Icon",
              tint = Color.Red,
              modifier = Modifier.size(22.dp)
            )
            Text(
              text = "18km/h",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.SansSerif,
              modifier = Modifier.padding(bottom = 16.dp)
            )
          }
        }
        Column(
          modifier = Modifier
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
            .size(width = 150.dp, height = 80.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
        ) {
          Text(
            color = Color.LightGray,
            fontWeight = FontWeight.SemiBold,
            text = "Humidity",
            fontSize = 14.sp,
          )
          Row(
            modifier = Modifier
              .padding(top = 4.dp)
          ) {
            Icon(
              imageVector = Filled.Opacity,
              contentDescription = "Menu Icon",
              tint = Color.Red,
              modifier = Modifier.size(22.dp)
            )
            Text(
              text = "78%",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.SansSerif,
              modifier = Modifier.padding(bottom = 16.dp)
            )
          }
        }
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HumidAndWindCardPreview() {
  Weather_AppTheme {
    HumidAndWindCard()
  }
}