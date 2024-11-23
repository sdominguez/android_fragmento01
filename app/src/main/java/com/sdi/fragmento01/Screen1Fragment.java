package com.sdi.fragmento01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sdi.fragmento01.databinding.FragmentScreen1Binding;
import com.squareup.picasso.Picasso;

public class Screen1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ImageView imageView;

    public Screen1Fragment() {
    }

    public static Screen1Fragment newInstance(String param1, String param2) {
        Screen1Fragment fragment = new Screen1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_screen1, container, false);
        imageView = view.findViewById(R.id.imageView);
        Picasso.get().load("https://rickandmortyapi.com/api/character/avatar/353.jpeg").into(imageView);
        return view;
    }
}