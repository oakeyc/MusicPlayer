package cs3500.music.model;

import java.util.List;

/**
 * represents a generic music model Created by Courtney on 6/10/2016.
 */
public interface GenericMusicModel {

    /**
     * adds music type to a specific beat
     */
    void addNote(Note mt);

    /**
     * edits a given note in a beat to a different note
     *
     * @param old  the note to be edited
     * @param next the note that replaces the old one
     */
    void editNote(Note old, Note next);

    /**
     * removes a note
     *
     * @param mt   the note to remove
     */
    void remove(Note mt);

    /**
     * adds a model onto the end of this one
     *
     * @param that the Model to add onto the end
     * @return a new combined model
     */
    GenericMusicModel add(GenericMusicModel that);

    /**
     * combines this model with that one
     *
     * @param that model to combine
     * @return a new combined model
     */
    GenericMusicModel combine(GenericMusicModel that);

    /**
     * gets the sheet music
     *
     * @return a sheet music implementation
     */
    List<Beat> getBeats();

    /**
     * gets highest note
     * @return the most high note in the Model
     */
    Note getMaxNote();

    /**
     * gets lowest note
     * @return the most low note in the model
     */
    Note getMinNote();
}
