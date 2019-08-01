package DiGraph_A5;

public class Edge {

	public String label;
	public long weight;
	public Vertex v2;
	public Vertex v1;

	public Edge(Vertex v, Vertex w, long we, String eLabel) {
		v1=v;
		v2=w;
		if(we==0)
			weight=1;
		else
			weight=we;
		label=eLabel;
	}

}
