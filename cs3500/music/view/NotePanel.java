package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.swing.*;

import cs3500.music.model.Accidental;
import cs3500.music.model.MusicType;
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
       this(new Note(Pitch.E, Accidental.natural, 3, 1, 0),
          new Note(Pitch.G, Accidental.natural, 4, 1, 0));
    }

    private NotePanel(Note low, Note high) {
        super();
        setNoteRange(low, high);
        setBackground(Color.WHITE);
    }


    public void setNoteRange(Note low, Note high)
    {
        this.range = high.getValue() - low.getValue();
        this.low = (Note) low;
        this.high = (Note) high;
    }

    public int getRange() {
        return range;
    }

    public void drawLines(int height, int width) {
//        this.height = height;
//        this.width = width;
        repaint();
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
        g2.drawLine(getWidth() / 8, 0, getWidth() / 8, getHeight()); // current line

        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < getWidth() ; i+=100)
            g2.drawLine(i, 0 , i, getHeight());

    }

}
