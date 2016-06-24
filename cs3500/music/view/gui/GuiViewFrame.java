package cs3500.music.view.gui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Song;

/**
 * A GUI view for Music is a IMusicView
 */
public class GuiViewFrame extends javax.swing.JFrame implements GuiView {
    private Song.Builder song; // the song composition builder

    private NotePanel displayPanel; // shows the notes
    private NumberPanel numPan; // shows the beat number
    private LabelPanel lanPan; // shows the note labels
    private Note low;
    private Note high;
    private JScrollPane scrollPane;
    public final static int windowWidth  = 1500;

    /**
     * constructor initializes with default values
     */
    public GuiViewFrame() {
        super();
        this.song = null;
        this.displayPanel = null;
        this.numPan = null;
        this.lanPan = null;
        this.setTitle("Music Player");
        this.getContentPane().setLayout(new BorderLayout());
        setSize(new Dimension(windowWidth, 800));
//        setMinimumSize(new Dimension(1100, 500));
        setResizable(false);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        low = null;
        high = null;
        scrollPane = null;
    }

    /**
     * shows the GUI to the world
     */
    public void initialize() {
        this.setVisible(true);
    }

    /**
     * rebuilds the GUI with proper panels given that a model has been provided
     */
    public void rebuild() {
        low = null; // represents the lowest note
        high = null; // represents the highest note
        for (Beat b : song.getBeats())
            for (Note n : b.getNotes()) {
                if (low == null)
                    low = n;
                else if (n.compareTo(low) < 0)
                    low = n;
                if (high == null)
                    high = n;
                else if (n.compareTo(high) > 0)
                    high = n;
            }

        // sets the note drawings
        this.displayPanel = new NotePanel(low, high, song.getBeats(), song.getTempo());
//        this.displayPanel.setPreferredSize(new Dimension(1500, 1000));

        // sets the labels
        this.lanPan = new LabelPanel(low, high);
        // sets the numbers
        numPan = new NumberPanel(displayPanel);

        // adding panels and such where they should be
        Container con1 = new Container();
        con1.setLayout(new BorderLayout());
        con1.add(displayPanel, BorderLayout.CENTER);
        con1.add(lanPan, BorderLayout.WEST);
        con1.add(numPan, BorderLayout.SOUTH);
        con1.setPreferredSize(new Dimension(song.getBeats().size() * NotePanel.widthOfNote,
          400));

        scrollPane = new JScrollPane(con1);

        scrollPane.setPreferredSize(new Dimension(con1.getWidth(),
          con1.getHeight() / 2));

//        con1.add(scrollPane, BorderLayout.CENTER);

//        this.getContentPane().add(lanPan, BorderLayout.WEST);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        this.repaint();
    }

    /**
     * Sets the model of this instance of GuiViewFrame
     */
    @Override
    public void setModel(Song.Builder model) {
        this.song = model;
        rebuild();
    }

    /**
     * renders the GUI builds and initializes
     */
    @Override
    public void render() {
        rebuild();
        initialize();
    }

    @Override
    public void addActionListener(ActionListener listener) {
        this.addActionListener(listener);
    }

    /**
     * stops the view from presenting more
     */
    @Override
    public void playPause() {
        displayPanel.playPause();
    }

    @Override
    public void addKeyListener(KeyboardHandler kbd) {
        this.addKeyListener(kbd);
    }

    @Override
    public void scroll(ScrollDir str) {
        displayPanel.scroll(str);
    }

    /**
     * Gets the note from the GUI box at the bottom of the screen.
     *
     * @return Note
     */
    @Override
    public Note getInputNote() {
        return null;
    }

    @Override
    public Note isANote(int x, int y) {
        int beat = x / NotePanel.widthOfNote;
        int pitch = y / NotePanel.heightOfNote; // starts at high, should floor

        for (Note n : song.getBeats().get(beat).getNotes()) {
            if (n.getValue() == high.getValue() - pitch)
                return n;
        }
        return null;
    }
}
