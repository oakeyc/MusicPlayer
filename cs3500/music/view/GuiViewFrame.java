package cs3500.music.view;

import java.awt.*;

import javax.sound.midi.InvalidMidiDataException;

import cs3500.music.controller.MusicController;

/**
 * A skeleton Frame
 */
public class GuiViewFrame extends javax.swing.JFrame implements IMusicView {

    private final NotePanel displayPanel; // You may want to refine this to a subtype of JPanel
    private final NumberPanel numPan;
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

        this.getContentPane().add(numPan, BorderLayout.SOUTH);


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

    public static void main(String[]args) {
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
