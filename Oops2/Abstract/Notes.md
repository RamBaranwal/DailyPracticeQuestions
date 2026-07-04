# Java Abstract Classes, Object Creation & Runtime Polymorphism Notes

---

# 1. Abstract Class

An **abstract class** is a class that **cannot be instantiated (cannot create an object directly)**.

It is mainly used to provide:

- Common variables
- Common methods
- Common constructors
- Abstract methods (methods without implementation)

Example:

```java
abstract class Parent {

    int age;

    Parent(int age){
        this.age = age;
    }

    void career(){
        System.out.println("Doctor");
    }

    abstract boolean haveMarriage(boolean done);
}
```

---

# 2. Abstract Method

An abstract method has

- No body
- Only declaration

Example

```java
abstract boolean haveMarriage(boolean done);
```

It is like saying

> "Every child class must provide its own implementation."

---

# 3. Rules of Abstract Class

## Rule 1

Cannot create object directly.

❌

```java
Parent obj = new Parent();
```

Compile Error

```
Cannot instantiate the type Parent
```

---

## Rule 2

If a child extends an abstract class,

it **must override every abstract method**.

Example

```java
class Son extends Parent{

    Son(int age){
        super(age);
    }

    @Override
    boolean haveMarriage(boolean done){
        return done;
    }
}
```

---

## Rule 3

If the child doesn't override,

then the child itself must become abstract.

```java
abstract class Son extends Parent{

}
```

---

# 4. Constructors in Abstract Class

Abstract classes **can have constructors**.

Example

```java
abstract class Parent{

    Parent(int age){
        this.age = age;
    }

}
```

Even though we cannot create Parent object,

its constructor is used while creating child objects.

Example

```java
Son obj = new Son(20);
```

Execution

```
Son Constructor
        │
        ▼
super(20)
        │
        ▼
Parent Constructor
```

---

# 5. Why super() is Required

Suppose Parent has only

```java
Parent(int age){

}
```

Then

```java
class Son extends Parent{

}
```

gives compile error

```
Implicit super constructor Parent() is undefined.
```

Because Java tries to call

```java
super();
```

which doesn't exist.

Correct

```java
class Son extends Parent{

    Son(int age){
        super(age);
    }

}
```

---

# 6. Object Creation

Syntax

```java
ReferenceType variable = new ObjectType();
```

Example

```java
Parent obj = new Son();
```

Remember

Left Side = Reference Type

Right Side = Actual Object

---

# 7. Example 1

```java
Son obj = new Son(20);
```

Memory

```
obj
 │
 ▼
+--------------------+
| Son Object         |
| age                |
| name               |
| career()           |
| greeting()         |
| haveMarriage()     |
+--------------------+
```

Reference

```
Son
```

Object

```
Son
```

Accessible

```
✔ career()

✔ greeting()

✔ haveMarriage()
```

Reason

Reference and object are same.

---

# 8. Example 2

```java
Parent obj = new Son(20);
```

Memory

```
obj
 │
 ▼
+--------------------+
| Son Object         |
+--------------------+
```

Reference

```
Parent
```

Object

```
Son
```

Accessible

```
✔ career()

✔ haveMarriage()
```

Not Accessible

```
❌ greeting()
```

Reason

Reference type is Parent.

Compiler only checks Parent methods.

---

# 9. Example 3 (Anonymous Class)

```java
Parent obj = new Parent(){

    @Override
    boolean haveMarriage(boolean done){
        return done;
    }

};
```

Java secretly creates

```java
class Anonymous extends Parent{

    @Override
    boolean haveMarriage(boolean done){
        return done;
    }

}
```

Then

```java
Parent obj = new Anonymous();
```

Actually runs.

---

# 10. Example 4 (Anonymous Child Class)

```java
Parent obj = new Son(20){

    @Override
    void greeting(){
        super.greeting();
    }

};
```

Java secretly creates

```java
class AnonymousSon extends Son{

    AnonymousSon(){
        super(20);
    }

    @Override
    void greeting(){
        super.greeting();
    }

}
```

Then

```java
Parent obj = new AnonymousSon();
```

---

# 11. Compile Time vs Runtime

This is the most important concept.

## Compile Time

Compiler checks

```
Reference Type
```

## Runtime

JVM checks

```
Actual Object
```

Example

```java
Parent obj = new Son();

obj.career();
```

Compile Time

```
Does Parent have career()?

YES
```

Runtime

```
Object is Son

Run Son's overridden version.
```

---

# 12. Dynamic Method Dispatch

Suppose

```java
class Parent{

    void career(){
        System.out.println("Doctor");
    }

}
```

