# 📘 Chapter 2 : Understanding Objects, References and Memory

> **Goal of this chapter**
>
> After completing this chapter you should never again be confused about:
>
> - Why `head` is of type `Node`
> - What `Node next` actually stores
> - Why `head = n` does NOT create a loop
> - Why `temp = temp.next` works
> - What references really are
> - How Java stores objects in memory
> - Why changing one reference doesn't change another

---

# Before Learning Linked List

You must first understand one thing.

A Linked List is **NOT** about nodes.

It is about **references**.

If references are clear,

Linked Lists become very easy.

---

# 1. Primitive Variables

Suppose

```java
int a = 10;
int b = a;
```

Memory

```
a

10


b

10
```

Notice

```
a
```

and

```
b
```

are completely different variables.

Changing

```java
a = 50;
```

does NOT change

```
b
```

because primitive variables copy **values**.

---

# 2. Objects Behave Differently

Suppose

```java
Node first = new Node(10);
```

Memory

```
first

        |

        |

        ▼

+--------------------+
| data = 10          |
| next = null        |
+--------------------+
```

Notice something.

```
first
```

does NOT store

```
10
```

It stores

```
Address of the object.
```

The object lives somewhere in memory.

---

# 3. References are Addresses

Imagine memory addresses.

```
Address 100

+----------------------+
| data = 10            |
| next = null          |
+----------------------+
```

Variable

```
first
```

contains

```
100
```

NOT

```
10
```

---

# 4. Another Variable

Suppose

```java
Node second = first;
```

Many beginners think

Java creates another node.

Wrong.

Memory

```
first

      |

      |

      ▼

+----------------------+
| data = 10            |
| next = null          |
+----------------------+

      ▲

      |

second
```

Only one object exists.

Two variables point to it.

---

# 5. Proof

```java
second.data = 50;
```

Output

```java
System.out.println(first.data);
```

prints

```
50
```

Why?

Because

```
first
```

and

```
second
```

point to the SAME object.

---

# Rule

Objects are NOT copied.

References are copied.

Remember this sentence.

It is the entire foundation of Linked Lists.

---

# 6. Understanding head

Suppose

```java
Node head;
```

Many students imagine

```
head

↓

Node
```

Actually

```
head
```

is only a variable capable of storing

```
Address of a Node.
```

Initially

```
head = null
```

Meaning

```
head

↓

null
```

There is no node yet.

---

# 7. Creating First Node

```java
Node n = new Node(10);
```

Memory

```
head

↓

null


n

        |

        ▼

+----------------+
| data = 10      |
| next = null    |
+----------------+
```

Notice

The list still doesn't exist.

Because

```
head
```

doesn't know about this node.

---

# 8. First Important Assignment

```java
head = n;
```

Memory

```
head

 |

 ▼

+----------------+
| data = 10      |
| next = null    |
+----------------+

 ▲

 |

 n
```

Question

How many nodes exist?

Answer

```
ONE
```

Question

How many references exist?

Answer

```
TWO

head

n
```

---

# 9. Does this Create a Loop?

No.

Many beginners imagine

```
head

↓

Node

↑

n
```

There is no loop.

Why?

Because

```
head

and

n
```

are only variables.

They point to the same object.

Objects never point back automatically.

---

# 10. Another Node

Suppose

```java
Node second = new Node(20);
```

Memory

```
head

 |

 ▼

10

n

 |

 ▼

10


second

 |

 ▼

20
```

Now there are

```
2 objects
```

---

# 11. Connecting Nodes

Execute

```java
n.next = second;
```

Memory

```
head

 |

 ▼

+-------------+
|10|---------+-------------------+
+-------------+                  |
                                 |
                                 ▼

                          +-------------+
                          |20|null      |
                          +-------------+
```

Question

Did second move?

No.

Question

Did first move?

No.

Only

```
next
```

changed.

---

# 12. Why is next of Type Node?

Suppose

```java
Node next;
```

Students ask

Why not

```java
int next;
```

Because

```
next
```

must store

```
Address of another Node.
```

Only

```
Node
```

variables can store Node references.

---

# 13. Understanding

```java
private Node head;
```

Question

Why not

```java
private int head;
```

Because

```
head
```

must store

```
Address of first Node.
```

Not an integer.

---

# 14. Example

```
Student topper;
```

means

```
topper

stores address of Student object.
```

Similarly

```
Node head;
```

means

```
head

stores address of first Node.
```

---

# 15. What Happens Here?

```java
head = second;
```

Current

```
head

↓

10 --->20

second

↓

20
```

After

```java
head = second;
```

Memory

```
head

↓

20


second

↓

20
```

Question

Did node 10 disappear?

No.

Node 10 still exists.

Only

```
head
```

forgot where it was.

Since nobody points to node 10 anymore,

Java's Garbage Collector will eventually remove it.

---

# 16. Biggest Misconception

Changing

```java
head
```

does NOT change

```java
n.next
```

Suppose

```
n.next

↓

20
```

Later

```java
head = anotherNode;
```

Question

Will

```
n.next
```

change?

Answer

No.

References are copied.

Not linked.

---

# 17. Golden Rule

Changing one reference

NEVER changes another reference.

Unless both variables point to the same object.

---

# 18. Memory Exercise

Suppose

```java
Node a = new Node(10);

Node b = a;

Node c = new Node(20);

a.next = c;
```

Draw it yourself.

Answer

```
a

 |

 ▼

10 ------->20

▲

|

b


c

↓

20
```

Question

Objects?

```
2
```

Variables?

```
3
```

---

# 19. Common Mistakes

❌ Thinking references are objects.

❌ Thinking assignment copies objects.

❌ Thinking changing head changes next.

❌ Thinking head owns every node.

❌ Thinking Node next creates another node.

All are incorrect.

---

# Summary

✔ Objects live in memory.

✔ Variables store addresses.

✔ References are copied.

✔ Objects are not copied.

✔ head stores address of first node.

✔ next stores address of next node.

✔ Two variables can point to one object.

✔ Changing one reference never changes another.

---

# Revision Questions

1. What is a reference?

2. Does

```
Node a = b;
```

copy the object or the address?

3. Why is

```
Node next;
```

not

```
int next;
```

4. Can two variables point to one object?

5. Why doesn't

```
head = n;
```

create a loop?

6. What happens to an object when no variable points to it?

7. What is actually stored inside

```
head
```

8. What is actually stored inside

```
next
```
