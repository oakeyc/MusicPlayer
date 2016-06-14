package cs3500.music.controller;

import cs3500.music.model.SheetMusic;

/**
 * Created by Courtney on 6/7/2016.
 */
public class MusicController {

    public SheetMusic fileToSheetMusic(String filePath) {
        FileReader file = new FileReader(filePath);
        SheetMusic song = new SheetMusic(null);

        int tempo = file.readTempo();
    }
}
