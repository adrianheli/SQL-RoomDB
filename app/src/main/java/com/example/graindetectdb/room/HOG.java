package com.example.graindetectdb.room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
    public class HOG
    {
        @PrimaryKey(autoGenerate = true)
        public int uid;

        @ColumnInfo(name = "win_SizeHeight")
        private String win_SizeHeight;

        @ColumnInfo(name = "win_SizeWidth")
        private String win_SizeWidth;

        @ColumnInfo(name = "blockSizeHeight")
        private String blockSizeHeight;

        @ColumnInfo(name = "blockSizeWidth")
        private String blockSizeWidth;

        @ColumnInfo(name = "blockStrideHeight")
        private String blockStrideHeight;

        @ColumnInfo(name = "blockStrideWidth")
        private String blockStrideWidth;

        @ColumnInfo(name = "cellSizeHeight")
        private String cellSizeHeight;

        @ColumnInfo(name = "cellSizeWidth")
        private String cellSizeWidth;

        @ColumnInfo(name = "nbins")
        private String nbins;

        public HOG(){}

        public String getWin_SizeHeight() {
            return win_SizeHeight;
        }

        public void setWin_SizeHeight(String win_SizeHeight) {
            this.win_SizeHeight = win_SizeHeight;
        }

        public String getWin_SizeWidth() {
            return win_SizeWidth;
        }

        public void setWin_SizeWidth(String win_SizeWidth) {
            this.win_SizeWidth = win_SizeWidth;
        }

        public String getBlockSizeHeight() {
            return blockSizeHeight;
        }

        public void setBlockSizeHeight(String blockSizeHeight) {
            this.blockSizeHeight = blockSizeHeight;
        }

        public String getBlockSizeWidth() {
            return blockSizeWidth;
        }

        public void setBlockSizeWidth(String blockSizeWidth) {
            this.blockSizeWidth = blockSizeWidth;
        }

        public String getBlockStrideHeight() {
            return blockStrideHeight;
        }

        public void setBlockStrideHeight(String blockStrideHeight) {
            this.blockStrideHeight = blockStrideHeight;
        }

        public String getBlockStrideWidth() {
            return blockStrideWidth;
        }

        public void setBlockStrideWidth(String blockStrideWidth) {
            this.blockStrideWidth = blockStrideWidth;
        }

        public String getCellSizeHeight() {
            return cellSizeHeight;
        }

        public void setCellSizeHeight(String cellSizeHeight) {
            this.cellSizeHeight = cellSizeHeight;
        }

        public String getCellSizeWidth() {
            return cellSizeWidth;
        }

        public void setCellSizeWidth(String cellSizeWidth) {
            this.cellSizeWidth = cellSizeWidth;
        }

        public String getNbins() {
            return nbins;
        }

        public void setNbins(String nbins) {
            this.nbins = nbins;
        }






    }


