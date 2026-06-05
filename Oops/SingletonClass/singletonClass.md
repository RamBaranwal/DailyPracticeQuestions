# Singleton Design Pattern - Complete Revision Notes

---

# What is Singleton?

Singleton is a design pattern that ensures:

1. Only ONE object of a class can exist.
2. A global access point is provided to access that object.

Example:

```java
Singleton obj = Singleton.getInstance();
```

No matter how many times `getInstance()` is called, the same object is returned.

---

# Why Do We Need Singleton?

Normally:

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
```

Creates:

```text
Object 1
Object 2
Object 3
```

Sometimes we don't want multiple objects.

Examples:

- Database Connection
- Logger
- Configuration Manager
- Cache Manager
- Printer Manager

In these cases, one shared object is enough.

---

# Structure of Singleton Class

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
```

---

# Understanding Each Line

## 1. Private Constructor

```java
private Singleton() {

}
```

Purpose:

Prevents outside classes from creating objects.

Wrong:

```java
Singleton obj = new Singleton();
```

Compile Error ❌

Because constructor is private.

Why?

If constructor is public:

```java
Singleton a = new Singleton();
Singleton b = new Singleton();
```

Multiple objects would be created.

Singleton rule breaks.

---

## 2. Static Instance Variable

```java
private static Singleton instance;
```

This stores the single object reference.

Normally:

```java
Singleton obj = new Singleton();
```

Here:

```java
Singleton instance;
```

is just another reference variable.

Difference:

`instance` is static.

---

# Why Static?

Without static:

```java
private Singleton instance;
```

Every object would have its own copy.

Example:

```text
obj1.instance
obj2.instance
obj3.instance
```

But Singleton requires one common reference.

Therefore:

```java
private static Singleton instance;
```

Static means:

```text
Belongs to Class
Not to Object
```

Only one copy exists.

---

# Why getInstance() is Static?

Method:

```java
public static Singleton getInstance()
```

Static methods belong to the class.

Can be called using:

```java
Singleton.getInstance();
```

No object required.

---

# What If getInstance() Was Not Static?

Suppose:

```java
public Singleton getInstance()
```

Then:

```java
Singleton obj = new Singleton();
obj.getInstance();
```

would be required.

But:

```java
new Singleton();
```

is impossible because constructor is private.

Therefore:

```java
getInstance()
```

must be static.

---

# Static vs Non-Static

## Non-Static Method

```java
class Student {

    void show() {

    }
}
```

Usage:

```java
Student obj = new Student();
obj.show();
```

Requires object.

---

## Static Method

```java
class Student {

    static void show() {

    }
}
```

Usage:

```java
Student.show();
```

No object required.

---

# Why We Directly Call

```java
Singleton.getInstance();
```

Instead Of

```java
obj.getInstance();
```

Because:

```java
getInstance()
```

is static.

Static members are accessed through class name.

Just like:

```java
Math.sqrt(25);
System.out.println("Hello");
```

No object needed.

---

# First Call Flow

```java
Singleton obj = Singleton.getInstance();
```

Step 1:

```java
instance == null
```

True.

Step 2:

```java
instance = new Singleton();
```

Object created.

Step 3:

```java
return instance;
```

Reference returned.

Memory:

```text
instance
   |
   V

Singleton Object
```

---

# Second Call Flow

```java
Singleton obj2 = Singleton.getInstance();
```

Now:

```java
instance != null
```

Condition fails.

No new object created.

Simply:

```java
return instance;
```

Again.

Memory:

```text
obj
obj2
instance
    |
    V

Singleton Object
```

All references point to same object.

---

# Proof Singleton Works

```java
Singleton obj1 = Singleton.getInstance();
Singleton obj2 = Singleton.getInstance();

System.out.println(obj1 == obj2);
```

Output:

```java
true
```

Because both references store the same address.

---

# Example

```java
class Singleton {

    private static Singleton instance;

    int count = 0;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
```

