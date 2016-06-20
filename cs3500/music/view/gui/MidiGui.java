package cs3500.music.view.gui;

import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.MidiView;

/**
 * Created by Courtney on 6/20/2016.
 */
public class MidiGui extends MidiView {

//    private final Synthesizer synth;
//    private final Receiver receiver;
//    private Song.Builder model;
//    private List<Beat> startNotes;

    public MidiGui() {
        super();
    }

    public MidiGui(Receiver r, Synthesizer s) {
       super(r, s);
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
        super.playNote(n);
    }

    /**
     * Sets the model of this instance of MidiView
     */
    @Override
    public void setModel(Song.Builder model) {
        super.setModel(model);
    }

    /**
     * Renders the MIDI View
     */
    @Override
    public void render() {
        for (int i = 0; i < model.getBeats().size(); i++) {
            for (Note n : model.getBeats().get(i).getNotes()) {
                if (n.getStart() == i) { // if it's a head
                    try {
                        playNote(n);
                    } catch (InvalidMidiDataException e) {
                        e.printStackTrace();
                    }
                }
            }
//            try {
//                Thread.sleep(100); // in milli-seconds
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        this.receiver.close(); // Only call this once you're done playing *all* notes
    }
}

