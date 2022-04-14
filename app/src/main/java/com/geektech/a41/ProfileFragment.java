package com.geektech.a41;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geektech.a41.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    public static final int RESULT_GALLERY = 1;
    public static final int RESULT_GALLERY_2 = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.pickBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGallery();
            }
        });

        binding.centerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT/*,MediaStore.Images.Media.EXTERNAL_CONTENT_URI*/);
                cameraIntent.setType("image/*");
                startActivityForResult(cameraIntent, RESULT_GALLERY_2);
            }
        });
    }

    private void startGallery() {
        Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT/*,MediaStore.Images.Media.EXTERNAL_CONTENT_URI*/);
        cameraIntent.setType("image/*");
        startActivityForResult(cameraIntent, RESULT_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri imageUri = data.getData();
            binding.profileBack.setImageURI(imageUri);
        }
        else if (requestCode == RESULT_GALLERY_2 && resultCode == Activity.RESULT_OK) {
            Uri centerImage = data.getData();
            binding.centerImage.setImageURI(centerImage);
        }
        else {
            Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show();
        }
    }
}