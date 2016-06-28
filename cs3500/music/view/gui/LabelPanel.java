package cs3500.music.view.gui;

import java.awt.*;

import javax.swing.*;

import cs3500.music.model.Note;

/**
 * this panel displays the String representation of the notes Created by Courtney on 6/15/2016.
 */
public class LabelPanel extends JPanel {

    private Note low; // the lowest represented note
    private Note high; // the highest represented note

    /**
     * constructor
     *
     * @param low  the lowest note in the song
     * @param high the highest note in the song
     */
    public LabelPanel(Note low, Note high) {
        this.low = low;
        this.high = high;

        this.setPreferredSize(new Dimension(NotePanel.widthOfNote, 100));
    }

    /**
     * draws on the labels as string to the side in proportion to the range
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Note temp = high;
        int counter = 0;
        // draws on the strings for the notes
        while (temp.getValue() >= low.getValue()) {
            g2.drawString(temp.toString(), 5,
              NotePanel.heightOfNote * counter +
                (NotePanel.heightOfNote / 2));

            temp = Note.fromValue(temp.getValue() - 1);
            counter++;
        }
        repaint();
    }

}
