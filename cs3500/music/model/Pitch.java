package cs3500.music.model;

/**  represents all the different pitchs a note is
 * Created by Courtney on 6/6/2016.
 */
public enum Pitch {
    C(1), D(3), E(5), F(6), G(8), A(10), B(12);
    // value based on frequency
    private int value;

    /**
     * initializes
     * @param value     value of pitch
     */
    Pitch(int value) {
        this.value = value;
    }

    /**
     * gets value
     * @return       the value
     */
    int getValue() {
        return value;
    }
}
