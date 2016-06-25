package cs3500.music.controller;

import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;

/**
 * Created by IanLeonard on 6/25/2016.
 */
public class RunnableRemove implements Runnable {
    int x;
    int y;
    IMusicView view;
    Song.Builder model;

    RunnableRemove(IMusicView view, Song.Builder model) {
        this.view = view;
        this.model = model;
    }
    @Override
    public void run() {
        Note tempNote = view.isANote(x, y);
        this.model.addFullNote(tempNote);
    }

    public void getXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
