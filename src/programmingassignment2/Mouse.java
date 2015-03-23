package programmingassignment2;

//COSC 1320 Spring 2015
//Sumaiya Asif
//Programming Assignment 2
//This is my own work; I will not post
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Mouse implements MouseMotionListener {

    private String temperature;
    private int SIDE = 50;
    private int x;
    private int y;
    private View view;
    private Treasure draw;

    public Mouse(Treasure draw, View view) {
        this.draw = draw;
        this.view = view;
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if (Math.abs(x - view.getXcor()) < (.5 * SIDE) && Math.abs(y - view.getYcor()) < (.5 * SIDE)) {
            temperature = "Found";
            Output();
            draw.removeMouseMotionListener(this);
            System.out.println("win " + x + " " + y);
            draw.setTemperature(temperature);
            draw.drawing(temperature, x, y, view.getXcor(), view.getYcor());
            draw.drawing(temperature, x, y, view.getXcor(), view.getYcor());

        } else if (Math.abs(x - view.getXcor()) < SIDE && Math.abs(y - view.getYcor()) < SIDE) {
            temperature = "Hot";
            displayMove(x, y, temperature);
        } else if (Math.abs(x - view.getXcor()) < (2 * SIDE) && Math.abs(y - view.getYcor()) < (2 * SIDE)) {
            temperature = "Warm";
            displayMove(x, y, temperature);
        } else if (Math.abs(x - view.getXcor()) < (3 * SIDE) && Math.abs(y - view.getYcor()) < (3 * SIDE)) {
            temperature = "Lukewarm";
            displayMove(x, y, temperature);
        } else {
           temperature = "Cold";
            displayMove(x, y, temperature);
        }
        draw.setTemperature(temperature);
        draw.drawing(getTemperature(), x, y, view.getXcor(), view.getYcor());
        view.increaseMoves();
    }

    public void mouseDragged(MouseEvent e) {
    }

    private void displayMove(int x, int y, String temperature) {
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(new FileOutputStream(
                    "Programming Assignment 2 Data Output.txt", true));
        } catch (FileNotFoundException e) {
            System.out.println("Error saving file.");
            System.exit(0);
        }
        outFile.println("(" + x + "," + y + ") Message: " + temperature);
        outFile.flush();
    }

    private void Output() {
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(new FileOutputStream(
                    "Programming Assignment 2 Data Output.txt", true));
        } catch (FileNotFoundException e) {
            System.out.println("Error saving file.");
            System.exit(0);
        }
        outFile.println("Total moves: " + view.getMoves());
        outFile.flush();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getSIDE() {
        return SIDE;
    }

    public void setSIDE(int SIDE) {
        this.SIDE = SIDE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Treasure getDraw() {
        return draw;
    }

    public void setDraw(Treasure draw) {
        this.draw = draw;
    }
}
