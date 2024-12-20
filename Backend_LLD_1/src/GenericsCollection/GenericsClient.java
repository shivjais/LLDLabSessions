package GenericsCollection;

public class GenericsClient {
    public static void main(String[] args) {
        GenericPair<String,Integer> indiaPop = new GenericPair<>();
        indiaPop.setFirst("Shivam");
        indiaPop.setSecond(20);
        //Compile time type safety is present
        //indiaPop.setFirst(25); //CTE

        //You are allowed to not mentioned anything
        // this is for backward compatibility
        GenericPair gp = new GenericPair();

        //Both are same
        //We are calling static method here
        String s1 = GenericPair.doSomething("Shivam");
        String s2 = GenericPair.<String,Integer>doSomething("Shivam");
    }
}
