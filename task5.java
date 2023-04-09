//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
// является ли входная строка логически правильной.
// Входная строка логически правильная, если:
// 1) Открытые скобки должны быть закрыты скобками того же типа.
// 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
// открытую скобку того же типа.
// ()[] = true
// () = true
// {[()]} = true
// ()() = true
// )()( = false

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class task5 {
   
    public static void main(String[] args) {

        String[] arr = {"()[]", "()", "{[()]}", "()()", ")()("};
        for (int i = 0; i < arr.length; i++) {
            String deque = arr[i];
            System.out.printf("%s = ", arr[i]);
            System.out.println(validate(deque));
        }
    }
    private static boolean validate(String deque) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (Character c: deque.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            }
            else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
