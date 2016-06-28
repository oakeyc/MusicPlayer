package cs3500.music.view.gui.Repeats;

import java.awt.event.ActionEvent;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import cs3500.music.model.Song;
import cs3500.music.model.SongRepeats;
import cs3500.music.view.gui.GuiMidiImpl;
import cs3500.music.view.gui.NotePanel;

/**
 * represents a combined GUI and MIDI representation for a song with repeats
 *
 * Created by Courtney on 6/27/2016.
 */
public class GuiMidiRepeats extends GuiMidiImpl {

    /**
     * constructor
     */
    public GuiMidiRepeats() {
        super();
        midi = new MidiRepeats();
        song = null;
    }

    /**
     * factory method that creates the display component for this window
     */
    public NotePanel createDisplay() {
//        System.out.println("SONG SIZE OF ENDS: " + ((SongRepeats) song).getEnds().size());

        NotePanelRepeats np = new NotePanelRepeats(low, high, song.getBeats(), song.getTempo());
        SongRepeats s = (SongRepeats) song;
//        System.out.println("SONG SIZE OF ENDS: " + ((SongRepeats) song).getEnds().size());
        np.setStarts(s.getStarts());
        np.setEnds(s.getEnds());
        return np;
    }

    @Override
    public void setModel(Song s) {
        super.setModel(s);

        MidiRepeats mi = (MidiRepeats) midi;
        mi.setStarts(((SongRepeats)s).getStarts());
        mi.setEnds(((SongRepeats)s).getEnds());
    }
}
