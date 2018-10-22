package tkzwyk;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for {@link RectanglePuzzleResolver}
 */
public class RectanglePuzzleResolverTest {
    @Test
    public void x_is_6_and_y_is_4() {
        assertThat(RectanglePuzzleResolver.getHalfOfNumberOfSquares(6, 4),
                is(8L));
    }

    @Test
    public void x_is_49288_and_y_is_30488() {
        assertThat(
                RectanglePuzzleResolver.getHalfOfNumberOfSquares(49288, 30488),
                is(751306388L));
    }
}
