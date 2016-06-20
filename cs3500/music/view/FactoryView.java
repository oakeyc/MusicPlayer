package cs3500.music.view;

import cs3500.music.model.Song;

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
    public static IMusicView viewPicker(String view) { // FIXME: 6/17/2016
        switch (view) {
            case "console":
                return new TextView();
            case "midi":
                return new MidiView();
            case "visual":
                return new GuiViewFrame();
            default:
                throw new IllegalArgumentException("Invalid View Type");
        }
    }
}
