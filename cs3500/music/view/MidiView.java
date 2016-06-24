package cs3500.music.view;


import java.awt.*;
import java.util.List;

import javax.sound.midi.*;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.controller.MouseHandler;
import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.gui.ScrollDir;

/**
 * A skeleton for MIDI playback
 */
public class MidiView implements IMusicView {
    private final Synthesizer synth;
    protected final Receiver receiver;
    protected Song.Builder model;

    protected boolean stop;
    protected Sequencer seq;

    public MidiView() {
        Receiver tempR = null;
        Synthesizer tempS = null;
        try {
            tempS = MidiSystem.getSynthesizer();
            tempR = tempS.getReceiver();
            tempS.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        receiver = tempR;
        synth = tempS;
        this.model = null;
        stop = false;
//        seq.Sequencer
    }

    public MidiView(Receiver r, Synthesizer s) {
        receiver = r;
        synth = s;
        model = null;
        stop = false;
    }

    /**
     * Relevant classes and methods from the javax.sound.midi library: <ul> <li>{@link
     * MidiSystem#getSynthesizer()}</li> <li>{@link Synthesizer} <ul> <li>{@link
     * Synthesizer#open()}</li> <li>{@link Synthesizer#getReceiver()}</li> <li>{@link
     * Synthesizer#getChannels()}</li> </ul> </li> <li>{@link Receiver} <ul> <li>{@link
     * Receiver#send(MidiMessage, long)}</li> <li>{@link Receiver#close()}</li> </ul> </li>
     * <li>{@link MidiMessage}</li> <li>{@link ShortMessage}</li> <li>{@link MidiChannel} <ul>
     * <li>{@link MidiChannel#getProgram()}</li> <li>{@link MidiChannel#programChange(int)}</li>
     * </ul> </li> </ul>
     *
     * @see <a href="https://en.wikipedia.org/wiki/General_MIDI"> https://en.wikipedia.org/wiki/General_MIDI
     * </a>
     */

    public void playNote(Note n) throws InvalidMidiDataException {
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, 0, n.getValue(), 64);
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, 0, n.getValue(), 64);
        this.receiver.send(start, synth.getMicrosecondPosition() + n.getStart() * model.getTempo());
        this.receiver.send(stop, synth.getMicrosecondPosition() + (n.getStart() + n.getDuration()) * model.getTempo());
    }

    /**
     * Sets the model of this instance of MidiView
     */
    @Override
    public void setModel(Song.Builder model) {
        this.model = model;
    }

    /**
     * Renders the MIDI View
     */
    @Override
    public void render() {
        stop = false;

        for (int i = 0; i < model.getBeats().size(); i++) {
            for (Note n : model.getBeats().get(i).getNotes()) {
                if (model.getBeats().get(i).isAltEnd()) { // replay

                }

                if (n.getStart() == i) { // if it's a head
                    if (i != 50)
                        try {
                            playNote(n);
                        } catch (InvalidMidiDataException e) {
                            e.printStackTrace();
                        }
                }
            }
            try {
                Thread.sleep(100); // in milli-seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.receiver.close(); // Only call this once you're done playing *all* notes
    }

    /**
     * stops the view from presenting more
     */
    @Override
    public void playPause() {
        stop = !stop;
    }

    @Override
    public void addKeyListener(KeyboardHandler kbd) {
        this.addKeyListener(kbd);
    }

    @Override
    public void scroll(ScrollDir left) {

    }

    @Override
    public void addMouseListener(MouseHandler msh) {

    }

    @Override
    public Note getInputNote() {
        return null;
    }

    public long getMicroPos() {
        return synth.getMicrosecondPosition();
    }

}
