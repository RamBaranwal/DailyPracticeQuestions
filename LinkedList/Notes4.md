# 📘 Chapter 3B : Why `head = n` Does NOT Create a Loop

> **Goal of this chapter**
>
> By the end of this chapter you will understand:
>
> - How `insertFirst()` works internally.
> - Why `head = n` does NOT create a loop.
> - Why changing `head` never changes `n.next`.
> - What Java executes first.
> - Why references are copied instead of linked.
> - The exact mistake I made while learning.

---

# Our Code

```java
public void insertFirst(int val){

    Node n = new Node(val);

    n.next = head;

    head = n;

}
```

Most beginners understand the code.

Very few understand **what actually happens inside memory.**

This chapter explains that.

---

# Step 0

Initially

```
head

↓

null
```

No nodes exist.

---

# Step 1

Java executes

```java
Node n = new Node(10);
```

Question

What happens?

Many students answer

```
A Linked List is created.
```

Wrong.

Only ONE node is created.

Memory

```
head

↓

null


n

 |

 ▼

+----------------------+
| data = 10            |
| next = null          |
+----------------------+
```

Notice

Question

Can we access this node through head?

Answer

No.

Because

```
head

↓

null
```

Head still doesn't know this node exists.

---

# Step 2

Java executes

```java
n.next = head;
```

This is where most confusion starts.

Current

```
head

↓

null
```

Question

What is the value inside head?

Answer

```
null
```

Therefore Java actually executes

```java
n.next = null;
```

Memory

```
head

↓

null


n

 |

 ▼

+----------------------+
| data = 10            |
| next = null          |
+----------------------+
```

Question

Did anything change?

Not really.

Because next was already null.

---

# Step 3

Java executes

```java
head = n;
```

Question

Does Java move the node?

No.

Question

Does Java copy the node?

No.

Question

What changes?

Only

```
head
```

starts storing the same address that

```
n
```

stores.

Memory

```
head

 |

 ▼

+----------------------+
| data = 10            |
| next = null          |
+----------------------+

 ▲

 |

 n
```

Notice carefully.

There is still only ONE node.

Two variables point to it.

---

# Rule

```
head = n;
```

copies

the address.

NOT

the object.

---

# Common Misconception

Many beginners imagine

```
head

↓

Node

↑

n
```

or

```
head <------> n
```

This picture is wrong.

Why?

Because

```
head
```

and

```
n
```

are NOT nodes.

They are variables.

Variables never point to each other.

Variables point to objects.

Correct picture

```
head

 |

 ▼

+----------------------+
| data = 10            |
| next = null          |
+----------------------+

 ▲

 |

 n
```

---

# What Happens When List Already Exists?

Suppose current list

```
head

 |

 ▼

10 ----->20 ----->30
```

We insert

```
5
```

---

# Step 1

Java executes

```java
Node n = new Node(5);
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30


n

↓

5 -> null
```

Nothing connected yet.

---

# Step 2

Java executes

```java
n.next = head;
```

Question

What is

```
head
```

currently storing?

Answer

Address of node 10.

Java actually executes

```java
n.next = Address(Node10);
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30


n

 |

 ▼

5 -------------------+

                      |

                      ▼

                     10
```

Notice

The new node now knows where the old first node is.

The list itself has NOT changed yet.

---

# Step 3

Java executes

```java
head = n;
```

Current

```
head

↓

10
```

After assignment

```
head

↓

5
```

Final picture

```
head

 |

 ▼

5 ----->10 ----->20 ----->30

▲

|

n
```

Done.

---

# 🚨 Where I Got Stuck

This was my thought:

```
n.next = head;

head = n;
```

I imagined

```
head

↓

5

↑

|
```

creating a loop.

---

# Why That Thought Is Wrong

Remember

Java executes

```
n.next = head;
```

FIRST.

At that moment

```
head
```

contains

Address of node 10.

So Java copies

Address(Node10)

inside

```
n.next
```

Now

```
n.next
```

will ALWAYS point to node 10

unless we change it explicitly.

Later

Java executes

```
head = n;
```

Question

Will

```
n.next
```

automatically change?

Answer

No.

Because

references are copied.

Not connected.

---

# Very Important Rule

Suppose

Initially

```
head

↓

10
```

Execute

```java
Node x = head;
```

Now

```
x

↓

10

head

↓

10
```

Now execute

```java
head = anotherNode;
```

Question

Will

```
x
```

change?

Answer

No.

Because

```
x
```

already copied the old address.

Exactly the same thing happens in

```java
n.next = head;
```

---

# Example

Suppose

```
head

↓

10
```

Execute

```java
Node a = head;
```

Memory

```
head

↓

10

a

↓

10
```

Now

```java
head = new Node(50);
```

Memory

```
head

↓

50


a

↓

10
```

Question

Did

```
a
```

change?

No.

Exactly.

This is why

```
n.next
```

doesn't change either.

---

# Analogy

Imagine your friend gives you his house address.

You write it in your notebook.

```
Notebook

House 25
```

Later

your friend moves to another city.

Question

Will your notebook automatically update?

No.

Because

your notebook contains a COPY of the old address.

Exactly like

```
n.next = head;
```

The address is copied.

Not linked.

---

# Another Confusion I Had

I thought

```
head = n;
```

changes

```
n.next
```

Wrong.

Changing one reference

never changes another reference.

Unless

I explicitly write

```java
n.next = something;
```

---

# Golden Rules ⭐

Rule 1

```
head

is NOT a node.

It stores an address.
```

Rule 2

```
n

is NOT a node.

It stores an address.
```

Rule 3

```
head = n;

copies the address.
```

Rule 4

Changing

```
head
```

never changes

```
n.next
```

Rule 5

References are copied.

Objects are not.

---

# Interview Question

Q.

Why doesn't

```java
n.next = head;
head = n;
```

create a loop?

Answer

Because

`n.next = head` copies the OLD address stored in `head`.

Later

`head = n`

changes only the variable `head`.

It does not modify the value already stored in `n.next`.

Therefore

```
5 -> 10 -> 20 -> 30
```

is formed.

Not

```
5 -> 5
```

or any loop.

---

# Self Test

Without looking above, answer:

1. How many nodes exist after `Node n = new Node(10);`?
2. Does `head = n` create another node?
3. What is copied in `head = n`?
4. Why doesn't `n.next` change after `head = n`?
5. Why doesn't `insertFirst()` create a loop?
6. If `head` changes later, will `n.next` automatically change?

If you can answer these six questions confidently, you've understood the most confusing part of `insertFirst()`.