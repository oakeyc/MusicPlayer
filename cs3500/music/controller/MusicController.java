package cs3500.music.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.music.model.Beat;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.TextView;

/**
 * Created by Courtney on 6/7/2016.
 */
public class MusicController {
    Song.Builder model;
    IMusicView view;

    public MusicController(Song.Builder model, IMusicView view) {
        this.model = model;
        this.view = view;
    }

    public void modelToView() {
        view.setModel(model);
    }

    public void play() {
        view.render();
    }

}
