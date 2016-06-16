package cs3500.music.view;

import java.awt.*;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

/**
 * Created by Ian Leonard on 6/15/2016.
 */
public class TextView implements IMusicView {
  Song.Builder song;

  public TextView(Song.Builder song) {
    this.song = song;
  }

    /**
     * the representation of this model
     *
     * @return string representation of the model
     */
    public String render() { // FIXME: 6/15/2016
      StringBuilder state = new StringBuilder("    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4" +
              " D4  D#4 E4  F4  F#4 G4\n");
      // the head of each note are exactly 4 spaces away
      int count = 0;
      int startVal = 3 * 12 + (Pitch.E.getValue()) - 1;
      int numCharPerLine = 17 * 4;
      for (Beat b : song.getBeats()) {
        state.append(count);
        for (int i = 0; i < 17 * 4 - 2; i++)
          state.append(" ");

        for (Note m : b.getNotes()) {
          int numSpace = m.getValue() - startVal;
          state.replace(((count + 1) * numCharPerLine) + numSpace * 4,
                  ((count + 1) * numCharPerLine) + numSpace * 4 + 1, m.getImage(count));
        }
        count++;
        state.append("\n");
      }
      return state.toString();
    }

  @Override
  public void initialize() {

  }

  @Override
  public Dimension getPreferredSize() {
    return null;
  }
}

