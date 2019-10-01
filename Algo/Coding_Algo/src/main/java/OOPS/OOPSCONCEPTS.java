package OOPS;

/**
 * https://www.youtube.com/watch?v=7WhnYwoBY24&list=PLlhM4lkb2sEhf5NlWeYh_gdcN49pHjVP0&index=1
 */
public class OOPSCONCEPTS {
  /*
      1. Objects is an instance of class
      2. Objects is real world entity
      3. Objects occupy memory

      Objects consists of :-
      1. Identity name
      2. State/Attribute color, breed, age,
      3. Behavior:- eat run

       ------------
      How to create an object :-

      1: Using new keyword
      2: Using newInstance() method.
      3: clone() method
      4: deseralization
      5: factory methods

      ------------
     Object instantiation : When we use new keyowrd thenthe memoey allocation happened

     Object initalization : Three ways
     1. By reference
     2. By constructor
     3. By Method

     class Animal {

      String color;
      String age;

      public static void main (String [] args) {
      Animal animal = new Animal();
      animal.color = "Red";
      animal.age = "23";

      ------------

      Constructor:
      1. No return type not even void.
      2. Constructor modifier public, private,protected,default
      3. Same name as class name.
      4. Constructor is used to initalize the object.
      --------------------------------------------------

      Inheriantce : IS A relationship. In java it is achived by using extends clause
      Having parent child relatonship


      1. Dog is a Bird.
      2. Sparrow is a bird.
      3. Car is vechicle.
      4. Surgeon is a doctor.

      Advantage of inheritance :

      1. Code reusable.
      2. Through inheritance we can achive polymorphism. Method overriding.

      Disadvantage of inheritance:
      1. Tightly coupled.

      Total type of inheritance in Java

      1. Single inheritance
      A->B

      2. Multi level inheritance.
      A->B->C

      3. Hierarchical
        A
      B   C

      Note : In Java you don't have multiple inheritance or hybrid inheritance
      Because of two classes have same property

      A --> show()
      B --> show()

      Not have multiple inheritance if C extends both class then compiler get confused
      which show() method get called.

      Diamond problem
      ------------
     }
    }
    ------------------------------------------------------------------------------------

    Relation ship between two classes two types
    a) Inheritance --> Is A
    b) Association  ->> Has A
       Associationhas two forms: Aggregation and Composition

    1. Inheritance relation ship --> IS A
    2. Association ---> HAS-A
    3. Aggregation
    4. Compostion

    Advantage of relationship :
    a) Code reusability
    b) Cost cutting
    3) Reduce reduanacy

    Association :

    Example 1:

    class Student {
      String name;
      String roll_no;
    }

    Student HAS-A name
    Student HAS-A roll no.

    Example 2. Association through new by creating object

    class Vehicle {

    }

    class car {
      Engine engine = new Engine();
    }

    CAR HAS-A Engine.


    Assoication has two forms : Aggregation and Composition
    1. Aggregation : Weak bonding

       CAR HAS A Music Player.

       a) Weak bonding
       b) Car can be without music player. Own line line
       c) Music player can be without car. Own life line

    2. Composition : Strong bonding

       Car HAS A engine

       1. Both the classes have strong bonding.
       2. Both needs each other.
       3. Car can not be without engine.
       4. Engine without car.
       5. Both have the same life time.

     Example :
     College
     Professor
     Branches

     Relationship between College and professor is Weak bonding (Aggregation)
     Relationship between college and branches is Strong bonding (Strong Composition)

    ------------------------------------------------------------------------------------
    Polymorphism :- Many forms

    -> Water --> Solid, Liquid, Gas
    -> Shapes --> Circle, Rectangle,
    --> Sound --> bark, roar

    Types : There are two types of polymorphism
    1) Compile time polymorphism (Static Polymorphism) Handled by compiler
       Method Overloading (Achieve)

    2) Run time Polymorphism (Dynamic Polymorphism) HAndled by JVM
       Method Overriding

      Difference between Method Overloading and method overriding.

      Method Overloading :
      1. Same name
      2. Same class
      3. Different arguments (No of arguments, Sequence of argument, Type of arguments)

      Method Overriding :
      1. Same name
      2. Different Class
      3. Same arguments (No of arguments, Seq of arguments, Type of tags)
      4. Between two classes. Inheritance IS A relation ship

      Method overloading can not be achived just because of just changing the return type.
     ------------------------------------------------------------------------------------
      Automatic conversion
      byte --> Short ---> Int--->Long--->Float--->Double
      char-->int-->Long--->Float-->Double


      Question 1. Do overriding method must have same return type or sub type.
      Answer: From java 5.0 onwards it is possible to have different return type for a overriding
      method in child class but child's return type should be sub type of parents return type.
      The phenomena is known as Co-Variant return types.

      Question 2: The access modifier for an overriding method can allow more but not less access than the
      overidden method. For example a protected instance method in the super-class can be made public
      but not private in the subclass. Doing so will generate compil;e-time error.

      Child modifier should be greater then as compare to parents.

     Q3 : Final methods can not be overriden. If we don't want a method to be overriden, We declare it as final.

     Q4. Static methods can not be overriden.
     (Method Overriding VS Method Hiding)
     When you defines a static method with same signature as a static method in base class.
     It is called method hiding.

     Q4 Private methods can not be Overidden
     Privates methods cannot be overriden as they are bounded during
     compile time. Therefor we can't even override private methods in a subclass.

    Q5: The presence of synchronized/strictfp modifier with method have no effect on the rules of
    overriding i.e it's possible that a synchronozed/strictfp one and vice versa.
      ------------------------------------------------------------------------------------
     1. Abstracition
     2. Data hiding
     3. Encapsulation.
     4. Tightly coupled classes

     Abstraction :
     1. Abstraction is details hiding (implementation)
     2. Data abstraction deals with exposing the interface to the user and hiding the
        details of the implementation.

     1. In Java abstraction can be achived through interface and abstract class

       Abstract class to achived abstraction hiding implementation (can be achived 0 to 100% abstraction)
       1.

       Interface class to achived abstraction hidng implementation (100% abstraction)
       1. It is used to achived abstraction.
       2. It




     Encapsulation :
     1. Encapsulation is data hiding (information hiding)
     2. Encapsulation groups together data and methoids that act upon the data




   */
}
