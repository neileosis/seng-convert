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

/**
 * Created by neileosis on 15-02-09.
 */
public class SpecialFormulas extends Fragment{
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.special_formulas_layout,container,false);
        rootview.setBackgroundColor(Color.parseColor(Conversion.bgColor));
        return rootview;
    }

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

    public void areaCalc(){
        final TextView areaTotal = (TextView) getView().findViewById(R.id.areaTotal);
        final EditText areaInput = (EditText) getView().findViewById(R.id.lengthIn);
        final EditText areaInput2 = (EditText) getView().findViewById(R.id.widthIn);
        double input = Double.valueOf(areaInput.getText().toString());
        double input2 = Double.valueOf(areaInput2.getText().toString());
        areaTotal.setText(Double.toString(input * input2));
    }

    public void aocCalc(){
        final TextView aocTotal = (TextView) getView().findViewById(R.id.aocTotal);
        final EditText aocInput = (EditText) getView().findViewById(R.id.radiusIn);
        double input = Double.valueOf(aocInput.getText().toString());
        input *= input;
        input *= Math.PI;
        aocTotal.setText(Double.toString(input));
    }

    public void circCalc(){
        final TextView circTotal = (TextView) getView().findViewById(R.id.circTotal);
        final EditText circInput = (EditText) getView().findViewById(R.id.radiusIn2);
        double input = Double.valueOf(circInput.getText().toString());
        input *= Math.PI;
        circTotal.setText(Double.toString(input*2));

    }

}
