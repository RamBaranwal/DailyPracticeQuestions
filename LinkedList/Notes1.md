# 📘 Chapter 1: Introduction to Linked Lists

> **Goal of this chapter**
>
> By the end of this chapter, you will understand:
>
> - Why Linked Lists exist.
> - Why Arrays are not always the best choice.
> - What a Node is.
> - How Nodes are connected.
> - What `head`, `tail`, and `size` mean.
> - How references (addresses) work.
> - The biggest beginner misconceptions.

---

# 1. Why Do We Need Linked Lists?

Before learning Linked Lists, let's first understand the problem they solve.

Suppose you have an array.

```java
int[] arr = {10,20,30,40,50};
```

Memory may look like this:

```
Address

1000     1004     1008     1012     1016

+----+   +----+   +----+   +----+   +----+
| 10 |   | 20 |   | 30 |   | 40 |   | 50 |
+----+   +----+   +----+   +----+   +----+
```

Notice something.

Every element is stored **continuously** in memory.

This is one of the biggest properties of arrays.

---

# 2. Problem with Arrays

Suppose we want to insert **25** after **20**.

Current array

```
10   20   30   40   50
```

Desired array

```
10   20   25   30   40   50
```

Can Java simply place 25 between 20 and 30?

No.

Because memory already looks like this.

```
1000

10

1004

20

1008

30

1012

40

1016

50
```

There is **no empty memory** between 20 and 30.

Java must first shift everything.

```
Move 50

↓

Move 40

↓

Move 30

↓

Insert 25
```

Final

```
10 20 25 30 40 50
```

This shifting takes

```
O(n)
```

time.

---

# 3. Another Problem

Suppose your array size is

```java
int[] arr = new int[5];
```

Currently

```
10 20 30 40 50
```

Now insert another element.

There is no space.

Java cannot increase the array size.

A completely new array must be created.

```
Old Array

10 20 30 40 50
```

↓

```
New Array

10 20 30 40 50 60
```

Then every element is copied.

Again

```
O(n)
```

---

# 4. So What Do We Need?

Instead of storing elements continuously,

what if every element could be stored **anywhere in memory**?

Example

```
10 stored at address 1000

20 stored at address 5000

30 stored at address 200

40 stored at address 9000
```

Would that still work?

Yes.

But then one question arises.

How will node 10 know where node 20 is?

---

# 5. Solution

Store the address of the next node.

Instead of storing only data

```
+------+
|  10  |
+------+
```

Store

```
+------+-------------+
| data | nextAddress |
+------+-------------+
```

Now every node knows

> "Who comes after me?"

This is the idea behind Linked Lists.

---

# 6. What is a Node?

A Node is a small object.

It contains two things.

```
+-----------+----------------+
|    data   |      next      |
+-----------+----------------+
```

Example

```
+-----------+----------------+
|    20     | Address of 30  |
+-----------+----------------+
```

Think of every node as a person.

Every person knows only

- their own value
- who comes next

They do **not** know the previous node.

---

# 7. Linked List Visualization

Suppose we have

```
10

20

30

40
```

Each node stores the address of the next node.

```
+-----+------+     +-----+------+     +-----+------+     +-----+------+
| 10  |  o-------->| 20  |  o-------->| 30  |  o-------->| 40  | null |
+-----+------+     +-----+------+     +-----+------+     +-----+------+
```

Notice

Node 10 does NOT know

- where node 40 is

Node 10 only knows

```
20
```

Node 20 only knows

```
30
```

Node 30 only knows

```
40
```

Node 40 knows

```
null
```

because nothing comes after it.

---

# 8. Why is it called "Linked" List?

Because every node is **linked** to the next node.

```
10 ---> 20 ---> 30 ---> 40
```

Every arrow is actually a stored memory address.

---

# 9. Java Implementation

Our Node class

```java
private class Node{

    private int data;

    private Node next;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

}
```

Notice

```
next
```

is not an integer.

