package com.example.infogram.view.fractmen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infogram.R;
import com.example.infogram.adapter.cardViewAdapter;
import com.example.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
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

        View view =inflater.inflate(R.layout.fragment_home, container, false);
        //toolbar
        showToolbar(getString(R.string.title_home_fragment),false,view);
        //recyclerView
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);

        //layoutManager
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        cardViewAdapter cardViewAdapter =new cardViewAdapter(buidImages(),R.layout.cardview_image,getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    private void showToolbar(String titulo, boolean botonSubir,View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        if ( ((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
        }
    }

    //creamos la lista de imagenes
    public ArrayList<Image>buidImages(){
        ArrayList<Image>images= new ArrayList<>();
        images.add(new Image("","carlos valdivia","2 dias","1 me gusta"));
        images.add(new Image("","luis perez","3 dias","2 me gusta"));
        images.add(new Image("","fernando torrico","4 dias","3 me gusta"));
        images.add(new Image("","maria flores","5 dias","4 me gusta"));
        images.add(new Image("","rolando morales","6 dias","5 me gusta"));
        images.add(new Image("","wilian jaimes","7 dias","6 me gusta"));
        images.add(new Image("","roberto paniagua","8 dias","7 me gusta"));
        images.add(new Image("","lorenas herreras","9 dias","8 me gusta"));
        images.add(new Image("","laura caceres","10 dias","9 me gusta"));
        images.add(new Image("","marcelo rojas","11 dias","10 me gusta"));
        images.add(new Image("","jaime paz","12 dias","11 me gusta"));



        return images;
    }
}