# Java Static Nested Class and Inner Class Notes

# What is a Nested Class?

A class declared inside another class is called a Nested Class.

```java
class Outer {

    class Inner {

    }
}
```

Hierarchy:

```text
Outer
  │
  └── Inner
```

---

# Types of Nested Classes

Java has two main types:

```text
Nested Class
    │
    ├── Static Nested Class
    │
    └── Non-Static Inner Class
```

Example:

```java
public class InnerClass {

    static class PlayStation {

    }

    class Toy {

    }
}
```

---

# Static Nested Class

A nested class declared with the `static` keyword.

Example:

```java
class Outer {

    static class PlayStation {

    }
}
```

---

# Why Static Nested Class Exists?

A static nested class belongs to the Outer Class itself.

It does NOT belong to an object of the Outer Class.

Think:

```text
Outer Class
     │
     └── Static Nested Class
```

The nested class can exist without creating an Outer object.

---

# Creating Object of Static Nested Class

Example:

```java
public class InnerClass {

    static class PlayStation {

    }

    public static void main(String[] args) {

        PlayStation obj =
                new PlayStation();
    }
}
```

Valid ✅

Because you are inside the same outer class.

---

# Fully Qualified Syntax

```java
InnerClass.PlayStation obj =
        new InnerClass.PlayStation();
```

Also Valid ✅

This is the complete path.

---

# In Your Code

```java
PlayStation obj =
        new PlayStation();

PlayStation obj2 =
        new InnerClass.PlayStation();
```

Both are valid.

Reason:

```text
Both create PlayStation objects.
```

The second version simply shows the full path.

---

# Memory Representation

```text
InnerClass
    │
    └── PlayStation
```

Object Creation:

```java
new InnerClass.PlayStation();
```

Java directly creates the PlayStation object.

No Outer object required.

---

# Why No Outer Object is Needed?

Because:

```java
static class PlayStation {

}
```

Static members belong to the class itself.

Just like:

```java
static int count;
```

can be accessed without creating an object.

Similarly:

```java
static class PlayStation
```

can be instantiated without an Outer object.

---

# Non-Static Inner Class

Example:

```java
class Outer {

    class Toy {

    }
}
```

A non-static inner class belongs to an object of the outer class.

---

# Why Outer Object is Required?

Because every Toy object is attached to an Outer object.

Think:

```text
Outer Object
      │
      └── Toy Object
```

A Toy cannot exist independently.

---

# Wrong Way

```java
Toy t = new Toy();
```

Compiler Error ❌

Reason:

```text
Toy needs an Outer object.
```

---

# Correct Way

```java
InnerClass outer =
        new InnerClass();

Toy t =
        outer.new Toy();
```

Valid ✅

---

# Understanding This Syntax

```java
outer.new Toy();
```

Read as:

```text
Create a Toy object
inside the Outer object.
```

---

# Memory Representation

```text
obj3 (InnerClass Object)
           │
           └── t1 (Toy Object)
```

The Toy object is linked to the Outer object.

---

# Complete Analysis of Your Code

```java
public class InnerClass {

    static class PlayStation{
        int price;
    }

    class Toy{
        int price;
    }

    public static void main(String[] args) {

        PlayStation obj =
                new PlayStation();

        PlayStation obj2 =
                new InnerClass.PlayStation();

        obj.price = 10;

        obj2.price = 30;

        InnerClass obj3 =
                new InnerClass();

        Toy t1 =
                obj3.new Toy();

        t1.price = 40;
    }
}
```

---

# Execution Flow

Step 1

```java
PlayStation obj =
        new PlayStation();
```

Creates PlayStation object.

Memory:

```text
obj
 │
 ▼
PlayStation
price = 0
```

---

Step 2

```java
PlayStation obj2 =
        new InnerClass.PlayStation();
```

Creates another PlayStation object.

Memory:

```text
obj2
 │
 ▼
PlayStation
price = 0
```

---

Step 3

```java
obj.price = 10;
```

Memory:

```text
obj
 │
 ▼
PlayStation
price = 10
```

---

Step 4

```java
obj2.price = 30;
```

Memory:

```text
obj2
 │
 ▼
PlayStation
price = 30
```

---

Step 5

```java
InnerClass obj3 =
        new InnerClass();
```

Creates Outer object.

Memory:

```text
obj3
 │
 ▼
InnerClass Object
```

---

Step 6

```java
Toy t1 =
        obj3.new Toy();
```

Creates Toy object attached to obj3.

Memory:

```text
obj3
 │
 ▼
InnerClass Object
      │
      ▼
      t1
      price = 0
```

---

Step 7

```java
t1.price = 40;
```

Memory:

```text
t1
 │
 ▼
Toy
price = 40
```

---

# Why This Fails?

```java
static class PlayStation {

}
```

Outside any class:

```java
static class PlayStation {

}
```

Compiler Error ❌

Reason:

```text
A top-level class cannot be static.
```

---

# Why?

Static means:

```text
Belongs to another class.
```

A top-level class does not belong to any class.

Therefore:

```java
static class PlayStation {

}
```

is illegal.

---

# Valid Example

```java
class Outer {

    static class PlayStation {

    }
}
```

Because PlayStation belongs to Outer.

---

# Static Nested Class vs Inner Class

| Feature                            | Static Nested Class | Inner Class |
| ---------------------------------- | ------------------- | ----------- |
| Uses static keyword                | Yes                 | No          |
| Needs Outer Object                 | No                  | Yes         |
| Can be created directly            | Yes                 | No          |
| Access Static Members of Outer     | Yes                 | Yes         |
| Access Non-Static Members Directly | No                  | Yes         |
| Memory Efficient                   | More                | Less        |

---

# Interview Questions

## Can a top-level class be static?

No.

```java
static class A {

}
```

Compiler Error.

---

## Can an inner class be static?

Yes.

```java
class Outer {

    static class Inner {

    }
}
```

---

## How do you create a Static Nested Class object?

```java
Outer.Inner obj =
        new Outer.Inner();
```

---

## How do you create an Inner Class object?

```java
Outer outer =
        new Outer();

Outer.Inner obj =
        outer.new Inner();
```

---

# Ultimate Memory Trick

```text
Static Nested Class
       ↓
Belongs to Class
       ↓
No Outer Object Needed

---------------------------------

Inner Class
       ↓
Belongs to Object
       ↓
Outer Object Required
```

Remember:

```java
Outer.Inner obj =
        new Outer.Inner();
```

Static Nested Class ✅

```java
Outer outer =
        new Outer();

Outer.Inner obj =
        outer.new Inner();
```

Non-Static Inner Class ✅

```
```
