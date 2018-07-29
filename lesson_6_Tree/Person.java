package geek;

public class Person {

    private final String name; //нужно ли писать заглавными NAME
//    private final int age;
    private final int id;

    public Person(String name, int id) {
        this.name = name;
//        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    public int getAge() {
//        return age;
//    }

    public int getId() {
        return id;
    }

    // генерация метода equals для сравнения. Метод получает на вход Объект и сравнивает его с объектом Person
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o; // убирает в переменную полученный объект с приведением его к типу Person
        return id == person.id;// возвращает true, если id равен полученному id объекта Person
    }

    //генерация медода выводящего в строку элементы Объекта
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
//                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
