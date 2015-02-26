package seng301.convert;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by neileosis on 15-02-09.
 */
public class CheatSheet extends Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.cheatsheet_layout,container,false);
        rootview.setBackgroundColor(Color.parseColor(Conversion.bgColor));
        return rootview;
    }
}
