// dllist.java
// Template code for doubly-linked list of strings.
// Contains all doubly linked list functions

import java.util.*;

public class dllist {

   public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

   private class node {
      String item;
      node prev;
      node next;
   }

   private node first = null;
   private node current = null;
   private node last = null;
   private int currentPosition = 0;

   public void setPosition (position pos) {
      switch(pos){
          case FIRST:   current = first;
                        break;
          case PREVIOUS: current = current.prev;
                        break;
          case FOLLOWING: current = current.next;
                        break;
          default:    current = last;
                        break;
        }
   }

   public boolean isEmpty () {
      if(current == null) // check current as that is what most list operations are dealing with
        return true;
      return false;
   }

   public String getItem () {
      return current.item;
   }

   public int getPosition() {
      currentPosition = 0;
      node n = first;
      while(n != null){
          if( n == current) return currentPosition;
          currentPosition++;
          n = n.next;
      }
      return -1;
   }

   public void delete () {
      node prev = current.prev;
      node next = current.next;
      if(prev != null){
          prev.next = next;
          current = prev;
      }
      else 
          first = next;
      if(next != null){
          next.prev = prev;
          current = next;
      }
      else 
          last = prev;
	if(prev == null && next == null)
	current = null;
   }

   public void insert (String item, position pos) {
      node newNode = new node();
      newNode.item = item;
      if(!isEmpty()){ // If empty, not work done on other nodes
          switch(pos){
	      case FIRST:   
                            newNode.next = first;
                            first.prev = newNode;
                            break;
                            
              case PREVIOUS: 
                             newNode.prev = current.prev;
                             newNode.next = current;
                             if(newNode.prev != null) newNode.prev.next = newNode;
                             current.prev = newNode;
                            break;
                            
              case FOLLOWING:
                             newNode.next = current.next;
                             newNode.prev = current;
                             if(newNode.next != null) newNode.next.prev = newNode;
                             current.next = newNode;
                            break;
                            
              default:      
                            last.next = newNode;
                            newNode.prev = last;
                            break;
          }
      }
      if(newNode.prev == null) first = newNode;
      if(newNode.next == null) last = newNode;
      current = newNode;
   }
   
   public void print () {
       node n = first;
       while( n != null){
           System.out.println(n.item);
           n = n.next;
        }
    }
   
   public String[] write()
   {
     int q = 0;
     node n = first;
     while(n != null)
     {
        q++;
        n = n.next;
     }
     String[] content = new String[q];

     n = first;
	
     for(int i = 0; i < q; i++)
        {
          content[i] = n.item;
          n = n.next;
        }
     return content;
   }
   
   

}

