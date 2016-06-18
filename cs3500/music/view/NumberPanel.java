package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/** represents the beat number labels
 * Created by Courtney on 6/13/2016.
 */
public class NumberPanel extends JPanel implements Scrollable{

    private int start;// where to start, when scrolling must change
    private int numBeats; // the number of beats to represent

    /**
     * constructor
     * @param numBeats     the number of beats in the song
     */
    public NumberPanel(int numBeats) {
        super();
        setBackground(Color.GRAY);
        setLayout(new GridLayout(1, 100)); // change the cols
        this.setPreferredSize(new Dimension(10, 25));
        start = 1; // should the beats be zero enumerated or not
        this.numBeats = numBeats;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        for (int i = start; i < numBeats + start; i++) {
            g2.drawString("" + i, NotePanel.widthOfNOte * (i - 1), this.getHeight() / 2);
        }
    }

    /**
     * Returns the preferred size of the viewport for a view component. For example, the preferred
     * size of a <code>JList</code> component is the size required to accommodate all of the cells
     * in its list. However, the value of <code>preferredScrollableViewportSize</code> is the size
     * required for <code>JList.getVisibleRowCount</code> rows. A component without any properties
     * that would affect the viewport size should just return <code>getPreferredSize</code> here.
     *
     * @return the preferredSize of a <code>JViewport</code> whose view is this
     * <code>Scrollable</code>
     * @see JViewport#getPreferredSize
     */
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return null;
    }

    /**
     * Components that display logical rows or columns should compute the scroll increment that will
     * completely expose one new row or column, depending on the value of orientation.  Ideally,
     * components should handle a partially exposed row or column by returning the distance required
     * to completely expose the item. <p> Scrolling containers, like JScrollPane, will use this
     * method each time the user requests a unit scroll.
     *
     * @param visibleRect The view area visible within the viewport
     * @param orientation Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL.
     * @param direction   Less than zero to scroll up/left, greater than zero for down/right.
     * @return The "unit" increment for scrolling in the specified direction. This value should
     * always be positive.
     * @see JScrollBar#setUnitIncrement
     */
    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    /**
     * Components that display logical rows or columns should compute the scroll increment that will
     * completely expose one block of rows or columns, depending on the value of orientation. <p>
     * Scrolling containers, like JScrollPane, will use this method each time the user requests a
     * block scroll.
     *
     * @param visibleRect The view area visible within the viewport
     * @param orientation Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL.
     * @param direction   Less than zero to scroll up/left, greater than zero for down/right.
     * @return The "block" increment for scrolling in the specified direction. This value should
     * always be positive.
     * @see JScrollBar#setBlockIncrement
     */
    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    /**
     * Return true if a viewport should always force the width of this <code>Scrollable</code> to
     * match the width of the viewport. For example a normal text view that supported line wrapping
     * would return true here, since it would be undesirable for wrapped lines to disappear beyond
     * the right edge of the viewport.  Note that returning true for a Scrollable whose ancestor is
     * a JScrollPane effectively disables horizontal scrolling. <p> Scrolling containers, like
     * JViewport, will use this method each time they are validated.
     *
     * @return True if a viewport should force the Scrollables width to match its own.
     */
    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    /**
     * Return true if a viewport should always force the height of this Scrollable to match the
     * height of the viewport.  For example a columnar text view that flowed text in left to right
     * columns could effectively disable vertical scrolling by returning true here. <p> Scrolling
     * containers, like JViewport, will use this method each time they are validated.
     *
     * @return True if a viewport should force the Scrollables height to match its own.
     */
    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
