import java.io.IOException; //in order to use throws clause
//1this would not work in vscode's terminal but will work in terminal itself
/*
modified Help.java
*/
// "static void main" must be defined in a public class.
public class ch3_program_control {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        System.out.println("Help on \n1. if \n2. switch \nChoose one");
        
        //input = 2
        //int console1 = System.in.read(); //print 50 because 2 is 50 in ascii table
        char console2 = (char) System.in.read();
        //System.out.println(console1);
        System.out.println(console2); //print 2
        
        char console3;
        do {
            console3 = (char) System.in.read();
        } while(console3 != '\n');
        //System.out.println(console.getClass());
        
        switch(console2) {
            case '1':
                System.out.println("The if: \n");
                System.out.println("if(condition) statement;");
                System.out.println("else statement;");
                break;
            case '2':
                System.out.println("The traditional switch: \n");
                System.out.println("switch(expression) {");
                System.out.println("    case constant:");
                System.out.println("        statement sequence");
                System.out.println("        break;");
                System.out.println("    // ...");
                System.out.println("}");
                break;
            default:
                System.out.println("Selection not found.");
                
        }
        
        for (int i = 2, dead = 5;;) {
            one: {
                System.out.println(i);
                i += 4;
                if (i == 8) break one;
                System.out.println("Almost boom");
                if (i % 3 != 0) continue;
                i -= 3;
                System.out.println("BOOM BOOM BOOM BOOM BOOM");
                dead -= 1;
            }
            if (i > 100 ^ dead == 0) break;
        }
        
    }
}