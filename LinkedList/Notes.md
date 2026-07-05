# 📚 Singly Linked List in Java (Revision Notes)

> These notes are based on my implementation of a Singly Linked List in Java.
> Goal: Quick revision before interviews, coding rounds, or GitHub reference.

---

# 📌 What is a Linked List?

A Linked List is a linear data structure where every element is stored inside a **Node**.

Each node contains

1. Data
2. Address of the next node

```
head
 |
 ▼
10 ---> 20 ---> 30 ---> null
```

Unlike arrays, nodes are **not stored continuously in memory**.

---

# Structure of My Linked List

```java
private Node head;
private Node tail;
private int size;
```

## head

Points to the first node.

```
head
 |
 ▼
10 -> 20 -> 30
```

---

## tail

Points to the last node.

```
10 -> 20 -> 30
              ^
              |
            tail
```

Using tail makes insertion at the end **O(1)**.

---

## size

Stores number of nodes.

Always update

- Insert → size++
- Delete → size--

Never forget.

---

# Node Class

```java
private class Node{
    int data;
    Node next;
}
```

Every node stores

```
+-----------+------------+
|   data    |    next    |
+-----------+------------+
```

Example

```
+-----+------+
| 20  |  ●-----> Node(30)
+-----+------+
```

---

# Why is Node an Inner Class?

```
LL
├── head
├── tail
├── size
└── Node
```

Since Node belongs only to Linked List,
making it an inner class hides its implementation.

Only LL can create nodes.

---

# Why can LL access Node?

Inside LL,

```java
Node temp = head;
```

works because Node is a member of LL.

The compiler reads the whole class before compiling.

---

# Constructors

## Constructor 1

```java
Node(int data)
```

Creates

```
25 -> null
```

---

## Constructor 2

```java
Node(int data, Node next)
```

Creates

```
25 -> 30
```

Useful while inserting in between.

---

# insertFirst()

```java
Node n = new Node(val);

n.next = head;

head = n;
```

Visualization

Before

```
head

10 -> 20 -> 30
```

Step 1

```
n

5 -> null
```

Step 2

```
5 ------>10 ->20 ->30
```

Step 3

```
head

5 ->10 ->20 ->30
```

Time Complexity

O(1)

---

# insertLast()

Using tail

```java
tail.next = newNode;

tail = newNode;
```

Visualization

Before

```
10 ->20 ->30
          ^
         tail
```

After

```
10 ->20 ->30 ->40
               ^
              tail
```

Time Complexity

O(1)

---

# insertLast() without tail

```
temp = head

while(temp.next != null)
    temp = temp.next;
```

Visualization

```
temp

10 ->20 ->30
```

↓

```
10 ->20 ->30

      temp
```

↓

```
10 ->20 ->30

           temp
```

Attach new node

```
30.next = 40
```

Time Complexity

O(n)

---

# insert(index)

Goal

Insert 25 after 20

Before

```
10 ->20 ->30 ->40
```

Traversal

```
temp = head

temp
 |
10
```

↓

```
20

temp
```

Create node

```java
Node n = new Node(25, temp.next);
```

Current

```
20 ------>30

25 ------>30
```

Now

```java
temp.next = n;
```

Final

```
10 ->20 ->25 ->30 ->40
```

---

# Two Correct Ways

Method 1

```java
Node n = new Node(val);

n.next = temp.next;

temp.next = n;
```

Method 2

```java
Node n = new Node(val, temp.next);

temp.next = n;
```

Both are correct.

Method 2 simply uses the constructor to assign next.

---

# deleteFirst()

```java
head = head.next;
```

Visualization

Before

```
head

10 ->20 ->30
```

After

```
head

20 ->30
```

If

```
head == null
```

then

```
tail = null;
```

---

# deleteLast()

Need second last node.

```
secondLast = get(size-2);
```

Before

```
10 ->20 ->30 ->40
               ^
              tail
```

After

```
tail = secondLast;

tail.next = null;
```

Result

```
10 ->20 ->30
```

---

# delete(index)

Need previous node.

```
prev = get(index-1);
```

Before

```
10 ->20 ->25 ->30
```

Delete 25

```
prev

20
```

Current

```
20 ->25 ->30
```

Execute

```
prev.next = prev.next.next;
```

