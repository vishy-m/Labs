//Version 1.2
public class Tester12 extends TestGUI.TestData{ 
   public static void main (String[] args) {        
      new TestGUI();   
   }

   public static void runTests() {  //Your test sequence must be within a method called runTests()
      //WRITE ALL YOUR TEST CASES IN HERE       
      setTimeOutSec(3);
      srcButton("Lock, CombinationLock, Date, Appointment, Vehicle, Car, Truck, Motorcycle, Inventory");
   
      // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
      // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])
   
      header("Combination Lock Functionality Tests");  
      message("Tests for just a standard lock (not a combination lock)");
      Object l = makeObject("Lock", new Object[]{});
      testMethod(l, "toString", null, "Lock is closed"); 
      testMethod(l, "open", null);
      testMethod(l, "toString", null, "Lock is open"); 
      testMethod(l, "close", null);
      testMethod(l, "toString", null, "Lock is closed");         
      message("Constructing a default combination lock & testing toString");
      Object c1 = makeObject("CombinationLock", new Object[]{});
      testMethod(c1, "toString", null, "Lock is closed, combination is ");        
      message("Constructing a parameterized combination lock & testing toString");
      Object c2 = makeObject("CombinationLock", new Object[]{"12-34-56"});
      testMethod(c2, "toString", null, "Lock is closed, combination is 12-34-56");        
      message("Performing various tests of open, close, and changing combination.");
      testMethod(c2, "open", null, "Enter combination >>> 88-88-88", "88-88-88");        
      testMethod(c2, "toString", null, "Lock is closed, combination is 12-34-56"); 
      testMethod(c2, "open", null, "Enter combination >>> 12-34-56", "12-34-56");                
      testMethod(c2, "toString", null, "Lock is open, combination is 12-34-56");
      testMethod(c2, "setCombination", new Object[]{"77-66-55"});                
      testMethod(c2, "close", null);
      testMethod(c2, "toString", null, "Lock is closed, combination is 77-66-55");
      
      header("Combination Lock Inheritance Tests"); 
      message("These tests verify that you followed proper rules of inheritance as guided by the lab instructions.");   
      Class combLock = getClassFromName("CombinationLock");
      if (combLock != null) {
         //See if CombinationLock extends Lock 
         boolean t = combLock.getSuperclass().getName().equals("Lock");
         message("CombinationLock class extends Lock: " + t, t);   
         
         //Confirm that CombinationLock only has 1 PIV
         t = combLock.getDeclaredFields().length == 1; 
         message("CombinationLock class declares only an additional PIV (for the combination): " + t, t); 
         
         //Confirm that CombinationLock inheritance and override
         String methodList = java.util.Arrays.toString(combLock.getDeclaredMethods());
         t = ! methodList.contains("close()"); 
         message("CombinationLock inherits close() without override: " + t, t);   
         t = methodList.contains("open()"); 
         message("CombinationLock overrides open(): " + t, t);               
      } else { message("Can't find CombinationLock class", false); }        
      
      header("Scheduler Functionality Tests");
      Object d = makeObject("Date", new Object[]{});
      testMethod(d, "toString", null, "1/1/1970"); 
      Object a = makeObject("Appointment", new Object[]{});
      testMethod(a, "toString", null, "1/1/1970 Do nothing"); 
      a = makeObject("Appointment", new Object[]{12, 31, 2020, "Good riddance, 2020."});
      testMethod(a, "toString", null, "12/31/2020 Good riddance, 2020.");
      testMethod(a, "getDay", null, "31");
      testMethod(a, "getText", null, "Good riddance, 2020.");
      
      header("Scheduler Inheritance Tests"); 
      message("These tests verify that you followed proper rules of inheritance as guided by the lab instructions.");   
      Class appt = getClassFromName("Appointment");
      if (appt != null) {
         //See if Appointment extends Date
         boolean t = appt.getSuperclass().getName().equals("Date");
         message("Appointment class extends Date: " + t, t);   
         
         //Confirm that Appointment only has 1 PIV
         t = appt.getDeclaredFields().length == 1; 
         message("Appointment class declares only an additional PIV (for the text): " + t, t);                        
      } else { message("Can't find CombinationLock class", false); }  
      
      header("Used Cars Functionality Tests");
      Object v = makeObject("Vehicle", new Object[]{"General Vehicle", 1900, 999.99});
      testMethod(v, "getInfo", null, "1900 General Vehicle"); 
      Object v1 = makeObject("Car", new Object[]{"Mini Cooper", 2012, 17999, 38});
      testMethod(v1, "getInfo", null, "2012 Mini Cooper, 38.0 mpg, $17999.0"); 
      Object v2 = makeObject("Truck", new Object[]{"Ford F150", 2009, 15300, 2001});
      testMethod(v2, "canTowBoat", null, "true"); 
      Object v3 = makeObject("Motorcycle", new Object[]{"Suzuki DR-Z400", 2020, 7399, false});
      Object v4 = makeObject("Motorcycle", new Object[]{"Ural Geo", 2021, 17579, true});
      Object inv = makeObject("Inventory", new Object[]{});        
      testMethod(inv, "addVehicle", new Object[]{v2});
      testMethod(inv, "addVehicle", new Object[]{v3});
      testMethod(inv, "addVehicle", new Object[]{v4});
      testMethod(inv, "listInventory", null, "2009 Ford F150, 2001 lbs. towing, $15300.0\n2020 Suzuki DR-Z400 without side car, $7399.0\n2021 Ural Geo with side car, $17579.0");
      
      header("Used Cars Inheritance Tests"); 
      message("These tests verify that you followed proper rules of inheritance as guided by the lab instructions.");   
      Class vehicle = getClassFromName("Vehicle");
      Class car = getClassFromName("Car");
      Class truck = getClassFromName("Truck");
      Class motorcycle = getClassFromName("Motorcycle");
      Class inventory = getClassFromName("Inventory");       
      
      if (car != null) {
         //See if Car extends Vehicle 
         boolean t = car.getSuperclass().getName().equals("Vehicle");
         message("Car class extends Vehicle: " + t, t);
         
         //Confirm that Car only has 1 PIV
         t = car.getDeclaredFields().length == 1; 
         message("Car class declares only an additional PIV (for the mpg): " + t, t); 
         
         //Confirm that Car inheritance and override
         java.lang.reflect.Method[] methods = car.getDeclaredMethods();
         String methodList = java.util.Arrays.toString(methods);
         t = methods.length==2 && methodList.contains("greatMPG()") && methodList.contains("getInfo()"); 
         message("Car class declares only greatMPG() and overrides getInfo() : " + t, t);              
      } else { message("Can't find Car class", false); } 
      
      if (truck != null) {
         boolean t = truck.getSuperclass().getName().equals("Vehicle");
         message("Car class extends Vehicle: " + t, t);
         
         t = truck.getDeclaredFields().length == 1; 
         message("Truck class declares only an additional PIV (for the towing capacity): " + t, t); 
         
         java.lang.reflect.Method[] methods = truck.getDeclaredMethods();
         String methodList = java.util.Arrays.toString(methods);
         t = methods.length==2 && methodList.contains("canTowBoat()") && methodList.contains("getInfo()"); 
         message("Truck class declares only canTowBoat() and overrides getInfo() : " + t, t);              
      } else { message("Can't find Truck class", false); } 
      
      if (motorcycle != null) {
         boolean t = motorcycle.getSuperclass().getName().equals("Vehicle");
         message("Motorcycle class extends Vehicle: " + t, t);
         
         t = motorcycle.getDeclaredFields().length == 1; 
         message("Motorcycle class declares only an additional PIV (for the towing capacity): " + t, t); 
         
         java.lang.reflect.Method[] methods = motorcycle.getDeclaredMethods();
         String methodList = java.util.Arrays.toString(methods);
         t = methodList.contains("getInfo()"); 
         message("Motorcycle overrides getInfo() : " + t, t);              
      } else { message("Can't find Motorcycle class", false); } 
      
      if (inventory != null) {
         boolean t = inventory.getSuperclass().getName().contains("Object");
         message("Inventory class does not extend a user class (extends only Object by default): " + t, t);
         
         t = inventory.getDeclaredFields().length == 1;
         message("Inventory class declares only 1 PIV (an ArrayList of Vehicles): " + t, t); 
         
         java.lang.reflect.Method[] methods = inventory.getDeclaredMethods();
         String methodList = java.util.Arrays.toString(methods);
         t = methods.length==2 && methodList.contains("addVehicle(Vehicle)") && methodList.contains("listInventory()"); 
         message("Inventory class declares only addVehicle(Vehicle) and listInventory() : " + t, t);              
      } else { message("Can't find Inventory class", false); } 
      
   }    
}