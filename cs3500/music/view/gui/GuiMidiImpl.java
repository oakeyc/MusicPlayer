package cs3500.music.view.gui;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.model.Song;

/**
 * Created by Courtney on 6/20/2016.
 */
public class GuiMidiImpl extends GuiViewFrame {

    private MidiGui midi;
//    private MouseListener mLis;
//    private KeyListener kLis;

    public GuiMidiImpl() {
        super();
        midi = new MidiGui();
//        kLis = new KeyboardHandler();
//        mLis = new MouseHandler();
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

    public void playPause() {
        super.playPause();
        midi.playPause();
    }

    @Override
    public void addKeyLis(KeyboardHandler kbd) {
//        super.addKeyLis(kbd);
//        midi.addKeyLis(kbd);
    }
}
