import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {0,8,9,5,6};
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,-1, 'R')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,1, 'R')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,1, 'r')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,-2, 'g')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,3, 'L')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,-3, 'L')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr2,6, 'L')));
        System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(new int[0],3, 'R')));

        int[][] m = {{0,0,0}, {0,0,0}, {0,0,0}};
        int[][] m2 = {{0,1,0,0}, {0,0,1,0}, {1,0,0,0}, {0,0,0,1}};
        int[][] m3 = {{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}};
        int[][] m4 = {{1,1,0,1}, {0,1,1,0}, {0,0,1,1}, {0,0,0,1}};
        int[][] m5 = {{1,1,0,0}, {0,1,1,0}, {1,1,1,0}, {0,0,0,0}};
        System.out.println(ArrayUtils.findShortestPath(m, 0, 1));
        System.out.println(ArrayUtils.findShortestPath(m, 1, 1));
        System.out.println(ArrayUtils.findShortestPath(m2, 0, 2));
        System.out.println(ArrayUtils.findShortestPath(m3, 0, 2));
        System.out.println(ArrayUtils.findShortestPath(m4, 0, 1));
        System.out.println(ArrayUtils.findShortestPath(m5, 0, 3));

        System.out.println(StringUtils.findSortedSequence("art act"));
        System.out.println(StringUtils.findSortedSequence("abcd abcde abc abd"));
        System.out.println(StringUtils.findSortedSequence("abc abcd"));

        System.out.println(StringUtils.isEditDistanceOne("helo", "hello"));
        System.out.println(StringUtils.isEditDistanceOne("abcd", "abc"));
        System.out.println(StringUtils.isEditDistanceOne("abc", "abcd"));
    }

}
