package GenericsCollection.withoutGenerics;

//A non-generic class can have generic method as well
public class PairWithoutGenerics {
    Object first;
    Object second;

    //we must need to pass <T,S> in method signature in non-generic class
    //because <T,S> refer type of param
    //at compiler time compiler need to know what ts type of param
    public <T,S> S genericMethod(T first, S second){
        return second;
    }
}
