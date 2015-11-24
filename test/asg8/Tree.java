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

    private void debugHelper(Node tree, int depth) {
        // Output left node, then self, then right; with depth
        // Use is based on examples from textbook
        if(tree.left != null){
            debugHelper(tree.left, depth + 1);
        }
        
        for(int i = depth; i != 0; i--){
            System.out.print("  ");
        }
        System.out.println(depth + " " + tree.key);
        if(tree.right != null){
            debugHelper(tree.right, depth + 1);
        }
    }

    private void outputHelper(Node tree) {
        // Output left node, then self, then right
        if(tree.left != null){
            outputHelper(tree.left);
        }
        
        System.out.print(tree.key + " : ");
        queueOutputHelper(tree.value);
        System.out.println();
        
        if(tree.right != null){
            outputHelper(tree.right);
        }
    }

    public void insert(String key, Integer linenum) 
    {
	Node next = new Node();
	next.value = new Queue<Integer>();
	next.key = key;

	Node n = root;
	
	if(root == null)
	{
	  root = next;
	  root.value.insert(linenum);
	}

	while(n != null)
	{	
	  if(key.compareTo(n.key) < 0)
	  {
	    if(n.left == null)
	    {
		next.key = key;
		n.left = next;
		next.value.insert(linenum);
		break;
	    }
		n = n.left;
	  }
	  
	  else if(key.compareTo(n.key) > 0)
	  {
            if(n.right == null)
            {
		next.key = key;
                n.right = next;
		next.value.insert(linenum);
		break;
            }
            	n = n.right;
	  }
	  
	  else
	  {
	    n.value.insert(linenum);
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
    private void queueOutputHelper(Queue<Integer> value) {
        // Prints all numbers on the present line
        Queue<Integer>.Itor iterator = (Queue<Integer>.Itor)value.iterator();
        while(iterator.hasNext()){
                System.out.print(iterator.next() + " ");
        }
    }

}
