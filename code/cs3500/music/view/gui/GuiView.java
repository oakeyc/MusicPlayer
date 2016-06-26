package cs3500.music.view.gui;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

/**
 * Created by Courtney on 6/20/2016. Represents ANY Music View
 */
public interface GuiView extends IMusicView {
    /**
     * Sets the model for the view based on an model given as input.
     */
    @Override
    void setModel(Song.Builder model);

    /**
     * Method for rendering the view Displays either text, gui, or midi output.
     */
    @Override
    void render();

    /**
     * Adds a MouseListener to the respective View.
     */
    void addMouseListener(MouseListener m);

    /**
     * Adds a KeyListener to the respective View.
     */
    void addKeyListener(KeyListener listener);

    /**
     * Gets a Note from a MouseEvent X and Y coordinates to pass to the Model.
     */
    Note isANote(int x, int y);

    /**
     * Scrolls the View left, right, home, or end.
     */
    void scroll(ScrollDir str);

    /**
     * Gets the note from the GUI box at the bottom of the screen.
     *
     * @return Note
     */
    Note getInputNote();

    /**
     * Plays and pauses the GUI view.
     */
    void playPause();

    /**
     * adds a listener for adding notes
     * @param lis
     */
    void addingLis(ActionListener lis);

    /**
     * is the view playuing
     * @return    true for playing
     */
    boolean isPlay();

    /**
     * is it started yet
     * @return    true for started
     */
    boolean started();

    /**
     * redraws the view
     */
    void reDraw();

    NotePanel getDisp();
}
