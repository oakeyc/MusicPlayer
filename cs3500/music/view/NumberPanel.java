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
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 100)); // change the cols
        nums = new ArrayList<JLabel>();
        setNums(1);
        for (JLabel l : nums)
            this.add(l);
    }

    /**
     * with 6 spaces, 64 numbers fit in the visible part of the screen
     *
     * @param start which beat number to start at
     */
    public void setNums(int start) {
        for (int i = start; i < 61 + start; i++) {
            nums.add(new JLabel("" + i));
        }
    }

    public int getLabelWidth() {
        return nums.get(0).getWidth();
    }
}
