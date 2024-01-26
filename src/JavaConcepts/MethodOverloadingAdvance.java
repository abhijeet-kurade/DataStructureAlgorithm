package JavaConcepts;

import java.awt.event.PaintEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MethodOverloadingAdvance {

    public static void main(String[] args) {

        List<Parent> listp = new ArrayList<>();
        listp.add(new Child());
    }

    static class  Parent {
        public Parent() {
            System.out.println("Parent");
        }

        public void method(){
            System.out.println("Method from parent");
        }
    }
    static class Child extends Parent{
        public Child() {
            System.out.println("Child");
        }

        public void method(){
            System.out.println("Method from child");
        }
    }
    public static void method(Parent p){
        p.method();
    }
    public static void method(List<? extends Objects> list){
        //list.get(0).method();
    }

}
