package cs3500.music.model;

/**
 * Created by Courtney on 6/6/2016.
 */
public enum Accidental {
    sharp(1), flat(-1), natural(0);

    private int value;

    /**
     * initializes
     * @param value     value to init
     */
    Accidental(int value) {
        this.value = value;
    }

    /**
     * gets the value
     * @return    the value
     */
    public int getValue(){
        return value;
    }
}
