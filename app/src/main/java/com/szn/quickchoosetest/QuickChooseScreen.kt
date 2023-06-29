package com.szn.quickchoosetest

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.withContext

@Composable
fun QuickChooseScreen () {

    var isClickFirst = remember {
        mutableStateOf(false)
    }

    var isClickSecond = remember {
        mutableStateOf(false)
    }

    var countTime by remember { mutableStateOf(0) }

    var count by remember { mutableStateOf(0) }


    val checkedFirst = remember { mutableStateOf(false) }

    val checkedSecond = remember { mutableStateOf(false) }

    var context = LocalContext.current
    val bookOne = listOf(
        "Chapter 1",
        "Chapter 2",
        "Chapter 3",
        "Chapter 4"
    )

    val bookTwo = listOf(
        "Chapter 1",
        "Chapter 2",
        "Chapter 3",
        "Chapter 4",
        "Chapter 5",

        )
    val checkedItems = remember { mutableStateListOf<Boolean>() }
    checkedItems.addAll(List(bookOne.size) { false })

    val checkedItemsTwo = remember { mutableStateListOf<Boolean>() }
    checkedItemsTwo.addAll(List(bookTwo.size) { false })


    countTime = count

    Surface(
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
                ) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /*navController.popBackStack()*/ }) {
                            Icon(
                                Icons.Default.ArrowBack, contentDescription = "back",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "FE",
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                    }
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Box(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(10.dp)
                        .background(Color(148, 184, 216))
                        .border(
                            1.dp,
                            color = Color(148, 184, 216),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .clickable {
                            isClickFirst.value = !isClickFirst.value
                        },
                    contentAlignment = Alignment.Center,

                    ) {
                    Text(
                        text = "Volume 1 ", color = Color.Black, fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


               if(isClickFirst.value) {


                   Column {
                       bookOne.forEachIndexed { index, item ->
                           Row(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .height(50.dp)
                                   .padding(10.dp),
                               horizontalArrangement = Arrangement.Start,
                               verticalAlignment = Alignment.CenterVertically
                           ) {
                               Checkbox(
                                   checked = checkedItems[index],
                                   onCheckedChange = { isChecked ->
                                       checkedItems[index] = isChecked
                                   },
                                   modifier = Modifier.padding(start = 8.dp)
                               )
                               Text(
                                   text = item,
                                   modifier = Modifier.padding(start = 16.dp),
                                   color = Color.Black
                               )
                           }
                       }

                       Button(
                           onClick = {
                               val selectedItems = bookOne.filterIndexed { index, _ ->
                                   checkedItems[index]
                               }
                               Toast.makeText(
                                   context,
                                   "Selected items: ${selectedItems.joinToString()}",
                                   Toast.LENGTH_SHORT
                               ).show()
                           },
                           modifier = Modifier.padding(top = 16.dp)
                       ) {
                           Text(text = "Get Selected Items")
                       }
                   }

               }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(10.dp)
                        .background(Color(148, 184, 216))
                        .border(
                            1.dp,
                            color = Color(148, 184, 216),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .clickable {
                            isClickSecond.value = !isClickSecond.value
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Volume 2 ", color = Color.Black, fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                if(isClickSecond.value) {


                    Column {
                        bookTwo.forEachIndexed { index, item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = checkedItemsTwo[index],
                                    onCheckedChange = { isChecked ->
                                        checkedItemsTwo[index] = isChecked
                                    },
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                                Text(
                                    text = item,
                                    modifier = Modifier.padding(start = 16.dp),
                                    color = Color.Black
                                )
                            }
                        }

                        Button(
                            onClick = {
                                val selectedItems = bookTwo.filterIndexed { index, _ ->
                                    checkedItemsTwo[index]
                                }
                                Toast.makeText(
                                    context,
                                    "Selected items: ${selectedItems.joinToString()}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text(text = "Get Selected Items")
                        }
                    }



                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Select Options",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))


                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(text = "Select Questions Count",
                        color = Color.Black,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )

                    Spacer(modifier = Modifier.width(30.dp))

                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                        horizontalAlignment = Alignment.End
                    ){
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(60.dp)
                                .padding(10.dp)
                                .border(
                                    1.dp,
                                    color = Color(148, 184, 216),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center

                        ) {

                            Row {
                                Icon(Icons.Default.Remove,
                                    contentDescription = "minus",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .alpha(if (count > 1) 1f else .4f)
                                        .clickable {
                                            if (count > 1) {
                                                count -= 5
                                            }
                                        }
                                        .size(20.dp)
                                )

                                Text(
                                    count.toString(),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .width(40.dp),
                                    color = Color.Black

                                )

                                Icon(Icons.Default.Add,
                                    contentDescription = "plus",
                                    tint = Color.Black
                                    ,
                                    modifier = Modifier
                                        .alpha(if (count < 80) 1f else .4f)
                                        .clickable {
                                            if (count < 80) {
                                                count += 5
                                            }
                                        }
                                        .size(20.dp)
                                )
                            }

                        }
                    }


                }

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(text = " Select Time ",
                        color = Color.Black,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )

                    Spacer(modifier = Modifier.width(106.dp))


                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                        horizontalAlignment = Alignment.End
                        ){
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(60.dp)
                                .padding(10.dp)
                                .border(
                                    1.dp,
                                    color = Color(148, 184, 216),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center

                        ) {

                            Row {

                                Icon(Icons.Default.Remove,
                                    contentDescription = "minus",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .alpha(if (countTime > 1) 1f else .4f)
                                        .clickable {
                                            if (countTime > 1) {
                                                countTime -= 1
                                            }
                                        }
                                        .size(20.dp)
                                )

                                Text(
                                    countTime.toString(),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .width(40.dp),
                                    color = Color.Black

                                )

                                Icon(Icons.Default.Add,
                                    contentDescription = "plus",
                                    tint = Color.Black
                                    ,
                                    modifier = Modifier
                                        .alpha(if (countTime < 80) 1f else .4f)
                                        .clickable {
                                            if (countTime < 80) {
                                                countTime += 1
                                            }
                                        }
                                        .size(20.dp)
                                )
                            }

                        }
                    }

                }



                var localContext = LocalContext.current

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(10.dp)
                        .background(Color(148, 184, 216))
                        .border(
                            1.dp,
                            color = Color(148, 184, 216),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .clickable {
                            Toast
                                .makeText(localContext, "Start Quizz", Toast.LENGTH_SHORT)
                                .show()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = " Start Quizz ", color = Color.Black, fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )


                }



            }


                }

            }


        }


