// edfile.java
// Template for a line-oriented text editor inspired by ed.
// Main function for the doubly linked list text editor

import java.util.Scanner;
import static java.lang.System.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;

class edfile{

   public static void main (String[] args) throws IOException  {
     String[] cmds = new String[args.length];
     dllist list = new dllist();
	for(int i = 0; i< args.length; i++)
	{
	cmds[i] = args[i];
	}
	
	
	
	if(cmds.length > 1)
	{
	  	if(cmds[1].contains("txt"))
	  	{
	    	BufferedReader in = new BufferedReader(new FileReader(cmds[1])); 
	    	String holder = in.readLine();
	    	while(holder != null)
	    	{
		list.insert(holder, dllist.position.LAST);
   
		//System.out.println(list.getItem());
		holder = in.readLine();
	    	}
		}
	        
		else
		{
                System.out.println("No such file exists");
                System.exit(1);
            	}
	}
	else
	   if(cmds.length == 1)
	   {
		if(cmds[0].contains("txt"))
		{
		BufferedReader in = new BufferedReader(new FileReader(cmds[0]));
            	String holder = in.readLine();
           	while(holder != null)
           	{
                list.insert(holder, dllist.position.LAST);

                //System.out.println(list.getItem());
                holder = in.readLine();
            	}

		}
		else
		{
		System.out.println("No such file exists");
		System.exit(1);
		}
	   }
      
      boolean want_echo = false;

      if(cmds.length > 0)
      {
	if(cmds[0] == "-e")
	  want_echo = true;
	else
	  want_echo = false;
      }
      System.out.println("Beginning edfile");
      Scanner stdin = new Scanner (in);
     
      boolean eof = false;
      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) continue;
         char command = inputline.charAt(0);
         switch (command) {
            case '#': break;
            case '$': list.setPosition(dllist.position.LAST); System.out.println(list.getItem()); break;
            case '*': list.print(); list.setPosition(dllist.position.LAST);   break;
            case '.': System.out.println(list.getItem()); break;
            case '0': list.setPosition(dllist.position.FIRST); System.out.println(list.getItem()); break;
            case '<': list.setPosition(dllist.position.PREVIOUS); System.out.println(list.getItem()); break;
            case '>': list.setPosition(dllist.position.FOLLOWING); System.out.println(list.getItem()); break;
            case 'a': list.insert(inputline.substring(1), dllist.position.FOLLOWING);  System.out.println(list.getItem()); break;
            case 'd': list.delete(); break;
            case 'i': list.insert(inputline.substring(1), dllist.position.PREVIOUS);  System.out.println(list.getItem()); break;
            case 'r': try
			{
			  int count = 0;
			  BufferedReader fileName = new BufferedReader(new FileReader(inputline.substring(1)));
			  String placeHolder = fileName.readLine();
			  while(placeHolder != null)
			  {
			    list.insert(placeHolder, dllist.position.LAST);
			    count++;
			    placeHolder = fileName.readLine();
			  }
			  System.out.println("New lines inserted: " +count);
			}
		      catch(FileNotFoundException e)
		      {
			System.out.println("File doesn't exist");
			eof = true;
		      }
			break;

            case 'w':   File file = new File(inputline.substring(1));
			if(!file.exists() && inputline.substring(1).contains("txt"))
			{
			  file.createNewFile();
			}
			else
			{
			  System.out.println("File already exists");
			  eof = true;
			  break;
			}

			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter writing = new BufferedWriter(fileWrite);
			
			String[] words = list.write();
			for(int i = 0; i < words.length; i++)
			{
			  writing.write(words[i]);
			  writing.newLine();
			}
			writing.close();
			System.out.println(words.length);
			break;

	    case 'e':   if(eof == true)
			{
			System.out.println("Invalid commands, options or file accesses were detected");
			System.exit(1);
        		}
			else
			System.out.println("Clean Exit");
        		System.exit(0);

			
            default : System.out.println("Invalid command"); eof = true;  break;
         }
      }
     }

}

