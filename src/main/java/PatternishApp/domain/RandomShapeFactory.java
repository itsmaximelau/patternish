package PatternishApp.domain;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomShapeFactory {

    Random random = new Random();

    public Shape generateShape(){
        int randType = random.nextInt(1);

        if (randType == 0 || randType == 1){
            int max = 6;
            int min = 3;
            int randVertex = random.nextInt((max - min) + 1) + min;
            List<Point> points = generateCoordinates(randVertex,500,500);

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
}
