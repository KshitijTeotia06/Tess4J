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
            Scanner scan = new Scanner(System.in);
            System.out.println("PLEASE ENTER THE NAME OF THE ANSWER KEY FILE: ");
            String answerFileName = "/Users/skumar/Downloads/Tess4J/src/" + scan.next();
            File answerKey = new File(answerFileName);

            System.out.println("PLEASE ENTER THE NAME OF THE STUDENT ANSWERS FILE: ");
            String studentFileName = "/Users/skumar/Downloads/Tess4J/src/" + scan.next();
            File studentFile = new File(studentFileName);

            image.setDatapath("/Users/skumar/Downloads/Tess4J/tessdata");
            image.setTessVariable("user_defined_dpi", "1000");

            String answer = image.doOCR(answerKey);
            String student = image.doOCR(studentFile);

            String answerNew = "";
            for (int i = 1; i < answer.length(); i+=3) {
                answerNew += answer.charAt(i);
            }

            String studentNew = "";
            for (int i = 1; i < student.length(); i+=3) {
                studentNew += student.charAt(i);
            }

            int score = 0;
            for (int i = 0; i < Math.min(studentNew.length(), answerNew.length()); i++) {
                if(studentNew.charAt(i) == answerNew.charAt(i))
                    score++;
                else {
                    int a = i+1;
                    System.out.println("#" + a + " is wrong");
                }
            }
            System.out.println("STUDENT GOT " + score + " questions right");

        } catch (TesseractException e) {
            System.out.println("ERROR: " + e);
        }
    }
}