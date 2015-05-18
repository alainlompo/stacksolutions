package stack.commons.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Charbased {

    public static void main(String[] args) throws IOException {

    File outFile = new File( "C:\\Tests\\fileOutput2.txt" );
    FileWriter fw = new FileWriter(outFile);

    Random rand = new Random();
    int x;
    String y;
    for(int i=1;i<=10001;i++){
         x = rand.nextInt(10001);
         y=x + " ";
         fw.write(y);
    }

    fw.close();

    }
}
