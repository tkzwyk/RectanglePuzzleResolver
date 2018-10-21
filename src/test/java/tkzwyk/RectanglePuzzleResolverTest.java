package tkzwyk;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for {@link RectanglePuzzleResolver}
 */
public class RectanglePuzzleResolverTest {
    @Test
    public void patter1() {
        assertThat(RectanglePuzzleResolver.getAnswer(6, 4), is(8L));
    }

    @Test
    public void patter2() {
        assertThat(RectanglePuzzleResolver.getAnswer(49288, 30488),
                is(751306388L));
    }
}
