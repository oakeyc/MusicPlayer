package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

import static java.awt.event.KeyEvent.VK_LEFT;


/**
 * Primary controller class. Controller has a Model and a View that it runs.
 *
 * Created by Courtney on 6/7/2016.
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
//        configureKeyBoardListener();
//        this.view.addActionListener(this);
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

//    private void configureKeyBoardListener() {
//        Map<Integer, Runnable> keyTypes = new HashMap<>();
//        Map<Integer, Runnable> keyPresses = new HashMap<>();
//        Map<Integer, Runnable> keyReleases = new HashMap<>();
//        //Another possible syntax: instead of defining a new class, just to make a single instance,
//        // you can create an "anonymous class" that implements a particular interface, by writing
//        // "new Interfacename() { all the methods you need to implement }"
//        // Note that "view" is in scope inside this Runnable!  But, also note that within the Runnable,
//        // "this" refers to the Runnable and not to the Controller, so we don't say "this.view".
//        keyTypes.put(VK_LEFT, new Runnable() {
//            public void run() {
//                view.scroll("left");
//            }
//        });
//
//        KeyboardHandler kbd = new KeyboardHandler();
//        kbd.setKeyTypedMap(keyTypes);
//        kbd.setKeyPressedMap(keyPresses);
//        kbd.setKeyReleasedMap(keyReleases);
//
//        view.addKeyListener(kbd);
//    }
//
//
//    public void actionPerformed(ActionEvent e) {
//        switch (e.getActionCommand()) {
//            //read from the input textfield
//            case "Echo Button":
//                String text = view.getInputString();
//                //send text to the model
//                model.setString(text);
//
//                //clear input textfield
//                view.clearInputString();
//                //finally echo the string in view
//                text = model.getString();
//                view.setEchoOutput(text);
//
//                //set focus back to main frame so that keyboard events work
//                view.resetFocus();
//
//                break;
//            case "Exit Button":
//                System.exit(0);
//                break;
//        }
//    }
//
//    // THESE CLASSES ARE NESTED INSIDE THE CONTROLLER,
//    // SO THAT THEY HAVE ACCESS TO THE VIEW
//    class MakeCaps implements Runnable {
//        public void run() {
//            String text = model.getString();
//            text = text.toUpperCase();
//            view.setEchoOutput(text);
//        }
//    }
//
//    class MakeOriginalCase implements Runnable {
//        public void run() {
//            String text = model.getString();
//            view.setEchoOutput(text);
//        }
//    }
}
