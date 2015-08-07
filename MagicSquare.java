
package magicsquare;

/**
 *
 * @author Ryan Darnell
 */
public class MagicSquare {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {


        Number[] array = new Number[9];
        int[] square = new int[9];
        
        
        for (int i = 1; i <= 9; i++) {
            array[i-1] = new Number(i);
        }
        try {
            recursiveMagic(0, array, square);
        } catch (NullPointerException e) {
            System.out.println("Done");
        }
        
    }
    
    public static void recursiveMagic(int position, Number[] numbers, int[] square){
        for (int i = 1; i < 10; i++) {
            
            //put number on this position and make it unavailable
            if (!numbers[i-1].getUsed()) { 
                square[position] = numbers[i-1].getValue();
                numbers[i-1].setUsed(true);
                
                if (checkSolution(position, square)){ //check current row
                    if (checkCompletion(square)) { //Check columns and diags
                        System.out.println("Magic Square Solution...");
                        printMagic(square);
                        throw new NullPointerException("Break the Recursion!");
                        
                    } else {
                        recursiveMagic(position + 1, numbers, square);
                    }
                    
                }
                square[position] = 0;
                numbers[i-1].setUsed(false);
            }
        }
    }
    
    public static boolean checkSolution(int position, int[] square) {
        int sum = 0;
        if (position == 3){
            for (int i = 0; i < 3; i++) {
                sum += square[i];
            }
        } else if (position == 6) {
            for (int i = 3; i < 6; i++) {
                sum += square[i];
            }
        } else if (position == 9) {
            for (int i = 6; i < 9; i++) {
                sum += square[i];
            }
        } else {
            return true;
        }
        if (sum == 15) {
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean checkCompletion(int[] square) {
        int sum = 0;
        //check columns
        sum = square[0] + square[3] + square[6];
            if (sum != 15)
                return false;
        sum = square[1] + square[4] + square[7];
            if (sum != 15)
                return false;
        sum = square[2] + square[5] + square[8];
            if (sum != 15)
                return false;
        
        //check diagonals
        sum = square[0] + square[4] + square[8];
            if (sum != 15)
                return false;
        sum = square[2] + square[4] + square[6];
            if (sum != 15)
                return false;
        
        return true;
    }
    
    public static void printMagic(int[] square){
        System.out.println();
        System.out.println(square[0] + "   " + square[1] + "   " + square[2]);
        System.out.println();
        System.out.println(square[3] + "   " + square[4] + "   " + square[5]);
        System.out.println();
        System.out.println(square[6] + "   " + square[7] + "   " + square[8]);
    }
    
}
