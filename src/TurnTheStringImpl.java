import java.util.Scanner;

public class TurnTheStringImpl implements ITurnTheString {

    protected String word; // переменная для сохранения введенного пользователем слова
    protected char[] wordArray; // массив для сохранения введенного слова посимвольно
    private int currentSize; // переменная для хранения размера массива символов
    private int wordSize; // переменная для хранения размера введенного слова

    Scanner scan = new Scanner(System.in);

    protected TurnTheStringImpl(){
        currentSize = 0;
        TurnTheStringImpl.this.userWord(); // запускает метод считывания введенного слова и количества букв
        this.wordArray = new char[wordSize];
    }

    String userWord(){
        System.out.println("Введите Ваше слово");
        this.word = scan.nextLine();
        System.out.println("Введите число сколько букв в Вашем слове");
        this.wordSize = scan.nextInt();
        return word;
    }

    @Override
    public char pop() {
        return this.wordArray[--currentSize];
    }

    @Override
    public void push(char character) {
       this.wordArray[currentSize++] = character;

    }

    @Override
    public char peek() {
        return this.wordArray[currentSize - 1];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

}
