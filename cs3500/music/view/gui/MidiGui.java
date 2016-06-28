package cs3500.music.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.swing.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.MidiView;

/**
 * Created by Courtney on 6/20/2016.
 */
public class MidiGui extends MidiView {

    protected Sequence sequence;
    boolean swap;
    boolean started = false;

    public MidiGui() {
        super();

        sequence = null;
        swap = false;
    }

    public MidiGui(Receiver r, Synthesizer s) {
        super(r, s);
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
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
//        playBeats(0);
    }

    public void start() {
        seq.start();
    }


    public void close() {
//        this.receiver.close(); // Only call this once you're done playing *all* notes
//        seq.close();
    }


    public void playNote(Note n, Track t) throws InvalidMidiDataException {
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, 0, n.getValue(), 64);
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, 0, n.getValue(), 64);
        t.add(new MidiEvent(start, seq.getMicrosecondPosition() + n.getStart()));
        t.add(new MidiEvent(stop, seq.getMicrosecondPosition() +
          (n.getStart() + n.getDuration()) * model.getTempo()));
    }


    /**
     * plays the beats inclusive of the start exclusive of the end
     */
//    protected void playBeats(int start) {
//        Track t = sequence.createTrack();
//        for (int i = 0; i < model.getBeats().size(); i++) {
//            for (Note n : model.getBeats().get(i).getNotes()) {
//                if (n.getStart() == i) { // if it's a head
//                    try {
//                        playNote(n, t);
//                    } catch (InvalidMidiDataException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        try {
//            seq.setSequence(sequence);
//        } catch (InvalidMidiDataException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * stops the view from presenting more
     */
    @Override
    public void playPause() {
        started = true;
        if (swap)
            seq.stop();
        else
            seq.start();
        swap = !swap;
        seq.setTempoInMPQ(model.getTempo() * 4);
    }

    public void reDraw() {
        try {
            sequence = new Sequence(Sequence.PPQ, 4);
            seq.setTempoInMPQ(model.getTempo() * 4);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
//        playBeats(0);
    }

    @Override
    public boolean hasStarted() {
        return started;
    }
}
