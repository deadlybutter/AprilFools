/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aprilfools;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joe
 */
public class AprilFools {
                                        //A      P     R     I     L
    private final String[] APRIL_TEXT = {" ---   ---   ---   ---   -   \n", 
                                         "|   |  |  |  |  }   |    |   \n", 
                                         "|---|  |--   |--    |    |   \n", 
                                         "|   |  |     |  |  ---   --- \n"
    };
    
    private final String[] FOOLS_TEXT = {"-----   --    --   |     --- \n",
                                         "|      |  |  |  |  |    |    \n",
                                         "+---   |  |  |  |  |     --- \n",
                                         "|      |  |  |  |  |        |\n",
                                         "|       --    --   ---   --- \n"
    };
    
    private final int matrixLoops = 2000;
    private final int aprilLoops = 10;
    private final Random random;
    private final String[] binary_char;
    private boolean printApril = true;
    
    
    public AprilFools(){
        binary_char = new String[]{"0","1"," "};
        random = new Random();
        beginOutput();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new AprilFools();
    }
    
    private void beginOutput(){
        printMatrix();
        printAprilFools();
    }
    
    private void printMatrix(){
        final int charectersPerLine = 76;
        StringBuilder outputLine = new StringBuilder(charectersPerLine);
        for(int lineIndex = 0; lineIndex < matrixLoops; lineIndex++){
            for(int charecterIndex = 0; charecterIndex < charectersPerLine; charecterIndex++){
                outputLine.append(binary_char[random.nextInt(binary_char.length)]);
            }
            System.out.println(outputLine);
            outputLine = new StringBuilder(charectersPerLine);
        }
    }
    
    private void printAprilFools(){
        for(int index = 0; index < aprilLoops; index++){
            System.err.println(printApril ? removeSymbols(Arrays.toString(APRIL_TEXT)) : removeSymbols(Arrays.toString(FOOLS_TEXT)));
            printApril = !printApril;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
    
    private String removeSymbols(String toEdit){
        return toEdit.replaceAll(",", "").replace('[', ' ').replace(']', ' ');
    }
}
