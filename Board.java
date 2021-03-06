public class Board
{
    //a two dimentional array of Blocks
    protected Block[][] block;
    //a two dimentional array of integers
    protected int[][] board;

    /**
     * constructor
     */
    public Board()
    {
        block = new Block[2][2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                block[i][j] = new Block();
            }
        }
        board = new int[6][6];
        //initialization of the board
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                board[i][j] = 0; 
            }
        }
    }

    /**
     * getter method of each block
     * @param i index of the block
     * @return returns the selected block
     */
    public Block getBlock(int i, int j)
    {
        return block[i][j];
    }

    /**
     * updates the board according to the positions in each block
     */
    public void updateBoard()
    {
        for (int iBlock=0; iBlock<2; iBlock++)
        {
            for (int jBlock=0; jBlock<2; jBlock++)
            {
                for (int i=0; i<3; i++)
                {
                    for (int j=0; j<3; j++)
                    {
                        board[iBlock*3 + i][jBlock*3 + j] = block[iBlock][jBlock].getPosition(iBlock,jBlock);
                    }
                }
            }
        }
    }

    /**
     * prints the game according to each state of array board
     */
    public void printBoard()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                switch (board[i][j])
                {
                    case 0:
                        System.out.print(" __ ");
                        break;
                    case 1: //red
                        System.out.print("\uD83D\uDD34 ");
                        break;
                    case 2: //blue
                        System.out.print("\uD83D\uDD35 ");
                        break;
                }

                if (j == 5)
                    System.out.print("\n");

                if (j == 2)
                    System.out.print("|");
                if (j == 5 && i == 2)
                    System.out.print("-------------------------");
            }
            System.out.println(" ");
        }
    }

    /**
     * checks for each player to see if there is 5 pawns in a row
     * @param player value of the player
     * @return returns the value of player if they win, or 0 if they don't
     */
    public int checkWin(int player)
    {
        for (int i=0; i<2; i++)
        {
            for (int j=0; j<2; j++)
            {
                if (board[i][j] == player
                        && board[i][j] == board[i+1][j]
                        && board[i+1][j] == board[i+2][j]
                        && board[i+2][j] == board[i+3][j]
                        && board[i+3][j] == board[i+4][j])
                    return board[i][j];
                else if (board[i][j] == player
                        && board[i][j] == board[i][j+1]
                        && board[i][j+1] == board[i][j+2]
                        && board[i][j+2] == board[i][j+3]
                        && board[i][j+3] == board[i][j+4])
                    return board[i][j];
            }
        }
        return 0;
    }
}
