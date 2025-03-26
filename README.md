# PipeAndFilter Java Program

## Overview
This Java program demonstrates the **Pipe and Filter** design pattern using functional programming and Java Streams. The program processes a list of integers through a sequence of filters, applying transformations at each step.

## Features
- Filters even numbers
- Squares the numbers
- Filters numbers greater than 10
- Removes prime numbers
- Uses Java Streams and functional programming

## How It Works
1. The program initializes a list of integers from 1 to 10.
2. A **pipeline of filters** is defined using a `LinkedHashMap`, ensuring filters are applied in order.
3. The input list is passed through the pipeline, with intermediate results printed after each filter.
4. The final processed list is displayed as output.

## Filters Explained
1. **filterEvenNumbers** - Keeps only even numbers.
2. **squareNumbers** - Squares each number.
3. **filterNumbersGreaterThanTen** - Keeps only numbers greater than 10.
4. **filterPrimeNumbers** - Removes prime numbers.
