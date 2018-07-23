import java.util.Arrays;

public class TurnTheStringMain {

    public static void main(String[] args) {

        TurnTheStringImpl userWord = new TurnTheStringImpl();

        for (int i = 0; i < userWord.word.length(); i++) { // заполнение массива в объекте userWord посимвольно буквами из введенного слова
            userWord.push(userWord.word.charAt(i));
        }
        System.out.print(Arrays.toString(userWord.wordArray)); // для наглядности заполнения стека
        System.out.println(" ");

        while (!userWord.isEmpty()) { // пока массив из объекта не пуст выводим top символ из стека, затем его удаляем, чтобы получить доступ к следующему символу
            System.out.print(userWord.peek());
            userWord.pop();
        }
    }
}
