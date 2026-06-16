# Java `final` Keyword - Notes That Remove Common Confusions

---

# What Does `final` Actually Mean?

Most beginners think:

```text
final = value cannot be assigned
```

❌ Wrong

Actual meaning:

```text
final = value can be assigned ONLY ONCE
```

This single sentence removes most confusion.

---

# 1. Final Variable

Example:

```java
final int age = 20;
```

Memory:

```text
age = 20
```

Now:

```java
age = 30;
```

❌ Error

Because `age` already received its one assignment.

---

# 2. Blank Final Variable

Example:

```java
final int rollNo;
```

At this point:

```text
rollNo = ?
```

No value assigned yet.

Java allows ONE assignment later.

---

## Valid Example

```java
class Student {

    final int rollNo;

    Student(int rollNo) {
        this.rollNo = rollNo;
    }
}
```

Execution:

```java
Student s = new Student(101);
```

Step 1:

```text
rollNo = ?
```

Step 2:

```java
this.rollNo = 101;
```

Step 3:

```text
rollNo = 101
```

Step 4:

```text
LOCKED FOREVER
```

✅ Valid

---

# Most Common Confusion

Students ask:

> "If rollNo is final, why can we write this.rollNo = rollNo?"

Answer:

Because:

```text
Before assignment:
rollNo = ?
```

No value exists.

Java is allowing the FIRST assignment.

It is NOT changing the value.

It is assigning the value for the first time.

---

# Difference Between Assignment and Change

Example:

```java
final int x;
```

Current state:

```text
x = ?
```

Assign:

```java
x = 10;
```

✅ First assignment

Now:

```text
x = 10
```

Try:

```java
x = 20;
```

❌ Second assignment

Not allowed.

---

# Visual Story

Imagine a locker.

Initially:

```text
Locker = Empty
```

You can put one item inside.

```text
Locker = 101
```

After that:

```text
Locker Locked
```

Trying to replace:

```text
101 → 102
```

❌ Not allowed.

---

# Why Does This Give an Error?

```java
class Student {

    final int rollNo;

    Student() {

    }
}
```

Compiler Error:

```text
blank final field rollNo may not have been initialized
```

Reason:

Object creation:

```text
rollNo = ?
```

Constructor runs:

```text
Nothing assigned
```

Object creation finishes:

```text
rollNo = ?
```

Java says:

```text
A final variable cannot remain blank.
```

❌ Error

---

# Important Rule

For every blank final variable:

```java
final int rollNo;
```

Java checks:

```text
Will EVERY constructor assign a value?
```

---

# Valid

```java
class Student {

    final int rollNo;

    Student() {
        rollNo = 1;
    }

    Student(int n) {
        rollNo = n;
    }
}
```

Both constructors assign a value.

✅ Valid

---

# Invalid

```java
class Student {

    final int rollNo;

    Student() {
        rollNo = 1;
    }

    Student(String name) {

    }
}
```

Second constructor leaves it blank.

❌ Error

---

# Final Reference Variable

Another common confusion.

Example:

```java
final Car car = new Car();
```

Students think:

```text
Everything inside car is final.
```

❌ Wrong

Only the reference is final.

---

## Memory

```text
car ---------> Car Object
```

Reference:

```text
car
```

Object:

```text
Car Object
```

These are different things.

---

# Allowed

```java
car.color = "Blue";
```

Why?

Because:

```text
Object changed
Reference unchanged
```

✅ Valid

---

# Not Allowed

```java
car = new Car();
```

Why?

Because:

```text
Reference changed
```

❌ Error

---

# Memory Visualization

Before:

```text
car ---------> Car Object (Red)
```

After:

```java
car.color = "Blue";
```

```text
car ---------> Car Object (Blue)
```

Same object.

Reference unchanged.

---

# Final Method

Example:

```java
class Vehicle {

    final void start() {

    }
}
```

Child:

```java
class Car extends Vehicle {

    void start() {

    }
}
```

❌ Error

Reason:

```text
Final Method = Cannot Override
```

---

# Final Class

Example:

```java
final class Vehicle {

}
```

```java
class Car extends Vehicle {

}
```

❌ Error

Reason:

```text
Final Class = Cannot Inherit
```

---

# Final Parameter

Example:

```java
void print(final int x) {

}
```

Valid:

```java
System.out.println(x);
```

Invalid:

```java
x = 20;
```

❌ Error

---

# Constructor vs Final Variable

Example:

```java
class Student {

    final int rollNo;

    Student(int rollNo) {

        this.rollNo = rollNo;

    }
}
```

Important:

```text
Constructor is not changing rollNo.
```

It is:

```text
Giving rollNo its first value.
```

After constructor finishes:

```text
rollNo becomes locked.
```

---

# Quick Revision Table

| Code                      | Meaning                  |
| ------------------------- | ------------------------ |
| final int x = 10          | Value fixed              |
| final int x; x = 10;      | First assignment allowed |
| x = 20                    | Not allowed              |
| final Car car = new Car() | Reference fixed          |
| car.color = "Blue"        | Allowed                  |
| car = new Car()           | Not allowed              |
| final method              | No overriding            |
| final class               | No inheritance           |
| final parameter           | No reassignment          |

---

# Interview Answers

### Q1. What does final mean?

```text
Can be assigned only once.
```

---

### Q2. Can blank final variables exist?

Yes.

But they must be initialized exactly once before constructor completion.

---

### Q3. Why is this valid?

```java
final int rollNo;

Student(int rollNo){
    this.rollNo = rollNo;
}
```

Because:

