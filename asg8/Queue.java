
import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> {

   private class Node {
      Item item;
      Node next;
   }
   private Node head = null;
   private Node tail = null;

   public boolean isempty() {
      if(head == null)
	return true;

	else
	return false;	
  }

   public void insert(Item newitem) {
   
	if(isempty())
	{
	  head = new Node();
	  head.item = newitem;
	  tail = new Node();
	  tail = head;
	}
	
	else
	{
	  tail.next = new Node();
	  tail.next.item = newitem;
	  tail = tail.next;
	}
   }

   public Iterator <Item> iterator() {
      return new Itor ();
   }

   class Itor implements Iterator <Item> {
      Node current = head;
      public boolean hasNext() {
         return current != null;
      }
      public Item next() {
         if (! hasNext ()) throw new NoSuchElementException();
         Item result = current.item;
         current = current.next;
         return result;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

}
