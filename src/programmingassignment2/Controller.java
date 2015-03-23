package programmingassignment2;

//COSC 1320 Spring 2015
//Sumaiya Asif
//Programming Assignment 2
//This is my own work; I will not post
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {

    private static int[] xCtr = new int[25];
    private static int[] yCtr = new int[25];
    private static int totalGames = 0;
    private static int totalTreasures = 0;

    private void getTreasure() {
        Scanner fileIn = null;
        int i = 0;
        try {
            fileIn = new Scanner(new FileInputStream("Programming Assignment 2 Data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        while (fileIn.hasNextLine()) {
            String coordinate = fileIn.nextLine();
            String[] coords = coordinate.split(",");
            xCtr[i] = Integer.parseInt((coords[0].trim().substring(1).trim()));
            yCtr[i] = Integer.parseInt(coords[1].trim().substring(0, coords[1].trim().length() - 1).trim());
            totalTreasures++;
            i++;
        }
    }

    public void cleanOutput() { //Cleans the output file to prevent large file
        PrintWriter fileOut = null;
        try {
            fileOut = new PrintWriter(new FileOutputStream(
                    "Programming Assignment 2 Data Output.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("There was an fatal error saving the data");
            System.exit(0);
        }
    }

    public void startGUI() {
        this.getTreasure();
        View view = new View(xCtr[0],xCtr[0]);
        view.createWindow();
        totalGames++;
       
    }

    public static int getXcorsAt(int i){
        return xCtr[i];
    }

    public static int getYcorsAt(int i){
        return yCtr[i];
    }

    public static int[] getxCtr() {
        return xCtr;
    }

    public static void setxCtr(int[] xCtr) {
        Controller.xCtr = xCtr;
    }

    public static int[] getyCtr() {
        return yCtr;
    }

    public static void setyCtr(int[] yCtr) {
        Controller.yCtr = yCtr;
    }

    public static int getTotalGames() {
        return totalGames;
    }

    public static void setTotalGames(int aTotalGames) {
        totalGames = aTotalGames;
    }

    public static int getTotalTreasures() {
        return totalTreasures;
    }

    public static void setTotalTreasures(int aTotalTreasures) {
        totalTreasures = aTotalTreasures;
    }
}
