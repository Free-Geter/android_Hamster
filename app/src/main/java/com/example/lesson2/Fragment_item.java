package com.example.lesson2;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_item extends Fragment {

    private View mview;
    ImageClickedListener mCallback;
    ImageView tinyImage;
    int imgId[] = {R.id.tinyImage01,R.id.tinyImage02,R.id.tinyImage03,R.id.tinyImage04,R.id.tinyImage05,R.id.tinyImage06,R.id.tinyImage07};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_item, container, false);

        try {
            mCallback = (ImageClickedListener) getActivity();
        } catch (ClassCastException e){
            throw  new ClassCastException(getActivity().toString() + "must implement ImageClickedListener");
        }
        for (int i = 0; i < imgId.length; i++) {
            tinyImage = (ImageView)mview.findViewById(imgId[i]);
            if (tinyImage != null)
                tinyImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCallback.updateImage((ImageView)v);
                    }
                });
        }
        return mview;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    public interface ImageClickedListener{
        public void updateImage(ImageView img);
    }
}