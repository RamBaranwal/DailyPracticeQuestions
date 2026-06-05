# Inheritance and `super()` in Java

## Classes Used

### Parent Class: `Box`

```java
class Box {
    double height;
    double width;
    double length;

    Box() {
        this.height = -1;
        this.length = -1;
        this.width = -1;
    }

    Box(double side) {
        this.height = side;
        this.length = side;
        this.width = side;
    }

    Box(double height, double length, double width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }
}
```

### Child Class: `BoxWeight`

```java
class BoxWeight extends Box {
    double weight;
}
```

---

# Important Rule

Whenever a child object is created, Java first creates the parent part of the object.

```java
BoxWeight box = new BoxWeight();
```

Execution:

```text
BoxWeight()
   ↓
super()     // inserted automatically by Java
   ↓
Box()
   ↓
Back to BoxWeight()
```

---

# Case 1: Default Constructor

```java
BoxWeight box4 = new BoxWeight();
```

Constructor:

```java
BoxWeight() {
    this.weight = -1;
}
```

Java converts it to:

```java
BoxWeight() {
    super();
    this.weight = -1;
}
```

Parent constructor:

```java
Box() {
    this.height = -1;
    this.length = -1;
    this.width = -1;
}
```

Result:

```text
weight = -1
height = -1
length = -1
width  = -1
```

Output:

```text
-1.0 -1.0 -1.0 -1.0
```

### Learning

If no `super(...)` is written, Java automatically calls `super()`.

---

# Case 2: Using `super(...)`

Constructor:

```java
BoxWeight(double height, double length, double width) {
    super(height, length, width);
}
```

Object creation:

```java
BoxWeight box5 = new BoxWeight(4.5, 5.7, 6.3);
```

Execution:

```text
BoxWeight(...)
      ↓
super(4.5, 5.7, 6.3)
      ↓
Box(height,length,width)
      ↓
height = 4.5
length = 5.7
width  = 6.3
```

Result:

```text
height = 4.5
length = 5.7
width  = 6.3
weight = 0.0
```

Output:

```text
0.0 4.5 5.7 6.3
```

### Learning

`super(...)` allows the parent constructor to initialize its own variables.

Benefits:

* Reuse parent code
* Avoid duplicate assignments
* Easier maintenance
* Cleaner design

---

# Case 3: Without `super(...)`

Constructor:

```java
BoxWeight(double weight,
          double height,
          double length,
          double width) {

    this.height = height;
    this.length = length;
    this.width = width;
    this.weight = weight;
}
```

Object creation:

```java
BoxWeight box6 =
    new BoxWeight(9.0, 8.0, 7.0, 6.0);
```

Execution:

```text
BoxWeight(...)
      ↓
height = 8.0
length = 7.0
width  = 6.0
weight = 9.0
```

Result:

```text
weight = 9.0
height = 8.0
length = 7.0
width  = 6.0
```

Output:

```text
9.0 8.0 7.0 6.0
```

### Learning

Here the child class manually initializes the parent variables.

Advantages:

* Full control over initialization

Disadvantages:

* Code duplication
* If parent constructor changes, child code may also need updates

---

# Difference Between Using and Not Using `super()`

## Using `super()`

```java
super(height, length, width);
```

Parent constructor handles parent variables.

```text
Child
  ↓
Parent Constructor
  ↓
Parent Variables Initialized
```

### Preferred Approach

---

## Not Using `super()`

```java
this.height = height;
this.length = length;
this.width = width;
```

Child manually handles parent variables.

```text
Child
  ↓
Manually Initializes Everything
```

### More code duplication

---

# Why is `super()` Useful?

Suppose later you modify the parent constructor:

```java
Box(double height,
    double length,
    double width) {

    System.out.println("Box Created");

    this.height = height;
    this.length = length;
    this.width = width;
}
```

If child uses:

```java
super(height, length, width);
```

Every child automatically gets the new behavior.

If child manually assigns values:

```java
this.height = height;
this.length = length;
this.width = width;
```

Then the new parent logic is skipped.

---

# Interview Revision

### What is `super()`?

Used to call the parent class constructor or access parent members.

### If we do not write `super()`?

Java automatically inserts:

```java
super();
```

and calls the parent's no-argument constructor.

### Why use `super(...)`?

* Reuse parent initialization logic
* Avoid code duplication
* Better maintainability

### Which is preferred?

```java
super(height, length, width);
```

because the parent should initialize its own data.

### Key Idea

> Parent initializes parent variables.
>
> Child initializes child variables.
>
> `super()` helps achieve this cleanly.
