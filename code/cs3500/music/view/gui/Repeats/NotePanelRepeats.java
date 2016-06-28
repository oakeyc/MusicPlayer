package cs3500.music.view.gui.Repeats;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.view.gui.NoteAddPanel;
import cs3500.music.view.gui.NotePanel;

/** changes the display for the repeats
 *
 * Created by Courtney on 6/27/2016.
 */
public class NotePanelRepeats extends NotePanel {
    Stack<Integer> starts;
    Queue<Integer> ends;

    /**
     * constructor
     *
     * @param low  the lowest note in the song
     * @param high the highest note in the song
     */
    public NotePanelRepeats(Note low, Note high, List<Beat> notes, int tempo) {
        super(low, high, notes, tempo);
    }

    public void setStarts(Stack<Integer> start) {
        this.starts = start;
    }

    public void setEnds(Queue<Integer> ends) {
        this.ends = ends;
    }

    /**
     * gets the most recent repeat
     * @return   the beat which we should go to
     */
    public int getNextDC() {
        if (starts.peek() == null) {
            return 0; // go to the start
        }
        return starts.pop();
    }

    /**
     * gets the next upcoming alternative ending
     * @return   which beat it is on
     */
    public int getNextAltEnd() {
        if (ends.peek() == null) {
            return notes.size() - 1; // the end of the song
        }
        return ends.remove();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (ends.size() != 0 && posOfCurrLine / NotePanel.widthOfNote == ends.peek()) {
            ends.remove();
            scroll(getNextDC());
        }
    }
}
