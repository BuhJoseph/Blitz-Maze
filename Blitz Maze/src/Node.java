
public class Node{
    Node parent;
    int cell;
    int rank;

    Node(int num){
        cell = num;
        parent = this;
        rank = 0;
    }

    @Override
    public boolean equals(Object obj){
        //Check if arguement references the same object
        if(this == obj)
            return true;

        //Check for same type
        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Node node = (Node) obj;

        //Equal if x and y are the same
        return (node.cell == this.cell);
    }


    public Node find(Node x){
        if(x.getParent() != x)
            x.setParent(find(x.getParent()));
        return x.getParent();
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node newParent){
        parent = newParent;
    }

    public int getCell(){
        return cell;
    }

    public int getRank(){
        return rank;
    }

    public void addRank(){
        rank++;
    }
}