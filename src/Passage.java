import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;


/**
 *
 * The Passage class is a concrete implementation of the abstract Block class
 * Passage contains integer values
 * */
public class Passage extends Block{

    private int value;


    public Passage(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {

        return String.valueOf(value);
    }

    public int getValue()
    {

        return value;
    }


}
