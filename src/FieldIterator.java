import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;

/**
 *
 * Generic class that provide an iterator for Field. This class implements the Iterator interface
 *
 * */
public class FieldIterator<T> implements Iterator<T> {

    private Field<T> field;
    private String iterableObjectName;
    private int x = 0; // will be used to capture the indexes of iterableObjectname in hasNext() and next()
    private int y = 0; // will be used to capture the indexes of iterableObjectname in hasNext() and next()

    public FieldIterator(Field<T> field, String iterableObjectName)
    {
        this.field = field;
        this.iterableObjectName = iterableObjectName;


    }

    /**
     *
     * returns true if there is the next element that is iterableObjectName (Passage or Obstacle)
     *
     * */

    @Override
    public boolean hasNext() //DOUBLE CHECK
    {
        boolean boo = false;

        for (int i = x; i < field.getHeight(); i++) {
            for (int j = y; j < field.getWidth(); j++) {
                if(field.getElement(i,j).getClass().getName().equals(iterableObjectName))
                {
                    x = i;
                    y = j;
                    return true;
                }
            }

            y=0;
            x++;

            /**
             * Loop through the field and check if the next element is the .equals() to iterableObjectName
             * iterableObjectname is either Passage or Obstacle
             *h
             * x and y will capture the indeces if the current element is equal to iterableObjectName,
             *
             *
             *
             * */
        }

        return boo;

        /*
        * HasNext

                boolean boo = false;

                        for (int i = 0; i < field.getHeight(); i++) {
                            for (int j = 0; j < field.getWidth(); j++) {
                                if(field.getElement(i,j).getClass().getName().equals(iterableObjectName))
                                {return true;}
                            }
                        }


                        return boo;\

            Next
          T iterableObjValue = null;

                 if(!hasNext())
                 {
                     throw new NoSuchElementException();
                 }


                 //double loop through it


                 for (int i = 0; i < field.getHeight(); i++) {
                     for (int j = 0; j < field.getWidth(); j++) {
                         if(field.getElement(i,j).getClass().getName().equals(iterableObjectName))
                         {iterableObjValue= field.getElement(i,j);}
                     }
                 }

                 return iterableObjValue;
        *
        *
        * */
    }

    /**
     *
     * As long as there's a next iterableObjectname element in field, return that
     * */
    @Override
    public T next()
    {
        /**
         * x and y indeces are captured in hasNext()
         * these two values are used to get the next element and return it
         *
         * */
        T iterableObjValue = null;

        if(!hasNext())
        {
            throw new NoSuchElementException();
        }

        iterableObjValue= field.getElement(x,y);
        y++;
        return iterableObjValue;
    }



    public void remove(){throw new UnsupportedOperationException();}


    /*public static void main(String[] args) throws FileNotFoundException
    {
        Field<Block> field = FieldGenerator.loadDataFromFile("temp.txt");

         //Example of running a while loop
         //This will invoke the overloaded iterator (the one using the FieldIterator class)
        Iterator<Block> it = field.iterator("Obstacle");
        while(it.hasNext())
        { System.out.println(it.next());}



        System.out.println("--------------------------------");


        Iterator<Block> ite = field.iterator("Passage");
//      Iterator<Block> it = field.iterator("Obstacle"); // same thing for Obstacle objects
        while(ite.hasNext())
        { System.out.println(ite.next());}


    }*/



}
