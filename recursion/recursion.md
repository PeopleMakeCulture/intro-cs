# Recursion
- a recursive function is a function that is specified in terms of itself
- not just a mind bend-y puzzle - actually occurs naturally
- "many computational artifacts are naturally self-referential"
- think of a tree, whose sub-nodes ore also trees
- a divide and conquer algorithm that continues to divide and conquer
- a file system where folders contain files and other folders
- Q: How do we convince ourselves that a recursive method is correct?
A: mathematical induction: 
	1. prove for base case, 
	2. assume it's true for small n, 
	3. prove for n
## Debugging
- missing base case
	- results in endlessly calling itself
- no convergence guarantee 
	- also leads to infinite recursive loop 
