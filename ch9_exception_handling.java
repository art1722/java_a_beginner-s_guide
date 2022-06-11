public class ch9_exception_handling {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
        ********ExcTest1********
        exception handler - a block of code - executed automatically when an error occurs without manually check
        class Throwable consists of subclasses; Error(JVM), Exception(standard exception, manually generate exception)
        
        kw: try, catch, throw, throws, finally
        If an exception occurs within the try block, it is thrown (to manually thrown an exception - throw, exception thrown out of a method - throws)
        
        try-catch (ExcepType1 exOb) vs try-with-resources(ch10)
        e.g. method in the try block -> throw exception -> catch
        
        multiple catch
        catching subclass exceptions: to catch all possible exceptions in case abn program terminnation must be avoided; catch Throwable, catch by putting subclass first then superclass
        Try blocks can be nested - to allow different categories of erros to be handled in different ways - normally outer try to catch more severe errors
        
        Throwing an exception
        Rethrowing an exception - inner catch exception can be caught by an outer catch to allow multiple handlers access to the exception
        */
        
        try {
            //ExcTest1.genException(); //if ther's a try in genException itself, this won't cause an exception in main = not forward to catch
        } catch (Throwable exc) {
            System.out.println("    Outer loop: Index out-of-bounds!");
        }
        /*
        ********ExcTest2*******
        Test of throwable methods - printStackTract(), toString()/println()
        using of throws: if a method generates an exception that it doesn't handle, it must declare that exception in a throws clause + except-list(comma separated list of exceptions)
        Exceptions that are subclassees of Error or RuntimeException don't need to be specified in a throws list.
        
        Three additional exception features: automatic resource management by try-with-resources, multi-catch (two or more exceptions to be caught by the same catch clause, each multi-catch parameter is implicitly final can't be assigned a new value), final rethrow or more precise rethrow (subtype or supertype).
        
        Java's Built-in Exceptions
        Java.lang -> RuntimeException (unchecked exceptions (including Error), the compiler doesn't check if a method handles or throws these exceptions), checked exceptions
        
        chained exceptions: Throwable getCause(); Throwable initCause(Throwable causeEXc);
        Creating exception subclasses
        Error can be reported in two ways: return values and exceptions(the latter should be the norm)
        */
        char ch = 'M';
        try {
         ExcTest2.prompt("Enter a letter");
      } catch (ArrayIndexOutOfBoundsException | java.io.IOException exc) {
          System.out.println("I/O exception occured.");
      }
        
       System.out.println("You pressed " + ch);
          
        try {
        ExcTest2.testChecked();
        } catch (NoSuchMethodException exc) {
            System.out.println("Sorry, no such method!");
        }
        
        int[] number = {4,7,8};
        int[] denominator = {2};
        
        for (int i = 0; i < number.length; i++) {
            System.out.println(number.length);
            try {
                if((number[i] % 2) != 0) throw new NonIntResultException(number[i], denominator[0]);
            } catch(NonIntResultException exc) {
                System.out.println(exc);
            }
        }
    }
    
}




class ExcTest1 {
    //To generate an exception
    
   static void genException() {
       //Suprising features: int a = 8/0; -> error // double b = 7.0 /0 -> infinity, not error 
       double[] nums = new double[5];
       int[] divisor = {2, 3, 5, 0, 7, 8, 9};
       double a, b;
       
       for (int i = 0; i < divisor.length; i++) {
        try {
           try {
       System.out.println(i + " Before exception is generated.");
       nums[i] = 7.0 / divisor[i];
        if (i == 2) a = 4/0;
        if (i == 4) b = 7.0/0; 
        if (i == 3) throw new NullPointerException(); //to throw, create an obj, you can't just throw a type
       System.out.println("After exception is generated, not catch yet");
       } catch (ArithmeticException exc) {
           System.out.println("Catch: Can't divide by 0");
            continue;
       } catch (ArrayIndexOutOfBoundsException exc) {
           System.out.println("Catch: No matching element");
       } finally {
            System.out.println(divisor[i]);
            System.out.println(nums[i]);
            System.out.println("...");
        }
       } catch (NullPointerException exc) {
            System.out.println("for outer loop exception");
            //throw exc; to rethrow an exception
            //try -> (if no error matches inner catch) -> inner finally -> outer catch -> outer finally
        }
   }
     /*
     If your program doesn't catch an exception, it will be caughted by JVM's default exception handler, display stack trace, error message
     by handle exception by yourself, program still continue to run. (Once an exception is handled, it is removed from the system.)
     */
      
   }
}



class ExcTest2 {
    static void prompt (String str) throws java.io.IOException { //if there is no throw, Line 42: error: exception IOException is never thrown in body of corresponding try statement [in Main.java]
        throw new java.io.IOException();
    }
    
    public static void testChecked () throws NoSuchMethodException {
        int i = 0;
        int total = 5;

        while (i < total) {
            
        try {
            if (i == 0) {i = total/i;}
            if (i == 1) {int[] a = {2,3,4}; a[2] = a[5];}
            if (i == 2) {Object k = Integer.valueOf(42); String s = (String) k;}
            if (i == 3) {Object obj = null; obj.hashCode();}
            
                    
        } catch (ArithmeticException exc) {
            System.out.println("ArithmeticException " + i);
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("ArrayIndexOutOfBoundsException " + i);
        } catch (ClassCastException exc) {
            System.out.println("ClassCastException" + i);
        } catch (IllegalArgumentException exc) {
            System.out.println("IllegalArgumentException" + i);
        } catch (NullPointerException exc) {
            System.out.println("NullPointerException" + i);
        } catch (Throwable exc) {
            System.out.println("Don't know" + i);
        }
            
        i += 1;
        }
        
    }
}



class NonIntResultException extends Exception {
        int n;
        int d;
        NonIntResultException(int i, int j) {
            n = i;
            d = j;
        }
        public String toString() {
            return "Result of " + n + " / " + d + " is non-integer.";
        }    
    
    }

