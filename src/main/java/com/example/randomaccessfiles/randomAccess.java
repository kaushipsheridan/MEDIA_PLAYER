//Char has 2 bytes
//String has  =2*char
//int has 4 bytes

package com.example.randomaccessfiles;




import java.io.File;
import java.io.RandomAccessFile;
import javafx.scene.media.Media;

public class randomAccess {
    public static void main(String[] args) {
        try{
            File fname= new File("RandomAccessExample.txt");

        if(!fname.exists()) {


        }
            fname.createNewFile();


            RandomAccessFile raf = new RandomAccessFile(fname, "rw");
//            System.out.println("before writing the pointer is at " + raf.getFilePointer());
            raf.writeChars("Hello World");
//            raf.writeInt(10);
//            System.out.println("After writing the pointer is at " + raf.getFilePointer());
            //af.read();;
            //raf.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

            try {
                raf.seek((0));
                while (true) {
                    System.out.print(raf.readChar());


                }

            } catch (Exception e) {
                System.out.println("\nEnd of file");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

}}
