package com.sdi.fragmento01;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Screen2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Screen2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Screen2Fragment() {
    }

    public static Screen2Fragment newInstance(String param1, String param2) {
        Screen2Fragment fragment = new Screen2Fragment();
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

    private ImageView imageView;
    private String URLImage = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen2, container, false);
        imageView = view.findViewById(R.id.imageView);

        //URLImage = "http://10.0.2.2:8084/images/trunks.jpg";
        URLImage = "http://192.168.1.103:8084/static/sorting-ShellSort.jpg";
        Log.d("SDI", "onCreateView: "+URLImage);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Bitmap bitmap = Picasso.get().load(URLImage).get();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException e) {
                    Log.e("SDI", e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();

        return view;
    }
}