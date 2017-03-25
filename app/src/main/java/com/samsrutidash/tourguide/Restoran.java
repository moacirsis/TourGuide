package com.samsrutidash.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Restoran extends Fragment {
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.restoran, container, false);
        final LocationDetails location_restoran_data[] = new LocationDetails[]
                {

                        new LocationDetails(getContext().getString(R.string.restoran1Name),
                                getContext().getString(R.string.restoran1Desc)
                                , R.drawable.insidepavilion,14.5234, 12.3123),
                        new LocationDetails(getContext().getString(R.string.restoran2Name),
                                getContext().getString(R.string.restoran2Desc) ,
                                R.mipmap.ic_launcher, 14.5234, 12.3123),
                        new LocationDetails(getContext().getString(R.string.restoran3Name),
                                getContext().getString(R.string.restoran3Desc), R.mipmap.ic_launcher,
                                14.5234, 12.3123),
                        new LocationDetails(getContext().getString(R.string.restoran1Name),
                                getContext().getString(R.string.restoran1Desc), R.mipmap.ic_launcher,
                                14.5234, 12.3123)
                };

        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new ListViewAdapter(view.getContext(), location_restoran_data));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                LocationDetails current = location_restoran_data[position];
//                    Toast.makeText(view.getContext(), "Wait..." , Toast.LENGTH_SHORT).show();
                Intent details = new Intent(getActivity(),LocationFullDisplay.class);
                details.putExtra("locationName" , current.getLocationName());
                details.putExtra("locationDesc",current.getLocationDesc());
                details.putExtra("locationLON", current.getLon());
                details.putExtra("locationLAT", current.getLat());
                details.putExtra("locationIcon", current.getLocationIcon());
                startActivity(details);
            }
        });
        return view;
    }
}