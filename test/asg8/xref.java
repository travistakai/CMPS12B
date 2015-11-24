//xref.java
//Main file for asg8

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {

    static void processFile(String filename, boolean debug) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
       	
	for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word: scan.nextLine().split ("\\W+")) {
                //out.printf ("%s: %d: %s%n", filename, linenr, word);
                tree.insert(word, linenr);
            }
        }
	
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
        boolean debug = false;
	String filename = "";

	if (args.length == 0 || args.length >= 3)
	{
	  System.out.println("Incorrect arguments");
	  System.exit(1);
	}

	if(args.length == 2)
	{
	  if(args[0].equals("-d") || args[1].equals("-d"))
	  {
	    debug = true;
	  }
	  
	  if(args[0].contains("txt"))
	  {
	    filename = args[0];
	  }
	  
	  else
	  if(args[1].contains("txt"))
	  {
	    filename = args[1];
	  }
	}

        if(args.length == 1)
        {
          if(args[0].equals("-d"))
          {
            debug = true;
          }

          if(args[0].contains("txt"))
          {
            filename = args[0];
          }
        }


        try {
            processFile(filename, debug);
        }catch (IOException error) {
            auxlib.warn (error.getMessage());
	    System.exit(1);
		//System.out.println("Testing");
        }
        auxlib.exit();
    }

}

