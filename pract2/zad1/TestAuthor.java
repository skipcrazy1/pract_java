package pract2.zad1;

public class TestAuthor {
    public static void main(String[] args){
        Author author = new Author("Murad", 19);
        System.out.println("Имя " + author.getName() + " ВОзраст: "+ author.getAge());
        author.setName("Silvester");
        author.setAge(100);
        System.out.println(author);
    }
}
