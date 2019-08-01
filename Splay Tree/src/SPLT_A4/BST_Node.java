package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par;
	boolean justMade;

	BST_Node(String d){ 
		data=d;
		par=null;
		justMade=true;
	}
	BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
		this.data=data;
		this.left=left;
		this.right=right;
		this.par=par;
		justMade=true;
	}

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	public BST_Node containsNode(String s){ 
		if(this.data.equals(s)){
			return this.splay(this);
		}
		else {
			if(this.data.compareTo(s)>0){
				if(this.left==null) {return this.splay(this);}
				return this.left.containsNode(s);
			}
			else {
				if(this.right==null) {return this.splay(this);}
				return this.right.containsNode(s); 
			}
		}
	}

	public BST_Node insertNode(String s){
		if(this.data.equals(s)){
			this.justMade=false;
			return this.splay(this);
		}
		else {
			if(this.data.compareTo(s)>0){
				if(this.left==null) {
					this.left=new BST_Node(s); 
					this.left.par=this ;
					return this.left.splay(this.left);
				}
				return this.left.insertNode(s);
			}
			else
				if(this.right==null) {
					this.right=new BST_Node(s); 
					this.right.par=this ;

					return this.right.splay(this.right);
				}
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
		if(this.left==null) {
			return this.splay(this);
		}
		return this.left.findMin();
	}
	public BST_Node findMax(){
		if(this.right==null) {
			return this.splay(this);
		}
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
	private BST_Node splay(BST_Node toSplay) {
		BST_Node G,P,X;
		P=this.par;
		if(P==null)
			return this;
		G=P.par;
		if(P!=null && G==null) {
			if(P.right==toSplay) {
				X=rotateLeft(P);

			}
			else
				X=rotateRight(P);
			return this;
		}
		else if(P!=null && G!=null) {
			if(G.right==P && P.left==toSplay) {
				X=rotateRight(P);
				X=rotateLeft(X.par);
				return splay(X);
			}
			else if(G.left==P && P.right==toSplay) {
				X=rotateLeft(P);
				X=rotateRight(X.par);
				return splay(X);
			}
			else if(G.left==P && P.left==toSplay) {
				X=rotateRight(G);
				X=rotateRight(X);
				return splay(X);
			}
			else if(G.right==P && P.right==toSplay) {
				X=rotateLeft(G);
				X=rotateLeft(X);
				return splay(X);
			}
		}
		return null;
	}

	private BST_Node rotateRight(BST_Node p) {
		BST_Node X, B;
		X=p.left;
		B=X.right;
		X.par=p.par;
		p.par=X;
		X.right=p;
		p.left=B;
		if(p.left!=null)
			p.left.par=p;
		if(X.par!=null && X.par.right==p)
			X.par.right=X;
		else if(X.par!=null && X.par.left==p)
			X.par.left=X;
		return X;
	}

	private BST_Node rotateLeft(BST_Node p) {
		BST_Node X=this, B;
		X=p.right;
		B=X.left;
		X.par=p.par;
		p.par=X;
		X.left=p;
		p.right=B;
		if(p.right!=null)
			p.right.par=p;
		if(X.par!=null && X.par.right==p)
			X.par.right=X;
		else if(X.par!=null && X.par.left==p)
			X.par.left=X;
		return X;
	}

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}
}
