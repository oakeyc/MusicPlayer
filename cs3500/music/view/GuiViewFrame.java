package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.ROMusic;
import cs3500.music.model.Song;

/**
 * A skeleton Frame
 */
public class GuiViewFrame extends javax.swing.JFrame implements IMusicView {
    Song.Builder song;

    private NotePanel displayPanel; // You may want to refine this to a subtype of JPanel
    private NumberPanel numPan;
    private LabelPanel lanPan;
    public static final int sizeBtwnBeat = 10;
    private int range;

//    private MusicController control;

    /**
     * Creates new GuiView
     */
    public GuiViewFrame() {
        super();
        this.setTitle("Music Player");
        this.getContentPane().setLayout(new BorderLayout());
        this.displayPanel = new NotePanel();
        setSize(new Dimension(2000, 600));
        setResizable(false);
        this.lanPan = new LabelPanel(new Note(Pitch.E, 3, 1, 0),
          new Note(Pitch.G, 4, 1, 0));

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        displayPanel.drawLines(displayPanel.getHeight());

        numPan = new NumberPanel();

        Container con1 = new Container();
        con1.setLayout(new BorderLayout());
        con1.add(displayPanel, BorderLayout.CENTER);
        con1.add(numPan, BorderLayout.SOUTH);
//        this.getContentPane().add(displayPanel, BorderLayout.CENTER);
        this.getContentPane().add(lanPan, BorderLayout.WEST);
        this.getContentPane().add(con1, BorderLayout.CENTER);

//        this.pack();
    }


    @Override
    public void initialize() {
        this.setVisible(true);
    }

    public void takeMusic(ROMusic m) {

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(2000, 800);
    }

  /**
   * Sets the model of this instance of GuiViewFrame
   * @param model
   */
  @Override
    public void setModel(Song.Builder model) {
        this.song = model;
    }

    @Override
    public void render() {

    }

    public static void main(String[] args) {
//        MusicController con = new MusicController();
        GuiViewFrame f = new GuiViewFrame();
        f.initialize();

//        MidiViewImpl m = new MidiViewImpl();
//        try {
//            m.playNote();
//        } catch (InvalidMidiDataException e) {
//            e.printStackTrace();
//        }

    }
}
