# 📘 Chapter 3C : Understanding `Node n = new Node(val, temp.next)`

> **Goal of this chapter**
>
> After completing this chapter you will understand:
>
> - How Java executes constructor calls.
> - Why `temp.next` is evaluated BEFORE the constructor starts.
> - Why `next` being initially `null` doesn't matter.
> - Why `Node(val, temp.next)` works.
> - Why node 30 is never lost.
> - Why reversing the two pointer assignments breaks the list.
> - The exact mistakes I made while learning.

---

# Our Code

This is the code that confused me the most.

```java
Node n = new Node(val, temp.next);

temp.next = n;
```

It looks very small.

But internally Java performs many steps.

We will slow every step down.

---

# Current Linked List

Suppose the list is

```
head

 |

 ▼

10 ----->20 ----->30 ----->40
```

Suppose

```
temp
```

is already standing on

```
20
```

Current memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

          ▲

          |

         temp
```

Goal

Insert

```
25
```

between

```
20

and

30
```

Desired list

```
10 ->20 ->25 ->30 ->40
```

---

# Step 1

Java reads

```java
Node n = new Node(25, temp.next);
```

Question

Does Java immediately enter the constructor?

Answer

NO.

This surprises many students.

Java first evaluates every argument.

---

# Java Rule

Whenever Java sees

```java
method(a,b,c);
```

or

```java
new Something(a,b,c);
```

Java first calculates

```
a

↓

b

↓

c
```

Only then

it calls the constructor.

---

# Therefore

Java first evaluates

```java
temp.next
```

Current memory

```
temp

↓

20
```

Question

What is stored inside

```
20.next
```

Answer

Address of node 30.

Therefore

Java replaces

```java
temp.next
```

with

```
Address(Node30)
```

Nothing has changed in memory.

Java has only calculated the value.

---

# Java is Actually Executing

Instead of

```java
new Node(25,temp.next)
```

Java now has

```java
new Node(25, Address(Node30))
```

Notice

The constructor hasn't started yet.

---

# Step 2

Now constructor begins.

Constructor

```java
public Node(int data, Node next){

    this.data = data;

    this.next = next;

}
```

Question

What is inside

```
data
```

Answer

```
25
```

Question

What is inside

```
next
```

Answer

Address of node 30.

Not

```
null
```

---

# Constructor Memory

Before assignment

```
data

↓

25


next

↓

Address(Node30)
```

Execute

```java
this.data = data;
```

New node

```
25

next = null
```

temporarily

Execute

```java
this.next = next;
```

Now

```
25 ----->30
```

The new node is complete.

---

# Memory Now

Current list

```
10 ----->20 ----->30 ----->40
```

New node

```
25 ----->30
```

Picture

```
10 ----->20 ----->30 ----->40


25 ---------+

             |

             ▼

            30
```

Question

Has the Linked List changed?

No.

The new node is floating separately.

---

# Step 3

Execute

```java
temp.next = n;
```

Current

```
20 ----->30
```

Question

What changes?

Only

```
20.next
```

Instead of pointing to

```
30
```

it now points to

```
25
```

Final picture

```
10 ----->20 ----->25 ----->30 ----->40
```

Done.

---

# Important Observation

Node 30 was NEVER lost.

Why?

Because before changing

```
20.next
```

we already saved

```
30
```

inside

```
25.next
```

---

# Biggest Beginner Confusion

I thought

```
next
```

inside constructor

was initially

```
null
```

So

```
this.next = next;
```

should copy

```
null.
```

Wrong.

---

# Why?

Because constructor parameters already contain values.

Question

Where did

```
next
```

come from?

Answer

From

```
temp.next
```

which Java evaluated BEFORE entering the constructor.

Therefore

```
next

=

Address(Node30)
```

inside constructor.

---

# Very Important Rule

Arguments are evaluated

BEFORE

the constructor starts.

Always remember this.

---

# Another Way

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

Which is correct?

Answer

Both.

---

# Comparison

Method 1

Step 1

```
25 -> null
```

Step 2

```
25 ->30
```

Step 3

```
20 ->25
```

---

Method 2

Constructor immediately creates

```
25 ->30
```

Then

```
20 ->25
```

Same final result.

---

# Why Constructor Version Exists

Instead of

```
Create node

↓

Assign data

↓

Assign next
```

the constructor performs everything together.

Cleaner code.

Same logic.

---

# What Happens If I Reverse The Order?

Wrong

```java
temp.next = n;

n.next = temp.next;
```

Let's execute it.

Initially

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

becomes

```
25 ----->25
```

Loop

```
25

▲

|

└──────────
```

Node 30 is lost.

---

# Golden Rule

Always save

the old connection

before breaking it.

Correct order

```
newNode.next = temp.next;

temp.next = newNode;
```

Never reverse these two statements.

---

# 🚨 Where I Got Stuck

## Confusion 1

I thought

```
next
```

inside constructor

was initially

```
null.
```

Actually

constructor parameters already receive values before execution begins.

---

## Confusion 2

I thought constructor executes first.

Wrong.

Arguments execute first.

Constructor starts later.

---

## Confusion 3

I thought

```
temp.next
```

changes after

```
temp.next = n.
```

Wrong.

The constructor had already copied the old address.

---

## Confusion 4

I thought

```
25
```

was immediately inside the list.

Wrong.

Initially

```
25
```

is completely separate.

Only after

```
temp.next = n;
```

does it become part of the Linked List.

---

# Real Life Analogy

Suppose friend A tells you

"My next friend is Rahul."

You write Rahul's phone number into your notebook.

Now later

Friend A changes his best friend.

Question

Will your notebook automatically change?

No.

Because you copied Rahul's phone number earlier.

Exactly the same thing happens here.

---

# Interview Question

Q.

Why do we write

```java
newNode.next = temp.next;

temp.next = newNode;
```

instead of the opposite?

Answer

Because we must preserve the old connection first.

If we change

```
temp.next
```

before saving it,

the rest of the Linked List becomes unreachable.

---

# Summary

✔ Java evaluates constructor arguments first.

✔ Constructor parameters already contain values.

✔ `next` is not copied from the new node.

✔ It is copied from `temp.next`.

✔ The new node is created separately.

✔ Only after `temp.next = newNode` does it join the Linked List.

✔ Never reverse the pointer assignments.

---

# Self Test

Without looking above, answer:

1. Does Java execute the constructor before evaluating arguments?
2. What value does `next` receive inside the constructor?
3. Why is node 30 never lost?
4. Why are both insertion methods correct?
5. What happens if we reverse the pointer assignments?
6. Why isn't the new node immediately part of the Linked List?