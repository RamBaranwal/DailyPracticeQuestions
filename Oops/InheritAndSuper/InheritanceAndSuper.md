# Java OOP Notes - Inheritance, super, this, Constructors & Method Overriding

---

# 1. Inheritance

## Definition

Inheritance allows one class to acquire properties and behaviors of another class.

```java
class Vehicle {
}

class Car extends Vehicle {
}
```

Here:

* Vehicle = Parent / Superclass
* Car = Child / Subclass

Relationship:

```text
Vehicle
   ↑
   |
  Car
```

---

## Why Use Inheritance?

Without inheritance:

```java
class Car {
    String name;
    int wheels;
}
```

```java
class Bike {
    String name;
    int wheels;
}
```

Duplicate code.

With inheritance:

```java
class Vehicle {
    String name;
    int wheels;
}
```

```java
class Car extends Vehicle {
}
```

```java
class Bike extends Vehicle {
}
```

Code reused.

---

# 2. What Child Class Gets?

```java
class Vehicle {
    String name;
    int wheels;

    void start() {
    }
}
```

```java
class Car extends Vehicle {
}
```

Car automatically gets:

```java
name
wheels
start()
```

No need to rewrite them.

---

# 3. Constructor Inheritance

Important:

Constructors are NOT inherited.

Example:

```java
class Vehicle {
    Vehicle() {
    }
}
```

```java
class Car extends Vehicle {
}
```

Car cannot directly use Vehicle constructor.

But when Car object is created:

```java
Car obj = new Car();
```

Parent constructor executes first.

---

# 4. super Keyword

## Definition

`super` refers to the immediate parent class.

Used for:

1. Calling parent constructor
2. Accessing parent methods
3. Accessing parent variables

---

# 5. Calling Parent Constructor

Parent:

```java
class Vehicle {

    Vehicle() {
        System.out.println("Vehicle Constructor");
    }
}
```

Child:

```java
class Car extends Vehicle {

    Car() {
        super();
        System.out.println("Car Constructor");
    }
}
```

Output:

```text
Vehicle Constructor
Car Constructor
```

Parent constructor always runs first.

---

# 6. What Happens If super() Is Not Written?

Java automatically inserts it.

```java
Car() {
}
```

Internally:

```java
Car() {
    super();
}
```

Compiler adds it automatically.

---

# 7. Parameterized Parent Constructor

Parent:

```java
Vehicle(int wheels) {
    this.wheels = wheels;
}
```

Child:

```java
Car() {
    super(4);
}
```

Meaning:

```text
Call parent's constructor
Pass value 4
Initialize wheels
```

---

# 8. Constructor Execution Order

Code:

```java
Car obj = new Car();
```

Execution:

```text
Memory Allocation

↓

Parent Constructor

↓

Child Constructor

↓

Object Ready
```

Always:

```text
Parent First
Child Second
```

Remember this forever.

---

# 9. this Keyword

## Definition

`this` refers to the current object.

Example:

```java
class Car {

    String color;

    void display() {
        System.out.println(this.color);
    }
}
```

Here:

```java
this.color
```

means:

```java
Current object's color
```

---

# 10. Uses of this

### Access Current Object Variable

```java
this.color
```

---

### Call Current Method

```java
this.start();
```

---

### Pass Current Object

```java
process(this);
```

---

### Call Another Constructor

```java
this("Red");
```

Must be first statement.

---

# 11. this vs super

## this

Refers to current object.

```java
this.color
```

Current class variable.

---

## super

Refers to parent class.

```java
super.start();
```

Parent class method.

---

Comparison:

| this           | super         |
| -------------- | ------------- |
| Current Object | Parent Object |
| Current Class  | Parent Class  |
| this.color     | super.color   |
| this.start()   | super.start() |

---

# 12. Method Overriding

## Definition

Child class provides its own implementation of parent method.

Parent:

```java
void start() {
    System.out.println("Vehicle Start");
}
```

Child:

```java
void start() {
    System.out.println("Car Start");
}
```

---

# 13. Why Overriding?

Parent gives general behavior.

Child gives specialized behavior.

Example:

```text
Vehicle → Start Engine

Car → Start Car Engine

Bike → Start Bike Engine
```

Same action.

Different implementation.

---

# 14. Method Resolution

```java
Car obj = new Car();
obj.start();
```

Java checks:

```text
Car class ?
```

Found?

```text
YES
```

Execute child method.

Parent method ignored.

---

If child doesn't contain method:

```text
Search Parent
```

Then:

```text
Grand Parent
```

And so on.

---

# 15. Calling Parent Method Explicitly

Child:

```java
void start() {

    super.start();

    System.out.println("Car Start");
}
```

Output:

```text
Vehicle Start
Car Start
```

---

# 16. Static Context and this

Inside:

```java
public static void main(String[] args)
```

Cannot use:

```java
this
```

Why?

Because:

```text
this = Current Object
```

But static methods belong to class.

No object exists yet.

Invalid:

```java
public static void main(String[] args) {

    System.out.println(this.name);

}
```

Compiler Error.

---

# 17. Accessing Instance Variables in main()

Wrong:

```java
System.out.println(this.name);
```

Correct:

```java
Car obj = new Car();

System.out.println(obj.name);
```

Need object reference.

---

# 18. Your Code Flow

```java
Car obj = new Car();
```

Execution:

### Step 1

Memory allocated.

---

### Step 2

```java
super();
```

calls:

```java
Vehicle()
```

Output:

```text
this is default constructor of Vehicle
```

---

### Step 3

Car constructor executes.

Output:

```text
this is car default constructor
```

---

### Step 4

Object created.

---

### Step 5

```java
obj.name = "i10";
obj.wheels = 4;
obj.color = "Red";
```

Values assigned.

---

### Step 6

```java
obj.start();
```

Car's start method exists.

Therefore:

```text
Method Overriding happens
```

Vehicle's start method is skipped.

---

# Interview Questions

## Can constructors be inherited?

No.

---

## Can constructors be overridden?

No.

---

## Can methods be overridden?

Yes.

---

## Which constructor executes first?

Parent constructor.

---

## What does super() do?

Calls parent constructor.

---

## What does this refer to?

Current object.

---

## Can this be used inside static methods?

No.

---

## Why?

Static methods belong to class, not object.

---

# Memory Tricks

### Inheritance

> Child gets parent's properties and methods.

### super

> Talk to Parent.

### this

> Talk to Yourself.

### Constructor Order

> Parent First → Child Second.

### Overriding

> Child replaces Parent's behavior.

### Static Method

> No Object → No this.
