// "static void main" must be defined in a public class.
public class ch7_inheritance {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        /*
        Inheritance, superclass, subclass -> does not overrule the private access
        buy you can use accessor methods to provide access to the private members
        keyword: extends
        
        constructors and inheritance
        super - immediate superclass
        super.member(method/instance variable)
        
        creating a multilevel hierarchy
        when are constructors executed - superclass to subclass
        
        superclass references and subclass objects
        method overriding - subclass must have same return type, same signature, as super class - can still use super.method() - this support polymorphism, dynamic method dispatch - the type of the object being referred to that determines which version of an overridden method will be executed "one interface, multiple methods"
            if not the same signature - method overload
            
        using abstract class - a superclass that defines only a generalized form that will be shared by all of its subclasses\
        
        using final - prevent overriding and inheritance - can also be inherited by subclasses and accessed directly inside those subclasses, can use static kw
        */
        
        Triangle t1 = new Triangle(4.0, 4.0, "filled");
        Triangle t2 = new Triangle(5);
        //TwoDShape t3 = new TwoDShape(6, 7);
        //t3 = t2;
        
        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());
        
        t1.setWidth(4.0);
        t1.height = 4.0;
        t1.style = "filled";
        
        t2.setWidth(4.0);
        t2.height = 12.0;
        t2.style = "outlined";
        
        System.out.println();
        
        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());
        
        System.out.println();
        
        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());
        
        System.out.println();
        
        System.out.println("Info for t3: ");
        //t3.showStyle(); doesn't work cause t3 don't know t2 methods
        //t3.showDim();
        //System.out.println("Area is " + t3.area());
        
        System.out.println();
        
        Triangle t4 = t2;
        t4.showStyle();
        t4.showDim();
        System.out.println("Area is " + t4.area());

    }
}

abstract class TwoDShape { //a class that contains one or mor abstract methods must also be declared as abstract, try to create an object of abstract class by using new will result in a compile-time error.
    //  for abstract class - create an object referece to is possible, declare obj of abstract class is no longer possible
    private double width;
    double height;
    
    TwoDShape() {
        width = height = 0.0;
    }
    
    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }
    
    TwoDShape(TwoDShape ob) {
        width = ob.width;
        height = ob.height;
    }
    
    final void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }
    
    double getWidth() {return width; }
    void setWidth(double w) { width = w; }
    
    /*
    double area() {
        System.out.println("area() must be overridden");
        return 0.0;
    }
    */
    
    abstract double area();
    
    //abstract type name(parameter-list);
}
    
class Triangle extends TwoDShape {
    String style;
    
    Triangle() {
        super();
        style = "none";
    }
    
    Triangle(double height) {
        super();
        super.height = height;
        style = "none";
    }
    
    Triangle(double w, double h, String s) {
        //setWidth(w);
        //height = h;
        
        super(w, h);
        style = s;
    }
    
    Triangle(Triangle ob) {
        super(ob); //a superclass reference can refer to a subclass object
        style = ob.style;
    }
    
    double area() {
        return getWidth() * super.height / 2;
    }
    
    void showStyle() {
        System.out.println("Triangle is " + style);
    }
    
}