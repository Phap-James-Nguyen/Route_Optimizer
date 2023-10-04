import java.io.FileNotFoundException;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

        /*Field<Block> field = FieldGenerator.loadDataFromFile("temp.txt");

        for (Block b: field) {

            System.out.println(b.getValue());

        }

        int i = 0;
        System.out.println(field.iterator().hasNext());
        while(field.iterator().hasNext()){
            System.out.println(field.iterator().next());
            //System.out.println(i++);
        }
        System.out.print(field.toString());*/


        public static int bestSum(int currRow, int currCol, int[][] field, int highestSum) // u can choose where to start row and col
        {
            highestSum += field[currRow][currCol];
            // stop case
            if(currRow== field.length - 1)
            {
                return highestSum;
            }


            //base case 1 left edge
            if(currCol == 0)
            {
                //going down
                int down = bestSum(currRow + 1,  currCol,  field,  highestSum); // 5

                // going right

                int right = bestSum(currRow + 1,  currCol + 1,  field,  highestSum); // 6

                if(down > right)
                {
                    return down;
                }
                else {return right;}
            }

            // base case 2: right edge
            if(currCol == field[0].length - 1)
            {
                //going down
                int down = bestSum(currRow + 1,  currCol,  field,  highestSum); // 5

                // going left

                int left = bestSum(currRow + 1,  currCol - 1,  field,  highestSum); // 6

                if(down > left)
                {
                    return down;
                }
                else {return left;}
            }

            //base case 3: middle
            if(currCol < field[0].length - 1 && currCol > 0)
            {
                //going down
                int down = bestSum(currRow + 1,  currCol,  field,  highestSum); // 5

                // going right

                int right = bestSum(currRow + 1,  currCol + 1,  field,  highestSum); // 6

                // going left

                int left = bestSum(currRow + 1,  currCol - 1,  field,  highestSum);

                if ( left > down && left > right ){
                    return left;
                }else if ( down > left && down > right ){
                    return down;
                }else if ( right > down && right > left){return right;}
            }


            return highestSum;


        }



        //public static TwoValues bestStartingPoint(Field<Block> board){}

        //public static ArrayList<Block> bestRoute(Field<Block> board, int col){}

        public static void main(String[] args) {
        int[][] matrix1 = {{1,3,2},
                {50,60,70},
                {500,600,700}};
            for (int[] row : matrix1) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            System.out.println(bestSum(0,2,matrix1, 0));



System.out.println("-------------");



        int[][] matrix2 = {{1,2,3,4,5},
                {50,60,70,80,90},
                {500,600,700,800,900}};

            for (int[] row : matrix2) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        System.out.println(bestSum(0,2,matrix2, 0));
    }



}