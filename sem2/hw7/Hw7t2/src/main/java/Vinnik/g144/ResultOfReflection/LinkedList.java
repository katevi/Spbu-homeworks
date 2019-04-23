package Vinnik.g144.ResultOfReflection;

import Vinnik.g144.*;

public class LinkedList <Type> extends Object implements List<Type>  {
	private int size = 0;

	ListElement first = null;

	
	public LinkedList() { }

	public boolean isEmpty ()   {
		return true;
	}

	public int size ()   {
		return 0;
	}

	public void addElement (Object arg0)   {
		return ;
	}

	public void print () throws ListIsEmptyException {
		return ;
	}

	public boolean exists (Object arg0)   {
		return true;
	}

	public void removeElement (int arg0) throws IndexOutOfBorderException, ListIsEmptyException {
		return ;
	}
	private class ListElement extends Object  {
	private Object value = null;

	private ListElement next = null;

	final LinkedList this$0 = null;

	
	private ListElement(LinkedList arg0, Object arg1) { }

	
}

	

	
}

	