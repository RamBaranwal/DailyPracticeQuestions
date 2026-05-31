package StaticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    // by during static it is going to update universal not inside the box
    static long population;

    public Human(int age, String name, int salary, boolean married){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        // this.population += 1;
        Human.population += 1;
    }

    public Human() {
        population++;
    }
}

/*
When population is NOT static
long population;

Each object gets its own copy of population.

When:

Human kunal = new Human(...);
kunal.population = 0
Constructor runs → population++
kunal.population = 1

When:

Human rahul = new Human(...);
rahul.population = 0
Constructor runs → population++
rahul.population = 1

Memory:

kunal
 ├─ age
 ├─ name
 ├─ salary
 ├─ married
 └─ population = 1

rahul
 ├─ age
 ├─ name
 ├─ salary
 ├─ married
 └─ population = 1

Output:

System.out.println(kunal.population); // 1
System.out.println(rahul.population); // 1
When population IS static
static long population;

Now there is only one copy of population shared by all objects.

Memory:

Human Class
 └─ population = 0

kunal
 ├─ age
 ├─ name
 ├─ salary
 └─ married

rahul
 ├─ age
 ├─ name
 ├─ salary
 └─ married

Execution:

Human kunal = new Human(...);

Constructor:

Human.population += 1;

Now:

population = 1

Then:

Human rahul = new Human(...);

Again:

population = 2

So:

System.out.println(kunal.population); // 2
System.out.println(rahul.population); // 2

Both print 2 because they are accessing the same shared variable.

Why write Human.population instead of this.population?

Inside the constructor:

Human.population += 1;

is preferred because:

population belongs to the class, not an object.
It makes the code clearer.
Java allows this.population, but it's misleading because this refers to an object.

Best practice:

Human.population++;

or

population++;

but Human.population++ clearly shows that population is a class-level variable.

Rule to remember
Instance variable → One copy per object.
Static variable → One copy for the entire class, shared by all objects.
*/