/**
 *
 * @author despa
 * @param <T>
 */
public class DLNode<T extends Comparable<? super T>> implements Comparable<DLNode<T>>
{
	T data;
	DLNode<T> next;
	DLNode<T> prev;
	
	public DLNode() {
		data = null;
		next = null;
		prev = null;
	}

	public DLNode(T newItem, DLNode nextN, DLNode prevN)
	{
		this.data = newItem;
		this.next = nextN;
		this.prev = prevN;
	
	}

        @Override
        public int compareTo(DLNode<T> nod)
        {
            return data.compareTo(nod.data);
        }
}