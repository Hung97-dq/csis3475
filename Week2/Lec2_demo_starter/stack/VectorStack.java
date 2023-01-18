import java.util.Vector;
import java.util.EmptyStackException;

/**
 A class of stacks whose entries are stored in a vector.
 @author Frank M. Carrano and Timothy M. Henry
 @version 5.0
 */
public final class VectorStack<T> implements StackInterface<T>
{
   private Vector<T> stack;   // Last element is the top entry in stack
   private boolean integrityOK;
   private static final int DEFAULT_CAPACITY = 50;
   private static final int MAX_CAPACITY = 10000;
   
   public VectorStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
   
   public VectorStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      stack = new Vector<>(initialCapacity); // Size doubles as needed
      integrityOK = true;
   } // end constructor

   // 6.17
   public void push(T newEntry)
   {
      checkIntegrity();
      stack.add(newEntry);
   } // end push

   // 6.18
   public T peek()
   {
      checkIntegrity();
      if (isEmpty())
         throw new EmptyStackException();
      else
         return stack.lastElement();
   } // end peek
   
   // 6.19
   public T pop()
   {
      checkIntegrity();
      if (isEmpty())
         throw new EmptyStackException();
      else
         return stack.remove(stack.size() - 1);
   } // end pop

   // 6.20
   public boolean isEmpty()
   {
      checkIntegrity();
      return stack.isEmpty();
   } // end isEmpty
   
   // 6.20
   public void clear()
   {
      checkIntegrity();
      stack.clear();
   } // end clear
   
   // Throws an exception if this object is not initialized.
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("VectorStack object is corrupt.");
   } // end checkIntegrity
   
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a stack " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
   } // end checkCapacity
} // end VectorStack

