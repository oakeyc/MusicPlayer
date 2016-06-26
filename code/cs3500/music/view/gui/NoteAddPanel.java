package cs3500.music.view.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs3500.music.model.Note;
import cs3500.music.model.Pitch;

/**
 * Created by Courtney on 6/25/2016.
 */
public class NoteAddPanel extends JPanel implements ActionListener {

    private JComboBox pitch;
    private Pitch pi;
    private JComboBox octave;
    private int oc;
    private JTextField start;
    private int st;
    private JTextField duration;
    private int du;
    private JButton add;
    private Note note;

    public NoteAddPanel(ActionListener lis) {
        super();
        this.setLayout(new FlowLayout());

        JLabel p = new JLabel("Enter a pitch: ");
        this.add(p);

        pitch = new JComboBox(Pitch.values());
        pitch.addActionListener(this);
        pitch.setActionCommand("pitch");
        this.add(pitch);

        JLabel o = new JLabel("Octave [1,10]");
        this.add(o);

        String[] oct = new String[10];
        for (int i = 1; i <= 10; i++) {
            oct[i - 1] = "" + i;
        }
        octave = new JComboBox(oct);
        octave.addActionListener(this);
        octave.setActionCommand("octave");
        this.add(octave);

        JLabel s = new JLabel("Start: ");
        this.add(s);

        start = new JTextField(5);
        start.addActionListener(this);
        start.setActionCommand("start");
        this.add(start);

        JLabel d = new JLabel("Duration: ");
        this.add(d);

        duration = new JTextField(5);
        duration.setActionCommand("duration");
        duration.addActionListener(this);
        this.add(duration);

        add = new JButton("ADD NOTE");
        add.setActionCommand("add");
        add.addActionListener(lis);
        this.add(add);

        pi = null;
        oc = st = du = -1;

        note = null;
        setBackground(new Color(4, 255, 203));
        setFocusable(true);
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "pitch":
                pi = (Pitch) ((JComboBox) e.getSource()).getSelectedItem();
                break;
            case "octave":
                oc = 1 + ((JComboBox) e.getSource()).getSelectedIndex();
                break;
            case "start":
                st = Integer.parseInt(start.getText());
                break;
            case "duration":
                du = Integer.parseInt(duration.getText());
                break;
//            case "add":
//                try {
//                    st = Integer.parseInt(start.getText());
//                    du = Integer.parseInt(duration.getText());
//                } catch (NumberFormatException n) {
//                    makeError();
//                    break;
//                }
//                if (pi == null || oc < 0 || st < 0 || du < 0) {
//                    makeError();
//                    break;
//                }
//                note = new Note(pi, oc, du, st);
        }

    }

    public Note addedNote() {
        try {
            st = Integer.parseInt(start.getText());
            du = Integer.parseInt(duration.getText());
        } catch (NumberFormatException n) {
            makeError();
            return null;
        }
        if (pi == null || oc < 0 || st < 0 || du < 0) {
            makeError();
            return null;
        }
        return new Note(pi, oc, du, st);
    }

    public void makeError() {
        start.setText("");
        duration.setText("");
        JFrame error = new JFrame();
        error.setSize(200, 200);
        error.add(new JLabel("INVALID INPUT"));
        error.setVisible(true);
    }

    public void addingList(ActionListener lis) {
        add.addActionListener(lis);
    }
}
