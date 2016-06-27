package cs3500.music.view.gui.Repeats;

import java.util.Queue;
import java.util.Stack;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
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
    Queue<Integer> ends;

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

    /**
     * Renders the MIDI View
     */
    @Override
    public void render() {
        try {
            sequence = new Sequence(Sequence.PPQ, 4);
            seq.setTempoInMPQ(model.getTempo() * 4);
            starts = ((SongRepeats) model).getStarts();
            ends = ((SongRepeats) model).getEnds();

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        Track t = sequence.createTrack();

        playBeats(0, t);
    }

    protected void playBeats(int start, Track t) {
        for (int i = start; i < model.getBeats().size(); i++) {
            if (ends.size() != 0 && i == ends.peek()) {
                ends.remove();
                if (starts.peek() == null)
                    playBeats(0);
                else
                    playBeats(starts.pop());
                return;
            }
            for (Note n : model.getBeats().get(i).getNotes()) {
                if (n.getStart() == i) { // if it's a head
                    try {
                        playNote(n, t);
                    } catch (InvalidMidiDataException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        try {
            seq.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
