
//Name: 

public class TwoDRunner
{

    public static void main(String[] args)
    {
        System.out.println(" >>> " + new TwoDArrayProbs(new int[][] {{1, 2}, {10, 11}}).sum());
        System.out.println(new TwoDArrayProbs(new int[][] {{2, 3}, {5, 4, 6}}).isSquare());
        new TwoDArrayProbs(new int[][] {{1,2,3}, {3,2,1}}).addMatrix(new int[][] {{2,3,1}, {3,1,2}});
        System.out.println();
        System.out.println("" + new TwoDArrayProbs(new int[][] {{1, 2, 3}, {4, 5, 6}, {6}}).columnSum(2));
        System.out.println(new TwoDArrayProbs(new int[][] {{1, 2}, {4, 3}, {1, 1, 5}}).isColumnMagic());
        System.out.println(new TwoDArrayProbs(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}).diagDifference());
    }
}
