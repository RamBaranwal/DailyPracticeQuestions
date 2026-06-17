# Java Access Modifiers & Packages - Complete Notes

# 1. What is an Access Modifier?

Access modifiers control **who can access a class, variable, constructor, or method**.

Java provides:

```java
public
private
protected
default   // no keyword
```

---

# 2. Access Modifier Table

| Modifier  | Same Class | Same Package | Different Package | Different Package (Inheritance) |
| --------- | ---------- | ------------ | ----------------- | ------------------------------- |
| private   | ✅          | ❌            | ❌                 | ❌                               |
| default   | ✅          | ✅            | ❌                 | ❌                               |
| protected | ✅          | ✅            | ❌                 | ✅                               |
| public    | ✅          | ✅            | ✅                 | ✅                               |

---

# 3. Private

Accessible only inside the same class.

```java
class Student {

    private String name;

    void print() {
        System.out.println(name); // Works
    }
}
```

```java
Student s = new Student();
s.name = "Rahul"; // Error
```

### Use Case

Hide data from outside classes.

This is called **Encapsulation**.

---

# 4. Default (Package-Private)

When no access modifier is written.

```java
class Student {
}
```

Equivalent to:

```java
default class Student {
}
```

(default keyword doesn't exist, Java assumes it)

Accessible only inside the same package.

---

## Example

Package:

```java
package college;
```

```java
class Student {
}
```

Another class in same package:

```java
package college;

public class Main {
    Student s = new Student(); // Works
}
```

Different package:

```java
package school;

import college.Student;

Student s = new Student(); // Error
```

---

# 5. Public

Accessible from anywhere.

```java
public class Student {
}
```

Can be used from any package.

```java
import college.Student;

Student s = new Student();
```

---

# 6. Protected

Accessible:

* Same class
* Same package
* Child class in another package

---

## Example

```java
package animal;

public class Animal {

    protected void sound() {
        System.out.println("Sound");
    }
}
```

```java
package dog;

import animal.Animal;

public class Dog extends Animal {

    void test() {
        sound(); // Works
    }
}
```

---

# 7. Access Modifiers Apply To

They can be used on:

### Classes

```java
public class Main {
}
```

### Variables

```java
public String name;
private String email;
```

### Methods

```java
public void show() {
}
```

### Constructors

```java
public Student() {
}
```

Many students forget constructors also have access modifiers.

---

# 8. Public Class vs Public Constructor

These are different things.

```java
public class Main {

    Main() {
    }
}
```

Class is public.

Constructor is default.

---

## Same Package

```java
Main obj = new Main();
```

Works.

---

## Different Package

```java
Main obj = new Main();
```

Error.

Because constructor is not public.

---

## Fix

```java
public class Main {

    public Main() {
    }
}
```

Now it works everywhere.

---

# 9. Public Class vs Public Variable

```java
public class Main {

    String name;
}
```

Class is public.

Variable is default.

---

Different package:

```java
Main obj = new Main();

obj.name = "Rahul";
```

Error.

Because variable is not public.

---

Fix:

```java
public String name;
```

or

```java
private String name;
```

with getter/setter.

---

# 10. Package

Package is a folder-like structure.

Example:

```java
package Oops.Encapsulation.LearnPackage;
```

Folder must match package.

```text
Oops
 └── Encapsulation
      └── LearnPackage
           └── Main.java
```

---

# 11. Package Mismatch Error

Error:

```text
The declared package does not match the expected package
```

Means:

Package statement and folder structure don't match.

---

## Wrong

File:

```text
Main.java
```

Package:

```java
package Oops.Encapsulation.LearnPackage;
```

---

## Correct

```text
Oops
 └── Encapsulation
      └── LearnPackage
           └── Main.java
```

---

# 12. Import

Import allows using classes from another package.

```java
import java.util.Date;
```

Specific class.

---

```java
import java.util.*;
```

All public classes from package.

---

# 13. Import Does NOT Import Non-Public Classes

Package:

```java
public class Main {
}

class Teaching {
}
```

Import:

```java
import package.*;
```

Accessible:

```java
Main
```

Not Accessible:

```java
Teaching
```

Because Teaching is not public.

---

# 14. One Public Class Rule

Students often misunderstand this.

Wrong understanding:

> Only one public class in project.

❌ False

---

Correct rule:

> Only one public class per file.

---

## Wrong

Main.java

```java
public class Main {
}

public class Student {
}
```

Error.

---

## Correct

Main.java

```java
public class Main {
}
```

Student.java

```java
public class Student {
}
```

Works perfectly.

---

# 15. Why Can't I Access Teaching From Another Package?

Example:

```java
public class Main {
}

class Teaching {
}
```

Teaching has default access.

Different package:

```java
import package.Teaching;
```

Error.

Because:

```text
Default = Same Package Only
```

---

# 16. Can Import Bypass Access Modifiers?

No.

Import only tells Java where the class is.

Access modifier decides whether you can use it.

Example:

```java
import package.Teaching;
```

If Teaching is default:

```java
class Teaching {
}
```

Still Error.

---

# 17. Real Project Structure

```text
src
 └── Oops
      └── Encapsulation
           ├── LearnPackage
           │     ├── Main.java
           │     ├── Teaching.java
           │     └── TeachingClass.java
           │
           └── LearnJava
                 └── TeacherJava.java
```

---

# 18. Best Practice

Use:

```java
private
```

for variables.

Provide getters/setters.

Example:

```java
public class Student {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

This is proper Encapsulation.

---

# Quick Revision

### private

```java
private String name;
```

Only same class.

---

### default

```java
String name;
```

Same package only.

---

### protected

```java
protected String name;
```

Same package + child class.

---

### public

```java
public String name;
```

Accessible everywhere.

---

# Interview Question

Q: Can a public class have a private constructor?

Yes.

```java
public class Singleton {

    private Singleton() {
    }
}
```

Used in Singleton Pattern.

---

# Golden Rule

To access something from another package:

1. Class must be public.
2. Constructor must be public.
3. Method must be public.
4. Variable must be public (or use getters/setters).

If any one of them is not accessible, Java will give a compilation error.
