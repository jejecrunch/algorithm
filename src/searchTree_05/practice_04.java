package searchTree_05;

public class practice_04 {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void print() {
			if (left != null) left.print();
			System.out.printf("%d ", value);
			if (right != null) right.print();
		}

		public int getLeftMostValue() {
			if (this.left != null) return this.left.getLeftMostValue();
			return this.value;
		}

		public void remove(int value, Node parent) {
			if (value < this.value) {
				if (left != null) left.remove(value, this);
			} else if (value > this.value) {
				if (right != null) right.remove(value, this);
			} else {
				if (left != null && right != null) {
					int temp = right.getLeftMostValue();
					this.value = temp;
					right.remove(temp, this);
				} else {
					Node child = (left != null) ? left : right;
					if (parent.left == this) parent.left = child;
					else parent.right = child;
				}
			}
		}
	}

	static class BinaryTree {
		Node root;

		public void add(int value) {
			if(root==null) {
				root = new Node(value);
				return;
			}
			Node p=root;
			while(true) {
				if(p.value>value) {
					if(p.left==null) {
						p.left=new Node(value);
						return;
					} else
						p=p.left;
				} else if (p.value < value ) {
					if(p.right==null) {
						p.right=new Node(value);
						return;
					} else
						p=p.right;
				} else
					return;
					
			}
		}	

		public void print() {
			if (root != null) root.print();
			System.out.println();
		}

		public boolean contains(int value) {
			if(root==null) return false;
			Node p = root;
			while(p!=null) {
				if(p.value < value) p=p.left;
				else if(p.value>value) p=p.right;
				else return true;
			}
			return false;
		}

		public void remove(int value) {
			if(root==null) return;
			else if(root.value==value) {
				if(root.left!=null && root.right!=null) {
					int temp=root.right.getLeftMostValue();
					root.value=temp;
					root.right.remove(temp, root);
				} else {
					Node child = (root.left != null) ? root.left : root.right;
					root=child;
				}
			} 
			else
				root.remove(value, null);
		}

	}

	public static void main(String[] args) {
		int[] a = { 5, 18, 1, 12, 7, 2, 14, 6, 9, 15 };
		BinaryTree binaryTree = new BinaryTree();
		for (int i = 0; i < a.length; ++i)
			binaryTree.add(a[i]);
		binaryTree.print();
		binaryTree.remove(14);
		binaryTree.print();
		binaryTree.remove(15);
		binaryTree.print();
		binaryTree.remove(5);
		binaryTree.print();
		binaryTree.remove(10);
		binaryTree.print();
		System.out.println();
	}
}
