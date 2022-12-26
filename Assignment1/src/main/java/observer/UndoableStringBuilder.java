package observer;

import java.util.EmptyStackException;
import java.util.Stack;
import java.lang.StringBuilder;

/** This class represents the StringBuilder class with support for the Undo operation.
 *@author Naor Tzadok & Nitai Levy*
 *To return to the last operation, we're using a stack that saves operations
 *that can undo the last change accordingly. These operation objects implement the interface below.
 */
public class UndoableStringBuilder {
    public StringBuilder strbuilder;
    private Stack<StringBuilder> stk;

    /** Empty constructor*/
    public UndoableStringBuilder(){
        this.strbuilder = new StringBuilder();
        this.stk = new Stack<>();
    }
    /** Parameterized constructor*/
    public UndoableStringBuilder(StringBuilder strbuilder, Stack<StringBuilder> stk){
        this.strbuilder = strbuilder;
        this.stk = stk;
    }

    /** this function appends the specified string to this character sequence
     *
     * @param str -> the string that will append to the UndoableStringBuilder
     * @return the new UndoableStringBuilder
     */
    public UndoableStringBuilder append(String str){
        StringBuilder undostr = new StringBuilder(this.strbuilder);
        try {
            this.strbuilder.append(str);
            this.stk.push(undostr);
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }catch (Exception e){
            System.out.println("Invalid input");
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }
    }

    /** this function Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start – The beginning index, inclusive.
     * @param end – The ending index, exclusive.
     * @return the new UndoableStringBuilder
     */

    public UndoableStringBuilder delete (int start, int end){
        try {
            StringBuilder undostr = new StringBuilder(this.strbuilder);
            this.strbuilder.delete(start,end);
            this.stk.push(undostr);
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }catch(StringIndexOutOfBoundsException e) {
            System.out.println("Can't delete. Invalid parameter.");
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }
    }

    /** this function Inserts the string into this character sequence.
     *
     * @param offset - the offset
     * @param str - a string
     * @return the new UndoableStringBuilder
     * */

    public UndoableStringBuilder insert (int offset, String str){
        try {
            StringBuilder undostr = new StringBuilder(this.strbuilder);
            this.strbuilder.insert(offset,str);
            this.stk.push(undostr);
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }catch(StringIndexOutOfBoundsException e) {
            System.out.println("Can't insert. Invalid parameter.");
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }

    }

    /** this function Replaces the characters in a substring of this sequence with characters in
     the specified String. The substring begins at the specified start and
     extends to the character at index end - 1 or to the end of the sequence if
     no such character exists. First the characters in the substring are removed
     and then the specified String is inserted at start. (This sequence will be
     lengthened to accommodate the specified String if necessary).
     *
     *@param  start – The beginning index, inclusive.
     *@param end – The ending index, exclusive.
     *@param str – String that will replace previous contents.
     *@return the new UndoableStringBuilder
     *
     */

    public UndoableStringBuilder replace(int start, int end, String str){
        try {
            StringBuilder undostr = new StringBuilder(this.strbuilder);
            this.strbuilder.replace(start,end,str);
            this.stk.push(undostr);
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }catch(StringIndexOutOfBoundsException e) {
            System.out.println("Can't replace. Invalid parameter.");
            return new UndoableStringBuilder(this.strbuilder, this.stk);
        }

    }

    /** this function Causes this character sequence to be replaced by the reverse of the
     * sequence
     *
     * @return the new UndoableStringBuilder
     * */

    public UndoableStringBuilder reverse(){
        StringBuilder undostr = new StringBuilder(this.strbuilder);
        this.strbuilder.reverse();
        this.stk.push(undostr);
        return new UndoableStringBuilder(this.strbuilder, this.stk);
    }

    /** this function doing Undo on the last operation we used*/

    public void undo(){
        try {
            this.strbuilder = this.stk.pop();
        }catch(EmptyStackException e) {
            System.out.println("No operations to undo.");
            return;
        }

    }

    /** this function return a string of UndoableStringBuilder
     *
     * @return a string of UndoableStringBuilder
     * */

    public String toString(){
        return this.strbuilder.toString();
    }

}
