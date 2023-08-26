# Using Data Types (3.1)

# Creating Data Types (3.2)
- a data type is implemented in a *class*
- an abstract data type, or class, or object, has:
- *constructors* - creates a new object and provides a reference to that object
- *instance variables* - defines set of data-type values
- *methods* - defines data-type operations on those values; eg implements APIs
- *test client*

## Java
- NOTE: in Java class, instance variables come before the constructor

### Instance variables
- instance variables have *access modifiers*; they can be public or private and/or final
	- *private* denies clients access to the variable, and therefore makes a data type abstract (eg implementation is abstracted from client)
	- *final* disallows changes in value, and documents this data type as _immutable_ (like `const` in javascript)  
- instance variables may be assigned values in the constructor; they are NOT declared in the constructor

### Constructors 
- constructors in Java are methods with no "static" AND *no return type*
- constructor may use arguments to assign values to instance variables 
- a constructor will: allocate memory for the object, initialize its instance variables, and return a reference to the newly created object
### Methods
- instance methods (eg class methods) have no "static"; can be "final"
- instance methods may reference instance variables
- **an instance variable reference in an instance method refers to the value for the specific object used to invoke the method**

### Clients
- clients use `new` keyword to invoke constructors  eg `Color c = new Color(0, 0, 255)`
- the return value of a constructor (eg `c`) is a _reference_ to a new object

### Best Practice:
- start by implementing a simple test client

## Python
https://introcs.cs.princeton.edu/python/32class/

- in Python, implement ADT using a _class_
- implenting an ADT similar to implementing a function module as set of functions, EXCEPT:
- we associate values - instance variables - with methods
- each method call is associated with the object used to invoke it

### Class
- a data type is implemented as a class 
- eg `class Color:`

### Constructor

- Python's mechanism for object creation is _flexible_ and _general_ (???)
- Python has a _default object creation process_ (constructor?) that calls __init__() to define and initialize instance variables
- technically, the __init__() method is not a constructor, because it does not handle all necessary parts for a constructor: eg memory allocation, object creation, returning a reference to the new object; it only defines and initializes instance variables
- more precisely, when a client creates a new object, Python creates an object and assigns 'self' as reference; allocates memory for all the arguments passed to the constructor, allocates memory within the object for the instance variables, references the parameter arguments with the instance variables, and returns self (eg a reference to the object)

#### __init__()
- the `__init__()` method can be defined within each class in order to define and initialize instance variables
- Python calls the __init__() method by default when a client calls a constructor to create a new object of specified type
- __init__() is a method, so its signature starts with `def`
- eg ```def __init__ (self, r, g, b):
	self._r = r
	...```

#### `self`
- a reference to the newly created object 
- first parameter variable in __init__() method

### Instance Variables
- by convention Python instance variables begin with an underscore (eg `_x`)
- instance variables are properties of `self` object, so we declare them in __init__() (eg `self._r = r`)

### Methods
- a method has access to three kinds of variables:
	- *instance variables* - accessed via `self` parameter, which is the first parameter passed to an instance method
	- *parameter variables* - passed as an argument from client to method
	- *local* variables - for tmp use within the method

#### `__str__()`
- Python's default behavior is to call `c.__str()__` for built in `str(c`
- useful for printing

#### Privacy
- client should only have access to methods defined in API
- helper methods should be private (so should __str__())
- by convention private methods are named with a leading underscore (eg `def _private_method(self):`)
- see Section 2.2 for more

### Clients
- clients invoke a constructor with the class name and constructor parameters  eg`c = Color(0, 0, 255)`

