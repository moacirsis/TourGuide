package com.samsrutidash.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

    public class Shopping extends Fragment {
        ListView list;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.shopping, container, false);
            final LocationDetails location_shopping_data[] = new LocationDetails[]
                    {

                            new LocationDetails(getContext().getString(R.string.shopping1Name),
                                    getContext().getString(R.string.shopping1Desc)
                                    , R.drawable.insidepavilion,14.5234, 12.3123),
                            new LocationDetails(getContext().getString(R.string.shopping2Name),
                                    getContext().getString(R.string.shopping2Desc) ,
                                    R.mipmap.ic_launcher, 14.5234, 12.3123),
                            new LocationDetails(getContext().getString(R.string.shopping3Name),
                                    getContext().getString(R.string.shopping3Desc), R.drawable.insidepavilion,
                                    14.5234, 12.3123),
                            new LocationDetails(getContext().getString(R.string.shopping1Name),
                                    getContext().getString(R.string.shopping1Desc), R.mipmap.ic_launcher,
                                    14.5234, 12.3123)
                    };


            list = (ListView) view.findViewById(R.id.list);
            list.setAdapter(new ListViewAdapter(view.getContext(), location_shopping_data));

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    LocationDetails current = location_shopping_data[position];
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