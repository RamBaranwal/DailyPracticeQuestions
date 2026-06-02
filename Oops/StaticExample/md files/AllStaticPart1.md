# Java Static vs Non-Static Master Guide

# Part 1–5 (Foundations, Variables, Methods, Static Blocks, Constructors)

---

# Part 1: Foundations

# 1. What is Static?

In Java, `static` means:

> The member belongs to the class itself rather than to any individual object.

When a member is declared static, Java creates only one copy of that member regardless of how many objects are created.

Example:

```java
class Student {
    static String college = "ABC College";
}
```

Memory:

```text
Student Class
|
|-- college = "ABC College"
```

Even if 1000 Student objects are created:

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
```

There is still only one copy of:

```java
college
```

shared by all objects.

---

## Why Static Exists

Imagine storing the name of a college.

```java
class Student {
    String name;
    String college;
}
```

Every student belongs to the same college.

Creating a separate copy of college for every object wastes memory.

Instead:

```java
class Student {
    String name;
    static String college = "ABC College";
}
```

Now only one copy exists.

This saves memory.

---

# 2. What is Non-Static?

Non-static means:

> The member belongs to an individual object.

Each object gets its own copy.

Example:

```java
class Student {
    String name;
}
```

```java
Student s1 = new Student();
Student s2 = new Student();
```

Memory:

```text
s1 --> [name]
s2 --> [name]
```

Separate copies.

---

## Why Non-Static Exists

Every student has a different name.

```java
s1.name = "Kunal";
s2.name = "Rahul";
```

Memory:

```text
s1 --> [name = Kunal]

s2 --> [name = Rahul]
```

Sharing would not make sense.

---

# 3. Class Members vs Object Members

## Class Members

Belong to the class.

```java
static int count;
static void fun(){}
static class Test{}
```

Access:

```java
ClassName.count;
ClassName.fun();
```

---

## Object Members

Belong to objects.

```java
int age;
void greet(){}
```

Access:

```java
obj.age;
obj.greet();
```

---

# 4. Memory Overview

Java memory can be simplified into:

```text
JVM Memory

|
|-- Method Area / Metaspace
|
|-- Heap
|
|-- Stack
```

---

## Method Area

Stores:

```text
Class Information
Static Variables
Static Methods Metadata
```

---

## Heap

Stores:

```text
Objects
Arrays
```

---

## Stack

Stores:

```text
Method Calls
Reference Variables
Local Variables
```

Example:

```java
Student s = new Student();
```

Memory:

```text
Stack
|
|-- s

Heap
|
|-- Student Object
```

---

# 5. Why Java Introduced Static

Three major reasons:

## Memory Saving

Instead of storing common data repeatedly.

Example:

```java
static String college;
```

---

## Utility Methods

Example:

```java
Math.sqrt(25);
Arrays.sort(arr);
Collections.sort(list);
```

No object needed.

---

## Shared State

Example:

```java
class Human {

    static int population;
}
```

Every object contributes to the same population.

---

# Part 2: Static Variables

# 6. Static Variables

A static variable belongs to the class.

Example:

```java
class Human {

    static int population = 0;
}
```

Only one copy exists.

---

# 7. Instance Variables

Instance variables belong to objects.

```java
class Human {

    String name;
}
```

Every object gets a separate copy.

---

# 8. Memory Representation

```java
class Human {

    static int population;

    String name;
}
```

Memory:

```text
Method Area

Human Class
|
|-- population

Heap

Object1
|
|-- name

Object2
|
|-- name
```

---

# 9. Shared Nature of Static Variables

```java
class Human {

    static int population;
}
```

```java
Human h1 = new Human();
Human h2 = new Human();

h1.population = 10;
```

Now:

```java
System.out.println(h2.population);
```

Output:

```text
10
```

Because both refer to the same variable.

---

# 10. Accessing Static Variables

Preferred:

```java
Human.population
```

Not:

```java
h1.population
```

---

# Why?

Because population belongs to the class.

---

# 11. Accessing Static Variables Through Objects

Allowed:

```java
Human h = new Human();

System.out.println(h.population);
```

But bad practice.

Use:

```java
Human.population
```

instead.

---

# 12. Static Variables Inside Constructors

```java
class Human {

    static int population;

    Human() {
        population++;
    }
}
```

Every constructor call updates the shared variable.

---

# 13. Static Variables Inside Instance Methods

```java
void show() {
    System.out.println(population);
}
```

Allowed.

Instance methods can access static members.

---

# 14. Static Variables Inside Static Methods

```java
static void show() {
    System.out.println(population);
}
```

Allowed.

Both belong to the class.

---

# 15. Static Variables and Multiple Objects

```java
Human h1 = new Human();
Human h2 = new Human();
Human h3 = new Human();
```

Still:

```text
One population variable
```

---

# 16. Static Variables and Inheritance

```java
class Parent {
    static int x = 10;
}

