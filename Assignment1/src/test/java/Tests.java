import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){

        GroupAdmin Sport_News_Group = new GroupAdmin();
        ConcreteMember Yossi = new ConcreteMember();
        ConcreteMember Dvid = new ConcreteMember();
        ConcreteMember Moshe = new ConcreteMember();


        logger.info(()-> JvmUtilities.objectTotalSize(Sport_News_Group));
        System.out.println("This is the total size of a GroupAdmin with 3 Members.\n");

        UndoableStringBuilder USB1 = new UndoableStringBuilder();
        UndoableStringBuilder USB2 = new UndoableStringBuilder();
        UndoableStringBuilder USB3 = new UndoableStringBuilder();


        logger.info(()-> JvmUtilities.objectTotalSize(USB1,USB2,USB3));
        System.out.println("This is the total size of 3 UndoableStringBuilder.\n");
    }
}