Main:

```java
public class Main {

    public static void main(String[] args) {

        Singleton obj1 = Singleton.getInstance();

        obj1.count++;

        Singleton obj2 = Singleton.getInstance();

        obj2.count++;

        System.out.println(obj1.count);
        System.out.println(obj2.count);
        System.out.println(obj1 == obj2);
    }
}
```

Output:

```text
2
2
true
```

---

# Real World Uses

## 1. Database Connection

```java
Database db = Database.getInstance();
```

One shared database connection.

---

## 2. Logger

```java
Logger logger = Logger.getInstance();
```

One logger writes all logs.

---

## 3. Configuration Manager

```java
Config config = Config.getInstance();
```

One configuration object.

---

## 4. Cache Manager

```java
Cache cache = Cache.getInstance();
```

One cache shared everywhere.

---

## 5. Printer Manager

```java
PrinterManager manager =
        PrinterManager.getInstance();
```

One printer controller.

---

# Spring Boot and Singleton

When you write:

```java
@Service
public class UserService {

}
```

Spring creates only one object by default.

Whenever:

```java
@Autowired
private UserService userService;
```

is used,

Spring gives the same object.

This is Singleton behavior.

---

# When NOT To Use Singleton

Do NOT use for:

```java
Student
Employee
Customer
Product
Order
```

Because many objects are needed.

Example:

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
```

Each student should be different.

---

# Interview Questions

## Why constructor is private?

To prevent object creation from outside the class.

---

## Why instance variable is static?

To keep only one shared reference.

---

## Why getInstance() is static?

Because no object exists yet to call the method.

---

## Can we create object using new?

No.

Constructor is private.

---

## How many objects are created?

Only one.

---

## What does getInstance() return?

The single existing object reference.

---

# Quick Revision

```text
Singleton Pattern

Goal:
→ Only one object

Private Constructor
→ Prevent outside object creation

Static Instance Variable
→ Store single object reference

Static getInstance()
→ Access object without creating object

First Call
→ Create object

Next Calls
→ Return same object

Uses:
→ Database
→ Logger
→ Cache
→ Config
→ Spring Services

Not Used For:
→ Student
→ Employee
→ Product
→ Customer
```

# Additional Doubts & Deep Understanding

---

# Static Variable Does NOT Mean Object Exists

Many beginners think:

```java
private static Singleton instance;
```

immediately creates a Singleton object.

Wrong ❌

This line only creates a variable that can store a reference to a Singleton object.

Initially:

```text
instance = null
```

because all reference variables receive the default value `null`.

Example:

```java
class Test {
    static String name;
}
```

Initially:

```text
name = null
```

Similarly:

```java
class Singleton {
    private static Singleton instance;
}
```

Initially:

```text
instance = null
```

No object exists yet.

---

# Variable Exists vs Object Exists

These are different things.

```java
private static Singleton instance;
```

creates:

```text
A variable named instance
```

It does NOT create:

```java
new Singleton();
```

Object creation happens only when:

```java
instance = new Singleton();
```

runs.

Memory before object creation:

```text
Method Area
------------------

Singleton Class

instance ----> null
```

Memory after object creation:

```text
Method Area
------------------

instance --------\
                  \
Heap              \
----------------   \
Singleton Object <--
```

---

# Why Is instance Initially Null?

Java gives default values to variables.

Default values:

```text
byte      -> 0
short     -> 0
int       -> 0
long      -> 0

float     -> 0.0
double    -> 0.0

boolean   -> false

