package cs3500.music.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents a single beat. There are typically 4 beats in a measure Created by Courtney on
 * 6/9/2016.
 */
public class Beat {
    // all the notes that are on this beat
    public List<Note> notes;
    private boolean elCapo;
    private boolean altEnd;

    /**
     * constructor
     *
     * @param n adds this note to the List of MusicTypes
     */
    public Beat(Note n) {
        notes = new ArrayList<Note>();
        notes.add(n);
        elCapo = false;
        altEnd = false;
    }

    /**
     * constructor
     *
     * @param n takes in an entire list of MusicTypes to initialize
     */
    public Beat(List<Note> n) {
        notes = n;
        elCapo = false;
        altEnd = false;
    }

    /**
     * default constructor, inits the data
     */
    public Beat() {
        notes = new ArrayList<Note>();
        elCapo = false;
        altEnd = false;
    }

    /**
     * returns a copy of all the notes on this beat
     *
     * @return a list of all the notes on this beat
     */
    public List<Note> getNotes() {
       return notes;
    }

    /**
     * adds a note to this Beat
     *
     * @param n note to add
     */
    public void addNote(Note n) {
        notes.add(n);
    }

    /**
     * get a specific note based on index
     */
    public Note getNote(int i) {
        return this.notes.get(i);
    }

    /**
     * sets the repeat
     */
    public void setRepeat() {
        elCapo = true;
    }

    /**
     * gets if it repeat
     * @return   gets if repeat
     */
    public boolean getElCapo() {
        return elCapo;
    }

    /**
     * gets if it is an alternate end
     * @return    gets the altnerend
     */
    public boolean isAltEnd() {
        return altEnd;
    }

    /**
     * makes in an althernate end
     */
    public void setAltEnd() {
        altEnd = true;
    }
}
