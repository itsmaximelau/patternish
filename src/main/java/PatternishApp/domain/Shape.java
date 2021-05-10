/**
 * Interface that will be used to implement more shapes
 * to be create by RandomShapeFactory in the future.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp.domain;

public interface Shape {
    int[] getX();
    int[] getY();
    int getSize();
}
