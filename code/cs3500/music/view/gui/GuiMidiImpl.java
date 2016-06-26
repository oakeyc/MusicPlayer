package cs3500.music.view.gui;

import java.awt.event.KeyListener;

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
        midi = new MidiGui(this);
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
    public void render()  {
        midi.render();
        super.render();

        midi.close();
    }

    public void playPause() {
        super.playPause();
        midi.playPause();
    }

    @Override
    public void reDraw(){
        super.reDraw();
        midi.reDraw();
    }


    @Override
    public void addKeyLis(KeyListener kbd) {
        super.addKeyLis(kbd);
//        midi.addKeyLis(kbd);
    }
}
