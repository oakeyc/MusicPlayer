package cs3500.music.view;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Created by Courtney on 6/7/2016.
 */
public class MusicView extends JFrame {

    private JPanel left;
    private JPanel right;
    private JPanel bottom;
    private JPanel top;
    private JPanel center;

    MusicView() {
        super();
        echo();
        this.pack();

        setVisible(true);

    }

    public void echo() {
        setSize(700, 400);
        setTitle("Echo a string");
        Container con = new Container();
        con.setLayout(new FlowLayout());
        JLabel l = new JLabel();
        l.setText("To be displayed");
        con.add(l);

        JTextField text = new JTextField(20);
//        text.addActionListener((ActionEvent e) -> {
//        });
        con.add(text);

        JButton echo = new JButton();
        echo.setText("Echo");

        echo.addActionListener((ActionEvent e) -> {
            l.setText(text.getText());
        });

        JButton exit = new JButton();
        exit.setText("Exit");
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        con.add(echo);
        con.add(exit);
        this.add(con);

    }


    public void practice() {

        setSize(800, 800);
//        setResizable(false);
        setMinimumSize(new Dimension(500, 500));
        setTitle("Music Player");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        left = new JPanel();
        left.setBackground(Color.MAGENTA);

        right = new JPanel();
        right.setBackground(Color.GRAY);

        bottom = new JPanel();
        bottom.setBackground(Color.BLUE);

        top = new JPanel();
        top.setBackground(Color.RED);

        center = new JPanel();
        center.setBackground(new Color(102, 0, 102));
        JLabel label = new JLabel("YOUR MUSIC");
        label.setForeground(Color.WHITE);


//        center.add(label);
//        center.setToolTipText("THIS IS THE CENTER MAN!");

        JButton b1 = new JButton();
        b1.setText("HELLO MY FRIEND!");
        b1.setToolTipText("Prints Hello World");
//        b1.setSize(new Dimension(100, 100));
        b1.addActionListener((ActionEvent e) -> { // lambda
            System.out.println("HELLO WORLD");
        });

        Container but = new Container();
        but.setLayout(new FlowLayout());
        but.add(b1);
        but.add(label);
        center.add(but);

        Container c = new Container();
        c.setLayout(new BorderLayout());
        c.add(left, BorderLayout.WEST);
        c.add(right, BorderLayout.EAST);
        c.add(bottom, BorderLayout.NORTH);
        c.add(top, BorderLayout.SOUTH);
        c.add(center, BorderLayout.CENTER);

        this.add(c);
        this.pack(); // makes it the smallest

        setVisible(true);
    }

    public static void main(String[] args) {
        MusicView m = new MusicView();
    }
}
