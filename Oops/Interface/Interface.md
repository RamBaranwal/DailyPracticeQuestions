# Java Interface Notes (Complete Revision Notes)

# What is an Interface?

An Interface is a blueprint of a class that contains abstract methods and constants.

It is used to achieve:

* Abstraction
* Multiple Inheritance
* Loose Coupling
* Standardization

Think of an interface as a contract.

```java
interface Human {
    void haveHand(int hand);
    void haveLeg(int leg);
}
```

Any class implementing this interface MUST provide implementations for all methods.

---

# Why Use Interfaces?

Suppose we have:

```java
interface Human {
    void walk();
}
```

Any class that implements Human promises:

```text
"I will provide a walk() method."
```

This creates a common standard.

---

# Interface Syntax

```java
interface Human {

    void haveHand(int hand);

    void haveLeg(int leg);
}
```

Methods inside an interface are automatically:

```java
public abstract
```

Java internally treats:

```java
void haveHand(int hand);
```

as

```java
public abstract void haveHand(int hand);
```

---

# Implementing an Interface

Use the `implements` keyword.

```java
class Species implements Human {

    @Override
    public void haveHand(int hand) {

    }

    @Override
    public void haveLeg(int leg) {

    }
}
```

Important:

```text
extends   -> Class inherits Class
implements -> Class implements Interface
```

---

# Multiple Interface Inheritance

A class can implement multiple interfaces.

```java
interface Human {
    void haveHand(int hand);
}

interface Dog {
    void havePaw(int paw);
}
```

```java
class Species implements Human, Dog {

}
```

This is Java's way of achieving Multiple Inheritance.

---

# Why Multiple Inheritance Through Classes is Not Allowed?

Not allowed:

```java
class A {

}

class B {

}

class C extends A, B {

}
```

Reason:

```text
Diamond Problem
```

Java cannot decide which parent's implementation to use.

---

# Multiple Inheritance Through Interfaces

Allowed:

```java
interface Human {

}

interface Dog {

}

class Species implements Human, Dog {

}
```

Because interfaces mainly define behavior contracts.

---

# Interface Variables

Example:

```java
interface Human {

    String sing = "human have voice";
}
```

Java automatically converts it to:

```java
public static final String sing =
    "human have voice";
```

So every interface variable is:

* public
* static
* final

---

# Meaning of Public Static Final

## Public

Accessible from anywhere.

```java
System.out.println(Human.sing);
```

---

## Static

Belongs to Interface itself.

No object required.

```java
Human.sing
```

Correct

```java
sp1.sing
```

Wrong style

---

## Final

Cannot be changed.

```java
Human.sing = "new value";
```

Compiler Error

---

# Accessing Interface Variables

```java
System.out.println(Human.sing);
```

Output:

```text
human have voice for easy communication
```

Best Practice:

```java
InterfaceName.variableName
```

---

# Default Methods

Java 8 introduced default methods.

Example:

```java
interface Human {

    default void walk() {
        System.out.println("Human Walking");
    }
}
```

Unlike abstract methods:

```java
void walk();
```

default methods contain a body.

---

# Why Default Methods Were Introduced?

Suppose interface already exists.

```java
interface Human {
    void eat();
}
```

100 classes implement it.

Later we add:

```java
void walk();
```

Now all 100 classes break.

To solve this:

```java
default void walk() {
    System.out.println("Walking");
}
```

Existing classes continue working.

---

# Overriding Default Methods

Your code:

```java
@Override
public void walk() {
    System.out.println("Dog is walking");
}
```

This replaces:

```java
default void walk() {
    System.out.println("he/she is walking");
}
```

Output:

```text
Dog is walking
```

because child implementation has priority.

---

# Important Rule

Abstract Method

```java
void walk();
```

No body.

Must Override.

---

Default Method

```java
default void walk() {
    System.out.println("Walking");
}
```

Has body.

Override is optional.

---

# Understanding Your Code

## Human Interface

```java
interface Human {

    void haveHand(int hand);

    void haveLeg(int leg);

    String sing =
        "human have voice for easy communication";

    default void walk() {
        System.out.println("he/she is walking");
    }
}
```

Contains:

* 2 abstract methods
* 1 constant variable
* 1 default method

---

## Dog Interface

```java
interface Dog {

    void havePaw(int paw);
}
```

