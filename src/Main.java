import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] gameBoard = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static String player = "X";
    public static Boolean game = true;

    public static void main(String[] args) {
        System.out.println("Welcome to game Piskvorky, dimension 3x3.");
        printGameBoard();
        while (game) {
            getMove();
            printGameBoard();
            checkWin();
        }
        System.out.println("Game over... Good bye!");
    }

    private static void printGameBoard() {
        for (int i = 1; i < 10; i++) {
            System.out.print(" " + gameBoard[i] + " ");
            if (i % 3 != 0) {
                System.out.print("|");
            } else {
                System.out.println();
            }
            if (i < 9 && i % 3 == 0) {
                System.out.println("-----------");
            }
        }
    }

    private static void getMove() {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Player " + player + "'s turn (please enter a number from 1 to 9): ");
            int move = scanner.nextInt();
            if (move > 0 && move < 10 && gameBoard[move].contains(Integer.toString(move))) {
                gameBoard[move] = player;
                player = (player.equals("X")) ? "O" : "X";
                validMove = true;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static void checkWin() {
        String winningPlayer = "D";
        if (gameBoard[1].equals(gameBoard[2]) && gameBoard[1].equals(gameBoard[3])) {
            winningPlayer = gameBoard[1];
        }
        if (gameBoard[4].equals(gameBoard[5]) && gameBoard[4].equals(gameBoard[6])) {
            winningPlayer = gameBoard[4];
        }
        if (gameBoard[7].equals(gameBoard[8]) && gameBoard[7].equals(gameBoard[9])) {
            winningPlayer = gameBoard[7];
        }
        if (gameBoard[1].equals(gameBoard[4]) && gameBoard[1].equals(gameBoard[7])) {
            winningPlayer = gameBoard[1];
        }
        if (gameBoard[2].equals(gameBoard[5]) && gameBoard[2].equals(gameBoard[8])) {
            winningPlayer = gameBoard[2];
        }
        if (gameBoard[3].equals(gameBoard[6]) && gameBoard[3].equals(gameBoard[9])) {
            winningPlayer = gameBoard[3];
        }
        if (gameBoard[1].equals(gameBoard[5]) && gameBoard[1].equals(gameBoard[9])) {
            winningPlayer = gameBoard[1];
        }
        if (gameBoard[7].equals(gameBoard[5]) && gameBoard[7].equals(gameBoard[3])) {
            winningPlayer = gameBoard[7];
        }
        if (winningPlayer.equals("X") || winningPlayer.equals("O")) {
            game = false;
            System.out.println("Player " + winningPlayer + " won!!!!! Congratulation. ");
        } else {
            for (int i = 1; i < 10; i++) {
                if (!gameBoard[i].equals("X") && !gameBoard[i].equals("O")) {
                    winningPlayer = " ";
                }
            }
        }
        if (winningPlayer.equals("D")) {
            game = false;
            System.out.println("Draw. Nobody won.");
        }
    }

}

