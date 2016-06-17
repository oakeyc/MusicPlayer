package cs3500.music.view;

import cs3500.music.model.Song;

/**
 * Created by Courtney on 6/15/2016.
 */
public class MidiView extends MidiViewImpl {
  Song.Builder song;

  public MidiView() {}

  public void setModel(Song.Builder model) {
    this.song = model;
  }

  @Override
  public String render() {
    return null; // FIXME: 6/17/2016 
  }
}
