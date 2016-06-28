package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.VK_LEFT;

/**
 * Created by Courtney on 6/20/2016.
 * Represents a KeyboardHandler
 * and implements KeyListener
 */
public class KeyboardHandler implements KeyListener {
    // represents the possible functions, handles key strokes
    Map<Integer, Runnable> keyPressed;
    Map<Integer, Runnable> keyReleased;
    Map<Integer, Runnable> keyTyped;

    /**
     * Secondary constructor.
     */
    public KeyboardHandler() {
        keyPressed = new HashMap<Integer, Runnable>();
        keyReleased = new HashMap<Integer, Runnable>();
        keyTyped = new HashMap<Integer, Runnable>();
    }

    /***
     * Primary constructor.
     * @param pres
     * @param rel
     * @param typ
     */
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

    }

    /**
     * sets the keytyped map
     * @param keyTypedMap  the map to set it to
     */
    protected void setKeyTypedMap(Map<Integer, Runnable> keyTypedMap) {
        this.keyTyped = keyTypedMap;
    }

    /**
     * sets the key pressed map
     * @param keyPressedMap   the map to set it to
     */
    protected void setKeyPressedMap(Map<Integer, Runnable> keyPressedMap) {
        this.keyPressed = keyPressedMap;
    }

    /**
     * sets the key realesed map
     * @param keyReleasedMap   the map to set it to
     */
    protected void setKeyReleasedMap(Map<Integer, Runnable> keyReleasedMap) {
        this.keyReleased = keyReleasedMap;
    }
}
