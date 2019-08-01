package DiGraph_A5;

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex arg0, Vertex arg1) {
		if(arg0.distance<arg1.distance) 
			return -1;
		if(arg0.distance>arg1.distance)
			return 1;
		return 0;
	}

}
