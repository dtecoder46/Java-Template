
# Espresso

A stronger cup of Java

## Why Espresso?
1. Debugging little semicolon errors consumes time that could've been spent on testing code that actually matters
2. The syntax for writing to a file is complex, so Espresso bundles a writeFile class for you
3. Writing out "System.out.println" whenever doing quick tests can be tedious, so Espresso abstracts that syntax away from you, and now you just write the following in your Main.esp file:
```
Print printer = new Print ("Your text here")

printer.print()
```

## How to Run

- All
    1. Install Java
- New Java project
    1. Clone the repo
- Existing Java project
    1. Download the compiler file
    2. Change .java files to .esp
    3. Remove any semicolons in the code
    4. Run the compiler file
        1. java Compiler.java
    5. The output is in [class name].java, depending on what you input for the class name
        1. Run your compiled Java file using "java [class name].java"

## Algorithm

- File format: .esp
- Compiler
1. Read the .esp file
2. Split the file contents by newline into an array of lines
3. Loop through the array of lines
    1. If a line contains either “{” or “}” (denoting a conditional block or loop, which don’t require semicolons at the end of lines with curly braces)
        1. Skip
    2. Else
        1. Strip each line of whitespace to the right
        2. Append a semicolon to the line
    3. Add each line to an output string
4. Ask the user for the class name for their Java code
5. Write the output string to [class name].java

## Credits/Sources
