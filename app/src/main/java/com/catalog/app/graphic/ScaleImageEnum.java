package com.catalog.app.graphic;

/**
 * Enum that represents how much is needed scale an image.
 * The reference image is: R.mipmap.ic_launcher
 *
 * i.e.: ScaleImageEnum.TWO means 2 times R.mipmap.ic_launcher
 */
public enum ScaleImageEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7);

    private final int scaleType;

    private ScaleImageEnum(int scaleType) {
        this.scaleType = scaleType;
    }

    public boolean equals(int otherUserType) {
        return scaleType == otherUserType;
    }

    public String toString() {
        return String.valueOf(scaleType);
    }

    public static int getScaleNumber(ScaleImageEnum scaleImageEnum){
        int scale = 1;
        if(scaleImageEnum == ScaleImageEnum.ONE){
            scale = 1;
        }else if(scaleImageEnum == ScaleImageEnum.TWO){
            scale = 2;
        }else if(scaleImageEnum == ScaleImageEnum.THREE){
            scale = 3;
        }else if(scaleImageEnum == ScaleImageEnum.FOUR){
            scale = 4;
        }else if(scaleImageEnum == ScaleImageEnum.FIVE){
            scale = 5;
        }else if(scaleImageEnum == ScaleImageEnum.SIX){
            scale = 6;
        }else if(scaleImageEnum == ScaleImageEnum.SEVEN){
            scale = 7;
        }
        return scale;
    }
}

