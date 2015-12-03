//Stack.java
//Stack that holds the order in which the player plays the game
//Makes easy to traverse back down the line of commands with "z"


class Stack
{
	int top = 0;
	String[] stack = new String[100];	

	void push(String room)
	{
		stack[top++] = room;
	}

	void pop()
	{
		if(top != 0)
		  top--;

		else
		  System.out.println("Can't undo any more!");
	}
}
