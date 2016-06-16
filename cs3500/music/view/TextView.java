package cs3500.music.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public String render() {
      String result = "";

      List<Note> allNotes = new ArrayList<Note>(); //COMPILE LIST OF ALL NOTES IN SONG //
      for (int a = 0; a < song.getBeats().size(); a++) {
        for (int b = 0; b < song.getBeats().get(a).notes.size(); b++) {
          allNotes.add(song.getBeats().get(a).notes.get(b));
        }
      }
      Note lowestNote = Collections.min(allNotes); //LOWEST NOTE IN THE SONG
      Note highestNote = Collections.max(allNotes); //HIGHEST NOTE IN THE SONG

      if (song.getBeats().size() < 1000) { //IF THERE ARE LESS THAN 1000 BEATS
        result = result + "   ";      //ADD THREE SPACES
      } else {                        //OTHERWISE
        result = result + "    ";     //ADD FOUR SPACES
      }

      //TOP ROW OF PRINTED NOTES
      List<Note> printedNotes = new ArrayList<Note>(); //LIST OF NOTES UP TOP (FOR USE LATER)
      for (int q = lowestNote.octave; q <= highestNote.octave; q++) {
        if (lowestNote.octave == highestNote.octave) { //FINISH INCOMPLETE OCTAVE
          for (int p = lowestNote.pitch.value; p <= highestNote.pitch.value; p++) {
            Note tempNote = new Note(q, Note.Pitch.values()[p-1], true);
            printedNotes.add(tempNote);
            result = result + " " + tempNote.printNote();  //
            int spaces = 4 - tempNote.printNote().length();
            for(int s = 0; s < spaces; s++) {
              result = result + " ";
            }
          }
        }
        else if (q == lowestNote.octave) { //FINISH OCTAVE TO RIGHT
          for (int p = lowestNote.pitch.value; p <= Note.Pitch.B.value; p++) {
            Note tempNote = new Note(q, Note.Pitch.values()[p-1], true);
            printedNotes.add(tempNote);
            result = result + " " + tempNote.printNote();
            int spaces = 4 - tempNote.printNote().length();
            for(int s = 0; s < spaces; s++) {
              result = result + " ";
            }
          }
        }
        else if (q == highestNote.octave) { //FINISH OCTAVE FROM LEFT
          for (int p = Note.Pitch.C.value; p <= highestNote.pitch.value; p++) {
            Note tempNote = new Note(q, Note.Pitch.values()[p-1], true);
            printedNotes.add(tempNote);
            result = result + " " + tempNote.printNote();
            int spaces = 4 - tempNote.printNote().length();
            for(int s = 0; s < spaces; s++) {
              result = result + " ";
            }
          }
        }
        else { //WRITE FULL OCTAVE
          for (int p = Note.Pitch.C.value; p <= Note.Pitch.B.value; p++) {
            Note tempNote = new Note(q, Note.Pitch.values()[p-1], true);
            printedNotes.add(tempNote);
            result = result + " " + tempNote.printNote(); //
            int spaces = 4 - tempNote.printNote().length();
            for(int s = 0; s < spaces; s++) {
              result = result + " ";
            }
          }
        }
      }

      result = result + "\n"; //NEW LINE

      //ITERATE OVER BEATS FOR SUBSEQUENT ROWS
      int lineCounter = 0;
      for (Beat b : song.getBeats()) {//FOR EACH BEAT IN THE SONG

        result = result + lineCounter; //PRINT THE BEAT NUMBER //
        lineCounter++; //INCREMENT THE BEAT NUMBER

        if (lineCounter <= 10) {
          result = result + "  ";
        }
        else if (lineCounter <= 1000) {
          result = result + " ";
        }

        int spaceCounter = 0;

        for (Note n : b.notes) {//AND FOR EACH NOTE IN EACH BEAT //

          for (int z = spaceCounter; z < printedNotes.size(); z++) { //ITERATE OVER THE NOTES UP TOP
            if (n.pitch == printedNotes.get(z).pitch && n.octave == printedNotes.get(z).octave) {
              //AND IF THE ITERATED NOTE IS EQUAL TO THE NOTE UP TOP
              if (n.first == true) {
                result = result + "  X  "; //ADD AN X
              }
              if (n.first == false) {
                result = result + "  |  "; //ADD A LINE
              }
              spaceCounter++;
              break; //BREAKS HERE //
            } else { //OTHERWISE
              result = result + "     "; //ADD A SPACE //
              spaceCounter++;
            }
          }
        }

        result = result + "\n"; //THEN ADD A NEW LINE
      }

      return result; //FINALLY, RETURN THE STRING
    }



    public String oldRender() { // FIXME: 6/15/2016
        StringBuilder state = new StringBuilder("    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4" +
          " D4  D#4 E4  F4  F#4 G4\n");
        // the head of each note are exactly 4 spaces away
        int count = 0;
        int startVal = 3 * 12 + (Pitch.E.getValue()) - 1;
        int numCharPerLine = 17 * 4;
        //for (Beat b : song.getBeats()) { // how are we going to get the stuff?
//        state.append(count);
//        for (int i = 0; i < 17 * 4 - 2; i++)
//          state.append(" ");
//
//        for (Note m : b.getNotes()) {
//          int numSpace = m.getValue() - startVal;
//          state.replace(((count + 1) * numCharPerLine) + numSpace * 4,
//                  ((count + 1) * numCharPerLine) + numSpace * 4 + 1, m.getImage(count));
//        }
//        count++;
//        state.append("\n");
//      }
//      return state.toString();
        return "HELLO WORLD";
    }

    @Override
    public void initialize() {

    }

    @Override
    public Dimension getPreferredSize() {
        return null;
    }
}

