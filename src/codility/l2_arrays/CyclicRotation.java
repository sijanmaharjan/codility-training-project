package codility.l2_arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h1>CyclicRotation</h1>
 * Rotate an array to the right by a given number of steps.
 * @see <a href="https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/training2YEBKT-GNF/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-02
 */
public class CyclicRotation {
    /**
     * N and K are integers within the range [0..100];
     * each element of array A is an integer within the range [−1,000..1,000].
     * @param A
     * @param K
     * @return
     */
    public static int[] solution(int[] A, int K) {
        return A.length == 0
                ? A
                : ((K % A.length) == 0)
                    ? A
                    : Stream.of(
                        Arrays.copyOfRange(A, offset(K, A.length), A.length),
                        Arrays.copyOfRange(A, 0, offset(K, A.length))
                ).flatMapToInt(IntStream::of).toArray();
    }

    /**
     * returns offset = L - (K % L)
     * @param K K
     * @param L array length
     * @return offset
     */
    private static int offset(int K, int L){
        return L - (K % L);
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{3,5,6,3,4,5}, solution(new int[]{3,4,5,3,5,6}, 3));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{9, 7, 6, 3, 8}, solution(new int[]{3, 8, 9, 7, 6}, 3));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{0, 0, 0}, solution(new int[]{0, 0, 0}, 1));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, solution(new int[]{1, 2, 3, 4}, 4));
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(new int[]{4, -10, 2, -30}, solution(new int[]{-10, 2, -30, 4}, 1));
    }
}
