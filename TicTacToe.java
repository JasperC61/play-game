
import java.util.Scanner;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        initBoard();
        do {
            displayBoard();
            getMove();
            makeMove();
            if (isWinner()) {
                displayBoard();
                System.out.println(currentPlayer + " wins!");
                return;
            }
            switchPlayer();
        } while (!isDraw());
        displayBoard();
        System.out.println("It's a draw.");
    }

    private static void makeMove() {
        
    }

	public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("  -----");
        }
    }

    public static void getMove() {
        int row, col;
        System.out.print("Enter row and column for " + currentPlayer + ": ");
        row = sc.nextInt();
        col = sc.nextInt();
        while (board[row][col] != ' ') {
            System.out.println("Space already occupied. Try again.");
            System.out.print("Enter row and column for " + currentPlayer + ": ");
            row = sc.nextInt();
            col = sc.nextInt();
        }
        board[row][col] = currentPlayer;
    }
    
   
    
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public static boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
   
    }
    
    public static boolean checkDiagonals() {
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }}

   