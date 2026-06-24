# Java Inheritance, Upcasting and Runtime Polymorphism

## Parent and Child Classes

```java
class Box {
    int w;
    int h;
}

class BoxWeight extends Box {
    float weight;
}
```

- `Box` is the Parent Class (Super Class).
- `BoxWeight` is the Child Class (Sub Class).
- Child classes inherit accessible members of the parent class.

---

# Upcasting

```java
Box obj = new BoxWeight();
```

This is called **Upcasting**.

### Meaning

- Reference Type = `Box`
- Actual Object Type = `BoxWeight`

Memory View:

```text
Stack
-----
obj
 |
 v

Heap
----------------------
| w | h | weight |
----------------------
    BoxWeight Object
```

---

# What Can Be Accessed?

```java
Box obj = new BoxWeight();
```

### Allowed

```java
obj.w;
obj.h;
```

Because `w` and `h` are declared in `Box`.

### Not Allowed

```java
obj.weight;
```

Compile Time Error

Reason:

Java checks the **reference type** (`Box`) while accessing variables.

Since `weight` is not declared inside `Box`, it cannot be accessed.

---

# Important Rule

## Variables (Fields)

Variables are resolved using the **Reference Type**.

```java
Box obj = new BoxWeight();
obj.w;
```

Java checks:

```java
Box obj
```

Therefore only members declared in `Box` are visible.

---

## Methods

Overridden methods are resolved using the **Actual Object Type**.

```java
obj.show();
```

Java checks:

```java
new BoxWeight()
```

and executes the overridden method in `BoxWeight`.

---

# Runtime Polymorphism

```java
class Box {
    void show() {
        System.out.println("Box");
    }
}

class BoxWeight extends Box {
    @Override
    void show() {
        System.out.println("BoxWeight");
    }
}
```

```java
Box obj = new BoxWeight();
obj.show();
```

Output:

```text
BoxWeight
```

### Why?

Compile Time:

Java verifies that `show()` exists inside `Box`.

Runtime:

Java checks the actual object:

```java
new BoxWeight()
```

Since `BoxWeight` overrides `show()`, Java executes:

```java
BoxWeight.show();
```

This is called:

- Runtime Polymorphism
- Dynamic Method Dispatch
- Method Overriding

---

# Variables Are Not Polymorphic

```java
class Box {
    int x = 10;
}

class BoxWeight extends Box {
    int x = 20;
}
```

```java
Box obj = new BoxWeight();
System.out.println(obj.x);
```

Output:

```text
10
```

### Why?

Variables are resolved using the reference type.

```java
Box obj
```

Therefore Java uses:

```java
Box.x
```

and ignores `BoxWeight.x`.

---

# Methods vs Variables

| Feature | Decided By |
|----------|-----------|
| Variables (Fields) | Reference Type |
| Overridden Methods | Actual Object Type |

Example:

```java
Box obj = new BoxWeight();
```

```java
obj.x;      // Box.x
obj.show(); // BoxWeight.show()
```

---

# Parent Reference -> Child Object

```java
Box obj = new BoxWeight();
```

Valid

Reason:

Every `BoxWeight` IS-A `Box`.

```text
BoxWeight -> Box
```

A child object can always be stored inside a parent reference.

---

# Child Reference -> Parent Object

```java
BoxWeight obj = new Box();
```

Invalid

Reason:

Every `Box` is NOT a `BoxWeight`.

A parent object cannot be stored inside a child reference.

Compile Time Error:

```text
Type mismatch:
cannot convert from Box to BoxWeight
```

---

# Downcasting

```java
Box obj = new BoxWeight();
```

To access child-specific members:

```java
BoxWeight bw = (BoxWeight) obj;

System.out.println(bw.weight);
```

Output:

```text
8.5
```

### Why?

The actual object is already a `BoxWeight`.

The cast simply tells Java to treat the reference as a `BoxWeight`.

---

# Constructor and super()

```java
class BoxWeight extends Box {

    float weight;

    BoxWeight(int l, int w, int h, float weight) {
        super(l, w, h);
        this.weight = weight;
    }
}
```

### Why use `super()`?

`super(l, w, h)` calls the parent constructor.

The parent constructor initializes its own fields:

```java
class Box {
    private int l;
    int w;
    int h;

    Box(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }
}
```

Benefits:

- Avoids duplicate code.
- Lets the parent initialize its own data.
- Follows constructor chaining.

---

# Why Can't We Access Private Variables?

```java
class Box {
    private int l;
}
```

Inside child class:

```java
this.l = l;
```

Not Allowed

Reason:

`private` members belong only to the class in which they are declared.

However:

```java
super(l, w, h);
```

Works because the parent constructor is allowed to access its own private members.

---

# Memory Rule

Remember:

> Reference Type decides what you can SEE.

> Actual Object Type decides what method actually RUNS.

Example:

```java
Box obj = new BoxWeight();
```

```java
obj.weight; // Not Allowed
obj.show(); // Executes BoxWeight.show()
```

---

# Interview Rule

Fields are bound at Compile Time.

Methods are bound at Runtime.