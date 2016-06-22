package cs3500.music.view.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;

/**
 * draws the notes in a grid like fashion
 */
public class NotePanel extends JPanel implements ActionListener {

    private int range;
    private Note low;
    private Note high;
    private List<Beat> notes;
    public static int heightOfNote;
    public static int widthOfNote = 30;
    private Timer time;
    private int posOfCurrLine;
    private int counter;
    private int firstX;
    private int lastX;
    private int firstBeat;
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
        widthOfNote = 30;
        heightOfNote = (int) (Math.floor(getHeight() * 1.0 / range));
        // set values
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        time = new Timer(tempo / 1000, this);
        time.start();
        posOfCurrLine = 0;
        counter = 0;
        firstX = 0;
        lastX = getWidth()/widthOfNote;
        firstBeat = 0;

        MouseHandler mouse = new MouseHandler();
        this.addMouseListener(mouse);
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
        for (int i = 0; i < getVisibleRect().getWidth(); i += 4) { // FIXME fix to update
            g2.drawLine(firstX + i * widthOfNote, 0, firstX + i * widthOfNote, getHeight());
            revalidate();
        }
//        for (int i = 0; i < getWidth(); i += 4 * widthOfNote)
//            g2.drawLine(i, 0, i, getHeight());


        // draws horizontal Lines
        for (int i = 0; i < getHeight() - (getHeight() % range); i += heightOfNote) {
            g2.drawLine(0, i, notes.size() * widthOfNote, i);
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
        for (int i = firstBeat; i <= lastX; i++)
        { // FIXME fix to update
            for (Note n : notes.get(i).getNotes()) {
                if (n.getStart() == i)
                    g2.setColor(new Color(28, 92, 100)); // gray ish
                else
                    g2.setColor(new Color(158, 0, 236)); // purple
                // draws note
                g2.fillRect(firstX + widthOfNote * i,
                  heightOfNote * (high.getValue() - n.getValue() + 1),
                  firstX + widthOfNote, heightOfNote);
                revalidate();
            }
        }

    }

    public void stop() {
        time.stop();
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        firstX += widthOfNote;
        lastX++;
        firstBeat++;
        if ((this.getVisibleRect().getCenterX() + 200) - posOfCurrLine > .1)
            posOfCurrLine += widthOfNote;
        else { // scroll
            if (posOfCurrLine < getWidth())
                 posOfCurrLine += widthOfNote;
            counter += widthOfNote;
            Rectangle rect = new Rectangle(counter, 0,
              getWidth() + widthOfNote, getHeight());
            scrollRectToVisible(rect);
            revalidate();
        }
        repaint();
    }
}
