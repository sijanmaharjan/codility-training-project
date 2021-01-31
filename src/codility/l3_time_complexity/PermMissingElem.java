package codility.l3_time_complexity;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <h1>PermMissingElem</h1>
 * Find the missing element in a given permutation.
 * @see <a href="https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/trainingJ6JW7Q-ZQ4/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-08
 */
public class PermMissingElem {

    /**
     * N is an integer within the range [0..100,000];
     * the elements of A are all distinct;
     * each element of array A is an integer within the range [1..(N + 1)].
     * @param A
     * @return
     */
    public static int solution(int [] A){
        int sum1 = IntStream.range(1, A.length+2).sum();
        int sum2 = Arrays.stream(A).sum();
        return sum1 - sum2;
    }

    /**
     * N is an integer within the range [0..100,000];
     * the elements of A are all distinct;
     * each element of array A is an integer within the range [1..(N + 1)].
     * @param A
     * @return
     */
    public static int solution2(int [] A){
        int sum1=0, sum2=0;
        for(int i=0; i<A.length; i++){
            sum2 += A[i];
            sum1 += (i+1);
        }
        sum1 += A.length+1;
        return sum1 - sum2;
    }

    @Test
    public void test1() {
        int a[] = new int[99999];
        a[0]=1;
        a[1]=2;
        for(int j=2,i=4; i<=100000; j++,i++){
            a[j] = i;
        }
        Assert.assertEquals(3, solution(a));
    }

    @Test
    public void test2() {
        int a[] = new int[99999];
        a[0]=1;
        a[1]=2;
        for(int j=2,i=4; i<=100000; j++,i++){
            a[j] = i;
        }
        Assert.assertEquals(3, solution2(a));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, solution2(new int[]{1,2,3,4,6,7,8}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(7, solution2(new int[]{1,2,3,4,5,6,8}));
    }
}
