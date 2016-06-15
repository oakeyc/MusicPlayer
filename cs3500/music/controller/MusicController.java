package cs3500.music.controller;

import java.nio.file.Paths;

import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

/**
 * Created by Courtney on 6/7/2016.
 */
public class MusicController {

    public static void main(String[] args) {
        FileReader file = new FileReader("C:\\Users\\IanLeonard\\IdeaProjects\\MusicOOD\\mary-little-lamb.txt");
        Song song = new Song(null);
        song = MusicReader.parseFile((Readable) file, song); // FIXME: 6/15/2016
    }




}
