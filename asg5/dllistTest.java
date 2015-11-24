// dllistTest.java
// Tests all the functions of dllist.java

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest
{
        @Test
        public void startsEmpty()
        {
          dllist lst = new dllist();
          assertEquals(true, lst.isEmpty());
        }

        @Test
        public void notEmpty()
        {
          dllist lst = new dllist();
	  lst.insert("Hello", dllist.position.LAST);
          assertEquals(false, lst.isEmpty());
        }


        @Test
        public void checkItem()
        {
          dllist lst = new dllist();
	  lst.insert("Hello", dllist.position.LAST);
          assertEquals("Hello", lst.getItem());
	  lst.insert("Hi", dllist.position.LAST);
	  assertEquals("Hi", lst.getItem());
        }

	@Test
        public void frontTest()
	{
	  dllist lst = new dllist();
          lst.insert("Hello", dllist.position.FIRST);
          assertEquals("Hello", lst.getItem());
          lst.insert("Hi", dllist.position.FIRST);
          assertEquals("Hi", lst.getItem());

	}

	@Test
	public void setFirstTest()
	{
	  dllist lst = new dllist();
	  lst.insert("Hello", dllist.position.LAST);
	  lst.insert("Hi", dllist.position.LAST);
	  lst.setPosition(dllist.position.FIRST);
	  assertEquals("Hello", lst.getItem());
	}

        @Test
        public void setLastTest()
        {
          dllist lst = new dllist();
          lst.insert("Hello", dllist.position.FIRST);
          lst.insert("Hi", dllist.position.FIRST);
          lst.setPosition(dllist.position.LAST);
          assertEquals("Hello", lst.getItem());
        }

        @Test
        public void checkLetters()
        {
          dllist lst = new dllist();
          lst.insert("A", dllist.position.LAST);
          lst.insert("B", dllist.position.LAST);
	  lst.insert("C", dllist.position.LAST);
	  lst.insert("D", dllist.position.PREVIOUS);
          lst.setPosition(dllist.position.LAST);
          assertEquals("C", lst.getItem());
        }

        @Test
        public void checkBackwards()
        {
          dllist lst = new dllist();
          lst.insert("A", dllist.position.FIRST);
          lst.insert("B", dllist.position.FIRST);
          lst.insert("C", dllist.position.FIRST);
          lst.insert("D", dllist.position.FOLLOWING);
          lst.setPosition(dllist.position.FIRST);
          assertEquals("C", lst.getItem());
        }

	@Test
	public void insertSet()
	{
	  dllist lst = new dllist();
	  lst.insert("Hello", dllist.position.LAST);
          lst.insert("Hi", dllist.position.LAST);
          lst.insert("Hola", dllist.position.LAST);
          lst.insert("Bonjour", dllist.position.LAST);
          lst.insert("Jambo", dllist.position.LAST);
	  lst.setPosition(dllist.position.PREVIOUS);
	  assertEquals("Bonjour", lst.getItem());
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals("Hola", lst.getItem());
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals("Hi", lst.getItem());
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals("Hello", lst.getItem());
          lst.setPosition(dllist.position.FOLLOWING);
          assertEquals("Hi", lst.getItem());
	}

        @Test
        public void insertGet()
        {
          dllist lst = new dllist();
          lst.insert("Hello", dllist.position.LAST);
          lst.insert("Hi", dllist.position.LAST);
          lst.insert("Hola", dllist.position.LAST);
          lst.insert("Bonjour", dllist.position.LAST);
          lst.insert("Jambo", dllist.position.LAST);
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals(3, lst.getPosition());
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals(2, lst.getPosition());
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals(1, lst.getPosition());
          lst.setPosition(dllist.position.PREVIOUS);
          assertEquals(0, lst.getPosition());
          lst.setPosition(dllist.position.FOLLOWING);
          assertEquals(1, lst.getPosition());
        }
	@Test
	public void deleteTest()
	{
	  dllist lst = new dllist();
	  lst.insert("Hello", dllist.position.LAST);
	  lst.insert("Hi", dllist.position.LAST);
	  lst.insert("Hola", dllist.position.LAST);
	  lst.setPosition(dllist.position.PREVIOUS);
	  lst.delete();
	  assertEquals("Hola", lst.getItem());
	}
	
	@Test(expected=Exception.class)
	public void exceptionTest()
	{
	  dllist lst = new dllist();
	  lst.getItem();
	}

	
}
