# Java Encapsulation, Data Hiding, Access Modifiers & Packages Notes

# 1. What is Encapsulation?

Encapsulation means:

> Wrapping data (variables) and methods (functions) together into a single unit (class) and controlling access to that data.

Example:

```java
class Student{
    private int age;

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
```

Here:

* `age` is hidden.
* Access is controlled through methods.

---

# 2. What is Data Hiding?

Data Hiding means:

> Preventing direct access to variables from outside the class.

Example:

```java
public class Teacher{

    private String name;

}
```

Outside class:

```java
Teacher t = new Teacher();

t.name = "Roshani";
```

❌ Error

Because:

```java
private String name;
```

can only be accessed inside `Teacher`.

---

# 3. Why Do We Hide Data?

Without Data Hiding:

```java
Student s = new Student();

s.age = -10;
```

Invalid data enters the object.

---

With Data Hiding:

```java
private int age;
```

No one can directly modify it.

Only controlled methods can modify it.

---

# 4. Real Purpose of Encapsulation

Many students think:

```java
private int age;
```

means Encapsulation is complete.

Wrong.

The real purpose is:

```text
Protect object from invalid state.
```

Example:

```java
age = -10;
salary = -5000;
balance = -10000;
```

These values should never exist.

Encapsulation prevents this.

---

# 5. Access Modifiers

Java provides:

```java
public
private
protected
default
```

---

# 6. Access Modifier Table

| Modifier  | Same Class | Same Package | Different Package | Child Class (Different Package) |
| --------- | ---------- | ------------ | ----------------- | ------------------------------- |
| private   | ✅          | ❌            | ❌                 | ❌                               |
| default   | ✅          | ✅            | ❌                 | ❌                               |
| protected | ✅          | ✅            | ❌                 | ✅                               |
| public    | ✅          | ✅            | ✅                 | ✅                               |

---

# 7. Private

Accessible only inside the same class.

```java
class Teacher{

    private String name;

}
```

Only Teacher can use:

```java
name
```

---

# 8. Public

Accessible everywhere.

```java
public String school;
```

Any package can access:

```java
obj.school = "Sunbeam";
```

---

# 9. Default Access

When no modifier is written:

```java
String name;
```

This is called:

```java
default
```

or

```java
package-private
```

Accessible only within the same package.

---

# 10. Protected

Accessible:

* Same class
* Same package
* Child class in another package

Used mainly in inheritance.

---

# 11. Access Modifiers Apply To

Not only variables.

They apply to:

### Classes

```java
public class Student{
}
```

### Variables

```java
private int age;
```

### Methods

```java
public void setAge(){
}
```

### Constructors

```java
public Student(){
}
```

---

# 12. Public Class ≠ Public Constructor

Example:

```java
public class Main{

    Main(){
    }

}
```

Class is public.

Constructor is default.

---

Different package:

```java
Main obj = new Main();
```

❌ Error

Because constructor is not public.

---

Fix:

```java
public Main(){
}
```

---

# 13. Public Class ≠ Public Variable

Example:

```java
public class Main{

    String name;

}
```

Different package:

```java
obj.name = "Rahul";
```

❌ Error

Because variable is default.

---

Fix:

```java
public String name;
```

---

# 14. Packages

Package groups related classes.

Example:

```java
package Oops.EncapsulationUses.LearnEncap;
```

Folder structure:

```text
Oops
 └── EncapsulationUses
      └── LearnEncap
           └── Main.java
```

Package and folder must match.

---

# 15. Package Mismatch Error

Error:

```text
The declared package does not match the expected package
```

Reason:

Package name and folder path are different.

---

# 16. Imports

Import allows classes from another package.

```java
import java.util.Date;
```

Specific class.

---

```java
import java.util.*;
```

All public classes.

---

# 17. Import Does NOT Bypass Access Modifiers

Example:

```java
public class Main{
}

class Teacher{
}
```

Teacher has default access.

---

Different package:

```java
import package.Teacher;
```

❌ Error

Import does not bypass access rules.

---

# 18. One Public Class Rule

Wrong understanding:

```text
Only one public class in project
```

❌ False

---

Correct rule:

```text
Only one public class per file
```

---

Wrong:

```java
public class Main{
}

public class Student{
}
```

inside same file.

❌ Error

---

Correct:

Main.java

```java
public class Main{
}
```

Student.java

```java
public class Student{
}
```

✅ Valid

---

# 19. Encapsulation Example

```java
public class Teacher{

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
```

Usage:

```java
Teacher t = new Teacher();

t.setName("Roshani");

System.out.println(t.getName());
```

---

# 20. Problem with Simple Setter

This allows invalid values:

```java
public void setAge(int age){
    this.age = age;
}
```

---

Example:

```java
s.setAge(-10);
```

Age becomes invalid.

---

# 21. Validation Inside Setter

```java
public void setAge(int age){

    if(age > 0 && age <= 100){
        this.age = age;
    }
    else{
        System.out.println("Invalid Age");
    }
}
```

Now invalid age is rejected.

---

# 22. Constructor Validation

Bad:

```java
public Student(int age){
    this.age = age;
}
```

---

Good:

```java
public Student(int age){

    if(age > 0){
        this.age = age;
    }
    else{
        this.age = 18;
    }
}
```

---

# 23. Best Practice: Exception

```java
public Student(int age){

    if(age <= 0){
        throw new IllegalArgumentException(
            "Age must be positive"
        );
    }

    this.age = age;
}
```

---

# 24. Why Did getAge() Return 0?

Example:

```java
private int age;
```

Java automatically assigns default value.

For int:

```java
age = 0;
```

---

Example:

```java
Student s = new Student();

System.out.println(s.getAge());
```

Output:

```text
0
```

Even though you never assigned 0.

Java assigned it automatically.

---

# 25. Default Values of Instance Variables

| Type    | Default Value |
| ------- | ------------- |
| int     | 0             |
| long    | 0L            |
| float   | 0.0f          |
| double  | 0.0           |
| boolean | false         |
| char    | '\u0000'      |
| String  | null          |
| Object  | null          |

---

# 26. Why Invalid Age Prints 0

Example:

```java
Student s = new Student();

s.setAge(-10);
```

Setter:

```java
if(age > 0){
    this.age = age;
}
else{
    System.out.println("Invalid Age");
}
```

Output:

```text
Invalid Age
```

But age remains:

```java
0
```

because:

* Invalid value was rejected.
* Java's default value is still stored.

Then:

```java
System.out.println(s.getAge());
```

prints:

```text
0
```

---

# 27. Real World Examples of Encapsulation

## Student

Protect age.

```java
private int age;
```

---

## Bank Account

Protect balance.

```java
private double balance;
```

Use:

```java
deposit()
withdraw()
```

instead of direct modification.

---

## Employee

Protect salary.

```java
private double salary;
```

Use:

```java
increaseSalary()
```

instead of:

```java
salary = -10000;
```

---

# Golden Rule

Encapsulation is NOT:

```java
private variable
```

alone.

Encapsulation is:

```java
private variable
+ validation
+ controlled access
```

The object should never enter an invalid state.

That is the real purpose of Data Hiding and Encapsulation.
