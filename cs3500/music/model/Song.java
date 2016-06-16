package cs3500.music.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.music.controller.CompositionBuilder;

/**
 * represents a sheet of music (a collection of beats) Created by Courtney on 6/7/2016.
 */
public class Song implements GenericMusicModel{

    // a list of beats
    private List<Beat> beats;
    private int tempo;



    public Song(List<Beat> beats) {
        this.beats = beats;
        this.tempo = 0;
    }

    public Song() {
    }

    /**
     * takes in a beat to add
     *
     * @param beat a beat to add
     */
    public void addBeat(Beat beat) {
        beats.add(beat);
    }

    /**
     * adds the note to a specifc beat
     *
     * @param n note to add
     *
     *          throws illegalArguementException if the beat is invalid
     */
    public void addNote(Note n) {
        for (int i = 0; i < n.getDuration() && (n.getStart() + i) < beats.size(); i++)
            beats.get(i + n.getStart()).addNote(n);
    }

    /**
     * checks invalid beats
     *
     * @param b beat to check if invalid
     */
    private void checkBeat(int b) {
        if (b < 0 || b >= beats.size())
            throw new IllegalArgumentException("Invalid beat number");
    }

    /**
     * gets all the music from a song
     */
    public List<Beat> getMusic() {
        return beats;
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
    @Override
    public GenericMusicModel add(GenericMusicModel that) {
        return add(that.getMusic());
    }

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    @Override
    public GenericMusicModel combine(GenericMusicModel that) {
        return combine(that.getMusic());
    }

    @Override
    public String getState() {
        return null; // FIXME: 6/15/2016
    }

    /**
     * adds a model onto the end of this one
     *
     * @param that the Model to add onto the end
     * @return a new combined model
     */
    public Song add(List<Beat> that) {
        List<Beat> copy = new ArrayList<Beat>();
        copy.addAll(beats);
        for (Beat b : that) {
            Beat newbeat = new Beat();
            for (Note m : b.getNotes()) {
                Note newNote = m.copy();
                newNote.setStart(m.getStart() + beats.size());
                newbeat.addNote(newNote);
            }
            copy.add(newbeat);
        }
        return new Song(copy);
    }

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    public Song combine(List<Beat> that) {
        List<Beat> copy = new ArrayList<Beat>();
        for (Beat b: beats)
        {
            Beat newBeat = new Beat();
            for (Note m: b.getNotes())
            {
                newBeat.addNote(m.copy());
            }
            copy.add(newBeat);
        }
        if (copy.size() >= that.size()) {
            loopOver(copy.size(), copy, that);
        } else {
            loopOver(copy.size(), copy, that);
            for (int i = copy.size(); i < that.size(); i++) {
                copy.add(that.get(i));
            }
        }
        return new Song(copy);
    }

    private List<Note> getAllNotes() {
        List<Note> result = new ArrayList<>();
        for (int a = 0; a < this.beats.size(); a++) {
            for (int b = 0; b < this.beats.get(a).getNotes().size(); b++) {
                result.add(this.beats.get(a).getNote(b));
            }
        }
        return result;
    }

    public Note getMaxNote() {
        return Collections.max(getAllNotes());
    }

    public Note getMinNote() { return Collections.min(getAllNotes()); }


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
        for (Note n : beats.get(beat).getNotes()) {
            if (n.equals(old)) {
                for (int i = 0; i < old.getDuration() && (beat + i) < beats.size(); i++)
                    beats.get(beat + i).getNotes().remove(n);
                if (rem)
                    return;
                for (int i = 0; i < next.getDuration() && (beat + i) < beats.size(); i++)
                    beats.get(beat + i).getNotes().add(next);
                return;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }



    public static final class Builder implements CompositionBuilder<GenericMusicModel> {
        Song song;


        public Builder(Song song){
            this.song = song;
        }

        @Override
        public Song build() {
            return song;
        }

        @Override
        public CompositionBuilder<GenericMusicModel> setTempo(int tempo1) {
            song.tempo = tempo1;
            return this;
        }

        @Override
        public CompositionBuilder<GenericMusicModel> addNote(int start, int end, int instrument, int pitch, int volume) {
            song.beats.get(start).addNote(new Note(numToPitch(pitch), numToOctave(pitch), noteLength(start, end), start));
            return this; // FIXME: 6/15/2016 DYNAMICALLY ADD NOTES
        }


        /**
         * Returns the pitch of a note based on its number.
         * @param noteNumber
         * @return
         */
        private Pitch numToPitch(int noteNumber) {
            int tempNum = noteNumber - (12 * numToOctave(noteNumber));
            return Pitch.values()[tempNum];
        }

        /**
         * Returns the octave of a note based on its number.
         * @param noteNumber
         * @return
         */
        private int numToOctave(int noteNumber) {
            return Math.floorDiv(noteNumber, 12);
        }

        /**
         * Returns the length of a note based on its starting and ending beats.
         * @param startBeat
         * @param endBeat
         * @return
         */
        private int noteLength(int startBeat, int endBeat) {
            return endBeat - startBeat;
        }
    }



    public List<Beat> getBeats() {
        return this.beats;
    }

}
