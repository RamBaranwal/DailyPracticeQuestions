# Java Static vs Non-Static Master Guide

# Part 6–10 (Static Classes, Famous Test Example, Memory, JVM, Inheritance)

---

# Part 6: Static Classes

# 49. Nested Classes

A class defined inside another class is called a nested class.

Example:

```java
class Outer {

    class Inner {

    }
}
```

Relationship:

```text
Outer
 |
 └── Inner
```

Nested classes help logically group classes that are only used by the outer class.

---

# 50. Static Nested Classes

A nested class can be declared static.

```java
class Outer {

    static class Inner {

    }
}
```

Now `Inner` belongs to the class `Outer`, not to an object of `Outer`.

---

## Creating Objects

```java
Outer.Inner obj = new Outer.Inner();
```

No Outer object required.

---

# Why?

Because:

```java
static class Inner
```

means:

> Inner is associated with the Outer class itself.

Not with any Outer object.

---

# 51. Inner Classes

A non-static nested class is called an Inner Class.

```java
class Outer {

    class Inner {

    }
}
```

Creating object:

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
```

---

# Why Outer Object Required?

Because an inner class is attached to a specific Outer object.

---

# 52. Static Nested Class vs Inner Class

| Feature                                | Static Nested Class | Inner Class  |
| -------------------------------------- | ------------------- | ------------ |
| Needs Outer Object                     | No                  | Yes          |
| Belongs To                             | Outer Class         | Outer Object |
| Access Outer Instance Members Directly | No                  | Yes          |
| Access Outer Static Members            | Yes                 | Yes          |

---

# 53. Why Static Nested Classes Exist

Suppose:

```java
class Car {

    static class Engine {

    }
}
```

An Engine conceptually belongs to Car.

But an Engine object does not need a specific Car object to exist.

Static nested classes solve this problem.

---

# 54. Why Static Nested Classes Can Have Multiple Objects

Most beginners think:

```java
static class Test
```

means:

```text
Only one Test object exists
```

Wrong.

Example:

```java
static class Test {

    String name;
}
```

```java
Test a = new Test();
Test b = new Test();
Test c = new Test();
```

Memory:

```text
a --> Object1

b --> Object2

c --> Object3
```

Three separate objects.

---

# 55. Why Static Class Does Not Mean Singleton

Singleton:

```text
Exactly one object
```

Static nested class:

```text
Unlimited objects
```

Example:

```java
Test a = new Test();
Test b = new Test();
```

Perfectly valid.

---

# 56. Access Rules of Static Nested Classes

```java
class Outer {

    static int x = 10;

    static class Inner {

        void show() {
            System.out.println(x);
        }
    }
}
```

Allowed.

---

# 57. Outer Class Access Rules

```java
class Outer {

    int y = 20;

    static class Inner {

        void show() {
            System.out.println(y);
        }
    }
}
```

Error.

Reason:

```text
No Outer object exists.
```

Need:

```java
Outer o = new Outer();
System.out.println(o.y);
```

---

# 58. Memory Model of Static Nested Classes

```java
class Outer {

    static class Inner {

    }
}
```

Memory:

```text
Method Area

Outer Class
|
|-- Inner Class Metadata
```

Creating objects:

```java
Outer.Inner a = new Outer.Inner();
```

Object goes into Heap.

---

# Part 7: The Famous Test Example

# 59. Understanding

```java
static class Test {

}
```

This means:

```text
Test belongs to Outer class.
```

NOT:

```text
Only one Test object exists.
```

---

# 60. Why This Works

```java
Test a = new Test();
```

Suppose:

```java
class Outer {

    static class Test {

    }

    public static void main(String[] args) {

        Test a = new Test();
    }
}
```

Why?

Because inside Outer:

```java
Test
```

automatically means:

```java
Outer.Test
```

Java already knows which Test you mean.

---

# 61. Why This Is Required Outside

Outside the class:

```java
Outer.Test obj = new Outer.Test();
```

Required because Java must know:

```text
Which Test?
```

There may be many classes named Test.

---

# 62. Memory Diagram of Multiple Test Objects

```java
Test a = new Test("Kunal");
Test b = new Test("Rahul");
```

Memory:

```text
Stack

a ----------+
            |
b ----------+
            |
            v

Heap

Object1
|
|-- name = Kunal

