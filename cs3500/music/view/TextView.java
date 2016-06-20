package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

/**
 * represents a textual view for the music model Created by Ian Leonard on 6/15/2016.
 */
public class TextView implements IMusicView {
    Song.Builder song;

    /**
     * constructor
     */
    public TextView() {
        song = null;
    }

    /**
     * sets the model
     *
     * @param model the type of model to set
     */
    public void setModel(Song.Builder model) {
        this.song = model;
    }

    /**
     * the representation of this model
     *
     * @return string representation of the model
     */
    public void render() {
        StringBuilder result = new StringBuilder();

        Note lowestNote = null; // represents the lowest note
        Note highestNote = null; // represents the highest note
        for (Beat b : song.getBeats())
            for (Note n : b.getNotes()) {
                if (lowestNote == null)
                    lowestNote = n;
                else if (n.compareTo(lowestNote) < 0)
                    lowestNote = n;
                if (highestNote == null)
                    highestNote = n;
                else if (n.compareTo(highestNote) > 0)
                    highestNote = n;
            }

        result.append("    "); // for beat number gaps assume num beat < 1000

        Note temp = lowestNote;
        while (temp.compareTo(highestNote) <= 0) {
            if (temp.toString().length() == 2) { // three spaces
                result.append(temp.toString() + "   ");
            } else { // it'll be 2 spaces
                result.append(temp.toString() + "  ");
            }
            temp = Note.fromValue(temp.getValue() + 1);
        }
        result.append("\n");
        for (int i = 0; i < song.getBeats().size(); i++) {
            result.append("" + i);
            int count = 0;
            while (("" + i).length() + count < 4) {
                result.append(" ");
                count++;
            }
            for (int j = 0; j < highestNote.getValue() - lowestNote.getValue() + 1; j++) {
                result.append("     ");
            }
            // note * 5 is char position for X or |
            for (Note n: song.getBeats().get(i).getNotes()) {
                int position = ((n.getValue() - lowestNote.getValue() + 2) * 5); // 0 enum posn
                int offset = (5 * (highestNote.getValue() - lowestNote.getValue() + 2))
                  * (i + 1) - 5; // 5 chars per note (plus one for margin, one extra line for header
                result.replace(offset + position, offset + position + 1, n.getImage(i));
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}

