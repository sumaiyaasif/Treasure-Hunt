package programmingassignment2;

//COSC 1320 Spring 2015
//Sumaiya Asif
//Programming Assignment 2
//This is my own work; I will not post
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Treasure extends JPanel {

    private int SIDE = 50;
    private int Xcor;
    private int Ycor;
    private int eventX;
    private int eventY;
    private String temperature = "test";
    private View view;

    public Treasure(View view) {
        this.view = view;
    }

    public void drawing(String temperature, int x, int y, int Xcor, int Ycor) {
        this.temperature = temperature;
        this.eventX = x;
        this.eventY = y;
        this.Xcor = Xcor;
        this.Ycor = Ycor;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        if (getTemperature().equals("Found")) {
            g.setColor(Color.RED);
            g.fillRect(Xcor - getSIDE() / 2, Ycor - SIDE / 2, SIDE, SIDE);
            g.setColor(Color.YELLOW);
            g.drawString("Found", Xcor - SIDE / 2, Ycor);
            if (Controller.getTotalGames() < Controller.getTotalTreasures() && Xcor == view.getXcor()) {
                view.setXcor(Controller.getXcorsAt(Controller.getTotalGames()));
                view.setYcor(Controller.getYcorsAt(Controller.getTotalGames()));
                view.createWindow();
                Controller.setTotalGames(Controller.getTotalGames() + 1);
                //view.setMoves = 0;
            }
        } else {
            g.drawString(temperature, eventX, eventY);
        }
    }

    public int getSIDE() {
        return SIDE;
    }

    public void setSIDE(int SIDE) {
        this.SIDE = SIDE;
    }

    public int getXcor() {
        return Xcor;
    }

    public void setXcor(int Xcor) {
        this.Xcor = Xcor;
    }

    public int getYcor() {
        return Ycor;
    }

    public void setYcor(int Ycor) {
        this.Ycor = Ycor;
    }

    public int getEventX() {
        return eventX;
    }

    public void setEventX(int eventX) {
        this.eventX = eventX;
    }

    public int getEventY() {
        return eventY;
    }

    public void setEventY(int eventY) {
        this.eventY = eventY;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
