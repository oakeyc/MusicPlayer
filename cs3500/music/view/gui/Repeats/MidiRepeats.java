package cs3500.music.view.gui.Repeats;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.model.SongRepeats;
import cs3500.music.view.gui.GuiView;
import cs3500.music.view.gui.MidiGui;

/**
 * Created by Courtney on 6/27/2016.
 */
public class MidiRepeats extends MidiGui {

    Stack<Integer> starts;
    ArrayList<Integer> ends;
    int endsCounter;
    int startCounter;
    Track t;
    int count = 0;

    public MidiRepeats() {
        super();
    }

    /**
     * Sets the model of this instance of MidiView
     */
    @Override
    public void setModel(Song model) {
        super.setModel(model);
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
        int temp = starts.get(startCounter);
        startCounter--;

        return temp;
    }

    /**
     * gets the next upcoming alternative ending
     * @return   which beat it is on
     */
    public int getNextAltEnd() {
        if (endsCounter > ends.size() - 1) {
            return model.getBeats().size(); // the end of the song
        }
        return ends.get(endsCounter);
    }

    /**
     * Renders the MIDI View
     */
    @Override
    public void render() {
        try {
            sequence = new Sequence(Sequence.PPQ, 4);
            seq.setTempoInMPQ(model.getTempo() * 4);

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        t = sequence.createTrack();

        playBeats(0, t);
    }

    public void playNote(Note n, Track t, int incre) throws InvalidMidiDataException {
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, 0, n.getValue(), 64);
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, 0, n.getValue(), 64);
        t.add(new MidiEvent(start, seq.getMicrosecondPosition() + incre));
        t.add(new MidiEvent(stop, seq.getMicrosecondPosition() +
          (incre + n.getDuration()) * model.getTempo()));
    }


    protected void playBeats(int start, Track t) {
        for (int i = start; i < model.getBeats().size(); i++) {
            if (i == getNextAltEnd()) {
                endsCounter++;
                playBeats(getNextDC(), t);
                return;
            }
            for (Note n : model.getBeats().get(i).getNotes()) {
                if (n.getStart() == i) { // if it's a head
                    try {
                        playNote(n, t, count);
                    } catch (InvalidMidiDataException e) {
                        e.printStackTrace();
                    }
                }
            }
            count++;
        }
        try {
            seq.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reDraw() {
        render();
    }

}
