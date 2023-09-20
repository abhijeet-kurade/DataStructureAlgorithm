package DynamicProgramming.LeetcodeDP.GeneralMultimesional;

public class PaintHouse {

    public static void main(String[] args) {
        System.out.println('j'+'a'+'v'+'a');
        Base b = Base.create();
    }


}

class Base{
    public void meth(){
        System.out.println("base");
    }

    protected static Base create(){
        return null;
    }
}

class Derived extends Base{
    private static int data;
    public Derived(){
        data = 25;
    }
    public void meth(){

        System.out.println("derived");
    }
}
