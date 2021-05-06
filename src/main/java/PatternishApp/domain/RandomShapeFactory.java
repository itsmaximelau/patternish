package PatternishApp.domain;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomShapeFactory {
    Random random = new Random();
    private int maxVertex;
    private int minVertex;
    private int maxX;
    private int maxY;
    private Controler controler;

    public RandomShapeFactory(Controler c){
        this.controler = c;
        setParameters();
    }

    public Shape generateShape(){
        int randType = random.nextInt(1);

        if (randType == 0 || randType == 1){
            int randVertex = random.nextInt((maxVertex - minVertex) + 1) + minVertex;
            List<Point> points = generateCoordinates(randVertex,maxX,maxY);

            return new Polygon(points);
        }

        return null;
    }

    private List<Point> generateCoordinates(int vertex,int maxX,int maxY){
        List<Point> vertexList = new ArrayList<Point>();

        for (int i=0; i<vertex; i++){
            int randX = random.nextInt(maxX);
            int randY = random.nextInt(maxY);
            vertexList.add(new Point(randX,randY));
        }

        return vertexList;
    }

    public void setParameters(){
        this.maxX = controler.getDrawingPanelBase().getWidth();
        this.maxY = controler.getDrawingPanelBase().getHeight();
        this.minVertex = controler.getMainWindow().getMinNumVertex();
        this.maxVertex = controler.getMainWindow().getMaxNumVertex();
    }
}
