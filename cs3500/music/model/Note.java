package cs3500.music.model;

import java.awt.*;

/**
 * represents a note Created by Courtney on 6/7/2016.
 */
public class Note implements Comparable<Note> {
    private Pitch pitch; // its pitch
    private Accidental acc; // its accidental
    private int octave; // INVARIENT: must be non-negative
    private int start; // start beat
    private int duration; // how long in beats

    /**
     * constructor
     *
     * @param p        the pitch
     * @param a        the accidental
     * @param octave   which octave it is (must be non-negative)
     * @param duration the duration (must be > 0)
     */
    public Note(Pitch p, Accidental a, int octave, int duration, int start) {
        this.duration = duration;
        this.start = start;
        pitch = p;
        acc = a;
        if (octave < 0)
            throw new IllegalArgumentException("No Negative octaves");
        this.octave = octave;
    }


    /**
     * sets the pitch of this note
     *
     * @param p a pitch to set to this
     */
    public void setPitch(Pitch p) {
        this.pitch = p;
    }

    /**
     * returns an string for this note
     *
     * @return string representation
     */
    public String getImage(int beat) {
        if (beat == start)
            return "X";
        else
            return "|";
    }

    /**
     * the value of this note
     * @return     the value of this note
     */
    public int getValue() {
        return (octave * 12) + (pitch.getValue() + acc.getValue());
    }

    /**
     * returns a copy
     *
     * @return MusicType  a copy
     */
    public Note copy() {
        return new Note(pitch, acc, octave, duration, start);
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
     * changes the value of start
     * @param start     the new start value
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * OVERRIDING COMPARETO SO THAT NOTES
     * MAY BE COMPARABLE TO EACH OTHER
     *
     * ORDERS THEM IN STANDARD ORDER, FROM LOWEST OCTAVE
     * AND LOWEST PITCH TO HIGHEST OCTAVE AND HIGHEST PITCH
     * @param note
     * @return int
     */
    @Override
    public int compareTo(Note note) {
        return this.getValue() - note.getValue();
    }
}
//commit