reference -> null
```

Since:

```java
Singleton instance;
```

is a reference variable,

Java initializes it as:

```java
instance = null;
```

automatically.

---

# Why Do We Check

```java
if(instance == null)
```

?

Meaning:

```text
Has a Singleton object already been created?
```

If:

```java
instance == null
```

then:

```java
instance = new Singleton();
```

creates the first object.

Otherwise:

```java
return instance;
```

returns the already existing object.

---

# Constructor Access Levels Revision

Many students confuse:

```java
Car() {}
```

with a default constructor.

They are NOT the same thing.

---

## Java Generated Default Constructor

If no constructor is written:

```java
class Car {

}
```

Java automatically generates:

```java
Car() {
    super();
}
```

This is called the Default Constructor.

---

## No-Argument Constructor

If you write:

```java
Car() {

}
```

yourself,

then it is NOT a default constructor.

It is a user-defined no-argument constructor.

---

# Constructor Access Modifiers

## Public Constructor

```java
public Car() {

}
```

Accessible everywhere.

---

## Package-Private Constructor

```java
Car() {

}
```

No modifier.

Accessible only inside the same package.

---

## Protected Constructor

```java
protected Car() {

}
```

Accessible inside the same package and subclasses.

---

## Private Constructor

```java
private Car() {

}
```

Accessible only inside the same class.

Singleton uses this.

---

# Same Object With Multiple References

Creating two objects:

```java
Student s1 = new Student();
Student s2 = new Student();
```

Memory:

```text
s1 ---> Object A

s2 ---> Object B
```

Two different objects.

---

Assigning same object:

```java
Student s1 = new Student();

Student s2 = s1;
```

Memory:

```text
s1 ----\
        \
         ---> Object A
        /
s2 ----/
```

Only one object exists.

Both references point to the same object.

Example:

```java
s1.num = 10;

System.out.println(s2.num);
```

Output:

```text
10
```

because both references point to the same object.

---

# Story Version Of Singleton

Imagine a college.

There must be only one Principal Office.

Normal classes:

```java
Student s1 = new Student();
Student s2 = new Student();
```

create:

```text
Room A
Room B
```

Multiple rooms are allowed.

---

Singleton:

```java
private Singleton() {}
```

locks the builder.

Nobody can create:

```java
new Singleton();
```

from outside.

Instead, everybody must go through:

```java
Singleton.getInstance();
```

First request:

```text
Office exists?
```

No.

Create office.

---

Second request:

```text
Office exists?
```

Yes.

Return existing office.

---

Result:

```text
User1 ----\
           \
            ---> Principal Office
           /
User2 ----/
```

Only one office.

Only one object.

---

# Most Important Singleton Interview Point

Many students think:

```java
Singleton.getInstance();
```

means constructor is never called.

Wrong ❌

Constructor is still called:

```java
private Singleton() {
    System.out.println("Constructor Called");
}
```

But only once.

First call:

```java
Singleton.getInstance();
```

Output:

```text
Constructor Called
```

Second call:

```java
Singleton.getInstance();
```

No constructor execution.

The existing object is returned.

---

# Why getInstance() Must Be Static

Wrong:

```java
public Singleton getInstance()
```

To call it:

```java
Singleton obj = new Singleton();
obj.getInstance();
```

But:

```java
new Singleton();
```

is impossible because the constructor is private.

So we get stuck:

```text
Need object to call getInstance()

Need getInstance() to create object
```

Therefore:

```java
public static Singleton getInstance()
```

is required.

Now:

```java
Singleton.getInstance();
```

can be called directly using the class name.

---

# Why instance Must Be Static

Wrong:

```java
private Singleton instance;
```

Every object would have its own copy.

```text
obj1.instance
obj2.instance
obj3.instance
```

This breaks Singleton.

Correct:

```java
private static Singleton instance;
```

Now only one copy exists in the class.

```text
Singleton Class
       |
       |
   instance
```

All users share the same reference.

---

# One-Line Interview Answer

## Why is getInstance() static?

```text
Because no Singleton object exists initially.
A static method can be called using the class name,
allowing creation and return of the first object.
If it were non-static, an object would be required
to call the method, defeating the purpose of Singleton.
```

---

## Why is instance static?

```text
Because Singleton requires one shared reference
for the entire class. Static variables belong
to the class and only one copy exists.
```
