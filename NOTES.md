# Notes

Use main method rather than extending App as this is the verbose way of showing the frames being held in the stack

Like pouring a milliliter of water into a cup 100000 times, at somepoint the limit of the cup will be exceeded, and the water will just flow over the edge.

Add thread stacktrace to show frames being created

Explain last call needs to be the recursive call
* add @tailrec annotation to the original function and explain the compiler helps to identify the problem

```scala
x + sum(xs)
// is equivalent to
y = sum(xs)
x + y
```

* This means that another frame needs to be created in the stack for sum(xs) until the end of the list is reached
* Only once Nil has been encountered (end of list) can the stack begin to wind back up, returning the value of each call to sum back to it's caller.
    * Winding up the stack -> clarify terminology
