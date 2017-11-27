package lights;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Lights {

    public static void main(String[] args) throws InterruptedException {
        int chosenNumber = menu();
        
        // If more menu items - could use switch statement
        if (chosenNumber == 1) {
            runProgram();
        }
        else {
            System.out.println("You must press 1 to run program");
        }
    }
    
    public static int menu() {
        Scanner reader = new Scanner(System.in);
        
        // More menu items can be added
        System.out.println("1 - Run program");
        System.out.print("Enter a number: ");
        
        int chosenNumber = reader.nextInt();
        reader.close();
        
        return chosenNumber;
    }
    
    public static void runProgram() throws InterruptedException {
        
        // LIST
        ArrayList<String> list = new ArrayList<String>();
        list.add("white");
        list.add("blue");
        list.add("green");
        
        
        // VARS
        int numberOfLights = 20;
        int count = 0;
        int lastIndex = list.size()-1;
        
        
        // TIME
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        
        // LOOP
        for (int i=0; i<numberOfLights; i++) {
            
            // LIGHT ON
            int lightNumber = i+1;
            String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(timestamp + 
                    " " + 
                    lightNumber + 
                    " " + 
                    list.get(count) + 
                    " light: " + "on");
            
            // PAUSE 1sec
            Thread.sleep(1000);
            
            // LIGHT OFF
            String ts = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(ts + 
                    " " + 
                    lightNumber + 
                    " " + 
                    list.get(count) + 
                    " light: " + "off");
            
            // Count
            count++;
            if (count > lastIndex) {
                count = 0;
            }
        }
    }
}
