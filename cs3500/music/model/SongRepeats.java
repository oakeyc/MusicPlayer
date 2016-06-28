package cs3500.music.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/** represents a song with capabilities of repeating
 * Created by Courtney on 6/27/2016.
 */
public class SongRepeats extends Song {
    Stack<Integer> starts;
    ArrayList<Integer> ends;

    public SongRepeats() {
        super();
        starts = new Stack<Integer>();
        ends = new ArrayList<Integer>() {};
    }

    public SongRepeats(List<Beat> b, int tempo) {
        super(b, tempo);
        starts = new Stack<Integer>();
        ends = new ArrayList<Integer>();
    }
    /**
     * sets where to come back to repeat
     * @param beat  which beat
     */
    public void addDC(int beat) {
        starts.push(beat);
    }

    /**
     * adds on an altnerative ending
     * @param beat  which beat
     */
    public void addAltEnd(int beat) {
        ends.add(beat);
    }

    /**
     * gets the most recent repeat
     * @return   the beat which we should go to
     */
    public int retrieveNextDC() {
        if (starts.size() == 0) {
            return 0; // go to the start
        }
        return starts.pop();
    }
//
//    public int getNextAltEnd() {
//        if (ends.size() == 0)
//            return getBeats().size();
//        return ends.peek();
//    }
//
//    /**
//     * gets the next upcoming alternative ending
//     * @return   which beat it is on
//     */
//    public int retrieverNextAltEnd() {
//        if (ends.peek() == null) {
//            return getBeats().size() - 1; // the end of the song
//        }
//        return ends.remove();
//    }

    public Stack<Integer> getStarts() {
        return starts;
    }

    public ArrayList<Integer> getEnds() {
        return ends;
    }
}
