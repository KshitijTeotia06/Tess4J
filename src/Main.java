import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.util.Scanner;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main{
    public static void main(String[] args) {
        Tesseract image = new Tesseract();
        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Please Enter File Name of Answer Key: ");
//            String answer = "/Users/skumar/Downloads/Tess4J/src/" + scan.next();
//
//            System.out.println("Please Enter File Name of Student Work: ");
//            String student = "/Users/skumar/Downloads/Tess4J/src/" + scan.next();

            File f = new File("/Users/skumar/Downloads/Tess4J/src/hardTest.png");
            System.out.println("REACHED");
            image.setDatapath("/Users/skumar/Downloads/Tess4J/tessdata");
            image.setTessVariable("user_defined_dpi", "300");
            System.out.println("REACHED");
            String str = image.doOCR(f);
            System.out.println("REACHED");
            System.out.println(str);
        } catch (TesseractException e) {
            System.out.println("ERROR: " + e);
        }
    }
}