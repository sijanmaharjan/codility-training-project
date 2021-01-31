package codility.l3_time_complexity;

import org.junit.Assert;
import org.junit.Test;

/**
 * <h1>FrogJmp</h1>
 * Count minimal number of jumps from position X to Y.
 * @see <a href="https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/trainingWFXPF9-G57/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-08
 */
public class FrogJmp {
    /**
     * X, Y and D are integers within the range [1..1,000,000,000];
     * X ≤ Y.
     * @param X source
     * @param Y dest
     * @param D fixed distance
     * @return minimal number of jumps
     */
    public static int solution(int X, int Y, int D){
        int totalJmp = (Y - X) / D;
        return  (X + totalJmp * D == Y)? totalJmp : totalJmp+1;
    }

    @Test
    public void test1() {
        Assert.assertEquals(142730189, solution(3, 999111321, 7));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution(10, 85, 30));
    }
}
