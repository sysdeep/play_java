import core.logic.models.*;

public class MainTest{
    public static void main(String args[]){

        Attr attr = new Attr();
        attr.setName("igor");

        System.out.println("MainTest!");
        System.out.println(attr.getName());

        attr.name = "opa";
        System.out.println(attr.getName());
    }
}