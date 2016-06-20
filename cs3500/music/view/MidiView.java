package cs3500.music.view;


import java.awt.*;
import java.util.List;

import javax.sound.midi.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Song;

/**
 * A skeleton for MIDI playback
 */
public class MidiView implements IMusicView {
    private final Synthesizer synth;
    private final Receiver receiver;
    private Song.Builder model;
    private List<Beat> startNotes;

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
        startNotes = null;
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
        // deals with the pitch?
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, 0, n.getValue(), 64);
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, 0, n.getValue(), 64);
        this.receiver.send(start, -1);
        // deals with duration
        this.receiver.send(stop, this.synth.getMicrosecondPosition() +
          n.getDuration() * 1000);
        try {
            Thread.sleep(1000); // in milli-seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {

    }

    @Override
    public Dimension getPreferredSize() {
        return null;
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
        // fill play the start notes only
        for (int i = 0; i < model.getBeats().size(); i++) {
//            startNotes.add(new Beat());
            for (Note n: model.getBeats().get(i).getNotes()) {
                if (n.getStart() == i) { // if it's a head
                    try {
                        playNote(n);
                    } catch (InvalidMidiDataException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        this.receiver.close(); // Only call this once you're done playing *all* notes
    }
}
