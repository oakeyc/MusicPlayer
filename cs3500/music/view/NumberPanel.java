package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

/**
 * Created by Courtney on 6/13/2016.
 */
public class NumberPanel extends JPanel {
    private StringBuilder str;
    private JLabel nums;

    public NumberPanel() {
        super();
        str = new StringBuilder();
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        nums = new JLabel();
        nums.setForeground(Color.BLACK);
        setNums(1);

        this.add(nums, FlowLayout.LEFT);
    }

    /**
     * with 6 spaces, 64 numbers fit in the visible part of the screen
     *
     * @param start which beat number to start at
     */
    public void setNums(int start) {

        for (int i = start; i < 63 + start; i++)
            str.append(i + "      ");
        nums.setText(str.toString());

    }
}
