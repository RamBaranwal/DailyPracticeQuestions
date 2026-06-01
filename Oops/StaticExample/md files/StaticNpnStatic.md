# Java Static vs Non-Static Methods - Notes

## 1. What is an Object?

When you write:

```java
StaticNonStatic funn = new StaticNonStatic();
```

Java creates an object in memory.

```text
funn ----> Object A
```

- `new StaticNonStatic()` creates the object.
- `funn` stores the reference (address) of that object.

---

## 2. What is a Non-Static Method?

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

## 3. What is a Static Method?

Example:

```java
static void fun() {
    System.out.println("Static Method");
}
```

A static method belongs to the class, not an object.

Call it using:

```java
StaticNonStatic.fun();
```

No object is required.

---

## Rule #1

### Non-static methods need an object.

✅ Correct

```java
StaticNonStatic obj = new StaticNonStatic();
obj.greeting();
```

❌ Wrong inside a static method

```java
greeting();
```

Error:

```text
non-static method greeting() cannot be referenced from a static context
```

---

## Rule #2

### Static methods do not need an object.

```java
StaticNonStatic.fun();
```

---

## Understanding `this`

Inside every non-static method, Java automatically provides:

```java
this
```

which means:

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

## Example: Same Object

```java
StaticNonStatic funn = new StaticNonStatic();
funn.fun3();
```

Memory:

```text
funn ----> Object A
```

Execution:

```java
funn.fun3();
```

Inside `fun3()`:

```java
this.greeting();
```

becomes:

```java
ObjectA.greeting();
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

## Example: Different Object

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

Memory before calling:

```text
funn ----> Object A
```

Inside `fun2()`:

```java
StaticNonStatic obj = new StaticNonStatic();
```

creates:

```text
funn ----> Object A
obj  ----> Object B
```

Then:

```java
obj.greeting();
```

runs on Object B.

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

Different object used.

---

# Your Code Analysis

```java
StaticNonStatic funn = new StaticNonStatic();
```

Creates:

```text
funn ----> Object A
```

---

```java
funn.fun2();
```

Object A executes `fun2()`.

Inside:

```java
StaticNonStatic obj = new StaticNonStatic();
obj.greeting();
```

Creates Object B.

```text
funn ----> Object A
obj  ----> Object B
```

Object B executes `greeting()`.

Output:

```text
Hello World
```

---

```java
funn.greeting();
```

Object A executes `greeting()`.

Output:

```text
Hello World
```

---

```java
StaticNonStatic obj = new StaticNonStatic();
```

Creates Object C.

```text
funn ----> Object A
obj  ----> Object C
```

No output because no method is called.

---

## Why Static Methods Cannot Call Non-Static Methods Directly

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
Static method  -> No object available
Non-static method -> Needs an object
```

Java doesn't know which object's `greeting()` should be executed.

---

## Correct Way

```java
static void fun() {
    StaticNonStatic obj = new StaticNonStatic();
    obj.greeting();
}
```

Now Java knows which object to use.

---

# Revision Table

| Method Type | Belongs To | Needs Object? | Has `this`? |
|------------|------------|------------|------------|
| Static | Class | ❌ No | ❌ No |
| Non-static | Object | ✅ Yes | ✅ Yes |

---

| Code | Same Object? |
|--------|--------|
| `greeting();` inside non-static method | ✅ Yes (`this.greeting()`) |
| `this.greeting();` | ✅ Yes |
| `obj.greeting();` | ❌ Uses another object |
| `new StaticNonStatic().greeting();` | ❌ Uses a new object |
| `greeting();` inside static method | ❌ Compile Error |

---

# Golden Rule

Inside a non-static method:

```java
greeting();
```

means:

```java
this.greeting();
```

(Current object)

When you write:

```java
obj.greeting();
```

or

```java
new StaticNonStatic().greeting();
```

you are telling Java:

> Don't use the current object. Use another object instead.