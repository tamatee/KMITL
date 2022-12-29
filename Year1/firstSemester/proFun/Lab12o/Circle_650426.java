package proFun.Lab12o;

public class Circle_650426 {
    public static void main(String[] args) {
        Circle c4 = new Circle(4.0);
        System.out.println(c4.getArea());
    }
}

class Circle {
    double radius;
    Circle() {
        this.radius = 1.0;
    }

    Circle(double radius) 
    {
        this.radius = radius;
    }

    double getRadius() 
    {
        return radius;
    }

    void setRadius(double radius) 
    {
        this.radius = radius;
    }

    double getArea() 
    {
        return Math.PI * radius * radius;
    }

    double getCircumference()
    {
        return radius * 2 * Math.PI;
    }

    public String toString() 
    {
        return "Circle([radius=" + radius + "]";
    }
}
