
//Name: 
import java.util.*;
public class Runner
{
    public static void main(String[] args)
    {
        SoundLabProbs sound = new SoundLabProbs();
        int[] nums = {1, 2, 3, 4};
        System.out.println(sound.lastIndexOf(nums, 8));

        // you could take the 3 gallon bucket water in the 5 gallon
        //then mark the air. then cut the marking. Then you make another marking based on thr cut and cut the 2nd marking out. Then you can combine the 2 markings to make a 4 gallon bucket.

        System.out.println(sound.range(nums));
        System.out.println(sound.minDifference(nums));
        System.out.println(sound.reverseWords("Hello world"));
        int[] bids = {1500, 1600, 2000, 2500};
        System.out.println(sound.priceIsRight(bids, 1900));
        System.out.println(Arrays.toString(sound.productExceptSelf(nums)));

        //double[] clip = {0.5, 1, 0, -1};
        //Sound.show(clip);
        //Sound.play(clip);
        double[] clip = Sound.pureTone(200.0, 1.0);
        Sound.show(clip);
        Sound.play(clip);
    }
}
