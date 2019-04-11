package com.example.graindetectdb.legacy;


public class DataObject {
    private double win_SizeHeight;
    private double win_SizeWidth;
    private double block_SizeHeight;
    private double block_SizeWidth;
    private double block_StrideHeight;
    private double block_StrideWidth;
    private double cell_SizeHeight;
    private double cell_SizeWidth;
    private int nbins;
    private int id;

    private double hue_lower_B;
    private double hue_higher_B;
    private double saturation_lower_B;
    private double saturation_higher_B;
    private double value_lower_B;
    private double value_higher_B;





    public DataObject(int id, double win_SizeHeight, double win_SizeWidth, double block_SizeHeight, double block_SizeWidth
            , double block_StrideHeight, double block_StrideWidth, double cell_SizeHeight, double cell_SizeWidth,
                      int nbins) {
        this.id = id;
        this.win_SizeHeight = win_SizeHeight;
        this.win_SizeWidth = win_SizeWidth;
        this.block_SizeHeight= win_SizeHeight;
        this.block_SizeWidth= block_SizeWidth;
        this.block_StrideHeight = block_StrideHeight;
        this.block_StrideWidth = block_StrideWidth;
        this.cell_SizeHeight = cell_SizeHeight;
        this.cell_SizeWidth = cell_SizeWidth;
        this.nbins = nbins;

    }

    public DataObject(){}

    public DataObject(int id, double hue_lower_B, double hue_higher_B, double saturation_lower_B, double saturation_higher_B,
                      double value_lower_B, double value_higher_B){
        this.id = id;
        this.hue_lower_B = hue_lower_B;
        this.hue_higher_B = hue_higher_B;
        this.saturation_lower_B = saturation_lower_B;
        this.saturation_higher_B = saturation_higher_B;
        this.value_lower_B = value_lower_B;
        this.value_higher_B = value_higher_B;

    }

    public double getHue_lower_B() {
        return hue_lower_B;
    }

    public void setHue_lower_B(double hue_lower_B) {
        this.hue_lower_B = hue_lower_B;
    }

    public double getHue_higher_B() {
        return hue_higher_B;
    }

    public void setHue_higher_B(double hue_higher_B) {
        this.hue_higher_B = hue_higher_B;
    }

    public double getSaturation_lower_B() {
        return saturation_lower_B;
    }

    public void setSaturation_lower_B(double saturation_lower_B) {
        this.saturation_lower_B = saturation_lower_B;
    }

    public double getSaturation_higher_B() {
        return saturation_higher_B;
    }

    public void setSaturation_higher_B(double saturation_higher_B) {
        this.saturation_higher_B = saturation_higher_B;
    }

    public double getValue_lower_B() {
        return value_lower_B;
    }

    public void setValue_lower_B(double value_lower_B) {
        this.value_lower_B = value_lower_B;
    }

    public double getValue_higher_B() {
        return value_higher_B;
    }

    public void setValue_higher_B(double value_higher_B) {
        this.value_higher_B = value_higher_B;
    }

    public double getWin_SizeHeight(){return win_SizeHeight;}

    public double getWin_SizeWidth(){return win_SizeWidth;}

    public double getBlock_SizeHeight(){return block_SizeHeight;}

    public double getBlock_SizeWidth(){return block_SizeWidth;}

    public double getBlock_StrideHeight(){return block_StrideHeight;}

    public double getBlock_StrideWidth(){return block_StrideWidth;}

    public double getCell_SizeHeight(){return cell_SizeHeight;}

    public double getCell_SizeWidth(){return cell_SizeWidth;}

    public int getNbins(){return nbins;}

    public int getId() {return id;}

    public void setWin_SizeHeight(double win_SizeHeight){
        this.win_SizeHeight = win_SizeHeight;
    }

    public void setWin_SizeWidth(double win_SizeWidth) {
        this.win_SizeWidth = win_SizeWidth;
    }

    public void setBlock_SizeHeight(double block_SizeHeight) {
        this.block_SizeHeight = block_SizeHeight;
    }

    public void setBlock_SizeWidth(double block_SizeWidth) {
        this.block_SizeWidth = block_SizeWidth;
    }

    public void setBlock_StrideHeight(double block_StrideHeight) {
        this.block_StrideHeight = block_StrideHeight;
    }

    public void setBlock_StrideWidth(double block_StrideWidth) {
        this.block_StrideWidth = block_StrideWidth;
    }

    public void setCell_SizeHeight(double cell_SizeHeight) {
        this.cell_SizeHeight = cell_SizeHeight;
    }

    public void setCell_SizeWidth(double cell_SizeWidth) {
        this.cell_SizeWidth = cell_SizeWidth;
    }

    public void setNbins(int nbins) {
        this.nbins = nbins;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void get_All_Info_HSV(){
      System.out.print(getHue_lower_B()+getHue_higher_B() + getSaturation_lower_B() + getSaturation_higher_B() + getValue_lower_B()
              + getValue_higher_B()) ;
    }

    @Override
    public String toString(){
        return win_SizeHeight + " - " + win_SizeWidth+ " - " + block_SizeHeight+ " - "+
                block_SizeWidth+ " - " +block_StrideHeight+ " - " +block_StrideWidth+ " - " +
                cell_SizeHeight+ " - " +cell_SizeWidth+ " - " +nbins;
    }


}




