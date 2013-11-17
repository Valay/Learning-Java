package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Graph<T> {
	
	boolean directed = false;
	int size = 0;
	int edge_count = 0;
	int vertex_count = 0;

	Map<T,List<T>> graph = new HashMap<T,List<T>>(); 
	
	public Graph(){
		this(false);
	}
	
	public Graph(boolean d){
		directed = d;
	}
	
	public Graph(boolean d, int s){
		directed = d;
		size = s;
	}
	
	// Adds an edge to the graph between vertices a and b
	public boolean addEdge(T a, T b){
		if(!graph.containsKey(a)){
			addNode(a);
		}
		if(!graph.containsKey(b)){
			addNode(b);
		}
		
		graph.get(a).add(b);
		graph.get(b).add(a);
		edge_count++;
		return true;
	}
	
	// insert a new vertex in the graph
	public boolean addNode(T a){
		if(vertex_count >= size){
			return false;
		}
		if(!graph.containsKey(a)){
			graph.put(a, new ArrayList<T>());
			vertex_count++;
			return true;
		}
		return false;
	}
	
	// iterate over adjacency list of a vertex
	
}
