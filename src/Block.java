import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;

/**
 *
 * The Block class represents an abstract building block of a field. This class serves as a
 * parent class for Passage and Obstacle to inherit
 *
 * */

public abstract class Block {

    public abstract int getValue();


}
