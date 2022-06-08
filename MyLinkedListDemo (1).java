
public class MyLinkedListDemo<E> {

	private ListNode front;

	public class ListNode{

		private E data;
		private ListNode next;

		public ListNode(E d, ListNode n){
			data = d;
			next = n;
		}
	}

	public void addFront(E item){

		front = new ListNode(item,front);

	}

	public void printAll(){

		ListNode curr = front;
		
		while(curr != null) { 
			System.out.println(curr.data);
			curr = curr.next;
		}

	}

	public void removeFront(){

		if(front==null)
			return;
		
		ListNode toRem = front;
		front = front.next;
		toRem.next = null;

	}



	public static void main(String[] args){
		MyLinkedListDemo<Integer> list = new MyLinkedListDemo<Integer>();

		list.addFront(15);
		list.addFront(8);
		list.addFront(4);		

		list.removeFront();
	}
}
