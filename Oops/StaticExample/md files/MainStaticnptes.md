# Java Static Keyword - Quick Revision Notes

## 1. What is `static`?

`static` means the member belongs to the class itself rather than any individual object.

```java
class Human {
    static long population;
}
```

There is only one copy of `population` shared by all objects.

---

## 2. Instance Variable vs Static Variable

### Instance Variable

```java
class Human {
    int age;
}
```

* Belongs to each object.
* Every object gets its own copy.

```java
Human h1 = new Human();
Human h2 = new Human();
```

Memory:

h1.age → separate

h2.age → separate

---

### Static Variable

```java
class Human {
    static long population;
}
```

* Belongs to the class.
* Shared by all objects.
* Only one copy exists.

Memory:

Human.population → one shared variable

---

## 3. Accessing Static Variables

Preferred:

```java
Human.population
```

Allowed but not recommended:

```java
kunal.population
```

Use the class name because the variable belongs to the class.

---

## 4. Example

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

2

---

## 5. Why Population Should Be Static

Wrong:

Each human has its own population count.

Correct:

Population is common to all humans.

```java
static long population;
```

---

## 6. Static Methods

```java
class Test {
    static void greet() {
        System.out.println("Hello");
    }
}
```

Call without creating object:

```java
Test.greet();
```

---

## 7. Rules for Static Methods

### Static method CAN access:

```java
static int a;
```

```java
static void fun() {
    System.out.println(a);
}
```

### Static method CANNOT directly access:

```java
int b;
```

```java
static void fun() {
    System.out.println(b); // Error
}
```

Reason:
Static methods run without any object.

---

## 8. Why `this` Cannot Be Used in Static Methods

```java
static void fun() {
    System.out.println(this.name); // Error
}
```

`this` refers to the current object.

Static methods do not belong to any object.

Therefore `this` is unavailable.

---

## 9. Static Block

Runs once when the class is loaded.

```java
class Test {
    static {
        System.out.println("Static block executed");
    }
}
```

Executed before objects are created.

---

## 10. Interview Questions

Q1. Can static methods be overridden?
→ No (they are hidden, not overridden).

Q2. Can constructors be static?
→ No.

Q3. Can static methods access non-static members?
→ No, not directly.

Q4. How many copies of a static variable exist?
→ Only one per class.

Q5. Can we call a static method without an object?
→ Yes.

```java
Math.sqrt(25);
Arrays.sort(arr);
Integer.parseInt("123");
```

---

## One-Line Revision

Instance Variable → One copy per object

Static Variable → One copy per class

Instance Method → Requires object

Static Method → Can be called using class name

`this` → Not allowed inside static methods

Best Practice → Access static members using ClassName.member
