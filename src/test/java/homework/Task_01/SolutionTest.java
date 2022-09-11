package homework.Task_01;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution.Person[] RAW_DATA = new Solution.Person[]{
            new Solution.Person(0, "Harry"),
            new Solution.Person(0, "Harry"),    // дубликат
            new Solution.Person(1, "Harry"),    // тёзка
            new Solution.Person(2, "Harry"),
            new Solution.Person(3, "Emily"),
            new Solution.Person(4, "Jack"),
            new Solution.Person(4, "Jack"),
            new Solution.Person(5, "Amelia"),
            new Solution.Person(5, "Amelia"),
            new Solution.Person(6, "Amelia"),
            new Solution.Person(7, "Amelia"),
            new Solution.Person(8, "Amelia"),
            new Solution.Person(9, null),         // Добавим для теста объект c именем null
            null                                           // и просто объект null
    };

    @Test
    public void  getStringWithStreamTest() {

        Map<String, Long> resultMap = new LinkedHashMap<>();
        resultMap.put("Amelia", 4L);
        resultMap.put("Emily", 1L);
        resultMap.put("Harry", 3L);
        resultMap.put("Jack", 1L);

        Map<String, Long> groupPerson = Solution.getStringWithStream(RAW_DATA);

        assertEquals(groupPerson, resultMap);
    }

    @Test
    public void  getStringWithoutStreamTest() {

        Map<String, Long> resultMap = new LinkedHashMap<>();
        resultMap.put("Amelia", 4L);
        resultMap.put("Emily", 1L);
        resultMap.put("Harry", 3L);
        resultMap.put("Jack", 1L);

        Map<String, Long> groupPerson = Solution.getStringWithoutStream(RAW_DATA);

        assertEquals(groupPerson, resultMap);
    }
}