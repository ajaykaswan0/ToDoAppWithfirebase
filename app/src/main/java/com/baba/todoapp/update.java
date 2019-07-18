package com.baba.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update extends AppCompatActivity {
    Button delete ,update;
    String id;
    EditText tital,decription;
    DatabaseReference databaseReference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.delete);
        tital = findViewById(R.id.showtital);
        decription = findViewById(R.id.showdec);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");
        tital.setText(intent.getExtras().getString("tital"));
        decription.setText(intent.getExtras().getString("dec"));


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Notes").child(id).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(update.this, "Task Deleted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(update.this,HomeActivity.class));
                        }
                    }
                });
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTask();
            }

        });


    }
    public void updateTask(){
        String myTitle =tital.getText().toString();
        String myDescription=decription.getText().toString();
        Notes listdata = new Notes(id,myTitle,myDescription);
        databaseReference.child("Notes").child(id).setValue(listdata).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(update.this, "Notes Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
    }
}
