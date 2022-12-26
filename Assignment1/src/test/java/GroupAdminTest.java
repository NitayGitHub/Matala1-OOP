package Matala_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    public GroupAdmin Sport_News_Group;
    public ConcreteMember Yossi;
    public String news1, news2;

    @BeforeEach
    void init(){
        Sport_News_Group = new GroupAdmin();
        Yossi = new ConcreteMember();
        news1 = "Leo Messi signed for more 2 years in P.S.G\n";
        news2 = "Kilian Mbappe signed for more 3 years in P.S.G\n";
    }

    @Test
    void register() {
        assertEquals(0, Sport_News_Group.size());
        Sport_News_Group.register(Yossi);
        assertEquals(1, Sport_News_Group.size());
    }

    @Test
    void unregister() {
        Sport_News_Group.register(Yossi);
        assertEquals(1, Sport_News_Group.size());
        Sport_News_Group.unregister(Yossi);
        assertEquals(0, Sport_News_Group.size());
        assertEquals(null, Yossi.getSB());
    }

    @Test
    void insert() {
        Sport_News_Group.register(Yossi);
        assertEquals(null, Yossi.getSB());
        assertEquals("", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.insert(0,news1);
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
    }

    @Test
    void append() {
        Sport_News_Group.register(Yossi);
        assertEquals(null, Yossi.getSB());
        assertEquals("", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.append(news1);
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.append(news2);
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n" +
                             "Kilian Mbappe signed for more 3 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n" +
                             "Kilian Mbappe signed for more 3 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
    }

    @Test
    void delete() {
        Sport_News_Group.register(Yossi);
        assertEquals(null, Yossi.getSB());
        assertEquals("", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.append(news1);
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.delete(0,4);
        assertEquals("Messi signed for more 2 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Messi signed for more 2 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
    }

    @Test
    void undo() {
        Sport_News_Group.register(Yossi);
        assertEquals(null, Yossi.getSB());
        assertEquals("", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.insert(0,news1);
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.append(news2);
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n" +
                             "Kilian Mbappe signed for more 3 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n" +
                             "Kilian Mbappe signed for more 3 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.delete(0,43);
        assertEquals("Kilian Mbappe signed for more 3 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Kilian Mbappe signed for more 3 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.undo();
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n" +
                             "Kilian Mbappe signed for more 3 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n" +
                             "Kilian Mbappe signed for more 3 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.undo();
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Yossi.getSB().toString());
        assertEquals("Leo Messi signed for more 2 years in P.S.G\n", Sport_News_Group.getUsbState().toString());
        Sport_News_Group.undo();
        assertEquals("", Yossi.getSB().toString());
        assertEquals("", Sport_News_Group.getUsbState().toString());
    }
}