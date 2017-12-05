/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author KOCMOC
 */
public class Run {

    public static void main(String[] args) {
        //
        // EXAMPLES OF WRITE
        //
//        MyXMLBasic basics = new MyXMLBasic("TEST");
//        basics.example1();
//        basics.testWrite();
        //
        //
        // EXAMPLES OF READING
        //
        //
        MyProps props = new MyProps("xml/test.xml");
        //
        String str_1 = props.getAttribute("PARENT", "children", "null");
        //
        String str_2 = props.getAttribute("PARENT","child1", "chldAttr1", "null");
        //
        System.out.println("" + str_1);
        System.out.println("" + str_2);
    }
}
