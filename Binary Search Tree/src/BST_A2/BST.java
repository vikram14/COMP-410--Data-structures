package BST_A2;

public class BST implements BST_Interface {

	public BST_Node root;
	int size;

	public BST(){ size=0; root=null; }

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		boolean success = false;
		if(root==null)
		{
			root=new BST_Node(s);
			size++;
			return true;
		}
		success= root.insertNode(s);
		if(success)
			size++;
		return success;
	}

	@Override
	public boolean remove(String s) {
		boolean success = false;
		if(root==null) {
			return false;
		}
		else if(root.data.equals(s)) {
			if(root.right==null && root.left==null) {
				root=null;
				size--;
				return true;
			}
			else {
				if(root.left==null) {
					root=root.right;
					size--;
					return true;
				}
				else if(root.right==null) {
					root=root.left;
					size--;
					return true;
				}
			}
		}
		success= root.removeNode(s,root);
		if(success)
			size--;
		return success;
	}

	@Override
	public String findMin() {
		if(!empty())
			return root.findMin().data;
		return null;
	}

	@Override
	public String findMax() {
		if(!empty())
			return root.findMax().data;
		return null;
	}

	@Override
	public boolean empty() {
		return root==null;
	}

	@Override
	public boolean contains(String s) {
		if(root==null) {
			return false;
		}
		return root.containsNode(s);
	}

	@Override
	public int size() {
		return size++;
	}

	@Override
	public int height() {
		if(!empty())
			return root.getHeight();
		return -1;
	}
}
