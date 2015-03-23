
package programmingassignment2;

//COSC 1320 Spring 2015
//Sumaiya Asif
//Programming Assignment 2
//This is my own work; I will not post
import javax.swing.JFrame;

public class View extends JFrame{

    private JFrame playFrame;
    private Treasure draw = new Treasure(this);
    private int Xcor;
    private int Ycor;
    private long countMoves = 0;
    private String temperature;

    public View() {
        Xcor = 225;
        Ycor = 225;
    }

    public View(int treasureXset, int treasureYset) {
        Xcor = treasureXset;
        Ycor = treasureYset;
    }

    public void createWindow() {
        playFrame = new JFrame("Move the mouse to find the treasure");
        playFrame.setSize(500, 500);
        playFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        playFrame.setVisible(true);
        playFrame.add(draw);
        draw.addMouseMotionListener(new Mouse(draw, this));
    }
    public void closeWindow(){
        playFrame.dispose();
    }

    public String getTemperature(){
        return temperature;
    }

    public void setTemperature(String message){
        this.temperature = message;
    }

    public int getXcor() {
        return Xcor;
    }

    public void setXcor(int treasureXset) {
        this.Xcor = treasureXset;
    }

    public int getYcor() {
        return Ycor;
    }

    public void setYcor(int YcorSet) {
        this.Ycor = YcorSet;
    }

    public long getMoves(){
        return countMoves;
    }

    public void setMoves(int moves){
        this.countMoves = moves;
    }

    public void increaseMoves(){
        countMoves++;
    }


}
