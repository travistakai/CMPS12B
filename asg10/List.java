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

	void insertRoom(List adventure, String room, String description, String[][] cmds)
	{
		if(adventure.front == null)
		{
		  adventure.front.room = room;
		  adventure.front.description = description;
		  adventure.front.cmds = cmds;
		  adventure.rear = adventure.front;
		}

		else
		{
		  adventure.rear.next.room = room;
		  adventure.rear.next.description = description;
		  adventure.rear.next.cmds = cmds;
		  adventure.rear = adventure.rear.next;
		}
	}

	void printRooms(List adventure)
	{
		node current = adventure.front;
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
}
