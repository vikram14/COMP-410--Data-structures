package MinBinHeap_A3;

public class MinBinHeap implements Heap_Intefrace {

	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MinBinHeap() {
		size=0;
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
	}

	//Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() { 
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		if(size==0) {
			array[1]=entry;
			size++;
		}
		else if(size+1> arraySize) {
			System.out.println("Heap is full");
		}
		else { 
			int i=size+1;
			for(i=size+1; i/2>=1 && entry.getPriority()<array[i/2].getPriority();i=i/2) { //percolate up
				array[i]=array[i/2];
			}
			array[i]=entry;
			size++;
		}
	}

	@Override
	public void delMin() {
		if(size==0) {
			System.out.println("Empty Heap");
		}
		/*else if (size==1) {
			array[1]=null;
			size--;
		}*/
		else {
			/*int i=1;
			while(i<size+1) {
				if(2*i < size+1 && 2*i+1<size+1) {
					if(array[2*i].getPriority()<array[2*i+1].getPriority()) {
						array[i]=array[2*i];
						i=2*i;
					}
					else {
						array[i]=array[2*i+1];
						i=2*i+1;
					}
				}
				else if (2*i<size+1) {
					array[i]=array[2*i];
					i=2*i;
				}
				else {
					break;
				}

			}*/
			array[1]=array[size];
			int hole=percolateDown(1);
			array[hole]=array[size];
			array[size]=null;
			size--;
		}
	}

	@Override
	public EntryPair getMin() {
		if(size==0)
			return null;
		return array[1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		size=entries.length; EntryPair temp; int holePosition;
		for(int i=0;i<entries.length;i++) {
			array[i+1]=entries[i];
		}
		for(int i=size/2; i>=1;i--) {
			temp=array[i];
			holePosition=percolateDown(i);
			array[holePosition]=temp;

		}
	}

	private int percolateDown(int i) {
		int hole=i; EntryPair temp=array [hole];
		while(hole<size+1) {
			if(2*hole < size+1 && 2*hole+1<size+1) {
				if(Math.max(Math.min(array[2*hole].getPriority(),array[2*hole+1].getPriority()),temp.getPriority())==temp.getPriority()) {
					if(array[2*hole].getPriority()<array[2*hole+1].getPriority()) {
						array[hole]=array[2*hole];
						hole=2*hole;
					}
					else {
						array[hole]=array[2*hole+1];
						hole=2*hole+1;
					}
				}
				else
					break;
			}
			else if (2*hole<size+1) {
				if(Math.max(array[2*hole].getPriority(),temp.getPriority())==temp.getPriority()) {
					array[hole]=array[2*hole];
					hole=2*hole;
				}
				else
					break;
			}
			else {
				break;
			}

		}
		return hole;
	}

}
