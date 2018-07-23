public class Link extends LinkImpl {

    private String name;
    private int age;

    protected Link nextItem;

    public Link(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void setNextItem(Link nextItem){
        this.nextItem = nextItem;
    }

    public Link getNextItem() {
        return nextItem;
    }


    public void display(){
        System.out.println("Name: " + this.name + " age: " + this.age);
    }
}
