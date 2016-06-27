package cs3500.music.model;

import java.util.List;

/**
 * a Read Only Model for GenericMusicModel Created by Courtney on 6/15/2016.
 */
public class ROMusic implements GenericMusicModel {
    GenericMusicModel m;

    /**
     * initializes the data
     *
     * @param m the Song model for which this is read only
     */
    public ROMusic(Song m) {
        this.m = m;
    }

    /**
     * adds music type to a specific beat
     */
    @Override
    public void addNote(Note mt) {
        throw new RuntimeException("Read only");
    }

    /**
     * edits a given note in a beat to a different note
     *
     * @param old  the note to be edited
     * @param next the note that replaces the old one
     */
    @Override
    public void editNote(Note old, Note next) {
        throw new RuntimeException("Read only");
    }

    /**
     * removes a note
     *
     * @param mt   the note to remove
     */
    @Override
    public void remove(Note mt) {
        throw new RuntimeException("Read only");
    }

    /**
     * adds a model onto the end of this one
     *
     * @param that the Model to add onto the end
     * @return a new combined model
     */
    @Override
    public GenericMusicModel add(GenericMusicModel that) {
        throw new RuntimeException("Read only");
    }

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    @Override
    public GenericMusicModel combine(GenericMusicModel that) {
        throw new RuntimeException("Read only");
    }

    /**
     * gets the sheet music
     *
     * @return a sheet music implementation
     */
    @Override
    public List<Beat> getBeats() {
        return m.getBeats();
    }

    /**
     * gets a copy of highest note in the song
     *
     * @return highest note
     */
    @Override
    public Note getMaxNote() {
        return m.getMaxNote();
    }

    /**
     * gets a copy of the lowest note in the song
     *
     * @return the lowest note
     */
    @Override
    public Note getMinNote() {
        return m.getMinNote();
    }
}
