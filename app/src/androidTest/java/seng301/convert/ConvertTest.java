package seng301.convert;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;
import com.robotium.solo.Solo;
import java.text.DecimalFormat;

public class ConvertTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public ConvertTest() {
        super(Conversion.class);
    }

    @Override
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

    public void testRandomPositiveNumber() throws Exception{
        solo.unlockScreen();
        int vInputNumber = randomWithRange(0,999999);
        int vMulNumber = 86400;
        int vMulNumber2 = 1440;
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*Double.valueOf(vMulNumber)));
        String vResult2 = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*Double.valueOf(vMulNumber2)));

        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);

        solo.pressSpinnerItem(0, 6);
        solo.pressSpinnerItem(1, 3);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(vResult));
        TextView result = (TextView) solo.getView(R.id.secondValue);
        assertEquals(vResult2, result.getText().toString());
    }

    public void testRandomNegativeNumber() throws Exception{
        solo.unlockScreen();
        int vInputNumber = randomWithRange(0,-999999);
        int vMulNumber = 144;
        double vMulNumber2 = 9.290304e-8;
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*Double.valueOf(vMulNumber)));
        String vResult2 = Double.toString(roundDecimals(Double.valueOf(vInputNumber) * vMulNumber2));

        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);

        solo.pressSpinnerItem(0, 0);
        solo.pressSpinnerItem(1, 1);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(vResult));
        TextView result = (TextView) solo.getView(R.id.sixthValue);
        assertEquals(vResult2, result.getText().toString());
    }

    public void testLargeNumber() throws Exception{
        solo.unlockScreen();
        double vInputNumber = 1922337203.6854775807e10;
        double vMulNumber = 4168181825.4;
        double vMulNumber2 = 41681818254e5;
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*vMulNumber));
        String vResult2 = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*vMulNumber2));

        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);

        solo.pressSpinnerItem(0, 8);
        solo.pressSpinnerItem(1, 11);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(vResult));
        TextView result = (TextView) solo.getView(R.id.firstValue);
        assertEquals(vResult2, result.getText().toString());
    }

    public void testSmallNumber() throws Exception{
        solo.unlockScreen();
        double vInputNumber = -1922337203.6854775807e10;
        double vMulNumber = 0.2;
        double vMulNumber2 = 2.3991275858e-16;
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*vMulNumber));
        String vResult2 = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*vMulNumber2));

        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);

        solo.pressSpinnerItem(0, 8);
        solo.pressSpinnerItem(1, 0);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(vResult));
        TextView result = (TextView) solo.getView(R.id.twelfthValue);
        assertEquals(vResult2, result.getText().toString());
    }

    public void testImproperDigits() throws Exception{
        solo.unlockScreen();
        String vInputNumber = ".";
        String vInputNumber2 = "-";
        String vInputNumber3 = "9.3.3";
        String vInputNumber4 = "-933-3";
        String vInputNumber5 = "-9.3-3";
        String vInputNumber6 = "-9.3.3";
        String vInputNumber7 = "-9.3.-3";
        double vInputNumber8 = -9.3;
        double vMulNumber = 0.393701;
        String error = "Too many decimal points. Maximum 1.";
        String error2 = "Please include only one -.\nAnd limit it to the beginning.";
        String error3 = "Please enter a numerical value.";
        String vResult = Double.toString(roundDecimals(vInputNumber8*vMulNumber));

        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);

        solo.pressSpinnerItem(0, 2);
        solo.pressSpinnerItem(1, 1);
        solo.enterText(vEditTextInput, vInputNumber);
        solo.clickOnButton("Convert");
        assertFalse(solo.searchText(error));
        assertFalse(solo.searchText(error2));
        assertTrue(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, vInputNumber2);
        solo.clickOnButton("Convert");
        assertFalse(solo.searchText(error));
        assertFalse(solo.searchText(error2));
        assertTrue(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, vInputNumber3);
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(error));
        assertFalse(solo.searchText(error2));
        assertFalse(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, vInputNumber4);
        solo.clickOnButton("Convert");
        assertFalse(solo.searchText(error));
        assertTrue(solo.searchText(error2));
        assertFalse(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, vInputNumber5);
        solo.clickOnButton("Convert");
        assertFalse(solo.searchText(error));
        assertTrue(solo.searchText(error2));
        assertFalse(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, vInputNumber6);
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(error));
        assertFalse(solo.searchText(error2));
        assertFalse(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, vInputNumber7);
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(error));
        assertFalse(solo.searchText(error2));
        assertFalse(solo.searchText(error3));

        solo.clearEditText(vEditTextInput);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber8));
        solo.clickOnButton("Convert");
        assertTrue(solo.searchText(vResult));
    }

    public void testInputEmpty() throws Exception{
        solo.unlockScreen();
        String vResult = "";

        EditText vEditTextInput = (EditText) solo.getView(R.id.inputText);

        solo.pressSpinnerItem(0, 0);
        solo.pressSpinnerItem(1, 3);
        solo.enterText(vEditTextInput, "");
        solo.clickOnButton("Convert");
        TextView result = (TextView) solo.getView(R.id.firstValue);
        TextView result2 = (TextView) solo.getView(R.id.fifthValue);
        TextView result3 = (TextView) solo.getView(R.id.seventhValue);
        assertEquals(vResult, result.getText().toString());
        assertEquals(vResult, result2.getText().toString());
        assertEquals(vResult, result3.getText().toString());
    }

    public double roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##########E0");
        return Double.valueOf(twoDForm.format(d));
    }

    int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }
}