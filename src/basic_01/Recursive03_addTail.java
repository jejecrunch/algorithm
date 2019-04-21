package basic_01;

public class Recursive03_addTail {

	static class Node{
		int value;
		Node next;
		
		public Node(int value, Node next) {
			this.value=value;
			this.next=next;
		}
		
		public void printAll() {
			Node point=this;

			if(point!=null) {
				System.out.printf("%d ", point.value);
				if(point.next!=null)
					point.next.printAll();
			} 
			
			/*for(Node p=this;p!=null;p=p.next)
				System.out.printf("%d ", p.value);*/
		}
		
		public void addTail(int value) {
			//Node p=this;
			
			if(next!=null) next.addTail(value);
			else next = new Node(value, null);
			
			/*if(p.next==null) {
				p.next=new Node(value, null);
				if(p.next.next==null)
					p.next.addTail(value);
			}*/
			
			// for(;p.next!=null;p=p.next) {}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(0, null);
		for(int i=1;i<=10;++i)
			root.addTail(i);
		
		root.printAll();
	}

}
