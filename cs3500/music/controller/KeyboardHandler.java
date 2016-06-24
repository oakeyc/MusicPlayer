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

    /**
     * Invoked when a key has been typed. See the class description for {@link KeyEvent} for a
     * definition of a key typed event.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        keyTyped.get(e.getKeyCode()).run();
    }

    /**
     * Invoked when a key has been pressed. See the class description for {@link KeyEvent} for a
     * definition of a key pressed event.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KEY PRESSED : " + e.getKeyCode());
        keyPressed.get(e.getKeyCode()).run();
    }

    /**
     * Invoked when a key has been released. See the class description for {@link KeyEvent} for a
     * definition of a key released event.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed.get(e.getKeyCode()).run();
    }

    public void setKeyTypedMap(Map<Integer,Runnable> keyTypedMap) {
        this.keyTyped = keyTypedMap;
    }

    public void setKeyPressedMap(Map<Integer,Runnable> keyPressedMap) {
        this.keyPressed = keyPressedMap;
    }

    public void setKeyReleasedMap(Map<Integer,Runnable> keyReleasedMap) {
        this.keyReleased = keyReleasedMap;
    }
}
