package cs3500.music.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;

/**
 * represents a music model allows the user to represent music
 *
 * Created by Courtney on 6/6/2016.
 */
public class MusicModel implements GenericMusicModel, CompositionBuilder<MusicModel> {
    // the song represented as SheetMusic
    private SheetMusic sheet1;

    /**
     * constructor, takes in data
     *
     * @param sheet the sheet to be this music
     */
    public MusicModel(SheetMusic sheet) {
        sheet1 = new SheetMusic(sheet.getMusic());
    }

    /**
     * the string representation
     * @return      the string representation
     */
    @Override
    public String getState() {
        return sheet1.getState();
    }

    /**
     * gets the sheet music
     *
     * @return a sheet music implementation
     */
    @Override
    public SheetMusic getSheet() {
        return sheet1;
    }

    /**
     * adds music type to a specific beat
     */
    @Override
    public void addNote(Note mt) {
        sheet1.addNote(mt);
    }

    /**
     * edits a given note in a beat to a different note
     *
     * @param old  the note to be edited
     * @param next the note that replaces the old one
     * @param beat which beat it's in
     */
    @Override
    public void editNote(Note old, Note next, int beat) {
        sheet1.editNote(old, next, beat);
    }

    /**
     * removes a note
     *
     * @param mt   the note to remove
     * @param beat the beat it is in
     */
    @Override
    public void remove(Note mt, int beat) {
        sheet1.remove(mt, beat);
    }

    /**
     * adds a model onto the end of this one
     *
     * @param that the Model to add onto the end
     * @return a new combined model
     */
    @Override
    public GenericMusicModel add(GenericMusicModel that) {
        return new MusicModel(sheet1.add(that.getSheet()));
    }

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    @Override
    public GenericMusicModel combine(GenericMusicModel that) {
        return new MusicModel(sheet1.combine(that.getSheet()));
    }

    @Override
    public MusicModel build() {
        return null;
    }

    @Override
    public CompositionBuilder<MusicModel> setTempo(int tempo) {
        return null;
    }

    @Override
    public CompositionBuilder<MusicModel> addNote(int start, int end, int instrument, int pitch, int volume) {
        return null;
    }
}
