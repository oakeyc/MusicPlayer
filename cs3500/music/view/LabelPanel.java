package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.music.model.Note;

/** this panel displays the String representation of the notes
 * Created by Courtney on 6/15/2016.
 */
public class LabelPanel extends JPanel {

    private Note low; // the lowest represented note
    private Note high; // the highest represented note

    /**
     * constructor
     * @param low      the lowest note in the song
     * @param high     the highest note in the song
     */
    public LabelPanel(Note low, Note high) {
        this.low = low;
        this.high = high;

        this.setPreferredSize(new Dimension(30, 100));
    }

    /**
     * draws on the labels as string to the side in proportion to the range
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int range = high.getValue() - low.getValue();

        Note temp = low;
        int counter = 1;

        while (temp.getValue() <= high.getValue()) {
            g2.drawString(temp.toString(), 10, NotePanel.heightOfNote * counter - (NotePanel.heightOfNote / 2));

            temp = Note.fromValue(temp.getValue() + 1);
            counter++;
        }
    }

}
