import java.util.Scanner;//This line imports the Scanner class from the java.util package, which is used to read user input.
public class tictactoe{//This line starts the definition of a new class called tictactoe.
    private static final int ROW = 3;
    private static final int COL = 3;//These lines define two constants ROW and COL, which are initialized to 3.
    private static String board [][] = new String[ROW][COL];//This line declares a two-dimensional array board of type String with dimensions ROW and COL. This array will be used to store the state of the Tic Tac Toe game.
    private static void clearBoard()//This line declares a private static method named clearBoard() which does not return any value.
    {
        for(int i=0;i<ROW;i++)// This line declares a for loop which initializes a variable i to 0, and continues to execute the loop as long as i is less than the value of ROW (assuming ROW is a constant or variable declared elsewhere in the code).
        {
            for(int j=0;j<COL;j++)//This line declares a nested for loop which initializes a variable j to 0, and continues to execute the loop as long as j is less than the value of COL (assuming COL is a constant or variable declared elsewhere in the code).
                board[i][j] = " ";//This line assigns an empty string to the ith row and jth column of the 2D array board. This effectively clears the board by setting all positions to an empty string.
        }
    }
    private static void display()//This line declares a private static method named display() which does not return any value.
    {
        for(int i=0;i<3;i++)//This line declares a for loop which initializes a variable i to 0, and continues to execute the loop as long as i is less than 3.
        {
            for(int j=0;j<3;j++)//This line declares a nested for loop which initializes a variable j to 0, and continues to execute the loop as long as j is less than 3.
            {
                System.out.print(board[i][j]) ;//This line prints the value at the ith row and jth column of the board 2D array.
                if(j != 2)//This line begins an if statement that checks if j is not equal to 2.
                    System.out.print(" |");// This line prints a vertical bar (|) character to separate the columns of the Tic-Tac-Toe board.
            }
            if(i != 2)// This checks if the current row being printed is not the last row.
                System.out.print("\n------------");//This prints a line of dashes to separate rows visually.
            System.out.println();//This prints a newline character to move to the next line after printing a row.
        }
        System.out.println();//This prints an extra newline character after printing all the rows to add some vertical space.
    }
    private static boolean isValidMove(int row, int col)//This declares a new method that takes two integer arguments row and col and returns a boolean value.
    {
        return(board[row][col].equals(" "));//This returns true if the position in board at the row and col indices is empty (i.e., equals " "), and false otherwise.
    }
    private static boolean isWin(String player)//This declares a new method isWin that takes a string argument player and returns a boolean value.
    {
        return(isColWin(player) || isRowWin(player) || isDiagnalWin(player));//This returns true if any of the isColWin, isRowWin, or isDiagonalWin methods return
    }
    private static boolean isColWin(String player)//This declares a new method isColWin that takes a string argument player and returns a boolean value.
    {
        for(int i=0;i<COL;i++)//This starts a loop that iterates over each column in board.
        {
            if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))//This checks if the player has three marks in a row in the current column i, returning true if so.
                return true;
        }
        return false;// if no column is found to have three marks in a row.
    }
    private static boolean isRowWin(String player)//This declares a new method isRowWin that takes a string argument player and returns a boolean value.
    {
        for(int i=0;i<ROW;i++)//This is a for loop that iterates through each row of the game board. ROW is a constant variable that represents the number of rows in the game board.
        {
            if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
                return true;//This checks if there is a win condition in the current row for the given player. It checks if the player's symbol is present in each of the three positions in the current row. If so, it returns true indicating that the player has won.
        }
        return false;//This is the end of the loop and indicates that there is no win condition in any row for the given player. The method returns false.
    }
    private static boolean isDiagnalWin(String player)//This is a method that checks if the given player has won diagonally. The method takes in a player's symbol as an argument.
    {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
            return true;//This checks if the player's symbol is present in all three positions of the diagonal from top-left to bottom-right. If so, it returns true indicating that the player has won
        if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            return true;//This checks if the player's symbol is present in all three positions of the diagonal from top-right to bottom-left. If so, it returns true indicating that the player has won.
        return false;//This is the end of the method and indicates that there is no diagonal win condition for the given player. The method returns false.
    }
    private static boolean isTie()//This is a method that checks if the game has ended in a tie.
    {
// loop to check if there are any empty space
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COL;j++)
            {
                if(board[i][j].equals(" "))
                    return false;
            }
        }//This loop checks if there are any empty spaces on the game board. If there are no empty spaces, it means that the game has ended in a tie, and the method returns true.
        return true;//This is the end of the method and indicates that the game has not ended in a tie. The method returns false.
    }
    private static String togglePlayer(String player)//This is a method that switches the current player. The method takes in the current player's symbol as an argument and returns the symbol of the next player.
    {
        if(player.equals("X"))
            return "0";
        else
            return "X";//This checks if the current player is "X". If so, it returns "1" which represents the symbol for the next player. Otherwise, it returns "2" which represents the symbol for the other player.
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);//This creates a new instance of the Scanner class to read user input from the console.
        String player;
        int row, col;//These are variable declarations. player will hold the current player's symbol, while row and col will hold the row and column numbers entered by the user.
        do {
            clearBoard();  // Clear the game board before starting a new game
            player = "X";  // Set the starting player to X
            while (!isWin("X") && !isWin("O") && !isTie())  // Loop until a win or tie is detected
            {
                display();  // Display the current game board
                row = SafeInput.getRangedInt(console, "Player " + player + ", enter row number: ", 1, ROW);  // Prompt the current player for their move row
                col = SafeInput.getRangedInt(console, "Player " + player + ", enter column number: ", 1, COL);  // Prompt the current player for their move column
                while (!isValidMove(row - 1, col - 1))  // Loop until a valid move is entered by the current player
                {
                    System.out.println("The position is already occupied. Please re-enter");  // Display an error message to the user
                    row = SafeInput.getRangedInt(console, "Player " + player + ", enter row number: ", 1, ROW);  // Prompt the current player again for their move row
                    col = SafeInput.getRangedInt(console, "Player " + player + ", enter column number: ", 1, COL);  // Prompt the current player again for their move column
                }
                board[row - 1][col - 1] = player;  // Update the game board with the current player's move
                if (isWin(player))  // Check if the current player has won the game
                    break;
                player = togglePlayer(player);  // Switch to the other player for the next turn
            }
            display();  // Display the final game board
            if (!isTie())  // Check if the game ended in a tie
                System.out.println("Player " + player + " wins!");  // Display the winning player
            else
                System.out.println("Its a tie!");  // Display a tie message
            System.out.println();  // Print an empty line for formatting
        } while (SafeInput.getYNConfirm(console, "Do you want to play another game (Y/N)? "));  // Prompt the user if they want to play another game and loop if they do
    }}
