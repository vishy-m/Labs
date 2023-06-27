
//Name: 
import java.util.*;

public class SoundClip
{
    private double[] clip;

    public SoundClip()
    {
        clip = null;
    }

    public SoundClip(double[] c)
    {
        clip = c;
    }

    // accessor//
    public double[] getClip()
    {
        return clip;
    }

    //modifier//
    public void adjustVolume(double factor)
    {
        for (int i = 0; i < clip.length; i++)
        {
            clip[i] *= factor;
        }
    }

    public void mix(double[] clip1, double[] clip2)
    {
        if (clip1.length > clip2.length)
        {
            clip = new double[clip1.length];
            for (int i = 0; i < clip.length; i++)
                clip[i] = clip1[i];
            for (int i = 0; i < clip2.length; i++)
                clip[i] += clip2[i];
        }
        else 
        {
            clip = new double[clip2.length];
            for (int i = 0; i < clip.length; i++)
                clip[i] = clip2[i];
            for (int i = 0; i < clip1.length; i++)
                clip[i] += clip1[i];
        }

    }

    public void append(double[] other)
    {
        double[] result = new double[clip.length + other.length];
        for (int i = 0, j = 0; i < result.length; i++)
        {
            if (i < clip.length)
                result[i] = clip[i];
            else
            {
                result[i] = other[j];
                j++;
            }
        }
        clip = result;
    }

    public void fadeIn(double seconds)
    {
        double seconds2 = seconds;
        double secSamples = Sound.toNumSamples(seconds);
        for (int i = 0; i < clip.length; i++)
        {
            clip[i] *= i / secSamples;
        }
    }

    public void fadeOut(double seconds)
    {
        double seconds2 = seconds;
        double secSamples = Sound.toNumSamples(seconds);
        for (int i = clip.length - 1, j = 0; i >= 0; i--, j++)
        {
            clip[i] *= j / secSamples;
        }
    }

    public void reverse()
    {
        double[] clip2 = clip;
        double[] clip1 = new double[clip2.length];
        for (int i = 0, r = clip2.length - 1; i < clip.length; i++, r--)
        {
            clip1[i] = clip2[r];
        }
        clip = clip1;
    }

    public void speedUp(double factor)
    {
        double[] clip2 = new double[clip.length / (int)factor];
        double average = 0;
        int clipIndex = 0;
        
        for (int i = 0; i < clip2.length && clipIndex < clip.length; i++, clipIndex += factor)
        {
            clip2[i] = clip[clipIndex];
        }
        clip = clip2;
    }

}
