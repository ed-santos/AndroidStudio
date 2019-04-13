package com.example.didyoulite;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddChoreFragment extends Fragment {


    public AddChoreFragment() {
        // Required empty public constructor

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Add Chores");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate (R.layout.fragment_add_chore, container, false);
        ImageView image = (ImageView)rootView.findViewById(R.id.imgLogo3);
        image.setImageResource(R.mipmap.didyoulogoonly);
        return  rootView;

    }

}
