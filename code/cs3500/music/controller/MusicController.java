package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.gui.GuiMidiImpl;
import cs3500.music.view.gui.GuiView;
import cs3500.music.view.gui.ScrollDir;

import static java.awt.event.KeyEvent.*;
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;


/**
 * Primary controller class. Controller has a Model and a View that it runs.
 *
 * Created by Courtney & Ian on 6/7/2016.
 */
public class MusicController implements MouseListener {
    protected Song.Builder model;
    protected IMusicView view;

    /**
     * Creates an instance of MusicController
     */
    public MusicController(Song.Builder model, IMusicView view) {
        this.model = model;
        this.view = view;

        if (view instanceof GuiView) {
            GuiView gv = (GuiView) view;
            gv.addingLis((ActionEvent e) -> {
                Note add = gv.getInputNote();
                System.out.println("NOTE : " + add);
                this.model.addFullNote(add);
                this.view.render();
            });
        }
        this.view.addMouseLis(this);
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
     * Configures the KeyboardListener maps with Integer Key representations and respective
     * Runnable()s
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

        keyPresses.put(VK_DOWN, () -> {
            view.scroll(ScrollDir.DOWN);
        });
        KeyboardHandler kbd = new KeyboardHandler(keyPresses, keyReleases, keyTypes);

        view.addKeyLis(kbd);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        GuiView gv = (GuiView) view;
        if (true) // check if started
            if (isRightMouseButton(e)) {
                /// something
            } else if (isLeftMouseButton(e)) { // remove note
                Note remove = view.isANote(e.getX(), e.getY());
                model.remove(remove);
            } else if (isMiddleMouseButton(e)) { // does something else
                // something
            }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