Object2
|
|-- name = Rahul
```

Separate objects.

---

# Part 8: Static and Memory

# 63. Stack Memory

Stores:

```text
Local Variables
Method Calls
References
```

Example:

```java
Test t = new Test();
```

Reference:

```text
t
```

stored in stack.

---

# 64. Heap Memory

Stores:

```text
Objects
Arrays
```

Example:

```java
new Test()
```

Heap allocation.

---

# 65. Method Area / Metaspace

Stores:

```text
Class Metadata
Static Variables
Class Information
Method Information
```

---

# 66. Where Static Variables Live

```java
class Test {

    static int x = 10;
}
```

Memory:

```text
Method Area

Test
|
|-- x
```

---

# 67. Where Objects Live

```java
Test t = new Test();
```

Memory:

```text
Heap
|
|-- Test Object
```

---

# 68. Where References Live

```java
Test t = new Test();
```

Reference:

```text
Stack
|
|-- t
```

---

# 69. Memory Diagram for Static Members

```java
class Test {

    static int x = 10;
}
```

```text
Method Area

Test Class
|
|-- x = 10
```

Only one copy.

---

# 70. Memory Diagram for Non-Static Members

```java
class Test {

    int y = 20;
}
```

```java
Test a = new Test();
Test b = new Test();
```

Memory:

```text
Heap

Object A
|
|-- y = 20

Object B
|
|-- y = 20
```

Two copies.

---

# Part 9: Static and JVM

# 71. Class Loading

Before Java uses a class:

```java
Test.x
```

JVM loads the class.

---

# 72. Linking

After loading:

```text
Verification
Preparation
Resolution
```

occur.

---

# 73. Initialization

Now:

```text
Static Variables Initialized
Static Blocks Execute
```

---

# 74. Class Loader

Responsible for loading classes into memory.

Example:

```text
java.lang.String
Student
Human
```

All loaded by class loaders.

---

# 75. Static Initialization

Example:

```java
static int x = 10;

static {
    x = 20;
}
```

Occurs during class initialization.

---

# 76. JVM Startup Sequence

Simplified:

```text
JVM Starts
|
Load Main Class
|
Initialize Static Members
|
Execute main()
```

---

# 77. Why main() Must Be Static

JVM must call:

```java
public static void main(String[] args)
```

before any object exists.

If main were non-static:

```java
public void main(String[] args)
```

JVM would need an object.

But:

```text
No object exists yet.
```

Therefore:

```java
main()
```

must be static.

---

# Part 10: Static and Inheritance

# 78. Inheritance of Static Variables

```java
class Parent {

    static int x = 10;
}

class Child extends Parent {
}
```

Access:

```java
System.out.println(Child.x);
```

Output:

```text
10
```

Inherited.

---

# 79. Inheritance of Static Methods

```java
class Parent {

    static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
}
```

```java
Child.show();
```

Output:

```text
Parent
```

---

# 80. Method Hiding

```java
class Parent {

    static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void show() {
        System.out.println("Child");
    }
}
```

This is:

```text
Method Hiding
```

Not overriding.

---

# 81. Parent Reference Child Object

```java
Parent p = new Child();
```

Important interview topic.

---

## Static Method

```java
p.show();
```

Output:

```text
Parent
```

Reference type decides.

---

## Instance Method

```java
p.display();
```

Output:

```text
Child
```

Object type decides.

---

# 82. Static Binding

Static methods use:

```text
Compile-Time Binding
```

Compiler decides method call.

---

Example:

```java
Parent p = new Child();

p.show();
```

Compiler sees:

```text
Parent Reference
```

Output:

```text
Parent
```

---

# 83. Runtime Polymorphism vs Compile-Time Binding

## Instance Methods

```text
Runtime Polymorphism
```

Decision:

```text
Runtime
```

---

## Static Methods

```text
Compile-Time Binding
```

Decision:

```text
Compile Time
```

---

# Quick Interview Summary

## Static Variables

* One copy
* Shared
* Stored in Method Area

## Instance Variables

* One copy per object
* Stored in Heap

## Static Methods

* Belong to class
* Cannot directly access instance members
* Hidden, not overridden

## Static Blocks

* Execute once
* Run during class initialization

## Static Nested Classes

* No outer object required
* Can create unlimited objects

## main()

* Must be static because JVM calls it before any object exists

---

# End of Part 6–10

Next Parts:

* Part 11: Static Utility Methods
* Part 12: Advanced Topics (Singleton, Factory Methods, Synchronization)
* Part 13: Common Mistakes
* Part 14: Top Interview Questions
* Part 15: Complete Revision & Cheat Sheet
