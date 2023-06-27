
//Name: Vishruth M;
import java.util.*;
public class SoundLabProbs
{
    public SoundLabProbs()
    {

    }

    public int lastIndexOf(int[] nums, int value)
    {
        for (int i = nums.length - 1; i >= 0; i--)
            if (nums[i] == value)
                return i;
        return -1;
    }

    public int range(int[] nums)
    {
        int smallest = nums[0];
        int biggest = nums[0];

        for (int i = 0; i < nums.length; i++)
        {
            if (biggest < nums[i])
            {
                biggest = nums[i];
            }
            else if (smallest > nums[i])
            {
                smallest = nums[i];
            }
        }
        return biggest - smallest;
    }

    public int minDifference(int[] nums)
    {
        int difference = 100000;
        int negative = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            negative = nums[i] - nums[i + 1];
            if (negative < 0)
                negative = -(negative);
            if (difference > negative)
                difference = negative;
             
        }
        return difference;
    }
    
    public String reverseWords(String str)
    {
        String[] words = str.split(" ");
        String ret = "";
        for (int i = words.length - 1; i >= 0; i--)
        {
            ret += words[i] + " ";
        }
        return ret;
    }
    
    public int priceIsRight(int[] bids, int price)
    {
        int negativeCount = 0;
        int lowestNum = bids[0];
        int difference = 0;
        for (int i = 0; i < bids.length; i++)
        {
            if (bids[i] > price)
                negativeCount++;
            else 
            {
                if (lowestNum > price - bids[i])
                {
                    lowestNum = price - bids[i];
                    difference = bids[i];
                }  
            }
        }
        if (negativeCount == bids.length)
            return -1;
        return difference;
    }
    public int[] productExceptSelf(int[] nums)
    {
        int[] products = new int[nums.length];
        int sum = 1;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
                if (nums[j] != nums[i])
                    sum = sum * nums[j];
            products[i] = sum;
            sum = 1;
        }
        return products;
    }
}

