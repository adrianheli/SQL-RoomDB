package com.example.graindetectdb.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface HOGDao {
    /*@Insert
    void insertOnlySingleMovie (Movies movies);
    @Insert
    void insertMultipleMovies (List<Movies> moviesList);
    @Query (“SELECT * FROM Movies WHERE movieId = :movieId“)
    Movies fetchOneMoviesbyMovieId (int movieId);
    @Update
    void updateMovie (Movies movies);
    @Delete
    void deleteMovie (Movies movies);*/

    @Query("SELECT * FROM HOG")
    List<com.example.graindetectdb.room.HOG> getAll();

    @Query("SELECT * FROM HOG WHERE uid IN (:userIds)")
    List<com.example.graindetectdb.room.HOG> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM HOG WHERE win_SizeHeight LIKE :first AND " + "win_SizeHeight LIKE :second AND" +
            " win_SizeWidth LIKE :third AND" + " blockSizeHeight LIKE :third AND" + " blockSizeWidth" +
            " LIKE :fourth AND" + " blockStrideHeight LIKE :fifth AND" + " blockStrideWidth LIKE :sixth AND"
            + " cellSizeHeight LIKE :seventh AND" + " cellSizeWidth LIKE :eigth AND" +
            " nbins LIKE :last LIMIT 1")
    List<com.example.graindetectdb.room.HOG> findByName(String first, String second, String third, String fourth, String fifth,
                                                        String sixth, String seventh, String eigth, String last);

    @Insert
    void insertMultipleHog(List<com.example.graindetectdb.room.HOG> users);

    @Insert
    void insertOneHOG(com.example.graindetectdb.room.HOG hog);

    @Delete
    void delete(com.example.graindetectdb.room.HOG hog);

    @Update
    void update(com.example.graindetectdb.room.HOG hog);
}

