package PatternishApp.domain;

import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.IOException;

public class ImageFlipping {
    public static final int FLIP_VERTICAL = 1;
    public static final int FLIP_HORIZONTAL = -1;

    public static BufferedImage flip(BufferedImage bi, int direction){
        try{
            int width = bi.getWidth();
            int height = bi.getHeight();
            BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for(int y=0; y < height; y++){
                for(int x=0; x < width;  x++){
                    switch (direction){
                        case FLIP_HORIZONTAL:
                            flipped.setRGB((width - 1)-x,y,bi.getRGB(x,y));
                            break;
                        case FLIP_VERTICAL:
                            flipped.setRGB(x,(height - 1) - y,bi.getRGB(x,y));
                            break;
                    }
                }
            }
            return flipped;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
