# 📘 Chapter 8 : `deleteLast()` - Deleting the Last Node

> **Goal of this chapter**
>
> After completing this chapter you should understand:
>
> * Why deleting the last node is harder than inserting.
> * Why `tail` alone is not enough.
> * Why we need the second last node.
> * Why `get(size-2)` is used.
> * Why `tail = tail.next` is wrong.
> * Every pointer movement.
> * The mistakes I made while implementing it.

---

# Our Code

```java
public int deleteLast(){

    if(size <= 1){
        return deleteFirst();
    }

    int val = tail.data;

    Node secondLast = get(size - 2);

    tail = secondLast;

    tail.next = null;

    size--;

    return val;
}
```

Many beginners understand **insertLast()** quickly.

But **deleteLast()** usually creates confusion.

Let's understand why.

---

# First Question

Current list

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

Delete

```
40
```

Expected Result

```
10 ----->20 ----->30
```

Simple.

Right?

Actually...

No.

---

# The Biggest Question

We already have

```
tail

↓

40
```

Question

Can we simply do

```java
tail = tail.next;
```

Let's see.

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

Answer

```
null
```

So

```java
tail = tail.next;
```

becomes

```java
tail = null;
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

tail

↓

null
```

Question

Did we delete 40?

No.

Question

Who still points to 40?

Answer

```
30.next
```

Current

```
30 ----->40
```

Nothing changed.

Therefore

```
tail = tail.next;
```

is completely wrong.

---

# Why Can't We Move Backward?

Question

Current

```
10 ----->20 ----->30 ----->40
```

Suppose

```
tail

↓

40
```

Can tail tell us

who comes before 40?

Answer

No.

Because

every node stores only

```
next
```

There is no

```
previous
```

pointer.

This is why it is called a

**Singly Linked List**.

---

# Important Observation

Current node

```
40
```

knows

```
next = null
```

But it has absolutely no idea

that

```
30
```

points to it.

---

# Therefore

We need to find

```
30
```

ourselves.

That node is called

```
Second Last Node
```

---

# Why size - 2 ?

Current list

```
Index

0      1      2      3

10 -->20 -->30 -->40
```

Current

```
size = 4
```

Last node index

```
size - 1

=

3
```

Second last node index

```
size - 2

=

2
```

Which is

```
30
```

Exactly what we need.

---

# Step 1

```java
Node secondLast = get(size-2);
```

Internally

Java executes

```java
get(2);
```

Let's see what happens.

---

# Internal Execution

Current

```
head

↓

10
```

Create

```java
Node temp = head;
```

Memory

```
temp

↓

10
```

---

Iteration 1

```java
temp = temp.next;
```

Now

```
temp

↓

20
```

---

Iteration 2

```
temp

↓

30
```

Loop ends.

Return

```
Node30
```

---

Memory

```
secondLast

↓

30
```

---

# Current Situation

```
10 ----->20 ----->30 ----->40

                     ▲

                     |

               secondLast


tail

↓

40
```

Now we have both references.

Exactly what we need.

---

# Step 2

```java
tail = secondLast;
```

Question

What changes?

Only

```
tail
```

Current

```
tail

↓

40
```

After assignment

```
tail

↓

30
```

Memory

```
10 ----->20 ----->30 ----->40

                     ▲

                     |

                   tail
```

Question

Did 40 disappear?

No.

Because

```
30.next
```

still points to it.

---

# Step 3

```java
tail.next = null;
```

Current

```
30 ----->40
```

Java changes

```
30.next

=

null
```

Result

```
10 ----->20 ----->30

                     ▲

                     |

                   tail


40
```

Question

Who points to 40 now?

Nobody.

Therefore

40 becomes unreachable.

Garbage Collector will remove it later.

---

# 🧠 Internal Execution

Java executes

```java
tail.next = null;
```

internally like this

```
Read tail
      ↓
Go to node 30
      ↓
Access next field
      ↓
Replace Address(Node40)
with
null
```

Notice

Node 40 never moved.

Only one pointer changed.

---

# Step 4

```java
size--;
```

Current

```
size = 4
```

After

```
size = 3
```

Done.

---

# Final Memory

```
head

 |

 ▼

10 ----->20 ----->30

                     ▲

                     |

                   tail


size = 3
```

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```java
tail = tail.next;
```

would remove the last node.

Wrong.

It only moves the tail reference.

It never changes

```
30.next
```

---

## Confusion 2

I wondered

Why do we need

```java
get(size-2)
```

Answer

Because

only the previous node

can disconnect the last node.

---

## Confusion 3

I thought

Tail should know

the previous node.

Wrong.

A Singly Linked List stores

only

```
next
```

There is no

```
previous
```

---

## Confusion 4

I forgot

```java
size--;
```

The list still displayed correctly.

Later

```
get(size-2)
```

started returning wrong nodes.

---

## Confusion 5

I forgot

```java
if(size<=1)
```

Deleting from a one-node list caused

```
NullPointerException
```

because there is no

second last node.

---

# Why Do We Use deleteFirst() ?

Suppose

```
head

↓

10

▲

|

tail
```

Current

```
size = 1
```

Question

Does

```
size-2
```

exist?

```
1-2

=

-1
```

Impossible.

There is no second last node.

Therefore

we simply call

```java
deleteFirst();
```

because

removing the first node

and removing the last node

are the same operation.

---

# Time Complexity

Finding second last node

↓

```
O(n)
```

Changing pointers

↓

```
O(1)
```

Overall

```
O(n)
```

---

# Interview Questions

### Q1

Why isn't deleteLast() O(1) even though we have tail?

Because

tail doesn't know

the previous node.

---

### Q2

Why do we need the second last node?

Because

only it can disconnect

the last node.

---

### Q3

Why can't we use

```java
tail = tail.next;
```

Because

`tail.next`

is always

```
null
```

for the last node.

---

### Q4

Why do we call

```java
deleteFirst()
```

when size is one?

Because

the first node

is also

the last node.

---

# Golden Rules ⭐

Rule 1

Tail knows

the last node.

It does NOT know

the previous node.

---

Rule 2

Deleting the last node

requires

the second last node.

---

Rule 3

Only the previous node

can disconnect

the last node.

---

Rule 4

Never think

```java
tail = tail.next;
```

deletes the last node.

It doesn't.

---

Rule 5

Whenever

```
size <= 1
```

delegate to

```java
deleteFirst();
```

---

# Self Test

Without looking above, answer:

1. Why can't `tail` delete itself?
2. Why is `tail = tail.next` wrong?
3. Why do we need `get(size-2)`?
4. Why doesn't the last node know the previous node?
5. Why is deleteLast() O(n)?
6. Why do we use `deleteFirst()` when there is only one node?

If you can answer these confidently, you've mastered deleting the last node in a singly linked list.
