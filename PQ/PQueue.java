/** 
	A class implementing an ADT PRIORITY QUEUE using a single linked node
	@authoer Daniel Esparza
	@version 1.0
*/

public class PQue<T extends Comparable<T>> implements PriorityQueueInterface<T>
{

	private Node<T> head;
	private Node<T> tail;
	private int count = 0;
	
	
	public PQue()
	{
		head = null;
		tail = head;
	}
	/** Adds a new entry to the front of this dequeue. The new node is node(item, next)
    @param item  An object to be added. */
	public PQue(T item)
	{
		
		head = new Node(item, null);	
                tail = head;
	}
	
	   /** Adds a new entry to this priority queue.
       @param newEntry  An object to be added. */
	public void add(T newEntry)
	{
		Node point = head;
		Node temp = head;
		if (head == null)
		{
			head = new Node(newEntry, null);
			tail = head;
			count++;
		}
		else 
		{
			Node node = new Node(newEntry, head);
			switch(head.compareTo(node))
			{
				case 0: node.next = head.next;
						head.next = node;
						count++;
						break;
				case 1: node.next = head;
						head = node;
						count++;
						break;
				case -1: while (point.compareTo(node) < 0 )
							 point = point.next;
						 while(temp.next != point)
							 temp = temp.next;
						 temp.next = node;
						 node.next = point;
						 count++;
						 break;
			}
		}
		
	}

   /** Removes and returns the entry having the highest priority.
       @return  Either the object having the highest priority or,
                if the priority queue is empty before the operation, null. */
	public T remove()
	{
		if(head != null)
		{
			T temp;
                        temp = head.data;
			head.data = null;
			if(head.next != null)
			{
				head = head.next;
			}
			count--;
			return temp;
		}
		
                return null;
	}

   /** Retrieves the entry having the highest priority.
       @return  Either the object having the highest priority or,
                if the priority queue is empty, null. */
	public T peek()
	{
		if (head.data != null)
			return head.data;
		else 
			return null;
	}

   /** Detects whether this priority queue is empty.
       @return  True if the priority queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		if (head.data == null && tail.data == null)
			return true;
		else 
			return false;
	}

   /** Gets the size of this priority queue.
       @return  The number of entries currently in the priority queue. */
	public int getSize()
	{
		return count;
	}

   /** Removes all entries from this priority queue. */
	public void clear()
	{
		do{
			head.data = null;
			if(head.next != null)
			{
				head = head.next;
			}				
		}while(head != null);
	}
}