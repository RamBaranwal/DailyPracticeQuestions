# Java Static Nested Class vs Non-Static Inner Class

## Code

```java
class Test{
    String name;

    Test(String name){
        this.name = name;
    }
}

public class StaticInnerClass {

    static class Test{
        String name;

        Test(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {

        Test a = new Test("Kunal");
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
    }
}
```

---

# Two Different Test Classes

This code contains two completely different classes named `Test`.

## Top-Level Class

```java
class Test {
    String name;

    Test(String name) {
        this.name = name;
    }
}
```

This class exists independently.

---

## Static Nested Class

```java
static class Test {
    String name;

    Test(String name) {
        this.name = name;
    }
}
```

This class exists inside `StaticInnerClass`.

---

# Class Structure

```text
Test (Top-Level Class)

StaticInnerClass
    |
    +---- Test (Static Nested Class)
```

These are different classes.

---

# Which Test Is Used Inside main()?

Inside:

```java
public static void main(String[] args) {

    Test a = new Test("Kunal");
    Test b = new Test("Rahul");
}
```

Java first searches inside the current class:

```java
public class StaticInnerClass
```

and finds:

```java
static class Test
```

Therefore Java uses:

```java
StaticInnerClass.Test
```

NOT the outer top-level `Test`.

---

# Java Internally Sees

```java
StaticInnerClass.Test a =
        new StaticInnerClass.Test("Kunal");

StaticInnerClass.Test b =
        new StaticInnerClass.Test("Rahul");
```

---

# Step-by-Step Execution

## Step 1

```java
Test a = new Test("Kunal");
```

Creates:

```text
Object A
---------
name = "Kunal"
```

Memory:

```text
a ----> Object A
```

---

## Step 2

```java
Test b = new Test("Rahul");
```

Creates:

```text
Object B
---------
name = "Rahul"
```

Memory:

```text
b ----> Object B
```

---

## Step 3

```java
System.out.println(a.name);
```

Output:

```text
Kunal
```

---

## Step 4

```java
System.out.println(b.name);
```

Output:

```text
Rahul
```

---

# Final Output

```text
Kunal
Rahul
```

---

# Why Is `static` Important?

Suppose we remove `static`.

```java
class Test {
    String name;

    Test(String name){
        this.name = name;
    }
}
```

Now `Test` becomes a non-static inner class.

Then this code:

```java
Test a = new Test("Kunal");
```

will fail.

---

# Error

```text
No enclosing instance of type StaticInnerClass is accessible
```

Reason:

A non-static inner class always belongs to an object of the outer class.

Java needs to know:

```text
Which StaticInnerClass object owns this Test object?
```

---

# How to Create a Non-Static Inner Class

```java
public class StaticInnerClass {

    class Test {
        String name;

        Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        StaticInnerClass outer =
                new StaticInnerClass();

        Test a = outer.new Test("Kunal");

        System.out.println(a.name);
    }
}
```

Output:

```text
Kunal
```

---

# Memory Diagram

```text
outer ----> StaticInnerClass Object
                |
                +----> Test Object
                          name = "Kunal"
```

The Test object belongs to the outer object.

---

# What Java Secretly Does

For a non-static inner class:

```java
class Test {
}
```

Java internally behaves like:

```java
class Test {

    StaticInnerClass outerReference;

}
```

Every Test object stores a reference to the outer object.

---

# Why Static Nested Class Works

```java
static class Test {
}
```

Static nested classes do NOT store an outer reference.

Memory:

```text
Test Object
-----------
name = "Kunal"
```

No connection to any outer object.

Therefore:

```java
new Test("Kunal");
```

works directly.

---

# Accessing Both Test Classes

Because two Test classes exist:

```java
class Test
```

and

```java
StaticInnerClass.Test
```

you can access them separately:

```java
// Top-level class
Test t1 = new Test("A");

// Static nested class
StaticInnerClass.Test t2 =
        new StaticInnerClass.Test("B");
```

---

# Static Nested Class

```java
static class Test {
}
```

Characteristics:

* Belongs to the class.
* Does not require an outer object.
* Can be created directly.
* Cannot directly access non-static members of the outer class.

Creation:

```java
StaticInnerClass.Test t =
        new StaticInnerClass.Test("Kunal");
```

---

# Non-Static Inner Class

```java
class Test {
}
```

Characteristics:

* Belongs to an object.
* Requires an outer object.
* Can access all members of the outer class.
* Stores a hidden reference to the outer object.

Creation:

```java
StaticInnerClass outer =
        new StaticInnerClass();

StaticInnerClass.Test t =
        outer.new Test("Kunal");
```

---

# Comparison Table

| Feature                                      | Static Nested Class | Non-Static Inner Class |
| -------------------------------------------- | ------------------- | ---------------------- |
| Belongs To                                   | Class               | Object                 |
| Needs Outer Object                           | ❌ No                | ✅ Yes                  |
| Can Access Outer Non-Static Members Directly | ❌ No                | ✅ Yes                  |
| Hidden Outer Reference                       | ❌ No                | ✅ Yes                  |
| Memory Usage                                 | Less                | Slightly More          |

---

# Golden Rule

```text
static class Test
    ↓
No outer object required

class Test
    ↓
Outer object required
```

Remember:

```text
Static Nested Class = Class Level

Non-Static Inner Class = Object Level
```
