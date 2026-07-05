# 📘 Chapter 3A : Understanding `temp = temp.next`

> **Goal of this chapter**
>
> By the end of this chapter, you will understand:
>
> - What `temp` actually is.
> - What `temp.next` actually means.
> - What Java executes first.
> - Why nodes never move.
> - Why only references move.
> - Why traversal works.
> - Why no data is copied.
> - The exact mistakes I made while learning.

---

# Before Starting

Forget Linked Lists.

Forget Java.

Imagine only houses.

Suppose there are four houses.

```
House A

House B

House C

House D
```

Now imagine every house knows only

> "Which house comes after me."

House A says

```
Next House = B
```

House B says

```
Next House = C
```

House C says

```
Next House = D
```

House D says

```
Nobody comes after me.
```

Now replace

House

with

Node.

Congratulations.

You already understand a Linked List.

---

# 1. What is temp?

Suppose

```java
Node temp = head;
```

Many beginners think

```
temp

↓

Node
```

Wrong.

temp is NOT a node.

temp is simply a variable.

Exactly like

```java
int x;
```

stores an integer,

```
Node temp;
```

stores

```
Address of a Node.
```

Never forget this.

---

# Visualization

Suppose

```
head

 |

 ▼

10 ----->20 ----->30 ----->40
```

Execute

```java
Node temp = head;
```

Memory becomes

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

How many nodes exist?

Answer

```
4
```

Question

Did Java create another node?

Answer

```
No.
```

Question

What changed?

Answer

Only one more variable

```
temp
```

started pointing to the first node.

---

# Rule

```
Node temp = head;
```

creates

NO new node.

It only copies the address.

---

# 2. Understanding temp.next

Current memory

```
temp

 |

 ▼

+---------------------+
| data = 10           |
| next = Address(20)  |
+---------------------+
```

Question

What is

```java
temp.next
```

?

Many students answer

```
Node 20
```

Not exactly.

The correct answer is

```
Address of Node 20.
```

Remember

```
next
```

stores an address.

Not an object.

---

# 3. Java Executes Right Side First

Suppose

```java
temp = temp.next;
```

Many students think

Java moves temp.

Actually

Java always evaluates the RIGHT side first.

Step 1

Evaluate

```java
temp.next
```

Current

```
temp

↓

10
```

Java asks node 10

```
Who is your next?
```

Node 10 replies

```
Address of node 20.
```

Java now knows

```
temp.next

=

Address of node 20
```

Nothing has changed yet.

---

Step 2

Execute assignment

```java
temp = Address(Node20)
```

Memory now

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

          ▲

          |

        temp
```

Notice

Did node 10 move?

No.

Did node 20 move?

No.

Did head move?

No.

Only

```
temp
```

changed.

---

# This is VERY Important

Nodes never move.

References move.

Read this sentence five times.

```
Nodes never move.

References move.
```

Almost every Linked List operation follows this rule.

---

# 4. Another Iteration

Again execute

```java
temp = temp.next;
```

Current

```
temp

↓

20
```

Java asks

```
Node 20,

Who is your next?
```

Answer

```
Node 30
```

Assignment

```
temp = Node30
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

Again

Nothing moved.

Only temp changed.

---

# 5. Last Iteration

Current

```
temp

↓

40
```

Execute

```java
temp = temp.next;
```

Java asks

```
Node40,

Who is your next?
```

Answer

```
null
```

Assignment

```
temp = null
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

temp

↓

null
```

Traversal ends.

---

# 6. Why while(temp != null)?

Display method

```java
while(temp != null){

    System.out.print(temp.data);

    temp = temp.next;

}
```

Question

Why not

```
while(temp.next != null)
```

?

Suppose list

```
10 ->20 ->30
```

When temp reaches

```
30
```

Current

```
30 -> null
```

Condition

```
temp.next != null
```

becomes

```
null != null

False
```

Loop ends.

Question

Was 30 printed?

No.

The last node is skipped.

Therefore

Always use

```java
while(temp != null)
```

---

# 7. Dry Run of display()

Code

```java
Node temp = head;

while(temp != null){

    System.out.print(temp.data);

    temp = temp.next;

}
```

Iteration 1

```
temp

↓

10
```

Print

```
10
```

Move

```
temp

↓

20
```

Iteration 2

Print

```
20
```

Move

```
30
```

Iteration 3

Print

```
30
```

Move

```
40
```

Iteration 4

Print

```
40
```

Move

```
null
```

Loop stops.

Output

```
10 20 30 40
```

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```
temp = temp.next;
```

moves the node.

Wrong.

Only

```
temp
```

moves.

Nodes never move.

---

## Confusion 2

I thought

```
temp.next
```

means

```
the next node.
```

Actually

```
temp.next
```

returns

```
the ADDRESS of the next node.
```

---

## Confusion 3

I thought Java changes

```
temp
```

first.

Wrong.

Java evaluates

```
temp.next
```

first.

Then performs assignment.

Always remember

```
Right side first.

Left side later.
```

---

## Confusion 4

I thought every iteration creates another node.

Wrong.

Traversal never creates nodes.

Traversal only changes one reference.

---

## Confusion 5

I imagined

```
10

↓

20

↓

30
```

moving in memory.

Wrong.

Memory never changes.

Only arrows (references) change.

---

# Interview Question

Q.

How does

```java
temp = temp.next;
```

work internally?

Answer

1. Java evaluates

```
temp.next
```

2. Reads the stored address.

3. Copies that address into

```
temp
```

4. No node moves.

5. No object is copied.

Only one reference changes.

---

# Golden Rules ⭐

Rule 1

```
temp

is never a node.

temp stores the address of a node.
```

Rule 2

```
temp.next

returns the address stored inside next.
```

Rule 3

Java always evaluates

RIGHT

before

LEFT.

Rule 4

Traversal never changes the Linked List.

Rule 5

Nodes never move.

Only references move.

---

# Self Test

Without looking above, answer:

1. Does `temp = temp.next` create a new node?
2. Does it move the existing node?
3. What is actually stored inside `temp`?
4. What is actually stored inside `next`?
5. Why does traversal stop when `temp == null`?
6. Why is `while(temp != null)` correct but `while(temp.next != null)` wrong?

If you can answer all six confidently, you've understood the heart of Linked Lists.