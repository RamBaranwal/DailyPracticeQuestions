# 📘 Chapter 5 : insertLast() - Adding a Node at the End

> **Goal of this chapter**
>
> By the end of this chapter you should understand:
>
> - Why `tail` exists.
> - How insertion at the end works.
> - Why it is O(1).
> - Why we need `tail.next`.
> - What happens internally in memory.
> - What changes if `tail` doesn't exist.
> - Why traversal becomes necessary.

---

# Introduction

Suppose the current Linked List is

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

                              ▲

                              |

                            tail
```

We want to insert

```
50
```

Final result

```
10 ----->20 ----->30 ----->40 ----->50
```

---

# The Code

```java
public void insertLast(int val){

    if(tail == null){
        insertFirst(val);
        return;
    }

    Node n = new Node(val);

    tail.next = n;

    tail = n;

    size++;
}
```

Only five lines.

But internally a lot happens.

Let's execute every line.

---

# Case 1 : Empty List

Current memory

```
head

↓

null


tail

↓

null


size = 0
```

Question

Can we insert at the end?

Yes.

But there is no end.

Because there is no node.

---

# Therefore

We execute

```java
if(tail == null){
    insertFirst(val);
}
```

Question

Why not write another insertion code?

Because

```
Insert at beginning

and

Insert at end
```

are exactly the same when the list is empty.

Result

```
head

 |

 ▼

10

▲

|

tail
```

---

# 🚨 Where I Got Stuck

I thought

```
insertLast()
```

should always contain different logic.

Wrong.

If the list is empty

```
First Node

=

Last Node
```

Therefore

calling

```
insertFirst()
```

is the cleanest solution.

---

# Case 2 : Linked List Already Exists

Current

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

                              ▲

                              |

                            tail
```

Goal

Insert

```
50
```

---

# Line 1

```java
Node n = new Node(50);
```

Memory

```
10 ----->20 ----->30 ----->40

50 -> null
```

Notice

The new node is NOT inside the list.

It is floating separately.

---

# Line 2

```java
tail.next = n;
```

Current

```
tail

↓

40
```

Question

What is

```
40.next
```

currently?

Answer

```
null
```

Java changes

```
40.next

=

Address(Node50)
```

Memory

```
10 ----->20 ----->30 ----->40 ----->50

                                      ▲

                                      |

                                      n
```

Question

Is tail still correct?

No.

Tail still points to

```
40
```

But

```
40
```

is no longer the last node.

---

# Line 3

```java
tail = n;
```

Java copies the address stored in

```
n
```

into

```
tail
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40 ----->50

                                       ▲

                                       |

                                      tail

                                       ▲

                                       |

                                       n
```

Now

Tail correctly points to the last node.

---

# Line 4

```java
size++;
```

Current

```
size = 4
```

After

```
size = 5
```

Done.

---

# Why Doesn't head Change?

Question

Did the first node change?

No.

Current first node

```
10
```

After insertion

Still

```
10
```

Therefore

```
head
```

must remain exactly where it is.

---

# Why tail Changes

Question

Did the last node change?

Yes.

Before

```
40
```

After

```
50
```

Therefore

```
tail
```

must move.

---

# Memory Summary

Before

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

                              ▲

                              |

                            tail
```

After

```
head

 |

 ▼

10 ----->20 ----->30 ----->40 ----->50

                                       ▲

                                       |

                                     tail
```

Notice

No node moved.

Only one pointer changed

```
40.next
```

Then

one reference changed

```
tail
```

---

# Why is this O(1)?

Let's count the operations.

Create node

↓

Change one next pointer

↓

Move tail

↓

Increase size

No loops.

No traversal.

Whether there are

```
5 nodes

or

5 million nodes
```

the work is exactly the same.

Therefore

```
Time Complexity = O(1)
```

---

# What If Tail Didn't Exist?

Suppose

```
tail
```

didn't exist.

Current list

```
head

 |

 ▼

10 ----->20 ----->30 ----->40
```

How do we find the last node?

We don't know.

So we must start from

```
head
```

---

# Code

```java
Node temp = head;

while(temp.next != null){

    temp = temp.next;

}

temp.next = newNode;
```

Question

Why?

Because only the last node has

```
next = null
```

---

# Visualization

Initial

```
temp

↓

10 ----->20 ----->30 ----->40
```

Iteration 1

```
temp

↓

20
```

Iteration 2

```
temp

↓

30
```

Iteration 3

```
temp

↓

40
```

Question

How do we know this is the last node?

Because

```
temp.next

=

null
```

Now execute

```
temp.next = newNode;
```

Result

```
10 ----->20 ----->30 ----->40 ----->50
```

---

# Why is This O(n)?

Suppose

```
10 nodes
```

Need

10 steps.

Suppose

```
100 nodes
```

Need

100 steps.

Suppose

```
1000000 nodes
```

Need

1000000 steps.

Therefore

```
Time Complexity

=

O(n)
```

---

# Comparison

## With Tail

```
Insert

↓

Done
```

Time

```
O(1)
```

---

## Without Tail

```
Start from head

↓

Visit every node

↓

Reach last node

↓

Insert
```

Time

```
O(n)
```

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```
tail.next = n;
```

should be

```
head.next = n;
```

Wrong.

Only the last node should connect to the new node.

The first node has nothing to do with insertion at the end.

---

## Confusion 2

I thought

```
tail = n;
```

creates another node.

Wrong.

It only moves the reference.

---

## Confusion 3

I forgot

```
tail = n;
```

Result

```
tail

↓

40
```

even though

```
50
```

became the last node.

Future insertions failed.

---

## Confusion 4

I thought

```
tail.next = n;
```

would also change

```
head.
```

Wrong.

Changing one reference never changes another reference.

---

## Confusion 5

I wondered

"Why do we even store tail?"

Answer

Without tail

every insertion at the end requires traversing the entire list.

---

# Edge Cases

## Empty List

```
head = null

tail = null
```

Call

```
insertFirst()
```

---

## One Node

Before

```
head

↓

10

↑

tail
```

Insert

```
20
```

After

```
10 ----->20

            ▲

            |

          tail
```

---

## Multiple Nodes

Before

```
10 ->20 ->30
```

After

```
10 ->20 ->30 ->40
```

Head never changes.

Tail always changes.

---

# Interview Questions

### Q1

Why is insertion at the end O(1) when we have a tail?

Because we already know where the last node is.

---

### Q2

Why doesn't head move?

Because the first node never changes.

---

### Q3

Can we insert at the end without a tail?

Yes.

But we must traverse the entire list.

Time becomes O(n).

---

### Q4

Why do we call insertFirst() when the list is empty?

Because in an empty list

the first node is also the last node.

---

# Summary

✔ New node is created separately.

✔ `tail.next` connects the old last node to the new node.

✔ `tail = n` moves the tail reference.

✔ `head` never changes.

✔ `size++` updates the count.

✔ With tail → O(1)

✔ Without tail → O(n)

---

# Self Test

1. Why does `insertLast()` call `insertFirst()` when the list is empty?
2. Why doesn't `head` change?
3. Why must `tail` change?
4. What happens if you forget `tail = n`?
5. Why is insertion without `tail` O(n)?
6. Why does only the last node have `next == null`?

If you can answer all six confidently, you've mastered insertion at the end.