////Map Class
////X,Y Coordinates read from left to right, top to bottom

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
public class Map {
    int x, y, currX, currY;
    private Tile[][] map;	// 10 by 10 maps
    
    public Map (String fileName) {

	FileReader reader = null;
	BufferedReader file = null;
	x = 0;
	y = 0;
	currX = 0;
	currY = 0;
	String line = null;
	String[] data = null;
	
	try {
	    reader = new FileReader(fileName);
	} 
	catch (ArrayIndexOutOfBoundsException error) {
	    System.out.println("File not specified.\nEnding program.\n");
	    System.exit(0);
	}
	catch (IOException error) { 
	    System.out.println("ERROR: File not found.\nEnding program.\n");
	    System.exit(0);
	}
	
	try {		
	    file = new BufferedReader(reader);
	    
	    line = file.readLine();
	    data = line.split(" ");
	    
	    x = Integer.parseInt(data[0]);
	    y = Integer.parseInt(data[0]);
	    
	    map = new Tile[x][y];
	    for (int height = 0; height < y; height++) {
		line = file.readLine();	//Get the next line of the file
		data = line.split(" ");	//Break the line into a map segment
		for (int width = 0; width < x; width++) {
		    map[width][height] = new Tile (Integer.parseInt(data[width]));
		}
	    }
	    
	    line = file.readLine();
	    data = line.split(" ");
	    
	    currX = Integer.parseInt(data[0]);
	    currY = Integer.parseInt(data[1]);
	    
	    file.close();
	} 
	catch (Exception error) { //Closes program and returns error if the file cannot be located
	    System.out.println("You hecked up\n");
	    System.exit(0);
	}
    }
    
    public boolean move (String direction) {
	if (direction.equals("w"))
	    return attemptMove(0,1);
	if (direction.equals("s"))
	    return attemptMove(0,-1);
	if (direction.equals("d"))
	    return attemptMove(1,0);
	if (direction.equals("a"))
	    return attemptMove(-1,0);
	else {
	    return false;
	}
    }
    
    private boolean attemptMove (int tryX, int tryY) {
	return false;
    }
    
    public void print () {
	for (int height = 0; height < y; height++) {
	    for (int width = 0; width < x; width++) {
		if (currX != width || currY != height)
		    map[width][height].print();
		else
		    System.out.print("@ ");
	    }
	    System.out.print("\n");
	}
    }
    
}
