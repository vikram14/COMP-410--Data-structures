package SPLT_A4;

public class SPLT implements SPLT_Interface{
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	} 

	public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		boolean success = false;
		if(root==null)
		{
			root=new BST_Node(s);
			size++;
			return;
		}
		root=root.insertNode(s);
		success= root.justMade;
		//System.out.println("bool"+success);
		if(success)
			size++;

	}

	@Override
	public void remove(String s) {
		if(root==null) {
			return;
		}
		/*else if(root.data.equals(s)) {
			if(root.right==null && root.left==null) {
				root=null;
				size--;
				return;
			}
			else {
				if(root.left==null) {
					root=root.right;
					root.par=null;
					size--;
					return;
				}
				else if(root.right==null) {
					root=root.left;
					root.par=null;
					size--;
					return;
				}
			}
		}*/
		boolean cont =contains(s);
		if(root.data.equals(s) && cont) {
			BST_Node L, R;
			L=root.left;
			R=root.right;
			root=null;
			if(L!=null) {
				L=L.findMax();
				L.right=R;
				if(R!=null)
					R.par=L;
				root=L;
			}
			else if(R!=null) {
				root=R;
				R.par=null;
			}
			else {
				root=null;
			}
			size--;
		}

	}

	@Override
	public String findMin() {
		if(!empty()) {
			root=root.findMin();
			return root.data;
		}
		return null;
	}

	@Override
	public String findMax() {
		if(!empty()) {
			root=root.findMax();
			return root.data;
		}
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
		root=root.containsNode(s);
		if (root.data.equals(s)) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {	
		if(!empty())
			return root.getHeight();
		return -1;
	} 

}
