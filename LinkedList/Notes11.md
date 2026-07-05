# 📘 Chapter 9 : delete(index) - Deleting a Node from Any Position

> **Goal of this chapter**
>
> After completing this chapter you should understand:
>
> * How deletion from any position works.
> * Why we stop at `index-1`.
> * How `prev.next = prev.next.next` works.
> * Why the deleted node becomes unreachable.
> * Why `return` is required.
> * Why `size--` is required.
> * Every mistake I made while implementing it.

---

# Our Code

```java
public int delete(int index){

    if(index < 0 || index >= size){
        throw new IndexOutOfBoundsException("Invalid Index");
    }

    if(index == 0){
        return deleteFirst();
    }

    if(index == size-1){
        return deleteLast();
    }

    Node prev = get(index-1);

    int val = prev.next.data;

    prev.next = prev.next.next;

    size--;

    return val;
}
```

---

# First Question

Current List

```
Index

0      1      2      3      4

10 -->20 -->30 -->40 -->50
```

Suppose we execute

```java
delete(2);
```

Question

Which node should disappear?

```
30
```

Final List

```
10 -->20 -->40 -->50
```

---

# First Thought

Many beginners think

> "Go directly to 30."

Wrong.

We do NOT need node 30.

We need

```
20
```

Why?

Because

only node 20 owns

```
20.next
```

And

```
20.next
```

currently points to

```
30
```

Only node 20 can change that pointer.

---

# Rule

To delete node at

```
index
```

we first move to

```
index - 1
```

Exactly the same rule

used during insertion.

---

# Step 1

Current

```
head

 |

 ▼

10 ----->20 ----->30 ----->40 ----->50
```

Execute

```java
Node prev = get(index-1);
```

Since

```
index = 2
```

Java executes

```java
get(1);
```

---

# Internal Execution

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

Need

```
20
```

Loop

```java
temp = temp.next;
```

Now

```
temp

↓

20
```

Loop ends.

Return

```
Node20
```

Now

```
prev

↓

20
```

Memory

```
10 ----->20 ----->30 ----->40 ----->50

          ▲

          |

         prev
```

---

# Step 2

Execute

```java
int val = prev.next.data;
```

Current

```
prev

↓

20
```

Question

What is

```
prev.next
```

?

Answer

```
Node30
```

Java reads

```
30.data
```

Result

```
val = 30
```

Nothing changes.

---

# 🧠 Internal Execution

Java performs

```
Read prev
      ↓
Go to node 20
      ↓
Read next
      ↓
Go to node 30
      ↓
Read data
      ↓
Copy into val
```

---

# Step 3

Now comes the most important line.

```java
prev.next = prev.next.next;
```

This single line is the heart of deletion.

Let's slow it down.

---

# Internal Execution

Current

```
10 ----->20 ----->30 ----->40 ----->50

          ▲

          |

         prev
```

Java first evaluates the RIGHT side.

Remember

Java always evaluates

RIGHT

before

LEFT.

---

### Right Side

```java
prev.next.next
```

Question

Where is

```
prev
```

?

```
20
```

Question

What is

```
20.next
```

?

```
30
```

Question

What is

```
30.next
```

?

```
40
```

Therefore

Java now knows

```
prev.next.next

=

Address(Node40)
```

Nothing has changed yet.

---

### Left Side

Now Java performs the assignment

```java
prev.next = Address(Node40);
```

Question

What changed?

Before

```
20 ----->30
```

After

```
20 ----->40
```

Memory

```
10 ----->20 -------->40 ----->50

30
```

Question

Who points to 30 now?

Nobody.

---

# What Happened to Node 30?

Current

```
30 ----->40
```

still exists.

But

no variable

and

no node

points to it.

Therefore

node 30 becomes

```
Unreachable
```

Java Garbage Collector removes it later.

---

# Visualization

Before

```
20 ----->30 ----->40
```

After

```
20 ------------->40

30 ----->40
```

Notice

Node 30 still knows about 40.

But

nobody knows about node 30.

That makes it useless.

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```
prev.next.next
```

would immediately change

the Linked List.

Wrong.

It only calculates

an address.

Nothing changes

until assignment happens.

---

## Confusion 2

I thought

```
prev.next = prev.next.next;
```

moves node 40.

Wrong.

No node moves.

Only

```
20.next
```

changes.

---

## Confusion 3

I thought

Java deletes node 30.

Wrong.

Java simply makes

30 unreachable.

Garbage Collector removes it later.

---

# The Biggest Bug I Made

My code was

```java
if(index == 0){
    deleteFirst();
}

if(index == size-1){
    deleteLast();
}

Node prev = get(index-1);
```

Question

What happens if

```
index == size-1
```

?

Java executes

```
deleteLast();
```

correctly.

But

then

continues executing

```
get(index-1);
```

Now the list has changed.

Sometimes

```
prev.next
```

becomes

```
null
```

Result

```
NullPointerException
```

---

# Correct Code

```java
if(index==0){
    return deleteFirst();
}

if(index==size-1){
    return deleteLast();
}
```

Question

Why?

Because

once the work is done,

the method should stop.

---

# Another Bug

I forgot

```java
size--;
```

Display still worked.

Later

```
get()

deleteLast()

insert(index)
```

started behaving incorrectly.

Reason

size was wrong.

---

# Edge Cases

## Delete First

```
index==0
```

Call

```
deleteFirst()
```

---

## Delete Last

```
index==size-1
```

Call

```
deleteLast()
```

---

## Delete Middle

Traverse.

Stop at previous node.

Reconnect pointers.

Decrease size.

---

# Time Complexity

Finding previous node

↓

O(n)

Pointer update

↓

O(1)

Overall

```
O(n)
```

---

# Interview Questions

### Q1

Why do we stop at

```
index-1
```

Because

only the previous node

can change

its

```
next
```

pointer.

---

### Q2

Why doesn't Java explicitly delete node 30?

Because Java uses

Garbage Collection.

---

### Q3

Why is

```java
prev.next = prev.next.next;
```

safe?

Because Java evaluates

the entire

right side

before changing

the left side.

---

### Q4

Why is

```
return
```

necessary?

Because

otherwise

the remaining code

continues executing

on an already modified list.

---

# Golden Rules ⭐

Rule 1

Deleting a node

means

disconnecting it.

---

Rule 2

Never forget

```
return
```

after

```
deleteFirst()

deleteLast()
```

---

Rule 3

Always update

```
size--
```

after successful deletion.

---

Rule 4

Java evaluates

RIGHT SIDE

before

LEFT SIDE.

---

Rule 5

Nodes never move.

Pointers change.

---

# Self Test

Without looking above, answer:

1. Why do we stop at `index-1`?
2. How does `prev.next.next` get evaluated?
3. Why does node 30 become unreachable?
4. Why is `return` necessary?
5. Why does forgetting `size--` cause future bugs?
6. Why is deleting from the middle O(n)?

If you can answer all six confidently, you've mastered deletion from any position in a singly linked list.
