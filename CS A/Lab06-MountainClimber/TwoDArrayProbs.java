
//Name: Vishruth M
import java.util.*;

public class TwoDArrayProbs
{
    private int[][] nums;
    
    public TwoDArrayProbs(int[][] nums)
    {
        this.nums = nums;
    }
    
    public int sum()
    {
        int sum = 0;
        for (int[] r : nums)
        {
            for (int num : r)
            {
                sum += num;
            }
        }
        return sum;
    }
    
    public boolean isSquare()
    {
        int count = 0;
        for (int[] r : nums)
        {
            if (r.length == nums.length)
                count++;
        }
        if (count == nums.length)
            return true;
        else
            return false;
    }
    
    public void addMatrix(int[][] other)
    {
        int row = 0;
        int column = 0;
        for (int[] r : other)
        {
            for (int c : r)
            {
                nums[row][column] += c;
                column++;
            }
            System.out.println(Arrays.toString(nums[row]));
            row++;
            column = 0;
        }
    }
    
    public int columnSum(int col)
    {
        int row = 0;
        int sum = 0;
        for (int[] r : nums)
        {
            try 
            {
                sum += nums[row][col];
            }
            catch (java.lang.ArrayIndexOutOfBoundsException e)
            {
                sum += 0;
            }
            row++;
        }
        return sum;
    }
    
    public boolean isColumnMagic()
    {
        int sum = 0;
        int colnum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i].length > colnum)
            {
                colnum = nums[i].length;
            }
        }
        for (int i = 0; i < colnum - 1; i++)
        {
          if (columnSum(i) != columnSum(i + 1))
            return false;
        }
        return true;
    }
    
    public int diagDifference()
    {
        int col = 0, row = 0, diag1 = 0, diag2 = 0;
        int col2 = nums[0].length - 1;
        for (int[] r : nums)
        {
            try 
            {
                diag1 += nums[row][col];
                diag2 += nums[row][col2];
            }
            catch (java.lang.ArrayIndexOutOfBoundsException e)
            {
                diag1 += 0;
                diag2 += 0;
            }
            row++;
            col++;
            col2--;            
        }
        return Math.abs(diag1 - diag2);
    }
}
