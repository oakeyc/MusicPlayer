package cs3500.music.view;

import cs3500.music.model.Song;

/**
 * Created by Ian Leonard on 6/17/2016.
 */
public class FactoryView {

  public static IMusicView viewPicker(String view) { // FIXME: 6/17/2016
    switch (view) {
      case "text" : {
        return new TextView();
      }
      case "midi" : {
        return new MidiView();
      }
      case "graphic" : {
        return new GuiViewFrame();
      }
      default: throw new IllegalArgumentException("Invalid View Type");
    }
  }
}
