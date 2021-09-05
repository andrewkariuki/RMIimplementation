package com.example.toyenginermi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toyenginermi.databinding.FragmentAddToyBinding;
import com.example.toyenginermi.databinding.FragmentViewToysBinding;

public class AddToyFragment extends Fragment {

    private FragmentAddToyBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAddToyBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editTextToyName = view.findViewById(R.id.addToyPriceNameInput);
        EditText editTextToyPrice = view.findViewById(R.id.addToyPricePriceInput);

        String toyName = editTextToyName.getText().toString();
        String toyPrice = editTextToyPrice.getText().toString();

        Button buttonAddToyPrice = view.findViewById(R.id.addToyPricePriceBtn);

        buttonAddToyPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toyName.isEmpty() && toyPrice.isEmpty()){
                    Toast.makeText(getActivity(), "Toy name and price required", Toast.LENGTH_LONG).show();
                }{

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