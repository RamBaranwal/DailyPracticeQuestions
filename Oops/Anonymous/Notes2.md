# Java Inner Classes, Anonymous Classes & Lambda Expressions - Complete Notes

# 🚀 1 Minute Revision (Quick Look)

## Object Creation

```java
Car c = new Car();
```

Objects can be created:

* Inside `main()`
* Inside methods
* Inside constructors
* As instance variables

---

## Types of Nested Classes

```java
class A {

    class B {}          // Member Inner Class

    static class C {}   // Static Nested Class

    void test() {
        class D {}      // Local Inner Class
    }
}
```

| Type                | Access               |
| ------------------- | -------------------- |
| Member Inner Class  | `A.B b = a.new B();` |
| Static Nested Class | `A.C c = new A.C();` |
| Local Inner Class   | Only inside method   |

---

## Anonymous Class

```java
Parent obj = new Parent() {

};
```

Java secretly creates:

```java
class Hidden extends Parent {

}

Parent obj = new Hidden();
```

---

## Functional Interface

```java
@FunctionalInterface
interface Demo {
    void show();
}
```

Must contain exactly **one abstract method**.

---

## Lambda Expression

```java
Demo d = () -> {
    System.out.println("Hello");
};
```

Equivalent to:

```java
Demo d = new Demo() {
    @Override
    public void show() {
        System.out.println("Hello");
    }
};
```

---

## Golden Rule

Compiler checks:

```java
Parent obj
```

Runtime executes:

```java
Child object
```

Reference type decides what methods are accessible.

---

# Class vs Object

## Class

Blueprint only.

```java
class Car {
    String name;
}
```

No memory allocated.

---

## Object

Real instance.

```java
Car c = new Car();
```

Memory allocated.

---

# Where Can Objects Be Created?

## Inside main()

```java
public static void main(String[] args) {
    Car c = new Car();
}
```

---

## Inside Methods

```java
void test() {
    Car c = new Car();
}
```

---

## Inside Constructor

```java
class Student {

    Car c;

    Student() {
        c = new Car();
    }
}
```

---

## As Instance Variables

```java
class Student {

    Car c = new Car();
}
```

Created automatically when Student object is created.

---

# main() is Not Special

Many students think objects must be created inside `main()`.

Wrong.

`main()` is only the entry point.

Objects can be created anywhere Java allows initialization.

---

# Nested Classes

A class inside another class.

---

# Member Inner Class

```java
class A {

    class B {

    }
}
```

### Creation

```java
A a = new A();

A.B b = a.new B();
```

### Why?

Because B belongs to an object of A.

Think:

```text
House A
 └── Room B
```

Need the house before entering the room.

---

# Static Nested Class

```java
class A {

    static class B {

    }
}
```

### Creation

```java
A.B obj = new A.B();
```

No outer object needed.

### Why?

Because static belongs to the class.

---

# Local Inner Class

```java
class A {

    void test() {

        class D {

        }
    }
}
```

Scope is only inside the method.

---

# Anonymous Classes

## Definition

Class without a name.

```java
OuterClass obj = new OuterClass() {

};
```

---

## What Java Creates Internally

```java
class HiddenClass extends OuterClass {

}

OuterClass obj = new HiddenClass();
```

---

# Anonymous Class Example

```java
OuterClass obj = new OuterClass() {

    void sing() {
        System.out.println("singing");
    }

    @Override
    public void call() {
        System.out.println("not singing");
        sing();
    }
};
```

---

# Why obj.sing() Doesn't Work

Reference type:

```java
OuterClass obj
```

Compiler only sees:

```java
class OuterClass {

    void call() {

    }
}
```

Compiler doesn't know about:

```java
void sing()
```

because sing exists only in the anonymous class.

---

## Valid

```java
obj.call();
```

---

## Invalid

```java
obj.sing();
```

Compile Error.

---

# Why sing() Works Inside call()

```java
@Override
public void call() {
    sing();
}
```

Because both methods belong to the same anonymous class.

Equivalent to:

```java
class HiddenClass extends OuterClass {

    void sing() {

    }

    void call() {
        sing();
    }
}
```

A class can access its own methods.

---

# Interface Anonymous Class

```java
SuperClass obj = new SuperClass() {

    @Override
    public void print() {
        System.out.println("Printing");
    }
};
```

Java secretly creates:

```java
class HiddenClass implements SuperClass {

    @Override
    public void print() {
        System.out.println("Printing");
    }
}
```

---

# Functional Interface

## Definition

An interface containing exactly one abstract method.

```java
@FunctionalInterface
interface SuperClass {

    void print();
}
```

Valid.

---

## Invalid

```java
@FunctionalInterface
interface Test {

    void a();

    void b();
}
```

Two abstract methods.

Compile Error.

---

# Lambda Expression

Your Code

```java
SuperClass obj4 = () -> {

};
```

This is Lambda Syntax.

Equivalent to:

```java
SuperClass obj4 = new SuperClass() {

    @Override
    public void print() {

    }
};
```

---

# Lambda with One Statement

```java
SuperClass obj4 = () ->
    System.out.println("Hello");
```

Equivalent to:

```java
SuperClass obj4 = new SuperClass() {

    @Override
    public void print() {
        System.out.println("Hello");
    }
};
```

---

# Lambda with Parameter

Your Code

```java
SystemIn sysIn = (int walk) -> {
    System.out.println("Walking");
    return walk;
};
```

Equivalent to:

```java
SystemIn sysIn = new SystemIn() {

    @Override
    public int systemIn(int walk) {

        System.out.println("Walking");

        return walk;
    }
};
```

---

# Calling Lambda

```java
int result = m.sysIn.systemIn(10);
```

Execution:

```text
Walking
```

Returns:

```text
10
```

Stored in:

```java
result
```

---

# Why Lambda Works Here

```java
@FunctionalInterface
interface SystemIn {

    int systemIn(int walk);
}
```

Only one abstract method.

Therefore lambda is allowed.

---

# Anonymous Class vs Lambda

| Feature                       | Anonymous Class | Lambda               |
| ----------------------------- | --------------- | -------------------- |
| Extends Class                 | ✅ Yes           | ❌ No                 |
| Implements Interface          | ✅ Yes           | ✅ Yes                |
| Functional Interface Required | ❌ No            | ✅ Yes                |
| Less Code                     | ❌ No            | ✅ Yes                |
| Creates Hidden Class          | ✅ Yes           | Internally optimized |

---

# Memory Trick

### Anonymous Class

```java
Parent obj = new Parent() {

};
```

Think:

```java
class Hidden extends Parent {

}
```

---

### Lambda

```java
Demo d = () -> {

};
```

Think:

```java
Demo d = new Demo() {

    @Override
    public void show() {

    }
};
```

---

# Most Important Interview Concept

Reference Type:

```java
Parent obj
```

Determines:

* What methods can be called
* Compile-time checking

Actual Object:

```java
new Child()
```

Determines:

* Which overridden method executes
* Runtime behavior

This is the foundation of:

* Inheritance
* Polymorphism
* Anonymous Classes
* Interfaces
* Lambda Expressions
