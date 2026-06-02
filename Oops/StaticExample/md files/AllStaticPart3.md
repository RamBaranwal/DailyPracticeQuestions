# Java Static vs Non-Static Master Guide

# Part 11–15 (Utility Methods, Advanced Topics, Mistakes, Interview Questions, Cheat Sheet)

---

# Part 11: Static Utility Methods

# 84. Arrays.sort()

Example:

```java
int[] arr = {5, 2, 8, 1};

Arrays.sort(arr);
```

---

## Why is Arrays.sort() Static?

Imagine if Java required:

```java
Arrays a = new Arrays();
a.sort(arr);
```

This would make no sense because:

```text
Arrays is not an object that stores data.
```

It is simply a utility class.

Therefore:

```java
Arrays.sort(arr);
```

is made static.

---

## Rule

Whenever a method:

* Does not depend on object state
* Performs a generic operation

it is often made static.

---

# 85. Collections.sort()

Example:

```java
List<Integer> list = new ArrayList<>();

Collections.sort(list);
```

Again:

```text
Sorting logic does not belong to a Collections object.
```

Hence static.

---

# 86. Math.sqrt()

Example:

```java
double x = Math.sqrt(25);
```

Output:

```text
5.0
```

---

## Why Static?

Square root calculation does not need a Math object.

Wrong design:

```java
Math m = new Math();
m.sqrt(25);
```

Correct:

```java
Math.sqrt(25);
```

---

# 87. Math.max()

Example:

```java
Math.max(10, 20);
```

Output:

```text
20
```

Static because:

```text
No object state required.
```

---

# 88. Integer.parseInt()

Example:

```java
int x = Integer.parseInt("123");
```

Output:

```text
123
```

---

## Why Static?

Parsing a string into an integer does not require an Integer object.

---

# 89. System.out

Many students ask:

```java
System.out.println("Hello");
```

Why not:

```java
new System().out.println("Hello");
```

---

## Explanation

Inside System class:

```java
public final class System {

    public static PrintStream out;
}
```

`out` is static.

Therefore:

```java
System.out
```

can be used directly.

---

# 90. Why Utility Methods Are Static

Utility methods:

```java
Math.sqrt()
Math.max()
Arrays.sort()
Collections.sort()
Integer.parseInt()
```

are static because:

```text
No object-specific data is required.
```

---

# Part 12: Advanced Topics

# 91. Static Factory Methods

Instead of constructors:

```java
User u = new User();
```

Java sometimes uses:

```java
User u = User.create();
```

---

Example:

```java
class User {

    static User create() {
        return new User();
    }
}
```

Usage:

```java
User u = User.create();
```

---

## Benefits

* Better names
* Control object creation
* Can return existing objects

---

# 92. Singleton Pattern

Singleton means:

```text
Only one object should exist.
```

Example:

```java
class Singleton {

    private static Singleton instance =
            new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
```

Usage:

```java
Singleton s1 =
    Singleton.getInstance();

Singleton s2 =
    Singleton.getInstance();
```

Both references point to the same object.

---

# 93. Lazy Initialization

Object created only when needed.

Example:

```java
class Singleton {

    private static Singleton instance;

    public static Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
```

---

## Benefit

Memory saved.

Object created only when required.

---

# 94. Initialization-on-Demand Holder Idiom

Best Singleton implementation.

```java
class Singleton {

    private Singleton() {}

    private static class Holder {

        private static final Singleton INSTANCE =
                new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

---

## Why Important?

Uses:

* Static Nested Class
* Lazy Loading
* Thread Safety

All together.

---

# 95. Static Synchronization

Example:

```java
class Counter {

    static synchronized void increment() {

    }
}
```

---

## Meaning

Lock applied on:

```text
Class Object
```

not on individual objects.

---

# 96. Thread Safety of Static Variables

Problem:

```java
static int count = 0;
```

Multiple threads:

```java
count++;
```

may cause incorrect results.

---

## Solution

Use:

```java
synchronized
AtomicInteger
```

---

# 97. Static Nested Singleton Pattern

Combines:

```text
Static Nested Class
Singleton
Lazy Loading
```

Example:

```java
class Singleton {

    private Singleton(){}

    private static class Holder {

        static final Singleton INSTANCE =
                new Singleton();
    }

    public static Singleton getInstance() {

        return Holder.INSTANCE;
    }
}
```

---

# Part 13: Common Mistakes

# 98. Accessing Instance Variables from Static Methods

Wrong:

```java
class Test {

    int age = 20;

