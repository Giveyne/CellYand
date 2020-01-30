package Cell;

import util.Utils;

public class Board {

    private int[][] arr;
    private int[][] resultArray;
    private int xSize;
    private int ySize;

    public Board(BoardSupplier cellsSupplier) {
        this(cellsSupplier.get());
    }

    public Board(int[][] arr) {
        this.arr = arr;
        printArray();
        calculateSize();
        initArrayToCopy();
    }

    private void initArrayToCopy() {
        this.resultArray = new int[xSize][ySize];
    }

    private void calculateSize() {
        xSize = arr.length;
        ySize = xSize == 0 ? 0 : arr[0].length;
    }


    public void calculate() {
        checkBoard();
        showResult();
    }

    private void checkBoard() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                checkCell(x, y);
            }
        }
        switchArrays();
    }

    private void checkCell(int x, int y) {
        if (arr[x][y] == 1)
            checkAliveCell(x, y);
        else {
            checkDeadCell(x, y);
        }
    }

    private int neighbors(int x, int y) throws ArrayIndexOutOfBoundsException {

        int startX = findStartIndex(x);
        int stopX = findXStopIndex(x);
        int startY = findStartIndex(y);
        int stopY = findYStopIndex(y);

        int count = 0;
        for (int i = startX; i <= stopX; i++) {
            for (int j = startY; j <= stopY; j++)
                count += arr[i][j];

        }
        return count - arr[x][y];
    }

    private int findStartIndex(int i) {
        return i == 0 ? i : (i - 1);
    }

    private int findXStopIndex(int x) {
        return (x == xSize - 1) ? xSize - 1 : (x + 1);
    }

    private int findYStopIndex(int y) {
        return (y == ySize - 1) ? ySize - 1 : y + 1;
    }

    private void checkAliveCell(int x, int y) {
        int numOfNeighbors = neighbors(x, y);
        resultArray[x][y] = isStillAlive(numOfNeighbors) ? 1 : 0;
    }

    private boolean isStillAlive(int numOfNeighbors) {
        return numOfNeighbors == 2 || numOfNeighbors == 3;
    }

    private void checkDeadCell(int x, int y) {
        int numOfNeighbors = neighbors(x, y);
        resultArray[x][y] = isStillDead(numOfNeighbors) ? 0 : 1;
    }

    private boolean isStillDead(int numOfNeighbors) {
        return numOfNeighbors != 3;
    }

    private void switchArrays() {
        int[][] arrTemp = arr;
        arr = resultArray;
        resultArray = arrTemp;
    }

    private void showResult() {
        printArray();
    }

    private void printArray() {
        System.out.println(Utils.arrayToString(arr));
    }
}
