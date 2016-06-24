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

    public Map<Integer, Runnable> getKeyPressed() {
        return keyPressed;
    }

    public void setKeyPressed(Map<Integer, Runnable> keyPressed) {
        this.keyPressed = keyPressed;
    }

    public Map<Integer, Runnable> getKeyReleased() {
        return keyReleased;
    }

    public void setKeyReleased(Map<Integer, Runnable> keyReleased) {
        this.keyReleased = keyReleased;
    }

    public Map<Integer, Runnable> getKeyTyped() {
        return keyTyped;
    }

    public void setKeyTyped(Map<Integer, Runnable> keyTyped) {
        this.keyTyped = keyTyped;
    }


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

    /**
     * Creates and sets a keyboard listener for the view. In effect it creates snippets of code as
     * Runnable object, one for each time a key is typed, pressed and released, only for those that
     * the program needs.
     *
     * In this example, we need to toggle color when user TYPES 'd', make the message all caps when
     * the user PRESSES 'c' and reverts to the original string when the user RELEASES 'c'. Thus we
     * create three snippets of code (ToggleColor,MakeCaps and MakeOriginalCase) and put them in the
     * appropriate map.
     *
     * Last we create our KeyboardListener object, set all its maps and then give it to the view.
     */
    private void configureKeyBoardListener() {


        // Another possible syntax: instead of defining a new class, just to make a single instance,
        // you can create an "anonymous class" that implements a particular interface, by writing
        // "new Interfacename() { all the methods you need to implement }"
        // Note that "view" is in scope inside this Runnable!  But, also note that within the Runnable,
        // "this" refers to the Runnable and not to the Controller, so we don't say "this.view".
        keyTyped.put(VK_LEFT, () -> {

            System.out.println("LEFT");
        });

    }

    protected void setKeyTypedMap(Map<Integer,Runnable> keyTypedMap) {
        this.keyTyped = keyTypedMap;
    }

    protected void setKeyPressedMap(Map<Integer,Runnable> keyPressedMap) {
        this.keyPressed = keyPressedMap;
    }

    protected void setKeyReleasedMap(Map<Integer,Runnable> keyReleasedMap) {
        this.keyReleased = keyReleasedMap;
    }
}
