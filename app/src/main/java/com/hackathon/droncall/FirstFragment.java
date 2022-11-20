package com.hackathon.droncall;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.hackathon.droncall.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.callAmbulanceBtn.setOnClickListener(view1 -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:+1(111)111-1111"));
            startActivity(callIntent);
        });

        binding.availTreatmentBtn.setOnClickListener(view1 -> {

        });

        binding.checkRemindersBtn.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_CheckRemindersFragment);
        });

        binding.addMedicalRecordBtn.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_AddMedicalRecordFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}