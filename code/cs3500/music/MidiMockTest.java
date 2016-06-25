package cs3500.music;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.music.controller.MusicController;
import cs3500.music.controller.MusicReader;
import cs3500.music.model.Note;
import cs3500.music.model.Pitch;
import cs3500.music.model.Song;
import cs3500.music.view.MidiView;

import static org.junit.Assert.assertEquals;

/** test the mock midi
 * Created by Courtney on 6/19/2016.
 */
public class MidiMockTest {
    @Test
    public void testMock() {
        StringBuilder b = new StringBuilder();
        MockReceiver r =  new MockReceiver(b);
        MockSynth s = new MockSynth();

        Song m = new Song();
        m.addNote(new Note(Pitch.C, 4, 2, 0));
        m.addNote(new Note(Pitch.E, 4, 2, 0));

        Song.Builder sb = new Song.Builder(m);

        MidiView mv = new MidiView(r, s);
        mv.setModel(sb);

        MusicController mc = new MusicController(sb, mv);
        mc.play();

        assertEquals(b.toString(),
          "144128144128");
    }

    @Test
    public void testMock2() {
        StringBuilder b = new StringBuilder();
        MockReceiver r =  new MockReceiver(b);
        MockSynth s = new MockSynth();

        Song m = new Song();
        m.addNote(new Note(Pitch.C, 4, 2, 0));
        m.addNote(new Note(Pitch.E, 4, 2, 0));
        m.addNote(new Note(Pitch.G, 4, 2, 1));
        m.addNote(new Note(Pitch.A, 5, 2, 2));
        m.addNote(new Note(Pitch.C, 4, 2, 3));
        m.addNote(new Note(Pitch.E, 4, 8, 3));

        Song.Builder sb = new Song.Builder(m);

        MidiView mv = new MidiView(r, s);
        mv.setModel(sb);

        MusicController mc = new MusicController(sb, mv);
        mc.play();

        assertEquals(b.toString(),
          "144128144128144128144128144128144128");
    }

    @Test
    public void testMary() {
        FileReader file = null; //takes file
        Song.Builder model = new Song.Builder(new Song());

        try {
            file = new FileReader(".\\src\\Files\\mary-little-lamb.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        MusicReader.parseFile(file, model); //assigns file to model
//        model.addNote(0, 2, 1, 64, 72);
//        model.addNote(0, 7, 1, 55, 70);
//        model.addNote(2, 4, 1, 62, 72);
//        model.



        StringBuilder b = new StringBuilder(14000);
        MockReceiver r =  new MockReceiver(b);
        MockSynth s = new MockSynth();
        MidiView view = new MidiView(r, s);

        view.setModel(model);
//    IMusicView view = viewPicker(args[1]); //assigns view type based on text input
//    view.setModel(model); //assigns the model to the view

        MusicController controller = new MusicController(model, view); //creates a new controller with model and view

        controller.play(); //calls play on controller
        assertEquals(b.toString(),
          "144128144128144128144128144128144128");
    }

}
