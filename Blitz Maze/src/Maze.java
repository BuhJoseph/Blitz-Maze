/*Mazes will be a rectangular shape of size n x m
 *Each cell will be represented by an integer and an
 *edge will be represented as a pair of cells. An edge 
 *will separate these two cells
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Maze{

    static int width;
    static int height;
    static int size;

    static int player;
    static int end;
    
    static Edge[] edges;

    //Default constructor
    Maze(){
        width = 10;
        height = 10;
        size = width * height;
        edges = new Edge[size * 2];
        generateEdges();
        player = 0;
        end = size - 1;
    }

    //Size constructor
    Maze(int width, int height){
        this.width = width;
        this.height = height;
        size = width * height;
        edges = new Edge[size * 2];
        generateEdges();
        player = 0;
        end = size - 1;
        
    }


    public void generateMaze(){
        DsjSet cells = new DsjSet(size);
    	
        Edge[] copy = new Edge[size * 2];
        for(int i = 0; i < size * 2; i++) {
        	copy[i] = edges[i];
        }
        List<Edge> random = Arrays.asList(copy);
        Collections.shuffle(random);
        
        //Kruskal's algorithm
        for(int i = 0; i < size * 2; i++) {
        	Edge curr = random.get(i);
        	int v1 = curr.getV1();
        	int v2 = curr.getV2();
        	if(v2 != -1) {
        		int set1 = cells.find(v1);
        		int set2 = cells.find(v2);
        		if(set1 != set2) {
        			curr.setUse(false);
        			cells.union(v1,v2);
        		}
        	}
        }
    }

    public void generateEdges() {
    	for(int i = 0; i < size; i++) {
    		//Creates edges that connect horizontally adjacent cells
    		if(((i+1) % width) != 0) {
    			//System.out.println(i);
    			edges[i] = new Edge(i, i + 1);
    		}
    		else {
    			//System.out.println(i);
    			edges[i] = new Edge(i, -1);
    			//edges[i].setUse(false);
    		}
    		//Creates edges that connect vertically adjacent cells
    		if(i <= size - 1 - width) {
    			edges[i + size] = new Edge(i, i + width);
    		}
    		else {
    			edges[i + size] = new Edge(i, -1);
    			//edges[i + size].setUse(false);
    		}
    	}
    }
    
    public void displayMaze(){
        //Prints top border
    	for(int i = 0; i < width; i++) {
    		System.out.print(".---");
    	}
    	System.out.println(".");
    	
        for(int y = 0; y < height; y++){
        	System.out.print("|");
            for(int x = 0; x < width; x++){
            	if(edges[y*width + x].getUse()) {
            		if(end == y*width+x)
            			System.out.print(" X |");
            		else if(player == y*width+x)
            			System.out.print(" O |");
            		else
            			System.out.print("   |");
            	}
            	else {
            		if(end == y*width+x)
            			System.out.print(" X  ");
            		else if(player == y*width+x)
            			System.out.print(" O  ");
            		else
            			System.out.print("    ");

            	}
            }
            System.out.println();
            
            System.out.print(".");
            for(int x = 0; x < width; x++){
            	if(edges[y*width + x + size].getUse()) {
            		System.out.print("---.");
            	}
            	else{	
            		System.out.print("   .");
            	}
            }
            System.out.println();
        }
    }
    
    public void move(String dir) {
    	if(dir == "a") {
    		if(player % width != 0) {
    			if(!edges[player - 1].getUse()) {
    				player = player - 1;
    				displayMaze();
    			}
    			else {
    				System.out.println("Can't move left");
    				displayMaze();
    			}
    		}
    		else {
				System.out.println("Can't move left");
				displayMaze();
    		}
    	}
    	else if(dir == "d") {
    		if((player + 1) % width != 0) {
    			if(!edges[player].getUse()) {
    				player = player + 1;
    				displayMaze();
    			}
    			else {
    				System.out.println("Can't move right");
    				displayMaze();
    			}
    		}
    		else {
				System.out.println("Can't move right");
				displayMaze();
    		}
    	}
    	else if(dir == "w") {
    		if(player >= width) {
    			if(!edges[player + size - width].getUse()) {
    				player = player - width;
    				displayMaze();
    			}
    			else {
    				System.out.println("Can't move up");
    				displayMaze();
    			}
    		}
    		else {
				System.out.println("Can't move up");
				displayMaze();
    		}
    	}
    	else if(dir == "s"){
    		if(player < size - width) {
    			if(!edges[player + size].getUse()) {
    				player = player + width;
    				displayMaze();
    			}
    			else {
    				System.out.println("Can't move down");
    				displayMaze();
    			}
    		}
    		else {
				System.out.println("Can't move down");
				displayMaze();
    		}
    	}
    }
    



    public static void main(String[] args){
        Maze maze = new Maze(10,10);
        maze.generateMaze();
        maze.displayMaze();    
        
        while(true) {
        	Scanner s = new Scanner(System.in);
        	String move = s.next();
        	
        	if(move.equals("a")) {
        		maze.move("a");
        	}
        	else if(move.equals("d")) {
        		maze.move("d");
        	}
        	else if(move.equals("w")) {
        		maze.move("w");
        	}
        	else if(move.equals("s")) {
        		maze.move("s");
        	}
        	else {
        		System.out.println("Invalid input");
        		maze.displayMaze();
        	}
      	
        	if(player == end) {
        		System.out.println("YOU WIN!");
        		break;
        	}
        }
    }
}