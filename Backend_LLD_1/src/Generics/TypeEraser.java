package Generics;

import java.util.List;

//Due to type eraser List of any type will become List of object at runtime
public class TypeEraser {

    //due to type eraser method signature will be
    //void fun(List<Object> list)
    public void fun(List<Integer> list){

    }

    //due to type eraser method signature will be
    //void fun(List<Object> list)
    //hence we are getting CTE for below method
    
    /*public void fun(List<String> list){

    }*/
}
