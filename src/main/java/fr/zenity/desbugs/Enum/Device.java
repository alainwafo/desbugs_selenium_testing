package fr.zenity.desbugs.Enum;

public enum Device {

    DESKTOP(-1,-1);

    private final int width;
    private final int height;

    Device( int width, int height ){
        this.width  = width;
        this.height = height;
    }

}
