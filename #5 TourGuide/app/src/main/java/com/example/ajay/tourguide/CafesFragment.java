package com.example.ajay.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CafesFragment extends Fragment {


    public CafesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information(getString(R.string.hill_station_cafe), getString(R.string.hill_station_cafe_info), R.drawable.cafe_1));
        informations.add(new Information(getString(R.string.mr_beans), getString(R.string.mr_beans_info), R.drawable.cafe_2));
        informations.add(new Information(getString(R.string.matteo_coffea), getString(R.string.mateo_coffea_info), R.drawable.cafe_3));
        informations.add(new Information(getString(R.string.art_cafe), getString(R.string.art_cafe_info), R.drawable.cafe_4));
        informations.add(new Information(getString(R.string.bakehouse), getString(R.string.bakehouse_info), R.drawable.cafe_5));
        informations.add(new Information(getString(R.string.om_cafe), getString(R.string.om_made_cafe), R.drawable.cafe_6));

        InformationAdapter adapter = new InformationAdapter(getActivity(), informations);

        ListView listView = (ListView) rootView.findViewById(R.id.list1);

        listView.setAdapter(adapter);
        return rootView;
    }

}
