package seng301.convert;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import com.robotium.solo.Solo;
import java.text.DecimalFormat;

public class SpecialFormulasTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public SpecialFormulasTest() {
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

    public void testRandomNumberFormula1() throws Exception{
        solo.unlockScreen();
        solo.clickOnActionBarHomeButton();
        solo.clickInList(2);
        String vInputNumber = String.valueOf(randomWithRange(0,999999));
        String vInputNumber2 = String.valueOf(randomWithRange(0,999999));
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*Double.valueOf(vInputNumber2)));
        EditText vEditTextInput = (EditText) solo.getView(R.id.lengthIn);
        EditText vEditTextInput2 = (EditText) solo.getView(R.id.widthIn);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton(0);
        assertTrue(solo.searchText("Please enter numbers in both boxes."));
        solo.enterText(vEditTextInput2, String.valueOf(vInputNumber2));
        solo.clickOnButton(0);
        assertTrue(solo.waitForText(vResult));
    }

    public void testRandomNumberFormula2() throws Exception{
        solo.unlockScreen();
        solo.clickOnActionBarHomeButton();
        solo.clickInList(2);
        String vInputNumber = String.valueOf(randomWithRange(0,999999));
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*Double.valueOf(vInputNumber)*Math.PI));
        EditText vEditTextInput = (EditText) solo.getView(R.id.radiusIn);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton(1);
        assertTrue(solo.waitForText(vResult));
    }

    public void testRandomNumberFormula3() throws Exception{
        solo.unlockScreen();
        solo.clickOnActionBarHomeButton();
        solo.clickInList(2);
        String vInputNumber = String.valueOf(randomWithRange(0,999999));
        String vResult = Double.toString(roundDecimals(Double.valueOf(vInputNumber)*2*Math.PI));
        EditText vEditTextInput = (EditText) solo.getView(R.id.radiusIn2);
        solo.enterText(vEditTextInput, String.valueOf(vInputNumber));
        solo.clickOnButton(2);
        assertTrue(solo.waitForText(vResult));
    }

    public double roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######E0");
        return Double.valueOf(twoDForm.format(d));
    }

    int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }

}
