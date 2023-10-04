import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;
public class FieldGenerator {

    /**
     *
     * This method takes in a file with a field and generates the field
     *
     * @return : Field<Block></>
     * */
    public static Field<Block> loadDataFromFile(String filename) //throws FileNotFoundException
    {

        /**
         *
         * Open and reading file
         * Try to check if file exist, if not catch the error and return an empty field
         * */
        File file = new File(filename);
        Scanner scan;
        try
        {
            scan = new Scanner(file);
        }

        catch (FileNotFoundException error)
        {
            Field<Block> f = new Field<>(0,0);
            return f;
            //throw new FileNotFoundException();
        }
        
        int h = 0; // used to store height
        int w = 0; // used to store width

        // an arrayList to store  the lines from file as string arrays
        ArrayList<String[]>countingWidth = new ArrayList<>();


        /**
         *
         * while there is a nextLine in the file
         * split the line by space and store it in an array of strings
         * add those arrays of strings into the arrayList created above
         * While I am doing this, I also keep count of the height and width of the read-in file
         * closed the scanner object
         * */
        while(scan.hasNextLine())
        {
            h++; 
            String wide = scan.nextLine();
            String[] t = wide.split(" ");
            countingWidth.add(t);
            w = t.length;
        }
        
        scan.close();

        /**
         *
         * First, create a new field based on the counted height and width
         * I then made a two nested loops are used to iterate through the elements in the countingWidth list.
         * The outer loop iterates through the string arrays (rows),
         * while the inner loop iterates through the elements (columns) of each string array.
         * Setting the element and using Integer.parseint() to parse in the string
         * */
        
        Field<Block> field = new Field<>(h,w);

        int i = 0;
        for (String[] arr : countingWidth) {
            int j = 0;
            for (String e : arr) {
                try {
                    int value = Integer.parseInt(e);
                    field.setElement(i, j, new Passage(value));
                } catch (NumberFormatException error) {
                    field.setElement(i, j, new Obstacle(e));
                }
                j++;
            }
            i++;
        }

        return field;
    }


    public static Field<Block> randomIntegers(int h, int w, int l, int m, int n) // DOUBLE CHECK
    {
        /*
        * It generates a Field where passages and obstacles have random placements.
        h is the height of the Field
        w is the width of the Field
        l is the lowest random number of points that a Passage can have
        m is the largest random number of points that a Passage can have
        n is the number of Obstacle objects in the Field.
        *
        * */

        Field<Block> field = new Field<>(h, w);
        Random random = new Random();


        /**
         *
         * obstacleCounter: Count the number of obstacles
         *
         * Need this part here because the generator picks random spots to put the obstacle,
         * For this reason, generator can replace an already existing obstacle and we would not
         * obtain the 'n' number of obstacle
         *
         * For this reason, I have to keep track of the number of Obstacles
         * and check if the getElement is not an instanceof Obstacle, if not then generate an obstacle in that spot
         * This way, we going to have 'n' number of Obstacle
         * */

        //generating obstacles
        int obstacleCounter = 0;
        while(obstacleCounter < n){
            int row = random.nextInt(h);
            int col = random.nextInt(w);
            if (!(field.getElement(row, col) instanceof Obstacle)){
                field.setElement(row, col, new Obstacle("-"));
                obstacleCounter +=1;
            }

        }

        /**
         * Used while loop to go through height and width of object
         * Check if it's not an instanceof Obstacle, then create the passage there.
         * We don't want to replace the Obstace with Passages.
         * generate the passage with random integer from the lowest + the difference of max & lowest + 1
         *
         * */

        //Generating passage
        int i = 0;
        while (i < h) {
            int j = 0;
            while (j < w) {
                if (field.getElement(i, j) == null) {
                    if(!(field.getElement(i, j) instanceof Obstacle)) {
                        field.setElement(i, j, new Passage(l + random.nextInt(m - l + 1)));
                    }

                }
                j++;
            }
            i++;
        }



        return field;
    }




}
