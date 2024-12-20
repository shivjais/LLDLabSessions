package GenericsCollection;

public class GenericPair <T,V>{
    T first;
    V second;

    //For static method we can't use non-static type (T & V) in method
    //So we can't use T & V type inside static method
    //<S,K> means we can pass 2 param of S & K
    //S is return type of below method
    public static <S,K> S doSomething(S data){
        System.out.println(data);
        return data;
    }

    //Non-Static method
    public T fun1(T data, V data1){
        System.out.println(data);
        return data;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }


}
