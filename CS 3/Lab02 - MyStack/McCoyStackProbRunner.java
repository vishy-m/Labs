import java.util.*;
import static java.lang.System.*;
import java.lang.reflect.Method;

public class McCoyStackProbRunner {

   public static void main (String[] args) {
   
      StackProbs sp = new StackProbs();      
      out.println(runMethod(sp, "doubleUp", new Object[] {makeStack(new int[] {1, 3, 5, 0, -1})}, "[1, 1, 3, 3, 5, 5, 0, 0, -1, -1]")+"\n");
      out.println(runMethod(sp, "doubleUp", new Object[] {makeStack(new int[] {1, 0, -9})}, "[1, 1, 0, 0, -9, -9]")+"\n");
      
      out.println(runMethod(sp, "posAndNeg", new Object[] {makeStack(new int[] {2, 9, -4, 3, -1, 0, -6})}, "[-6, -1, -4, 2, 9, 3, 0] (order may be different, but all negatives on left)")+"\n");
      out.println(runMethod(sp, "posAndNeg", new Object[] {makeStack(new int[] {1, 0, -9})}, "[-9, 1, 0] (order may be different, but all negatives on left)")+"\n");
      
      out.println(runMethod(sp, "shiftByN", new Object[] {makeStack(new int[] {7, 23, -7, 0, 22, -8, 4, 5}), 3}, "[0, 22, -8, 4, 5, 7, 23, -7]")+"\n");
      out.println(runMethod(sp, "shiftByN", new Object[] {makeStack(new int[] {1, 2, 3, 4}), 2}, "[3, 4, 1, 2]")+"\n");      
      
      out.println(runMethod(sp, "reverseVowels", new Object[] {"hello how are you"}, "hullo hew aro yoe")+"\n");
      out.println(runMethod(sp, "reverseVowels", new Object[] {"salsa is the best"}, "selse is tha bast")+"\n");
   
      out.println(runMethod(sp, "bracketBalance", new Object[] {"([()[]()])()"}, "true")+"\n");      
      out.println(runMethod(sp, "bracketBalance", new Object[] {"(([()])))"}, "false")+"\n");      
      out.println(runMethod(sp, "bracketBalance", new Object[] {"[()[]()[]()]"}, "true")+"\n");      
            
   }
      
   
   public static Stack<Integer> makeStack(int[] nums) {
      Stack<Integer> stack = new Stack<>();
      for (int num : nums)
         stack.push(num);
      return stack;
   }

   public static Object runMethod(Object o, String name, Object[] args, String expOut) {
      //runMethod (object containing method, method name, array of method parameters, expected output)      
      //runMethod will return whatever the invoked method returns
   
      try { 
         Class[] argTypes = new Class[args.length];
         for (int i = 0; i < args.length; i++) {
            argTypes[i] = fixPrimitive(args[i].getClass());
         }
      
         Method m = o.getClass().getMethod(name, argTypes);                 
         Object ret = null;
         if (m != null) 
            out.println(">>CALLING " + name + "(" + getParam(args) + ")\nEXPECTED OUTPUT: \n" + expOut + "\nACTUAL OUTPUT: ");
         ret = m.invoke(o, args);
         if (ret == null) 
            return "";
         if (ret.getClass().isArray()) 
            return arrayAsString(ret);           
         return ret;
         
      } catch (Exception e) {
         out.println("Error of some kind"); 
      }
      return "";          
   }
   
   public static Class<?> fixPrimitive(Class c) {
      if (c == Byte.class) 
         return byte.class;
      if (c == Short.class) 
         return short.class;
      if (c == Integer.class) 
         return int.class;
      if (c == Long.class) 
         return long.class;
      if (c == Float.class) 
         return float.class;
      if (c == Double.class) 
         return double.class;
      if (c == Boolean.class) 
         return boolean.class;
      if (c == Character.class) 
         return char.class;
      return c;         
   }
   
   public static String arrayAsString(Object o) {
      if (o instanceof byte[]) 
         return Arrays.toString((byte[])o);
      if (o instanceof short[]) 
         return Arrays.toString((short[])o);
      if (o instanceof int[]) 
         return Arrays.toString((int[])o);
      if (o instanceof long[]) 
         return Arrays.toString((long[])o);
      if (o instanceof float[]) 
         return Arrays.toString((float[])o);
      if (o instanceof double[]) 
         return Arrays.toString((double[])o);
      if (o instanceof boolean[]) 
         return Arrays.toString((boolean[])o);
      if (o instanceof char[]) 
         return Arrays.toString((char[])o);      
      return Arrays.toString((Object[])o);   
   }
   
   public static String getParam(Object[] params) {
      String ret = "";
      for (Object o : params) {
         if (ret.length() > 0) ret += ", ";
         if (o instanceof String) ret += "\"" + o + "\"";
         else if (o.getClass().isArray()) ret += arrayAsString(o);
         else ret += o;
      }
      return ret;         
   }



}