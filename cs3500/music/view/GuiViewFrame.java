package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.ROMusic;
import cs3500.music.model.Song;

/**
 * A GUI view for Music is a IMusicView
 */
public class GuiViewFrame extends javax.swing.JFrame implements IMusicView {
    private Song.Builder song; // the song composition builder

    private NotePanel displayPanel; // shows the notes
    private NumberPanel numPan; // shows the beat number
    private LabelPanel lanPan; // shows the note labels

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
        setSize(new Dimension(2000, 600));
        setMinimumSize(new Dimension(400, 120));
        setResizable(true);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * shows the GUI to the world
     */
    @Override
    public void initialize() {
        this.setVisible(true);
    }

    /**
     * rebuilds the GUI with proper panels given
     * that a model has been provided
     */
    public void rebuild() {
        Note low = null; // represents the lowest note
        Note high = null; // represents the highest note
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
        this.displayPanel = new NotePanel(low, high, song.getBeats());
        // sets the labels
        this.lanPan = new LabelPanel(low, high);
        // sets the numbers
        numPan = new NumberPanel(song.getBeats().size());

        // adding panels and such where they should be
        Container con1 = new Container();
        con1.setLayout(new BorderLayout());
        con1.add(displayPanel, BorderLayout.CENTER);
        con1.add(numPan, BorderLayout.SOUTH);
        this.getContentPane().add(lanPan, BorderLayout.WEST);
        this.getContentPane().add(con1, BorderLayout.CENTER);
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
     * renders the GUI
     *      builds and initializes
     */
    @Override
    public void render() {
        rebuild();
        initialize();
    }

    /**
     * main to look at stuff
     * @param args
     */
    public static void main(String[] args) {
        Song s = new Song();
        Note n = new Note(Pitch.C, 4, 4, 0);
        Note n2 = new Note(Pitch.Fs, 4, 4, 1);
        Note n3 = new Note(Pitch.D, 3, 3, 2);

        s.addNote(n);
        s.addNote(n2);
        s.addNote(n3);

        Song.Builder b = new Song.Builder(s);
        GuiViewFrame f = new GuiViewFrame();

        f.setModel(b);
        f.render();
    }
}
