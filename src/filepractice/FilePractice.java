/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filepractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Dan
 */
public class FilePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File data = new File("C:" + File.separatorChar + "temp" + File.separatorChar +
                "lab1.txt");
        
        BufferedReader read = null;
        
        try {
            read = new BufferedReader(new FileReader(data));
            String line = " ";
            while (line != null){
                line = read.readLine();
                
                int lineNumber = 1;
                if (lineNumber == 1){
                    String[] formatter = line.split(" ");
                    System.out.println("Last Name: " + formatter[1]);
                    System.out.println("First Name: " + formatter[0]);
                    lineNumber++;
                }
                if (lineNumber == 2){
                    line = read.readLine();
                    System.out.println("Address: " + line);
                    lineNumber++;
                }
                if (lineNumber == 3){
                    line = read.readLine();
                    System.out.println("City, State, Zip: " + line);
                    
                }
                line = read.readLine();
                if (line != null){
                    System.out.println(line);
                }
                lineNumber = 1;
            }
            
        }catch (IOException ioe){
            System.out.println("Error");
        }
        finally{
            try{
               read.close(); 
            }catch(Exception e){
                
            }
            
        }
        
        System.out.println("\nWould you like to add another contact?");
        
        
        Scanner keyboard = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n\nMenu Options\n");
            System.out.println("(1) - Enter Contact");
            System.out.println("(2) - Quit");

            System.out.print("Please enter your selection:");
            String selection = keyboard.nextLine();

            if ("1".equals(selection)) {
                boolean append = true;
              
   
                PrintWriter out = new PrintWriter(
			new BufferedWriter(new FileWriter(data, append)));
                
           
                
                System.out.print("Enter contact name(first and last):\t");
                String name = keyboard.nextLine();
                
                System.out.print("Enter contact address:\t");
                String address = keyboard.nextLine();
                
                System.out.print("Enter contact City, State, Zip\t");
                String cityStateZip = keyboard.nextLine();
                
                
                out.println(name);
                out.println(address);
                out.println(cityStateZip);
                
                out.close();
                
         
            }
            
            else if ("2".equals(selection)) {
                break;
            }
        }
   
        
        
}
}
