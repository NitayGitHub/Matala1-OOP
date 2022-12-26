/** The ConcreteMember (observer) class contains within it a shallow copy (memState) of the UndoableStringBuilder database from the GroupAdmin.
 *@author Naor Tzadok & Nitai Levy*/

public class ConcreteMember implements Member{
	private UndoableStringBuilder memState = null;

	/** Updates the class string sequence to point to the given UndoableStringBuilder parameter.
	 * If the ConcreteMember was added to a GroupAdmin Class database of clients, the function updates
	 * the memState to point to that GroupAdmin database of states. If it was removed, the function updates
	 * the memState to be null.
	 *
	 * @param usb -> The GroupAdmin UndoableStringBuilder
	 */
	@Override
	public void update(UndoableStringBuilder usb) {
			memState = usb;

	}

	public UndoableStringBuilder getSB() {
		return memState;
	}

}
