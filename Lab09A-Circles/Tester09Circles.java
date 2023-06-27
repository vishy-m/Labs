//Name: McCoy
import java.lang.reflect.*;
import java.awt.Color;
/**
 *  This tester does not require TestGUI.java
 *  This tester does not produce a red light/green light GUI
 *  It simply runs through the various tests provided in CircleRunner
 */
public class Tester09Circles
{
    public static void main(String[] args)
    {
        test1(); //runs test of: app.addCircles()
        test2(); //runs test of: app.addCircles(5)
        test3(); //runs test of: overlap method of Circle class
        test4(); //runs test of: noOverlapping(500)       
        test5(); //runs test of: app.movingCircles(50, 1000);
        test6(); //runs test of: app.bouncePhysics(1000); 
        test7(); //runs test of: app.paint();
    }

    /**
     *  Test 1 - Drawing random circles (no parameter version, should draw 3)
     *  Tests a call to:  app.addCircles();
     *  Then waits 2 seconds (so we can see the result before moving on)
     */
    public static void test1() {
        try {
            System.out.println("Attempting Test 1");
            CircleAnimations app = new CircleAnimations(600);
            Class c = Class.forName("CircleAnimations");        
            Method m = c.getMethod("addCircles");
            m.invoke(app, new Object[] { });
            StdDraw.pause(2000);
        } catch (Exception e) {
            System.out.println("Test #1 was not successful\nReason: " + e);
        }
        System.out.println();
    }

    /** Test 2 - Drawing random circles (parameterized - should draw 5)
     *  Tests a call to:  app.addCircles(5);
     *  Then waits 2 seconds (so we can see the result before moving on)
     */
    public static void test2() {
        try {
            System.out.println("Attempting Test 2");
            CircleAnimations app = new CircleAnimations(600);            
            Class c = Class.forName("CircleAnimations");        
            Method m = c.getMethod("addCircles", int.class);                        
            m.invoke(app, 5);
            StdDraw.pause(2000);
        } catch (Exception e) {
            System.out.println("Test #2 was not successful\nReason: " + e);
        }
        System.out.println();
    }

    /** 
     * Test 3 - Overlap
     * Tests calls to: circleA.overlaps(circleB) and circleA.overlaps(circleC)
     * Expected results: false true
     */
    public static void test3() {
        try {
            System.out.println("Attempting Test 3");
            Class c = Class.forName("Circle");
            Constructor con = c.getConstructor(int.class, int.class, int.class, Color.class);
            Object circleA = con.newInstance(1, 1, 1, null); //color is irrelevant for this
            Object circleB = con.newInstance(3, 3, 1, null);
            Object circleC = con.newInstance(3, 3, 5, null);
            Method m = c.getMethod("overlaps", c);
            System.out.println("Expected results of Test 3: \tfalse true");
            String s = "Actual results of Test 3: \t";
            s += m.invoke(circleA, circleB) + " "; //should be false
            s += m.invoke(circleA, circleC); //should be true 
            System.out.println(s);
            StdDraw.pause(2000);
        } catch (Exception e) {
            System.out.println("Test #3 was not successful\nReason: " + e);
        }
        System.out.println();
    }

    /** Test 4 - Drawing 500 circles with no overlap
     *  Tests a call to:  app.noOverlapping(500);
     *  Then waits 2 seconds (so we can see the result before moving on)
     */
    public static void test4() {
        try {
            System.out.println("Attempting Test 4");
            CircleAnimations app = new CircleAnimations(600);
            Class c = Class.forName("CircleAnimations");        
            Method m = c.getMethod("noOverlapping", int.class);
            m.invoke(app, 500);
            StdDraw.pause(2000);
        } catch (Exception e) {
            System.out.println("Test #4 was not successful\nReason: " + e);
        }
        System.out.println();
    }

    /** Test 5 - Moving circles (1000 frames of 50 circles moving around)
     *  Tests a call to:  app.movingCircles(50, 1000);
     */
    public static void test5() {
        try {
            System.out.println("Attempting Test 5");
            CircleAnimations app = new CircleAnimations(600);
            Class c = Class.forName("CircleAnimations");        
            Method m = c.getMethod("movingCircles", int.class, int.class);
            m.invoke(app, 50, 1000);
        } catch (Exception e) {
            System.out.println("Test #5 was not successful\nReason: " + e);
        }
        System.out.println();
    }
    
    /** Test 6 - Bounce Physics (1000 frames of balls bouncing on the ground)
     *  Tests a call to:  app.bouncePhysics(1000);
     */
    public static void test6() {
        try {
            System.out.println("Attempting Test 6 - Advanced (Optional)");
            CircleAnimations app = new CircleAnimations(600);
            Class c = Class.forName("CircleAnimations");        
            Method m = c.getMethod("bouncePhysics", int.class);
            m.invoke(app, 1000);
        } catch (Exception e) {
            System.out.println("Test #6 was not successful\nReason: " + e);
        }
        System.out.println();
    }
    
    /** Test 7 - Paint program 
     *  Tests a call to:  app.paint();
     */
    public static void test7() {
        try {
            System.out.println("Attempting Test 7 - Advanced (Optional)");
            CircleAnimations app = new CircleAnimations(600);
            Class c = Class.forName("CircleAnimations");        
            Method m = c.getMethod("paint");
            m.invoke(app);
        } catch (Exception e) {
            System.out.println("Test #7 was not successful\nReason: " + e);
        }
        System.out.println();
    }
}

