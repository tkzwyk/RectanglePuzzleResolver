package tkzwyk;

import com.github.zawataki.IntersectionPoint;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Resolve the following puzzle.
 * <ul>
 * <li>There is a rectangle</li>
 * </ul>
 */
public class RectanglePuzzleResolver {
    public static void main(String[] args) {
        final int x = 49288, y = 30488;
        log("answer: " + getAnswer(x, y));
    }

    protected static long getAnswer(final int maxX, final int maxY) {
        return getHalfOfNumberOfSquares(maxX, maxY) * 2;
    }

    protected static long getHalfOfNumberOfSquares(final int maxX,
            final int maxY) {

        final Point2D p1 = new Point2D.Double(maxX, 0);
        final Point2D p2 = new Point2D.Double(0, maxY);
        final Line2D line = new Line2D.Double(p1, p2);

        AtomicLong halfNumberOfSquares = new AtomicLong();
        for (int x = 1; x < maxX; x++) {

            IntersectionPoint.getIntersectionPoint(line,
                    new Line2D.Double(x, 0, x, maxY)).ifPresent(point2D -> {

                int intY = (int) (Math.floor(point2D.getY()));

                halfNumberOfSquares.addAndGet(intY);
            });

        }

        return halfNumberOfSquares.get();
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
