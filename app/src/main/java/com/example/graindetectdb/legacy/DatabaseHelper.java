package com.example.graindetectdb.legacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //HOG
    private static final String DATABASE_NAME = "Grain_DB";
    private static final String TABLE_NAME = "HOG";
    private static final String ID = "id";
    private static final String WIN_SIZE_HEIGHT = "winSizeHeight";
    private static final String WIN_SIZE_WIDTH = "winSizeWidth";
    private static final String BLOCK_SIZE_HEIGHT = "blockSizeHeight";
    private static final String BLOCK_SIZE_WIDTH = "blockSizeWidth";
    private static final String BLOCK_STRIDE_HEIGHT = "blockStrideHeight";
    private static final String BLOCK_STRIDE_WIDTH = "blockStrideWidth";
    private static final String CELL_SIZE_HEIGHT = "cellSizeHeight";
    private static final String CELL_SIZE_WIDTH = "cellSizeWidth";
    private static final String N_BINS = "nbins";

    //HSV
    private static final String TABLE_NAME_2 = "HSV";
    private static final String HUE_LOWER_B = "hue_lower_B";
    private static final String HUE_HIGHER_B = "hue_higher_B";
    private static final String SATURATION_LOWER_B = "saturation_lower_B";
    private static final String SATURATION_HIGHER_B = "saturation_higher_B";
    private static final String VALUE_LOWER_B = "value_lower_B";
    private static final String VALUE_HIGHER_B = "value_higher_B";

    //RGB
    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";

    private static final String[] COLUMNS = {ID, WIN_SIZE_HEIGHT, WIN_SIZE_WIDTH,
            BLOCK_SIZE_HEIGHT, BLOCK_SIZE_WIDTH, BLOCK_STRIDE_HEIGHT, BLOCK_STRIDE_WIDTH,
            CELL_SIZE_HEIGHT, CELL_SIZE_WIDTH, N_BINS};

    private static final String[] COLUMNS2 = {ID, HUE_LOWER_B, HUE_HIGHER_B, SATURATION_LOWER_B, SATURATION_HIGHER_B,
            VALUE_LOWER_B, VALUE_HIGHER_B};


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WIN_SIZE_HEIGHT + " TEXT, " + WIN_SIZE_WIDTH + " TEXT, " + BLOCK_SIZE_HEIGHT + " TEXT, " + BLOCK_SIZE_WIDTH
                + " TEXT, " + BLOCK_STRIDE_HEIGHT + " TEXT, " + BLOCK_STRIDE_WIDTH + " TEXT, " + CELL_SIZE_HEIGHT + " TEXT, "
                + CELL_SIZE_WIDTH + " TEXT, " + N_BINS + " Integer)";

        String CREATION_TABLE_2 = "CREATE TABLE " + TABLE_NAME_2 + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HUE_LOWER_B + " TEXT, " + HUE_HIGHER_B + " TEXT, " + SATURATION_LOWER_B + " TEXT, " + SATURATION_HIGHER_B
                + " TEXT, " + VALUE_LOWER_B + " TEXT, " + VALUE_HIGHER_B + " TEXT)";

        db.execSQL(CREATION_TABLE);
        db.execSQL(CREATION_TABLE_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Input Data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        this.onCreate(db);
    }

    public void deleteData(DataObject dataObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(dataObj.getId())});
        db.delete(TABLE_NAME_2, "id = ?", new String[]{String.valueOf(dataObj.getId())});
        db.close();
    }

    public DataObject getDataObjectHOG(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, COLUMNS, "id = ?", new String[]{
                String.valueOf(id)}, null, null, null, null);

        if (cursor != null) cursor.moveToFirst();

        DataObject dataObj = new DataObject();
        setterMethodsHOG(dataObj, cursor);
        return dataObj;
    }

    public DataObject getDataObjectHSV(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_NAME_2, COLUMNS2, "id = ?", new String[]{
                String.valueOf(id)}, null, null, null, null);
        if (cursor1 != null) cursor1.moveToFirst();
        DataObject dataObj = new DataObject();
        setterMethodsHOG(dataObj, cursor1);
        return dataObj;

    }

    private void setterMethodsHSV(DataObject dataObj, Cursor cursor1) {
        dataObj.setId(cursor1.getInt(0));
        dataObj.setHue_lower_B(cursor1.getDouble(1));
        dataObj.setHue_higher_B(cursor1.getDouble(2));
        dataObj.setSaturation_lower_B(cursor1.getDouble(3));
        dataObj.setSaturation_higher_B(cursor1.getDouble(4));
        dataObj.setValue_lower_B(cursor1.getDouble(5));
        dataObj.setValue_higher_B(cursor1.getDouble(6));

    }

    public void setterMethodsHOG(DataObject dataObj, Cursor cursor) {
        dataObj.setId(cursor.getInt(0));
        dataObj.setWin_SizeHeight(cursor.getDouble(1));
        dataObj.setWin_SizeWidth(cursor.getDouble(2));
        dataObj.setBlock_SizeHeight(cursor.getDouble(3));
        dataObj.setBlock_SizeWidth(cursor.getDouble(4));
        dataObj.setBlock_StrideHeight(cursor.getDouble(5));
        dataObj.setBlock_StrideWidth(cursor.getDouble(6));
        dataObj.setCell_SizeHeight(cursor.getDouble(7));
        dataObj.setCell_SizeWidth(cursor.getDouble(8));
        dataObj.setNbins(cursor.getInt(9));
    }

    public List<DataObject> allDataHOG() {
        List<DataObject> data = new LinkedList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        DataObject dataObj = null;

        while(cursor.moveToNext()){
            dataObj = new DataObject();
            setterMethodsHOG(dataObj, cursor);
            data.add(dataObj);
        }

        return data;
    }

    public List<DataObject> allDataHSV() {
        List<DataObject> data = new LinkedList<>();
        String query = "SELECT * FROM " + TABLE_NAME_2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        DataObject dataObj;
        while(cursor.moveToNext()) {
             dataObj = new DataObject();
             setterMethodsHSV(dataObj, cursor);
             data.add(dataObj);
        }
        return data;
    }

    public void addDataObjectHOG(DataObject dataObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        putHOG(db, values, dataObj);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void addDataObjectHSV(DataObject dataObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        putHSV(db, values, dataObj);
        db.insert(TABLE_NAME_2, null, values);
        db.close();
    }

    public void putHOG(SQLiteDatabase db, ContentValues values, DataObject dataObj) {
        values.put(WIN_SIZE_HEIGHT, dataObj.getWin_SizeHeight());
        values.put(WIN_SIZE_WIDTH, dataObj.getWin_SizeWidth());
        values.put(BLOCK_SIZE_HEIGHT, dataObj.getBlock_SizeHeight());
        values.put(BLOCK_SIZE_WIDTH, dataObj.getBlock_SizeWidth());
        values.put(BLOCK_STRIDE_HEIGHT, dataObj.getBlock_StrideHeight());
        values.put(BLOCK_STRIDE_WIDTH, dataObj.getBlock_StrideWidth());
        values.put(CELL_SIZE_HEIGHT, dataObj.getCell_SizeHeight());
        values.put(CELL_SIZE_WIDTH, dataObj.getCell_SizeWidth());
        values.put(N_BINS, dataObj.getNbins());
    }

    public void putHSV(SQLiteDatabase db, ContentValues values, DataObject dataObj) {
        values.put(HUE_LOWER_B, dataObj.getHue_lower_B());
        values.put(HUE_HIGHER_B, dataObj.getHue_higher_B());
        values.put(SATURATION_LOWER_B, dataObj.getSaturation_lower_B());
        values.put(SATURATION_HIGHER_B, dataObj.getSaturation_higher_B());
        values.put(VALUE_LOWER_B, dataObj.getValue_lower_B());
        values.put(VALUE_HIGHER_B, dataObj.getValue_higher_B());
    }

    public int updateDataObject(DataObject dataObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        putHOG(db, values, dataObj);
        int i = db.update(TABLE_NAME, values, "id = ?", new String[]{
                String.valueOf(dataObj.getId())
        });

        db.close();

        return i;
    }

    public int updateDataObjectHSV(DataObject dataObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        putHSV(db, values, dataObj);
        int j = db.update(TABLE_NAME_2, values, "id=?", new String[]{
            String.valueOf(dataObj.getId())});

        db.close();

        return j;
    }
}