# Java Inner Classes & Anonymous Classes - Complete Notes

## 1. Class vs Object

### Class

A class is a blueprint or template.

```java
class Car {
    String name;
}
```

No memory is allocated.

---

### Object

An object is an instance of a class.

```java
Car c = new Car();
```

Memory is allocated and the object is created.

---

## 2. Where Can Objects Be Created?

Objects are not limited to `main()`.

### Inside main()

```java
public static void main(String[] args) {
    Car c = new Car();
}
```

### Inside a Method

```java
void test() {
    Car c = new Car();
}
```

### As an Instance Variable

```java
class Student {
    Car c = new Car();
}
```

### Inside a Constructor

```java
class Student {

    Car c;

    Student() {
        c = new Car();
    }
}
```

---

## 3. main() is Just an Entry Point

`main()` is not the only place where objects can be created.

```java
public static void main(String[] args)
```

is simply where program execution starts.

---

# Nested Classes

A class can be declared inside another class.

```java
class A {

}
```

---

## 4. Member Inner Class

### Syntax

```java
class A {

    class B {

    }
}
```

### Relationship

```text
A
└── B
```

`B` belongs to an object of `A`.

### Object Creation

```java
A outer = new A();

A.B inner = outer.new B();
```

### Why?

Because `B` is non-static.

It needs an object of `A`.

### Example

```java
class A {

    int x = 10;

    class B {

        void show() {
            System.out.println(x);
        }
    }
}
```

```java
A a = new A();

A.B b = a.new B();

b.show();
```

Output:

```text
10
```

---

## 5. Static Nested Class

### Syntax

```java
class A {

    static class C {

    }
}
```

### Object Creation

```java
A.C c = new A.C();
```

### Why?

Static members belong to the class itself.

No object of A is needed.

### Example

```java
class A {

    static int x = 10;

    static class C {

        void show() {
            System.out.println(x);
        }
    }
}
```

---

## 6. Local Inner Class

Declared inside a method.

### Syntax

```java
class A {

    void test() {

        class D {

        }
    }
}
```

### Scope

Only available inside the method where it is declared.

### Valid

```java
void test() {

    class D {}

    D obj = new D();
}
```

### Invalid

```java
void anotherMethod() {

    D obj = new D(); // Error
}
```

---

# Anonymous Classes

## 7. What is an Anonymous Class?

Anonymous = No Name

### Syntax

```java
OuterClass obj = new OuterClass() {

};
```

Java secretly creates:

```java
class HiddenClass extends OuterClass {

}

OuterClass obj = new HiddenClass();
```

---

## 8. Anonymous Class with Method Override

### Parent Class

```java
class OuterClass {

    void call() {
        System.out.println("calling");
    }
}
```

### Anonymous Class

```java
OuterClass obj = new OuterClass() {

    @Override
    void call() {
        System.out.println("new call");
    }
};
```

### Usage

```java
obj.call();
```

Output:

```text
new call
```

---

## 9. Anonymous Class Implementing Interface

### Interface

```java
interface SuperClass {

    void print();
}
```

### Anonymous Implementation

```java
SuperClass obj = new SuperClass() {

    @Override
    public void print() {
        System.out.println("printing");
    }
};
```

Java secretly creates:

```java
class HiddenClass implements SuperClass {

    @Override
    public void print() {
        System.out.println("printing");
    }
}
```

---

## 10. Anonymous Class as Instance Variable

Valid:

```java
public class Main {

    OuterClass obj = new OuterClass() {

    };
}
```

Because it is just another instance variable.

Similar to:

```java
int age = 20;
String name = "Ram";
```

---

## 11. Biggest Confusion: New Method in Anonymous Class

### Code

```java
OuterClass obj = new OuterClass() {

    void sing() {
        System.out.println("singing");
    }
};
```

### Can we do this?

```java
obj.sing();
```

No.

Compiler Error:

```text
The method sing() is undefined for the type OuterClass
```

---

## Why?

Reference type:

```java
OuterClass obj
```

Compiler only checks methods available in `OuterClass`.

### Actual Object

```java
AnonymousClass extends OuterClass
```

### Reference

```java
OuterClass obj
```

Only methods of `OuterClass` are accessible.

---

## Example

```java
class Animal {

    void sound() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    void sound() {
        System.out.println("Bark");
    }

    void run() {
        System.out.println("Running");
    }
}
```

```java
Animal a = new Dog();
```

Allowed:

```java
a.sound();
```

Not Allowed:

```java
a.run();
```

Same concept applies to anonymous classes.

---

## 12. How to Use sing()?

### Option 1: Call it inside an overridden method

```java
OuterClass obj = new OuterClass() {

    void sing() {
        System.out.println("singing");
    }

    @Override
    void call() {
        sing();
    }
};
```

```java
obj.call();
```

Output:

```text
singing
```

---

### Option 2: Declare sing() in Parent Class

```java
class OuterClass {

    void sing() {
        System.out.println("default");
    }
}
```

Override:

```java
OuterClass obj = new OuterClass() {

    @Override
    void sing() {
        System.out.println("anonymous singing");
    }
};
```

Now:

```java
obj.sing();
```

works.

---

# Package Rule

Package name must match folder structure.

### Example

```java
package Oops.Anonymous;
```

Folder:

```text
Oops
└── Anonymous
    └── Main.java
```

Compile:

```bash
javac Oops/Anonymous/Main.java
```

Run:

```bash
java Oops.Anonymous.Main
```

---

# Quick Revision

### Normal Class

```java
Car c = new Car();
```

### Member Inner Class

```java
A a = new A();
A.B b = a.new B();
```

### Static Nested Class

```java
A.C c = new A.C();
```

### Local Inner Class

```java
class D {}
```

Accessible only inside the method.

### Anonymous Class

```java
Parent obj = new Parent() {

};
```

Java secretly creates a hidden subclass and its object immediately.

### Golden Rule

Reference type controls what methods are accessible.

```java
Parent obj = new Child();
```

Only Parent methods are accessible through `obj`.
