package cs3500.music.controller;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.gui.ScrollDir;

import static java.awt.event.KeyEvent.*;


/**
 * Primary controller class. Controller has a Model and a View that it runs.
 *
 * Created by Courtney & Ian on 6/7/2016.
 */
public class MusicController {
    protected Song.Builder model;
    protected IMusicView view;

    /**
     * Creates an instance of MusicController
     */
    public MusicController(Song.Builder model, IMusicView view) {
        this.model = model;
        this.view = view;

        configureKeyBoardListener();
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

    /**
     * Configures the KeyboardListener maps
     * with Integer Key representations
     * and respective Runnable()s
     */
    private void configureKeyBoardListener() {
        Map<Integer, Runnable> keyTypes = new HashMap<Integer, Runnable>();
        Map<Integer, Runnable> keyPresses = new HashMap<Integer, Runnable>();
        Map<Integer, Runnable> keyReleases = new HashMap<Integer, Runnable>();

        keyPresses.put(VK_LEFT, new Runnable() {
            public void run() {
                view.scroll(ScrollDir.LEFT);
            }
        });

        keyPresses.put(VK_RIGHT, new Runnable() {
            public void run() {
                view.scroll(ScrollDir.RIGHT);
            }
        });

        keyPresses.put(VK_SPACE, new Runnable() {
            public void run() {
                view.playPause();
            }
        });

        keyPresses.put(VK_END, new Runnable() {
            public void run() {
                view.scroll(ScrollDir.END);
            }
        });

        keyPresses.put(VK_HOME, new Runnable() {
            public void run() {
                view.scroll(ScrollDir.HOME);
            }
        });

        KeyboardHandler kbd = new KeyboardHandler(keyPresses, keyReleases, keyTypes);
//        kbd.setKeyTypedMap(keyTypes);
//        kbd.setKeyPressedMap(keyPresses);
//        kbd.setKeyReleasedMap(keyReleases);

        view.addKeyLis(kbd);
    }

    /**
     * Similar to configureKeyboardListener,
     * configures the maps of Mouse Integer reps
     * and respective Runnable()s
     */
    private void configureMouseListener() {
        Map someMap = new HashMap<Integer, Runnable>();

        someMap.put(MouseHandler.RIGHT, new RunnableRemove(view, model) {
        });

        someMap.put(MouseHandler.LEFT, new Runnable() {
            @Override
            public void run() {
                //MouseHandler.addNoteHandler(model, view);
                //model.addNote(view.isANote(x, y));  // FIXME: 6/25/2016 Need addNote(Note) function?
            }
        });

        someMap.put(MouseHandler.CENTER, new Runnable() {
            @Override
            public void run() {
                // something else
            }
        });

        MouseHandler msh = new MouseHandler(someMap);

        view.addMouseLis(msh);
    }

    /**
     * Depricated? 
     */
    public void stop() {
        view.playPause();
    } // FIXME: 6/25/2016
}
