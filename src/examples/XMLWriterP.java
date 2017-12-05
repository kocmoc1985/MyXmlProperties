/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import other.ParamStr;
import main.MyXMLBasic;


/**
 *
 * @author KOCMOC
 */
public class XMLWriterP extends MyXMLBasic {

    private final static String PATH = "parameters/";

    static {
//        HelpM.create_dir_if_missing(PATH);
    }

    public XMLWriterP(String nameOfRootElem) {
        super(nameOfRootElem);
    }

    public void finalizeXMlDoc(ParamStr str) {
        build(str);
        String path = PATH + str.getPROBE() + "_" + str.getCHARGE() + "_" + str.getMISH() + ".xml";
        writeXMLDocToFile(path, false, false);
    }

    private void build(ParamStr str) {
        ELEMENT recievedParamStr = new ELEMENT("RecievedParamStr", str.getInitialParamString());
        ELEMENT sentParamStr = new ELEMENT("SentParamStr", str.getParametersToSend());
        ELEMENT probe = new ELEMENT("Probe", str.getPROBE());
        ELEMENT charge = new ELEMENT("Charge", str.getCHARGE());
        ELEMENT mishung = new ELEMENT("Mischung", str.getMISH());
        ELEMENT temp = new ELEMENT("Temperature", str.getTemperature());
        ELEMENT tempTolerance = new ELEMENT("TempTolerance", str.getTempTolerance());
        ELEMENT testTime = new ELEMENT("TestTime", str.getTestTime());
        ELEMENT amplitude = new ELEMENT("Amplitude", str.getAmplitude());
        ELEMENT frequency = new ELEMENT("Frequency", str.getFrequency());
        //
        addElement(recievedParamStr);
        addElement(sentParamStr);
        addElement(probe);
        addElement(charge);
        addElement(mishung);
        addElement(temp);
        addElement(tempTolerance);
        addElement(testTime);
        addElement(amplitude);
        addElement(frequency);
    }
}