//@Composable
//fun Counter(count : Int) {
//
//
//
//
//    Box(
//        modifier = Modifier
//            .width(150.dp)
//            .height(60.dp)
//            .padding(10.dp)
//            .border(
//                1.dp,
//                color = Color(148, 184, 216),
//                shape = RoundedCornerShape(20.dp)
//            ),
//        contentAlignment = Alignment.Center
//
//    ) {
//
//        Row {
//            Icon(Icons.Default.Remove,
//                contentDescription = "minus",
//                tint = Color.Black,
//                modifier = Modifier
//                    .alpha(if (count > 1) 1f else .4f)
//                    .clickable {
//                        if (count > 1) {
//                            count -= 5
//                        }
//                    }
//                    .size(20.dp)
//            )
//
//            Text(
//                count.toString(),
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .width(40.dp),
//                color = Color.Black
//
//            )
//
//            Icon(Icons.Default.Add,
//                contentDescription = "plus",
//                tint = Color.Black
//                ,
//                modifier = Modifier
//                    .alpha(if (count < 80) 1f else .4f)
//                    .clickable {
//                        if (count < 80) {
//                            count += 5
//                        }
//                    }
//                    .size(20.dp)
//            )
//        }
//
//    }
//
//
//
//}

@SuppressLint("RememberReturnType")
@Composable
fun MultipleCheckboxes() {
    var context = LocalContext.current
    val items = listOf(
        "Option 1",
        "Option 2",
        "Option 3",
        "Option 4"
    )
    val checkedItems = remember { mutableStateListOf<Boolean>() }
    checkedItems.addAll(List(items.size) { false })

    Column {
        items.forEachIndexed { index, item ->
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedItems[index],
                    onCheckedChange = { isChecked ->
                        checkedItems[index] = isChecked
                    },
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color.Black
                )
            }
        }

        Button(
            onClick = {
                val selectedItems = items.filterIndexed { index, _ ->
                    checkedItems[index]
                }
                Toast.makeText(
                    context,
                    "Selected items: ${selectedItems.joinToString()}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Get Selected Items")
        }
    }
}