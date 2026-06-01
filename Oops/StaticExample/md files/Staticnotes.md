# Java Static Keyword - Revision Notes

## What is `static`?

`static` means the member belongs to the **class** rather than an individual object.

```java
class Human {
    static long population;
}
```

There is only **one copy** of a static variable shared by all objects.

---

# Static vs Non-Static

| Feature         | Static           | Non-Static               |
| --------------- | ---------------- | ------------------------ |
| Belongs To      | Class            | Object                   |
| Memory          | One copy         | Separate copy per object |
| Access          | ClassName.member | object.member            |
| Object Required | No               | Yes                      |

---

## Static Variable Example

```java
class Human {
    static long population;

    Human() {
        population++;
    }
}
```

```java
Human h1 = new Human();
Human h2 = new Human();

System.out.println(Human.population);
```

Output:

```text
2
```

Reason:
Both objects share the same `population` variable.

---

# Accessing Static Members

Preferred:

```java
Human.population
```

Allowed but not recommended:

```java
h1.population
```

Always use:

```java
ClassName.staticMember
```

for better readability.

---

# Static Methods

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

No object is required.

---

# Non-Static Methods

```java
class Test {

    void greet() {
        System.out.println("Hello");
    }

}
```

Call:

```java
Test obj = new Test();
obj.greet();
```

Object is required.

---

# Static Method Calling Static Method

```java
static void fun() {
    greet();
}

static void greet() {
    System.out.println("Hello");
}
```

✔ Valid

Reason:
Static methods can directly access other static methods.

---

# Static Method Calling Non-Static Method

Wrong:

```java
static void fun() {
    greet();
}

void greet() {
    System.out.println("Hello");
}
```

❌ Compilation Error

```text
non-static method cannot be referenced from a static context
```

Reason:
Non-static methods belong to objects.

---

# Correct Way

```java
static void fun() {
    Test obj = new Test();
    obj.greet();
}

void greet() {
    System.out.println("Hello");
}
```

✔ Valid

---

# Why `this` Cannot Be Used in Static Methods

Wrong:

```java
static void fun() {
    System.out.println(this.name);
}
```

❌ Error

Reason:

* `this` refers to the current object.
* Static methods do not belong to any object.

Therefore `this` is unavailable.

---

# Static Method Rules

Static methods CAN access:

```java
static int x;
static void greet() {}
```

Static methods CANNOT directly access:

```java
int age;
void display() {}
```

unless an object is created.

---

# Example Analysis

```java
class StaticFunCall {

    static void fun() {
        StaticFunCall obj = new StaticFunCall();
        obj.greeting();
    }

    static void greeting3() {
        System.out.println("hello naa ji");
    }

    static void fun2() {
        greeting3();
    }

    void greeting() {
        System.out.println("hello haa ji");
    }

    void greeting2() {
        System.out.println("hello ji");
    }
}
```

---

## Method Summary

### fun()

```java
static void fun()
```

Creates an object and calls a non-static method.

Output:

```text
hello haa ji
```

---

### greeting3()

```java
static void greeting3()
```

Static method.

Output:

```text
hello naa ji
```

---

### fun2()

```java
static void fun2()
```

Calls another static method.

Output:

```text
hello naa ji
```

---

### greeting()

```java
void greeting()
```

Non-static method.

Output:

```text
hello haa ji
```

Requires object.

---

### greeting2()

```java
void greeting2()
```

Non-static method.

Output:

```text
hello ji
```

Requires object.

---

# Calling Everything

```java
public static void main(String[] args) {

    fun();

    greeting3();

    fun2();

    StaticFunCall obj = new StaticFunCall();

    obj.greeting();

    obj.greeting2();
}
```

Output:

```text
hello haa ji
hello naa ji
hello naa ji
hello haa ji
hello ji
```

---

# Interview Questions

### Can static methods be overridden?

No.

They are hidden, not overridden.

---

### Can constructors be static?

No.

Constructors belong to objects.

---

### Can static methods access instance variables?

No.

They need an object reference.

---

### How many copies of a static variable exist?

Only one copy per class.

---

### Can we call static methods without creating objects?

Yes.

```java
Math.sqrt(25);
Arrays.sort(arr);
Integer.parseInt("123");
```

---

# Quick Revision

```text
Static Variable -> One copy per class

Instance Variable -> One copy per object

Static Method -> Called using ClassName.method()

Non-Static Method -> Called using object.method()

Static Method -> Can access static members directly

Static Method -> Cannot access non-static members directly

this -> Not allowed inside static methods

Best Practice -> Access static members using ClassName.member
```


## Revision Table

| Method        | Static? | Needs Object? | How to Call                 |
| ------------- | ------- | ------------- | --------------------------- |
| `fun()`       | ✅ Yes   | ❌ No          | `StaticFunCall.fun()`       |
| `fun2()`      | ✅ Yes   | ❌ No          | `StaticFunCall.fun2()`      |
| `greeting3()` | ✅ Yes   | ❌ No          | `StaticFunCall.greeting3()` |
| `greeting()`  | ❌ No    | ✅ Yes         | `obj.greeting()`            |
| `greeting2()` | ❌ No    | ✅ Yes         | `obj.greeting2()`           |

---

## Easy Rule

```text
Static Method     -> ClassName.method()
Non-Static Method -> object.method()
```

---

## Examples

### Calling Static Methods

```java
StaticFunCall.fun();
StaticFunCall.fun2();
StaticFunCall.greeting3();
```

No object is required because these methods belong to the class.

---

### Calling Non-Static Methods

```java
StaticFunCall obj = new StaticFunCall();

obj.greeting();
obj.greeting2();
```

An object is required because these methods belong to an instance of the class.

---

## Quick Memory Trick

```text
static  -> belongs to Class
non-static -> belongs to Object

Class member  -> ClassName.member
Object member -> object.member
```

---

## Most Important Interview Rule

```java
static void fun() {
    greeting3();   // ✅ Static method can call static method

    // greeting(); // ❌ Error
}
```

To call a non-static method from a static method:

```java
static void fun() {
    StaticFunCall obj = new StaticFunCall();
    obj.greeting();   // ✅
}
```
