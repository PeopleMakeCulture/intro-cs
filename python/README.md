# Python Exercises for Arrays

These exercises from the book https://introcs.cs.princeton.edu/python/14array/


1.4.18  Write a code fragment to multiply two rectangular matrices that are not necessarily square. Note: For the dot product to be well defined, the number of columns in the first matrix must be equal to the number of rows in the second matrix. Print an error message if the dimensions do not satisfy this condition.

1.4.33  Find a duplicate. Given an integer array of length n, with each value between 1 and n, write a code fragment to determine whether there are any duplicate values. You may not use an extra array (but you do not need to preserve the contents of the given array.)

1.4.41  Binomial coefficients. Write a program that takes an integer command-line argument n and creates a two-dimensional ragged array a[][] such that a[n][k] contains the probability that you get exactly k heads when you toss a fair coin n times. These numbers are known as the binomial distribution: if you multiply each element in row i by 2^n, you get the binomial coefficients—the coefficients of x^k in (x+1)^n—arranged in Pascal’s triangle. To compute them, start with a[n][0] = 0.0 for all n and a[1][1] = 1.0, then compute values in successive rows, left to right, with a[n][k] = (a[n-1][k] + a[n-1][k-1]) / 2.0.