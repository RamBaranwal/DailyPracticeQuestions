# 📘 Chapter 4 : `insertFirst()` - Adding a Node at the Beginning

> **Goal of this chapter**
>
> After completing this chapter you should understand:
>
> - How `insertFirst()` works internally.
> - Why every line is written.
> - Why insertion at the beginning is O(1).
> - Why `tail` changes only when the list is empty.
> - Every edge case.
> - The mistakes I made while implementing it.

---

# Code

```java
public void insertFirst(int val){

    Node n = new Node(val);

    n.next = head;

    head = n;

    if(tail == null){
        tail = head;
    }

    size++;
}
```

At first glance it looks like only five lines.

But internally Java performs several operations.

Let's execute each line.

---

# Case 1 : Empty Linked List

Current state

```
head

↓

null


tail

↓

null


size = 0
```

There are no nodes.

---

# Line 1

```java
Node n = new Node(10);
```

Memory

```
head

↓

null


tail

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

Notice carefully.

The node exists.

But it is NOT part of the Linked List.

Why?

Because

```
head
```

still doesn't know where it is.

---

# 🚨 Where I Got Stuck

I used to think

```
new Node(...)
```

means

"The node has been inserted into the list."

Wrong.

It only creates an object.

Until some node points to it,

it is not part of the Linked List.

---

# Line 2

```java
n.next = head;
```

Current

```
head

↓

null
```

Java evaluates

```
head
```

which is

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

Nothing visible changes because `next` was already `null`.

---

# Line 3

```java
head = n;
```

Java copies the address stored in `n` into `head`.

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

Now the Linked List finally exists.

---

# Question

Why didn't we write

```java
head.next = n;
```

Answer

Because

```
head

↓

null
```

There is no node.

Trying to access

```
head.next
```

would cause

```
NullPointerException
```

---

# Line 4

```java
if(tail == null){
    tail = head;
}
```

Current

```
tail

↓

null
```

Since this is the first node,

both head and tail should point to it.

Memory

```
head

 |

 ▼

+----------------------+
| data = 10            |
| next = null          |
+----------------------+

 ▲               ▲

 |               |

 n             tail
```

Question

Why should tail also point here?

Because

the first node is also the last node.

---

# Rule

When the list has exactly one node

```
head == tail
```

Always.

---

# Line 5

```java
size++;
```

Current

```
size = 0
```

After

```
size = 1
```

---

# Final State

```
head

 |

 ▼

10 -> null

▲

|

tail


size = 1
```

Everything is correct.

---

# Case 2 : List Already Contains Nodes

Suppose

```
head

 |

 ▼

20 ----->30 ----->40

                     ▲

                     |

                   tail
```

Now insert

```
10
```

---

# Line 1

```java
Node n = new Node(10);
```

Memory

```
20 ----->30 ----->40

10 -> null
```

The new node is separate.

---

# Line 2

```java
n.next = head;
```

Question

What is inside head?

Answer

Address of node 20.

So Java executes

```
10.next = Address(Node20)
```

Memory

```
20 ----->30 ----->40


10 ----------------+

                   |

                   ▼

                  20
```

The Linked List itself still starts at 20.

---

# Line 3

```java
head = n;
```

Now head changes.

Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

                              ▲

                              |

                            tail
```

Done.

No node moved.

Only references changed.

---

# Why Doesn't Tail Change?

Current

```
10 ----->20 ----->30 ----->40
```

Question

Which node is last?

```
40
```

Did inserting at the beginning change the last node?

No.

Therefore

```
tail
```

should remain on

```
40
```

Changing tail would be incorrect.

---

# Why is this O(1)?

Let's count operations.

```
Create one node

↓

Assign one reference

↓

Assign head

↓

Possibly assign tail

↓

Increase size
```

No loop.

No traversal.

Whether there are

```
1 node

or

1,000,000 nodes
```

the work is exactly the same.

Therefore

```
Time Complexity = O(1)
```

---

# Edge Cases

## Empty List

Before

```
head = null

tail = null
```

After insertion

```
head == tail
```

---

## One Node

Before

```
head

↓

20

↑

tail
```

Insert

```
10
```

After

```
head

↓

10 ----->20

            ▲

            |

          tail
```

Tail does not move.

---

## Multiple Nodes

Before

```
20 ->30 ->40 ->50
```

After

```
10 ->20 ->30 ->40 ->50
```

Again

tail remains unchanged.

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```
new Node()
```

automatically inserts the node.

Wrong.

It only creates an object.

---

## Confusion 2

I thought

```
head = n;
```

creates a loop.

Wrong.

`head` simply copies an address.

---

## Confusion 3

I wondered why

```java
if(tail == null)
```

was needed.

Answer

When the list is empty,

the first node is BOTH

- first node
- last node

Therefore

```
head == tail
```

---

## Confusion 4

I thought

tail should always change.

Wrong.

Tail changes only when

the last node changes.

Inserting at the beginning never changes the last node.

---

## Confusion 5

I forgot

```
size++
```

The Linked List still displayed correctly,

but `size` became incorrect,

causing later operations to fail.

---

# Interview Questions

### Q1. Why is `insertFirst()` O(1)?

Because no traversal is required.

---

### Q2. Why don't we update tail every time?

Because inserting at the beginning does not affect the last node.

---

### Q3. Why do we check

```java
tail == null
```

instead of

```java
head == null
```

Either works here because both are `null` in an empty list. Using `tail` is a design choice since we specifically need to initialize the tail when the first node is added.

---

### Q4. Can we write

```java
head.next = n;
```

when the list is empty?

No.

`head` is `null`, so accessing `head.next` throws a `NullPointerException`.

---

# Quick Revision

```
Create node
      ↓
Connect new node to old head
      ↓
Move head to new node
      ↓
If list was empty
      ↓
Move tail to head
      ↓
Increase size
```

---

# Self Test

Without looking at the notes, answer:

1. Why doesn't `new Node()` insert into the list?
2. Why do we execute `n.next = head` before `head = n`?
3. Why is `tail` updated only for an empty list?
4. Why is `insertFirst()` O(1)?
5. What would happen if you forgot `size++`?
6. What happens if you write `head.next = n` when `head` is `null`?

If you can explain these answers in your own words, you've fully understood `insertFirst()`.