package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Created by Courtney on 6/13/2016.
 */
public class NumberPanel extends JPanel {
    private StringBuilder str;
    private ArrayList<JLabel> nums;

    public NumberPanel() {
        super();
        str = new StringBuilder();
        setBackground(Color.GRAY);
        setLayout(new GridLayout(1, 100)); // change the cols
        this.setPreferredSize(new Dimension(10, 25));
//        nums = new ArrayList<JLabel>();
//        setNums(1);
//        for (JLabel l : nums)
//            this.add(l);
    }

    /**
     * with 6 spaces, 64 numbers fit in the visible part of the screen
     *
     * @param start which beat number to start at
     */
    public void setNums(int start) {
//        for (int i = start; i < 61 + start; i++) {
//            nums.add(new JLabel("" + i));
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        g2.drawLine(0, 0, 100, 100);

        int start  = 0;
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.WHITE);
//        g2.drawString("THIS IS A STRING", 0, 20);
        for (int i = start; i < 61 + start; i++) {
            g2.drawString("" + i, NotePanel.widthOfNOte * i, this.getHeight() / 2);
        }

    }
}
