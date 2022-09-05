package com.hynekbraun.chesstimer.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.W300
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.unit.sp
import com.hynekbraun.chesstimer.R

private val QuickSand = FontFamily(
    Font(R.font.quicksand_light, W300),
    Font(R.font.quicksand_regular, W400),
    Font(R.font.quicksand_medium, W500),
    Font(R.font.quicksand_bold, W600),
)

val QuickSandTypography = Typography(
    h1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Light,
        fontSize = 96.sp,
    ),
    h2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Light,
        fontSize = 60.sp
    ),
    h3 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 48.sp
    ),
    h4 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Medium,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Medium,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Medium,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = QuickSand,
        fontWeight = Normal,
        fontSize = 10.sp
    ),
)