Child

```java
class Son extends Parent{

    @Override
    void career(){
        System.out.println("Software Engineer");
    }

}
```

Now

```java
Parent obj = new Son();

obj.career();
```

Output

```
Software Engineer
```

Why?

Because object is Son.

---

# 13. Why greeting() Doesn't Work

Example

```java
Parent obj = new Son();

obj.greeting();
```

Compile Error

```
Cannot find symbol

greeting()
```

Reason

Compiler only knows

```
Parent
```

Parent doesn't contain greeting().

Runtime never starts.

---

# 14. Accessing Child Methods

Use Child Reference

```java
Son obj = new Son();

obj.greeting();
```

or Downcasting

```java
Parent obj = new Son();

((Son)obj).greeting();
```

---

# 15. Upcasting

Child object stored inside Parent reference.

```java
Parent obj = new Son();
```

Diagram

```
Reference
Parent
   │
   ▼
Son Object
```

Advantages

- Runtime polymorphism
- Loose coupling
- Flexibility

---

# 16. Downcasting

Converting Parent reference back into Child.

```java
Parent obj = new Son();

Son s = (Son)obj;
```

Now

```java
s.greeting();
```

works.

---

# 17. Wrong Downcasting

```java
Parent obj = new Parent(){

    @Override
    boolean haveMarriage(boolean done){
        return done;
    }

};

Son s = (Son)obj;
```

Compiles

But Runtime

```
ClassCastException
```

Because object isn't Son.

---

# 18. instanceof

Before downcasting

```java
if(obj instanceof Son){

    Son s = (Son)obj;

}
```

Prevents

```
ClassCastException
```

---

# 19. Compile Time Errors

### Example 1

```java
Parent obj = new Parent();
```

```
Cannot instantiate abstract class
```

---

### Example 2

```java
Parent obj = new Son();

obj.greeting();
```

```
Method undefined
```

---

### Example 3

```java
class Son extends Parent{

}
```

```
Must implement abstract method
```

---

### Example 4

```java
int age = "20";
```

```
Type mismatch
```

---

### Example 5

```java
String name = Roshan;
```

```
Roshan cannot be resolved
```

Need

```java
String name = "Roshan";
```

---

# 20. Runtime Errors

### NullPointerException

```java
Son obj = null;

obj.greeting();
```

---

### ArithmeticException

```java
int x = 10 / 0;
```

---

### ArrayIndexOutOfBoundsException

```java
int arr[] = {1,2};

System.out.println(arr[10]);
```

---

### ClassCastException

```java
Parent obj = new Parent(){

    @Override
    boolean haveMarriage(boolean done){
        return done;
    }

};

Son s = (Son)obj;
```

---

# 21. Golden Rules

## Rule 1

```
Left Side

↓

Reference Type

↓

Determines

What methods you can call.
```

---

## Rule 2

```
Right Side

↓

Actual Object

↓

Determines

Which overridden method runs.
```

---

## Rule 3

Compile Time

```
Checks Left Side
```

Runtime

```
Checks Right Side
```

---

## Rule 4

Method Overriding happens at Runtime.

Variable access happens at Compile Time.

Example

```java
Parent obj = new Son();

obj.career();
```

Compiler

```
Parent has career()

✔
```

Runtime

```
Son overrides career()

Run Son's version.
```

---

# Quick Revision Table

| Statement | Compile Time | Runtime |
|-----------|--------------|---------|
| `Parent obj = new Son();` | Checks `Parent` methods | Creates `Son` object |
| `obj.career();` | `career()` exists in `Parent` | Executes `Son`'s overridden method (if overridden) |
| `obj.greeting();` | ❌ Error (`Parent` has no `greeting()`) | Runtime never starts |
| `((Son)obj).greeting();` | Allowed after cast | Executes `Son.greeting()` |
| `new Parent();` | ❌ Compile error | Never runs |
| `(Son)new Parent(){...};` | Compiles | ❌ `ClassCastException` if object isn't a `Son` |

---

# Interview One-Liners

**Q1. Can an abstract class have a constructor?**

Yes. It is called when a child object is created.

---

**Q2. Can we create an object of an abstract class?**

No, unless using an anonymous class that implements all abstract methods.

---

**Q3. What is Upcasting?**

Storing a child object in a parent reference.

```java
Parent obj = new Son();
```

---

**Q4. What is Downcasting?**

Converting a parent reference back to a child reference.

```java
Son s = (Son)obj;
```

---

**Q5. What decides accessible methods?**

The **reference type (left side)**.

---

**Q6. What decides which overridden method executes?**

The **actual object (right side)**.