// "static void main" must be defined in a public class.
public class ch5_methods {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //Sorting an array
        //Bubble sort
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        int[] arr = nums;
        //stem.out.println(nums[-1]); ArrayIndexOutOfBoundsException
        
        int a,b,t;
        int size;
        
        //display original array
        System.out.print("Original arrays is: \n");
        for (var item: nums) {
            item = item * 2;
        }
        for (int item: nums) {
            System.out.print(item + " ");
        }
        
        System.out.println();
        //Bubble sort system
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (arr[i] > arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        
        var str1 = new String("Hello");
        var str2 = new String(str1);
        String str3 = str1.substring(1,4);
        str3 = 'H' + str3;
        
        if (str2.equals(str1)) {
            System.out.println("str2 equals str1");
        }
        if (str2 == str1) {
            System.out.println("str2 == str1");
        }
        if (str3.equals(str1)) {
            System.out.println("str3 equals str1");
        }
        if (str3 == str1) {
            System.out.println("str3 == str1");
        }
        str2 = str2.toLowerCase();
        System.out.println(str2);
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.lastIndexOf("l"));
        //var can be used in ability to streamline code, used in FileInputStream class
        
        var var = -128; //different answer from -128L
        var = var >> 1;
        var = var << 1;
        var = var >>> 1;
        System.out.println(var);
        System.out.println();
        
        var newBits = new Bits(142);
        newBits.showBits();
    }
    public static class Bits {
        private int numBits;
        
        public Bits(int num) {
            numBits = num;
        }
        
        public void showBits() {
            for (var i = (Integer.MAX_VALUE / 2) + 1; i > 0; i /= 2) {
                if((numBits & i) > 0) System.out.print("1");
                else System.out.print("0");
        }
        }
    }
}
