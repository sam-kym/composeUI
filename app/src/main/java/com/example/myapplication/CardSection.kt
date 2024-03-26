package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.Cards
import com.example.myapplication.ui.theme.BlueEnd
import com.example.myapplication.ui.theme.BlueStart
import com.example.myapplication.ui.theme.GreenEnd
import com.example.myapplication.ui.theme.GreenStart
import com.example.myapplication.ui.theme.OrangeEnd
import com.example.myapplication.ui.theme.OrangeStart
import com.example.myapplication.ui.theme.PurpleEnd
import com.example.myapplication.ui.theme.PurpleStart

val cardItems = listOf(
    Cards(
        cardsType = "VISA",
        cardNumber = "3765 2248 8931 9120",
        cardName = "Business",
        balance = 34.75,
        color = getGradient(PurpleStart, PurpleEnd)
    ),Cards(
        cardsType = "MASTER CARD",
        cardNumber = "8749 7361 9023 7166",
        cardName = "Savings",
        balance = 4091.75,
        color = getGradient(BlueStart, BlueEnd)
    ),Cards(
        cardsType = "VISA",
        cardNumber = "3965 7048 8924 9102",
        cardName = "School",
        balance = 6.75,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Cards(
        cardsType = "MASTER CARD",
        cardNumber = "6539 4870 2489 1900",
        cardName = "Trips",
        balance = 8.30,
        color = getGradient(GreenStart, GreenEnd)
    ),
)
fun getGradient(
   startColor:Color,
   endColor:Color
):Brush{
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        )
    )
}
@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cardItems.size){index->
            CardItem(index)
        }
    }
}
@Composable
fun  CardItem(
   index:Int
){
val card = cardItems[index]
var lastItemPaddingEnd =0.dp
  if (index == cardItems.size -1){
      lastItemPaddingEnd =16.dp
  }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardsType== "MASTER CARD"){
         image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(170.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = card.cardName
            , modifier =Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
                        Text(text = card.cardName, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold )
            Text(text = "$ ${card.balance}", color = Color.White, fontSize = 23.sp, fontWeight = FontWeight.Bold )
            Text(text = card.cardNumber, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold )

        }
    }
}