package antcolony;

import graph.*;



public class Test {

	public static void main(String[] args) {
		test_graphs();
	}

	
	public static void test_graphs() {
	
			
		//CREATE A GRAPH
		graph<String,Double> Gr= new graph<String,Double>();
		boolean b;
		b=Gr.addVertex("João");
		b=Gr.addVertex("Matilde");
		b=Gr.addVertex("Carolina");
		b=Gr.addE("João","Matilde",6.5);
		b=Gr.addE("Carolina","Matilde",3.2);
		
		//TEST GRAPH
		if(b==true)
			System.out.println(Gr.toString());
		else System.out.println("Fail");
		
		
		//TEST VERTEX AND EDGE GETTERS
		Vertex<String,Double> v=Gr.GetVertex(0);
		Edge<String,Double> e=v.getE().get(0);
		String label= e.getLabel();
		Double weight= e.getWeight();
		System.out.println("Sucess:"+ label + weight);
		
		
		
	}
}
