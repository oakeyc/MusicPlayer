package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.music.model.Note;

/**
 * Created by Courtney on 6/15/2016.
 */
public class LabelPanel extends JPanel {

    private Note low;
    private Note high;

    public LabelPanel(Note low, Note high) {

        this.low = low;
        this.high = high;

        this.setPreferredSize(new Dimension( 30, 100));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int range = high.getValue() - low.getValue();

        Note temp = low;
        int counter = 1;
        g2.setStroke(new BasicStroke(30));

        while (temp.getValue() <= high.getValue()) {
            g2.drawString(temp.toString(), 10, NotePanel.heightOfNote * counter - (NotePanel.heightOfNote / 2));

            temp = Note.fromValue(temp.getValue() + 1);
            counter++;
        }
    }

}
