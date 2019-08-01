package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String d){ 
		data=d;
	}

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	public boolean containsNode(String s){ 
		if(this.data.equals(s)){
			return true;
		}
		else {
			if(this.data.compareTo(s)>0){
				if(this.left==null) {return false;}
				return this.left.containsNode(s);
			}
			else
				if(this.right==null) {return false;}
			return this.right.containsNode(s);
		}
	}
	public boolean insertNode(String s){
		if(this.data.equals(s)){
			return false;
		}
		else {
			if(this.data.compareTo(s)>0){
				if(this.left==null) {this.left=new BST_Node(s); return true;}
				return this.left.insertNode(s);
			}
			else
				if(this.right==null) {this.right=new BST_Node(s); return true;}
			return this.right.insertNode(s);
		}
	}
	public boolean removeNode(String s, BST_Node parent){ 
		if(this.data.equals(s)) {
			if(this.right==null && this.left==null){
				if (parent.right== this) {
					parent.right=null;
				}
				else
					parent.left=null;
			}
			else if (this.right==null) {
				if (parent.right== this) {
					parent.right=this.left;
					this.left=null;
				}
				else  if (parent.left==this){
					parent.left=this.left;
					this.left=null;
				}
			}
			else if(this.left==null) {
				if (parent.right== this) {
					parent.right=this.right;
					this.right=null;
				}
				else {
					parent.left=this.right;
					this.right=null;
				}
			}
			else {

				this.data= this.right.findMin().data;
				this.right.removeNode(this.data, this);
			}
			return true;
		}
		else {
			if(this.data.compareTo(s)>0){
				if(this.left==null) {return false;}
				return this.left.removeNode(s,this);
			}
			else
				if(this.right==null) {return false;}
			return this.right.removeNode(s,this);
		} 
	}
	public BST_Node findMin(){ 
		if(this.left==null)
			return this;
		return this.left.findMin();
	}
	public BST_Node findMax(){
		if(this.right==null)
			return this;
		return this.right.findMax(); 
	}
	public int getHeight(){ 
		if (this.right== null && this.left== null) {
			return 0;
		}
		else if(this.right==null) {
			return 1+this.left.getHeight();
		}
		else if(this.left==null)
			return 1+this.right.getHeight();
		else
			return 1+ Math.max(this.right.getHeight(),this.left.getHeight());
	}



	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}
}
