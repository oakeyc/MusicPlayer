package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.Song;

/**
 * A dummy view that simply draws a string
 */
public class NotePanel extends JPanel {

    private int range;
    private Note low;
    private Note high;
    private int height;
    private int width;
    public static int heightOfNote;
    public static int widthOfNOte = 40;


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
        this.range = high.getValue() - low.getValue() + 1;
        this.low = low;
        this.high = high;
    }

    public int getRange() {
        return range;
    }


    @Override
    public void paintComponent(Graphics g) {
        heightOfNote = (int)(Math.ceil(getHeight() * 1.0 / range));
        widthOfNOte = 40;

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.CYAN);
        g2.drawLine(2, 0, 2, getHeight()); // current line

        g2.setColor(Color.BLACK);
        // draws the vertical lines
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < getWidth(); i += widthOfNOte * 4)
            g2.drawLine(i, 0, i, getHeight());

        // draws horizontal Lines
        for (int i = 0; i < getHeight(); i += heightOfNote) {
            g2.drawLine(0, i, getWidth(), i);
        }

        drawNotes(g2);

        repaint();
    }

    private void drawNotes(Graphics2D g2) {

        // draws notes
        ArrayList<Beat> b = new ArrayList<Beat>();
        Beat beat = new Beat();
        Beat beat2 = new Beat();

        for (int i = 0; i < 10; i++)
            b.add(new Beat());

        Song s = new Song(b);
        s.addNote(new Note(Pitch.C, 4, 2, 0));
        s.addNote(new Note(Pitch.A, 3, 6, 3));
        s.addNote(new Note(Pitch.Gs, 3, 1, 0));
        s.addNote(new Note(Pitch.C, 4, 6, 2));
        s.addNote(new Note(Pitch.As, 3, 3, 3));

//---------------------------------- Real code --------------------------
        // needs some sort of list to iterate through
        for (int i = 0; i < b.size(); i++) {
            for (Note n : b.get(i).getNotes()) {
                if (n.getStart() == i)
                    g2.setColor(new Color(28, 92, 100));
                else
                    g2.setColor(new Color(158, 0, 236)); // purple
                g2.fillRect(widthOfNOte * i, heightOfNote * (n.getValue() - low.getValue()),
                  widthOfNOte, heightOfNote);
            }
        }

    }

}
