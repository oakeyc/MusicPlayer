package cs3500.music.model;

/**
 * represents a generic music model Created by Courtney on 6/10/2016.
 */
public interface GenericMusicModel {

    /**
     * adds music type to a specific beat
     * @param mt
     */
    void addNote(Note mt);

    /**
     * edits a given note in a beat to
     * a different note
     * @param old          the note to be edited
     * @param next         the note that replaces the old one
     * @param beat         which beat it's in
     *          throws illegalArguementException for invalid input
     */
    void editNote(Note old, Note next, int beat);

    /**
     * removes a note
     * @param mt      the note to remove
     * @param beat    the beat it is in
     *        throws illegalArguementException for invalid input
     */
    void remove(Note mt, int beat);

    /**
     * adds a model onto the end of this one
     * @param that       the Model to add onto the end
     * @return           a new combined model
     */
    GenericMusicModel add(GenericMusicModel that);

    /**
     * combines this model with that one
     * @param that        model to combine
     * @return            a new combined model
     */
    GenericMusicModel combine(GenericMusicModel that);

    /**
     * the representation of this model
     * @return         string representation of the model
     */
    String getState();

    /**
     * gets the sheet music
     * @return      a sheet music implementation
     */
    SheetMusic getSheet();
}
