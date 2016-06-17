package cs3500.music.view;

import cs3500.music.model.Song;

/**
 * Class to represent the View factory method.
 * Created by Ian Leonard on 6/17/2016.
 */
public class FactoryView {

  /**
   * Returns a new View based on text input from args[]
   * @param view
   * @return
   */
  public static IMusicView viewPicker(String view) { // FIXME: 6/17/2016
    switch (view) {
      case "text" : {
        return new TextView();
      }
      case "midi" : {
        return new MidiView();
      }
      case "gui" : {
        return new GuiViewFrame();
      }
      default: throw new IllegalArgumentException("Invalid View Type");
    }
  }
}
