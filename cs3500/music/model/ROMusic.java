package cs3500.music.model;

import java.util.List;

/**
 * Created by Courtney on 6/15/2016.
 */
public class ROMusic implements GenericMusicModel {
    /**
     * adds music type to a specific beat
     */
    @Override
    public void addNote(Note mt) {

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

    }

    /**
     * removes a note
     *
     * @param mt   the note to remove
     * @param beat the beat it is in
     */
    @Override
    public void remove(Note mt, int beat) {

    }

    /**
     * adds a model onto the end of this one
     *
     * @param that the Model to add onto the end
     * @return a new combined model
     */
    @Override
    public GenericMusicModel add(GenericMusicModel that) {
        return null;
    }

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    @Override
    public GenericMusicModel combine(GenericMusicModel that) {
        return null;
    }

    /**
     * the representation of this model
     *
     * @return string representation of the model
     */
    @Override
    public String getState() {
        return null;
    }

    /**
     * gets the sheet music
     *
     * @return a sheet music implementation
     */
    @Override
    public List<Beat> getMusic() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Note getMaxNote() {
        return null;
    }

    @Override
    public Note getMinNote() {
        return null;
    }
}
