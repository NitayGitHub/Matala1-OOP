import java.util.ArrayList;

/** The GroupAdmin class contains within it the database of states (UdoableStringBuilder)
 * and a database of clients (members) who receive updates on any changes made to the database.
 *@author Naor Tzadok & Nitai Levy*/
public class GroupAdmin implements Sender{
    private ArrayList<Member> members = new ArrayList<>();
    private UndoableStringBuilder usbState = new UndoableStringBuilder();

    /** This function registers an object that implements the Member interface into
     * our database of clients.
     * @param obj -> The object that will be added to our group.
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
    }

    /** This function unregisters an object from
     * our database of clients. This object won't get updates when we change the
     * group state (UdoableStringBuilder) and its current state (UdoableStringBuilder) will change to null.
     * @param obj -> The object that will be omitted from our group.
     */
    @Override
    public void unregister(Member obj) {
        int pos = members.indexOf(obj);
        members.get(pos).update(null);
        members.remove(obj);

    }

    /** This function inserts a string into our database of states (UdoableStringBuilder)
     * and updates each client.
     * @param offset - The offset.
     * @param obj - A string.
     */
    @Override
    public void insert(int offset, String obj) {
        usbState.insert(offset, obj);
        for (Member m : members)
            m.update(usbState);
    }

    @Override
    public void append(String obj) {
        usbState.append(obj);
        for (Member m : members)
            m.update(usbState);

    }

    @Override
    public void delete(int start, int end) {
        usbState.delete(start, end);
        for (Member m : members)
            m.update(usbState);

    }

    @Override
    public void undo() {
        usbState.undo();
        for (Member m : members)
            m.update(usbState);

    }

}
