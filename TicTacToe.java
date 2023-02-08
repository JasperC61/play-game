
import java.util.Scanner;

public class TicTacToe {
	/*
	 這段程式碼宣告了三個靜態變數：
     sc：一個 Scanner 物件，用來讀取使用者輸入。
     board：一個二維字元陣列，用來表示井字遊戲的棋盤。
	 currentPlayer：一個字元，用來表示目前玩家。初始值為字元 'X'，代表先手玩家。 
	 */
    static Scanner sc = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
   
    
    /*
     這段程式碼是整個程式的主程式，主要功能如下：
	初始化棋盤：呼叫 initBoard() 將棋盤上的所有格子設為空白。
	迴圈：使用 do-while 迴圈進行多次遊戲，直到某位玩家贏了或是平局結束。
	顯示棋盤：呼叫 displayBoard() 顯示棋盤。
	取得玩家的下棋位置：呼叫 getMove() 取得玩家的下棋位置。
	呼叫 makeMove() 下棋。
	判斷是否有人贏了：呼叫 isWinner() 判斷是否有人贏了。如果有人贏了，顯示贏家的結果。
	判斷是否平局：呼叫 isDraw() 判斷是否平局。如果平局，顯示平局的結果。
	切換玩家：呼叫 switchPlayer() 切換玩家。 
     */
    public static void main(String[] args) {
        initBoard();
        do {
            displayBoard();
            getMove();
            makeMove();
            if (isWinner()) {
                displayBoard();
                System.out.println(currentPlayer + "贏了!");
                return;
            }
            switchPlayer();
        } while (!isDraw());
        displayBoard();
        System.out.println("平手.");
    }
    
    /*
     
     */

    private static void makeMove() {
    	System.out.println("落子");
    }
    
    /*
     這段程式碼的主要功能是對井字遊戲的棋盤進行初始化，把所有棋盤的位置設置為空格（' '）。
     它是通過使用兩個循環來遍歷每個棋盤位置并設置其值為空格來實現的。
     */

	public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
	
	/*
	 這段程式碼的功能是顯示井字遊戲的遊戲盤面。它使用迴圈遍歷 board 二維陣列，
	 並在每個格子上顯示 X 或 O，如果格子是空的則顯示空格。同時還有一些輔助文字
	 ，用於顯示行和列的索引，以及每行的分界線。
	 */

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
    
   /*
    這段程式碼定義了一個名為 getMove() 的方法，它是遊戲的一個重要部分，用於得到當前玩家的下棋位置。
     首先，它使用全局變量 sc 定義了兩個本地變量 row 和 col，它們用於存儲玩家輸入的棋盤位置。
      接下來，它向玩家輸出當前玩家的提示，以便輸入棋盤位置。玩家輸入的位置存儲在 row 和 col 變量中。
      接下來，使用 while 循環檢查所選位置是否已被占用。如果是，程序向玩家輸出錯誤信息，然後再次要求玩家輸入位置。
      這個循環會一直持續，直到玩家選擇了一個未被占用的位置。
      最後，程序將當前玩家的字符放入該位置，表示該玩家已經在該位置下了一個棋子。
    */
   
   
   
   
    public static void getMove() {
        int row, col;
        System.out.print("請輸入列-欄位置 " + currentPlayer + ": ");
        row = sc.nextInt();
        col = sc.nextInt();
        while (board[row][col] != ' ') {
            System.out.println("該位置已被佔據.請重下");
            System.out.print("請輸入列-欄位置 " + currentPlayer + ": ");
            row = sc.nextInt();
            col = sc.nextInt();
        }
        board[row][col] = currentPlayer;
    }
    
   /*
    這段程式碼的功能是判斷在一場井字遊戲中是否發生和局。
    它通過循環檢查整個棋盤數組，如果找到任意一個空格，則返回false，
    表示還有可用的空格，游戲還未結束。如果没有空格，則返回true，表示棋盤已經被填滿，
    游戲結束且没有贏家，即和局。
    */
    
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
    
    
   /*
    這段程式碼是定義了一個名為"switchPlayer"的靜態方法，它是用來在玩家進行完一步操作後切換下一個玩家的操作。
     方法的邏輯是：首先檢查現在的玩家是否為 "X"，如果是，則將玩家切換為 "O"；如果不是，則將玩家切換為 "X"。
    */
    public static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
    
    /*
     這段程式碼用於判斷當前玩家是否獲勝。
     它通過調用 checkRows，checkColumns，和 checkDiagonals 這三個方法來實現這個功能。
     如果任意一個方法返回 true，則 isWinner 會返回 true，否則返回 false。
     這表示如果當前玩家在棋盤上的任意一行，一列或對角線上都有三個連續的棋子，則當前玩家就是贏家。
     */

    public static boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }
    
    
    /*
     這段程式碼定義了一個方法 checkRows()，這個方法用於檢查棋盤上是否存在一行的三個位置都被同一方所填寫（也就是三子連線）
     方法的主要功能是利用一個 for 迴圈檢查棋盤的每一行是否都被同一方填寫。如果有任意一行被填寫，則返回 true，表示有三子連線；
     否則返回 false，表示沒有三子連線。
     */
    public static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }
    
    /*
     這段程式碼的主要功能是檢查「三個棋子都連續且被填滿」遊戲的計分表的每一個欄是否有被同一個玩家的棋子填滿。如果滿了，就回傳 true；否則回傳 false。
     */

    public static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
   
    }
    
    
    /*
     這段程式碼為 Java 中的方法 checkDiagonals()，它檢查在井字遊戲的棋盤上是否有玩家贏了遊戲。此方法會檢查兩條對角線，
     分別是左上角到右下角和右上角到左下角。檢查方式是，如果對角線上的三個位置都被同一位玩家填寫，則返回 true，表示該玩家贏了遊戲；
     如果兩條對角線都沒有贏家，則返回 false。
     */
    public static boolean checkDiagonals() {
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }}

   