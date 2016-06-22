package cs3500.music.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.gui.GuiView;
import cs3500.music.view.gui.KeyHandler;
import cs3500.music.view.gui.NotePanel;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 * Created by Courtney on 6/21/2016.
 */
public class MusicControllerGui extends MusicController implements MouseListener {

//    protected Map<Integer, Runnable> keyPressed;
//    protected Map<Integer, Runnable> keyReleased;
//    protected Map<Integer, Runnable> keyTyped;
    protected GuiView gV;
    protected KeyHandler key;

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
        key = new KeyHandler();
        gV.addKeyListener(key);
        gV.addMouseListener(this);
    }

    public void stop() {
        gV.stop();
    }


    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        if (isRightMouseButton(e)) { // add note??
//            int beat = e.getX() / NotePanel.widthOfNote;
//            int pitch = e.getY() / NotePanel.heightOfNote; // starts at high

        } else if (isLeftMouseButton(e)) { // remove note
            Note remove= gV.isANote(e.getX(), e.getY());
            if (remove != null) {
                model.remove(remove);
            }
        } else if (isMiddleMouseButton(e)) { // does something else

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
