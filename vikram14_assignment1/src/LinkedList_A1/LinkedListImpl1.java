package LinkedList_A1;
/*package LinkedList_A1;

public class LinkedListImpl1 implements LIST_Interface {
	Node sentinel, tailPointer; int size,counter;

	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel=new Node(0);//Note that the root's data is not a true part of your data set!
		tailPointer=new Node(0);
		tailPointer.prev=sentinel;
		sentinel.next=tailPointer;//e
	}

	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		Node newNode= new Node(elt);
		Node currentNode;
		if(index>size || index<0){ 
			return false;
		}

		else if(index==0 && sentinel.next==null){
			newNode.next=sentinel.next;
			sentinel.next=newNode;
			newNode.prev=sentinel;
			if(newNode.next==null) {
				//newNode.next=sentinel;
				tailPointer.prev=newNode;//or sentinel.prev=
				newNode.next=tailPointer;
			}

			size++;
			return true;
		}
		else {
			currentNode=sentinel;
			if(index<=size/2) {
				counter=0;
				while((counter <= index)) {
					if(counter==index) {
						newNode.next= currentNode.next;

						currentNode.next=newNode;
						newNode.prev=currentNode;
						if(newNode.next==null) {
							//newNode.next=sentinel;
							tailPointer.prev=newNode;//or sentinel.prev=
							newNode.next=tailPointer;//edited
						}
						else
						newNode.next.prev=newNode;//execute when newNode.next and newNode.next.prev!= null
						size++;
						return true;
					}
					counter++;
					//updateCounter(index);
					currentNode=currentNode.getNext();
				}
			}
			else { 
				currentNode=tailPointer;//sentinel
				//System.out.println(size);
				counter=size;
				if(index==size) {
					newNode.prev= currentNode.prev;
					newNode.prev.next=newNode;
					currentNode.prev=newNode;
					newNode.next=currentNode;
				}

				while((counter >= index)) {
					if(counter==index) {
						newNode.prev= currentNode.prev;
						newNode.prev.next=newNode;
						currentNode.prev=newNode;
						newNode.next=currentNode;
						if(newNode.next==null) {
							//newNode.next=sentinel;
							tailPointer.prev=newNode;//or sentinel.prev=
							newNode.next=tailPointer;
						}
						size++;
						return true;
					}
					counter--;
					//updateCounter(index);
					currentNode=currentNode.getPrev();
				}
			}

		}
		return false;
	}

	@Override
	public boolean remove(int index) {
		Node currentNode; int count;
		if(index<0 || index>size-1) {
			return false;
		}
		else if(sentinel.getNext()==tailPointer){
			return false;
		}
		else {
			if(index<=size) {
				count=0;
				currentNode=sentinel;
				while(count<=index) {
					if(count==index) {
						currentNode.next=currentNode.getNext().getNext();
						currentNode.next.prev=currentNode;
						size--;
						return true;
					}
					currentNode=currentNode.getNext();
					count++;
				}
			}
			else {
				count=size-1;
				currentNode=tailPointer;
				while(count>=index) {
					if(count==index) {
						currentNode.prev=currentNode.prev.prev;
						currentNode.prev.next=currentNode;
						size--;
						return true;
					}
					currentNode=currentNode.getPrev();
					count--;
				}
			}
			return false;
		}	
	}

	@Override
	public double get(int index) {
		Node currentNode; int i;
		if(index<=size/2) {
			currentNode=sentinel.getNext();
			i=0;
			while(currentNode!=null && i<=index) {
				if(i==index)
					return currentNode.getData();
				currentNode=currentNode.getNext();
				i++;
			}
			return Double.NaN;
		}
		else {
			i=size-1;
			currentNode=tailPointer.getPrev();
			while(currentNode!=null && i>=index) {
				if(i==index)
					return currentNode.getData();
				currentNode=currentNode.getPrev();
				i--;
			}
			return Double.NaN;
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {	
		tailPointer.prev=sentinel;
		sentinel.next=tailPointer;
		size=0;
	}

}
*/