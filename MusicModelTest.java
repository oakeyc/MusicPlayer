import java.util.ArrayList;
import java.util.List;

import cs3500.music.model.Accidental;
import cs3500.music.model.Beat;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.SheetMusic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * a testing class Created by Courtney on 6/10/2016.
 */
public class MusicModelTest {
    List<Beat> b = new ArrayList<Beat>();
    Note n = new Note(Pitch.C, Accidental.natural, 4, 4, 0);
    Note n2 = new Note(Pitch.A, Accidental.sharp, 3, 1, 0);
    Note n3;
    Note n4;

    Beat beat = new Beat();

    SheetMusic sheet;
    GenericMusicModel model;

    // initializes
    private void init1() {
        b = new ArrayList<Beat>();
        n = new Note(Pitch.C, Accidental.natural, 4, 4, 0);
        beat = new Beat();

        beat.addNote(n);
        b.add(beat);

        sheet = new SheetMusic(b);
        model = new MusicModel(sheet);
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


        sheet = new SheetMusic(b);
        model = new MusicModel(sheet);
        n = new Note(Pitch.C, Accidental.natural, 4, 4, 0);
        n2 = new Note(Pitch.F, Accidental.sharp, 4, 4, 1);

        model.addNote(n, 0);
        model.addNote(n2, 1);

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

        Note n3 = new Note(Pitch.F, Accidental.natural, 4, 3, 4);
        model.addNote(n3, 4);
        model.addNote(new Note(Pitch.B, Accidental.flat, 3, 2, 0), 0);
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
        assertEquals(model.getSheet().getState(), sheet.getState());
    }

    // tests the edit
    @Test
    public void testEdit() {
        init2();
        Note n3 = new Note(Pitch.F, Accidental.natural, 4, 3, 4);
        model.addNote(n3, 4);
        model.addNote(new Note(Pitch.B, Accidental.flat, 3, 2, 0), 0);
        model.editNote(n3, new Note(Pitch.A, Accidental.sharp, 3, 2, 4), 4);
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
        Note n3 = new Note(Pitch.F, Accidental.natural, 4, 3, 4);
        model.addNote(n3, 4);
        model.addNote(new Note(Pitch.B, Accidental.flat, 3, 2, 0), 0);
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
        SheetMusic sheet2 = new SheetMusic(beats);
        GenericMusicModel model2 = new MusicModel(sheet2);

        n3 = new Note(Pitch.G, Accidental.sharp, 3, 1, 0);
        n4 = new Note(Pitch.C, Accidental.natural, 4, 6, 2);
        Note n5 = new Note(Pitch.B, Accidental.flat, 3, 3, 3);

        model2.addNote(n3, 0);
        model2.addNote(n4, 2);
        model2.addNote(n5, 3);

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

        m4.addNote(new Note(Pitch.E, Accidental.natural, 3, 3, 0), 0);

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
        SheetMusic sheet2 = new SheetMusic(beats);
        GenericMusicModel model2 = new MusicModel(sheet2);

        n3 = new Note(Pitch.G, Accidental.sharp, 3, 1, 0);
        n4 = new Note(Pitch.C, Accidental.natural, 4, 6, 2);
        Note n5 = new Note(Pitch.B, Accidental.flat, 3, 3, 3);

        model2.addNote(n3, 0);
        model2.addNote(n4, 2);
        model2.addNote(n5, 3);

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

        m3.addNote(new Note(Pitch.E, Accidental.natural, 3, 3, 0), 0);
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

        model.addNote(n, 100);
        model.addNote(n, -100);
        n4 = new Note(Pitch.A, Accidental.flat, -1, 0, 0);
        n4 = new Note(Pitch.A, Accidental.flat, 0, 0, -1);
        n4 = new Note(Pitch.A, Accidental.flat, 0, -1, -1);


    }

    @Test
    public void testFloorDiv() {
        assertEquals(Math.floorDiv(55, 12), 4);
    }
}