Result

```
20 ->30
```

---

# get(index)

Purpose

Return node present at index.

```java
Node n = head;

for(...)
    n = n.next;
```

Visualization

```
0     1     2     3

10 ->20 ->30 ->40
```

get(2)

```
10

↓

20

↓

30
```

Returns node containing 30.

---

# find(value)

```
Node n = head;

while(n != null)
```

Move node one by one.

```
10

↓

20

↓

30

↓

40
```

If

```
n.data == value
```

Return node.

Else return null.

---

# display()

```
temp = head;

while(temp != null)
```

Print

```
temp.data
```

Then

```
temp = temp.next;
```

Until

```
null
```

---

# How temp = temp.next Works

Suppose

```
temp

10 ->20 ->30
```

Java asks

```
Node 10,

Where is your next?
```

Answer

```
Node 20
```

Then

```
temp = Node20
```

Nothing moves.

Only temp changes.

---

# Biggest Confusion I Had

## Why no loop?

```
n.next = head;

head = n;
```

I thought

```
head

↓

n

↑
```

creates loop.

Wrong.

Reason

```
n.next
```

stores old head.

Later

```
head
```

changes.

Changing head never changes n.next.

---

# Biggest Confusion

```
Node n = new Node(val,temp.next);
```

How does

```
this.next = temp.next;
```

work?

Answer

Java first evaluates

```
temp.next
```

Suppose

```
temp

20 ->30
```

Java replaces

```
temp.next
```

with

```
address of node 30
```

Constructor receives

```
Node(25,addressOf30)
```

So

```
25 ->30
```

gets created immediately.

---

# Biggest Mistake I Made

Wrong

```java
deleteFirst();

deleteLast();
```

without

```
return
```

Correct

```java
return deleteFirst();

return deleteLast();
```

Otherwise code continues executing.

---

# Another Mistake

Forgot

```
size--;
```

Display still works because it follows pointers.

But

```
size
```

becomes incorrect.

Later

```
get(size-2)
```

fails.

---

# Another Mistake

Deleted from

```
obj
```

Displayed

```
obj2
```

Always check

```
Which object am I modifying?
```

---

# Common Edge Cases

## Empty List

```
head == null
```

---

## One Node

```
head == tail
```

Deleting first or last should set

```
head = null

tail = null
```

---

## Insert at beginning

```
index == 0
```

---

## Insert at end

```
index == size
```

---

## Delete first

```
index == 0
```

---

## Delete last

```
index == size-1
```

---

# Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert First | O(1) |
| Insert Last (tail) | O(1) |
| Insert Last (without tail) | O(n) |
| Insert Middle | O(n) |
| Delete First | O(1) |
| Delete Last | O(n) |
| Delete Middle | O(n) |
| Find | O(n) |
| Display | O(n) |
| Get | O(n) |

---

# Revision Checklist ✅

- [ ] What is head?
- [ ] What is tail?
- [ ] Why size is maintained?
- [ ] Difference between constructor 1 & 2.
- [ ] Why Node is inner class.
- [ ] How temp moves.
- [ ] How insertion between two nodes works.
- [ ] Why constructor version works.
- [ ] deleteFirst visualization.
- [ ] deleteLast visualization.
- [ ] delete(index) visualization.
- [ ] Edge cases.
- [ ] Complexity.

---

# Things I Must Never Forget 🚨

### 1.

```
temp = temp.next;
```

does NOT move nodes.

It only moves temp.

---

### 2.

Always save next before changing links.

Correct

```
newNode.next = temp.next;

temp.next = newNode;
```

Never reverse the order.

---

### 3.

Whenever node is added

```
size++
```

Whenever node is deleted

```
size--
```

---

### 4.

Special cases must return immediately.

```
return deleteFirst();

return deleteLast();
```

---

### 5.

Always think with diagrams, not code.

Instead of reading

```
temp.next
```

think

> Ask current node: "Where is your next?"

---

# Golden Rule ⭐

Whenever stuck in Linked List:

1. Draw the nodes.
2. Draw `head`.
3. Draw `tail`.
4. Draw `temp`.
5. Draw `newNode`.
6. Update **one pointer at a time**.
7. Never imagine everything changing together.

**If I can draw it, I can code it.**