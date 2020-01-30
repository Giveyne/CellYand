package Cell;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class FileBoardSupplier implements BoardSupplier {
    
    private static final String SPLITTER = " ";

    private String filePath;
    private int[][] array = null;


    public FileBoardSupplier() {
        this(getFilePath());
    }

    public FileBoardSupplier(String filePath) {
        this.filePath = filePath;
        readBoardFromFile();
    }


    private static String getFilePath() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter file path: ");
            return in.next();
        }
    }

    private void readBoardFromFile() {

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (lines.isEmpty()) {
            return;
        }

        int xSize = lines.size();
        array = new int[xSize][];
        for (int i = 0; i < xSize; i++) {
            String[] items = lines.get(i).split(SPLITTER);
            array[i] = toIntArray(items);
        }
    }

    private int[] toIntArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int[] intArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    @Override
    public int[][] get() {
        return array;
    }
}
