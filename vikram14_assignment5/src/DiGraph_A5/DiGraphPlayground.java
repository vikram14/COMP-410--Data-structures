package DiGraph_A5;

public class DiGraphPlayground {
	
	public static void main (String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like 
		//    -- print
		//    -- sort
		//    -- random fill
		//    -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		test();
	}

	public static void exTest(){
		DiGraph d = new DiGraph();
		d.addNode(1, "f");
		d.addNode(3, "s");
		d.addNode(7, "t");
		d.addNode(0, "fo");
		d.addNode(4, "fi");
		d.addNode(6, "si");
		d.addEdge(0, "f", "s", 4, null);
		d.addEdge(1, "f", "si", 3, null);
		d.addEdge(2, "s", "t", 2, null);
		d.addEdge(3, "fo", "fi", 1, null);
		d.addEdge(4, "fi", "si", 8, null);
		System.out.println("numEdges: "+d.numEdges());
		System.out.println("numNodes: "+d.numNodes());
		d.print();
		/*String []res=d.TopoSort();  // can't do Topo-sort before dijkstra's.
		for(String s: res) {
			System.out.print(s+",");
		}*/
		ShortestPathInfo sp[]=d.shortestPath("f");
		for(ShortestPathInfo s : sp) {
			System.out.println(s);
		}
	}
	public static void test() {
		DiGraph d = new DiGraph();
		d.addNode(1,"a");
		d.addNode(2,"b");
		d.addNode(3,"c");
		d.addNode(4,"d");
		d.addNode(5,"e");
		d.addEdge(0, "a", "b",1,null);
		d.addEdge(1, "b", "c",2,null);
		d.addEdge(2, "c", "a",3,null);
		d.addEdge(3, "c", "d",2,null);
		d.addEdge(4, "d", "b",1,null);
	//	d.addEdge(0, "a", "b",3,null);
		//d.addEdge(1, "b", "c",4,null);
	//	d.addEdge(2, "a", "c",10,null);
		/*d.addEdge(0, "a", "b",1, null);
		d.addEdge(1, "b", "c",1, null);
		d.addEdge(2, "a", "c",3, null);
		d.addEdge(3, "c", "d",2, null);
		d.addEdge(4, "c", "e",5, null);
		d.addEdge(5, "b", "d",2, null);
		d.addEdge(6, "d", "e",3, null);
		d.addEdge(7, "b", "e",7, null);
		d.addEdge(8, "a", "e",9, null);
		d.addEdge(9, "a", "d",5, null);*/
		ShortestPathInfo sp[]=d.shortestPath("k");
		for(ShortestPathInfo s : sp) {
			System.out.println(s);
		}
	}
}
