package cs3500.music.view;

import java.awt.*;

import cs3500.music.model.Song;

/**
 * Created by Courtney on 6/13/2016.
 */
public interface IMusicView {


    void initialize();
    Dimension getPreferredSize();

    void setModel(Song.Builder model);

    String render();
}
