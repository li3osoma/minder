package com.example.minder.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.minder.utils.Constants.TASK
import com.example.minder.utils.Constants.TASK_CATEGORY
import com.example.minder.utils.Constants.TASK_CREATION_DATE
import com.example.minder.utils.Constants.TASK_DEADLINE_DATE
import com.example.minder.utils.Constants.TASK_DESCRIPTION
import com.example.minder.utils.Constants.TASK_ID
import com.example.minder.utils.Constants.TASK_TITLE

@Entity(tableName = TASK)
data class TaskEntity(
    @ColumnInfo(name = TASK_ID)
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name = TASK_TITLE)
    val title:String,
    @ColumnInfo(name = TASK_DESCRIPTION)
    val description:String,
    @ColumnInfo(name = TASK_CREATION_DATE)
    val creationDate:Long,
    @ColumnInfo(name = TASK_DEADLINE_DATE)
    val deadlineDate:Long,
    @ColumnInfo(name = TASK_CATEGORY)
    val categoryId:Long
)