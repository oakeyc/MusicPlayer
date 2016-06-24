package cs3500.music.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import cs3500.music.model.Pitch;
import cs3500.music.view.gui.NotePanel;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 * Created by Courtney on 6/20/2016.
 */
public class MouseHandler implements MouseListener {

    Map<MouseEvent, Runnable> mouseClicked;
    Map<MouseEvent, Runnable> mousePressed;
    Map<MouseEvent, Runnable> mouseReleased;

    public MouseHandler() {
        mouseClicked = new HashMap<MouseEvent, Runnable>();
        mousePressed = new HashMap<MouseEvent, Runnable>();
        mouseReleased = new HashMap<MouseEvent, Runnable>();
    }

    public String update(){
        return "";
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
            int beat = e.getX() / NotePanel.widthOfNote;
            int pitch = e.getY() / NotePanel.heightOfNote; // starts at high

            // look at page for what he wants

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

    public void setMouseReleasedMap(Map<MouseEvent, Runnable> mouseReleasedMap) {
        this.mouseReleased = mouseReleasedMap;
    }

    public void setMousePressedMap(Map<MouseEvent, Runnable> mousePressedMap) {
        this.mousePressed = mousePressedMap;
    }

    public void setMouseClickedMap(Map<MouseEvent, Runnable> mouseClickedMap) {
        this.mouseClicked = mouseClickedMap;
    }
}
