package cs3500.music.view.gui.Repeats;

import java.awt.event.ActionEvent;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import cs3500.music.model.Song;
import cs3500.music.model.SongRepeats;
import cs3500.music.view.gui.GuiMidiImpl;
import cs3500.music.view.gui.NotePanel;

/** represents a combined GUI and MIDI representation for a
 * song with repeats
 *
 * Created by Courtney on 6/27/2016.
 */
public class GuiMidiRepeats extends GuiMidiImpl {
    private SongRepeats song;

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
     * @return
     */
    public NotePanel createDisplay() {
        NotePanelRepeats np = new NotePanelRepeats(low, high, song.getBeats(), song.getTempo());
        np.setStarts(song.getStarts());
        np.setEnds(song.getEnds());
        return np;
    }

    @Override
    public void setModel(Song s) {
        if (s instanceof SongRepeats) {
            song = (SongRepeats)s;
        }
        else
            super.setModel(s);
    }
}
