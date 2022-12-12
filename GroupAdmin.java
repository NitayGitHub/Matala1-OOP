import java.util.ArrayList;

public class GroupAdmin implements Sender{
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder usbState = new UndoableStringBuilder();
    @Override
    public void register(Member obj) {
        members.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        int pos = members.indexOf(obj);
        members.get(pos).update(null);
        members.remove(obj);

    }

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