```text
First assignment
```

not

```text
Value change
```

---

### Q4. Can final object data change?

```java
car.color = "Blue";
```

✅ Yes

---

### Q5. Can final reference change?

```java
car = new Car();
```

❌ No

---

# Ultimate Memory Trick

Think of `final` as a lock 🔒

```text
final variable
    ↓
Lock Value After First Assignment

final reference
    ↓
Lock Address

final method
    ↓
Lock Overriding

final class
    ↓
Lock Inheritance

final parameter
    ↓
Lock Reassignment
```

### Golden Formula

```text
final ≠ Cannot Assign

final = Can Assign Exactly Once
```
# Inheritance vs Creating Objects of Another Class

One of the biggest beginner confusions is:

> "If I can create an object of another class and use its methods, then why do I need inheritance?"

---

# Accessing Another Class Without Inheritance

Example:

```java
class Vehicle {

    int wheels = 4;

    void start() {
        System.out.println("Vehicle Started");
    }
}

class Car {

    void show() {

        Vehicle v = new Vehicle();

        System.out.println(v.wheels);

        v.start();
    }
}
```

Here:

```java
Vehicle v = new Vehicle();
```

creates a Vehicle object.

Then:

```java
v.start();
```

calls Vehicle's method.

This works without inheritance.

---

# What Relationship Is This?

```text
Car ----uses----> Vehicle
```

Car is using a Vehicle object.

This is called:

```text
HAS-A Relationship
```

because Car has a Vehicle object reference.

---

# Memory View

```java
Vehicle v = new Vehicle();
```

Memory:

```text
v ---------> Vehicle Object
             --------------
             wheels = 4
             start()
             --------------
```

Car accesses Vehicle through the reference variable:

```java
v
```

---

# With Inheritance

Example:

```java
class Vehicle {

    int wheels = 4;

    void start() {
        System.out.println("Vehicle Started");
    }
}

class Car extends Vehicle {

}
```

Now:

```java
Car c = new Car();

System.out.println(c.wheels);

c.start();
```

works directly.

No Vehicle object is created separately.

---

# What Relationship Is This?

```text
Vehicle
   ↑
   |
  Car
```

This is called:

```text
IS-A Relationship
```

Because:

```text
Car IS-A Vehicle
Bike IS-A Vehicle
Truck IS-A Vehicle
```

---

# Biggest Difference

## Without Inheritance

```java
Vehicle v = new Vehicle();

v.start();
```

Need another object.

Relationship:

```text
HAS-A
```

---

## With Inheritance

```java
Car c = new Car();

c.start();
```

No extra object needed.

Relationship:

```text
IS-A
```

---

# Real World Example

## HAS-A Relationship (Composition)

```java
class Engine {

    void start() {
        System.out.println("Engine Started");
    }
}

class Car {

    Engine e = new Engine();

    void drive() {
        e.start();
    }
}
```

Meaning:

```text
Car HAS-A Engine
```

A car contains an engine.

A car is NOT an engine.

---

## IS-A Relationship (Inheritance)

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle Started");
    }
}

class Car extends Vehicle {

}
```

Meaning:

```text
Car IS-A Vehicle
```

A car is a type of vehicle.

---

# Why Do We Need Inheritance?

Suppose:

```java
class Car {

    String name;
    int wheels;

    void start() {}
}
```

```java
class Bike {

    String name;
    int wheels;

    void start() {}
}
```

```java
class Truck {

    String name;
    int wheels;

    void start() {}
}
```

Same code repeated.

---

Using inheritance:

```java
class Vehicle {

    String name;
    int wheels;

    void start() {}
}
```

```java
class Car extends Vehicle {}
class Bike extends Vehicle {}
class Truck extends Vehicle {}
```

Code written once.

All child classes reuse it.

---

# Inheritance Gives More Than Access

Inheritance is not only about accessing methods.

It provides:

### Code Reuse

```text
Write Once
Reuse Everywhere
```

---

### Method Overriding

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle");
    }
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car");
    }
}
```

Child changes parent behavior.

---

### Runtime Polymorphism

```java
Vehicle v = new Car();

v.start();
```

Output:

```text
Car
```

Without inheritance this feature is impossible.

---

# Composition vs Inheritance

| Composition               | Inheritance                 |
| ------------------------- | --------------------------- |
| HAS-A                     | IS-A                        |
| Uses another object       | Becomes a type of parent    |
| `Engine e = new Engine()` | `class Car extends Vehicle` |
| Object relationship       | Parent-child relationship   |
| No overriding             | Supports overriding         |
| No polymorphism           | Supports polymorphism       |

---

# Interview Question

### If I can create another class's object and use its methods, why do I need inheritance?

Because inheritance is not for simply accessing methods.

Inheritance provides:

* Code reuse
* IS-A relationship
* Method overriding
* Runtime polymorphism
* Easier maintenance

Creating an object only provides:

```text
HAS-A relationship
```

while inheritance provides:

```text
IS-A relationship
```

---

# Memory Trick

```java
Engine e = new Engine();
```

```text
Car HAS-A Engine
```

Composition.

---

```java
class Car extends Vehicle
```

```text
Car IS-A Vehicle
```

Inheritance.

---

# Golden Rule

Use Inheritance when:

```text
A child is a specialized version of parent.
```

Examples:

```text
Car IS-A Vehicle
Dog IS-An Animal
Student IS-A Person
```

Use Composition when:

```text
One object contains another object.
```

Examples:

```text
Car HAS-An Engine
House HAS-A Room
Computer HAS-A CPU
```
