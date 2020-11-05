package codility.l2_arrays;

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
    public static int[] solution(int[] A, int K) {
        return A.length == 0
                ? A
                : ((K % A.length) == 0)
                    ? A
                    : Stream.of(
                        Arrays.copyOfRange(A, offset(K, A.length), A.length),
                        Arrays.copyOfRange(A, 0, offset(K, A.length))
                ).flatMap(Stream::of).flatMapToInt(IntStream::of).toArray();
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

    public static void main(String[] args) {
        for(int i=0;i<10; i++) {
            Arrays.stream(solution(new int[]{3,4,5,3,5,6}, i)).forEach(System.out::print);
            System.out.println();
        }
    }
}
