package tkzwyk;

import sample.IntersectPoint;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Resolve the following puzzle.
 * <ul>
 * <li>There is a rectangle</li>
 * </ul>
 */
public class RectanglePuzzleResolver {
    public static void main(String[] args) {
        resolve();
    }

    private static void resolve() {
        final int width = 49288, height = 30488;

        final LocalDateTime beforeTime = LocalDateTime.now();

        final long answer = getAnswer(width, height);

        final long processingSeconds =
                ChronoUnit.SECONDS.between(beforeTime, LocalDateTime.now());

        log("answer: " + answer);
        log("Processing seconds: " + processingSeconds);
    }

    protected static long getAnswer2(final int maxX, final int maxY) {
        return getAnswer(maxX, maxY);
    }

    protected static long getAnswer(int MAX_X, int MAX_Y) {

        final Point2D p1 = new Point2D.Double(MAX_X, 0);
        final Point2D p2 = new Point2D.Double(0, MAX_Y);
        final Line2D line = new Line2D.Double(p1, p2);

        AtomicLong numberOfIntersectedSquares = new AtomicLong();
        for (int x = 1; x < MAX_X; x++) {

            IntersectPoint.getIntersectionPoint(line,
                    new Line2D.Double(x, 0, x, MAX_Y)).ifPresent(point2D -> {

                int intY = (int) (Math.floor(point2D.getY()));

                numberOfIntersectedSquares.addAndGet(intY);
            });

        }

        return numberOfIntersectedSquares.get();
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
