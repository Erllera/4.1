package com.geektech.a41;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.a41.databinding.FragmentHomeBinding;
import com.geektech.a41.databinding.FragmentNewsBinding;

public class NewsFragment extends Fragment {
    private FragmentNewsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
                close();
            }
        });

    }

    private void save() {
        String text = binding.editText.getText().toString();
        Bundle bundle = new Bundle();
        NewsModel model = new NewsModel(text,System.currentTimeMillis());
        bundle.putSerializable("key_news",model);
        getParentFragmentManager().setFragmentResult("rk_key",bundle);
    }


    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}