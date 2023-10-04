import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;

/**
 *
 * The Obstacle class represents a cell of a field that is an obstacle.
 * This concrete class inherit Block
 * Obstacle contain integer values of zero
 * */
public class Obstacle extends Block{

    private String label;
    public Obstacle(String label)
    {
        this.label = label;
    }


    public String toString()
    {
        return label;
    }

    public int getValue()
    {
        int result = 0;


        return result;



    }


}
