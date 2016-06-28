package cs3500.music;

//import org.testng.remote.adapter.IMasterAdapter;

import cs3500.music.controller.MusicController;
import cs3500.music.controller.MusicReader;
import cs3500.music.model.Song;
import cs3500.music.model.SongRepeats;
import cs3500.music.view.IMusicView;
import cs3500.music.view.MidiView;
//import cs3500.music.view.MidiView;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static cs3500.music.view.FactoryView.viewPicker;


public class MusicEditor {


    /**
     * main() method tor running the entire program takes two args:
     * music file (filepath) and a view
     * type view type is either: text, midi, or gui
     */
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader(args[0]); //takes file

        Song.Builder model = new Song.Builder(new Song());
        MusicReader.parseFile(file, model); //assigns file to model

        IMusicView view = viewPicker(args[1]); //assigns view type based on text input

        Song s = model.build();
        SongRepeats song = new SongRepeats(s.getBeats(), s.getTempo());
        song.addDC(5);
        song.addAltEnd(15);
        song.addAltEnd(30);

        view.setModel(song);

        MusicController controller = new MusicController(song, view);
        //creates a new controller with model and view

        controller.play(); //calls play on controller
    }
}
