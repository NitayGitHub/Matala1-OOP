import java.util.ArrayList;

/** The GroupAdmin (observable) class contains within it the database of states (UndoableStringBuilder)
 * and a database of clients (members) who receive updates on any changes made to the database.
 *@author Naor Tzadok & Nitai Levy*/
public class GroupAdmin implements Sender{
    private final ArrayList<Member> members = new ArrayList<>();
    private final UndoableStringBuilder usbState = new UndoableStringBuilder();

    /** This function registers an object that implements the Member interface into
     * our database of clients. After that, the object updates its UndoableStringBuilder
     * to point to usbState.
     * @param obj -> The object that will be added to our group.
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
        obj.update(usbState);
    }

    /** This function unregisters an object from
     * our database of clients. This object won't get updates when we change the
     * group state (UndoableStringBuilder) and its current state (UndoableStringBuilder) will change to null.
     * @param obj -> The object that will be omitted from our group.
     */
    @Override
    public void unregister(Member obj) {
        int pos = members.indexOf(obj);
        members.get(pos).update(null);
        members.remove(obj);

    }

    /** This function inserts a string into our database of states (UndoableStringBuilder).
     * @param offset - The offset.
     * @param obj - A string.
     */
    @Override
    public void insert(int offset, String obj) {
        usbState.insert(offset, obj);

    }

    /** This function appends the specified string to our database of states (UndoableStringBuilder).
     * @param obj - A string.
     */
    @Override
    public void append(String obj) {
        usbState.append(obj);

    }

    /** This function removes the characters in a substring of our database of states. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * @param start – The beginning index, inclusive.
     * @param end – The ending index, exclusive.
     */
    @Override
    public void delete(int start, int end) {
        usbState.delete(start, end);

    }
    /** This function reverts our database of states to the state before the current one.*/

    @Override
    public void undo() {
        usbState.undo();

    }

}
