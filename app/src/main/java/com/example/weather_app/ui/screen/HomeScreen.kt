package com.example.weather_app.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_app.ui.components.FiveDaysFocusCard
import com.example.weather_app.ui.components.ForecastScreen
import com.example.weather_app.ui.components.HumidAndWindCard
import com.example.weather_app.ui.components.HumidityCard
import com.example.weather_app.ui.components.InfoSection
import com.example.weather_app.ui.components.SummaryCard
import com.example.weather_app.ui.theme.Weather_AppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
  LazyColumn(
    modifier = modifier
      .fillMaxWidth()
      .padding(vertical = 10.dp, horizontal = 10.dp)
  ) {
    item { InfoSection() }
    item { Spacer(modifier = Modifier.height(15.dp)) }
    item { SummaryCard() }
    item { Spacer(modifier = Modifier.height(15.dp)) }
    item { HumidityCard() }
    item { Spacer(modifier = Modifier.height(15.dp)) }
    item { HumidAndWindCard() }
    item { Spacer(modifier = Modifier.height(15.dp)) }
    item { ForecastScreen() }
    item { Spacer(modifier = Modifier.height(15.dp)) }
    item { FiveDaysFocusCard() }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
  Weather_AppTheme {
    HomeScreen()
  }
}