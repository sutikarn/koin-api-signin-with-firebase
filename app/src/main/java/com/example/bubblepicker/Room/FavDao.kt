package com.example.bubblepicker.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavDao {
    @Insert
    fun insertFav(favEntity: FavEntity)

    @Query("SELECT * FROM FAVORITESTATUS")
    fun getFav():List<FavEntity>

    @Query("delete from favoritestatus where favoritestatus.name = :favoritename")
    fun deletefav(favoritename:String)

    @Query("SELECT * FROM favoritestatus WHERE favoritestatus.name = :favoritestatus")
    fun getStudentByName(favoritestatus: String):List<FavEntity>

    @Query("select * from favoritestatus where favoritestatus.id = :id")
    fun getStudentById(id:String):List<FavEntity>

    @Query("select * from favoritestatus where favoritestatus.status =:status")
    fun getStudentByStatus(status:String):List<FavEntity>



}