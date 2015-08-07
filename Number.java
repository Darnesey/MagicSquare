
package magicsquare;

/**
 *
 * @author Ryan Darnell
 */
public class Number {
    
    int value;
    boolean used;
    
    public Number(int number){
        value = number;
        used = false;
    }

    public int getValue() {
        return value;
    }
    
    public void setUsed(boolean visit){
        used = visit;
    }
    
    public boolean getUsed(){
        return used;
    }
}
