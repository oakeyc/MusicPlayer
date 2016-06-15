package cs3500.music.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * represents a sheet of music (a collection of beats) Created by Courtney on 6/7/2016.
 */
public class SheetMusic {

    // a list of beats
    List<Beat> notes;

    /**
     * constructor, iniliazes data
     *
     * @param b a list of beat to be the list of beats
     */
    public SheetMusic(List<Beat> b) {
        notes = b;
    }

    /**
     * takes in a beat to add
     *
     * @param beat a beat to add
     */
    public void addBeat(Beat beat) {
        notes.add(beat);
    }

    /**
     * adds a note onto the end of the music
     *
     * @param n a note to add
     */
    public void addNote(Note n) {
        notes.add(new Beat(n));
    }

    /**
     * adds the note to a specifc beat
     *
     * @param n note to add
     * @param b beat to add the note at (0 enumerated)
     *
     *          throws illegalArguementException if the beat is invalid
     */
    public void addNote(Note n, int b) {
        checkBeat(b);
        for (int i = 0; i < n.getDuration() && (b + i) < notes.size(); i++)
            notes.get(i + b).addNote(n);
    }

    /**
     * checks invalid beats
     *
     * @param b beat to check if invalid
     */
    private void checkBeat(int b) {
        if (b < 0 || b >= notes.size())
            throw new IllegalArgumentException("Invalid beat number");
    }

    /**
     * gets all the music from a song
     */
    public List<Beat> getMusic() {
        return notes;
    }

    /**
     * edits a given note in a beat to a different note
     *
     * @param old  the note to be edited
     * @param next the note that replaces the old one
     * @param beat which beat it's in throws IllegalArguementException for invalid input
     */
    public void editNote(Note old, Note next, int beat) {
        change(old, next, beat, false);
    }

    /**
     * removes a note
     *
     * @param mt   the note to remove
     * @param beat the beat it is in throws IllegalArguementException for invalid input
     */
    public void remove(Note mt, int beat) {
        change(mt, null, beat, true);
    }

    /**
     * adds a model onto the end of this one
     *
     * @param that the Model to add onto the end
     * @return a new combined model
     */
    public SheetMusic add(SheetMusic that) {
        List<Beat> copy = new ArrayList<Beat>();
        copy.addAll(notes);
        for (Beat b : that.getMusic()) {
            Beat newbeat = new Beat();
            for (Note m : b.getNotes()) {
                Note newNote = m.copy();
                newNote.setStart(m.getStart() + notes.size());
                newbeat.addNote(newNote);
            }
            copy.add(newbeat);
        }
        return new SheetMusic(copy);
    }

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    public SheetMusic combine(SheetMusic that) {
        List<Beat> copy = new ArrayList<Beat>();
        for (Beat b: notes)
        {
            Beat newBeat = new Beat();
            for (Note m: b.getNotes())
            {
                newBeat.addNote(m.copy());
            }
            copy.add(newBeat);
        }
        if (copy.size() >= that.getMusic().size()) {
            loopOver(copy.size(), copy, that.getMusic());
        } else {
            loopOver(copy.size(), copy, that.getMusic());
            for (int i = copy.size(); i < that.getMusic().size(); i++) {
                copy.add(that.getMusic().get(i));
            }
        }
        return new SheetMusic(copy);
    }

    public List<Note> getAllNotes() {
        List<Note> result = new ArrayList<>();
        for (int a = 0; a < this.notes.size(); a++) {
            for (int b = 0; b < this.notes.get(a).getNotes().size(); b++) {
                result.add(this.notes.get(a).getNote(b));
            }
        }
        return result;
    }

    public Note getMaxNote() {
        return Collections.max(getAllNotes());
    }

    public Note getMinNote() { return Collections.min(getAllNotes()); }

    /**
     * the representation of this model
     *
     * @return string representation of the model
     */
    public String getState() {
        StringBuilder state = new StringBuilder("    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4" +
          " D4  D#4 E4  F4  F#4 G4\n");
        // the head of each note are exactly 4 spaces away
        int count = 0;
        int startVal = 3 * 12 + (Pitch.E.getValue()) - 1;
        int numCharPerLine = 17 * 4;
        for (Beat b : notes) {
            state.append(count);
            for (int i = 0; i < 17 * 4 - 2; i++)
                state.append(" ");

            for (Note m : b.getNotes()) {
                int numSpace = m.getValue() - startVal;
                state.replace(((count + 1) * numCharPerLine) + numSpace * 4,
                  ((count + 1) * numCharPerLine) + numSpace * 4 + 1, m.getImage(count));
            }
            count++;
            state.append("\n");
        }
        return state.toString();
    }

    /**
     * loops over adding all the notes from one list of beat to the copy
     *
     * @param size the minimun of the two sizes
     * @param copy the list we are copying into
     * @param that the list we are copying from
     */
    private void loopOver(int size, List<Beat> copy, List<Beat> that) {
        for (int i = 0; i < size; i++) {
            for (Note m : that.get(i).getNotes())
                copy.get(i).addNote(m);
        }
    }

    /**
     * changes a note
     *
     * @param old  the note to be changed
     * @param next the potential next note
     * @param beat the beat it is in
     * @param rem  if we want to only remove the old note
     *
     *             throws IllegalArguementException for invalid input
     */
    private void change(Note old, Note next, int beat, boolean rem) {
        checkBeat(beat);
        for (Note n : notes.get(beat).getNotes()) {
            if (n.equals(old)) {
                for (int i = 0; i < old.getDuration() && (beat + i) < notes.size(); i++)
                    notes.get(beat + i).getNotes().remove(n);
                if (rem)
                    return;
                for (int i = 0; i < next.getDuration() && (beat + i) < notes.size(); i++)
                    notes.get(beat + i).getNotes().add(next);
                return;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
}