It is

```java
Node next;
```

Why?

Because it stores

```
Address of another Node
```

NOT

```
Integer
```

---

# 10. Understanding

This line

```java
Node next;
```

does NOT create another node.

Many beginners think

```
Node next;
```

means

```
Node

↓

Node

↓

Node

↓

Node
```

Wrong.

It only creates a variable capable of storing the address of another Node.

Initially

```
next = null
```

---

# 11. How a Node Looks in Memory

Suppose we execute

```java
Node n = new Node(20);
```

Memory

```
n

        |
        |
        ▼

+----------------------+
| data = 20            |
| next = null          |
+----------------------+
```

Notice

No second node exists.

Only one node exists.

---

# 12. Two Connected Nodes

Suppose

```java
Node first = new Node(10);

Node second = new Node(20);
```

Memory

```
first

+-------------+
|10|null      |
+-------------+

second

+-------------+
|20|null      |
+-------------+
```

Completely independent.

Now execute

```java
first.next = second;
```

Memory

```
first

+-------------+
|10|---------+------------------+
+-------------+                 |
                                |
                                ▼

                         +-------------+
                         |20|null      |
                         +-------------+
```

Now they are connected.

Notice

Nothing moved in memory.

Only

```
next
```

changed.

---

# 13. What is head?

Suppose we have

```
10 ->20 ->30
```

How do we know where the Linked List starts?

We store

```
head
```

```
head

 |
 ▼

10 ->20 ->30
```

Without head,

we cannot access any node.

If we lose head,

the entire Linked List becomes unreachable.

---

# 14. What is tail?

Tail points to the last node.

```
head

 |

10 ->20 ->30

            ▲

            |

          tail
```

Tail allows insertion at the end in

```
O(1)
```

Without traversing the entire list.

---

# 15. What is size?

```
size = Number of Nodes
```

Example

```
10 ->20 ->30
```

```
size = 3
```

Whenever

Insert

```
size++
```

Whenever

Delete

```
size--
```

Never forget to update size.

Otherwise

many methods fail.

---

# 16. Biggest Beginner Misconception

Many students think

```
head

↓

10

↓

20

↓

30
```

means

```
head owns every node.
```

Wrong.

Actually

```
head
```

knows only

```
10
```

Node 10 knows

```
20
```

Node 20 knows

```
30
```

Node 30 knows

```
null
```

That's it.

---

# 17. Real Life Analogy

Imagine four friends.

```
Ram

Aman

Rahul

Priya
```

Ram knows only Aman.

Aman knows only Rahul.

Rahul knows only Priya.

Priya knows nobody.

Now suppose you know Ram.

Can you meet Priya?

Yes.

Ram tells you

```
Go to Aman.
```

Aman tells you

```
Go to Rahul.
```

Rahul tells you

```
Go to Priya.
```

This is exactly how Linked Lists work.

Every node knows only the next node.

---

# 18. Summary

✔ Array stores elements continuously.

✔ Linked List stores nodes anywhere in memory.

✔ Every node stores data and the address of the next node.

✔ `head` stores the address of the first node.

✔ `tail` stores the address of the last node.

✔ `size` stores the number of nodes.

✔ A node never knows the whole list.

✔ Every node knows only its next node.

✔ If `head` is lost, the entire list becomes inaccessible.

---

# Quick Revision

```
Node
│
├── data
└── next

Linked List
│
├── head
├── tail
└── size

Insert
│
└── size++

Delete
│
└── size--

Last Node
│
└── next = null
```

---

# Before Moving to Chapter 2

You should now be able to answer these questions without looking at the code:

1. Why do we need Linked Lists?
2. Why is `next` of type `Node` and not `int`?
3. What happens if `head` becomes `null`?
4. Why does the last node store `null`?
5. Why do we maintain `tail`?
6. Why do we maintain `size`?
7. How are Linked Lists different from Arrays?
8. Does a node know the whole list or only the next node?