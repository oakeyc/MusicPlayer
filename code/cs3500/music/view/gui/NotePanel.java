package cs3500.music.view.gui;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RunnableFuture;


import javax.swing.*;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.controller.MouseHandler;
import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import javafx.scene.media.SubtitleTrack;

import static java.awt.event.KeyEvent.VK_END;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;

/**
 * draws the notes in a grid like fashion
 */
public class NotePanel extends JPanel implements ActionListener {

    private int range;
    private Note low;
    private Note high;
    private List<Beat> notes;
    public static int heightOfNote; // perhaps hard code something
    public static int widthOfNote = 40;
    private Timer time;
    private int posOfCurrLine;
    private int counter;
    private boolean isStopped;
    private boolean auto;
    private int saveCurr;

//    private Boolean removeNote;
//    private Note toRemove;

    /**
     * constructor
     *
     * @param low  the lowest note in the song
     * @param high the highest note in the song
     */
    public NotePanel(Note low, Note high, List<Beat> notes, int tempo) {// tempo is millisec
        super();
        // initialize
        this.range = high.getValue() - low.getValue() + 1; // to include start and finish
        this.low = low;
        this.high = high;
        this.notes = notes;
        widthOfNote = 40;
        heightOfNote = (int) (Math.floor(getHeight() * 1.0 / range));
        // set values
        setBackground(Color.PINK);
        setLayout(new BorderLayout());
        time = new Timer(tempo / 1000, this);
        time.start();
        isStopped = false;

        auto = true;
        posOfCurrLine = 0;
        counter = 0;

        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        heightOfNote = (int) (Math.floor(getHeight() * 1.0 / range));

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.CYAN);
        g2.drawLine(posOfCurrLine, 0, posOfCurrLine, getHeight()); // current line

        g2.setColor(Color.BLACK);
        // draws the vertical lines
        g2.setStroke(new BasicStroke(1));
        for (int i = 0; i < GuiViewFrame.windowWidth; i += 4 * widthOfNote) {
            // draw on visible part
            g2.drawLine((int) getVisibleRect().getX() + i, 0,
              (int) getVisibleRect().getX() + i, getHeight());
            revalidate();
        }

        // draws horizontal Lines
        for (int i = 0; i < getHeight() - (getHeight() % range); i += heightOfNote) {
            g2.drawLine((int) getVisibleRect().getX(), i,
              (int) getVisibleRect().getX() + GuiViewFrame.windowWidth, i);
            revalidate();
        }

        // draws notes on
        drawNotes(g2);

        repaint();
    }

    /**
     * draws the notes on
     *
     * @param g2 the graphics instance
     */
    private void drawNotes(Graphics2D g2) {
        for (int i = (int) getVisibleRect().getX() / widthOfNote;
             i < notes.size() && i < ((int) getVisibleRect().getX() +
               GuiViewFrame.windowWidth) / widthOfNote; i++) { // FIXME fix to update
            for (Note n : notes.get(i).getNotes()) {
                if (n.getStart() == i)
                    g2.setColor(new Color(28, 92, 100)); // gray ish
                else
                    g2.setColor(new Color(158, 0, 236)); // purple
                // draws note

                g2.fillRect(i * widthOfNote, heightOfNote * (high.getValue() - n.getValue() + 1),
                  widthOfNote, heightOfNote);
                revalidate();
            }
        }
    }

    public void scroll(ScrollDir dir) {
        if (auto)
            saveCurr = counter;
        auto = false;
        switch (dir.getVal()) {
            case -1: // left
                saveCurr -= widthOfNote;
                scrollRectToVisible(
                  new Rectangle(saveCurr, 0, GuiViewFrame.windowWidth, getHeight()));
                break;
            case 1: // right
                saveCurr += widthOfNote;
                scrollRectToVisible(
                  new Rectangle(saveCurr, 0, GuiViewFrame.windowWidth, getHeight()));
                break;
            case 0: // home
                saveCurr = 0;
                scrollRectToVisible(new Rectangle(0, 0, GuiViewFrame.windowWidth, getHeight()));
                break;
            case 10: // end
                saveCurr = getWidth() - GuiViewFrame.windowWidth;
                scrollRectToVisible(new Rectangle(saveCurr, 0, getWidth(), getHeight()));
                break;
            case 2: // current line
                auto = true;
                scrollRectToVisible(
                  new Rectangle(counter, 0,
                    getWidth(), getHeight()));
                break;
            default:
                throw new IllegalArgumentException("Not a scrolling direction");

        }
    }

    public void playPause() {
        if (!isStopped)
            time.stop();
        else
            time.start();
        isStopped = !isStopped;
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if ((GuiViewFrame.windowWidth - widthOfNote * 8) - posOfCurrLine >= 0) {
            posOfCurrLine += widthOfNote;
        } else { // scroll
            if (posOfCurrLine < getWidth())
                posOfCurrLine += widthOfNote;
            counter += widthOfNote;

            Rectangle rect = new Rectangle(counter, 0,
              getWidth() + widthOfNote, getHeight());
            if (auto)
                scrollRectToVisible(rect);

//            not();
            revalidate();
        }
        repaint();
    }

    public int getCount() {
        if (auto)
            return counter / widthOfNote;
        else
            return saveCurr / widthOfNote;
    }

}


