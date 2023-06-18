//Version 1.0
public class Tester15 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.16)
            System.out.println("This test script requires TestGUI version 2.16 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(30);
        srcButton("Sprite, StationarySprite, MobileSprite, BouncingSprite, HeavySprite, ControllableSprite");

        //IMPORTANT: This tester requires that students use the version of StdDraw that 
        //   does NOT shut down on close.

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("Creating Sprites and Adding to World");  
        Object world = makeObject("World", new Object[]{600, 600});
        Object ss1 = makeObject("StationarySprite", new Object[]{
                    300, 300, 30, 70, "square.png"
                });
        testMethod(world, "add", new Object[] {ss1}); 
        Object ss2 = makeObject("StationarySprite", new Object[]{
                    380, 300, 70, 30, "square.png"
                });
        testMethod(world, "add", new Object[] {ss2}); 
        Object ms = makeObject("MobileSprite", new Object[]{
                    10, 10, 30, 30, "circle.png", 3, 1
                });
        testMethod(world, "add", new Object[] {ms}); 
        Object bs = makeObject("BouncingSprite", new Object[]{
                    320, 420, 64, 64, "asteroid.png", 1, 2
                });
        testMethod(world, "add", new Object[] {bs}); 
        Object hs = makeObject("HeavySprite", new Object[]{
                    300, 400, 40, 40, "triangle.png", 1, 3
                });
        testMethod(world, "add", new Object[] {hs});
        Object cs = makeObject("ControllableSprite", new Object[]{
                    440, 320, 64, 64, "spaceship.png"
                });
        testMethod(world, "add", new Object[] {cs});       

        header("Testing collisions"); 
        testMethod(ss1, "collides", new Object[] {ss2}, "false"); 
        testMethod(bs, "collides", new Object[] {hs}, "true"); 
        testMethod(ss1, "collides", new Object[] {cs}, "false"); 
        testMethod(ss2, "collides", new Object[] {cs}, "true");

        header("Object Design & Inheritance Tests"); 
        message("These tests verify that you followed proper rules of object design and inheritance as guided by the lab instructions.");   
        Class sClass = getClassFromName("Sprite");
        Class ssClass = getClassFromName("StationarySprite");
        Class msClass = getClassFromName("MobileSprite");     
        Class bsClass = getClassFromName("BouncingSprite"); 
        Class hsClass = getClassFromName("HeavySprite"); 
        Class csClass = getClassFromName("ControllableSprite"); 

        boolean t;
        if (sClass != null) {
            t = java.lang.reflect.Modifier.isAbstract(sClass.getModifiers());
            message("Sprite class is abstract: " + t, t); 
            
            t = java.util.Arrays.toString(sClass.getDeclaredMethods()).contains("public abstract void Sprite.step(World)");          
            message("step (in Sprite) is abstract: " + t, t);                     
        } else { message("Can't find Sprite class", false); } 
        
        if (ssClass != null) {
            t = ssClass.getSuperclass().getName().equals("Sprite");
            message("StationarySprite extends Sprite: " + t, t); 
            
            String fields = java.util.Arrays.toString(ssClass.getDeclaredFields());            
            t = ssClass.getDeclaredFields().length == 0 && ! fields.contains("public"); 
            message("StationarySprite declares 0 PIVs (all fields inherited): " + t, t);                  
        } else { message("Can't find StationarySprite class", false); } 
        
        if (msClass != null) {
            t = msClass.getSuperclass().getName().equals("Sprite");
            message("MobileSprite extends Sprite: " + t, t); 
            
            String fields = java.util.Arrays.toString(msClass.getDeclaredFields());            
            t = msClass.getDeclaredFields().length == 2 && ! fields.contains("public"); 
            message("MobileSprite declares 2 PIVs (all other fields inherited): " + t, t);                  
        } else { message("Can't find MobileSprite class", false); } 

        if (bsClass != null) {
            t = bsClass.getSuperclass().getName().equals("MobileSprite");
            message("BouncingSprite extends MobileSprite: " + t, t); 
            
            String fields = java.util.Arrays.toString(bsClass.getDeclaredFields());            
            t = bsClass.getDeclaredFields().length == 0 && ! fields.contains("public"); 
            message("BouncingSprite declares 0 PIVs (all fields inherited): " + t, t);                  
        } else { message("Can't find BouncingSprite class", false); } 
        
        if (hsClass != null) {
            t = hsClass.getSuperclass().getName().equals("BouncingSprite");
            message("HeavySprite extends BouncingSprite: " + t, t); 
            
            String fields = java.util.Arrays.toString(hsClass.getDeclaredFields());            
            t = hsClass.getDeclaredFields().length == 0 && ! fields.contains("public"); 
            message("HeavySprite declares 0 PIVs (all fields inherited): " + t, t);                  
        } else { message("Can't find HeavySprite class", false); } 
        
        if (csClass != null) {
            t = csClass.getSuperclass().getName().equals("MobileSprite");
            message("ControllableSprite extends MobileSprite: " + t, t); 
            
            String fields = java.util.Arrays.toString(csClass.getDeclaredFields());            
            t = csClass.getDeclaredFields().length == 0 && ! fields.contains("public"); 
            message("ControllableSprite declares 0 PIVs (all fields inherited): " + t, t);                  
        } else { message("Can't find ControllableSpriteSprite class", false); } 
        
        /*
        if (greedyPath != null) {
            boolean t = greedyPath.getSuperclass().getName().equals("Path");
            message("GreedyPath class extends Path: " + t, t);

            //Confirm that GreedyPath only has 1 PIV
            String fields = java.util.Arrays.toString(greedyPath.getDeclaredFields());            
            t = greedyPath.getDeclaredFields().length == 1 && ! fields.contains("public"); 
            message("GreedyPath class declares 1 PIV (all other fields were inherited): " + t, t);                                  
        } else { message("Can't find GreedyPath class", false); } 

        
        */
        boolean success = runAsThread(world, "run", null);
        message("Successfully called world.run():", success);
        message("IMPORTANT NOTICE: You won't necessarily get a 100 just because everything turned green.  Mr. McCoy will visually inspect the movements of your sprites and will test the controls of your arrow-key controlled sprite.");
    }    
}