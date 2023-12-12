package com.example.minder.model

data class Task(
    val title:String,
    val content:String,
    val done:Boolean,
    val creationDate:String,
    val deadlineDate:String?,
    val color:Long
)
