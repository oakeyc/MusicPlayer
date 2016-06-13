package cs3500.music.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents a single beat. There are typically 4 beats in a measure Created by Courtney on
 * 6/9/2016.
 */
public class Beat {
    // all the notes that are on this beat
    private List<MusicType> notes;

    /**
     * constructor
     *
     * @param n adds this note to the List of MusicTypes
     */
    public Beat(MusicType n) {
        notes = new ArrayList<MusicType>();
        notes.add(n);
    }

    /**
     * constructor
     *
     * @param n takes in an entire list of MusicTypes to initialize
     */
    public Beat(List<MusicType> n) {
        notes = n;
    }

    /**
     * default constructor, inits the data
     */
    public Beat() {
        notes = new ArrayList<MusicType>();
    }

    /**
     * returns all the notes on this beat
     *
     * @return a list of all the notes on this beat
     */
    public List<MusicType> getNotes() {
        return notes;
    }

    /**
     * adds a note to this Beat
     * @param n        note to add
     */
    public void addNote(MusicType n) {
        notes.add(n);
    }
}
