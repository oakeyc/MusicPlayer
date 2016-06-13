package cs3500.music.model;

import java.util.List;

/** represents any way someone who represent music
 * Created by Courtney on 6/10/2016.
 */
public interface GenericMusic {
    /**
     * takes in a beat to add
     *
     * @param beat a beat to add
     */
    public void addBeat(Beat beat);

    /**
     * adds a note onto the end
     * @param n   the note to end
     */
    void addNote(MusicType n);

    /**
     * adds the note to a specifc beat
     * @param n        note to add
     * @param b        beat to add the note at
     *       throws illegalArguementException if the beat
     *                 doesn't exist
     */
    void addNote(MusicType n, int b);

    /**
     * gets all the music from a song
     * @return
     */
    List<Beat> getMusic();

    /**
    * edits a given note in a beat to
    * a different note
    * @param old          the note to be edited
    * @param next         the note that replaces the old one
    * @param beat         which beat it's in
      *          throws illegalArguementException for invalid input
    */
    void editNote(MusicType old, MusicType next, int beat);

    /**
     * removes a note
     * @param mt      the note to remove
     * @param beat    the beat it is in
     *        throws illegalArguementException for invalid input
     */
    void remove(MusicType mt, int beat);

    /**
     * adds a music onto the end of this one
     * @param that       the music to add onto the end
     * @return           a new combined music
     */
    GenericMusic add(GenericMusic that);

    /**
     * combines this music with that one
     * @param that        music to combine
     * @return            a new music model
     */
    GenericMusic combine(GenericMusic that);

    /**
     * the representation of this model
     * @return         string representation of the model
     */
    String getState();
}
