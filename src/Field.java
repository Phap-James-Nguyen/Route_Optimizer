import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;


/**
 *
 * A generic 2D container that represents a field. This class implement FlexibleIterable<T></>
 *
 * */
public class Field<T> implements FlexibleIterable<T>{

    private T[][] matrix;


    public Field(int height, int width)
    {
        this.matrix = (T[][]) new Object[height][width];
    }

    /**
     *
     * @getter
     * @return : generics element
     *
     * return the element at the specified row, col
     * */
    public T getElement(int row, int col)
    {
        return matrix[row][col];
    }

    public void setElement(int row, int col, T el)
    {
       matrix[row][col] = el;
    }

    public int getHeight() // number of rows
    {
        return matrix.length;
    }

    public int getWidth() // number of collumns
    {
        return matrix[0].length;
    }

    /**
     * @toString method
     * @return :String
     *
     * Will essentially be used to print out the field
     *
     * When the column is not at the end, we want to continue adding blank space
     *
     * When the column reaches the end, we dont want to add more space to the right but
     * go to the next line
     * */

    public String toString()
    {
        String result = "";

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                result += matrix[row][col];
                if(col != getWidth() - 1) {
                    result += " ";
                }

            }

            result += "\n";

        }
        return result;
    }

    /**
     *
     * Default Iterator inner class inside of Field
     *
     * We implement the next() and hasNext() method so that it can Iterate to every values
     *
     * */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int row = 0;
            private int col = 0;

            /**
             *
             *
             * if row and collumn values are not outside of 2D array size return false
             * */

            public boolean hasNext() {
                if(row < getHeight() && col < getWidth())
                {
                    return true;
                }
                if(!(row < getHeight()) && !(col < getWidth()))
                {
                    return false;
                }

                return false;
            }


            public T next()
            {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                    T value = matrix[row][col];
                    col++;

                    if (col == getWidth()) {
                        if (row <= getHeight()) {
                            col = 0;
                            row++;
                        }
                    }

                    return value;
                }




            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }



    public Iterator<T> iterator(String iterableObjectName)
    {
        return new FieldIterator(this, iterableObjectName);
    }







}
