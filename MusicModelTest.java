
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cs3500.music.controller.FileReader;
import cs3500.music.model.Beat;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.Song;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * a testing class Created by Courtney on 6/10/2016.
 */
public class MusicModelTest {
    List<Beat> b = new ArrayList<Beat>();
    Note n = new Note(Pitch.Cs, 4, 4, 0);
    Note n2 = new Note(Pitch.A, 3, 1, 0);
    Note n3;
    Note n4;

    Beat beat = new Beat();

    Song sheet;
    GenericMusicModel model;

    // initializes
    private void init1() {
        b = new ArrayList<Beat>();
        n = new Note(Pitch.C, 4, 4, 0);
        beat = new Beat();

        beat.addNote(n);
        b.add(beat);

        model = new Song(b);
        sheet = new Song(b);
    }

    //inits
    private void init2() {
        b = new ArrayList<Beat>();
        beat = new Beat();
        b.add(beat);
        b.add(new Beat());
        b.add(new Beat());
        b.add(new Beat());
        b.add(new Beat());


        model = new Song(b);
        n = new Note(Pitch.C, 4, 4, 0);
        n2 = new Note(Pitch.Fs, 4, 4, 1);

        model.addNote(n);
        model.addNote(n2);

    }

    /* test the state of the game
     */
    @Test
    public void testState() {
        init1();
        assertEquals(model.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                                    X                             \n");
    }

    // tests the state more
    @Test
    public void testState2() {
        init2();
        assertEquals(model.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                                    X                             \n" +
            "1                                    |                       X     \n" +
            "2                                    |                       |     \n" +
            "3                                    |                       |     \n" +
            "4                                                            |     \n");
    }

    // tests more state
    @Test
    public void testState3() {
        init2();

        Note n3 = new Note(Pitch.F, 4, 3, 4);
        model.addNote(n3);
        model.addNote(new Note(Pitch.As, 3, 2, 0));
        assertEquals(model.getState(), "    E3  F3  F#3 G3  G#3 A3  A#3 B3 " +
          " C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
          "0                            X       X                             \n" +
          "1                            |       |                       X     \n" +
          "2                                    |                       |     \n" +
          "3                                    |                       |     \n" +
          "4                                                        X   |     \n");
    }

    // tests getter
    @Test
    public void testGet() {
        init1();
        assertEquals(model.getState(), sheet.getState());
    }

    // tests the edit
    @Test
    public void testEdit() {
        init2();
        Note n3 = new Note(Pitch.F, 4, 3, 4);
        model.addNote(n3);
        model.addNote(new Note(Pitch.As, 3, 2, 0));
        model.editNote(n3, new Note(Pitch.As, 3, 2, 4), 4);
        assertEquals(model.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                            X       X                             \n" +
            "1                            |       |                       X     \n" +
            "2                                    |                       |     \n" +
            "3                                    |                       |     \n" +
            "4                            X                               |     \n");

    }

    // tests the remove
    @Test
    public void testRemove() {
        init2();
        Note n3 = new Note(Pitch.F, 4, 3, 4);
        model.addNote(n3);
        model.addNote(new Note(Pitch.As, 3, 2, 0));
        model.remove(n3, 4);
        assertEquals(model.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
          "0                            X       X                             \n" +
          "1                            |       |                       X     \n" +
          "2                                    |                       |     \n" +
          "3                                    |                       |     \n" +
          "4                                                            |     \n");
    }

    // tests adding two models (addition)
    @Test
    public void testAdd() {
        init2();
        List<Beat> beats = new ArrayList<Beat>();
        beats.add(new Beat());
        beats.add(new Beat());
        beats.add(new Beat());
        beats.add(new Beat());
        beats.add(new Beat());
        Song sheet2 = new Song(beats);
        GenericMusicModel model2 = new Song(beats);

        n3 = new Note(Pitch.Gs, 3, 1, 0);
        n4 = new Note(Pitch.C, 4, 6, 2);
        Note n5 = new Note(Pitch.As, 3, 3, 3);

        model2.addNote(n3);
        model2.addNote(n4);
        model2.addNote(n5);

        GenericMusicModel m3 = model.add(model2);
        assertEquals(model2.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                    X                                             \n" +
            "1                                                                  \n" +
            "2                                    X                             \n" +
            "3                            X       |                             \n" +
            "4                            |       |                             \n");

        assertEquals(m3.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                                    X                             \n" +
            "1                                    |                       X     \n" +
            "2                                    |                       |     \n" +
            "3                                    |                       |     \n" +
            "4                                                            |     \n" +
            "5                    X                                             \n" +
            "6                                                                  \n" +
            "7                                    X                             \n" +
            "8                            X       |                             \n" +
            "9                            |       |                             \n");
        GenericMusicModel m4 = model2.add(model);
        assertEquals(m4.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                    X                                             \n" +
            "1                                                                  \n" +
            "2                                    X                             \n" +
            "3                            X       |                             \n" +
            "4                            |       |                             \n" +
            "5                                    X                             \n" +
            "6                                    |                       X     \n" +
            "7                                    |                       |     \n" +
            "8                                    |                       |     \n" +
            "9                                                            |     \n");

        m4.addNote(new Note(Pitch.E, 3, 3, 0));

        assertEquals(m4.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0    X               X                                             \n" +
            "1    |                                                             \n" +
            "2    |                               X                             \n" +
            "3                            X       |                             \n" +
            "4                            |       |                             \n" +
            "5                                    X                             \n" +
            "6                                    |                       X     \n" +
            "7                                    |                       |     \n" +
            "8                                    |                       |     \n" +
            "9                                                            |     \n");

    }

    // tests combine
    @Test
    public void testCombine() {
        init2();
        List<Beat> beats = new ArrayList<Beat>();
        beats.add(new Beat());
        beats.add(new Beat());
        beats.add(new Beat());
        beats.add(new Beat());
        beats.add(new Beat());
        Song sheet2 = new Song(beats);
        GenericMusicModel model2 = new Song(beats);

        n3 = new Note(Pitch.Gs, 3, 1, 0);
        n4 = new Note(Pitch.C, 4, 6, 2);
        Note n5 = new Note(Pitch.As, 3, 3, 3);

        model2.addNote(n3);
        model2.addNote(n4);
        model2.addNote(n5);

        GenericMusicModel m3 = model.combine(model2);
        GenericMusicModel m4 = model2.combine(model);

        assertEquals(model2.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                    X                                             \n" +
            "1                                                                  \n" +
            "2                                    X                             \n" +
            "3                            X       |                             \n" +
            "4                            |       |                             \n");

        assertEquals(m3.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0                    X               X                             \n" +
            "1                                    |                       X     \n" +
            "2                                    X                       |     \n" +
            "3                            X       |                       |     \n" +
            "4                            |       |                       |     \n");

        m3.addNote(new Note(Pitch.E, 3, 3, 0));
        assertEquals(m3.getState(),
          "    E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 D4  D#4 E4  F4  F#4 G4\n" +
            "0    X               X               X                             \n" +
            "1    |                               |                       X     \n" +
            "2    |                               X                       |     \n" +
            "3                            X       |                       |     \n" +
            "4                            |       |                       |     \n");
    }

    // test bad input
    @Test(expected = IllegalArgumentException.class)
    public void testExcep() {
        init2();

        n4 = new Note(Pitch.Gs, -1, 0, 0);
        n4 = new Note(Pitch.Gs, 0, 0, -1);
        n4 = new Note(Pitch.Gs, 0, -1, -1);


    }

    @Test
    public void testFileToSheetMusic() throws IOException {
        // must be relative to the program or it won't compile on other things
        FileReader reader = new FileReader("/src/cs3500/music/mary-little-lamb.txt");
        assertEquals(reader.fileToSheetMusic(), new Song(null));
    }
}
