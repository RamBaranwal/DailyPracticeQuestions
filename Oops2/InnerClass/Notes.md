# Java Inner Classes and Static Nested Classes - Complete Notes

## Introduction

When learning Java OOP, one of the most confusing topics is:

* Inner Classes
* Static Nested Classes
* Static Variables inside Nested Classes
* Why some classes need an object of the outer class and others do not

Let's understand everything from scratch.

---

# 1. What is a Nested Class?

A class declared inside another class is called a **nested class**.

Example:

```java
class Outer {

    class Inner {

    }
}
```

Here:

* `Outer` is the outer class.
* `Inner` is the nested class.

Java supports two major types:

1. Non-static nested class (Inner Class)
2. Static nested class

---

# 2. Non-Static Inner Class

Example:

```java
public class Main {

    class Test {

    }

}
```

Since `Test` is not static, it belongs to an object of `Main`.

Think of it like:

```text
Main Object
|
|---- Test Object
|
|---- Test Object
```

The inner class exists inside an outer class object.

---

# Your First Example

```java
public class Main {

    class Test {

        String name;

        Test(String name){
            this.name = name;
        }

        void display(){
            System.out.println("Welcome " + this.name);
        }
    }

    public static void main(String[] args) {

        Main obj = new Main();

        Main.Test t1 = obj.new Test("Super 1");
        Main.Test t2 = obj.new Test("Super 2");

        t1.display();
        t2.display();
    }
}
```

---

# Step-by-Step Execution

## Step 1

JVM starts

```java
main()
```

No Main object exists yet.

Memory:

```text
Stack
-----
main()
```

---

## Step 2

Create Main object

```java
Main obj = new Main();
```

Memory:

```text
obj -----> Main Object
```

---

## Step 3

Create first Test object

```java
Main.Test t1 = obj.new Test("Super 1");
```

Memory:

```text
obj -----> Main Object
             |
             |
             +-----> Test Object
                        name = "Super 1"
```

---

## Step 4

Create second Test object

```java
Main.Test t2 = obj.new Test("Super 2");
```

Memory:

```text
obj -----> Main Object
             |
             +-----> Test Object
             |          name = "Super 1"
             |
             +-----> Test Object
                        name = "Super 2"
```

---

## Step 5

Call display

```java
t1.display();
```

Inside display:

```java
this.name
```

becomes

```java
t1.name
```

Output:

```text
Welcome Super 1
```

---

## Step 6

```java
t2.display();
```

Inside display:

```java
this.name
```

becomes

```java
t2.name
```

Output:

```text
Welcome Super 2
```

---

# Why do we write obj.new Test()?

Because Test is not static.

Java needs to know:

```text
Which Main object owns this Test object?
```

Therefore:

```java
obj.new Test(...)
```

is required.

Without `obj`, Java cannot create the inner class.

---

# Hidden Reference Created by Java

Whenever you create:

```java
obj.new Test("Super 1");
```

Java secretly stores:

```java
Main.this = obj;
```

inside Test.

Therefore every Test object remembers the Main object that created it.

---

# Static Nested Class

Now look at your second example.

```java
public class Main2 {

    static class Test2 {

    }

}
```

Notice the keyword:

```java
static
```

Now Test2 belongs to the class itself.

It does NOT belong to a Main2 object.

---

# Why Static Nested Class Does Not Need Outer Object

Normal inner class:

```java
class Test
```

Needs:

```java
Main obj = new Main();
obj.new Test();
```

Static nested class:

```java
static class Test2
```

Needs:

```java
new Test2();
```

No Main object required.

---

# Your Test2 Analysis

```java
static class Test2 {

    String name;

    Test2(String name){
        this.name = name;
    }

    void display(){
        System.out.println("welcome " + this.name);
    }
}
```

Create object:

```java
Test2 a = new Test2("Rahul");
```

Memory:

```text
a -----> Test2 Object
          |
          +--- name = Rahul
```

Call:

```java
a.display();
```

Output:

```text
welcome Rahul
```

---

# Test3 Analysis

```java
static class Test3 {

    static String name;

    Test3(String name){
        Test3.name = name;
    }

    static void display(){
        System.out.println("Welcome " + Test3.name);
    }
}
```

This is completely different.

Notice:

```java
static String name;
```

There is only ONE copy.

Not one copy per object.

---

# Memory Structure

```text
Class Area
----------
Test3.name
```

No object owns this variable.

The class owns it.

---

# Execution

```java
Test3 b = new Test3("Karan");
```

Constructor runs:

```java
Test3.name = "Karan";
```

Memory:

```text
Class Area
----------
name = Karan
```

---

# Call

```java
Test3.display();
```

Output:

```text
Welcome Karan
```

---

# Important Observation

Suppose:

```java
Test3 a = new Test3("Rahul");
Test3 b = new Test3("Karan");
```

What happens?

First:

```text
name = Rahul
```

Then:

```text
name = Karan
```

Rahul gets overwritten.

Because static variables are shared.

Final value:

```text
name = Karan
```

Output:

```text
Welcome Karan
```

---

# Static vs Non-Static Variables

## Non-Static

```java
String name;
```

Every object gets its own copy.

```text
Object 1
name = Rahul

Object 2
name = Karan
```

---

## Static

```java
static String name;
```

Only one copy exists.

```text
Class
name = Karan
```

All objects share it.

---

# Why Test2 Uses this.name

```java
this.name
```

Because name belongs to the object.

Every object has its own value.

---

# Why Test3 Uses Test3.name

```java
Test3.name
```

Because name belongs to the class.

Not to any object.

---

# Interview Question

Can a static nested class access non-static members of the outer class directly?

Example:

```java
class Main {

    int age;

    static class Test {

    }
}
```

Inside Test:

```java
System.out.println(age);
```

Error.

Why?

Because static nested classes do not have an outer object reference.

---

# When to Use Inner Class

Use when the nested class logically belongs to an object.

Examples:

* Node inside Linked List
* Iterator inside Collection
* Button Listener inside GUI

---

# When to Use Static Nested Class

Use when the nested class is only grouped for organization and does not need outer object data.

Examples:

* Builder Pattern
* Helper Classes
* Utility Classes

---

# Final Revision

## Non-Static Inner Class

```java
class Test
```

Properties:

* Requires outer object
* Can access outer object members
* Created using:

```java
obj.new Test()
```

---

## Static Nested Class

```java
static class Test
```

Properties:

* No outer object required
* Behaves like normal class
* Created using:

```java
new Test()
```

or

```java
new Main.Test()
```

---

# Golden Rule

If a nested class needs data from a specific outer object:

```java
class Inner
```

Use a non-static inner class.

If a nested class does not depend on any outer object:

```java
static class Inner
```

Use a static nested class.
