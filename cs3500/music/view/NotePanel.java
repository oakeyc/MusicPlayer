package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.music.model.Note;
import cs3500.music.model.Pitch;

/**
 * A dummy view that simply draws a string
 */
public class NotePanel extends JPanel {

    private int range;
    private Note low;
    private Note high;
    private int height;
    private int width;


    public NotePanel() {
        this(new Note(Pitch.E, 3, 1, 0),
          new Note(Pitch.G, 4, 1, 0));
    }

    private NotePanel(Note low, Note high) {
        super();
        setNoteRange(low, high);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

    }


    public void setNoteRange(Note low, Note high) {
        this.range = high.getValue() - low.getValue();
        this.low = low;
        this.high = high;
    }

    public int getRange() {
        return range;
    }


    @Override
    public void paintComponent(Graphics g) {
        // Handle the default painting
        super.paintComponent(g);
        // Look for more documentation about the Graphics class,
        // and methods on it that may be useful
//        g.drawString("Hello World", 25, 25);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.CYAN);
        g2.drawLine(1, 0, 1, getHeight()); // current line

        g2.setColor(Color.BLACK);
        // draws the vertical lines
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < getWidth(); i += 300)
            g2.drawLine(i, 0, i, getHeight());

        // draws horizontal Lines
        for (int i = 0; i < getHeight(); i += getHeight()/range) {
            g2.drawLine(0, i, getWidth(), i);
        }
        repaint();
    }

}
