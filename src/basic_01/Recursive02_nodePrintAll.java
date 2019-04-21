package basic_01;

public class Recursive02_nodePrintAll {

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
	}
	
	public static void main(String[] args) {
		Node root = null;
		for(int i=1;i<=10;++i)
			root=new Node(i, root);
		
		root.printAll();
	}

}
