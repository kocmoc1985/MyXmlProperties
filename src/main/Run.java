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
//        System.out.println(getRecipeName_kobe());
        //
        MyProps props = new MyProps("xml/test.xml");
        //
        String str_0 = props.getProperty("sql_host");
        //
        String str_0_1 = props.getAttribute("sql_host", "localhost", "null");
        //
        String str_1 = props.getAttribute("PARENT", "children", "null");
        //
        String str_2 = props.getAttribute("PARENT","child1", "chldAttr1", "null");
        //
        System.out.println("" + str_0);
        System.out.println("" + str_0_1);
        System.out.println("" + str_1);
        System.out.println("" + str_2);
    }
    
    public static final String XML_KOBE_MP_CONTROLLER = "xml/test.xml";
    public static final String XML_PROPERTY__RECIPE_NAME = "sql_host";
    public static final String XML_PROPERTY__AMMOUNT_OF_STEPS = "";
    
    public static String getRecipeName_kobe(){
        MyProps props = new MyProps(XML_KOBE_MP_CONTROLLER);
        String recipeName = props.getProperty(XML_PROPERTY__RECIPE_NAME);
        return recipeName;
    }
    
     public static String getAmmountOfSteps_kobe(){
        MyProps props = new MyProps(XML_KOBE_MP_CONTROLLER);
        String steps = props.getProperty(XML_PROPERTY__AMMOUNT_OF_STEPS);
        return steps;
    }
}
