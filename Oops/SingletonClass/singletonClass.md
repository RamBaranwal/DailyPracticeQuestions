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