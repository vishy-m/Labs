//Version 1.0
public class Tester03 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.171)
            System.out.println("This test script requires TestGUI version 2.171 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(5);
        srcButton("SoundLabProbs, SoundClip");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])        

        message("Best possible score is: 20 Green, 0 Yellow, 0 Red");        

        header("SoundLabProbs Tests");                 
        Object o = makeObject("SoundLabProbs", new Object[]{});

        testMethod(o, "lastIndexOf", new Object[]{new int[] {8, 2, 4, 6, 8}, 8}, "4");
        testMethod(o, "lastIndexOf", new Object[]{new int[] {8, 2, 4, 6, 8}, 2}, "1");
        testMethod(o, "lastIndexOf", new Object[]{new int[] {2, 4, 6, 12}, 8}, "-1");

        testMethod(o, "range", new Object[]{new int[] {8, 3, 5, 7, 2, 4}}, "6");
        testMethod(o, "range", new Object[]{new int[] {15, 22, 8, 19, 31}}, "23");

        testMethod(o, "minDifference", new Object[]{new int[] {4, 8, 6, 1, 5, 9, 4}}, "2");
        testMethod(o, "minDifference", new Object[]{new int[] {4, 8, 13, 17, 20, -7}}, "3");

        testMethod(o, "reverseWords", new Object[]{"hello world"}, "world hello ");
        testMethod(o, "reverseWords", new Object[]{"the sky is blue"}, "blue is sky the");

        testMethod(o, "priceIsRight", new Object[]{new int[] {900, 885, 990, 1}, 800}, "1");
        testMethod(o, "priceIsRight", new Object[]{new int[] {1500, 1600, 2000, 2500}, 1900}, "1600");

        testMethod(o, "productExceptSelf", new Object[]{new int[] {1, 2, 3, 4}}, "[24, 12, 8, 6]");

        header("SoundLab Test"); 
        Class soundClass = getClassFromName("Sound");
        message("IMPORTANT NOTICE: Just because the tests below turn green doesn't mean that you did it correctly.  You should visually compare your waveforms to the last page of the instructions.");
        double[] sound1 = new double[] {0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4};  
        double[] sound2 = new double[] {-0.5, -0.8, -1.0, -0.8, -0.5};
        Object c = makeObject("SoundClip", new Object[]{sound1}); 
        Object ret = testMethod(c, "getClip", new Object[]{}, 
                "[0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4]"
            );
        boolean success = false;

        //ADJUSTING VOLUME TEST
        sound1 = new double[] {0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4};  
        sound2 = new double[] {-0.5, -0.8, -1.0, -0.8, -0.5};
        c = makeObject("SoundClip", new Object[]{sound1}); 
        testMethod(c, "adjustVolume", new Object[]{0.5}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after adjusting volume : " + success, success);

        //MIX TEST
        sound1 = new double[] {0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4}; 
        sound2 = new double[] {-0.5, -0.8, -1.0, -0.8, -0.5};
        c = makeObject("SoundClip", new Object[]{sound1}); 
        testMethod(c, "mix", new Object[]{sound1, sound2}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after mixing 2 clips : " + success, success);

        //APPEND TEST
        sound1 = new double[] {0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4}; 
        sound2 = new double[] {-0.5, -0.8, -1.0, -0.8, -0.5};
        c = makeObject("SoundClip", new Object[]{sound2}); 
        testMethod(c, "append", new Object[]{sound1}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after appending clips : " + success, success);
        
        //FADE IN TEST
        c = makeObject("SoundClip", new Object[]{Sound.pureTone(300, .02)}); 
        testMethod(c, "fadeIn", new Object[]{.01}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after fading in : " + success, success);
        
        
        //FADE OUT TEST
        c = makeObject("SoundClip", new Object[]{Sound.pureTone(200, .02)}); 
        testMethod(c, "fadeOut", new Object[]{.01}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after fading out : " + success, success);
        
        //REVERSE TEST
        sound1 = new double[] {0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4}; 
        c = makeObject("SoundClip", new Object[]{sound1}); 
        testMethod(c, "reverse", new Object[]{}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after reversing : " + success, success);
        
        //SPEEDUP TEST
        sound1 = new double[] {0.4, 0.7, 0.9, 1.0, 0.9, 0.7, 0.4, -0.4, -0.7, -0.9, -1.0, -0.9, -0.7, -0.4}; 
        c = makeObject("SoundClip", new Object[]{sound1}); 
        testMethod(c, "speedUp", new Object[]{2.0}, null);
        ret = testMethod(c, "getClip", new Object[]{}, null);
        success = false;
        try {
            double[] retarray = (double[]) ret;
            success = runAsThread(soundClass, "show", new Object[] {(double[])retarray});
        } catch (Exception other) { }
        message("Successfully called show() after speeding up (x2) : " + success, success);                

    }
}