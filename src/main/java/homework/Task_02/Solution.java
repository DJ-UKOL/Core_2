package homework.Task_02;

import java.util.Arrays;

/*
 * Задача №2 - на вход подается массив и число.
 * Нужно вывести первую пару чисел, которые дают в сумме число.
 * [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
 */
public class Solution {

    public static void main (String[] args)
    {
        int[] nums = {3, 4, 2, 7};
        int target = 10;
        // Выводим массив в консоль
        System.out.print(Arrays.toString(nums) + ", " + target + " -> ");
        System.out.println(Arrays.toString(findOneFirstPair(nums, target)));
    }

    // Функция поиска пары в массиве с заданной суммой
    // nums - входной массив
    // target - заданная сумма
    public static int[] findOneFirstPair(int[] nums, int target)
    {
        int[] result = new int[2];
        // Проходим в цикле по всем элементам в массиве nums, кроме последнего
        for (int i = 0; i < nums.length - 1; i++)
        {
            // начинаем с i-го элемента до последнего элемента
            for (int j = i + 1; j < nums.length; j++)
            {
                // если искомая сумма найдена,
                if (nums[i] + nums[j] == target)
                {
                    // Включаем данные в массивж
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }
        return result;
    }
}