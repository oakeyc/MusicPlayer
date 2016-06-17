package cs3500.music;

import org.testng.remote.adapter.IMasterAdapter;

import cs3500.music.controller.MusicController;
import cs3500.music.controller.MusicReader;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Song;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.IMusicView;
import cs3500.music.view.MidiView;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.TextView;
//import cs3500.music.view.MidiViewImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;

import static cs3500.music.view.FactoryView.viewPicker;


public class MusicEditor {


  public static void main(String[] args) throws FileNotFoundException { // FIXME: 6/17/2016 TAKE ARGS IN MAIN METHOD ("mary.txt", "console");
    FileReader file = new FileReader("./music/Files/" + args[0]); //takes file

    Song.Builder model = new Song.Builder(new Song());
    MusicReader.parseFile(file, model); //assigns file to model

    IMusicView view = viewPicker(args[1]); //assigns view type based on text input
    view.setModel(model); //assigns the model to the view

    MusicController controller = new MusicController(model, view); //creates a new controller with model and view

    controller.play(); //calls play on controller
  }


}
