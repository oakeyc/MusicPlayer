
Waits for user to start the playing of the music



Model

Song contains a list of Beat.
Beat contains a list of Note.
Note contains a Pitch, Octave, Duration, and Start Beat.

GenericMusicModel is the Interface that controls the Model.

View

FactoryView creates a new view from run parameters.
GuiViewFrame is the GUI View that pops up when run.
MidiView is the MIDI View that plays sound when run.
TextView is the TEXT View that outputs console text when run.
IMusicView is the Interface that controls the model.

LabelPanel is part of the GUI and helps draw the labels.
NotePanel is part of the GUI and helps draw the notes.
NumberPanel is part of the GUI and helps draw the numbers.

Controller

CompositionBuilder is the Interface that controls the Controller.
MusicController is the controller object which helps mediate the model and view.
MusicReader is the file reader that turns files into Songs.

Files
All music files are contained in this folder.

MusicEditor
Contains the Main() method which is called to run the program.
Take two arguments, filepath and view type (text, midi, or gui).

MusicModelTest contains tests.