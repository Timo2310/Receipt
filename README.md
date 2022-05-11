# Receipt
Coding Challenge Itemis

This small commandline program asks customers for product orders and prints a receipt when they are finished. It was created by Timo Lehmann in response to the coding challenge issued by Itemis.

##Assumptions:

- user is on Windows 10 (although it shouldn't matter, since it is Java. But just in case.)
- user uses at least Java 16 (Meaning it should be installed and set to classpath. If the classpath is not set the path to javac and java should be given in possibility                               three)

##Buildprocess:

Possibility 1: Just pop it into eclipse or any other IDE under a package called shopping (or adjust the code accordingly to fit the name) and run it. 

Possibility 2: Alternatively, you can use the provided Java JAR to run it from the commandline with "java -jar 'path'/Receipt.jar".

Possibility 3: 
  - download all the source files (the .java ones) from the shopping folder
  - put them in a folder under "src/shopping/\*.java" (eg: Receipt/src/shopping/\*.java)
  - enter the folder that contains the src folder (in the above example 'Receipt')
  - open a cmd Window here (enter cmd in the path bar for quick access)
  - enter "java src/shopping/\*.java -d 'yourPreferredOutputPath' " (eg: java src/shopping/\*.java -d classes)
  - go into the created folder (eg: classes in the above example)
  - open a cmd window here (or navigate the previous window to this directory)
  - enter "java shopping/Main" and press enter
  - the program will be executed


##Concerning my design philosophy/thoughts:

Since this program is obviously part of a bigger program (a shopping site like amazon) I decided to do a commandline program since if this was a real task the classes and functions would probably be included there and not have their own unique output window.

For the input I take the prompt from the challenge in that exact same format, ie: '1 book at 12.49'. It is possible to enter other numbers instead of '1' in the beginning of the prompt to generate multiple items or leave it out completely for only one.

The type needs to be given by the user, since I did not want to hardcode stuff. That would cause false calculations if someone entered an order for a product that is a food, medical product or a book but can not be recognized as such since the name is not in the code. Realistically speaking, since this is supposed to be part of a bigger shopping site, the possible products would already be listed there including the type. Therefore the user inputs the type here, since this can be easily replaced with a prompt to read the type.

For similar reasons I just programmed a simple loop for entering products. This would probably be done by a gui in a real setting, so the main is purely for checking if the program works.

Since I could not find a proper solution for the numberformat problem, I just straight up ignored your formula (np/100 rounded up to the nearest 0.05) and implemented my own solution (which accomplishes the same thing). I apologize. :(

Looking forward to having a chat with you!

