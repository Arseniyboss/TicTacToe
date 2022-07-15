import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);

    private static char[][] board = new char[3][3];
    static final char PLAYER = 'X';
    static final char COMPUTER = 'O';

    public static void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board[row][column] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.printf(" %c | %c | %c ", board[0][0], board[0][1], board[0][2]);
        System.out.printf("\n---|---|---\n");
        System.out.printf(" %c | %c | %c ", board[1][0], board[1][1], board[1][2]);
        System.out.printf("\n---|---|---\n");
        System.out.printf(" %c | %c | %c ", board[2][0], board[2][1], board[2][2]);
        System.out.println();
        System.out.println();
    }

    public static int checkFreeSpaces() {
        int freeSpaces = 9;

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] != ' ') {
                    freeSpaces--;
                }
            }
        }

        return freeSpaces;
    }

    public static void playerMove() {
        int row;
        int column;

        do {
            System.out.print("Enter row #(1-3): ");

            row = scanner.nextInt();
            row--;

            System.out.print("Enter column #(1-3): ");
            column = scanner.nextInt();
            column--;

            System.out.println();

            if ((row < 0 || row > 2) || (column < 0 || column > 2) || board[row][column] != ' ') {
                System.out.println("Invalid move!\n");
            } else {
                board[row][column] = PLAYER;
                break;
            }
        } while ((row < 0 || row > 2) || (column < 0 || column > 2) || board[row][column] != ' ');
    }

    public static void computerMove() {
        int row;
        int column;
        Random random = new Random();

        if (checkFreeSpaces() > 0) {
            do {
                row = random.nextInt(3);
                column = random.nextInt(3);
            } while (board[row][column] != ' ');

            board[row][column] = COMPUTER;
        } else {
            printWinner(' ');
        }
    }

    public static char checkWinner() {
        // check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][0] == board[row][2]) {
                return board[row][0];
            }
        }

        // check columns
        for (int column = 0; column < 3; column++) {
            if (board[0][column] == board[1][column] && board[0][column] == board[2][column]) {
                return board[0][column];
            }
        }

        // check diagonals

        // left diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0];
        }

        // right diagonal
        if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
            return board[2][0];
        }

        return ' ';
    }

    public static void printWinner(char winner) {
        if (winner == PLAYER) {
            System.out.println("You won!");
        } else if (winner == COMPUTER) {
            System.out.println("You lost!");
        } else {
            System.out.println("It's a draw!");
        }
        System.out.println();
    }
}
