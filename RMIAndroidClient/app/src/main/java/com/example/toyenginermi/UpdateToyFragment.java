package com.example.toyenginermi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toyenginermi.databinding.FragmentUpdateToyBinding;
import com.example.toyenginermi.databinding.FragmentViewToysBinding;

public class UpdateToyFragment extends Fragment {

    private FragmentUpdateToyBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentUpdateToyBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextName = view.findViewById(R.id.updatePriceNameInput);
        EditText editTextPrice = view.findViewById(R.id.addToyPricePriceInput);

        Button buttonUpdateToyPrice = view.findViewById(R.id.btnUpdateToyPrice);

        buttonUpdateToyPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toyPrice = editTextPrice.getText().toString();

                if(toyPrice.isEmpty()){
                    Toast.makeText(getActivity(), "Toy Price required", Toast.LENGTH_LONG).show();
                }else {
                    Navigation.findNavController(view).navigate(R.id.go_from_update_to_toys);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}