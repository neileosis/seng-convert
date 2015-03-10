package seng301.convert;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Convert extends Fragment {
    View rootview;
    public Spinner firstSpinner, areaSpn, binSpn, distSpn, spdSpn, infoSpn, tempSpn, timeSpn, wgtSpn, volSpn;
    public int decCount, dashCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.convert_layout, container, false);
        rootview.setBackgroundColor(Color.parseColor(Conversion.bgColor));
        return rootview;
    }

    public void onStart() {
        super.onStart();
        final TextView input = (TextView) rootview.findViewById(R.id.inputText);
        Button quickSet1 = (Button) rootview.findViewById(R.id.quickSet1);
        Button quickSet2 = (Button) rootview.findViewById(R.id.quickSet2);
        Button quickSet3 = (Button) rootview.findViewById(R.id.quickSet3);
        Button quickSet4 = (Button) rootview.findViewById(R.id.quickSet4);
        Button quickSet5 = (Button) rootview.findViewById(R.id.quickSet5);
        quickSet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("0.25");
            }});
        quickSet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("0.5");
            }});
        quickSet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("1");
            }});
        quickSet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("5");
            }});
        quickSet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("10");
            }});

        chooseCategory();
        chooseArea();
        chooseBin();
        chooseDist();
        chooseInfo();
        chooseSpd();
        chooseTemp();
        chooseTime();
        chooseWgt();
        chooseVol();
    }

    public void chooseCategory() {

        firstSpinner = (Spinner) rootview.findViewById(R.id.unitSpinner2);
        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.units, android.R.layout.simple_spinner_item);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpinner.setAdapter(firstAdapter);
        firstSpinner.setOnItemSelectedListener(new planOnClickListener());
    }

    private void chooseArea() {
        areaSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> areaList = new ArrayList<String>();
        areaList.add("Square Inches");
        areaList.add("Square Feet");
        areaList.add("Square Meters");
        areaList.add("Acres");
        areaList.add("Hectares");
        areaList.add("Square Kilometers");
        areaList.add("Square Miles");
        ArrayAdapter<String> areaAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, areaList);
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpn.setAdapter(areaAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = areaSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Square Inches": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.006944444444444444));
                        thirdValue.setText(convertNumber(0.00064516));
                        fourthValue.setText(convertNumber(1.5942250790735638e-7));
                        fifthValue.setText(convertNumber(6.4516e-8));
                        sixthValue.setText(convertNumber(6.4516e-10));
                        seventhValue.setText(convertNumber(2.4909766860524435e-10));
                        break;
                    }
                    case "Square Feet": {
                        firstValue.setText(convertNumber(144));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(0.09290304));
                        fourthValue.setText(convertNumber(0.00002295684113865932));
                        fifthValue.setText(convertNumber(0.000009290304));
                        sixthValue.setText(convertNumber(9.290304e-8));
                        seventhValue.setText(convertNumber(3.587006427915519e-8));
                        break;
                    }
                    case "Square Meters": {
                        firstValue.setText(convertNumber(1550.0031000062));
                        secondValue.setText(convertNumber(10.763910416709722));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.0002471053814671653));
                        fifthValue.setText(convertNumber(0.0001));
                        sixthValue.setText(convertNumber(0.000001));
                        seventhValue.setText(convertNumber(3.8610215854244587e-7));
                        break;
                    }
                    case "Acres": {
                        firstValue.setText(convertNumber(6272640));
                        secondValue.setText(convertNumber(43560));
                        thirdValue.setText(convertNumber(4046.8564224));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(0.40468564224));
                        sixthValue.setText(convertNumber(0.0040468564224));
                        seventhValue.setText(convertNumber(0.0015625));
                        break;
                    }
                    case "Hectares": {
                        firstValue.setText(convertNumber(15500031.000062));
                        secondValue.setText(convertNumber(107639.10416709722));
                        thirdValue.setText(convertNumber(10000));
                        fourthValue.setText(convertNumber(2.4710538146716536));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(0.01));
                        seventhValue.setText(convertNumber(0.0038610215854244585));
                        break;
                    }
                    case "Square Kilometers": {
                        firstValue.setText(convertNumber(1550003100.0062));
                        secondValue.setText(convertNumber(10763910.416709723));
                        thirdValue.setText(convertNumber(1000000));
                        fourthValue.setText(convertNumber(247.10538146716533));
                        fifthValue.setText(convertNumber(100));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.38610215854244584));
                        break;
                    }
                    case "Square Miles": {
                        firstValue.setText(convertNumber(40144896e+2));
                        secondValue.setText(convertNumber(27878400));
                        thirdValue.setText(convertNumber(2589988.110336));
                        fourthValue.setText(convertNumber(640));
                        fifthValue.setText(convertNumber(258.9988110336));
                        sixthValue.setText(convertNumber(2.589988110336));
                        seventhValue.setText(convertNumber(1));
                        break;
                    }
                }
            }
        });
    }

    private void chooseBin() {
        binSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> binList = new ArrayList<String>();
        binList.add("Binary");
        binList.add("Decimal");
        binList.add("Hexadecimal");
        ArrayAdapter<String> binAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, binList);
        binAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binSpn.setAdapter(binAdapter);
        binSpn.setOnItemSelectedListener(new planOnClickListener2());
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = binSpn.getSelectedItem().toString();
                final EditText inputValue = (EditText) rootview.findViewById(R.id.inputTextDec);
                final EditText inputValue2 = (EditText) rootview.findViewById(R.id.inputTextHex);
                final EditText inputValue3 = (EditText) rootview.findViewById(R.id.inputTextBin);
                String input = inputValue.getText().toString();
                String input2 = inputValue2.getText().toString();
                String input3 = inputValue3.getText().toString();
                switch (selection) {
                    case "Binary": {
                        if (!input3.matches("") && !errorCheck(input3)){                                                  //check to see if input is empty or error
                        firstValue.setText(input3);
                        secondValue.setText(String.valueOf(Integer.parseInt(input3, 2)));
                        thirdValue.setText(Integer.toHexString(Integer.parseInt(input3, 2)));
                        break;
                    }}
                    case "Decimal": {
                        if (!input.matches("") && !errorCheck(input)){                                                   //check to see if input is empty or error
                        firstValue.setText(Integer.toBinaryString(Integer.parseInt(input)));
                        secondValue.setText(input);
                        thirdValue.setText(Integer.toHexString(Integer.parseInt(input)));
                        break;
                    }}
                    case "Hexadecimal": {
                        if (!input2.matches("") && !errorCheck(input2)){                                                  //check to see if input is empty or error
                        firstValue.setText(Integer.toBinaryString(Integer.parseInt(input2, 16)));
                        secondValue.setText(String.valueOf(Integer.parseInt(input2, 16)));
                        thirdValue.setText(input2);
                        break;
                    }}
                }
            }
        });

    }

    private void chooseDist() {
        distSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> distList = new ArrayList<String>();
        distList.add("Millimeters");
        distList.add("Centimeters");
        distList.add("Meters");
        distList.add("Kilometers");
        distList.add("Inches");
        distList.add("Feet");
        distList.add("Yards");
        distList.add("Miles");
        ArrayAdapter<String> distAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, distList);
        distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distSpn.setAdapter(distAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        final TextView eighthValue = (TextView) rootview.findViewById(R.id.eighthValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = distSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Millimeters": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.01));
                        thirdValue.setText(convertNumber(0.001));
                        fourthValue.setText(convertNumber(0.000001));
                        fifthValue.setText(convertNumber(0.0393701));
                        sixthValue.setText(convertNumber(0.00328084));
                        seventhValue.setText(convertNumber(0.00109361));
                        eighthValue.setText(convertNumber(0.00000062137));
                        break;
                    }
                    case "Centimeters": {
                        firstValue.setText(convertNumber(10));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(0.01));
                        fourthValue.setText(convertNumber(0.00001));
                        fifthValue.setText(convertNumber(0.393701));
                        sixthValue.setText(convertNumber(0.0328084));
                        seventhValue.setText(convertNumber(0.0109361));
                        eighthValue.setText(convertNumber(0.0000062137));
                        break;
                    }
                    case "Meters": {
                        firstValue.setText(convertNumber(1000));
                        secondValue.setText(convertNumber(100));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.001));
                        fifthValue.setText(convertNumber(39.3701));
                        sixthValue.setText(convertNumber(3.28084));
                        seventhValue.setText(convertNumber(1.09361));
                        eighthValue.setText(convertNumber(0.000621371));
                        break;
                    }
                    case "Kilometers": {
                        firstValue.setText(convertNumber(1000000));
                        secondValue.setText(convertNumber(100000));
                        thirdValue.setText(convertNumber(1000));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(39370.1));
                        sixthValue.setText(convertNumber(3280.84));
                        seventhValue.setText(convertNumber(1093.61));
                        eighthValue.setText(convertNumber(0.621371));
                        break;
                    }
                    case "Inches": {
                        firstValue.setText(convertNumber(25.4));
                        secondValue.setText(convertNumber(2.54));
                        thirdValue.setText(convertNumber(0.0254));
                        fourthValue.setText(convertNumber(0.0000254));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(0.0833333));
                        seventhValue.setText(convertNumber(0.0277778));
                        eighthValue.setText(convertNumber(0.000015783));
                        break;
                    }
                    case "Feet": {
                        firstValue.setText(convertNumber(304.8));
                        secondValue.setText(convertNumber(30.48));
                        thirdValue.setText(convertNumber(0.3048));
                        fourthValue.setText(convertNumber(0.0003048));
                        fifthValue.setText(convertNumber(12));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.333333));
                        eighthValue.setText(convertNumber(0.000189394));
                        break;
                    }
                    case "Yards": {
                        firstValue.setText(convertNumber(914.4));
                        secondValue.setText(convertNumber(91.44));
                        thirdValue.setText(convertNumber(0.9144));
                        fourthValue.setText(convertNumber(0.0009144));
                        fifthValue.setText(convertNumber(36));
                        sixthValue.setText(convertNumber(3));
                        seventhValue.setText(convertNumber(1));
                        eighthValue.setText(convertNumber(0.000568182));
                        break;
                    }
                    case "Miles": {
                        firstValue.setText(convertNumber(1609340));
                        secondValue.setText(convertNumber(160934));
                        thirdValue.setText(convertNumber(1609.34));
                        fourthValue.setText(convertNumber(1.60934));
                        fifthValue.setText(convertNumber(63360));
                        sixthValue.setText(convertNumber(5280));
                        seventhValue.setText(convertNumber(1760));
                        eighthValue.setText(convertNumber(1));
                        break;
                    }
                }
            }
        });

    }

    private void chooseInfo() {
        infoSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> infoList = new ArrayList<String>();
        infoList.add("Bit");
        infoList.add("Byte");
        infoList.add("Kilobyte");
        infoList.add("Megabyte");
        infoList.add("Gigabyte");
        infoList.add("Terabyte");
        infoList.add("Petabyte");
        ArrayAdapter<String> infoAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, infoList);
        infoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infoSpn.setAdapter(infoAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = distSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Bit": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.125));
                        thirdValue.setText(convertNumber(0.0001220703125));
                        fourthValue.setText(convertNumber(1.19209289550781e-07));
                        fifthValue.setText(convertNumber(1.16415321826935e-10));
                        sixthValue.setText(convertNumber(1.13686837721616e-13));
                        seventhValue.setText(convertNumber(1.11022302462516e-16));
                        break;
                    }
                    case "Byte": {
                        firstValue.setText(convertNumber(8));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(0.0009765625));
                        fourthValue.setText(convertNumber(9.5367431640625e-07));
                        fifthValue.setText(convertNumber(9.31322574615479e-10));
                        sixthValue.setText(convertNumber(9.09494701772928e-13));
                        seventhValue.setText(convertNumber(8.88178419700125e-16));
                        break;
                    }
                    case "Kilobyte": {
                        firstValue.setText(convertNumber(8192));
                        secondValue.setText(convertNumber(1024));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.0009765625));
                        fifthValue.setText(convertNumber(7.62939453125e-06));
                        sixthValue.setText(convertNumber(9.31322574615479e-10));
                        seventhValue.setText(convertNumber(9.09494701772928e-13));
                        break;
                    }
                    case "Megabyte": {
                        firstValue.setText(convertNumber(8388608));
                        secondValue.setText(convertNumber(8388608));
                        thirdValue.setText(convertNumber(1024));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(0.0009765625));
                        sixthValue.setText(convertNumber(9.5367431640625e-07));
                        seventhValue.setText(convertNumber(9.31322574615479e-10));
                        break;
                    }
                    case "Gigabyte": {
                        firstValue.setText(convertNumber(8589934592L));
                        secondValue.setText(convertNumber(1073741824));
                        thirdValue.setText(convertNumber(1048576));
                        fourthValue.setText(convertNumber(1024));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(0.0009765625));
                        seventhValue.setText(convertNumber(9.5367431640625e-07));
                        break;
                    }
                    case "Terabyte": {
                        firstValue.setText(convertNumber(8796093022208L));
                        secondValue.setText(convertNumber(1099511627776L));
                        thirdValue.setText(convertNumber(1073741824));
                        fourthValue.setText(convertNumber(1048576));
                        fifthValue.setText(convertNumber(1024));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.0009765625));
                        break;
                    }
                    case "Petabyte": {
                        firstValue.setText(convertNumber(9007199254740992L));
                        secondValue.setText(convertNumber(1.12589990684262e+15));
                        thirdValue.setText(convertNumber(1099511627776L));
                        fourthValue.setText(convertNumber(1073741824));
                        fifthValue.setText(convertNumber(1048576));
                        sixthValue.setText(convertNumber(1024));
                        seventhValue.setText(convertNumber(1));
                        break;
                    }
                }
            }
        });

    }

    private void chooseSpd() {
        spdSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> speedList = new ArrayList<String>();
        speedList.add("Meters per second");
        speedList.add("Kilometers per second");
        speedList.add("Feet per second");
        speedList.add("Miles per second");
        speedList.add("Miles per minute");
        speedList.add("Miles per hour");
        speedList.add("Knots");
        ArrayAdapter<String> speedAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, speedList);
        speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdSpn.setAdapter(speedAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = areaSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Meters per second": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.001));
                        thirdValue.setText(convertNumber(3.28084));
                        fourthValue.setText(convertNumber(0.000621371192));
                        fifthValue.setText(convertNumber(0.0372822715));
                        sixthValue.setText(convertNumber(2.23694));
                        seventhValue.setText(convertNumber(1.94384));
                        break;
                    }
                    case "Kilometers per second": {
                        firstValue.setText(convertNumber(1000));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(3280.8399));
                        fourthValue.setText(convertNumber(0.621371192));
                        fifthValue.setText(convertNumber(37.2822715));
                        sixthValue.setText(convertNumber(2236.93629));
                        seventhValue.setText(convertNumber(1943.84449));
                        break;
                    }
                    case "Feet per second": {
                        firstValue.setText(convertNumber(0.3048));
                        secondValue.setText(convertNumber(0.0003048));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.000189393939));
                        fifthValue.setText(convertNumber(0.0113636364));
                        sixthValue.setText(convertNumber(0.681818));
                        seventhValue.setText(convertNumber(0.592484));
                        break;
                    }
                    case "Miles per second": {
                        firstValue.setText(convertNumber(1609.344));
                        secondValue.setText(convertNumber(1.609344));
                        thirdValue.setText(convertNumber(5280));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(60));
                        sixthValue.setText(convertNumber(3600));
                        seventhValue.setText(convertNumber(0.0015625));
                        break;
                    }
                    case "Miles per minute": {
                        firstValue.setText(convertNumber(26.8224));
                        secondValue.setText(convertNumber(0.0268224));
                        thirdValue.setText(convertNumber(88));
                        fourthValue.setText(convertNumber(0.0166666667));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(60));
                        seventhValue.setText(convertNumber(52.1385745));
                        break;
                    }
                    case "Miles per hour": {
                        firstValue.setText(convertNumber(0.44704));
                        secondValue.setText(convertNumber(0.00044704));
                        thirdValue.setText(convertNumber(1.46667));
                        fourthValue.setText(convertNumber(0.000277777778));
                        fifthValue.setText(convertNumber(0.0166666667));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.868976));
                        break;
                    }
                    case "Knots": {
                        firstValue.setText(convertNumber(0.514444444));
                        secondValue.setText(convertNumber(0.000514444444));
                        thirdValue.setText(convertNumber(1.68781));
                        fourthValue.setText(convertNumber(0.000319660958));
                        fifthValue.setText(convertNumber(0.0191796575));
                        sixthValue.setText(convertNumber(1.15078));
                        seventhValue.setText(convertNumber(1));
                        break;
                    }
                }
            }
        });
    }

    private void chooseTemp() {
        tempSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> tempList = new ArrayList<String>();
        tempList.add("Fahrenheit");
        tempList.add("Celsius");
        tempList.add("Kelvin");
        ArrayAdapter<String> tempAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, tempList);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpn.setAdapter(tempAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final EditText inputValue = (EditText) rootview.findViewById(R.id.inputText);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double celToFah,fahToCel,kelToFah;
                String selection = tempSpn.getSelectedItem().toString();
                double input = Double.valueOf(inputValue.getText().toString());
                switch (selection) {
                    case "Fahrenheit": {
                        fahToCel = (((input-32)*5)/9);
                        firstValue.setText(Double.toString(input));
                        secondValue.setText(Double.toString(fahToCel));
                        thirdValue.setText(Double.toString(fahToCel+273.15));
                        break;
                    }
                    case "Celsius": {
                        celToFah = (((input*9)/5)+32);
                        firstValue.setText(Double.toString(celToFah));
                        secondValue.setText(Double.toString(input));
                        thirdValue.setText(Double.toString(input+273.15));
                        break;
                    }
                    case "Kelvin": {
                        kelToFah = ((((input-273.15)*9)/5)+32);
                        firstValue.setText(Double.toString(kelToFah));
                        secondValue.setText(Double.toString(input-273.15));
                        thirdValue.setText(Double.toString(input));
                        break;
                    }
                }
            }
        });

    }

    private void chooseTime() {
        timeSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> timeList = new ArrayList<String>();
        timeList.add("Seconds");
        timeList.add("Minutes");
        timeList.add("Hours");
        timeList.add("Days");
        timeList.add("Weeks");
        timeList.add("Months");
        timeList.add("Non-Leap Years");
        timeList.add("Leap Years");
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, timeList);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpn.setAdapter(timeAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        final TextView eighthValue = (TextView) rootview.findViewById(R.id.eighthValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = timeSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Seconds": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.0166667));
                        thirdValue.setText(convertNumber(0.000277778));
                        fourthValue.setText(convertNumber(1.1574e-5));
                        fifthValue.setText(convertNumber(1.6534e-6));
                        sixthValue.setText(convertNumber(3.80265E-7));
                        seventhValue.setText(convertNumber(3.170979e-8));
                        eighthValue.setText(convertNumber(3.162315e-8));
                        break;
                    }
                    case "Minutes": {
                        firstValue.setText(convertNumber(60));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(0.0166667));
                        fourthValue.setText(convertNumber(0.000694444));
                        fifthValue.setText(convertNumber(9.9206e-5));
                        sixthValue.setText(convertNumber(2.2816e-5));
                        seventhValue.setText(convertNumber(1.902588e-6));
                        eighthValue.setText(convertNumber(1.897389e-6));
                        break;
                    }
                    case "Hours": {
                        firstValue.setText(convertNumber(3600));
                        secondValue.setText(convertNumber(60));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.0416667));
                        fifthValue.setText(convertNumber(0.00595238));
                        sixthValue.setText(convertNumber(0.00136895));
                        seventhValue.setText(convertNumber(1.141553e-4));
                        eighthValue.setText(convertNumber(1.138434e-4));
                        break;
                    }
                    case "Days": {
                        firstValue.setText(convertNumber(86400));
                        secondValue.setText(convertNumber(1440));
                        thirdValue.setText(convertNumber(24));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(0.142857));
                        sixthValue.setText(convertNumber(0.0328549));
                        seventhValue.setText(convertNumber(0.00274));
                        eighthValue.setText(convertNumber(0.002732));
                        break;
                    }
                    case "Weeks": {
                        firstValue.setText(convertNumber(604800));
                        secondValue.setText(convertNumber(10080));
                        thirdValue.setText(convertNumber(168));
                        fourthValue.setText(convertNumber(7));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(0.229984));
                        seventhValue.setText(convertNumber(0.019178));
                        eighthValue.setText(convertNumber(0.019126));
                        break;
                    }
                    case "Months": {
                        firstValue.setText(convertNumber(2592000));
                        secondValue.setText(convertNumber(43200));
                        thirdValue.setText(convertNumber(720));
                        fourthValue.setText(convertNumber(30));
                        fifthValue.setText(convertNumber(4.34812));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.08333333333333));
                        eighthValue.setText(convertNumber(0.08333333333333));
                        break;
                    }
                    case "Non-Leap Years": {
                        firstValue.setText(convertNumber(31536000));
                        secondValue.setText(convertNumber(525600));
                        thirdValue.setText(convertNumber(8760));
                        fourthValue.setText(convertNumber(365));
                        fifthValue.setText(convertNumber(52.1428));
                        sixthValue.setText(convertNumber(12));
                        seventhValue.setText(convertNumber(1));
                        eighthValue.setText(convertNumber(1.0037735849));
                        break;
                    }
                    case "Leap Years": {
                        firstValue.setText(convertNumber(31622400));
                        secondValue.setText(convertNumber(527040));
                        thirdValue.setText(convertNumber(8784));
                        fourthValue.setText(convertNumber(366));
                        fifthValue.setText(convertNumber(52.2857));
                        sixthValue.setText(convertNumber(12));
                        seventhValue.setText(convertNumber(0.9972677596));
                        eighthValue.setText(convertNumber(1));
                        break;
                    }
                }
            }
        });
    }

    private void chooseWgt() {
        wgtSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> wgtList = new ArrayList<String>();
        wgtList.add("Milligram");
        wgtList.add("Carat");
        wgtList.add("Gram");
        wgtList.add("Ounce");
        wgtList.add("Pound");
        wgtList.add("Kilogram");
        wgtList.add("Stone");
        wgtList.add("Metric ton");
        ArrayAdapter<String> wgtAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, wgtList);
        wgtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wgtSpn.setAdapter(wgtAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        final TextView eighthValue = (TextView) rootview.findViewById(R.id.eighthValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = wgtSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Milligram": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.005));
                        thirdValue.setText(convertNumber(0.001));
                        fourthValue.setText(convertNumber(0.000035));
                        fifthValue.setText(convertNumber(0.0000022046));
                        sixthValue.setText(convertNumber(0.000001));
                        seventhValue.setText(convertNumber(1.574730444e-7));
                        eighthValue.setText(convertNumber(0.000000001));
                        break;
                    }
                    case "Carat": {
                        firstValue.setText(convertNumber(200));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(.2));
                        fourthValue.setText(convertNumber(0.00705479239));
                        fifthValue.setText(convertNumber(0.000440924524));
                        sixthValue.setText(convertNumber(2.0e-4));
                        seventhValue.setText(convertNumber(3.149460893-5));
                        eighthValue.setText(convertNumber(2.0e-7));
                        break;
                    }
                    case "Gram": {
                        firstValue.setText(convertNumber(1000));
                        secondValue.setText(convertNumber(5));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.035274));
                        fifthValue.setText(convertNumber(0.00220462));
                        sixthValue.setText(convertNumber(0.001));
                        seventhValue.setText(convertNumber(0.000157473));
                        eighthValue.setText(convertNumber(0.000001));
                        break;
                    }
                    case "Ounce": {
                        firstValue.setText(convertNumber(28349.5));
                        secondValue.setText(convertNumber(141.747616));
                        thirdValue.setText(convertNumber(28.3495));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(0.0625));
                        sixthValue.setText(convertNumber(0.0283495));
                        seventhValue.setText(convertNumber(0.00446429));
                        eighthValue.setText(convertNumber(2.83495e-5));
                        break;
                    }
                    case "Pound": {
                        firstValue.setText(convertNumber(453592.37));
                        secondValue.setText(convertNumber(2267.96185));
                        thirdValue.setText(convertNumber(453.592));
                        fourthValue.setText(convertNumber(16));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(0.453592));
                        seventhValue.setText(convertNumber(0.0714286));
                        eighthValue.setText(convertNumber(0.000453592));
                        break;
                    }
                    case "Kilogram": {
                        firstValue.setText(convertNumber(1000000));
                        secondValue.setText(convertNumber(5000));
                        thirdValue.setText(convertNumber(1000));
                        fourthValue.setText(convertNumber(35.274));
                        fifthValue.setText(convertNumber(2.20462));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.157473));
                        eighthValue.setText(convertNumber(0.001));
                        break;
                    }
                    case "Stone": {
                        firstValue.setText(convertNumber(6350293.18));
                        secondValue.setText(convertNumber(31751.4659));
                        thirdValue.setText(convertNumber(6350.29));
                        fourthValue.setText(convertNumber(224));
                        fifthValue.setText(convertNumber(14));
                        sixthValue.setText(convertNumber(6.35029));
                        seventhValue.setText(convertNumber(1));
                        eighthValue.setText(convertNumber(0.00635029));
                        break;
                    }
                    case "Metric ton": {
                        firstValue.setText(convertNumber(1000000000));
                        secondValue.setText(convertNumber(5000000));
                        thirdValue.setText(convertNumber(1000000));
                        fourthValue.setText(convertNumber(35274));
                        fifthValue.setText(convertNumber(2204.62));
                        sixthValue.setText(convertNumber(1000));
                        seventhValue.setText(convertNumber(157.473));
                        eighthValue.setText(convertNumber(1));
                        break;
                    }
                }
            }
        });
    }

    private void chooseVol() {
        volSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
        List<String> volList = new ArrayList<String>();
        volList.add("Milliliter");
        volList.add("Teaspoon");
        volList.add("Tablespoon");
        volList.add("Ounce");
        volList.add("Cup");
        volList.add("Pint");
        volList.add("Quart");
        volList.add("Liter");
        volList.add("Gallon");
        volList.add("Cubic yard");
        volList.add("Cubic meter");
        volList.add("Cubic mile");
        ArrayAdapter<String> volAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, volList);
        volAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volSpn.setAdapter(volAdapter);
        Button convertButton = (Button) rootview.findViewById(R.id.buttonConvert);
        final TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        final TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        final TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        final TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        final TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        final TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        final TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        final TextView eighthValue = (TextView) rootview.findViewById(R.id.eighthValue);
        final TextView ninthValue = (TextView) rootview.findViewById(R.id.ninthValue);
        final TextView tenthValue = (TextView) rootview.findViewById(R.id.tenthValue);
        final TextView eleventhValue = (TextView) rootview.findViewById(R.id.eleventhValue);
        final TextView twelfthValue = (TextView) rootview.findViewById(R.id.twelfthValue);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = volSpn.getSelectedItem().toString();
                switch (selection) {
                    case "Milliliter": {
                        firstValue.setText(convertNumber(1));
                        secondValue.setText(convertNumber(0.2));
                        thirdValue.setText(convertNumber(0.066666666667));
                        fourthValue.setText(convertNumber(0.033814022701));
                        fifthValue.setText(convertNumber(0.004));
                        sixthValue.setText(convertNumber(0.0021133764189));
                        seventhValue.setText(convertNumber(0.0010566882094));
                        eighthValue.setText(convertNumber(0.001));
                        ninthValue.setText(convertNumber(0.0002199692483));
                        tenthValue.setText(convertNumber(0.0000013079506193));
                        eleventhValue.setText(convertNumber(0.000001));
                        twelfthValue.setText(convertNumber(2.3991275858e-16));
                        break;
                    }
                    case "Teaspoon": {
                        firstValue.setText(convertNumber(5));
                        secondValue.setText(convertNumber(1));
                        thirdValue.setText(convertNumber(0.33333333333));
                        fourthValue.setText(convertNumber(0.16907011351));
                        fifthValue.setText(convertNumber(0.02));
                        sixthValue.setText(convertNumber(0.010566882094));
                        seventhValue.setText(convertNumber(0.0052834410472));
                        eighthValue.setText(convertNumber(0.005));
                        ninthValue.setText(convertNumber(0.0013208602618));
                        tenthValue.setText(convertNumber(0.0000065397530966));
                        eleventhValue.setText(convertNumber(0.000005));
                        twelfthValue.setText(convertNumber(1.1995637929e-15));
                        break;
                    }
                    case "Tablespoon": {
                        firstValue.setText(convertNumber(15));
                        secondValue.setText(convertNumber(3));
                        thirdValue.setText(convertNumber(1));
                        fourthValue.setText(convertNumber(0.50721034052));
                        fifthValue.setText(convertNumber(0.06));
                        sixthValue.setText(convertNumber(0.031700646283));
                        seventhValue.setText(convertNumber(0.015850323141));
                        eighthValue.setText(convertNumber(0.015));
                        ninthValue.setText(convertNumber(0.0039625807854));
                        tenthValue.setText(convertNumber(0.00001961925929));
                        eleventhValue.setText(convertNumber(0.000015));
                        twelfthValue.setText(convertNumber(3.5986913787e-15));
                        break;
                    }
                    case "Ounce": {
                        firstValue.setText(convertNumber(29.573529563));
                        secondValue.setText(convertNumber(5.9147059126));
                        thirdValue.setText(convertNumber(1.9715686375));
                        fourthValue.setText(convertNumber(1));
                        fifthValue.setText(convertNumber(0.11829411825));
                        sixthValue.setText(convertNumber(0.0625));
                        seventhValue.setText(convertNumber(0.03125));
                        eighthValue.setText(convertNumber(0.029573529563));
                        ninthValue.setText(convertNumber(0.0078125000001));
                        tenthValue.setText(convertNumber(0.000038680716307));
                        eleventhValue.setText(convertNumber(0.000029573529563));
                        twelfthValue.setText(convertNumber(7.0950670584e-15));
                        break;
                    }
                    case "Cup": {
                        firstValue.setText(convertNumber(250));
                        secondValue.setText(convertNumber(50));
                        thirdValue.setText(convertNumber(16.666666667));
                        fourthValue.setText(convertNumber(8.4535056753));
                        fifthValue.setText(convertNumber(1));
                        sixthValue.setText(convertNumber(0.52834410472));
                        seventhValue.setText(convertNumber(0.26417205236));
                        eighthValue.setText(convertNumber(0.25));
                        ninthValue.setText(convertNumber(0.06604301309));
                        tenthValue.setText(convertNumber(0.00032698765483));
                        eleventhValue.setText(convertNumber(0.00025));
                        twelfthValue.setText(convertNumber(5.9978189645e-14));
                        break;
                    }
                    case "Pint": {
                        firstValue.setText(convertNumber(473.176473));
                        secondValue.setText(convertNumber(94.6352946));
                        thirdValue.setText(convertNumber(31.5450982));
                        fourthValue.setText(convertNumber(16));
                        fifthValue.setText(convertNumber(1.892705892));
                        sixthValue.setText(convertNumber(1));
                        seventhValue.setText(convertNumber(0.5));
                        eighthValue.setText(convertNumber(0.473176473));
                        ninthValue.setText(convertNumber(0.125));
                        tenthValue.setText(convertNumber(0.00061889146091));
                        eleventhValue.setText(convertNumber(0.000473176473));
                        twelfthValue.setText(convertNumber(1.1352107293e-13));
                        break;
                    }
                    case "Quart": {
                        firstValue.setText(convertNumber(946.352946));
                        secondValue.setText(convertNumber(189.2705892));
                        thirdValue.setText(convertNumber(63.0901964));
                        fourthValue.setText(convertNumber(32));
                        fifthValue.setText(convertNumber(3.785411784));
                        sixthValue.setText(convertNumber(2));
                        seventhValue.setText(convertNumber(1));
                        eighthValue.setText(convertNumber(0.946352946));
                        ninthValue.setText(convertNumber(0.25));
                        tenthValue.setText(convertNumber(0.0012377829218));
                        eleventhValue.setText(convertNumber(0.000946352946));
                        twelfthValue.setText(convertNumber(2.2704214587e-13));
                        break;
                    }
                    case "Liter": {
                        firstValue.setText(convertNumber(1000));
                        secondValue.setText(convertNumber(200));
                        thirdValue.setText(convertNumber(66.666666667));
                        fourthValue.setText(convertNumber(33.814022701));
                        fifthValue.setText(convertNumber(4));
                        sixthValue.setText(convertNumber(2.1133764189));
                        seventhValue.setText(convertNumber(1.0566882094));
                        eighthValue.setText(convertNumber(1));
                        ninthValue.setText(convertNumber(0.26417205236));
                        tenthValue.setText(convertNumber(0.0013079506193));
                        eleventhValue.setText(convertNumber(0.001));
                        twelfthValue.setText(convertNumber(2.3991275858e-13));
                        break;
                    }
                    case "Gallon": {
                        firstValue.setText(convertNumber(3785.411784));
                        secondValue.setText(convertNumber(757.0823568));
                        thirdValue.setText(convertNumber(252.3607856));
                        fourthValue.setText(convertNumber(128));
                        fifthValue.setText(convertNumber(15.141647136));
                        sixthValue.setText(convertNumber(8));
                        seventhValue.setText(convertNumber(4));
                        eighthValue.setText(convertNumber(3.785411784));
                        ninthValue.setText(convertNumber(1));
                        tenthValue.setText(convertNumber(0.0049511316873));
                        eleventhValue.setText(convertNumber(0.003785411784));
                        twelfthValue.setText(convertNumber(9.0816858347e-13));
                        break;
                    }
                    case "Cubic yard": {
                        firstValue.setText(convertNumber(764554.85798));
                        secondValue.setText(convertNumber(152910.9716));
                        thirdValue.setText(convertNumber(50970.323865));
                        fourthValue.setText(convertNumber(25852.675324));
                        fifthValue.setText(convertNumber(3058.2194319));
                        sixthValue.setText(convertNumber(1615.7922078));
                        seventhValue.setText(convertNumber(807.89610389));
                        eighthValue.setText(convertNumber(764.55485798));
                        ninthValue.setText(convertNumber(201.97402597));
                        tenthValue.setText(convertNumber(1));
                        eleventhValue.setText(convertNumber(0.76455485798));
                        twelfthValue.setText(convertNumber(1.8342646506e-10));
                        break;
                    }
                    case "Cubic meter": {
                        firstValue.setText(convertNumber(1000000));
                        secondValue.setText(convertNumber(200000));
                        thirdValue.setText(convertNumber(66666.666667));
                        fourthValue.setText(convertNumber(33814.022701));
                        fifthValue.setText(convertNumber(4000));
                        sixthValue.setText(convertNumber(2113.3764189));
                        seventhValue.setText(convertNumber(1056.6882094));
                        eighthValue.setText(convertNumber(1000));
                        ninthValue.setText(convertNumber(264.17205236));
                        tenthValue.setText(convertNumber(1.3079506193));
                        eleventhValue.setText(convertNumber(1));
                        twelfthValue.setText(convertNumber(2.3991275858e-10));
                        break;
                    }
                    case "Cubic mile": {
                        firstValue.setText(convertNumber(41681818254e5));
                        secondValue.setText(convertNumber(83363636508e4));
                        thirdValue.setText(convertNumber(27787878836e4));
                        fourthValue.setText(convertNumber(14094299487e4));
                        fifthValue.setText(convertNumber(16672727302e3));
                        sixthValue.setText(convertNumber(88089371793e2));
                        seventhValue.setText(convertNumber(44044685897e2));
                        eighthValue.setText(convertNumber(41681818254e2));
                        ninthValue.setText(convertNumber(11011171474e2));
                        tenthValue.setText(convertNumber(5451776e3));
                        eleventhValue.setText(convertNumber(4168181825.4));
                        twelfthValue.setText(convertNumber(1));
                        break;
                    }

                }
            }
        });
    }


    public class planOnClickListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                   long id) {

            parent.getItemAtPosition(pos);
            TextView firstName = (TextView) rootview.findViewById(R.id.firstName);
            TextView secondName = (TextView) rootview.findViewById(R.id.secondName);
            TextView thirdName = (TextView) rootview.findViewById(R.id.thirdName);
            TextView fourthName = (TextView) rootview.findViewById(R.id.fourthName);
            TextView fifthName = (TextView) rootview.findViewById(R.id.fifthName);
            TextView sixthName = (TextView) rootview.findViewById(R.id.sixthName);
            TextView seventhName = (TextView) rootview.findViewById(R.id.seventhName);
            TextView eighthName = (TextView) rootview.findViewById(R.id.eighthName);
            TextView ninthName = (TextView) rootview.findViewById(R.id.ninthName);
            TextView tenthName = (TextView) rootview.findViewById(R.id.tenthName);
            TextView eleventhName = (TextView) rootview.findViewById(R.id.eleventhName);
            TextView twelfthName = (TextView) rootview.findViewById(R.id.twelfthName);
            zeroNames();
            zeroValues();
            if (pos == 0) {
                firstName.setText("Square Inches: ");
                secondName.setText("Square Feet: ");
                thirdName.setText("Square Meters: ");
                fourthName.setText("Acres: ");
                fifthName.setText("Hectares: ");
                sixthName.setText("Square Kilometers: ");
                seventhName.setText("Square Miles: ");
                resetBoxes();
                quickVis2();
                chooseArea();
            } else if (pos == 1) {
                firstName.setText("Binary: ");
                secondName.setText("Decimal: ");
                thirdName.setText("Hexadecimal:");
                resetBinBoxes();
                quickVis();
                chooseBin();
            } else if (pos == 2) {
                firstName.setText("Millimeters: ");
                secondName.setText("Centimeters: ");
                thirdName.setText("Meters: ");
                fourthName.setText("Kilometers: ");
                fifthName.setText("Inches: ");
                sixthName.setText("Feet: ");
                seventhName.setText("Yards: ");
                eighthName.setText("Miles: ");
                resetBoxes();
                quickVis2();
                chooseDist();
            } else if (pos == 3) {
                firstName.setText("Bit: ");
                secondName.setText("Byte: ");
                thirdName.setText("Kilobyte: ");
                fourthName.setText("Megabyte: ");
                fifthName.setText("Gigabyte: ");
                sixthName.setText("Terabyte: ");
                seventhName.setText("Petrabyte: ");
                resetBoxes();
                quickVis2();
                chooseInfo();
            } else if (pos == 4) {
                firstName.setText("Meters per second: ");
                secondName.setText("Kilometers per second: ");
                thirdName.setText("Feet per second: ");
                fourthName.setText("Miles per second: ");
                fifthName.setText("Miles per minute: ");
                sixthName.setText("Miles per hour: ");
                seventhName.setText("Knots: ");
                resetBoxes();
                quickVis2();
                chooseSpd();
            } else if (pos == 5) {
                firstName.setText("Fahrenheit: ");
                secondName.setText("Celsius: ");
                thirdName.setText("Kelvin: ");
                resetBoxes();
                quickVis2();
                chooseTemp();
            } else if (pos == 6) {
                firstName.setText("Seconds: ");
                secondName.setText("Minutes: ");
                thirdName.setText("Hours: ");
                fourthName.setText("Days: ");
                fifthName.setText("Weeks: ");
                sixthName.setText("Months: ");
                seventhName.setText("Non-Leap Years: ");
                eighthName.setText("Leap Years: ");
                resetBoxes();
                quickVis2();
                chooseTime();
            } else if (pos == 7) {
                firstName.setText("Milligram: ");
                secondName.setText("Carat: ");
                thirdName.setText("Gram: ");
                fourthName.setText("Ounce: ");
                fifthName.setText("Pound: ");
                sixthName.setText("Kilogram: ");
                seventhName.setText("Stone: ");
                eighthName.setText("Metric ton: ");
                resetBoxes();
                quickVis2();
                chooseWgt();
            } else if (pos == 8) {
                firstName.setText("Milliliter: ");
                secondName.setText("Teaspoon: ");
                thirdName.setText("Tablespoon: ");
                fourthName.setText("Ounce: ");
                fifthName.setText("Cup: ");
                sixthName.setText("Pint: ");
                seventhName.setText("Quart: ");
                eighthName.setText("Liter: ");
                ninthName.setText("Gallon: ");
                tenthName.setText("Cubic yard: ");
                eleventhName.setText("Cubic meter: ");
                twelfthName.setText("Cubic mile: ");
                resetBoxes();
                quickVis2();
                chooseVol();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    }
    public class planOnClickListener2 implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                   long id) {
            final EditText inputValue = (EditText) rootview.findViewById(R.id.inputTextDec);
            final EditText inputValue2 = (EditText) rootview.findViewById(R.id.inputTextHex);
            final EditText inputValue3 = (EditText) rootview.findViewById(R.id.inputTextBin);
            inputValue.setText("");
            inputValue2.setText("");
            inputValue3.setText("");
            binSpn = (Spinner) rootview.findViewById(R.id.unitSpinner);
            String selection = binSpn.getSelectedItem().toString();
            switch (selection){
                case "Binary":{
                    inputValue.setVisibility(View.INVISIBLE);
                    inputValue2.setVisibility(View.INVISIBLE);
                    inputValue3.setVisibility(View.VISIBLE);
                    break;
                }
                case "Decimal": {
                    inputValue.setVisibility(View.VISIBLE);
                    inputValue2.setVisibility(View.INVISIBLE);
                    inputValue3.setVisibility(View.INVISIBLE);
                    break;
                }
                case "Hexadecimal": {
                    inputValue.setVisibility(View.INVISIBLE);
                    inputValue2.setVisibility(View.VISIBLE);
                    inputValue3.setVisibility(View.INVISIBLE);
                    break;
                }
        }}

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void resetBoxes(){
        final EditText inputValue = (EditText) rootview.findViewById(R.id.inputText);
        final EditText inputValue2 = (EditText) rootview.findViewById(R.id.inputTextHex);
        final EditText inputValue3 = (EditText) rootview.findViewById(R.id.inputTextBin);
        final EditText inputValue4 = (EditText) rootview.findViewById(R.id.inputTextDec);
        inputValue.setVisibility(View.VISIBLE);
        inputValue2.setVisibility(View.INVISIBLE);
        inputValue3.setVisibility(View.INVISIBLE);
        inputValue4.setVisibility(View.INVISIBLE);
        inputValue.setText("");
        inputValue2.setText("");
        inputValue3.setText("");
        inputValue4.setText("");
    }
    public void resetBinBoxes(){
        final EditText inputValue = (EditText) rootview.findViewById(R.id.inputText);
        final EditText inputValue2 = (EditText) rootview.findViewById(R.id.inputTextHex);
        final EditText inputValue3 = (EditText) rootview.findViewById(R.id.inputTextBin);
        final EditText inputValue4 = (EditText) rootview.findViewById(R.id.inputTextDec);
        inputValue.setVisibility(View.INVISIBLE);
        inputValue2.setVisibility(View.INVISIBLE);
        inputValue3.setVisibility(View.VISIBLE);
        inputValue4.setVisibility(View.INVISIBLE);
        inputValue.setText("");
        inputValue2.setText("");
        inputValue3.setText("");
        inputValue4.setText("");
    }

    public double roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##########E0");
        return Double.valueOf(twoDForm.format(d));
    }

    public String convertNumber(double var) {
        final EditText inputValue = (EditText) rootview.findViewById(R.id.inputText);
        String input = inputValue.getText().toString();
        if (errorCheck(input)){
            return "";
        }
        else if (input.matches("")){
            return input;
        }
        else {
            double input2 = Double.valueOf(input);
            return Double.toString(roundDecimals(input2 * var));
        }
    }

    public boolean errorCheck(String input){
        final TextView error = (TextView) rootview.findViewById(R.id.error);
        decCount = countOccurrences(input,'.');
        dashCount = countOccurrences(input,'-');
        if (decCount != 0 && decCount != 1){
            error.setText("Too many decimal points. Maximum 1.");
            error.setVisibility(View.VISIBLE);
            return true;
        }
        else if (dashCount != 0 && dashCount != 1 || dashCount == 1 && input.charAt(0)!='-'){
            error.setText("Please include only one -.\nAnd limit it to the beginning.");
            error.setVisibility(View.VISIBLE);
            return true;
        }
        else if (input.contentEquals("-") || input.contentEquals(".")){
            error.setText("Please enter a numerical value.");
            error.setVisibility(View.VISIBLE);
            return true;
        }
        else {
            error.setVisibility(View.INVISIBLE);
            return false;
        }
    }

    public int countOccurrences(String input, char find)
    {
        int count = 0;
        for (int i=0; i < input.length(); i++)
        {
            if (input.charAt(i) == find)
            {
                count++;
            }
        }
        return count;
    }

    public void quickVis(){
        Button quickSet1 = (Button) rootview.findViewById(R.id.quickSet1);
        Button quickSet2 = (Button) rootview.findViewById(R.id.quickSet2);
        Button quickSet3 = (Button) rootview.findViewById(R.id.quickSet3);
        Button quickSet4 = (Button) rootview.findViewById(R.id.quickSet4);
        Button quickSet5 = (Button) rootview.findViewById(R.id.quickSet5);
        quickSet1.setVisibility(View.INVISIBLE);
        quickSet2.setVisibility(View.INVISIBLE);
        quickSet3.setVisibility(View.INVISIBLE);
        quickSet4.setVisibility(View.INVISIBLE);
        quickSet5.setVisibility(View.INVISIBLE);
    }
    public void quickVis2(){
        Button quickSet1 = (Button) rootview.findViewById(R.id.quickSet1);
        Button quickSet2 = (Button) rootview.findViewById(R.id.quickSet2);
        Button quickSet3 = (Button) rootview.findViewById(R.id.quickSet3);
        Button quickSet4 = (Button) rootview.findViewById(R.id.quickSet4);
        Button quickSet5 = (Button) rootview.findViewById(R.id.quickSet5);
        quickSet1.setVisibility(View.VISIBLE);
        quickSet2.setVisibility(View.VISIBLE);
        quickSet3.setVisibility(View.VISIBLE);
        quickSet4.setVisibility(View.VISIBLE);
        quickSet5.setVisibility(View.VISIBLE);
    }

    private void zeroValues() {
        TextView firstValue = (TextView) rootview.findViewById(R.id.firstValue);
        TextView secondValue = (TextView) rootview.findViewById(R.id.secondValue);
        TextView thirdValue = (TextView) rootview.findViewById(R.id.thirdValue);
        TextView fourthValue = (TextView) rootview.findViewById(R.id.fourthValue);
        TextView fifthValue = (TextView) rootview.findViewById(R.id.fifthValue);
        TextView sixthValue = (TextView) rootview.findViewById(R.id.sixthValue);
        TextView seventhValue = (TextView) rootview.findViewById(R.id.seventhValue);
        TextView eighthValue = (TextView) rootview.findViewById(R.id.eighthValue);
        TextView ninthValue = (TextView) rootview.findViewById(R.id.ninthValue);
        TextView tenthValue = (TextView) rootview.findViewById(R.id.tenthValue);
        TextView eleventhValue = (TextView) rootview.findViewById(R.id.eleventhValue);
        TextView twelfthValue = (TextView) rootview.findViewById(R.id.twelfthValue);
        firstValue.setText("");
        secondValue.setText("");
        thirdValue.setText("");
        fourthValue.setText("");
        fifthValue.setText("");
        sixthValue.setText("");
        seventhValue.setText("");
        eighthValue.setText("");
        ninthValue.setText("");
        tenthValue.setText("");
        eleventhValue.setText("");
        twelfthValue.setText("");
    }
    private void zeroNames() {
        TextView firstName = (TextView) rootview.findViewById(R.id.firstName);
        TextView secondName = (TextView) rootview.findViewById(R.id.secondName);
        TextView thirdName = (TextView) rootview.findViewById(R.id.thirdName);
        TextView fourthName = (TextView) rootview.findViewById(R.id.fourthName);
        TextView fifthName = (TextView) rootview.findViewById(R.id.fifthName);
        TextView sixthName = (TextView) rootview.findViewById(R.id.sixthName);
        TextView seventhName = (TextView) rootview.findViewById(R.id.seventhName);
        TextView eighthName = (TextView) rootview.findViewById(R.id.eighthName);
        TextView ninthName = (TextView) rootview.findViewById(R.id.ninthName);
        TextView tenthName = (TextView) rootview.findViewById(R.id.tenthName);
        TextView eleventhName = (TextView) rootview.findViewById(R.id.eleventhName);
        TextView twelfthName = (TextView) rootview.findViewById(R.id.twelfthName);
        firstName.setText("");
        secondName.setText("");
        thirdName.setText("");
        fourthName.setText("");
        fifthName.setText("");
        sixthName.setText("");
        seventhName.setText("");
        eighthName.setText("");
        ninthName.setText("");
        tenthName.setText("");
        eleventhName.setText("");
        twelfthName.setText("");
    }
}