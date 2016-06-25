package cs3500.music;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Patch;
import javax.sound.midi.Receiver;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.sound.midi.VoiceStatus;

/**
 * mock synthesizer Created by Courtney on 6/19/2016.
 */
public class MockSynth implements Synthesizer {

    MockReceiver r;


    @Override
    public Info getDeviceInfo() {
        return null;
    }

    @Override
    public void open() throws MidiUnavailableException {

    }


    @Override
    public void close() {

    }

    /**
     * Reports whether the device is open.
     *
     * @return <code>true</code> if the device is open, otherwise <code>false</code>
     * @see #open
     * @see #close
     */
    @Override
    public boolean isOpen() {
        return false;
    }


    @Override
    public long getMicrosecondPosition() {
        return 0;
    }


    @Override
    public int getMaxReceivers() {
        return 0;
    }


    @Override
    public int getMaxTransmitters() {
        return 0;
    }

    public MockReceiver getReceiver() {
        return r;
    }


    @Override
    public List<Receiver> getReceivers() {
        return null;
    }


    @Override
    public Transmitter getTransmitter() throws MidiUnavailableException {
        return null;
    }


    @Override
    public List<Transmitter> getTransmitters() {
        return null;
    }


    @Override
    public int getMaxPolyphony() {
        return 0;
    }

    @Override
    public long getLatency() {
        return 0;
    }

    @Override
    public MidiChannel[] getChannels() {
        return new MidiChannel[0];
    }


    @Override
    public VoiceStatus[] getVoiceStatus() {
        return new VoiceStatus[0];
    }


    @Override
    public boolean isSoundbankSupported(Soundbank soundbank) {
        return false;
    }

    @Override
    public boolean loadInstrument(Instrument instrument) {
        return false;
    }


    @Override
    public void unloadInstrument(Instrument instrument) {

    }

    @Override
    public boolean remapInstrument(Instrument from, Instrument to) {
        return false;
    }

    /**
     * Obtains the default soundbank for the synthesizer, if one exists. (Some synthesizers provide
     * a default or built-in soundbank.) If a synthesizer doesn't have a default soundbank,
     * instruments must be loaded explicitly from an external soundbank.
     *
     * @return default soundbank, or <code>null</code> if one does not exist.
     * @see #isSoundbankSupported
     */
    @Override
    public Soundbank getDefaultSoundbank() {
        return null;
    }


    @Override
    public Instrument[] getAvailableInstruments() {
        return new Instrument[0];
    }

    /**
     * Obtains a list of the instruments that are currently loaded onto this
     * <code>Synthesizer</code>.
     *
     * @return a list of currently loaded instruments
     * @see #loadInstrument
     * @see #getAvailableInstruments
     * @see Soundbank#getInstruments
     */
    @Override
    public Instrument[] getLoadedInstruments() {
        return new Instrument[0];
    }


    @Override
    public boolean loadAllInstruments(Soundbank soundbank) {
        return false;
    }

    /**
     * Unloads all instruments contained in the specified <code>Soundbank</code>.
     *
     * @param soundbank soundbank containing instruments to unload
     * @throws IllegalArgumentException thrown if the soundbank is not supported.
     * @see #isSoundbankSupported
     * @see #unloadInstrument
     * @see #unloadInstruments
     */
    @Override
    public void unloadAllInstruments(Soundbank soundbank) {

    }


    @Override
    public boolean loadInstruments(Soundbank soundbank, Patch[] patchList) {
        return false;
    }


    @Override
    public void unloadInstruments(Soundbank soundbank, Patch[] patchList) {

    }
}