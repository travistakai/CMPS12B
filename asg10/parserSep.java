import static java.lang.System.*;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class parserSep
{

	public static void main(String[] args) throws IOException
	{
	  
	BufferedReader in = new BufferedReader(new FileReader(args[0]));
	BufferedReader readIn = new BufferedReader(new InputStreamReader(System.in));
	
	int lineCount = 0;
	while (in.readLine() != null)
	{
	  lineCount++;
	}
	
	//array of lines from file read-in
	String[] unsorted = new String[lineCount];
	int i = 0;

	//string we are cutting into substrings
	String sep = "";

	String roomName = "";
	int r = 0;
	String desc = "";
	String temp = "";

	List adventure = new List();
	
	while(i < lineCount)
	{
	  sep = unsorted[i];
	  temp = sep.substring (0,1);
	  String[][] cmds = new String[30][2];

	  if(temp.equals("r"))
	  {
	    if(roomName != "")
	    {
	      adventure.insertRoom(roomName, desc, cmds);
	      r = 0;
	    }
	    roomName = sep.substring(2, sep.length());
	  }
	  
	  if(temp.equals("d"))
	  {
	    desc = desc.concat(sep.substring(2, sep.length()));
	  }
	  
	  if(temp.equals("o"))
	  {
	    cmds[r][0] = sep.substring(2, sep.length());
	  }
	
	  if(temp.equals("t"))
	  {
	    cmds[r][1] = sep.substring(2, sep.length());
	  }

	  i++;
	}
	
	String room = adventure.firstRoom();

	String option = "";
	char input = 's';
	Stack history = new Stack();
	history.push(room);
	
	//Input from user
	while(!option.equals("q"))
	{
	  option = readIn.readLine();

	  if(option.length() > 1)
	  {
	    System.out.println("Invalid choice! Try again");
	  }

	  else
	  {
	    input = option.charAt(0);
	    if(option != "")
	    {
	      //checks if its in range of valid options
	      if(((int)input)-97 < 13)
	      {
	        room = adventure.choice(room, input);
		history.push(room);
		adventure.options(room);
	      }
	
	      else
	      {
		if((int)input-97 == 16)
		{
		  System.out.println("Exit status: 0");
		  System.exit(0);
		}
		
		else
		if((int)input-97 == 17)
		{
		  history.restart(adventure.firstRoom());
		}
	      }
	    }
	  }
	}
}

}
	



