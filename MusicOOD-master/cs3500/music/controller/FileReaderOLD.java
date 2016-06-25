package cs3500.music.controller;

import cs3500.music.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads in FIles
 *
 * @author Ian Leonard
 */
public class FileReaderOLD {

    private final Path FilePath;
    private static void log(Object aObject){
        System.out.println(String.valueOf(aObject));
    }

/*

    public static void main(String... aArgs) throws IOException {
        FileReaderOLD parser = new FileReaderOLD("C:\\Users\\IanLeonard\\IdeaProjects\\MusicOOD\\mary-little-lamb.txt");
        parser.readEachLine();
    }
*/

    /**
     Constructor.
     @param FileName full name of an existing, readable file.
     */
    public FileReaderOLD(String FileName){
        FilePath = Paths.get(FileName);
    }


    /**
     * Reads each line of the file using readLine
     * @throws IOException
     */
    public Song fileToSheetMusic() throws IOException {
        Song song = new Song(new ArrayList<Beat>(), 0); //FIXME

        try (Scanner scanner =  new Scanner(FilePath)){

            scanner.next();
            int tempo = scanner.nextInt();
            log("Tempo: " + tempo);
            scanner.nextLine();

            while (scanner.hasNextLine()){
                song.addBeat(new Beat());// FIXME: 6/14/2016 DYNAMICALLY ADD BEATS WHEN NECESSARY?
                song.addBeat(new Beat());
                song.addBeat(new Beat());
                song.addBeat(new Beat());
                song.addBeat(new Beat());
                song.addBeat(new Beat());

                Note tempNote = readNote(scanner.nextLine());
                song.addNote(tempNote); //use appropriate addNote method
            }
        }
        return song;
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

        return null;
    }



}