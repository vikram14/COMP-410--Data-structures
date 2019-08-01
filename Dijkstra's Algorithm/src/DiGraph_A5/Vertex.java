package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;

public class Vertex {
	int in_count;
	int out_count;
	long id;
	long distance;
	String label;
	HashSet<String> in;
	HashSet<String> out;
	HashMap<String, Long> outEdgeId;
	public boolean known;
	
	public Vertex(long idNum, String lab) {
		outEdgeId = new HashMap<>();
		out = new HashSet<>();
		in = new HashSet<>();
		in_count=0;
		out_count=0;
		label=lab;
		id=idNum;		
		known= false;
		distance=Long.MAX_VALUE;
	}

}
