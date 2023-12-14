package com.example.minder.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateTimeUtils {
    companion object {

        @SuppressLint("SimpleDateFormat")
        fun dateToLong(date: Date):Long{
            val format= SimpleDateFormat("MMM d, yyyy")
            return format.parse(dateToString(date))!!.time
        }

        fun longToDate(l:Long): Date {
            return Date(l)
        }

        fun dateToString(date: Date): String {
            val formatter = SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
            return formatter.format(date)
        }


        @SuppressLint("SimpleDateFormat")
        fun stringToDate(s:String): Date {
            val format= SimpleDateFormat("MMM d, yyyy")
            return format.parse(s)!!
        }


        @SuppressLint("SimpleDateFormat")
        fun stringToTimeLong(s:String):Long{
            val format= SimpleDateFormat("HH:mm")
            return format.parse(s)!!.time
        }

        fun timeLongToString(l:Long):String{
            val formatter = SimpleDateFormat("HH:mm", Locale.ENGLISH);
            return formatter.format(l)
        }


        fun getCurrentDateString():String{
            return dateToString(Date())
        }

        fun getCurrentTimeString():String{
            return timeLongToString(Date().time)
        }

    }
}