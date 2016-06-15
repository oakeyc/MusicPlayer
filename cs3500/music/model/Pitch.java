package cs3500.music.model;

/**  represents all the different pitchs a note is
 * Created by Courtney on 6/6/2016.
 */
public enum Pitch {
    C(1), Cs(2), D(3), Ds(4), E(5), F(6), Fs(7), G(8), Gs(9), A(10), As(11), B(12);
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
