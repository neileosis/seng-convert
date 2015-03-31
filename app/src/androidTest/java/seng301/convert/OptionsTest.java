package seng301.convert;

import android.graphics.Point;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;
import com.robotium.solo.Solo;
import java.text.DecimalFormat;

public class OptionsTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public OptionsTest() {
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

    //test changing a color
    public void testSingleColorChange() throws Exception{
        solo.unlockScreen();
        solo.clickOnActionBarHomeButton();
        solo.clickInList(4);
        int randomButton = randomWithRange(0,5);
        solo.clickOnButton(randomButton);
        buttonTest(randomButton);
    }

    //test changing three colors at once
    public void testThreeColorChange() throws Exception{
        solo.unlockScreen();
        solo.clickOnActionBarHomeButton();
        solo.clickInList(4);
        int randomButton = randomWithRange(0,5);
        solo.clickOnButton(randomButton);
        buttonTest(randomButton);
        int randomButton2 = randomWithRange(0,5);
        solo.clickOnButton(randomButton2);
        buttonTest(randomButton2);
        solo.clickOnActionBarHomeButton();
        solo.clickInList(3);
        solo.drag(50, 50, 150, 50, 5);
        solo.clickOnActionBarHomeButton();
        solo.clickInList(4);
        int randomButton3 = randomWithRange(0,5);
        solo.clickOnButton(randomButton3);
        buttonTest(randomButton3);
        solo.clickOnActionBarHomeButton();
        solo.clickInList(1);
    }

    //help testing changing a color
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

    //return random integer within desired range
    int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }

}