Contains:

* 1 abstract method

---

## Species Class

```java
class Species implements Human, Dog
```

Implements:

```text
Human Interface
Dog Interface
```

Therefore it MUST implement:

```java
haveHand()
haveLeg()
havePaw()
```

Otherwise compilation fails.

---

# Why @Override?

Example:

```java
@Override
public void haveHand(int hand)
```

Benefits:

* Compiler checks correctness
* Prevents spelling mistakes
* Improves readability

Example mistake:

```java
public void haveHands(int hand)
```

Without @Override:

No compiler warning.

With @Override:

Compiler Error

---

# Why Methods are Public?

Interface methods are:

```java
public abstract
```

Therefore implementation must be:

```java
public void haveHand(int hand)
```

Not:

```java
void haveHand(int hand)
```

Otherwise:

```text
Cannot reduce visibility of inherited method
```

Compiler Error

---

# Execution Flow of Your Program

```java
Species sp1 = new Species();
```

Object created.

---

```java
sp1.haveHand(4);
```

Output:

```text
this is human extended class
```

---

```java
sp1.haveLeg(2);
```

Output:

```text
this is human leg
```

---

```java
sp1.havePaw(8);
```

Output:

```text
this is paw
```

---

```java
System.out.println(Human.sing);
```

Output:

```text
human have voice for easy communication
```

---

# Final Interview Questions

## Can an interface have variables?

Yes.

```java
String name = "Ram";
```

Automatically:

```java
public static final
```

---

## Can an interface have constructors?

No.

Interfaces cannot create objects.

---

## Can an interface have method bodies?

Yes.

Using:

```java
default
static
private (Java 9+)
```

---

## Can an interface have abstract methods?

Yes.

That is its primary purpose.

---

## Can a class implement multiple interfaces?

Yes.

```java
class Species implements Human, Dog
```

---

## Can interface methods be private?

Abstract methods cannot.

But Java 9+ allows:

```java
private void helperMethod()
```

inside interfaces.

---

## Difference Between Abstract Class and Interface

| Feature              | Abstract Class | Interface  |
| -------------------- | -------------- | ---------- |
| Constructor          | Yes            | No         |
| Instance Variables   | Yes            | No         |
| Multiple Inheritance | No             | Yes        |
| Abstract Methods     | Yes            | Yes        |
| Concrete Methods     | Yes            | Yes        |
| Keyword              | extends        | implements |

---

# Memory Trick

```text
Class + Class
       =
extends

Class + Interface
       =
implements

Interface + Interface
       =
extends
```

Examples:

```java
class Dog extends Animal
```

```java
class Species implements Human
```

```java
interface Human extends LivingThing
```

Remember:

Inheritance between classes -> extends

Using an interface contract -> implements

```
```
# Additional Important Interface Notes

---

# Interface Reference Variables

Just like inheritance, an interface reference can hold the object of a class that implements it.

```java
Human h = new Species();
```

Valid ✅

Because:

```text
Species IS-A Human
```

Example:

```java
Human h = new Species();

h.haveHand(2);
h.haveLeg(2);
```

Output:

```text
this is human extended class
this is human leg
```

---

# Why Can't We Access Dog Methods?

```java
Human h = new Species();

h.havePaw(4);
```

Compiler Error ❌

Reason:

```text
Reference Type = Human
```

The compiler only checks methods available inside the Human interface.

`havePaw()` belongs to Dog, not Human.

---

# Accessing Dog Methods

```java
Species sp = new Species();

sp.havePaw(4);
```

Valid ✅

Because Species contains the method.

---

# Interface Polymorphism

```java
Human h = new Species();

h.haveHand(2);
```

Java allows:

```text
Interface Reference
        ↓
Implementation Object
```

This is called Runtime Polymorphism.

---

# Can We Create Interface Objects?

No ❌

```java
Human h = new Human();
```

Compiler Error

Reason:

```text
Interfaces are incomplete blueprints.
```

They cannot be instantiated.

Correct:

```java
Human h = new Species();
```

---

# Interface Extending Another Interface

An interface can extend another interface.

```java
interface LivingThing {

    void breathe();
}

interface Human extends LivingThing {

    void speak();
}
```

Now Human contains:

```java
breathe();
speak();
```

---

# Interface Inheritance Chain

