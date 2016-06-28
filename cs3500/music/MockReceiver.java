package cs3500.music;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;

/** reps a mock receiver
 * Created by Courtney on 6/19/2016.
 */
public class MockReceiver implements Receiver {
    public StringBuilder str;

    MockReceiver(StringBuilder s) {
        str = s;
    }

    /**
     * Sends a MIDI message and time-stamp to this receiver.
     * If time-stamping is not supported by
     * this receiver, the time-stamp value should be -1.
     *
     * @param message   the MIDI message to send
     * @param timeStamp the time-stamp for the message, in microseconds.
     * @throws IllegalStateException if the receiver is closed
     */
    @Override
    public void send(MidiMessage message, long timeStamp) {
        str.append(message.getStatus());
    }

    @Override
    public void close() {
        System.out.println(str.toString());
    }
}
