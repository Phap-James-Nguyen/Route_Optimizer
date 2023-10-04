import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;

/**
 *
 * A generic interface that extends the interface Iterable<T>
 *     We want to overload the one method (Iterator<T>) that is contains in the Iterable Interface
 *
 * */
public interface FlexibleIterable<T> extends Iterable<T>
{

    public Iterator<T> iterator(String iterableObjectName);



}
