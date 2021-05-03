package PatternishApp.domain;

import java.util.ArrayList;
import java.util.List;

public class Controler {
    private List<Shape> shapeList = new ArrayList<>();
    private RandomShapeFactory randomShapeFactory = new RandomShapeFactory();
    private Drawer drawer = new Drawer(this);

    public Controler() {
    }

    public void generateRandomShape(){
        shapeList.add(randomShapeFactory.generateShape());
    }

    public void generateNewShapes(int amount){
        shapeList.clear();
        for (int i=0; i<amount; i++){
            generateRandomShape();
        }
    }

    public List<Shape> getShapeList(){
        return shapeList;
    }


}