```text
LivingThing
      ↑
    Human
      ↑
   Species
```

Example:

```java
interface LivingThing {

    void breathe();
}

interface Human extends LivingThing {

    void speak();
}

class Species implements Human {

    public void breathe() {
        System.out.println("Breathing");
    }

    public void speak() {
        System.out.println("Speaking");
    }
}
```

---

# Static Methods in Interface

Java 8 introduced static methods.

```java
interface Human {

    static void info() {
        System.out.println("Human Interface");
    }
}
```

Call using:

```java
Human.info();
```

Output:

```text
Human Interface
```

---

# Wrong Way to Call Static Methods

```java
Species sp = new Species();

sp.info();
```

Compiler Error ❌

Static interface methods belong to the interface, not the object.

Correct:

```java
Human.info();
```

---

# Private Methods in Interface (Java 9+)

Interfaces can contain private methods.

```java
interface Human {

    private void helper() {
        System.out.println("Helper Method");
    }
}
```

Used internally by default and static methods.

Cannot be accessed outside the interface.

---

# Functional Interface

A Functional Interface contains exactly one abstract method.

```java
@FunctionalInterface
interface Human {

    void speak();
}
```

Valid ✅

---

# Invalid Functional Interface

```java
@FunctionalInterface
interface Human {

    void speak();

    void walk();
}
```

Compiler Error ❌

Because there are two abstract methods.

---

# Why Functional Interfaces Are Important

Used in:

* Lambda Expressions
* Streams API
* Collections Framework
* Multithreading
* Functional Programming

Example:

```java
Human h = () -> {
    System.out.println("Speaking");
};
```

---

# Default Method Conflict

Interview Question 🔥

```java
interface Human {

    default void walk() {
        System.out.println("Human Walking");
    }
}

interface Dog {

    default void walk() {
        System.out.println("Dog Walking");
    }
}
```

Now:

```java
class Species implements Human, Dog {

}
```

Compiler Error ❌

Java doesn't know which walk() method to use.

---

# Resolving Default Method Conflict

Override the method.

```java
class Species implements Human, Dog {

    @Override
    public void walk() {
        System.out.println("Species Walking");
    }
}
```

Now compilation succeeds.

---

# Interface vs Inheritance

## Class Inheritance

```java
class Animal {

}

class Dog extends Animal {

}
```

Relationship:

```text
Dog IS-A Animal
```

---

## Interface Implementation

```java
interface Human {

}

class Species implements Human {

}
```

Relationship:

```text
Species CAN-DO Human Behavior
```

Easy Memory Trick:

```text
extends     → What you ARE

implements  → What you CAN DO
```

Examples:

```text
Dog IS-A Animal

Bird CAN-FLY

Human CAN-WALK
```

---

# Important Compilation Rule

If a class implements an interface:

```java
class Species implements Human
```

Then it must:

## Option 1

Implement all methods.

```java
public void haveHand(int hand) {}

public void haveLeg(int leg) {}
```

---

## Option 2

Become abstract.

```java
abstract class Species implements Human
```

Then implementation can be provided later by child classes.

---

# Ultimate Memory Diagram

```text
                Interface
                     │
       ┌─────────────┼─────────────┐
       │             │             │
 Abstract      Default       Static
 Methods       Methods       Methods
       │             │             │
 Must Override  Optional     Human.info()

------------------------------------------------

Variables Inside Interface

String name = "Ram";

Automatically Becomes:

public static final String name = "Ram";

------------------------------------------------

Object Creation

Human h = new Human();      ❌

Human h = new Species();    ✅

------------------------------------------------

Multiple Inheritance

Class + Class       ❌

Class + Interfaces  ✅

------------------------------------------------

Interface Methods

public abstract

Implementation Must Be:

public void method()

------------------------------------------------

Relationships

Class → Class           extends

Class → Interface       implements

Interface → Interface   extends
```

---

# Most Important Interview One-Liners

```text
Interface methods are public abstract by default.

Interface variables are public static final by default.

Interfaces cannot have constructors.

Interfaces cannot be instantiated.

A class can implement multiple interfaces.

An interface can extend multiple interfaces.

Default methods can be overridden.

Static methods belong to the interface itself.

Private methods are allowed in interfaces from Java 9+.

Functional interfaces contain exactly one abstract method.
```
