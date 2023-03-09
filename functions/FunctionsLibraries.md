# Functions and Libraries
## Why modular programming?
- fundamental seperation of client (e.g. a program that calls randomNumber(1,100)) from implementation (eg the static method that takes in a range and outputs a random int in that range)
- an API is a "contract" between the client and the implementation that specifies what each method will do  
- a clear API allows the implementation of a method/class/library to be developed *independently* from the client code

## best practices
- "Independent Development"
- *write the _before_ writing the implementation* 
- Why? Because goal is to make better, eg more compact, readable, self-descriptive, _client_ code
- include `main() test` client in each module (eg use the `maim` method for each module to run each method in that module at least once); 
- then do more testing in a separate module 
- write the API -- defninitions of what a functions the class will contain and what data each function takes in and puts out -- _before_ writing the functions
