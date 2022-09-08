package homework.Task_03;
/*
 * Задача №3
 * Реализовать функцию нечеткого поиска
 * fuzzySearch("car", "ca6$$#_rtwheel"); // true
 * fuzzySearch("cwhl", "cartwheel"); // true
 * fuzzySearch("cwhee", "cartwheel"); // true
 * fuzzySearch("cartwheel", "cartwheel"); // true
 * fuzzySearch("cwheeel", "cartwheel"); // false
 * fuzzySearch("lw", "cartwheel"); // false
 * Добавил проверку на null, в тестах проверил
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }

    public static boolean fuzzySearch(String find, String str) {
        // Проверка на null
        if(find == null || str == null) {
            return false;
        }
        if(find.length() == 0){
            return false;            // Если строка поиска не содержит символов то вернуть ложь
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == find.charAt(count)) {
                if(count == find.length()-1)
                    return true;
                else count++;
            }
        }
        return false;
    }
}