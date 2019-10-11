package com.example.bubblepicker.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritestatus")
data class FavEntity(@PrimaryKey(autoGenerate = true) var id: Int? = null,
                     @ColumnInfo(name = "name") var name:String? =null,
                     @ColumnInfo(name = "status") var status:String? =null)