package cs3500.music.controller;

import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.gui.GuiView;

/**
 * Created by Courtney on 6/21/2016.
 */
public class MusicControllerGui extends MusicController {

    //    protected Map<Integer, Runnable> keyPressed;
//    protected Map<Integer, Runnable> keyReleased;
//    protected Map<Integer, Runnable> keyTyped;
    protected GuiView gV;
    protected KeyboardHandler key;

    /**
     * Creates an instance of MusicController
     */
    public MusicControllerGui(Song.Builder model, IMusicView view) {
        super(model, view);
        gV = null;
    }

    public MusicControllerGui(Song.Builder model, GuiView view) {
        super(model, view);
        gV = view;
        key = new KeyboardHandler();
        gV.addKeyListener(key);
        gV.addMouseListener(this);
    }

    public void stop() {
        gV.stop();
    }
}