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
public class ResortsFragment extends Fragment {


    public ResortsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information(getString(R.string.aura_hotel), getString(R.string.aura_hotel_info), R.drawable.akshaya_mayura));
        informations.add(new Information(getString(R.string.royal_orchid), getString(R.string.royal_orchid_info), R.drawable.royalcomfort));
        informations.add(new Information(getString(R.string.chairman), getString(R.string.chairman_info), R.drawable.chairman));
        informations.add(new Information(getString(R.string.nature_camp), getString(R.string.nature_camp_info), R.drawable.bannerghatta));
        informations.add(new Information(getString(R.string.richmond), getString(R.string.richmond_info), R.drawable.ramanashreerichmond));
        informations.add(new Information(getString(R.string.rialto), getString(R.string.rialto_info), R.drawable.reilto));
        informations.add(new Information(getString(R.string.royal), getString(R.string.royal_info), R.drawable.royalcomfort));

        InformationAdapter adapter = new InformationAdapter(getActivity(), informations);

        ListView listView = (ListView) rootView.findViewById(R.id.list1);

        listView.setAdapter(adapter);
        return rootView;
    }

}
