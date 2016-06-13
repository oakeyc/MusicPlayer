package cs3500.music.model;

import java.awt.*;

/**
 * represents a rest in the music Created by Courtney on 6/7/2016.
 */
public class Rest extends MusicType {

    /**
     * constructor, initializes duration
     *
     * @param duration the duration to initialize
     * @param start the start
     */
    public Rest(int duration, int start) {
        super(duration, start);
    }

    /**
     * the string representation of this object
     * @return    the string representation of this object
     */
    @Override
    public String getImage(int beat) {
        return " ";
    }

    /**
     * returns a copy
     *
     * @return MusicType  a copy
     */
    @Override
    public MusicType copy() {
        return new Rest(this.duration, this.start);
    }
}
