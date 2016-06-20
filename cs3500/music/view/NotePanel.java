package cs3500.music.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;

/**
 * draws the notes in a grid like fashion
 */
public class NotePanel extends JPanel implements Scrollable {

    private int range;
    private Note low;
    private Note high;
    private List<Beat> notes;
    public static int heightOfNote;
    public static int widthOfNOte;

    /**
     * constructor
     * @param low    the lowest note in the song
     * @param high   the highest note in the song
     */
    public NotePanel(Note low, Note high, List<Beat> notes) {
        super();
        // initialize
        this.range = high.getValue() - low.getValue() + 1; // to include start and finish
        this.low = low;
        this.high = high;
        this.notes = notes;
        widthOfNOte = 40;
        heightOfNote = (int)(Math.ceil(getHeight() * 1.0 / range));
        // set values
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        heightOfNote = (int)(Math.ceil(getHeight() * 1.0 / range));

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
            g2.drawLine(0, (getHeight() - i), getWidth(), (getHeight() - i));
        }

        // draws notes on
        drawNotes(g2);

        repaint();
    }

    /**
     * draws the notes on
     * @param g2     the graphics instance
     */
    private void drawNotes(Graphics2D g2) {
        for (int i = 0; i < notes.size(); i++) {
            for (Note n : notes.get(i).getNotes()) {
                if (n.getStart() == i)
                    g2.setColor(new Color(28, 92, 100)); // gray ish
                else
                    g2.setColor(new Color(158, 0, 236)); // purple
                // draws note
                g2.fillRect(widthOfNOte * i,
                  getHeight() - (heightOfNote * (n.getValue() - low.getValue() + 1)),
                  widthOfNOte, heightOfNote);
            }
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
        return 10;
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
        return 10;
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
        return true;
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
        return true;
    }
}
