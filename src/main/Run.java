/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author KOCMOC
 */
public class Run {

    public static void main(String[] args) throws MalformedURLException, JDOMException, IOException {
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
        //
//        MyProps props = new MyProps("xml/test.xml");
//        String str_0 = props.getProperty("sql_host");
//        String str_0_1 = props.getAttribute("sql_host", "localhost", "null");
//        String str_1 = props.getAttribute("PARENT", "children", "null");
//        String str_2 = props.getAttribute("PARENT","child1", "chldAttr1", "null");
//        //
//        //
//        System.out.println("" + str_0);
//        System.out.println("" + str_0_1);
//        System.out.println("" + str_1);
//        System.out.println("" + str_2);
        //
        //
//        MyProps props = new MyProps("xml/kobe.xml");
//        String str_0 = props.getProperty("CompData", "CompoundName", "null");
//        String str_1 = props.getProperty("MpRecipeStep", "StepNo", "null");
////
////        //
////        //
//        System.out.println("" + str_0);
//        System.out.println("" + str_1);
        //
        System.out.println(""  +  kobe_get_recipe_name());
        System.out.println(""  +  kobe_get_ammount_of_steps());
    }
    
    public static final String XML_KOBE_MP_CONTROLLER = "xml/kobe.xml";
    public static final String XML_PROPERTY__RECIPE_NAME = "CompoundName";
    public static final String XML_PROPERTY__STEP_NO = "StepNo";

    public static String kobe_get_recipe_name() {
        MyProps props = new MyProps(XML_KOBE_MP_CONTROLLER);
        return props.getProperty("CompData", XML_PROPERTY__RECIPE_NAME, "null");
    }
    
    public static int kobe_get_ammount_of_steps() {
        //
        MyProps props = new MyProps("xml/kobe.xml");
        //
        List<Element> list = props.ROOT.getChildren();
        //
        int step = -1;
        //
        for (Element target : list) {
            //
            Element stepList = target.getChild("StepList");
            //
            List<Element> list_b = stepList.getChildren();
            //
            for (Element target_b : list_b) {
                Element stepNo = target_b.getChild(XML_PROPERTY__STEP_NO);
                String stepNumber = stepNo.getText();
                step = Integer.parseInt(stepNumber);
                System.out.println(""+ step);
            }
            //
        }
        return step;
    }

    public static void kobe_test_a() {
        MyProps props = new MyProps("xml/kobe.xml");
        //
        List<Element> list = props.ROOT.getChildren();
        //
        for (Element target : list) {
            Element stepList = target.getChild("StepList");
            Element recipeStep = stepList.getChild("MpRecipeStep");
            Element stepNo = recipeStep.getChild("StepNo");
            String stepNumber = stepNo.getText();
            System.out.println(stepNumber);
        }
    }

    
}
