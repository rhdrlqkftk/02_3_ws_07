package afternoon;

public class BinarySearchTree {

	private Node root; 
	
	
	//���� 
	public void inorder()
	{
		inorder(root);
	}
	private void inorder( Node now)
	{
		if( now !=null)
		{
			inorder(now.left);
			System.out.println(now.data + " ");
			inorder(now.right);
			
		}
	}
	public void add(int num)
	{
		if( root ==null)
		{
			root = new Node(num);
		}
		else
		{
			add(root, num);			
		}
	}
	public boolean search(int num)
	{
		return search(root,num);
	}
	public boolean search(Node now, int num)
	{
		if( now.data == num) // Ȯ���� ã�����. 
		{
			return true;
		}
		// Ȯ���� ��ã�°��. 
		if( (now.data< num && now.right ==null) || (now.data > num && now.left==null))
		{
			return false; 
		}
		// �� �������ϴ°��
		else
		{
			if( now.data< num)
			{
				return search( now.right, num);
			}
			else 
			{
				return search( now.left, num);
			}
		}
		
	}
	public void add(Node node, int num)
	{
		if( node.data < num) // �������̳�. 
		{
			if( node.right == null)
			{
				node.right = new Node(num);
			}
			else
			{
				add( node.right , num);
			}
		}
		else // �����̳� 
		{
			if( node.left == null)
			{
				node.left = new Node(num);
			}
			else
			{
				add( node.left , num);
			}
		}
	}
	class Node
	{	
		int data; 
		Node left, right; 
		Node(int d)
		{
			data = d; 
		}
	}
	public static void main(String[] args) 
	{	
		BinarySearchTree tree= new BinarySearchTree(); 
		tree.add(10);
		tree.add(20);
		tree.add(560);
		tree.add(7);
		tree.add(2);
		tree.add(100);
		
		tree.inorder();
		
	}

}
