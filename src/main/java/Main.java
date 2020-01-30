import Cell.BoardSupplier;
import Cell.RandomBoardSupplier;
import Cell.FileBoardSupplier;
import Cell.Board;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoardSupplier boardSupplier = null;
        if (args.length > 0) {
            if (args[0].equals("-f")) {
                if (args.length > 1) {
                    boardSupplier = new FileBoardSupplier(args[1]);
                } else {
                    boardSupplier = new FileBoardSupplier();
                }
            } else if (args[0].equals("-r")) {
                boardSupplier = new RandomBoardSupplier();
            }
        }

        if (boardSupplier == null) {
            System.out.println("Wrong parameter");
            System.out.println();
            return;
        }

        Board board = new Board(boardSupplier);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                board.calculate();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 0, 1000L);
    }
}

