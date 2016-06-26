package cs3500.music.model;

/**  represents all the different pitchs a note is
 * Created by Courtney on 6/6/2016.
 */
public enum Pitch {
    C(0), Cs(1), D(2), Ds(3), E(4), F(5), Fs(6), G(7), Gs(8), A(9), As(10), B(11);
    // value based on frequency
    public int value;

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
    public int getValue() {
        return value;
    }

    /**
     * the to string
     * @return   the string representation
     */
    public String toString() {
        switch(this.value) {
            case 0:
                return "C";
            case 1:
                return "C#";
            case 2:
                return "D";
            case 3:
                return "D#";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "F#";
            case 7:
                return "G";
            case 8:
                return "G#";
            case 9:
                return "A";
            case 10:
                return "A#";
            case 11:
                return "B";
            default:
                return "";
        }
    }
}
