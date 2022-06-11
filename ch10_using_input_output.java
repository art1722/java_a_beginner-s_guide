// "static void main" must be defined in a public class.
import java.io.*;

public class ch10_using_input_output {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
        Java's I/O system: byte I/O, character I/O -> two separate set of class hierachies
        Java programs perform I/O through streams (an abstraction that either produces or consumes information)
        All stream behave in the same manner, thus the same I/O classes and methods can be applied to different types of devices.
        
        Byte streams -> InputStream, OutputStream -> many subclasses, many methods (e.g. input - read, output - close/flush/write)
        Character streams -> Reader, Writer
        The predefined streams
        --------java.lang pck -> System class (run time env) - stream variables: in(InputStream), out(PrintStream, as a byte stream), err(PrintStream) - IOException --------
        Using the byte streams
        
        Reading console input: int read(), (byte[] data), (byte[] data, int start, int max) throws IOException
        Writing console output: voide write(int byteval)
        
        Inputting from a file: 
            Constructor: FileInputStream(String File) throws FileNotFoundException, 
            int read() throws IOException, 
            void close() throws IOException
        Writing to a file: 
            Constructor: FileOutputStream(String fileName)/(String fileName, boolean append) throws FileNotFoundException, 
            void write(int byteval) thows IOException, 
            void close() throws IOException -> automatically closing a file by automatic resource management (try-with-resources, try(resource-specification to declare and initializes a resource such as a file), can be used only with those resources that implement the AutoCloseable interface defined by java.lang, associated with getSuppressed() defined by Throwable)
        
        Reading and writing binary data: (ints doubles shorts, other binary val of Java primitve types)
            All IOException
            DataInput interface (read method)-> DataInputStream(InputStream // IOException
            InputStream) readInt()
            DataOutputStream(InputStream InputStream e.g. FileInputStream) (write method) writeInt(int val) 
        
        Randomaccessfile (Difference from sequential files, one byte after another.)
            DataInput, DataOutput interface ->
            supports positioning requests
            RandomAccessFile(String fileName, String access) throws FileNotFoundException
                access - r, rw, rws, rwd
            void seek(long newPos) throws IOException
            
        Using Java's character based streams // IOException
        System.in is an InputStream [byte] -----> InputStreamReader(InputStream inputStream e.g. System.in, Charset charset e.g. System.console().charset() if console is presented) -----> BufferredReader(Reader inputReader) [char]
            int read() -1 when at the end of the stream, (char[] data), (char[] dat, int start, int max)
            String readLine()0
        Console Output using character streams for real world application
            PrintWriter(OutputStream outputStream, boolean flushingOn): print() println() -- primitive -> text formatted
        File I/O Using character streams -- FileNotFoundException
            FileReader(Stirng fileName) -- creates a Reader
            FileWriter(String fileName, boolean append) -- creates a Writer
        
        Java's type wrapper
            parseX(String str) -> turn str into X type -- can cause NumberFormatException
            equals(), compareTo()
            
            java.util.Scanner
            Scanner(InputStream from)
                hasNextX methods
                nextX methods - if input is already available, then read it with this method, convert the human-readable form of the data into its internal, binary representation and return the result
                InputMismatchException
        */
    try {
    ReadBytes.ReadBytesMethod();
    } catch(IOException exc) {
      System.out.println("no");  
    }
    
    int b = 'X';
    System.out.println(b);
    System.out.write(88);
    System.out.write(b);
    System.out.write('\n');
    }
}
class ReadBytes {
    public static void ReadBytesMethod() throws IOException {
        byte[] data = new byte[10];
        
        System.out.println("Enter some characters.");
        System.in.read(data); //read bytes
        for(var d: data) {
            System.out.print((char) d);
            System.out.print("-");
        }
        System.out.println();
    }
 }