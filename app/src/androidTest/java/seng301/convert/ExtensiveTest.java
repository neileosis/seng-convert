package seng301.convert;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;
import com.robotium.solo.Solo;
import java.util.Random;
import java.text.DecimalFormat;

public class ExtensiveTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public ExtensiveTest() {
        super(Conversion.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testFull() throws Exception{
        solo.unlockScreen();
        int vInputNumber = randomWithRange(0,999999);
        int vMulNumber = 88;
        Double vMulNumber2 = 0.0166666667;
        String vResult = Double.toString(roundDecimals(vInputNumber*vMulNumber));
        String vResult2 = Double.toString(roundDecimals(vInputNumber*vMulNumber2));

        //go to special formulas page and test area of a circle
        solo.clickOnActionBarHomeButton();
        solo.clickInList(2);
        EditText vEditTextInput2 = (EditText) solo.getView(R.id.radiusIn);
        String vInputNumber2 = String.valueOf(randomWithRange(0,999999));
        String vResult3 = Double.toString(roundDecimals2(Double.valueOf(vInputNumber2)*Double.valueOf(vInputNumber2)*Math.PI));
        solo.enterText(vEditTextInput2, String.valueOf(vInputNumber2));
        solo.clickOnButton(1);
        assertTrue(solo.waitForText(vResult3));

        //go to options page and test by clicking a button to change the background color
        solo.clickOnActionBarHomeButton();
        solo.clickInList(4);
        int randomButton = randomWithRange(0,5);
        solo.clickOnButton(randomButton);
        buttonTest(randomButton);

        //select the convert page and do a conversion of a random number
        solo.clickOnActionBarHomeButton();
        solo.clickInList(1);

        solo.pressSpinnerItem(0, 4);
        solo.pressSpinnerItem(1, 4);
        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        assertTrue(solo.searchText(vResult));
        TextView result = (TextView) solo.getView(R.id.fourthValue);
        assertEquals(vResult2, result.getText().toString());

        //select the special formulas page and test the circumference of a circle
        solo.clickOnActionBarHomeButton();
        solo.clickInList(2);
        EditText vEditTextInput3 = (EditText) solo.getView(R.id.radiusIn2);
        String vInputNumber3 = String.valueOf(randomWithRange(0,999999));
        String vResult4 = Double.toString(roundDecimals2(2*Double.valueOf(vInputNumber3)*Math.PI));
        solo.enterText(vEditTextInput3, String.valueOf(vInputNumber3));
        solo.clickOnButton(2);
        assertTrue(solo.waitForText(vResult4));

        //test entering a custom color to change the background color
        solo.clickOnActionBarHomeButton();
        solo.clickInList(4);
        EditText vEditTextInput6 = (EditText) solo.getView(R.id.customValue);
        solo.enterText(vEditTextInput6, generateRandomString());
        solo.clickOnButton(6);

        //select the special formulas page and calculate area based on random inputs
        solo.clickOnActionBarHomeButton();
        solo.clickInList(2);
        EditText vEditTextInput4 = (EditText) solo.getView(R.id.lengthIn);
        EditText vEditTextInput5 = (EditText) solo.getView(R.id.widthIn);
        String vInputNumber4 = String.valueOf(randomWithRange(0,999999));
        String vInputNumber5 = String.valueOf(randomWithRange(0,999999));
        String vResult5 = Double.toString(roundDecimals2(Double.valueOf(vInputNumber4)*Double.valueOf(vInputNumber5)));
        solo.enterText(vEditTextInput4, String.valueOf(vInputNumber4));
        solo.enterText(vEditTextInput5, String.valueOf(vInputNumber5));
        solo.clickOnButton(0);
        assertTrue(solo.waitForText(vResult5));
    }

    //round to desired decimal place
    public double roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##########E0");
        return Double.valueOf(twoDForm.format(d));
    }

    //return random number in desired range
    int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }

    //round decimals to desired decimal place
    public double roundDecimals2(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######E0");
        return Double.valueOf(twoDForm.format(d));
    }

    //test if correct button was pressed
    void buttonTest(int button){
        switch (button){
            case 0:
                solo.waitForFragmentByTag("Options",2000);
                assertEquals("#eeeeee", Conversion.bgColor);
                break;
            case 1:
                solo.waitForFragmentByTag("Options",2000);
                assertEquals("#ff9955", Conversion.bgColor);
                break;
            case 2:
                solo.waitForFragmentByTag("Options",2000);
                assertEquals("#a3cfff", Conversion.bgColor);
                break;
            case 3:
                solo.waitForFragmentByTag("Options",2000);
                assertEquals("#b7fec5", Conversion.bgColor);
                break;
            case 4:
                solo.waitForFragmentByTag("Options",2000);
                assertEquals("#ff7373", Conversion.bgColor);
                break;
            case 5:
                solo.waitForFragmentByTag("Options",2000);
                assertEquals("#ffffff", Conversion.bgColor);
                break;
        }

    }

    //2 methods to help create a random test of the custom color function

    private static final String CHAR_LIST = "abcdef1234567890";
    private static final int RANDOM_STRING_LENGTH = 6;
    public String generateRandomString(){
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    }