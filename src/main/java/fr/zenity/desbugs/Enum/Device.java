package fr.zenity.desbugs.Enum;

public enum Device {

    DESKTOP(-1,-1, true),
    DESKTOP_TABLET(1366, 768, false),
    GALAXY_S3(360,640,false),
    GALAXY_S5( 360, 640 , false),
    IPHONE(414,736, false);

    private final int width;
    private final int height;
    private final boolean isRealDevice;


    Device( int width, int height, boolean isRealDevice ){
        this.width          = width;
        this.height         = height;
        this.isRealDevice   = isRealDevice;
    }

    public int getWidth( ){
        return this.width;
    }

    public int getHeight( ){
        return this.height;
    }

    public boolean isRealDevice(){
        return this.isRealDevice;
    }

}
