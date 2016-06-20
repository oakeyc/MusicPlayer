package cs3500.music.view.gui;

import java.awt.event.KeyEvent;
import java.util.Map;

/**
 * Created by Courtney on 6/20/2016.
 */
public class KeyHandler implements java.awt.event.KeyListener {
    // represents the possible functions, handles key strokes
    Map<Integer, Runnable> keyPressed;
    Map<Integer, Runnable> keyReleased;
    Map<Integer, Runnable> keyTyped;

    public Runnable getRunnableRel(Integer i) {
        return keyReleased.get(i);
    }

    public void putRel(Integer key, Runnable val) {
        this.keyReleased.put(key, val);
    }

    public Runnable getRunnablePres(Integer i) {
        return keyPressed.get(i);
    }

    public void putPres(Integer key, Runnable val) {
        this.keyPressed.put(key, val);
    }

    public Runnable getRunnableType(Integer i) {
        return keyTyped.get(i);
    }

    public void putType(Integer key, Runnable val) {
        this.keyTyped.put(key, val);
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
}
