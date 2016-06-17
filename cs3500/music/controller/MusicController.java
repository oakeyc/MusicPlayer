package cs3500.music.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.music.model.Beat;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Song;
import cs3500.music.view.TextView;

/**
 * Created by Courtney on 6/7/2016.
 */
public class MusicController { // FIXME: 6/17/2016 SUPPOSED TO BE CALLED MUSICEDITOR?
    
    public static void main(String[] args) throws FileNotFoundException { // FIXME: 6/17/2016 TAKE ARGS IN MAIN METHOD ("mary.txt", "console");
        FileReader file = new FileReader("./Files/mary-little-lamb.txt"); //
        //Song controllerSong = null;

        Song.Builder s = new Song.Builder(new Song());
        //MusicReader reader = new MusicReader();
        MusicReader.parseFile(file, s); //

        TextView textView = new TextView(s);
        System.out.println(textView.render());
    }

    public void viewPicker(String view) { // FIXME: 6/17/2016 
        switch (view) {
            case "text" : {
                ???
                break;
            }
            case "midi" : {
                ???
                break;
            }
            case "graphic" : {
                ???
                break;
            }
        }
    }




}
