import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;
public class Game {

    /**
     static nested class serving as a vehicle to return two values from a method
     */
    public static class TwoValues
    {
        public int startingColumn;
        public int totalPoints;
    }
    public static TwoValues bestStartingPoint(Field<Block> board)
    {
        TwoValues result = new TwoValues();
        result.startingColumn = 0;
        result.totalPoints = 0;
        int currentHighest= 0;
        int highestSum = 0; // use to check highest in arraylist
        int startingColIndex = 0;

        // Loop through the first line of generated field
        //get all the max summs that each starting indeces can have
        // store all of these max summs in an arraylist
        // return the highest number in the arraylist by looping through arrayList
        // return the corresponding number to the highest sum

        //int firstHighest = bestSum(0,0,board,0);
        for (int i = 0; i < board.getWidth(); i++) // i is the starting collumn index
        {
            highestSum = bestSum(0,i,board,0);
            if(highestSum > currentHighest)
            {
                currentHighest = highestSum;
                startingColIndex = i;
            }

        }

        result.startingColumn = startingColIndex;
        result.totalPoints = currentHighest;



        return result;
    }

    public static ArrayList<Block> bestRoute(Field<Block> board, int col)
    {
        return new ArrayList<Block>();

    }


    //Helper Method:

    // u can choose where to start row and col
    // recursive helper method. highestSum will be the value of the highestSum given the starting point: currRow, currCol
    // technically, you would only need startCol, bc Row would be 0
    public static int bestSum(int currRow, int currCol, Field<Block> board, int highestSum)
    {
        // currRow: index of current row. Most of the time = 0
        //currCol: index of current collumn you want to check
        //highestSum: keeps track of highest sums through recursion.

        if(board.getElement(currRow,currCol) instanceof Obstacle)
        {
            int result = -789987789;
            return result;
        }

        highestSum += board.getElement(currRow,currCol).getValue(); // add in the first given number

        // stop case
        if(currRow == board.getHeight() - 1) // if reach the last row, returns the sum.
        {
            return highestSum;
        }

        /**
         *
         * The left edge cells element can go down or diagonally right, not left
         * */

        //base case 1: when element is left edge
        if(currCol == 0)
        {
            //going down
            /**
             * When you go straight down, you increased the row by one
             * insert that back in the method
             * */
            int down = bestSum(currRow + 1,  currCol,  board,  highestSum); // 5


            // going right
            /**
             * When you go diagonally right, you go one row down and one column right
             * */

            int right = bestSum(currRow + 1,  currCol + 1,  board,  highestSum); // 6

            if(down > right)
            {
                return down;
            }
            else {return right;}
        }

        /**
         *
         * The right edge cells element can go down or left, not right
         * */
        // base case 2: right edge
        if(currCol == board.getWidth() - 1)
        {
            //going down
            int down = bestSum(currRow + 1,  currCol,  board,  highestSum); // 5

            /**
             * When you go diagonally left, you go one row down and one column left
             * */
            // going left

            int left = bestSum(currRow + 1,  currCol - 1,  board,  highestSum); // 6

            if(down > left)
            {
                return down;
            }
            else {return left;}
        }

        /**
         *
         * The cells in the middle have element to the left and right of it
         * These cells also have 3 choices, either to go straight down, left, or right
         * For this reason, we need to take into account of all these scenario
         * */
        //base case 3: middle
        if(currCol < board.getWidth() - 1 && currCol > 0)
        {
            //going down
            int down = bestSum(currRow + 1,  currCol,  board,  highestSum); // 5

            // going right

            int right = bestSum(currRow + 1,  currCol + 1,  board,  highestSum); // 6

            // going left

            int left = bestSum(currRow + 1,  currCol - 1,  board,  highestSum);

            if ( left > down && left > right ){
                return left;
            }else if ( down > left && down > right ){
                return down;
            }else if ( right > down && right > left){return right;}
        }


        return highestSum;


    }



}
