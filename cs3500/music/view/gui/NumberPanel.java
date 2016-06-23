package cs3500.music.view.gui;

import java.awt.*;

import javax.swing.*;

/** represents the beat number labels
 * Created by Courtney on 6/13/2016.
 */
public class NumberPanel extends JPanel{

    private int start;// where to start, when scrolling must change
    private int numBeats; // the number of beats to represent
    private int numBeatsScreen;
    private NotePanel p;

    public NumberPanel(NotePanel p) {
        super();
        setBackground(Color.GRAY);
        setLayout(new GridLayout(1, 100)); // change the cols
        this.setPreferredSize(new Dimension(10, 25));
        start = 0; // should the beats be zero enumerated or not
//        this.numBeats = numBeats;
        this.p = p;
        start = p.getCount();
        numBeatsScreen = GuiViewFrame.windowWidth / NotePanel.widthOfNote;
    }

//    public static void scrollBeat() {
//        start++;
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        start = p.getCount();
        for (int i = start; i < numBeatsScreen + start; i++) {
            g2.drawString("" + i, NotePanel.widthOfNote * (i + 1), this.getHeight() / 2);
        }
    }
}
