

public class DsjSet{
    Node[] set;

    DsjSet(int size){
    	set = new Node[size];
        for(int i = 0; i < size; i++){
            set[i] = new Node(i);
        }
    }

    public void union(int x, int y){
        Node xRoot = set[x].find(set[x]);
        Node yRoot = set[y].find(set[y]);

        if(xRoot == yRoot)
            return;
        
        if(xRoot.getRank() < yRoot.getRank()){
            xRoot.setParent(yRoot);
            yRoot.addRank();
        }
        else{
            yRoot.setParent(xRoot);
            xRoot.addRank();
        }
    }
    
    public int find(int x) {
    	Node xNode = set[x];
    	return xNode.find(xNode).getCell();
    }
}