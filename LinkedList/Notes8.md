# 📘 Chapter 6 : insert(index) - Inserting a Node at Any Position

> **Goal of this chapter**
>
> After this chapter you should understand:
>
> - How to insert at any position.
> - Why we stop at `index - 1`.
> - Why we don't stop at `index`.
> - Why `temp = temp.next` works.
> - Why `new Node(val, temp.next)` works.
> - Why the order of pointer assignments matters.
> - The mistakes I made while learning.

---

# Our Code

```java
public void insert(int val, int index){

    if(index == 0){
        insertFirst(val);
        return;
    }

    if(index == size){
        insertLast(val);
        return;
    }

    Node temp = head;

    for(int i = 1; i < index; i++){
        temp = temp.next;
    }

    Node n = new Node(val,temp.next);

    temp.next = n;

    size++;
}
```

Don't memorize this.

Understand it.

---

# First Question

Suppose the list is

```
Index

0      1      2      3

10 -->20 -->30 -->40
```

We want

```
insert(25,2)
```

Expected result

```
10 -->20 -->25 -->30 -->40
```

Question

Where should the new node go?

Between

```
20

and

30
```

Therefore

we need access to

```
20
```

NOT

```
30
```

---

# Why?

Suppose

```
10 -->20 -->30 -->40
```

Question

Which node's pointer should change?

Should

```
30.next
```

change?

No.

Should

```
20.next
```

change?

YES.

Because

currently

```
20 ------->30
```

must become

```
20 ------->25
```

Therefore

we need

```
20
```

This is why we stop

ONE NODE BEFORE

the insertion point.

---

# Rule

To insert at

```
index
```

we stop at

```
index-1
```

Always remember this.

---

# Step 1

Current list

```
head

 |

 ▼

10 ----->20 ----->30 ----->40
```

Goal

Insert

```
25

at index 2
```

---

# Step 2

```java
Node temp = head;
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

▲

|

temp
```

Question

Have we reached the correct node?

No.

We need

```
20
```

---

# Step 3

Loop

```java
for(int i=1;i<index;i++)
```

Question

Why

```
i = 1
```

?

Because

```
temp
```

already stands on index

```
0
```

Current

```
temp

↓

10
```

Need

```
20
```

Loop executes once.

---

# First Iteration

Java executes

```java
temp = temp.next;
```

Question

What happens internally?

Current

```
temp

↓

10
```

Java asks

```
Node10

Who is your next?
```

Answer

```
Node20
```

Java copies that address into

```
temp
```

Now

```
temp

↓

20
```

Loop ends.

---

# Current Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

          ▲

          |

         temp
```

Exactly where we wanted.

---

# Step 4

Create node

```java
Node n = new Node(25,temp.next);
```

Question

What is

```
temp.next
```

?

Current

```
temp

↓

20
```

Answer

```
Address(Node30)
```

Java first evaluates

```
temp.next
```

Then enters constructor.

Constructor receives

```
25

Address(Node30)
```

New node becomes

```
25 ----->30
```

Current memory

```
10 ----->20 ----->30 ----->40


25 ---------+

             |

             ▼

            30
```

Notice

The new node is NOT inside the Linked List yet.

---

# Step 5

Execute

```java
temp.next = n;
```

Current

```
20 ----->30
```

After assignment

```
20 ----->25 ----->30
```

Final list

```
10 ----->20 ----->25 ----->30 ----->40
```

Done.

---

# Why Does This Work?

Because

before changing

```
20.next
```

we already stored

```
30
```

inside

```
25.next
```

Nothing was lost.

---

# Very Important

Never break

an old connection

before saving it.

---

# Wrong Order

Suppose

```java
temp.next = n;

n.next = temp.next;
```

Current

```
20 ----->30
```

Step 1

```
20 ----->25

30 disconnected
```

Now

```
temp.next

=

25
```

Execute

```java
n.next = temp.next;
```

Means

```
25 ----->25
```

Loop

```
25

▲

|

└────────────
```

Node

```
30
```

is lost.

---

# Why Constructor Version Works

Method 1

```java
Node n = new Node(25);

n.next = temp.next;

temp.next = n;
```

Method 2

```java
Node n = new Node(25,temp.next);

temp.next = n;
```

Question

Difference?

Only style.

Logic is exactly the same.

---

# Why Don't We Stop At index?

Suppose

```
10 -->20 -->30 -->40
```

Want

```
25

before

30
```

If

```
temp

↓

30
```

Can we insert before

```
30
```

No.

Because

we only know

```
30.next
```

We don't know

who points to

```
30
```

Therefore

we stop at

```
20
```

which controls

```
20.next
```

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```
temp

should stop at index.
```

Wrong.

To insert

we need

the previous node.

---

## Confusion 2

I didn't understand

```
temp = temp.next
```

Now I know

nodes never move.

Only temp changes.

---

## Confusion 3

I thought

```
new Node(val,temp.next)
```

copies

```
null.
```

Wrong.

Java evaluates

```
temp.next
```

before entering the constructor.

---

## Confusion 4

I thought

```
head

and

n.next

point to each other.
```

Wrong.

References are copied.

Not linked.

---

## Confusion 5

I wondered

Why not reverse

```
temp.next

and

newNode.next
```

Now I know

the old connection would be lost.

---

# Edge Cases

## Insert at beginning

```
index==0
```

Call

```
insertFirst()
```

---

## Insert at end

```
index==size
```

Call

```
insertLast()
```

---

## Insert in middle

Traverse.

Stop at previous node.

Save old connection.

Connect new node.

---

# Complexity

Traversal

↓

O(n)

Pointer updates

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

we need the previous node's

```
next
```

pointer.

---

### Q2

Why doesn't the new node immediately become part of the list?

Because

nothing points to it yet.

---

### Q3

Why is the constructor version equivalent?

Because

it simply initializes

```
next
```

inside the constructor instead of later.

---

### Q4

What happens if we reverse the pointer assignments?

The remaining Linked List becomes unreachable.

---

# Summary

✔ Stop at previous node.

✔ Never stop at insertion index.

✔ Save old connection first.

✔ Then change previous node's pointer.

✔ Never reverse pointer assignments.

✔ Constructor version and manual version are identical.

---

# Self Test

1. Why do we stop at `index-1`?
2. What does `temp.next` return?
3. Why isn't the new node part of the list immediately?
4. Why must we save the old connection first?
5. Why are both insertion methods equivalent?
6. Why is insertion in the middle `O(n)`?

If you can explain these without looking, you've mastered insertion at an index.