package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.MidiView;
import cs3500.music.view.gui.GuiView;
import cs3500.music.view.gui.ScrollDir;


import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;


/**
 * Primary controller class. Controller has a Model and a View that it runs.
 *
 * Created by Courtney & Ian on 6/7/2016.
 */
public class MusicController {
    protected Song.Builder model;
    protected GuiView view;

    public MusicController(Song.Builder model, IMusicView v) {
        this.model = model;
        view = (GuiView) v; // FIXME
    }

    /**
     * Creates an instance of MusicController
     */
    public MusicController(Song.Builder model, GuiView view) {
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
    private void configureKeyBoardListener() {
        Map<Integer, Runnable> keyTypes = new HashMap<>();
        Map<Integer, Runnable> keyPresses = new HashMap<>();
        Map<Integer, Runnable> keyReleases = new HashMap<>();

        keyTypes.put(VK_LEFT, new Runnable() {
            public void run() {
                view.scroll(ScrollDir.LEFT);
            }
        });

        keyTypes.put(VK_RIGHT, new Runnable() {
            public void run() {
                view.scroll(ScrollDir.RIGHT);
            }
        });

        keyTypes.put(VK_SPACE, new Runnable() {
            public void run() {
                view.playPause();
            }
        });


        keyPresses.put(VK_LEFT, new Runnable() {
            public void run() {
                System.out.println("LEFT ARROW");
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


        KeyboardHandler kbd = new KeyboardHandler();
        kbd.setKeyTypedMap(keyTypes);
        kbd.setKeyPressedMap(keyPresses);
        kbd.setKeyReleasedMap(keyReleases);

        view.addKeyListener(kbd);
    }

    private void configureMouseListener() {
        Map<MouseEvent, Runnable> mouseClicks = new HashMap<>();
        Map<MouseEvent, Runnable> mousePresses = new HashMap<>();
        Map<MouseEvent, Runnable> mouseReleases = new HashMap<>();

//        mouseClicks.put(MouseEvent.MOUSE_CLICKED, new Runnable() {
//            public void run() {
//                model.remove(view.isANote(???, ???))
//            }
//        });
//
//        mousePresses.put(MouseEvent.MOUSE_PRESSED, new Runnable() {
//            public void run() {
////                ???
//            }
//        });
//
//        mouseReleases.put(MouseEvent.MOUSE_RELEASED, new Runnable() {
//            public void run() {
////                ???
//            }
//        });

        MouseHandler msh = new MouseHandler();
        msh.setMouseClickedMap(mouseClicks);
        msh.setMousePressedMap(mousePresses);
        msh.setMouseReleasedMap(mouseReleases);

        view.addMouseListener(msh);
    }

    public void stop() {
        view.playPause();
    }
}
