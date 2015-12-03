class List
{
	
	
	private class node
	{
		private String room;
		private String[][] cmds;
		private node next;
		
	}
	
	node front;
	node rear;

	void insertRoom(List adventure, String room, String[][] cmds)
	{
		if(adventure.front == null)
		{
		  adventure.cmds = cmds;
		  adventure.rear = adventure.front;
		}

		else
		{
		  adventure.rear.next.room = room;
		  adventure.rear.next.cmds = cmds;
		  adventure.rear = adventure.rear.next;
		}
	}
}
