//List.java
//Linked list class to be used with main to store room objects

class List
{
	
	private class node
	{
		String room;
		String description;
		String[][] cmds;
		node next;	
	}
	
	
	node front;
	node rear;

	void insertRoom(String room, String description, String[][] cmds)
	{
		if(front == null)
		{
		  front.room = room;
		  front.description = description;
		  front.cmds = cmds;
		  rear = front;
		}

		else
		{
		  rear.next.room = room;
		  rear.next.description = description;
		  rear.next.cmds = cmds;
		  rear = rear.next;
		}
	}

	void printRooms()
	{
		node current = front;
		String tags = "";
		int count = 0;

		while(current != null)
		{
		  while(current.cmds[count][1]  != null)
		  {
		    tags += (current.cmds[count++][1] + " ");
		  }
		  System.out.println(current.description + ": " + tags);
		  tags = "";
		  count = 0;
		  current = current.next;
		}
	}
	
	void options(String room)
	{
		node current = front;
		int count = 1;
		while(current != null)
		{
		  if(current.room == room)
		  {
		    while(current.cmds[count][1]  != null)
		    {
			System.out.println(count + " - " + current.cmds[count][0]);
			count++;
		    }
		  }

		  else
		  current = current.next;
		}
	}

	String choice(String room, int option)
	{
		node current = front;
		String nextRoom = "";
		
		if(option-1 > current.cmds.length)
		{
		  System.out.println("Not a valid option, trry again");
		}
		
		else
		{
		
		  while(current != null)
		  {
		    if(current.room == room)
		    {
		      nextRoom = current.cmds[option][1];
		    }
		    else
		    current = current.next;
		  }
		}

	return nextRoom;
	}
}
