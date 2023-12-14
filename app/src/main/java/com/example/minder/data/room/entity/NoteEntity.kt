package com.example.minder.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.minder.utils.Constants.NOTE
import com.example.minder.utils.Constants.NOTE_CATEGORY
import com.example.minder.utils.Constants.NOTE_CONTENT
import com.example.minder.utils.Constants.NOTE_CREATION_DATE
import com.example.minder.utils.Constants.NOTE_ID
import com.example.minder.utils.Constants.NOTE_TITLE

@Entity(tableName = NOTE)
data class NoteEntity(
    @ColumnInfo(name = NOTE_ID)
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name = NOTE_TITLE)
    val title:String,
    @ColumnInfo(name = NOTE_CONTENT)
    val content:String,
    @ColumnInfo(name = NOTE_CREATION_DATE)
    val creationDate:Long,
    @ColumnInfo(name = NOTE_CATEGORY)
    val categoryId:Long
)