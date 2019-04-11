package com.example.graindetectdb.room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HSV {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @ColumnInfo(name = "hue_lower_B")
    private String hue_lower_B;

    @ColumnInfo(name = "hue_higher_B")
    private String hue_higher_B;

    @ColumnInfo(name = "saturation_lower_B")
    private String saturation_lower_B;

    @ColumnInfo(name = "saturation_higher_B")
    private String saturation_higher_B;

    @ColumnInfo(name = "value_lower_B")
    private String value_lower_B;

    @ColumnInfo(name = "value_higher_B")
    private String value_higher_B;

    public HSV(){}


    public String getHue_lower_B() {
        return hue_lower_B;
    }

    public void setHue_lower_B(String hue_lower_B) {
        this.hue_lower_B = hue_lower_B;
    }

    public String getHue_higher_B() {
        return hue_higher_B;
    }

    public void setHue_higher_B(String hue_higher_B) {
        this.hue_higher_B = hue_higher_B;
    }

    public String getSaturation_lower_B() {
        return saturation_lower_B;
    }

    public void setSaturation_lower_B(String saturation_lower_B) {
        this.saturation_lower_B = saturation_lower_B;
    }

    public String getSaturation_higher_B() {
        return saturation_higher_B;
    }

    public void setSaturation_higher_B(String saturation_higher_B) {
        this.saturation_higher_B = saturation_higher_B;
    }

    public String getValue_lower_B() {
        return value_lower_B;
    }

    public void setValue_lower_B(String value_lower_B) {
        this.value_lower_B = value_lower_B;
    }

    public String getValue_higher_B() {
        return value_higher_B;
    }

    public void setValue_higher_B(String value_higher_B) {
        this.value_higher_B = value_higher_B;
    }




}

