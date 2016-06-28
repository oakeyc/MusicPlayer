package cs3500.music.view.gui.Repeats;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    ArrayList<Integer> ends;
    int endsCounter;
    int startCounter;

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
        startCounter = starts.size() - 1;
    }

    public void setEnds(ArrayList<Integer> ends) {
        this.ends = ends;
        endsCounter = 0;
    }
    /**
     * gets the most recent repeat
     * @return   the beat which we should go to
     */
    public int getNextDC() {
        if (startCounter < 0) {
            return 0; // go to the start
        }
        return starts.get(startCounter);
    }

    /**
     * gets the next upcoming alternative ending
     * @return   which beat it is on
     */
    public int getNextAltEnd() {
        if (endsCounter >= ends.size() - 1) {
            return notes.size(); // the end of the song
        }
        return ends.get(endsCounter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
//        System.out.println(posOfCurrLine / NotePanel.widthOfNote + "  \n" +
//        " ends :  " + ends.peek() + " SIZE: " + ends.size());
        if (endsCounter <= ends.size() - 1 && posOfCurrLine / NotePanel.widthOfNote ==
          ends.get(endsCounter)) {
            System.out.println(" I BELIVE IN YOU \n");
            endsCounter++;
            scroll(getNextDC());
            startCounter--;
        }
    }
}
