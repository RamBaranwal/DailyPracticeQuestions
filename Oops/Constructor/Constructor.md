# Java OOP Notes - Constructors, Constructor Overloading, Methods & Objects

---

# What is a Constructor?

A constructor is a special member of a class used to initialize objects when they are created.

Think of it as the **birth process of an object**.

When an object is created using `new`, the constructor executes automatically.

```java
Student s = new Student();
```

Here:

1. Memory is allocated.
2. Constructor is called.
3. Object is initialized.

---

# Characteristics of Constructors

### 1. Same Name as Class

```java
class Student {
    Student() {
    }
}
```

Constructor name must exactly match the class name.

---

### 2. No Return Type

Valid:

```java
Student() {
}
```

Invalid:

```java
void Student() {
}
```

Once a return type is added, it becomes a normal method.

---

### 3. Called Automatically

Methods require explicit calls.

```java
obj.display();
```

Constructors execute automatically.

```java
Student s = new Student();
```

---

### 4. Used for Initialization

Without constructor:

```java
Student s = new Student();
s.name = "John";
s.age = 20;
```

With constructor:

```java
Student s = new Student("John", 20);
```

Cleaner and safer.

---

# Types of Constructors

---

## 1. Default Constructor

Created automatically by Java if no constructor exists.

```java
class Student {
}
```

Java internally provides:

```java
Student() {
}
```

---

## 2. No-Argument Constructor

Written explicitly by programmer.

```java
Student() {
    name = "Unknown";
}
```

No parameters are accepted.

---

## 3. Parameterized Constructor

Accepts values during object creation.

```java
Student(String name, int age) {
    this.name = name;
    this.age = age;
}
```

Usage:

```java
Student s = new Student("John", 20);
```

---

# Constructor Overloading

## Definition

Having multiple constructors with different parameter lists in the same class.

Example:

```java
class Student {

    Student() {
    }

    Student(String name) {
    }

    Student(String name, int age) {
    }
}
```

---

## Why Constructor Overloading?

Provides multiple ways to create objects.

Example:

```java
Student s1 = new Student();

Student s2 = new Student("John");

Student s3 = new Student("John", 20);
```

Different requirements → Different constructors.

---

# Constructor vs Method

| Constructor                   | Method                     |
| ----------------------------- | -------------------------- |
| Initializes object            | Performs operations        |
| Same name as class            | Any valid name             |
| No return type                | Has return type or void    |
| Called automatically          | Called manually            |
| Executes once during creation | Can execute multiple times |

Example:

```java
Student(String name)
```

Constructor

```java
void display()
```

Method

---

# What is an Object?

An object is a real-world entity represented in software.

Examples:

* Student
* Car
* Employee
* Bank Account

Class = Blueprint

Object = Actual thing built from blueprint

Example:

```java
Student s1 = new Student();
```

Here:

* Student → Class
* s1 → Object

---

# Object Creation Process

```java
Student s1 = new Student();
```

Step 1:

Memory allocated.

Step 2:

Constructor called.

Step 3:

Reference stored in `s1`.

Diagram:

```text
s1
 |
 ▼
Object in Heap Memory
```

---

# What is a Method?

A method defines behavior of an object.

Examples:

```java
display()
calculate()
deposit()
withdraw()
```

Methods tell objects what they can do.

---

# Components of a Method

```java
returnType methodName(parameters) {

}
```

Example:

```java
int add(int a, int b) {
    return a + b;
}
```

---

# Types of Methods

---

## 1. Void Method

Returns nothing.

```java
void display() {
    System.out.println("Hello");
}
```

---

## 2. Returning Method

Returns a value.

```java
int add(int a, int b) {
    return a + b;
}
```

---

## 3. Object Returning Method

Returns an object.

```java
Complex add(Complex obj) {
    return new Complex(...);
}
```

Return type = Complex

Returned value = Complex object

---

# Returning Objects

Most beginners know how to return numbers.

```java
int square(int n) {
    return n * n;
}
```

Java can also return entire objects.

```java
Complex add(Complex obj) {
    return new Complex(10, 20);
}
```

Usage:

```java
Complex result = obj1.add(obj2);
```

This is heavily used in:

* Collections
* APIs
* Design Patterns
* Frameworks

---

# this Keyword

Used to refer to current object.

Example:

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Without `this`, Java gets confused between:

```java
name
```

(parameter)

and

```java
name
```

(instance variable)

---

# Memory Concept

Objects are stored in Heap Memory.

References are stored in Stack Memory.

Example:

```java
Student s = new Student();
```

Memory:

```text
Stack             Heap

s  ----------->   Student Object
```

---

# Interview Questions

### Why do constructors have no return type?

Because constructors are not ordinary methods. Their job is object initialization.

---

### Can constructors be overloaded?

Yes.

```java
Student()
Student(String name)
Student(String name, int age)
```

---

### Can constructors be inherited?

No.

Constructors belong to the class itself.

---

### Can constructors be private?

Yes.

Used in:

* Singleton Pattern
* Utility Classes

---

### Can a constructor call another constructor?

Yes.

Using:

```java
this(...)
```

Example:

```java
Student() {
    this("Unknown");
}
```

---

# Quick Revision

## Constructor

* Initializes object
* Same name as class
* No return type
* Called automatically

---

## Constructor Overloading

* Multiple constructors
* Different parameter lists
* Multiple ways to create objects

---

## Object

* Instance of class
* Created using `new`

---

## Method

* Defines behavior
* Called explicitly

---

## Object Returning Method

```java
Complex add(Complex obj)
```

Returns an object instead of primitive value.

---

# One-Line Memory Tricks

### Constructor

> Creates the object.

### Method

> Performs work on the object.

### Class

> Blueprint.

### Object

> Real thing created from blueprint.

### Constructor Overloading

> Multiple ways to create the same object.

### Returning Object

> Method gives back a complete object instead of a simple value.
