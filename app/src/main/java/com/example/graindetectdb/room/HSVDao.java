package com.example.graindetectdb.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface HSVDao {

    @Query("SELECT * FROM HSV")
    List<HSV> getAll();

    @Query("SELECT * FROM HSV WHERE uid IN (:userIds)")
    List<HSV> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM HSV WHERE hue_lower_B LIKE :first AND " + "hue_higher_B LIKE :second AND " +
            "saturation_lower_B LIKE :third AND" + " saturation_higher_B LIKE :fourth AND" + " value_lower_B" +
            " LIKE :fifth AND" + " value_higher_B LIKE :last LIMIT 1")
    List<HSV> findByParameters(String first, String second, String third, String fourth, String fifth
            , String last);

    @Insert
    void insertMultipleHSV(List<HSV> hsv_List);

    @Insert
    void insertOnlyOne(HSV hsv);

    @Delete
    void delete(HSV hsv);

    @Update
    void updateHSV(HSV hsv);
}
