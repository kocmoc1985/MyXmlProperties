/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author KOCMOC
 */
public class ParamStr {

    private String initialParamStr;
    private static String PARAMETERS_TO_SEND;
    private boolean EMPTY = false;
    //
    private String PROBE = "PROBE"; // is not sent to the test device
    private String CHARGE = "CHARGE"; // is not sent to the test device
    private String MISH = "MISH"; // is not sent to the test device
    private String TEMP_TOLERANCE = "TT"; // is not sent to the test device
    private String TEMP = "T";
    private String TEST_TIME = "MZ";
    private String AMPLITUDE = "W";
    private String FREQUENCY = "F";
    //
    private HashMap<String, String> basicInfoMap = new HashMap<String, String>();
    //
    private boolean oneTimeFlag = true;
    private int CHARGE_NR = 0;

    //PROBE:ABC-105,CHARGE:ABC,MISH:x548,TT:0.5,MZ:5,T:100,F:0.833,W:3.5
    public ParamStr(String paramstr) {
        this.initialParamStr = paramstr;
        extract(initialParamStr);
        extractB(initialParamStr);
    }

    public boolean getEmpty() {
        return EMPTY;
    }

    public String getInitialParamString() {
        return initialParamStr;
    }
    
     public String getParametersToSend() {
        return PARAMETERS_TO_SEND;
    }

    public String getPROBE() {
        return basicInfoMap.get(PROBE);
    }

    public void increaseChargeNr() {
        CHARGE_NR++;
    }
    
   
    public String getCHARGE() {
        //
        if (oneTimeFlag) {
            oneTimeFlag = false;
            //
            String batch = basicInfoMap.get(CHARGE);
            //
            if (true) {
                CHARGE_NR = Integer.parseInt(batch);
                return "" + CHARGE_NR;
            } else {
                return "" + CHARGE_NR;
            }
            //
        } else {
            return "" + CHARGE_NR;
        }
        //
    }

    public String getMISH() {
        return basicInfoMap.get(MISH);
    }

    public String getTempTolerance() {
        return basicInfoMap.get(TEMP_TOLERANCE);
    }

    public String getTemperature() {
        return basicInfoMap.get(TEMP);
    }

    public String getTestTime() {
        return basicInfoMap.get(TEST_TIME);
    }

    public String getAmplitude() {
        return basicInfoMap.get(AMPLITUDE);
    }

    public String getFrequency() {
        return basicInfoMap.get(FREQUENCY);
    }

    private void extractB(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        //
        String[] arr = str.split(",");
        //
        for (String rst : arr) {
            String[] arr2 = rst.split(":");
            if (arr2 != null && arr2[0] != null && arr2[1] != null) {
                basicInfoMap.put(arr2[0], arr2[1]);
            } else {
                return;
            }
        }
    }
    private ArrayList<String> PARAM_SET = new ArrayList<String>();

    private void extract(String str) {
        if (str == null || str.isEmpty()) {
            EMPTY = true;
            return;
        }
        //
        String[] arr = str.split(",");
        //
        if (arr == null) {
            return;
        }
        //
        PARAM_SET.addAll(Arrays.asList(arr));
        //
        PARAMETERS_TO_SEND = "PAR:";
        //
        for (String param : PARAM_SET) {
            if (checkParam(param)) {
                PARAMETERS_TO_SEND += param + ",";
            }
        }
        //
        PARAMETERS_TO_SEND = delete_last_letter_in_string(PARAMETERS_TO_SEND);
        //
        System.out.println(PARAMETERS_TO_SEND);
        //
    }

    /**
     * PAR:MZ:10,T:100,F:0.833,W:3.2
     *
     * @param param
     * @return
     */
    private boolean checkParam(String param) {
        if (param.contains(PROBE) == false && param.contains(CHARGE) == false
                && param.contains(MISH) == false && param.contains(TEMP_TOLERANCE) == false) {
            return true;
        } else {
            return false;
        }
    }

    public static String delete_last_letter_in_string(String str) {
        int a = str.length() - 1;
        return str.substring(0, a);
    }
}
