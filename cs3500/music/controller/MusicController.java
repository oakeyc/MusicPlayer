package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Beat;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.TextView;
import cs3500.music.view.gui.NotePanel;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 * Primary controller class. Controller has a Model and a View that it runs.
 *
 * Created by Courtney on 6/7/2016.
 */
public class MusicController {
    Song.Builder model;
    IMusicView view;

    /**
     * Creates an instance of MusicController
     */
    public MusicController(Song.Builder model, IMusicView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Sets the model of the given view.
     */
    public void modelToView() {
        view.setModel(model);
    }

    /**
     * primary play method called by MusicEditor, calls render() in respective view.
     */
    public void play() {
        view.setModel(model);
        view.render();
    }

}
