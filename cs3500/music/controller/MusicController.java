package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.gui.GuiView;
import cs3500.music.view.gui.NotePanel;

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

    /**
     * Creates an instance of MusicController
     */
    public MusicController(Song.Builder model, GuiView view) {
        this.model = model;
        this.view = view;

        configureKeyBoardListener();
        //this.view.addActionListener(this); // FIXME: 6/24/2016 WHAT IS THIS
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
                view.scroll(NotePanel.ScrollDir.LEFT);
            }
        });

        keyTypes.put(VK_RIGHT, new Runnable() {
            public void run() {
                view.scroll(NotePanel.ScrollDir.RIGHT);
            }
        });

        keyTypes.put(VK_SPACE, new Runnable() {
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
        Map someMap = new HashMap<Integer, Runnable>();

        someMap.put(MouseHandler.RIGHT, new Runnable() {

            @Override
            public void run() {
                // add something
            }
        });

        someMap.put(MouseHandler.LEFT, new Runnable() {
            @Override
            public void run() {
                // remove something
            }
        });

        someMap.put(MouseHandler.CENTER, new Runnable() {
            @Override
            public void run() {
                // something else
            }
        });


        MouseHandler msh = new MouseHandler(someMap);

        view.addMouseListener(msh);
    }


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //read from the input textfield
            case "Create Note":
                Note tempNote = view.getInputNote();
                //add note to model
                //model.addNote(tempNote);
                break;
            case "Exit Button":
                System.exit(0);
                break;
        }
    }
}
