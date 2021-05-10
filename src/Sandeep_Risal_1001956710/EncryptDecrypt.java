package Sandeep_Risal_1001956710;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class EncryptDecrypt {
    public static void main(String[] args) {
        File file = new File("originalText.txt");
        String original = "";
        String encrypted = "";
        
        char[] character;
        char[] character1 = new char[48];
        char[] character2 = new char[48];
        char[] character3 = new char[48];
        char[] character4 = new char[48];
        char[] character5 = new char[48];
        String text = "";
        int num = 0, randomKeygen;

        String headerMessage = "A1B2";
        String trailerMessage = "END";

        //For generating random key///////////////////////
        Random r = new Random(8);
        randomKeygen = r.nextInt(9);
 
        //////////////// To read originalText.txt////////////////
        try {
            BufferedReader br = new BufferedReader(
            new FileReader("originalText.txt"));
            original = br.readLine();
        } catch (Exception e) {
            return;
        }

        System.out.println("Reading Original Text... : \n"+original);

        character = original.toCharArray();
        for (char c : character) {
            c += randomKeygen;
      
            character1[num] = c;
            num++;
        }
        int s = num;
        text = new String(character1);
        System.out.println("");
        System.out.println("Encrypted Text : \n"+ text);
        StringBuilder txt = new StringBuilder(text);
        txt.reverse();
        encrypted = headerMessage + txt + trailerMessage;
        System.out.println("");
        System.out.println("Reversing Encrypted Text... : \n"+ encrypted);
        
        
        ////////////// To make and write on encryptMessage.txt//////////////////////
        character2 = encrypted.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
            new FileWriter("encryptedText.txt"));
            for (char c : character2) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }

        // Read encryptText.txt
        try {
            BufferedReader br = new BufferedReader(
            new FileReader("encryptedText.txt"));
            encrypted = br.readLine();
        } catch (Exception e) {
            return;
        }
        System.out.println("");
        System.out.println("Encrypted, Reversed and Encapsilated Text... : \n"+ encrypted);
        
        
        ////////////////For decrypting encryptMessage.txt//////////////////
        character3 = encrypted.toCharArray();

        int ss = character3.length;
        ss -= 3;

        int j, i;
        for (i = 0, j = 0; i < character3.length; i++) {
            if (i > 3 && i < ss) {
                character4[j] = character3[i];
                j++;
            }
        }

        for (char c : character4) {
            
        }
        text = new String(character4);
        txt = new StringBuilder(text);
        txt.reverse();
        encrypted = txt + "";

        ///////////// For wirting the decrypted text on decryptedText.txt///////////////
        num = 0;
        character5 = encrypted.toCharArray();
        for (char c : character5) {
            c -= randomKeygen;

            character1[num] = c;
            num++;
        }
        

        String result = new String(character1);
 
        
        char[] finalChar = new char[s];
        for (i = 0, j = 0; i < character1.length; i++) {
            if (i < s) {
             finalChar[j] = character1[i];
                j++;
            }
        }

        result = new String(finalChar);
        System.out.println("");
        System.out.println("Decryption into original text... : \n"+ result);
        
        character2 = result.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
            new FileWriter("decryptedMessage.txt"));
            for (char c : character2) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception e) {
            return;
        }
    }
}
