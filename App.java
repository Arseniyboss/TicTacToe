import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char winner = ' ';
        char response = ' ';

        do {
            winner = ' ';
            response = ' ';
            TicTacToe.resetBoard();
            System.out.println();

            while (winner == ' ' && TicTacToe.checkFreeSpaces() != 0) {
                TicTacToe.printBoard();
                TicTacToe.playerMove();
                winner = TicTacToe.checkWinner();
                if (winner != ' ' || TicTacToe.checkFreeSpaces() == 0) {
                    break;
                }

                TicTacToe.computerMove();
                winner = TicTacToe.checkWinner();
                if (winner != ' ' || TicTacToe.checkFreeSpaces() == 0) {
                    break;
                }
            }

            TicTacToe.printBoard();
            TicTacToe.printWinner(winner);

            System.out.print("Would you like to play again? (Y/N): ");
            response = Character.toUpperCase(scanner.nextLine().charAt(0));
        } while (response == 'Y');

        System.out.println("Thanks for playing!");
    }
}