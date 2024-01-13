import java.awt.*;

public class CircleRunner {
    public static void main(String[] args) {        
        CircleAnimations app = new CircleAnimations(600); //supply window size, will be 600x600

        /**
         * UNCOMMENT CODE BELOW TO TEST EACH SECTION OF THE LAB
         * 
         * BEFORE YOU TURN THIS IN... Verify that Tester09Circles works correctly.
         * It is design to test everything at once.
         * 
         */

        //Test 1 - Drawing 3 random circles
        //app.addCircles();

        //Test 2 - Drawing 5 random circles
        //app.addCircles(5);

        //Test 3 - Detecting circle overlap
        //Circle a = new Circle(1, 1, 1, null); //color is irrelevant for this
        //Circle b = new Circle(3, 3, 1, null);
        //Circle c = new Circle(3, 3, 5, null);
        //System.out.println(a.overlaps(b)); //should print false
        //System.out.println(a.overlaps(c)); //should print true 

        //Test 4 - Generating 500 circles with no overlap
        //app.noOverlapping(500);

        //Test 5 - 50 moving circles (that bounce off walls)
        //app.movingCircles(50, 1000);  //1000 frames = approx 10 seconds

        //Test 6 - Bouncing with realistic physics (not required)
        //app.bouncePhysics2(); 

        //Test 7 - Painting circles (not required)
        app.paint();        
    }
}
