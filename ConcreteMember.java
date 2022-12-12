public class ConcreteMember implements Member{
	private UndoableStringBuilder MemState;

	@Override
	public void update(UndoableStringBuilder usb) {
		MemState = usb;
		
	}
	
	public UndoableStringBuilder getSB() {
		return MemState;
	}

}
