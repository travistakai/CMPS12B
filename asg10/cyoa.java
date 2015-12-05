//cyoa.java
//Main class to run the adventure

class cyoa
{

	public static void main (String[] args)
	{
		List adventure = new List();
		String room = "";
		String description = "";
		String[][] cmds = new String[2][2];
		cmds[1][1] = "";
		adventure.insertRoom(room, description, cmds); 
		String tag = adventure.choice(2);
		

	}

}
