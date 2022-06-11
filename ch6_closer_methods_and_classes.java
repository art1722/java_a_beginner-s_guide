// "static void main" must be defined in a public class.
public class ch6_closer_methods_and_classes {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //control access to class members: public vs private
        //helps prevent misuse of the object - black box
        
        //Java access modifiers
        //public private protected(only when inheritance is involved)

        var a = new FailSoftArray(5, -1);
        System.out.println(a.get(0));
        System.out.println(a.get(0,1));
        System.out.println(a.length);

        //Pass objects to methods: call-by-value, call-by-reference
        //Wrapper class: Double, Float, Bye, Short, Integer, Long, Character
        //Overloading
        
        //Recursion
        //Understand static keyword
        
        //mini project: quicksort
        //varags: variable-length arguments
        
    }
}
class FailSoftArray {
    private int[] a;
    private double errval;
    public long length;
    
    static {
        System.out.println("This is static");
    }
    FailSoftArray(int size, double errv) {
        a = new int[size];
        errval = errv;
        length = size;
    }
    
    
    public double get(int index, int ... v) {
        for (int item : v) {
            System.out.println(item);
        }

        if(indexOK(index)) return a[index];
        return errval;
    }
    
    public boolean put(int index, int val) {
        if(indexOK(index)) {
            a[index] = val;
            return true;
        }
        return false;
    }
    private boolean indexOK(int index) {
        if (index >= 0 & index < length) return true;
        return false;
    }
}

class QuickSort {
    
    static void qsort(char[] items) {
        qs(items, 0, items.length - 1);
    }
    
    private static void qs(char[] items, int left, int right) {
        int i, j;
        char x, y;
        
        i = left; j = right;
        x = items[(left + right) / 2];
            
        do {
            while((items[i] < x) && (i < right)) i++;
            while((x < items[j]) && (j > left)) j--;
            
            if(i <= j){
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
                }
            
        } while(i <= j);
        
        if(left < j) qs(items, left, j);
        if(i < right) qs(items, i, right);
    }
}