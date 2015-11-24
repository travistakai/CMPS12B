//Tree.java
//Tree class for the main function of asg8

import static java.lang.System.*;

class Tree {

    private class Node {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) 
    {
	int tabs = depth;
	
	if(tree != null)
        {
          debugHelper(tree.left, depth+1);
          
	  for(int i = tabs; i > 0; i--)
	  {
	    System.out.print("  ");
	    tabs--;
	  }
	  System.out.println(depth + " " + tree.key);
	  
          debugHelper(tree.right, depth+1);
        }

    }

    private void outputHelper(Node tree) {
        // Your code here might be recursive
        throw new UnsupportedOperationException();
    }

    public void insert(String key, Integer linenum) 
    {
	Node next = new Node();
	next.value = new Queue<Integer>();
	next.key = key;

	Node current = root;
	
	if(root == null)
	{
	  root = next;
	}

	//System.out.println(next.key);
	//Node n = root;	
	
	//System.out.println(n.key);
	while(current != null)
	{
	//System.out.println("Hello");	
	  if(key.compareTo(current.key) < 0)
	  {
	    if(current.left == null)
	    {
		next.key = key;
		current.left = next;
		//System.out.println("<F3><F3><F3>");
		next.value.insert(linenum);
		break;
	    }
		//System.out.println("left");
		current = current.left;
	  }
	  //current = current.left;
	  
	  else if(key.compareTo(current.key) > 0)
	  {
            if(current.right == null)
            {
		next.key = key;
                current.right = next;
		//System.out.println("-----");
		next.value.insert(linenum);
		break;
            }
		//System.out.println("right");
            	current = current.right;
	  }
	  //current = current.right;
	  
	else
	{
	  current.value.insert(linenum);
	  break;
	}
       }
    }
    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }

}
