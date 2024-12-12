package com.example.weather_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.Weather_AppTheme

@Composable
fun InfoSection() {
  Row(
    modifier = Modifier
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row(
      modifier = Modifier
    ) {
      Icon(
        imageVector = Icons.Filled.LocationOn,
        contentDescription = "Location Icon",
        tint = Color.Red,
        modifier = Modifier.size(22.dp)
      )
      Spacer(modifier = Modifier.width(5.dp))
      Text(
        text = "Location Name",
        fontSize = 12.sp,
        fontFamily = FontFamily.Serif,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier.padding(top = 2.dp)
      )
    }
    Row(
      modifier = Modifier
    ) {
      Icon(
        imageVector = Icons.Filled.Search,
        contentDescription = "Search Icon",
        tint = Color.Red,
        modifier = Modifier.size(22.dp)
      )
      Spacer(modifier = Modifier.width(15.dp))
      Icon(
        imageVector = Icons.Filled.MoreVert,
        contentDescription = "Menu Icon",
        tint = Color.Red,
        modifier = Modifier.size(22.dp)
      )
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserInfoPreview() {
  Weather_AppTheme {
    InfoSection()
  }
}