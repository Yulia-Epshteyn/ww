package ww.q1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:
//
//        Apple – a fruit, a tech firm
//        Apple -  a fruit, a tech firm
//        Table – an object, contains rows and columns when used in context of computers
//        Orange – a fruit
//
//        Given a path to the file, do the following:
//
//        a)    Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
//        b)    Read each word and its possible meanings and print them out. Your output should look like this:
//
//        Word1
//        Meaning 1
//        Meaning 2
//        Word2
//        Meaning1
//        Meaning2
//
//        Use appropriate data structures wherever necessary.
public class DictionaryFile {
    private static final String WORD_MEANING_SEPARATOR = " - ";
    private static final String MEANING_SEPARATOR = ";";

    public static boolean doesFileExist(String path) {
        return Files.exists(Paths.get(path));
    }

    public static void printDictionary(String path) {
        if (!doesFileExist(path)) {
            return;
        }
        try {
            final List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                processLine(line);
            }

        } catch (IOException e) {
            System.err.println(String.format("File %s cannot be read", path));
        }
    }

    private static void processLine(String line) {
        final String[] tokens = line.split(WORD_MEANING_SEPARATOR);
        if (tokens.length < 2) {
            return;
        }
        System.out.println(tokens[0].trim());
        final String[] meanings = tokens[1].split(MEANING_SEPARATOR);
        for (String meaning : meanings) {
            System.out.println(meaning.trim());
        }
    }
}