    static void show() {

        System.out.println(age);
    }
}
```

Error.

---

Correct:

```java
static void show() {

    Test t = new Test();

    System.out.println(t.age);
}
```

---

# 99. Using this in Static Methods

Wrong:

```java
static void show() {

    System.out.println(this);
}
```

Error.

---

Reason:

```text
this = current object
```

Static methods have no current object.

---

# 100. Thinking Static Classes Have One Object

Wrong assumption:

```java
static class Test
```

means:

```text
Only one object.
```

Wrong.

---

Example:

```java
Test a = new Test();
Test b = new Test();
```

Two separate objects.

---

# 101. Calling Instance Methods Without Objects

Wrong:

```java
class Test {

    void show() {}
}

Test.show();
```

Compilation error.

---

Need:

```java
Test t = new Test();

t.show();
```

---

# 102. Confusing Method Hiding with Overriding

Static methods:

```java
static void show()
```

→ Hidden

Instance methods:

```java
void show()
```

→ Overridden

---

# Part 14: Top Interview Questions

# 103. Top 50 Static Interview Questions

### Q1

Can constructors be static?

Answer:

```text
No
```

---

### Q2

Can static methods be overridden?

Answer:

```text
No
```

---

### Q3

Can static methods be overloaded?

Answer:

```text
Yes
```

---

### Q4

Can static variables be inherited?

Answer:

```text
Yes
```

---

### Q5

Can static methods access instance variables?

Answer:

```text
No
```

---

### Q6

Can instance methods access static variables?

Answer:

```text
Yes
```

---

### Q7

How many copies of a static variable exist?

Answer:

```text
One
```

---

### Q8

Where are static variables stored?

Answer:

```text
Method Area / Metaspace
```

---

### Q9

Why is main() static?

Answer:

```text
JVM calls it before creating objects.
```

---

### Q10

Can a top-level class be static?

Answer:

```text
No
```

---

# 104. Output-Based Questions

Question:

```java
class Test {

    static int x = 10;

    static {
        x = 20;
    }

    public static void main(String[] args) {

        System.out.println(x);
    }
}
```

Output:

```text
20
```

---

# 105. Memory-Based Questions

Question:

```java
class Test {

    static int x;
}
```

How many copies?

Answer:

```text
One
```

---

Question:

```java
class Test {

    int x;
}
```

Three objects created.

How many copies?

Answer:

```text
Three
```

---

# 106. Inheritance Questions

Question:

```java
Parent p = new Child();

p.show();
```

where show() is static.

Output:

```text
Parent
```

Reason:

```text
Method Hiding
```

---

# 107. Nested Class Questions

Question:

```java
static class Test {
}
```

Can we create multiple objects?

Answer:

```text
Yes
```

Unlimited.

---

# Part 15: Complete Revision & Cheat Sheet

# 108. One-Page Cheat Sheet

### Static

```text
Belongs to Class
One Copy
Shared
```

### Non-Static

```text
Belongs to Object
Multiple Copies
Not Shared
```

---

# 109. Quick Comparison Table

| Feature      | Static     | Non-Static       |
| ------------ | ---------- | ---------------- |
| Belongs To   | Class      | Object           |
| Copies       | One        | Per Object       |
| Shared       | Yes        | No               |
| Needs Object | No         | Yes              |
| Accessed By  | Class Name | Object Reference |

---

# 110. Golden Rules

### Rule 1

Static belongs to class.

### Rule 2

Non-static belongs to object.

### Rule 3

One static copy.

### Rule 4

One instance copy per object.

### Rule 5

Static methods cannot directly access instance members.

### Rule 6

Instance methods can access both.

---

# 111. Memory Rules

```text
Static Variables
      ↓
Method Area

Objects
      ↓
Heap

References
      ↓
Stack
```

---

# 112. Method Rules

```text
Static → Static ✓

Static → Instance ✗

Instance → Static ✓

Instance → Instance ✓
```

---

# 113. Static Class Rules

```text
Static Nested Class
|
|-- No Outer Object Needed
|-- Unlimited Objects Allowed
|-- Can Access Outer Static Members
|-- Cannot Directly Access Outer Instance Members
```

---

# 114. Interview Traps

### Trap 1

Static class ≠ Singleton

---

### Trap 2

Static methods are not overridden

---

### Trap 3

main() must be static

---

### Trap 4

Access static members using class name

Preferred:

```java
Human.population
```

Not:

```java
h.population
```

---

### Trap 5

Every `new` creates a new object

Even for:

```java
static class Test
```

---

# Final Ultimate Rule

Whenever you see:

```java
static
```

Ask:

> Does this belong to the class or to each object?

If the answer is:

```text
Class
```

Use static.

If the answer is:

```text
Each Object
```

Use non-static.

This one question solves almost every static vs non-static confusion in Java.
