package cs3500.music.view.gui;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import cs3500.music.model.Song;
import cs3500.music.view.MidiView;

/**
 * Created by Courtney on 6/20/2016.
 */
public class GuiMidiImpl extends GuiViewFrame {

    private MidiView midi;
    private MouseListener mLis;
    private KeyListener kLis;

    public GuiMidiImpl() {
        super();
        midi = new MidiView();
        kLis = new KeyHandler();
        mLis = new MouseHandler();
    }
    /**
     * Sets the model for the view based on an model given as input.
     */
    @Override
    public void setModel(Song.Builder model) {
        super.setModel(model);
        midi.setModel(model);
    }

    /**
     * Method for rendering the view Displays either text, gui, or midi output.
     */
    @Override
    public void render() {
        super.render();
        midi.render();
    }
}
