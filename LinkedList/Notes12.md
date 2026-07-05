# 📘 Chapter 10 : Understanding `get()` and `find()`

> **Goal of this chapter**
>
> After completing this chapter you should understand:
>
> * Why `get()` returns a `Node`.
> * Why not return an `int`.
> * Why `find()` returns a `Node`.
> * How Java returns object references.
> * How these methods are used by other Linked List operations.
> * The mistakes I made while learning.

---

# Our Methods

```java
public Node get(int index){

    Node temp = head;

    for(int i = 0; i < index; i++){
        temp = temp.next;
    }

    return temp;
}
```

and

```java
public Node find(int value){

    Node temp = head;

    while(temp != null){

        if(temp.data == value){
            return temp;
        }

        temp = temp.next;
    }

    return null;
}
```

These methods look very small.

But they are used throughout the Linked List implementation.

---

# First Question

Suppose the list is

```text id="d0s2z1"
Index

0      1      2      3

10 -->20 -->30 -->40
```

Now execute

```java
Node x = get(2);
```

Question

What should x become?

Answer

```text id="c4g0fj"
Node30
```

Not

```text id="v6nvlr"
30
```

This difference is extremely important.

---

# Step 1

Current memory

```text id="0nm8m5"
head

 |

 ▼

10 ----->20 ----->30 ----->40
```

Execute

```java
Node temp = head;
```

Memory

```text id="cv4ggf"
head

 |

 ▼

10 ----->20 ----->30 ----->40

▲

|

temp
```

---

# Step 2

Loop

```java
temp = temp.next;
```

Iteration 1

```text id="1xikm0"
temp

↓

20
```

Iteration 2

```text id="tdv27v"
temp

↓

30
```

Loop stops.

---

# Step 3

Java executes

```java
return temp;
```

Question

Does Java copy node 30?

Answer

No.

Java copies only the **reference**.

Current

```text id="vprz8l"
temp

↓

30
```

After

```java
Node x = get(2);
```

Memory

```text id="g64q7k"
temp

↓

30

▲

|

x
```

Question

How many nodes exist?

Answer

Still

```text id="i9prm9"
4
```

Question

Did Java create another node?

Answer

No.

It copied only the address.

---

# Why Doesn't get() Return int?

Suppose

```java
public int get(int index)
```

returns

```text id="dpxl9f"
30
```

Now suppose we want

```java
Node secondLast = get(size-2);
```

Can this work?

No.

Because

```java
int
```

cannot be stored inside

```java
Node
```

---

# Why Does deleteLast() Need a Node?

Remember

```java
Node secondLast = get(size-2);

tail = secondLast;

tail.next = null;
```

Question

If

```java
get()
```

returned only

```text id="eqhv3m"
30
```

Could we write

```java
30.next = null;
```

Answer

Impossible.

Numbers do not have

```java
next
```

Only Node objects have

```java
data

next
```

Therefore

we must return

```java
Node
```

instead of

```java
int
```

---

# Visual Comparison

Suppose

```
Node30
```

looks like

```text id="mqqgk5"
+----------------------+
| data = 30            |
| next = Address(40)   |
+----------------------+
```

Returning

```java
int
```

returns only

```text id="zwq1kq"
30
```

Returning

```java
Node
```

returns

```text id="sjazvg"
Entire Object
```

which contains

```text id="gkqtkx"
data

next
```

---

# Analogy

Imagine

A Student object.

```java
class Student{

    String name;

    int age;

}
```

Suppose

```java
Student s;
```

Question

If I return only

```java
name
```

Can I later access

```java
age
```

Answer

No.

If I return

```java
Student
```

I can access

```java
s.name

s.age
```

Exactly the same idea applies to Linked Lists.

---

# Understanding find()

Current list

```text id="awxrtq"
10 -->20 -->30 -->40
```

Execute

```java
Node x = find(30);
```

Traversal

```text id="yte9ur"
10

↓

20

↓

30
```

Match found.

Return

```text id="g86xmp"
Node30
```

Again

Java returns the **reference**,

not a copy of the node.

---

# Why Doesn't find() Return boolean?

Suppose

```java
boolean find(int value)
```

returns

```text id="7kmp0x"
true
```

Question

Can we access

```java
next
```

?

No.

Can we modify the node?

No.

Can we insert after it?

No.

Returning only

```java
true
```

tells us the node exists,

but gives us no access to it.

Returning

```java
Node
```

gives us the entire object.

---

# Example

```java
Node x = find(30);
```

Now

```java
System.out.println(x.data);
```

prints

```text id="rfd6s3"
30
```

You can also access

```java
x.next
```

because

you have the actual node.

---

# Why Return null?

Suppose

```java
find(100)
```

Current list

```text id="1fwczs"
10 -->20 -->30 -->40
```

100 is not found.

Question

What should Java return?

Returning

```java
0
```

is wrong,

because

0 might be valid data.

Returning

```java
-1
```

is also not ideal.

Instead,

Java returns

```java
null
```

Meaning

```text id="rq9bgn"
No Node Exists
```

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```java
get()
```

should return

```java
int
```

Now I know

Linked List operations need the **entire node**,

not just its data.

---

## Confusion 2

I thought

```java
return temp;
```

copies the node.

Wrong.

It copies only the reference.

---

## Confusion 3

I wondered

Why does

```java
find()
```

return

```java
Node
```

instead of

```java
boolean
```

Now I know

Returning the node allows future operations

like insertion,

deletion,

or traversal.

---

## Confusion 4

I thought

```java
null
```

means

"empty data."

Wrong.

It means

"No object."

---

# Internal Execution

Suppose

```java
return temp;
```

Java internally does

```text id="9vx5bh"
Read temp
      ↓
Copy address stored in temp
      ↓
Give that address to the caller
```

Notice

The object is NOT copied.

---

# Time Complexity

Traversal

↓

```text id="xrg7lj"
O(n)
```

Returning reference

↓

```text id="u0cr4p"
O(1)
```

Overall

```text id="n2p5b5"
O(n)
```

---

# Interview Questions

### Q1

Why does

```java
get()
```

return

```java
Node
```

instead of

```java
int
```

Because future operations need access to

both

```java
data

next
```

---

### Q2

Why does

```java
find()
```

return

```java
Node
```

instead of

```java
boolean
```

Because the caller can continue working with the node.

---

### Q3

Does

```java
return temp;
```

copy the node?

No.

It copies only the reference.

---

### Q4

Why do we return

```java
null
```

when the value isn't found?

Because

there is no matching object to return.

---

# Golden Rules ⭐

Rule 1

A Node contains

```text id="26cc4i"
data

+

next
```

Returning only

```java
data
```

loses half the information.

---

Rule 2

Java returns

references,

not object copies.

---

Rule 3

```java
null
```

means

"No object."

It does NOT mean

"Empty value."

---

Rule 4

Whenever future operations need

```java
next
```

always return

```java
Node
```

instead of

```java
int
```

---

# Self Test

1. Why does `get()` return a `Node`?
2. Why can't it return only an `int`?
3. What exactly is copied during `return temp`?
4. Why does `find()` return `Node` instead of `boolean`?
5. Why is `null` returned when a node isn't found?
6. Why is returning the whole object more useful than returning just the data?

If you can answer all six questions confidently, you've understood one of the most important OOP design decisions in your Linked List implementation.
