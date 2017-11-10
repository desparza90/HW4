public class SortDLlist<T extends Comparable<T>> implements SortedListInterface<T>
{
	private DLNode<T> head;	//pointer to beginning of line
	private DLNode<T> tail;	//pointer to end of line
        private DLNode<T> point;	//pointer to specific location
        public int num = 0;

	
        
        public SortDLlist()
                {
                    head = null;
                    tail = null;
                    point = null;
                }
        
        public SortDLlist(T item)
                {
                    head = new DLNode(item, null, null);
                    tail = head;
                    point = head;
                    num++;
                }
   /** Adds a new entry to the end of this List.
	   The list size will increase by 1.
	   Other entry positions will be unaffected
       @param item  An object to be added. */
    public void add(T item)
    {
        DLNode point = head;
	if (head == null)
	{
            head = new DLNode(item, null, null);
            tail = head;
            num++;
	}
	else 
	{
            DLNode node = new DLNode(item, null, null);
            switch(head.compareTo(node))
            {
                case 0: head.prev = node;
                        node.next = head;
                        head = node;
			num++;
			break;
		case 1: head.prev = node;
                        node.next = head;
			head = node;
			num++;
			break;
		case -1: while (point.compareTo(node) < 0 )
                            point = point.next;
                         point.prev = node;
			 node.next = point;
                         num++;
			 break;
            }
		}
		
       if (head == null)
       {
           head = new DLNode(item,null, null);
            tail = head;
       }
       else
       {
           DLNode dlnode = new DLNode(item, null, tail);
           tail.next = dlnode;
           tail = dlnode;
       }
       num++;
   }
   
   /** Removes the entry at the specified location.
	   All items below on list move up on the list
	   The list size will decrease by 1.
	   @param position location of the item you would like to remove
       @throws IndexOutOfBoundsException f either position < 1 or 
			   position > DEFAULT_CAPACITY */
   public void remove(int position)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           DLNode Tnode = head;
           int temp = 1;
           while (temp != position)
           {
               if(temp == position-1)
                   Tnode = point;
               point = point.next;
               temp++;
           }
           Tnode.next = point.next;
           point.next.prev = Tnode;
           point.data = null;
           point.next = null;
           point.prev = null;
           point = head;
           num--;
       }   
   }
   
   /**  Removes all entries from this List. 
		All entries will be effected. */
   public void clear()
   {
       while(head.next != null)
       {
           head.data = null;
           head = head.next;
       }
       head = null;
       tail = null;
       point = null;
   }
   
   /** Verifies if an item is an entry of this List.
	   @param position Where on the list we are looking.
       @return Item if item is found or Null if not. */
   public T view(int position)
   {
       T tempd;
       int temp = 1;
       while (temp != position)
       {
           point = point.next;
           temp++;
       }
       tempd = point.data;
       point = head;
       return tempd;
   }
   
   /** Verifies if an item is an entry of this List.
	   @param position Where on the list we are looking.
       @return true if item is found or false if not. */
   public boolean contains(T item)
   {
       for(int i = 1; i <= num; i++)
       {
           if(item == point.data)
               return true;
       }
       
       return false;
   }
   
   /**  Detects whether this dequeue is empty.
       @return  True if the queue is empty, or false otherwise. */
   public boolean isEmpty()
   {
            return num <= 0;
   }
}