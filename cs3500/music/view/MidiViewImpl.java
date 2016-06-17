package cs3500.music.view;

import java.awt.*;

import javax.sound.midi.*;

import cs3500.music.model.Song;

/**
 * A skeleton for MIDI playback
 */
public class MidiViewImpl implements IMusicView {
    private final Synthesizer synth;
    private final Receiver receiver;

    public MidiViewImpl() {
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
     * @see <a href="https://en.wikipedia.org/wiki/General_MIDI">
     *     https://en.wikipedia.org/wiki/General_MIDI
     * </a>
     */

    public void playNote() throws InvalidMidiDataException {
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, 0, 60, 64);
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, 0, 60, 64);
        this.receiver.send(start, -1);
        this.receiver.send(stop, this.synth.getMicrosecondPosition() + 200000);
        try {
            Thread.sleep(1000); // in milli-seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.receiver.close(); // Only call this once you're done playing *all* notes
    }

    @Override
    public void initialize() {

    }

    @Override
    public Dimension getPreferredSize() {
        return null;
    }

  /**
   * Sets the model of this instance of MidiViewImpl
   * @param model
   */
  @Override
    public void setModel(Song.Builder model) {

    }

  /**
   * Renders the MIDI View
   */
  @Override // FIXME: 6/17/2016 DUPLICATE?
    public void render() {
    }
}
