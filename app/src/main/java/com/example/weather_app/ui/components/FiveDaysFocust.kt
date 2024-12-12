package com.example.weather_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.WbSunny
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
fun FiveDaysFocusCard() {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 4.dp
    ),
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
  ) {
    Row(
      modifier = Modifier
        .padding(10.dp),
      horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Icon(
        imageVector = Filled.CalendarToday,
        contentDescription = "Sun Icon",
        tint = Color.White,
        modifier = Modifier.size(22.dp)
      )
      Text(
        text = "24h forecast",
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
      )
    }
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
          Row(
            modifier = Modifier
              .padding(top = 4.dp)
          ) {
            Icon(
              imageVector = Filled.WbSunny,
              contentDescription = "Sun Icon",
              tint = Color.Yellow,
              modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "18°C",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.SansSerif,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "Sunny",
              fontSize = 16.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color.DarkGray,
              fontFamily = FontFamily.SansSerif,
            )
          }
        Text(
          text = "24°/18°",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.SansSerif
        )
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FiveDaysFocusCardPreview() {
  Weather_AppTheme {
    FiveDaysFocusCard()
  }
}