# 📘 Chapter 7 : `deleteFirst()` - Deleting the First Node

> **Goal of this chapter**
>
> After completing this chapter you should understand:
>
> * How deleting the first node actually works.
> * Why `head = head.next` deletes a node.
> * Why we don't physically remove the node.
> * What happens to the deleted node.
> * Why `tail = null` is needed.
> * Why `size--` is important.
> * The mistakes I made while learning.

---

# Our Code

```java
public int deleteFirst(){

    if(head == null){
        throw new RuntimeException("List is Empty");
    }

    int val = head.data;

    head = head.next;

    if(head == null){
        tail = null;
    }

    size--;

    return val;
}
```

Many beginners think

> "Where is the delete statement?"

There isn't one.

That is the first thing we need to understand.

---

# Before Understanding deleteFirst()

Remember one rule.

Java does **NOT** manually delete objects.

Instead,

Java removes objects automatically using the **Garbage Collector (GC).**

So in Linked Lists,

we never destroy a node ourselves.

We only make it unreachable.

---

# Current Linked List

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

                              ▲

                              |

                            tail
```

Suppose we execute

```java
deleteFirst();
```

Expected result

```
20 ----->30 ----->40
```

---

# Step 1

Java executes

```java
int val = head.data;
```

Current

```
head

↓

10
```

Java reads

```
head

↓

10

↓

data
```

Value obtained

```
10
```

Now

```
val = 10
```

Memory

```
head

 |

 ▼

10 ----->20 ----->30 ----->40

val

↓

10
```

Question

Has anything changed?

Answer

No.

Java only copied the data.

---

# 🧠 Internal Execution

```text
Read head
      ↓
Go to first node
      ↓
Read data field
      ↓
Copy value into variable val
```

Notice

The node is untouched.

---

# Step 2

Java executes

```java
head = head.next;
```

This is the most important line.

Java DOES NOT execute it all at once.

It executes it internally.

---

# Internal Execution

Current

```
head

↓

10 ----->20 ----->30 ----->40
```

Java first evaluates the **right side**.

```
head.next
```

Current

```
head

↓

10
```

Java asks

```
Node 10,

Who is your next?
```

Answer

```
Address of node 20
```

Nothing has changed yet.

Java now knows

```
head.next

=

Address(Node20)
```

---

Now Java performs the assignment.

```java
head = Address(Node20);
```

Memory becomes

```
head

 |

 ▼

20 ----->30 ----->40

                    ▲

                    |

                  tail
```

Question

Where did node 10 go?

Look carefully.

```
10 ----->20
```

still exists.

But

nothing points to node 10 anymore.

---

# Important Observation

Node 10 still exists in memory.

```
10 ----->20
```

But

```
head
```

forgot its address.

Since no variable points to node 10,

Java's Garbage Collector will eventually remove it.

---

# 🚨 Where I Got Stuck

I thought

```
head = head.next;
```

moves node 20.

Wrong.

Node 20 never moves.

Only

```
head
```

changes.

---

# Another Confusion

I thought

```
head = head.next;
```

deletes node 10.

Wrong.

It simply removes the only reference to node 10.

The Garbage Collector deletes it later.

---

# Step 3

```java
if(head == null){
    tail = null;
}
```

Question

Why do we need this?

Let's understand with an example.

---

# Case : One Node

Current

```
head

↓

10

▲

|

tail
```

Execute

```java
head = head.next;
```

Question

What is

```
10.next
```

?

Answer

```
null
```

Therefore

```
head

↓

null
```

But

```
tail

↓

10
```

Problem!

Tail still points to a node that is no longer part of the list.

Incorrect state

```
head

↓

null


tail

↓

10
```

That means

the list looks empty,

but

tail still says

"I have a last node."

Impossible.

---

# Therefore

We write

```java
tail = null;
```

Now

```
head

↓

null


tail

↓

null
```

Correct.

---

# Rule

Whenever the list becomes empty

```
head

=

null

tail

=

null
```

Always.

---

# Step 4

```java
size--;
```

Current

```
size = 4
```

After deletion

```
size = 3
```

Question

Why is this important?

Because many methods depend on size.

For example

```
deleteLast()

insert(index)

get(index)
```

If size is incorrect,

these methods may access invalid indexes and throw exceptions.

---

# 🚨 Where I Got Stuck

I once forgot

```java
size--;
```

The display method still worked.

So I thought everything was fine.

Later

```
deleteLast()
```

started failing.

Reason

Display never uses size.

Many other methods do.

---

# Final Memory

```
head

 |

 ▼

20 ----->30 ----->40

                    ▲

                    |

                  tail


size = 3
```

Deleted node

```
10
```

has no references.

Garbage Collector will eventually free it.

---

# Why is deleteFirst() O(1)?

Let's count the work.

```
Read first node

↓

Move head

↓

Possibly move tail

↓

Decrease size
```

No traversal.

No loop.

Whether there are

```
2 nodes

or

2 million nodes
```

the work is the same.

Therefore

```
Time Complexity = O(1)
```

---

# Edge Cases

## Empty List

```
head

↓

null
```

Throw exception.

---

## One Node

Before

```
head

↓

10

▲

|

tail
```

After deletion

```
head

↓

null

tail

↓

null
```

---

## Multiple Nodes

Before

```
10 ->20 ->30 ->40
```

After

```
20 ->30 ->40
```

Only

```
head
```

changes.

---

# Common Mistakes

❌ Forgetting to check

```
head == null
```

Result

```
NullPointerException
```

---

❌ Forgetting

```
tail = null
```

when deleting the only node.

Result

```
tail
```

points to an invalid node.

---

❌ Forgetting

```
size--
```

Future methods behave incorrectly.

---

❌ Thinking

```
head = head.next;
```

moves nodes.

Wrong.

Only

```
head
```

moves.

---

# Interview Questions

### Q1

Why don't we explicitly delete the first node?

Because Java automatically removes unreachable objects using the Garbage Collector.

---

### Q2

Why is

```java
head = head.next;
```

enough?

Because once head forgets the first node,

nothing else references it.

The node becomes unreachable.

---

### Q3

Why do we set

```java
tail = null;
```

only when

```java
head == null
```

Because only then has the list become completely empty.

---

### Q4

Why is deleteFirst() O(1)?

Because no traversal is required.

---

# Golden Rules ⭐

Rule 1

```
Deleting

≠

Destroying an object.
```

Deleting means

```
Removing references.
```

---

Rule 2

Java's Garbage Collector removes unreachable objects.

---

Rule 3

```
head = head.next;
```

moves only

```
head.
```

---

Rule 4

Whenever

```
head == null
```

then

```
tail

must also

be null.
```

---

Rule 5

Always update

```
size--
```

after successful deletion.

---

# Self Test

Without looking above, answer:

1. Why doesn't Java need a `delete` keyword?
2. What actually happens during `head = head.next`?
3. Where does the old first node go?
4. Why do we set `tail = null`?
5. Why does forgetting `size--` cause future bugs?
6. Why is `deleteFirst()` O(1)?

If you can explain these six answers confidently, you've mastered deleting the first node.
