package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.music.model.Note;

/**
 * Created by Courtney on 6/15/2016.
 */
public class LabelPanel extends JPanel{

    public LabelPanel(Note low, Note high) {

        JPanel pitch = new JPanel();
        pitch.setBackground(Color.BLACK);
        BoxLayout lay = new BoxLayout(pitch, BoxLayout.Y_AXIS);
        pitch.setLayout(lay);

        Note temp = low;
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        int counter = 0;
        while (temp.getValue() <= high.getValue()) {
            JLabel l = new JLabel(temp.toString());
            l.setForeground(Color.WHITE);

            l.setFont(l.getFont().deriveFont(24.9f));
            pitch.add(l);
            temp = Note.fromValue(temp.getValue() + 1);
            counter++;
        }
        this.add(pitch, BorderLayout.WEST);
    }

}
