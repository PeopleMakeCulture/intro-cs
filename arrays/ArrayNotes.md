# Array Notes

- java arrays are of immutable length
- this means there is no option to pop()/push()
- instead, use `java.util.Collections` to use higher level data structures (e.g. a Stack)
- Array class doesn't have a sum method
- use `java.util.stream.IntStream` class instead `int sum = IntStream.of(a).sum()` 
- to print the contents of an array, use `Arrays.toString()` from `java.util.Arrays`