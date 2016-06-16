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
public class MusicController {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("C:\\Users\\Ian Leonard\\IdeaProjects\\CS3500\\music\\Files\\mary-little-lamb.txt"); // FIXME: 6/16/2016 PACKAGE-BASED FILE REFERENCE
        //Song controllerSong = null;

        Song.Builder s = new Song.Builder(new Song());
        //MusicReader reader = new MusicReader();
        MusicReader.parseFile(file, s); //

        TextView textView = new TextView(s);
        System.out.println(textView.render());
    }




}
