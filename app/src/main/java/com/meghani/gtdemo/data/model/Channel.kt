package com.meghani.gtdemo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class Channel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val icon_url: String,
    val name: String,
    val package_name_android: String,
    val url: String
)