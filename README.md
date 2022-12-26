# Matala1-OOP | Naor Tzadok & Nitay Levy
In this assignment, we add more functionality to the UndoableStringBuilder we built in a previous project.

## Data Structures
**GroupAdmin** - The GroupAdmin (observable) class contains within it the database of states (a string sequence) and a list of clients (observers) who receive updates on any changes made to the current state.

Data members:
1. private final ArrayList<Member> members - A list of objects that implement the Member interface.
2. private final UndoableStringBuilder usbState - A string sequence with the undo function.

Fuctions: 
1. register(Member obj) - Adds an object that implements the Member interface into our list of clients.
2. unregister(Member obj) - Omits an object from our list of clients.
3. insert(int offset, String obj) - Inserts a string into our string sequence.
4. append(String obj) - Appends the specified string to our string sequence.
5. delete(int start, int end) - Removes the characters in a substring of our string sequence.
6. undo() - Reverts our string sequence to the state before the current one.

**ConcreteMember** - The ConcreteMember (observer) class contains within it a shallow copy of the UndoableStringBuilder database from the GroupAdmin.
  
Data members:
1. private UndoableStringBuilder memState - A string sequence with the undo function.

Fuctions:
1. update(UndoableStringBuilder usb) -  Updates the class string sequence to point to the given UndoableStringBuilder parameter.

## JvmUtilities
The JvmUtilities class contains three static methods: 
• "objectFootprint" method - shows all the references that the object contains and the size of each reference (including overhead) 
• "objectTotalSize" method - shows the total size of the object.
• "jvmInfo" method - displays the process ID of the JVM and the total amount of memory for the benefit of the program.
