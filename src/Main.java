import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Math.*;

public class Main
{
    //Завдання 1
    class Person
    {
        int age;
        String name;
        String healthInfo;
        public Person(int age, String name, String healthInfo)
        {
            this.age= age;
            this.name = name;
            this.healthInfo = healthInfo;
        }
        public String getHealthStatus()
        {
            return name + " " + healthInfo;
        }
    }

    class Child extends Person
    {
        String childIDNumber;

        public Child(int age, String name, String healthInfo,String childIDNumber)
        {
            super(age, name, healthInfo);
            this.childIDNumber  = childIDNumber;
        }
    }

    class Adult extends Person
    {
        String passportNumber;
        public Adult(int age, String name, String healthInfo, String passportNumber)
        {
            super(age, name, healthInfo);
            this.passportNumber = passportNumber;
        }
    }

    //Завдання 2
    /*{
        abstract class Figure
        {
            abstract double getPerimeter();
        }

        class Rectang extends Figure
        {
            double width;
            double height;
            public Rectang(double height, double width)
            {
                this.width = width;
                this.height = height;
            }
            public double getPerimeter()
            {
                return ((height + width) * 2);
            }
        }
        class Square extends Figure
        {
            double width;
            public Square(double width)
            {
                this.width = width;
            }
            public double getPerimeter()
            {
                return (width * 4);
            }
        }
        public class MyUtils
        {
            public double sumPerimeter(List<Figure> firures)
            {
                double perimeters = 0;

                for (Figure f: firures){
                    if (f == null){
                        continue;
                    }
                    perimeters+=f.getPerimeter();

                }
                return perimeters;
            }
        }

    }*/

    //Завдання 3
    abstract class Shape
    {
        private String name;
        abstract double getArea();
        public double getRadius()
        {
            return 0;
        }
        public double getHeight()
        {
            return 0;
        }
        public double getWidth()
        {
            return 0;
        }
        public String getName()
        {
            return name;
        }
        public Shape(String name)
        {
            this.name = name;
        }
    }

    public class Circle extends Shape
    {
        private double radius;
        public Circle(String name, double radius)
        {
            super(name);
            this.radius = radius;
        }
        public double getRadius()
        {
            return radius;
        }
        public double getArea()
        {
            return Math.PI * Math.pow(radius,2);
        }
    }

    public class Rectangle extends Shape
    {
        private double width;
        private double height;
        public Rectangle(String name ,double height, double width)
        {
            super(name);
            this.width = width;
            this.height = height;
        }
        public double getHeight()
        {
            return height;
        }
        public double getWidth()
        {
            return width;
        }
        public double getArea()
        {
            return width * height;
        }
    }

    public class MyUtils
    {
        public List<Shape> maxAreas(List<Shape> firures)
        {
            if (firures.isEmpty())
            {
                return firures;
            }
            List<Shape> newfirures = new ArrayList<>(firures);
            for(int i=0; i < newfirures.size(); i++)
            {
                for(int j=1; j < (newfirures.size()-i); j++)
                {
                    if(newfirures.get(j-1).getArea() < newfirures.get(j).getArea())
                    {
                        Collections.swap(newfirures,(j-1),j);
                    }

                }
            }
            if (firures.size() == 1)
            {
                return newfirures;
            }
            else
            {
                List<Shape> tempc = new ArrayList<>(newfirures);
                List<Shape> tempr = new ArrayList<>(newfirures);
                int a = 0, b = 0;
                for (int i=0; i < 2; i++)
                {
                    if (newfirures.get(i).getName() == "Circle")
                    {
                        for (int j=0; j < newfirures.size(); j++)
                        {
                            if (newfirures.get(j).getName() == "Circle")
                            {
                                if (a == 0)
                                {
                                    tempc.set(0, newfirures.get(j));
                                    a++;
                                }
                                if (tempc.get(0).getArea() > newfirures.get(j).getArea())
                                {
                                    newfirures.remove(j);
                                }
                            }
                        }
                    }
                    if (newfirures.get(i).getName() != "Circle")
                    {
                        for (int j=0; j < newfirures.size(); j++)
                        {
                            if (newfirures.get(j).getName() != "Circle")
                            {
                                if (b == 0)
                                {
                                    tempr.set(0, newfirures.get(j));
                                    b++;
                                }
                                if (tempr.get(0).getArea() > newfirures.get(j).getArea())
                                {
                                    newfirures.remove(j);
                                }
                            }
                        }
                    }
                }
                return newfirures;
            }
        }
    }

    public static void main(String[] args)
    {
        Circle cir = new Circle("Circle",2);
        /*Circle cir1 = new Circle("Circle",1);
        Circle cir2 = new Circle("Circle",0.5);*/
        Rectangle rec = new Rectangle("Rectangle",2,3);
        Rectangle rec1 = new Rectangle("Rectangle",3,2);
        Rectangle rec2 = new Rectangle("Rectangle",1,2);
        List<Shape> list1 = new ArrayList<Shape>();
        list1.add(rec);
        list1.add(rec1);
        list1.add(rec2);
        list1.add(cir);
        /*list1.add(cir1);
        list1.add(cir2);*/
        MyUtils a = new MyUtils();
        List<Shape> list2 = new ArrayList<Shape>();
        list2 = a.maxAreas(list1);
        for (Shape b: list2)
        {
            System.out.println(b.getName()+"\t"+b.getArea()+"\t"+b.getRadius()+"\t"+b.getHeight()+"\t"+b.getWidth());
        }
    }
}