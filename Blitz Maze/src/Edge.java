//Edges are pairs of vertices
//A "vertex" is the cell in the maze which is represented
//by an integer

public class Edge{

    int v1;
    int v2;
    boolean used;
    
    Edge(int v1, int v2){
    	this.v1 = v1;
    	this.v2 = v2;
    	used = true;
    }
    
    @Override
    public boolean equals(Object obj){
        //Check if argument references the same object
        if(this == obj)
            return true;

        //Check for same type
        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Edge edge = (Edge) obj;

        //Equal if x and y are the same
        return (edge.v1 == this.v1 && edge.v2 == this.v2);
    }

    public int getV1(){
        return this.v1;
    }

    public int getV2(){
        return this.v2;
    }
    
    public boolean getUse() {
    	return used;
    }
    public void setUse(boolean use) {
    	this.used = use;
    }
}