package com.industrialmaster.sachinapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class Notes_Add_Activity extends AppCompatActivity {

    String file = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes__add_);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            String note = bundle.getString("note");
            file = bundle.getString("file");

            EditText etNote = findViewById(R.id.etNotes);
            etNote.setText(note);
        }
        else {
            Button btnNotesDelete = findViewById(R.id.btnNotesDelete);
            btnNotesDelete.setVisibility(View.INVISIBLE);
        }
    }
    public void notesSave(View v){
        String fileName = (file != null)? file: String.valueOf(new Date().getTime());
        File file = new File(getFilesDir()+File.separator+"notes"+File.separator+ fileName);

        try{
            FileOutputStream fos = new FileOutputStream(file);
            EditText etNotes = findViewById(R.id.etNotes);
            String note = etNotes.getText().toString();

            fos.write(note.getBytes());
            fos.close();

            Toast.makeText(this,"Success !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,My_Notes.class);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Error, Not saved!",Toast.LENGTH_SHORT).show();
        }
    }
    public void notesDelete(View v){
        File fileToDelete = new File(getFilesDir()+File.separator+"notes"+File.separator+file);
        fileToDelete.delete();

        Toast.makeText(this,"Deleted !", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,My_Notes.class);
        startActivity(intent);
    }
}
