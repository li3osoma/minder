package com.example.minder.model

data class Tracker(
    val title:String,
    val description:String,
    val days:Int,
    val daysList:List<Boolean> = List(days){false},
    val creationDate:String,
    val startDay:String,
    val finishDate:String,
    val doneNum:Int,
    val color:Long
)