class Child extends Parent {
}
```

```java
System.out.println(Child.x);
```

Output:

```text
10
```

Inherited.

---

# 17. Static Final Variables

```java
static final double PI = 3.14159;
```

Cannot be modified.

---

# 18. Constants in Java

Examples:

```java
Math.PI
Integer.MAX_VALUE
Integer.MIN_VALUE
```

All are:

```java
static final
```

---

# 19. Common Interview Questions

### Q1

How many copies of a static variable exist?

Answer:

```text
Only one.
```

---

### Q2

Can static variables be inherited?

Answer:

```text
Yes.
```

---

### Q3

Can static variables be accessed without objects?

Answer:

```text
Yes.
```

---

# Part 3: Static Methods

# 20. Static Methods

A static method belongs to the class.

Example:

```java
class Test {

    static void greet() {
        System.out.println("Hello");
    }
}
```

Call:

```java
Test.greet();
```

---

# 21. Instance Methods

Belong to objects.

```java
class Test {

    void greet() {
        System.out.println("Hello");
    }
}
```

Need:

```java
Test t = new Test();
t.greet();
```

---

# 22. Calling Static Methods

```java
Test.greet();
```

No object required.

---

# 23. Calling Instance Methods

```java
Test t = new Test();
t.greet();
```

Object required.

---

# 24. Why Static Methods Cannot Access Instance Members

Wrong:

```java
int age = 20;

static void show() {
    System.out.println(age);
}
```

Error.

Reason:

Static methods do not know which object's age should be used.

---

# 25. Why Instance Methods Can Access Static Members

```java
static int x = 10;

void show() {
    System.out.println(x);
}
```

Allowed.

Objects can access class members.

---

# 26. Static Method Calling Rules

| Caller   | Callee   | Allowed |
| -------- | -------- | ------- |
| Static   | Static   | Yes     |
| Static   | Instance | No      |
| Instance | Static   | Yes     |
| Instance | Instance | Yes     |

---

# 27. Method Access Matrix

```text
Static Method
|
|-- Static Variable ✓
|-- Static Method ✓
|-- Instance Variable ✗
|-- Instance Method ✗
```

---

# 28. Static Methods and Overloading

Allowed.

```java
static void fun() {}
static void fun(int x) {}
```

This is overloading.

---

# 29. Static Methods and Overriding

Not allowed.

Static methods are hidden.

Not overridden.

---

# 30. Method Hiding

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

Called:

```text
Method Hiding
```

---

# 31. Static Methods and Polymorphism

```java
Parent p = new Child();

p.show();
```

Output:

```text
Parent
```

Static methods use reference type.

Not object type.

---

# 32. Dynamic Method Dispatch vs Static Binding

Instance methods:

```text
Runtime Binding
```

Static methods:

```text
Compile-Time Binding
```

---

# 33. Common Interview Questions

### Can static methods be overloaded?

Yes.

### Can static methods be overridden?

No.

### Can static methods access instance variables?

No.

---

# Part 4: Static Blocks

# 34. Static Blocks

Static blocks execute when the class loads.

```java
static {
    System.out.println("Static Block");
}
```

---

# 35. Purpose of Static Blocks

Used for:

```text
Complex Initialization
Database Drivers
Configuration Loading
```

---

# 36. Class Loading Process

```text
Load
Link
Initialize
```

Static block executes during:

```text
Initialize
```

---

# 37. Initialization Order

```java
static int x = 10;

static {
    x = 20;
}
```

Order:

```text
Static Variable
Static Block
main()
```

---

# 38. Multiple Static Blocks

```java
static {
    System.out.println("A");
}

static {
    System.out.println("B");
}
```

Output:

```text
A
B
```

Top to bottom.

---

# 39. Static Variables and Static Blocks Together

```java
static int x = 10;

static {
    x *= 2;
}
```

Result:

```text
20
```

---

# 40. Static Block Execution Flow

Runs only once per class.

Never once per object.

---

# 41. Static Block vs Constructor

| Static Block   | Constructor     |
| -------------- | --------------- |
| Once per class | Once per object |
| Runs first     | Runs later      |

---

# 42. Interview Questions

Can static blocks run multiple times?

```text
No
```

Only once per class loading.

---

# Part 5: Constructors and Static

# 43. Constructors

Used to initialize objects.

```java
Test() {
}
```

---

# 44. Why Constructors Cannot Be Static

Wrong:

```java
static Test() {
}
```

Reason:

```text
Constructor → Object
Static → Class
```

Contradiction.

---

# 45. Constructors Accessing Static Members

Allowed.

```java
Test() {
    count++;
}
```

---

# 46. Constructors Calling Static Methods

Allowed.

```java
Test() {
    show();
}
```

---

# 47. Static Methods Creating Objects

Allowed.

```java
static void create() {
    Test t = new Test();
}
```

---

# 48. Constructor Execution Flow

```java
Test t = new Test();
```

Flow:

```text
1. Class Loads
2. Static Variables Initialized
3. Static Blocks Execute
4. Object Created
5. Instance Variables Initialized
6. Constructor Executes
```

---

# End of Part 1–5

Next Parts:

* Part 6: Static Classes
* Part 7: The Famous Test Example
* Part 8: Static and Memory
* Part 9: Static and JVM
* Part 10: Static and Inheritance
