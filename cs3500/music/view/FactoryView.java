package cs3500.music.view;

import cs3500.music.view.gui.GuiMidiImpl;
import cs3500.music.view.gui.GuiViewFrame;

/**
 * Class to represent the View factory method. Created by Ian Leonard on 6/17/2016.
 */
public class FactoryView {

    /**
     * represents all the types of viewing
     */
    public enum MusicViewType {
        text, midi, gui;
    }

    /**
     * Returns a new View based on text input from args[]
     *
     * @param view which view wanted
     * @return the instance of the view
     */
    public static IMusicView viewPicker(String view) {
        switch (view) {
            case "console":
                return new TextView();
            case "midi":
                return new MidiView();
            case "visual":
                return new GuiViewFrame();
            case "combine":
                return new GuiMidiImpl();
            default:
                throw new IllegalArgumentException("Invalid View Type");
        }
    }
}
