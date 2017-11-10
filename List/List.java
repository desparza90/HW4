public class List<T> implements ListInterface
{
	
	private final Object[] list; 
	private int numberOfEntries = 0;
	private static final int DEFAULT_CAPACITY = 10;

	
        
        public List()
                {
                    this.list = new Object [DEFAULT_CAPACITY];
                }
        
        public List(T newItem)
                {
                    this.list = new Object [DEFAULT_CAPACITY];
                    list[numberOfEntries] = newItem;
                    numberOfEntries++;
                }
   /** Adds a new entry to the end of this List.
	   The list size will increase by 1.
	   Other entry positions will be unaffected
       @param item  An object to be added. */
   public void add(T item)
   {
	   if(numberOfEntries < 10)
		{
			list[numberOfEntries] = item;
			numberOfEntries++;
		}
		else
			System.out.print("List is full");
	   
	   
   }
   
      /** Adds a new entry to the specified position of this List.
	   The list size will increase by 1.
	   All items positions at or below specified position will be effected
	   @param position position in list where item will be added
       @param item  An object to be added. 
	   @throws IndexOutOfBoundsException if either position < 1 or 
			   position > DEFAULT_CAPACITY */
   public void add(int position, T item)
   {
	   int tempnum = numberOfEntries;
	   while (position >= tempnum)
	   {
		   list[tempnum+1] = list[tempnum];
		   tempnum--;
		   
	   }
	   if(numberOfEntries < 10)
		{
			list[numberOfEntries] = item;
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException();
	   
   }
   
   /** Removes the entry at the specified location.
	   All items below on list move up on the list
	   The list size will decrease by 1.
	   @param position location of the item you would like to remove
       @throws IndexOutOfBoundsException f either position < 1 or 
			   position > DEFAULT_CAPACITY */
   public void remove(int position)
   {
       if(list[position] != null)
       {
	   while(position < numberOfEntries)
	   {
		   if(position > numberOfEntries)
			   break;
		   else
		   {
			   list[position] = list[position++];
		   }
	   }
	   list[numberOfEntries] = null;
	   numberOfEntries--;
       }
       else
           throw new IndexOutOfBoundsException();
	   
   }
   
   /**  Removes all entries from this List. 
		All entries will be effected. */
   public void clear()
   {
	   for(int i = 0; i <= numberOfEntries; i++)
		   list[i] = null;
	   
   }
   
   /** Verifies if an item is an entry of this List.
	   @param position Where on the list we are looking.
       @return Item if item is found or Null if not. */
   public Object view(int position)
   {
	   return list[position];
   }
   
   /** Verifies if an item is an entry of this List.
	   @param position Where on the list we are looking.
       @return Item if item is found or Null if not. */
   public Object contains(int position)
   {
	   return list[position];
   }
   
   /**  Detects whether this dequeue is empty.
       @return  True if the queue is empty, or false otherwise. */
   public boolean isEmpty()
   {
	   if(numberOfEntries == 0)
		   return true;
	   else 
		   return false;
   }
   
}