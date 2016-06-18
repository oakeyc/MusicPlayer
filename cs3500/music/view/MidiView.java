package cs3500.music.view;

import cs3500.music.model.Song;

/**  represents the audio view for Music
 * Created by Courtney on 6/15/2016.
 */
public class MidiView extends MidiViewImpl {
  Song.Builder song;

  /**
   * Creates an instance of MidiView.
   */
  public MidiView() {}

  /**
   * Sets the model of this MidiView object.
   * @param model
   */
  public void setModel(Song.Builder model) {
    this.song = model;
  }

  /**
   * "Renders" the MIDI view.
   * @return
   */
  @Override
  public void render() {
    // FIXME: 6/17/2016
  }
}
