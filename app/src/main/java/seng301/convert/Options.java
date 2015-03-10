package seng301.convert;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

public class Options extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.options_layout, container, false);
        rootview.setBackgroundColor(Color.parseColor(Conversion.bgColor));
        return rootview;
    }

    public void onStart() {
        super.onStart();
        Button firstButton = (Button) getView().findViewById(R.id.button);
        Button secondButton = (Button) getView().findViewById(R.id.button2);
        Button thirdButton = (Button) getView().findViewById(R.id.button3);
        Button fourthButton = (Button) getView().findViewById(R.id.button4);
        Button fifthButton = (Button) getView().findViewById(R.id.button5);
        Button sixthButton = (Button) getView().findViewById(R.id.button6);
        Button customButton = (Button) getView().findViewById(R.id.customButton);
        final EditText customColor = (EditText) getView().findViewById(R.id.customValue);
        final TextView note = (TextView) getView().findViewById(R.id.note);
        note.setVisibility(View.INVISIBLE);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Conversion.bgColor = getString(R.string.def);note.setVisibility(View.VISIBLE);Toast.makeText(getActivity(), getString(R.string.button1), Toast.LENGTH_LONG).show();}});
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Conversion.bgColor = getString(R.string.peach);note.setVisibility(View.VISIBLE);Toast.makeText(getActivity(), getString(R.string.button2), Toast.LENGTH_LONG).show();}});
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Conversion.bgColor = getString(R.string.blue);note.setVisibility(View.VISIBLE);Toast.makeText(getActivity(), getString(R.string.button3), Toast.LENGTH_LONG).show();}});
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Conversion.bgColor = getString(R.string.green);note.setVisibility(View.VISIBLE);Toast.makeText(getActivity(), getString(R.string.button4), Toast.LENGTH_LONG).show();}});
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Conversion.bgColor = getString(R.string.red);note.setVisibility(View.VISIBLE);Toast.makeText(getActivity(), getString(R.string.button5), Toast.LENGTH_LONG).show();}});
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Conversion.bgColor = getString(R.string.white);note.setVisibility(View.VISIBLE);Toast.makeText(getActivity(), getString(R.string.button6), Toast.LENGTH_LONG).show();}});
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customValue = customColor.getText().toString();
                if (customValue.length()==6) {
                    Conversion.bgColor = "#" + customValue;
                    note.setVisibility(View.VISIBLE);
                }
            }});
    }
}
