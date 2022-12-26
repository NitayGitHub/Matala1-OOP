
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcreteMemberTest {

    public GroupAdmin Sport_News_Group;
    public ConcreteMember Yossi;

    @BeforeEach
    void init(){
        Sport_News_Group = new GroupAdmin();
        Yossi = new ConcreteMember();
    }


    @Test
    void update() {
        assertEquals(null, Yossi.getSB());
        UndoableStringBuilder news = new UndoableStringBuilder();
        news.insert(0,"Leo Messi signed for more 2 years in P.S.G\n");
        Yossi.update(news);
        assertEquals(news, Yossi.getSB());
    }

    @Test
    void getSB() {
        assertEquals(null, Yossi.getSB());
        UndoableStringBuilder news = new UndoableStringBuilder();
        news.insert(0,"Kilian Mbappe signed for more 2 years in P.S.G\n");
        Yossi.update(news);
        assertEquals(news, Yossi.getSB());

    }
}
