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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information(getString(R.string.price_hotel), "", R.drawable.hotel_1));
        informations.add(new Information(getString(R.string.tulip_inn), "", R.drawable.hotel_2));
        informations.add(new Information(getString(R.string.hotel_ud), "", R.drawable.hotel_3));
        informations.add(new Information(getString(R.string.hotel_royal), "", R.drawable.hotel_4));
        informations.add(new Information(getString(R.string.nandhi), "", R.drawable.hotel_5));
        informations.add(new Information(getString(R.string.chancery), "", R.drawable.hotel_6));

        InformationAdapter adapter = new InformationAdapter(getActivity(), informations);

        ListView listView = (ListView) rootView.findViewById(R.id.list1);

        listView.setAdapter(adapter);
        return rootView;
    }

}
