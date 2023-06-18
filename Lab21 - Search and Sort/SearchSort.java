
//Name: Vishruth M
import java.util.*;
import java.awt.*;

public class SearchSort
{

    public static void main(String[] args)
    {
        int[] nums = {64, 54, 18, 87, 35, 15};
        //Arrays.sort(nums);
        SearchSort s = new SearchSort(nums);
        System.out.println(s.binarySearch(86));
        //s.bubbleSort(true);
        //s.insertionSort(true);
        s.mergeSort(true);
    }

    int[] nums;
    Random random = new Random();

    public SearchSort(int[] nums)
    {
        this.nums = nums;
    }

    public SearchSort(int size)
    {
        nums = new int[size];
        initArray();
    }

    public void initArray()
    {
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = random.nextInt(100) + 1;
        }
    }

    public String toString()
    {
        String s = "[";
        for (int i = 0; i < nums.length - 1; i++)
        {
            s += nums[i] + ", ";
        }
        s += nums[nums.length - 1] + "]";
        return s;
    }

    private void swap(int i , int j)
    {
        int numAtI = nums[i];
        nums[i] = nums[j];
        nums[j] = numAtI;
    }

    public int linearSearch(int key)
    {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == key) return i;
        return -1;
    }

    public int binarySearch(int key)
    {
        int low = 0;
        int high = nums.length - 1;
        for (int i = (high + low) / 2; low < high || low == high; i = (high + low) / 2)
        {
            //System.out.println("Low: " + low + " Mid: " + i + " High: " + high);
            if (nums[i] != key)
            {
                if (key > nums[i]) low = i + 1;
                else high = i - 1;
            }
            else return i;
        }
        return -1;
    }

    public void bubbleSort(boolean print)
    {
        int numSorted = 0;
        //boolean hasSorted = false;
        for (int i = 0; i < nums.length; i++)
        {
            boolean hasSorted = false;
            for (int j = 0; j < (nums.length - 1) - numSorted; j++)
            {
                if (nums[j] > nums[j + 1])
                {
                    swap(j, j + 1);
                    hasSorted = true;
                    if (print) System.out.println(this);
                }

            }
            if (hasSorted) numSorted++;
        }
    }

    public void selectionSort(boolean print)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int minIndex = i;
            int min = nums[minIndex];

            for (int j = minIndex; j < nums.length; j++)
            {
                if (min > nums[j])
                {
                    min = nums[j];
                    minIndex = j;
                }
            }

            swap(i, minIndex);
            if (print) System.out.println(this);
        }
    }

    public void insertionSort(boolean print)
    {
        boolean foundSpot = false;
        for (int i = 1, loc = 0; i < nums.length; i++, loc = 0)
        {
            loc = i;
            int num = nums[loc];
            while (loc > 0)
            {
                if (num < nums[loc - 1])
                {
                    int locnum = nums[loc - 1];
                    nums[loc] = locnum;
                }
                else break;
                loc--;
            }
            nums[loc] = num;
            if (print) System.out.println(this);
        }
    }

    public void mergeSort(boolean print)
    {
        divideAndMerge(0, nums.length - 1, print);
    }

    public void divideAndMerge(int front, int back, boolean print)
    {

        if (front < back)
        {
            int mid = (front + back) / 2;
            divideAndMerge(front, mid, print);
            divideAndMerge(mid + 1, back, print);
            merge(front, mid, back);
            if (print) System.out.println(this);
            //System.out.println("Front: " + front + " Back: " + back);
        }

    }

    public void merge(int front, int mid, int back)
    {
        int[] temp = new int[nums.length];
        //System.out.println("Temp len: " + temp.length + " nums len: " + nums.length);
        int i = front;
        int j = mid + 1;
        int k = front;
        //System.out.println("I: " + i + " J: " + j + " K: " + k);
        //System.out.println("Front: " + front + " Mid: " + mid + " Back: " + back + "\n");

        while (i <= mid && j <= back)
        {
            if (nums[i] < nums[j])
            {
                temp[k] = nums[i];
                i++;
            }
            else
            {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid)
        {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= back)
        {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int r = front; r <= back; r++)
        {
            nums[r] = temp[r];
        }
    }
}
