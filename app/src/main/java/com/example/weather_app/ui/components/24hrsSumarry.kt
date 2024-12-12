package com.example.weather_app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalDensity
import kotlin.math.roundToInt
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.Weather_AppTheme

@Composable
fun ScrollToCurrentIndex(currentTimeIndex: Int, scrollState: ScrollState) {
  val scrollPosition = (currentTimeIndex * 100).dp
  val scrollPositionPx = with(LocalDensity.current) { scrollPosition.toPx() }
  LaunchedEffect(currentTimeIndex) {
    scrollState.scrollTo(scrollPositionPx.roundToInt())
  }
}

@Composable
fun WeatherForecastGraph24Hrs(
  temperatures: List<Int>,
  times: List<String>,
  icons: List<@Composable () -> Unit>,
  currentTimeIndex: Int,
  modifier: Modifier = Modifier
) {
  val maxTemp = temperatures.maxOrNull() ?: 0
  val minTemp = temperatures.minOrNull() ?: 0
  val tempRange = maxTemp - minTemp

  val scrollState = rememberScrollState()

  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 4.dp
    ),
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(),
    shape = MaterialTheme.shapes.medium,

  ) {
    Row(
      modifier = Modifier
          .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Icon(
        imageVector = Filled.AccessTime,
        contentDescription = "Sun Icon",
        tint = Color.White,
        modifier = Modifier.size(22.dp)
      )
      Text(
        text = "24h forecast",
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
      )
    }
    Box(
      modifier = Modifier
        .padding(16.dp)
        .horizontalScroll(scrollState)
    ) {
      Column(
        modifier = Modifier
          .width((temperatures.size * 100).dp)
      ) {
        // Graph Area
        Canvas(
          modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
        ) {
          val stepX = size.width / (temperatures.size - 1)
          val points = temperatures.mapIndexed { index, temp ->
            val x = index * stepX
            val y = size.height - (temp - minTemp) * size.height / tempRange
            x to y
          }

          // Draw temperature path
          val path = Path().apply {
            points.forEachIndexed { index, point ->
              if (index == 0) moveTo(point.first, point.second)
              else {
                val prev = points[index - 1]
                cubicTo(
                  (prev.first + point.first) / 2, prev.second,
                  (prev.first + point.first) / 2, point.second,
                  point.first, point.second
                )
              }
            }
          }
          drawPath(
            path = path,
            color = Color.Gray,
            style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
          )

          // Draw temperature points
          points.forEach { (x, y) ->
            drawCircle(Color.White, radius = 6.dp.toPx(), center = Offset(x, y))
          }
        }

        // Time Labels and Weather Icons
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          temperatures.forEachIndexed { index, temp ->
            Column(
              modifier = Modifier.width(100.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(
                text = "$temp°",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
              icons[index]()
              Text(
                text = times[index],
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
            }
          }
        }
      }
    }
    ScrollToCurrentIndex(currentTimeIndex, scrollState)
  }
}

@Composable
fun ForecastScreen() {
  WeatherForecastGraph24Hrs(
    temperatures = listOf(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12),
    times = (0..23).map { "$it:00" },
    icons = List(24) { hour ->
      if (hour < 6 || hour >= 18) {
        { NightIcon() }
      } else {
        { SunnyIcon() }
      }
    },
    currentTimeIndex = 12
  )
}

@Composable
fun SunnyIcon() {
  Text("☀️", fontSize = 24.sp)
}

@Composable
fun NightIcon() {
  Text("🌙", fontSize = 24.sp)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForecastScreenPreview() {
  Weather_AppTheme {
    ForecastScreen()
  }
}
