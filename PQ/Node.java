public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>>
{
	T data;
	Node<T> next;
	
	public Node() {
		data = null;
		next = null;
	}

	public Node(T newItem, Node nextN)
	{
		this.data = newItem;
		this.next = nextN;
	}
	
        @Override
        public int compareTo(Node<T> nod)
        {
            return data.compareTo(nod.data);
        }
}