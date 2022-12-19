# Matala1-OOP
In this assignment, we add more functionality to the UndoableStringBuilder we built in a previous project.
##Data Structures
GroupAdmin - The GroupAdmin (observable) class contains within it the database of states (a string sequence) and a list of clients who receive updates on any changes made to the current state.
Fuctions: 
1. register(Member obj) - Adds an object that implements the Member interface into our list of clients.
2. unregister(Member obj) - Omits an object from our list of clients.
3. insert(int offset, String obj) - Inserts a string into our string sequence.
4. append(String obj) - Appends the specified string to our string sequence.
5. delete(int start, int end) - Removes the characters in a substring of our string sequence.
6. undo() - Reverts our string sequence to the state before the current one
