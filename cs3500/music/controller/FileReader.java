package cs3500.music.controller;

import cs3500.music.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private final Path FilePath;
    private static void log(Object aObject){
        System.out.println(String.valueOf(aObject));
    }

/*

    public static void main(String... aArgs) throws IOException {
        FileReader parser = new FileReader("C:\\Users\\IanLeonard\\IdeaProjects\\MusicOOD\\mary-little-lamb.txt");
        parser.readEachLine();
    }
*/

    /**
     Constructor.
     @param FileName full name of an existing, readable file.
     */
    public FileReader(String FileName){
        FilePath = Paths.get(FileName);
    }


    /**
     * Reads each line of the file using readLine
     * @throws IOException
     */
    public SheetMusic fileToSheetMusic() throws IOException {
        SheetMusic sheetMusic = new SheetMusic(new ArrayList<Beat>());

        try (Scanner scanner =  new Scanner(FilePath)){

            scanner.next();
            int tempo = scanner.nextInt();
            log("Tempo: " + tempo);
            scanner.nextLine();

            while (scanner.hasNextLine()){
                sheetMusic.addBeat(new Beat());// FIXME: 6/14/2016 DYNAMICALLY ADD BEATS WHEN NECESSARY?
                sheetMusic.addBeat(new Beat());
                sheetMusic.addBeat(new Beat());
                sheetMusic.addBeat(new Beat());
                sheetMusic.addBeat(new Beat());
                sheetMusic.addBeat(new Beat());

                Note tempNote = readNote(scanner.nextLine());
                sheetMusic.addNote(tempNote); //use appropriate addNote method
            }
        }
        return sheetMusic;
    }

    protected  void readTempo(String line) throws IOException {
        Scanner scanner = null;
            scanner.next();
            int tempo = scanner.nextInt();
            scanner.nextLine();
    }
    /**
     Reads a line of a text file and turns it  into a note
     */
    private Note readNote(String line){
        //use a second Scanner to parse the content of each line
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(" ");

        String type = scanner.next();
        int startBeat = scanner.nextInt();
        int endBeat = scanner.nextInt();
        int WHATISTHIS = scanner.nextInt();
        int noteNumber = scanner.nextInt();
        int WHATISTHISTOO = scanner.nextInt();

        Note result = new Note(
                numToPitch(noteNumber),
                numToOctave(noteNumber),
                noteLength(startBeat, endBeat),
                startBeat);

        return result;
    }

    /**
     * Returns the pitch of a note based on its number.
     * @param noteNumber
     * @return
     */
    private Pitch numToPitch(int noteNumber) {
        int tempNum = noteNumber - (12 * numToOctave(noteNumber));
        return Pitch.values()[tempNum];
    }

    /**
     * Returns the octave of a note based on its number.
     * @param noteNumber
     * @return
     */
    private int numToOctave(int noteNumber) {
        return Math.floorDiv(noteNumber, 12);
    }

    /**
     * Returns the length of a note based on its starting and ending beats.
     * @param startBeat
     * @param endBeat
     * @return
     */
    private int noteLength(int startBeat, int endBeat) {
        return endBeat - startBeat;
    }

}