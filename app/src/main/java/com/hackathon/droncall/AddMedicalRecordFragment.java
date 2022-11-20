package com.hackathon.droncall;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddMedicalRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMedicalRecordFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddMedicalRecordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddMedicalRecord.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMedicalRecordFragment newInstance(String param1, String param2) {
        AddMedicalRecordFragment fragment = new AddMedicalRecordFragment();
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

        Spinner dropdown = getView().findViewById(R.id.spinner1);
        String[] items = new String[]{"Immunization", "Lab Test Results"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown = getView().findViewById(R.id.spinner2);
        items = new String[]{"Anthrax", "DTaP", "Poliovirus", "Rotavirus"};
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_medical_record, container, false);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        getView().findViewById(R.id.dateField).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.dateHeading).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.spinner2).setVisibility(View.VISIBLE);
        switch (position) {
            case 0:
                // Adding immunization
                break;
            case 1:
                // Adding lab test results
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        getView().findViewById(R.id.dateField).setVisibility(View.GONE);
        getView().findViewById(R.id.dateHeading).setVisibility(View.GONE);
        getView().findViewById(R.id.spinner2).setVisibility(View.GONE);
    }
}