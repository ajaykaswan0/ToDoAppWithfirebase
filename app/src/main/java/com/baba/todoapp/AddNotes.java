package com.baba.todoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.nio.file.OpenOption;
import java.util.List;

public class AddNotes extends AppCompatActivity {
    private static final int image_request=1;
    EditText editText1;
    EditText editText2;
    Button btn;
    String titalsend,descsend;
    private DatabaseReference mDatabase;


    ImageView imageView;

    ProgressBar progressBar;
    StorageReference storageReference;
    private StorageTask mUploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        editText1 = findViewById(R.id.tital);
        editText2 = findViewById(R.id.description);


        imageView = findViewById(R.id.forview);
        progressBar = findViewById(R.id.progaress);
        storageReference = FirebaseStorage.getInstance().getReference("Notes");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btn = findViewById(R.id.save);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText1 == null && editText2 == null) {
                    Toast.makeText(AddNotes.this, "fill the fild", Toast.LENGTH_SHORT).show();
                } else {

                    AddNotes();
                }
            }
        });


    }



    private void AddNotes(){
        titalsend = editText1.getText().toString();
        descsend = editText2.getText().toString();
        String id = mDatabase.push().getKey();
        Notes notes = new Notes(titalsend,descsend,id);
        mDatabase.child("Notes").child(id).setValue(notes)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AddNotes.this,"Notes Added",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }

                    }
                });

    }



}
