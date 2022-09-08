package homework.Task_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void fuzzySearchTest() {
        assertTrue(Solution.fuzzySearch("car", "ca6$$#_rtwheel"));
        assertTrue(Solution.fuzzySearch("cwhl", "cartwheel"));
        assertTrue(Solution.fuzzySearch("cwhee", "cartwheel"));
        assertTrue(Solution.fuzzySearch("cartwheel", "cartwheel"));
        assertFalse(Solution.fuzzySearch("cwheeel", "cartwheel"));
        assertFalse(Solution.fuzzySearch("lw", "cartwheel"));
        assertTrue(Solution.fuzzySearch("version", "Frekl5673vhwes;lrsjfijcmon"));
        assertFalse(Solution.fuzzySearch("fds", null));
        assertFalse(Solution.fuzzySearch("null", null));
        assertFalse(Solution.fuzzySearch(null, "sdfg"));
        assertFalse(Solution.fuzzySearch("", "Asdklrerw"));
        assertFalse(Solution.fuzzySearch("Asdklrerw", ""));
    }

}