package graph;

public class Main {

	public static void main(String[] args) {
		graph<String,Integer> Gr= new graph<String,Integer>();
		boolean b;
		b=Gr.addVertex("Jo�o");
		b=Gr.addVertex("Matilde");
		b=Gr.addVertex("Carolina");
		b=Gr.addE("Jo�o","Matilde",10);
		b=Gr.addE("Carolina","Matilde",5);
		if(b==true)
			System.out.println(Gr.toString());
		else System.out.println("Fail");
		//if (b==true)
			//System.out.println("it worked:");
		//else System.out.println("fail");	
	}

}
