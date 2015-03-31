package seng301.convert;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math.*;
import java.text.DecimalFormat;

public class SpecialFormulas extends Fragment{
    View rootview;
    public int decCount, dashCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.special_formulas_layout,container,false);
        rootview.setBackgroundColor(Color.parseColor(Conversion.bgColor));
        return rootview;
    }

    //initialize the buttons and listeners associated with them
    public void onStart() {
        super.onStart();
        Button areaButton = (Button) getView().findViewById(R.id.sfConvert);
        Button aocButton = (Button) getView().findViewById(R.id.sfConvert2);
        Button circButton = (Button) getView().findViewById(R.id.sfConvert3);
        areaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {areaCalc();}});
        aocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {aocCalc();}});
        circButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {circCalc();}});
    }

    //calculate the area of two numbers
    public void areaCalc(){
        final TextView areaTotal = (TextView) getView().findViewById(R.id.areaTotal);
        final EditText areaInput = (EditText) getView().findViewById(R.id.lengthIn);
        final EditText areaInput2 = (EditText) getView().findViewById(R.id.widthIn);
        final TextView error = (TextView) getView().findViewById(R.id.sfError);
        String input = areaInput.getText().toString();
        String input2 = areaInput2.getText().toString();
        if (input.matches("") || input2.matches("")) {
            error.setVisibility(View.VISIBLE);
        }
        else {
            error.setVisibility(View.INVISIBLE);
            areaTotal.setText(sfConvert(input,input2, 0));
        }
    }

    //calculate the area of a circle
    public void aocCalc(){
        final TextView aocTotal = (TextView) getView().findViewById(R.id.aocTotal);
        final EditText aocInput = (EditText) getView().findViewById(R.id.radiusIn);
        String input = aocInput.getText().toString();
        if (!input.matches(""))
            aocTotal.setText(sfConvert(input,input,1));
    }

    //calcualte the circumference of a circle
    public void circCalc(){
        final TextView circTotal = (TextView) getView().findViewById(R.id.circTotal);
        final EditText circInput = (EditText) getView().findViewById(R.id.radiusIn2);
        String input = circInput.getText().toString();
        if (!input.matches(""))
            circTotal.setText(sfConvert(input, "2", 2));
    }

    public String sfConvert(String var, String var2, int formula) {
        if (formula == 1 || formula == 2) {
            return Double.toString(roundDecimals(Double.valueOf(var) * Double.valueOf(var2) * Math.PI));
        }
        else {
            return Double.toString(roundDecimals(Double.valueOf(var) * Double.valueOf(var2)));
        }
    }

    public double roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######E0");
        return Double.valueOf(twoDForm.format(d));
    }
}
