package Cell;

import java.util.Scanner;

public class RandomBoardSupplier implements BoardSupplier {

    public RandomBoardSupplier() {

    }

    private ArraySize getArraySize() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter X size board: ");
            int xSize = in.nextInt();
            System.out.println("Enter Y size board: ");
            int ySize = in.nextInt();
            return new ArraySize(xSize, ySize);
        }
    }

    private int[][] generateArray(ArraySize arraySize) {
        return generateArray(arraySize.getXSize(), arraySize.getYSize());
    }

    private int[][] generateArray(int xSize, int ySize) {
        int[][] arr = new int[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                arr[i][j] = (int) (Math.random() * 2);
            }
        }
        return arr;
    }

    @Override
    public int[][] get() {
        ArraySize arraySize = getArraySize();
        return generateArray(arraySize);
    }

    private static class ArraySize {
        private int xSize;
        private int ySize;

        ArraySize(int xSize, int ySize) {
            this.xSize = xSize;
            this.ySize = ySize;
        }

        int getXSize() {
            return xSize;
        }

        int getYSize() {
            return ySize;
        }
    }
}