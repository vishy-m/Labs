//Version 1.0
public class Tester13 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.11)
            System.out.println("This test script requires TestGUI version 2.11 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(3);
        srcButton("Animal, Dog, Cat, Toy, House, Runner");
        message("Best possible score: 11 Green, 1 Yellow, 0 Red");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        //get value of current year field
        Class animal = getClassFromName("Animal");
        int currentYear = 0;
        if (animal != null) {
            //Confirm that Animal only has 4 PIVs and 1 static variable
            try {                
                currentYear = animal.getDeclaredField("currentYear").getInt(null);
            } catch (Exception e) { 
                message("Unable to determine the current year.  Do you not have a PUBLIC STATIC currentYear variable?", false);
            }
        } else { message("Can't find Animal class", false); }

        header("Functionality Tests");  
        Object t1 = makeObject("Toy", new Object[]{"Ball"});
        Object t2 = makeObject("Toy", new Object[]{"Ball"});
        Object t3 = makeObject("Toy", new Object[]{"Bone"});
        Object t4 = makeObject("Toy", new Object[]{"Busy Bee"});
        Object t5 = makeObject("Toy", new Object[]{"Bone"});
        Object t6 = makeObject("Toy", new Object[]{"Ball"});
        Object t7 = makeObject("Toy", new Object[]{"Mouse"});
        testMethod(t7, "toString", null, "A Mouse"); 
        testMethod(t1, "equals", new Object[]{t2}, "true"); 
        testMethod(t1, "equals", new Object[]{t3}, "false"); 
        Object h = makeObject("House", new Object[]{});
        Object a1 = makeObject("Dog", new Object[]{"Sparky", 2015, true});
        Object a2 = makeObject("Cat", new Object[]{"Fluffy", 2018});
        Object a3 = makeObject("Cat", new Object[]{"Roadkill", 2000, 0});
        testMethod(a3, "toString", null, "Hello, I am Roadkill. I am "+(currentYear-2000)+" years old.\nI have no friends.\nI have these 0 toys: []\nI have 0 lives."); 
        testMethod(a1, "addToy", new Object[]{t1}); 
        testMethod(a1, "addToy", new Object[]{t2}); 
        testMethod(a1, "addToy", new Object[]{t3}); 
        testMethod(a1, "addToy", new Object[]{t4}); 
        testMethod(a1, "addToy", new Object[]{t5}); 
        testMethod(a1, "addToy", new Object[]{t6}); 
        testMethod(a2, "addToy", new Object[]{t7}); 
        testMethod(a1, "setFriend", new Object[]{a2}); 
        testMethod(a2, "setFriend", new Object[]{a1});
        testMethod(h, "printAnimals", null, ""); 
        testMethod(h, "add", new Object[]{a1});
        testMethod(h, "add", new Object[]{a2});
        testMethod(h, "printAnimals", null, "Hello, I am Sparky. I am "+(currentYear-2015)+" years old.\nI have a friend named Fluffy.\nI have these 6 toys: [A Ball, A Ball, A Bone, A Busy Bee, A Bone, A Ball]\nI'm a good doggy.\n\nHello, I am Fluffy. I am "+(currentYear-2018)+" years old.\nI have a friend named Sparky.\nI have these 1 toys: [A Mouse]\nI have 9 lives."); 
        testMethod(h, "cleanHouse", null);
        testMethod(h, "printAnimals", null, "Hello, I am Sparky. I am "+(currentYear-2015)+" years old.\nI have a friend named Fluffy.\nI have these 3 toys: %line%\nI'm a good doggy.\n\nHello, I am Fluffy. I am "+(currentYear-2018)+" years old.\nI have a friend named Sparky.\nI have these 1 toys: [A Mouse]\nI have 9 lives."); 

        header("Inheritance Tests"); 
        message("These tests verify that you followed proper rules of inheritance as guided by the lab instructions.");   
        //Class animal = getClassFromName("Animal");
        Class dog = getClassFromName("Dog");
        Class cat = getClassFromName("Cat");     

        if (animal != null) {
            //Confirm that Animal only has 4 PIVs and 1 static variable
            String fields = java.util.Arrays.toString(animal.getDeclaredFields());            
            boolean t = animal.getDeclaredFields().length == 5 && fields.contains("public static int"); 
            int privateCount = 0;
            for (java.lang.reflect.Field f : animal.getDeclaredFields()) {
                if (f.toString().contains("private"))
                    privateCount++;
            }
            t = t && privateCount==4;
            message("Animal class declares 4 PIVs and 1 static variable: " + t, t);          
        } else { message("Can't find Animal class", false); } 

        if (dog != null) {
            boolean t = dog.getSuperclass().getName().equals("Animal");
            message("Dog class extends Animal: " + t, t);

            t = dog.getDeclaredFields().length == 1; 
            message("Dog class declares only one additional PIV (everything else inherited): " + t, t);           
        } else { message("Can't find Dog class", false); } 

        if (cat != null) {
            boolean t = cat.getSuperclass().getName().equals("Animal");
            message("Cat class extends Animal: " + t, t);

            t = cat.getDeclaredFields().length == 1; 
            message("Cat class declares only one additional PIV (everything else inherited): " + t, t);           
        } else { message("Can't find Cat class", false); } 

    }    
}