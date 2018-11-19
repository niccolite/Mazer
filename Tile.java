
public class Tile {
    int type;
    
    //
    public Tile (int i) {
	type = i;
    }
    //Return the type of Tile
    public int type () {
	return type;
    }
    
    public void print () {
	if (type == 0)
	    System.out.print("X ");
	if (type == 1)
	    System.out.print("  ");
	if (type != 0 && type != 1)
	    System.out.print("?");
    }
}
