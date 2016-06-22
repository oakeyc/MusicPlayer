package cs3500.music.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cs3500.music.model.Pitch;
import cs3500.music.view.gui.NotePanel;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 * Created by Courtney on 6/20/2016.
 */
public class MouseHandler implements MouseListener {

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
}
