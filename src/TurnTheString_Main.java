import java.util.Arrays;

public class TurnTheString_Main {

    public static void main(String[] args) {

        TurnTheString_Impl userWord = new TurnTheString_Impl();

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
