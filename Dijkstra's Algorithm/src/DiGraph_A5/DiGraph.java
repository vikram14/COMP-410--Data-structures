package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class DiGraph implements DiGraphInterface {
	HashMap<String, Vertex > vertex_map;
	HashMap<Long, Vertex > vertex_map1;
	HashMap <Long, Edge> edge_map;
	LinkedList <Vertex> toposort;
	HashSet<String> vLabels;
	private long num_e;
	private long num_v;

	public DiGraph ( ) {
		num_e=0;
		num_v=0;
		vertex_map = new HashMap<>();
		vertex_map1 = new HashMap<>();
		edge_map=new HashMap<>();
		vLabels= new HashSet<>();
	}
	@Override
	public boolean addNode(long idNum, String label) {
		if(idNum<0 || label==null)
			return false;
		if(vertex_map.get(label)==null && vertex_map1.get(new Long(idNum))==null) {
			Vertex v= new Vertex(idNum, label);
			vertex_map.put(label, v);
			vertex_map1.put(idNum, v);
			vLabels.add(label);
			num_v++;
			return true;
		}
		return false;
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if(sLabel==null || dLabel==null)
			return false;
		Vertex v= vertex_map.get(sLabel);
		Vertex w= vertex_map.get(dLabel);
		if(idNum<0)
			return false;
		if(v==null || w==null)
			return false;
		if(edge_map.get(idNum)!=null)
			return false;
		if(v.out.contains(dLabel))
			return false;
		v.outEdgeId.put(dLabel, idNum);
		v.out.add(dLabel);
		w.in.add(sLabel);
		v.out_count++;
		w.in_count++;
		num_e++;
		Edge e= new Edge(v,w,weight,eLabel);
		edge_map.put(idNum, e);
		return true;
	}

	@Override
	public boolean delNode(String label) {
		Vertex v=vertex_map.get(label);
		if(v==null)
			return false;
		for(String lab: v.in) {
			this.delEdge(lab, label);
		}
		for(String oe: v.out) {
			this.delEdge(label, oe);
		}
		vertex_map.remove(label);
		vertex_map1.remove(v.id);
		vLabels.remove(label);
		num_v--;
		return true;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		if(sLabel==null || dLabel==null)
			return false;
		Vertex v= vertex_map.get(sLabel);
		Vertex w= vertex_map.get(dLabel);
		if(v==null || w==null)
			return false;
		if(v.outEdgeId.get(dLabel)==null)
			return false;
		long id= v.outEdgeId.get(dLabel);
		edge_map.remove(id);
		v.out.remove(dLabel);
		v.outEdgeId.remove(dLabel);
		v.out_count--;
		w.in_count--;
		num_e--;
		return true;
	}

	@Override
	public long numNodes() {
		return num_v;
	}

	@Override
	public long numEdges() {
		return num_e;
	}

	public void print() {
		for(Vertex v : this.vertex_map.values()) {
			System.out.print(v.label+":");
			System.out.println(v.out);
		}
	}
	public String[] TopoSort() {
		String [] result;
		toposort=new LinkedList<>();
		Vertex temp; HashSet<String> adjacencies;
		for(Vertex v :vertex_map.values()) {
			if(v.in_count==0) {
				toposort.addLast(v);
			}
		}
		if(toposort.isEmpty()) {
			System.out.println("No Topo-Sort for this graph. Cycle present");
			return null;
		}
		result =new String[(int) num_v];
		int count=0;
		while(! (toposort.isEmpty())) {
			temp=toposort.removeFirst();
			adjacencies=temp.out;
			result[count]=temp.label;
			//this.delNode(temp.label);// would cause a larger time-complexity
			vertex_map.remove(temp.label);
			count++;
			for(String s : adjacencies) {
				temp=vertex_map.get(s);
				temp.in_count--;// instead, we can update only in_count as we are already looping through the adjacencies.
				if(temp.in_count==0)
					toposort.addLast(vertex_map.get(s));
			}
		}
		if (count==num_v) {
			return result;
		}
		edge_map.clear();
		System.out.println("No Topo-Sort for this graph. Cycle present");
		return null;

	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {// Dijkstra's Single source shortest path algorithm.
		ShortestPathInfo[] sp= new ShortestPathInfo[(int)num_v];
		//Set<String> vLabels= vertex_map.keySet();
		int count=0;
		if(vertex_map.get(label)==null) {
			for(String s: vLabels) {
				//v=vertex_map.get(s);
				sp[count]=new ShortestPathInfo(s, -1);
				count++;
			}
			return sp;
		}
		PriorityQueue<Vertex> pq= new PriorityQueue<>(new VertexComparator());
		Vertex v= vertex_map.get(label),w;
		v.distance=0;
		pq.add(v);
		while(!(pq.isEmpty())) {
			v=pq.poll();
			if(v.known) {
				continue;
				/*sp [count]=new ShortestPathInfo(v.label,v.distance);
				count++;
				v.known=true;*/
				//vLabels.remove(v.label);
			}
			sp [count]=new ShortestPathInfo(v.label,v.distance);
			count++;
			v.known=true;
			for(String adj: v.out) {
				w=vertex_map.get(adj);
				long id= v.outEdgeId.get(adj);
				if( v.distance + edge_map.get(id).weight< w.distance) {//w.distance==0 ||
					w.distance=v.distance + edge_map.get(id).weight;
					pq.add(w);
				}
			}
		}
		if(count!= num_v) {
			for(String s: vLabels) {
				v=vertex_map.get(s);
				if(v.known!=true) {
				sp[count]=new ShortestPathInfo(s, -1);
				count++;}
			}
		}
		return sp;
	}

}
