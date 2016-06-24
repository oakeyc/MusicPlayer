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

//    Map<MouseEvent, Runnable> mouseClicked;
//    Map<MouseEvent, Runnable> mousePressed;
//    Map<MouseEvent, Runnable> mouseReleased;
    Map<Integer, Runnable> buttons; // The keys are the buttons
    // 0 is right, 1 is left, and 2 is center
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int CENTER = 2;

    public MouseHandler(Map<Integer, Runnable> b) {
        buttons = b;
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
            buttons.get(0).run();
        } else if (isLeftMouseButton(e)) { // remove note
            buttons.get(1).run();

        } else if (isMiddleMouseButton(e)) { // does something else
            buttons.get(2).run();
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
