package stack.commons.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Bytebased {

    public static void main(String[] args) throws IOException {

    File outFile = new File( "C:\\Tests\\fileOutput.bin" );
    FileOutputStream fos = new FileOutputStream(outFile);

    Random rand = new Random();
    int x;

    for(int i=1;i<=10001;i++){
         x = rand.nextInt(10001);
        fos.write(x);
    }
    fos.close();
    }
}
