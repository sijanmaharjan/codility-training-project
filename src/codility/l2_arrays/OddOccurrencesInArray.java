package codility.l2_arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <h1>OddOccurrencesInArray</h1>
 * Find value that occurs in odd number of elements.
 * @see <a href="https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/training8H2PJK-5Z6/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-02
 */
public class OddOccurrencesInArray {
    /**
     * N is an odd integer within the range [1..1,000,000];
     * each element of array A is an integer within the range [1..1,000,000,000];
     * all but one of the values in A occur an even number of times.
     * @param A
     * @return
     */
    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i=0; i<A.length; i+=2){
            if(i+1 == A.length) return A[i];
            else if(A[i] - A[i+1] != 0) return A[i];
        }
        throw new RuntimeException("No Odd Occurrence");
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, solution(new int[]{6,4,3,4,3,6,4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, solution(new int[]{9,3,9,3,9,7,9}));
    }
}
