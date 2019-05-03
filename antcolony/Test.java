package antcolony;

import graph.*;



public class Test {

	public static void main(String[] args) {
		test_graphs();
	}

	
	public static void test_graphs() {
		graph<String,Double> Gr= new graph<String,Double>();
		boolean b;
		b=Gr.addVertex("João");
		b=Gr.addVertex("Matilde");
		b=Gr.addVertex("Carolina");
		b=Gr.addE("João","Matilde",6.5);
		b=Gr.addE("Carolina","Matilde",3.2);
		if(b==true)
			System.out.println(Gr.toString());
		else System.out.println("Fail");
		//if (b==true)
			//System.out.println("it worked:");
		//else System.out.println("fail");
	}
}
