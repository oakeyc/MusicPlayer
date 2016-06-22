package cs3500.music.view.gui;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

/**
 * Created by Courtney on 6/20/2016.
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

    void addMouseListener(MouseListener m);

    void addKeyListener(KeyListener k);

    Note isANote(int x, int y);
}
