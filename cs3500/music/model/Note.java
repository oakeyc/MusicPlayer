package cs3500.music.model;

import java.awt.*;

/**
 * represents a note Created by Courtney on 6/7/2016.
 */
public class Note extends MusicType {
    private Pitch pitch; // its pitch
    private Accidental acc; // its accidental
    private int octave; // INVARIENT: must be non-negative

    /**
     * constructor
     *
     * @param p        the pitch
     * @param a        the accidental
     * @param octave   which octave it is (must be non-negative)
     * @param duration the duration (must be > 0)
     */
    public Note(Pitch p, Accidental a, int octave, int duration, int start) {
        super(duration, start);
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
    @Override
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
    @Override
    public MusicType copy() {
        return new Note(pitch, acc, octave, duration, start);
    }
}
