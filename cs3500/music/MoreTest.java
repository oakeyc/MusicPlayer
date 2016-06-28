package cs3500.music;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.controller.MusicController;
import cs3500.music.model.*;
import cs3500.music.view.IMusicView;
import cs3500.music.view.gui.GuiMidiImpl;
import cs3500.music.view.gui.GuiView;
import cs3500.music.view.gui.GuiViewFrame;
import cs3500.music.view.gui.NotePanel;
import cs3500.music.view.gui.ScrollDir;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_HOME;
import static org.junit.Assert.assertEquals;

/**
 * Created by IanLeonard on 6/25/2016.
 */
public class MoreTest {
    KeyboardHandler kbd;
    GuiView view;
    Song.Builder model;
    MusicController controller;


    private void init2() {

        Song.Builder model = new Song.Builder(new Song());
        model.addNote(0, 5, 2, 50, 2);
        model.addNote(10, 5, 2, 50, 2);
        model.addNote(20, 5, 2, 50, 2);

        GuiViewFrame view = new GuiViewFrame();

        MusicController controller = new MusicController(model.build(), view);
        Map<Integer, Runnable> keyTypes = new HashMap<Integer, Runnable>();
        Map<Integer, Runnable> keyPresses = new HashMap<Integer, Runnable>();
        Map<Integer, Runnable> keyReleases = new HashMap<Integer, Runnable>();

        keyPresses.put(VK_LEFT, new Runnable() {
            public void run() {
                System.out.println("LEFT ARROW");
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


        KeyboardHandler kbd = new KeyboardHandler(keyPresses, keyReleases, keyTypes);


    }

    @Test
    public void testKeyboardHandler() throws AWTException {
        init2();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SPACE);

        assertEquals(view.getDisp().isStopped(), true);
    }

    @Test
    public void testKeyboardHandler2() throws AWTException {
        init2();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_HOME);

        assertEquals(view.getDisp().saveCurr, 0);
    }

    @Test
    public void testKeyboardHandler3() throws AWTException {
        init2();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);

        assertEquals(view.getDisp().saveCurr, view.getDisp().getWidth()
          - GuiViewFrame.windowWidth);
    }

    @Test
    public void testController2() {
        init2();

        assertEquals(controller.getKBL(), kbd);
    }

    @Test
    public void testController3() {
        init2();

        controller.modelToView();

        assertEquals(controller.getSong(), model);
    }
}

