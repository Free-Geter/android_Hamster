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
 * Use the {@link Fragment_item#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_item extends Fragment {

    private static final String TAG = "Fragment_Test";
    ImageClickedListener mCallback;
    ImageView tinyImage;
    int imgId[] = {R.id.tinyImage01,R.id.tinyImage02,R.id.tinyImage03,R.id.tinyImage04,R.id.tinyImage05,R.id.tinyImage06,R.id.tinyImage07};

    public interface ImageClickedListener{
        public void updateImage(ImageView img);
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_item() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_item.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_item newInstance(String param1, String param2) {
        Fragment_item fragment = new Fragment_item();
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
        return inflater.inflate(R.layout.fragment_item, container, false);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (ImageClickedListener) getActivity();
        } catch (ClassCastException e){
            throw  new ClassCastException(getActivity().toString() + "must implement ImageClickedListener");
        }

        for (int i = 0; i < imgId.length; i++) {
            Log.d(TAG, "onAttach: " + imgId[i]);
            Log.d(TAG, "onAttach: " + getView());
            tinyImage = (ImageView)getView().findViewById(imgId[i]);
            if (tinyImage != null)
                tinyImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCallback.updateImage((ImageView)v);
                    }
                });
        }
    }
}