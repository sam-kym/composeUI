package com.example.myapplication.data

import androidx.compose.ui.graphics.Brush

data class Cards (
   val cardsType:String,
   val cardNumber:String,
   val cardName:String,
   val balance:Double,
   val color:Brush,
)