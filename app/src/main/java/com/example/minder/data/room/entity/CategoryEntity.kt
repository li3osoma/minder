package com.example.minder.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.minder.utils.Constants.CATEGORY
import com.example.minder.utils.Constants.CATEGORY_COLOR
import com.example.minder.utils.Constants.CATEGORY_ID
import com.example.minder.utils.Constants.CATEGORY_NAME

@Entity(tableName = CATEGORY)
data class CategoryEntity(
    @ColumnInfo(name = CATEGORY_ID)
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name = CATEGORY_NAME)
    val name:String,
    @ColumnInfo(name = CATEGORY_COLOR)
    val color:Long
)