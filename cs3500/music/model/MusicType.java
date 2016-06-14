package cs3500.music.model;

import java.awt.*;

/** represents anything that can be on music
 * Created by Courtney on 6/7/2016.
 */
public abstract class MusicType implements Comparable<MusicType> {
    // invariant: duration is greater than 0
    protected int duration;
    protected int start; // start beat

    /**
     * constructor, inializes data
     * throws illegalArguementException for invalid durations
     * @param duration       the duration for this class
     */
    public MusicType(int duration, int start) {
        checkDur(duration, start);
        this.duration = duration;
        this.start = start;
    }

    /**
     * sets the duration for a value
     * throws illegal argugment exceptions for invalid durations
     * @param dur        the duration to set
     */
    public void setDuration(int dur) {
        checkDur(dur, start);
        this.duration = dur;
    }

    /**
     * checks if a duration is valid
     * @param dur          the duration to check
     */
    private void checkDur(int dur, int start) {
        if (dur <= 0)
            throw new IllegalArgumentException("Duration must be positive");
        if (start < 0)
            throw new IllegalArgumentException("Start must be positive");
    }

    /**
     * gets the duration of this object
     * @return     value of the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * gets start beat
     * @return     value of start beat
     */
    public int getStart() {
        return start;
    }

    /**
     * the string representation of this object
     * @return       the string to represent this object
     */
    public abstract String getImage(int beat);

    /**
     * the value of this note
     * @return     the value of this note
     */
    public int getValue() {
        return 0;
    }

    /**
     * changes the value of start
     * @param start     the new start value
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * returns a copy
     * @return MusicType  a copy
     */
    public abstract MusicType copy();

    @Override
    public int compareTo(MusicType musicType) {
        return
    }
}
