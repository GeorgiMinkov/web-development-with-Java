# Java introduction tasks
For development purposes you can use any IDE(IntelliJ, Eclipse, STS) or text editor with compiler


# Task 0
Write a method that calculates the factorial of a given number.
Factorial is the product of all positive integers less than or equal to n. For example, factorial(4) = 4x3x2x1 = 24.

# Task 1
Write a method that returns the index of the first occurrence of given integer in an array.
The index of the first element in the list is zero.

If the number does not exist return -1.

Example:
[5, 3, 8, 1, 3] 3 -> 1 

# Task 2
Write a method that returns the nth odd element of an array. If the index of the element exceeds the list size, then return -1.
Example:
[5, 3, 8, 1, 9] 4 -> 9
[5, 3, 8, 1, 9] 5 -> -1

# Task 3
A palindrome is a word which reads the same backward or forward. 'abcba' is a palindrome.
Write a method that detects if a string is a palindrome.
Tip: Use word.charAt(i) to get the character at position i.

# Task 4
Save in characters/string related data the following pattern:

```
*
* *
* * *
* * * *
```
Where the rows are defined by the user input number.

Tip: Think about the difference between String and StringBuilder

# Task 5
Implement the Caeser cypher -> https://en.wikipedia.org/wiki/Caesar_cipher

# Task 6
Create a class named Person with two attributes: name and age. 
Implement 3 constructors:
 - without parameters setting up default parameters "No name" and -1
 - with 1 parameter for name and default value for age -1
 - with 2 parameters setting up the both attributes

Implement setters and getters

Implement string representation of the object -> Hello, I am <name>. I am <age> years old
Tip: override -> toString.

This implementation to have the following logic:
 - if the age is not set, then print Hello, I am <name>.
 - if the the name is not set, then print I am John Doe

# Task 7
Create class Car with 4 attributes: brand, model, horsePower, year.

Create method insuranceCategory() which will return the category of the car by the year of construction:
 - category 1: under 8 years
 - category 2: between 8 and 15
 - category 3: between 16 and 25
 - category 4: over 26

Create functionality which will return the insurance value of a car based on the following rule:
based values:
 - category 1: 150
 - category 2: 200
 - category 3: 300
 - category 4: 500

if the car is under 80 hp increase the value by 20%, if over 140 increase with 45%

Example:
Lada 5 1989 75 -> 600
Mercedes-Benz S220 2009 160 -> 217.5


# Task 8
Create class FMIDate in which you will have the fields year, month and day defined.

The class will have the follwoing methods:
|method | description|
--------|--------------
|boolean isLeapYear() | is checking if the date defined in the object is a leap year|
|int getCentury() | return the appropriate century|
|int getDaysDifference(FMIDate other) | return the difference between the passed and the object data|
|void printInfo() | print the date followed by the century and if it's leap year followed by "It is a LEAP year" Example: yyyy MM dd - <XX> century.[*It is LEAP year*]


Create a program that will read two dates from the standart input and print the following 3 rows:
 - difference between the two dates
 - printInfo() for both dates

Example:
| Dates | Output |
|-------|--------|
|2016 09 26<br/>1878 03 03| 50612<br/>2016 09 21 - 21 century. It is a LEAP year<br/>1978 03 03 - 19 century. |
|2016 09 26 <br/> 2017 01 01| 98<br/>2016 09 26 - 21 century. It is LEAP year.<br/>2017 01 01 - 21 century. |	
