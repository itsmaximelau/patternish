/**
 * This class is used to flip an image. It's used
 * by FullImageGenerator to generate patterns from
 * a base image.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp.domain;

import java.awt.image.BufferedImage;

public class ImageFlipping {
    public static final int FLIP_VERTICAL = 1;
    public static final int FLIP_HORIZONTAL = 0;

    public static BufferedImage flip(BufferedImage bufferedImage, int direction){
        try{
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for(int y=0; y < height; y++){
                for(int x=0; x < width;  x++){
                    switch (direction){
                        case FLIP_HORIZONTAL:
                            flipped.setRGB((width - 1)-x,y,bufferedImage.getRGB(x,y));
                            break;
                        case FLIP_VERTICAL:
                            flipped.setRGB(x,(height - 1) - y,bufferedImage.getRGB(x,y));
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
