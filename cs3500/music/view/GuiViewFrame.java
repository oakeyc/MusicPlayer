package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.*;

import cs3500.music.controller.MusicController;
import cs3500.music.model.Accidental;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;

/**
 * A skeleton Frame
 */
public class GuiViewFrame extends javax.swing.JFrame implements IMusicView {

    private NotePanel displayPanel; // You may want to refine this to a subtype of JPanel
    private NumberPanel numPan;
    public static final int sizeBtwnBeat = 50;
    private int range;

//    private MusicController control;

    /**
     * Creates new GuiView
     */
    public GuiViewFrame() {
//        this.control = control;
        this.setTitle("Music Player");
        this.getContentPane().setLayout(new BorderLayout());
        this.displayPanel = new NotePanel();
        setSize(new Dimension(2000, 600));
        setResizable(false);

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(displayPanel, BorderLayout.CENTER);
//        displayPanel.drawLines(displayPanel.getHeight());

        numPan = new NumberPanel();

        JPanel pitch = new JPanel();
        pitch.setBackground(Color.CYAN);
        BoxLayout lay = new BoxLayout(pitch, BoxLayout.Y_AXIS);
        pitch.setLayout(lay);

        Note low = new Note(Pitch.E, Accidental.natural, 3, 1, 0);
        Note high = new Note(Pitch.G, Accidental.natural, 4, 1, 0);

        Note temp = low;
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        while (temp.getValue() <= high.getValue()) {
            pitch.add(new JLabel(temp.toString()));
            temp = temp.fromValue(temp.getValue() + 1);
        }
        this.getContentPane().add(pitch, BorderLayout.WEST);

//        this.getContentPane().add(numPan, BorderLayout.SOUTH);

//        this.pack();
    }


    @Override
    public void initialize() {
        this.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(2000, 800);
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
