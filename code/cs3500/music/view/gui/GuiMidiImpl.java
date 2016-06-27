package cs3500.music.view.gui;

import java.awt.event.KeyListener;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.model.Song;

/** represents a combined view of GUI and Midi
 * Created by Courtney on 6/20/2016.
 */
public class GuiMidiImpl extends GuiViewFrame {

    protected MidiGui midi;
    // constructor
    public GuiMidiImpl() {
        super();
        midi = new MidiGui();
    }
    /**
     * Sets the model for the view based on an model given as input.
     */
    @Override
    public void setModel(Song model) {
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

    /**
     * plays and pauses the view
     */
    public void playPause() {
        super.playPause();
        midi.playPause();
    }

    /**
     * redraws the views after changes to the model
     */
    @Override
    public void reDraw(){
        super.reDraw();
        midi.reDraw();
    }

    /**
     * adds a keyListener
     * @param kbd   keylisterner to add
     */
    @Override
    public void addKeyLis(KeyListener kbd) {
        super.addKeyLis(kbd);
    }
}
