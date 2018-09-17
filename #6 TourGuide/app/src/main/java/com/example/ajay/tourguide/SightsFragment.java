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
public class SightsFragment extends Fragment {


    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information(getString(R.string.lal_bagh), getString(R.string.lal_bagh_info), R.drawable.lalbagh));
        informations.add(new Information(getString(R.string.bannerghatta), getString(R.string.bannerghatta_info), R.drawable.bannerghattanationalpark));
        informations.add(new Information(getString(R.string.cubbon_park), getString(R.string.cubbon), R.drawable.cubbonpark));
        informations.add(new Information(getString(R.string.bangalore_palace), getString(R.string.bangalore_palace_info), R.drawable.bangalorepalace));
        informations.add(new Information(getString(R.string.tippu), getString(R.string.tippu_info), R.drawable.tipussummerplace));
        informations.add(new Information(getString(R.string.iskon), getString(R.string.iskon_info), R.drawable.iskon));
        informations.add(new Information(getString(R.string.vidhana_soudha), getString(R.string.vidhana_soudha_info), R.drawable.vidhansoudha));
        informations.add(new Information(getString(R.string.museum), getString(R.string.museum_info), R.drawable.museum));

        InformationAdapter adapter = new InformationAdapter(getActivity(), informations);

        ListView listView = (ListView) rootView.findViewById(R.id.list1);

        listView.setAdapter(adapter);
        return rootView;
    }

}
