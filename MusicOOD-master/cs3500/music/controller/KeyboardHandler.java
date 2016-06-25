package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.VK_LEFT;

/**
 * Created by Courtney on 6/20/2016.
 */
public class KeyboardHandler implements KeyListener {
    // represents the possible functions, handles key strokes
    Map<Integer, Runnable> keyPressed;
    Map<Integer, Runnable> keyReleased;
    Map<Integer, Runnable> keyTyped;

    public KeyboardHandler() {
        keyPressed = new HashMap<Integer, Runnable>();
        keyReleased = new HashMap<Integer, Runnable>();
        keyTyped = new HashMap<Integer, Runnable>();
    }

    public KeyboardHandler(Map<Integer, Runnable> pres, Map<Integer, Runnable> rel,
                           Map<Integer, Runnable> typ) {
        keyPressed = pres;
        keyReleased = rel;
        keyTyped = typ;
    }

    /**
     * Invoked when a key has been typed. See the class description for {@link KeyEvent} for a
     * definition of a key typed event.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (keyTyped.containsKey(e.getKeyCode())) {
            keyTyped.get(e.getKeyCode()).run();
        }
    }

    /**
     * Invoked when a key has been pressed. See the class description for {@link KeyEvent} for a
     * definition of a key pressed event.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (keyPressed.containsKey(e.getKeyCode())) {
            keyPressed.get(e.getKeyCode()).run();
        }
    }

    /**
     * Invoked when a key has been released. See the class description for {@link KeyEvent} for a
     * definition of a key released event.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (keyReleased.containsKey(e.getKeyCode())) {
            keyReleased.get(e.getKeyCode()).run();
        }
    }

    protected void setKeyTypedMap(Map<Integer, Runnable> keyTypedMap) {
        this.keyTyped = keyTypedMap;
    }

    protected void setKeyPressedMap(Map<Integer, Runnable> keyPressedMap) {
        this.keyPressed = keyPressedMap;
    }

    protected void setKeyReleasedMap(Map<Integer, Runnable> keyReleasedMap) {
        this.keyReleased = keyReleasedMap;
    }
}
