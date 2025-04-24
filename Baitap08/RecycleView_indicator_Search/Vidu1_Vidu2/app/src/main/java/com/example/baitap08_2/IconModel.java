package com.example.baitap08_2;

import java.io.Serializable;

public class IconModel implements Serializable {
    private final int imgId;
    private final String desc;

    public IconModel(int imgId, String desc) {
        this.imgId = imgId;
        this.desc = desc;
    }

    public int getImgId() {
        return imgId;
    }

    public String getDesc() {
        return desc;
    }
}