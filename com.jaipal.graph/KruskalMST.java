package com.jaipal.graph;
import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
	
	private Queue<Edge> mst=new LinkedList<Edge>();
	private double weight; 
	
	public KruskalMST(EdgeWeightGraph g){
		MinPQ<Edge> pq=new MinPQ<Edge>();
		for(Edge e:g.edges())
			pq.insert(e);
		UF uf=new UF(g.V());
		weight=0.0;
		while(!pq.isEmpty() && mst.size() < g.V()-1){
			Edge eg=pq.delMin();
			int v=eg.either();
			int w=eg.other(v);
			if(!uf.connected(v, w)){
				uf.union(v, w);
				mst.add(eg);
				weight+=eg.weight();
			}
			
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight() {
        return weight;
    }

}
