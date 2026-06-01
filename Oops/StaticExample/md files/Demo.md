# Java Static vs Non-Static Complete Notes

## 1. Object Creation

```java
StaticNonStatic obj = new StaticNonStatic();
```

What happens?

1. Memory is allocated.
2. An object is created.
3. `obj` stores the reference to that object.

Memory:

```text
obj ----> Object A
```

---

# 2. Non-Static Methods

Example:

```java
void greeting() {
    System.out.println("Hello World");
}
```

A non-static method belongs to an object.

To call it:

```java
StaticNonStatic obj = new StaticNonStatic();
obj.greeting();
```

Output:

```text
Hello World
```

---

# 3. Static Methods

Example:

```java
static void fun() {
    System.out.println("Inside fun");
}
```

A static method belongs to the class.

Call it using:

```java
StaticNonStatic.fun();
```

No object required.

---

# 4. Why Static Methods Cannot Directly Call Non-Static Methods

Example:

```java
static void fun() {
    greeting();
}
```

Error:

```text
non-static method greeting() cannot be referenced from a static context
```

Reason:

```text
Static Method -> No object

Non-Static Method -> Needs an object
```

Java does not know which object's `greeting()` should be called.

Correct:

```java
static void fun() {
    StaticNonStatic obj = new StaticNonStatic();
    obj.greeting();
}
```

---

# 5. Understanding `this`

Inside every non-static method:

```java
this
```

means:

```text
Current Object
```

Example:

```java
void fun3() {
    greeting();
}
```

Java internally treats it as:

```java
void fun3() {
    this.greeting();
}
```

---

# 6. Same Object Example

```java
void fun3() {
    greeting();
}
```

Execution:

```java
StaticNonStatic obj = new StaticNonStatic();
obj.fun3();
```

Flow:

```text
Object A
   |
   +--> fun3()
           |
           +--> greeting()
```

Both methods use the same object.

---

# 7. Different Object Example

```java
void fun2() {
    StaticNonStatic obj = new StaticNonStatic();
    obj.greeting();
}
```

Execution:

```java
StaticNonStatic funn = new StaticNonStatic();
funn.fun2();
```

Memory:

```text
funn ----> Object A
obj  ----> Object B
```

Flow:

```text
Object A
   |
   +--> fun2()
            |
            +--> create Object B
                      |
                      +--> greeting()
```

`greeting()` executes on Object B, not Object A.

---

# 8. Object Creation Does Not Cause Errors

This is valid:

```java
StaticNonStatic obj = new StaticNonStatic();
obj.greeting();
```

No error occurs.

Creating objects is normal.

---

# 9. Indirect Recursion and StackOverflowError

Example:

```java
void greeting() {
    fun();
}

static void fun() {
    StaticNonStatic obj = new StaticNonStatic();
    obj.greeting();
}
```

Flow:

```text
greeting()
    |
    -> fun()
          |
          -> greeting()
                |
                -> fun()
                      |
                      -> greeting()
```

This never ends.

Result:

```text
java.lang.StackOverflowError
```

---

# 10. Static Variables

Example:

```java
static int a = 20;
```

Static variables belong to the class.

Only one copy exists.

Memory:

```text
Class Area
-----------
a = 20
```

All objects share it.

---

# 11. Instance Variables

Example:

```java
int age;
```

Each object gets its own copy.

```java
Student s1 = new Student();
Student s2 = new Student();
```

Memory:

```text
s1.age
s2.age
```

Separate copies.

---

# 12. Static Block

Example:

```java
static {
    System.out.println("Static Block Executed");
}
```

Purpose:

* Initialize static data
* Run startup code

Runs automatically.

---

# 13. When Does Static Block Execute?

Runs when the class is loaded.

Example:

```java
class Demo {

    static {
        System.out.println("Static Block");
    }
}
```

First use:

```java
Demo obj = new Demo();
```

Output:

```text
Static Block
```

---

# 14. Why Static Block Runs Only Once

Java loads a class only one time.

Process:

```text
Class Loading
     ↓
Static Variables Initialized
     ↓
Static Blocks Run
     ↓
Class Ready
```

After that:

```java
new Demo();
new Demo();
new Demo();
```

Only objects are created.

The class is already loaded.

Static block does not run again.

---

# 15. Static Variable Initialization

Example:

```java
static int a = 20;
```

Runs once during class loading.

Not every time an object is created.

---

# 16. Constructors

Example:

```java
Demo() {
    System.out.println("Constructor");
}
```

Runs every time an object is created.

Example:

```java
new Demo();
new Demo();
new Demo();
```

Output:

```text
Constructor
Constructor
Constructor
```

---

# 17. Complete Execution Order

Example:

```java
class Demo {

    static int a = 10;

    static {
        System.out.println("Static Block");
    }

    Demo() {
        System.out.println("Constructor");
    }
}
```

Execution:

```java
new Demo();
new Demo();
```

Output:

```text
Static Block
Constructor
Constructor
```

---

# 18. Static Method Calls

All are valid:

```java
Demo.fun();

obj.fun();

fun();
```

Preferred:

```java
Demo.fun();
```

Reason:

Static methods belong to the class.

---

# 19. Why obj.fun() Works

Example:

```java
obj.fun();
```

Java internally treats it as:

```java
Demo.fun();
```

The object reference is ignored.

Even this works:

```java
Demo obj = null;
obj.fun();
```

Because static methods belong to the class.

---

# 20. Why a and b Do Not Reset

Example:

```java
static int a = 20;
static int b = 60;
```

After:

```java
a = 25;
b = 180;
```

Creating another object:

```java
new Demo();
```

does NOT change them.

Reason:

Static variables belong to the class.

Only one copy exists.

---

# 21. Static vs Non-Static Lifecycle

Static:

```text
Class Loading
    ↓
Static Variables
    ↓
Static Blocks
```

Runs once.

---

Non-Static:

```text
Object Creation
      ↓
Constructor
      ↓
Instance Variables
```

Runs for every object.

---

# 22. Memory Diagram

```text
Class Area
------------------
static int a
static int b
static methods
static block
------------------

      ↑ Shared By ↑

obj1
obj2
obj3
```

Only one copy of static members.

---

# Revision Table

| Feature           | Belongs To     | Runs/Created                         |
| ----------------- | -------------- | ------------------------------------ |
| Static Variable   | Class          | Once                                 |
| Static Block      | Class          | Once                                 |
| Static Method     | Class          | Shared                               |
| Instance Variable | Object         | Per Object                           |
| Constructor       | Object         | Per Object                           |
| Non-Static Method | Object         | Per Object                           |
| this              | Current Object | Available only in non-static methods |

---

# Golden Rule

```text
Static = Class Level

Non-Static = Object Level
```

Remember:

Class Loading (Once)
↓
Static Variables
↓
Static Blocks
↓
main()

Object Creation (Many Times)
↓
Constructors
↓
Instance Variables
↓
Non-Static Methods

```
```
