<CHANGELOG>
***See JavaDocs for Class & Method Purposes***

 - Added Files & Corresponding Methods:
  - KeyboardHandler
   - keyTyped()
   - keyPressed()
   - keyReleased()
  - MouseHandler
- mouseClicked()
   - mousePressed()
   - mouseEntered()
   - mouseExited()
  - MusicControllerGui
   - stop()
  - RunnableRemove
   - getXY()
  - CenterPanel
   - getPreferredScrollableViewportSize()
   - getScrollableUnitIncrement()
   - getScrollableBlockIncrement()
   - getScrollableTracksViewportWidth()
   - getScrollableTracksViewportHeight()
  - GuiMidiImpl
   - setModel()
   - render()
   - playPause()
   - addKeyLis()
  - GuiView (Interface)
   - setModel()
   - render()
   - addMouseListener()
   - addKeyListener()
   - addActionListener()
   - isANote()
   - scroll()
   - getInputNote()
   - playPause()
  - MidiGui
   - playNote()
   - setModel()
   - render()
   - playBeats()
  - ScrollDir
   - getVal()
   - toString()

Added methods to do repeats for the extra credit in the model
</CHANGELOG>

<INSTRUCTIONS>

To RUN the program, run main() in MusicEditor.
main() takes two arguments:
 - a filepath to a song's .txt file
 - a GUI display type:
  - "combine"
  - "midi"
  - "visual"
  - "console"

To PLAY/PAUSE the program, use the SPACE BAR

To SCROLL:
 - FORWARD, use the right arrow key
 - BACKWARD, use the left arrow key
 - END, use the end key
 - BEGINNING, use the home key


To REMOVE a note, click on it.

To ADD a note, use the GUI interaction to select the note's details:
 - Pitch
 - Octave
 - Start beat
 - Duration
- ONLY BEFORE THE PIECE IS STARTED

 ***Notes may be added:
 - somewhere in the piece
 - above highest pitch
 - below lowest pitch
 - after last note
 - before first note

 to REMOVE a note use GUI interaction:
 - click on any part of it
 - ONLY BEFORE THE PIECE IS STARTED



</INSTRUCTIONS>

<OVERVIEW>

Model

 - Song contains a list of Beat.
 - Beat contains a list of Note.
 - Note contains a Pitch, Octave, Duration, and Start Beat.
 - GenericMusicModel is the Interface that controls the Model.

View

 - FactoryView creates a new view from run parameters.
 - GuiViewFrame is the GUI View that pops up when run.
 - MidiView is the MIDI View that plays sound when run.
 - TextView is the TEXT View that outputs console text when run.
 - IMusicView is the Interface that controls the view.
 - GuiView is the Interface that specifically controls the GUI
 - LabelPanel is part of the GUI and helps draw the labels.
 - NotePanel is part of the GUI and helps draw the notes.
 - NumberPanel is part of the GUI and helps draw the numbers.
 - CenterPanel is part of the GUI and helps draw the panels.
 - GuiMidiImpl is the actual implementation of the combined MIDI and GUI
 - MidiGui is the combined implementation of the MIDI and GUI
 - ScrollDir is an enum defining which way the view can scroll.

Controller

 - CompositionBuilder is the Interface that controls the Controller.
 - MusicController is the controller object which helps mediate the
  model and view and defines KeyPress maps.
 - MusicControllerGui extends MusicController and adds Listeners & More
 - MusicReader is the file reader that turns files into Songs.
 - KeyboardHandler is the object that mediates all keyboard presses.
 - MouseHandler is the object that mediates all mouse clicks.


Files

 - All music files are contained in this folder.

MusicEditor
 - Contains the Main() method which is called to run the program.
 - Take two arguments, filepath and view type (text, midi, or gui).

 - MusicModelTest contains tests.

 </OVERVIEW>
