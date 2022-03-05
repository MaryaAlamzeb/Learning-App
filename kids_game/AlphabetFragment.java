package com.example.kids_game;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlphabetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlphabetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlphabetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlphabetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlphabetFragment newInstance(String param1, String param2) {
        AlphabetFragment fragment = new AlphabetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_alphabet, container, false);
        String [] alphabets= new String[6];
                for (int i=0, j=65; i<6; i++,j++)
                {
                    alphabets[i]=Character.toString((char)j);
                }

        GridView gridView= view.findViewById(R.id.gridview1);

        ArrayAdapter <String> adapter=new ArrayAdapter <String>(getContext(), android.R.layout.simple_expandable_list_item_1,alphabets);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1= new Intent(getContext(),AlphabetActivity.class);
               i1.putExtra("name", alphabets[i]);
                startActivity(i1);
            }
        });

        return view;
    }
}