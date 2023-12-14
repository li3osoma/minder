package com.example.minder.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.minder.utils.Constants
import com.example.minder.utils.Constants.TRACKER
import com.example.minder.utils.Constants.TRACKER_CATEGORY
import com.example.minder.utils.Constants.TRACKER_CREATION_DATE
import com.example.minder.utils.Constants.TRACKER_DAY_NUM
import com.example.minder.utils.Constants.TRACKER_DESCRIPTION
import com.example.minder.utils.Constants.TRACKER_DONE_NUM
import com.example.minder.utils.Constants.TRACKER_FINISH_DATE
import com.example.minder.utils.Constants.TRACKER_ID
import com.example.minder.utils.Constants.TRACKER_LIST
import com.example.minder.utils.Constants.TRACKER_START_DATE
import com.example.minder.utils.Constants.TRACKER_TITLE

@Entity(tableName = TRACKER)
data class TrackerEntity(
    @ColumnInfo(name = TRACKER_ID)
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name = TRACKER_TITLE)
    val title:String,
    @ColumnInfo(name = TRACKER_DESCRIPTION)
    val description:String,
    @ColumnInfo(name = TRACKER_CREATION_DATE)
    val creationDate:Long,
    @ColumnInfo(name = TRACKER_START_DATE)
    val startDate:Long,
    @ColumnInfo(name = TRACKER_FINISH_DATE)
    val finishDate:Long,
    @ColumnInfo(name = TRACKER_DAY_NUM)
    val dayNum:Long,
    @ColumnInfo(name = TRACKER_DONE_NUM)
    val doneNum:Long,
    @ColumnInfo(name = TRACKER_LIST)
    val list:String,
    @ColumnInfo(name = TRACKER_CATEGORY)
    val categoryId:Long
)