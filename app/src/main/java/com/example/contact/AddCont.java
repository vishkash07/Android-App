package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCont extends AppCompatActivity {

        DatabaseHelper myDb;
	    EditText  editId,editName,editSurname,editPhone;
	    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cont);

        myDb = new DatabaseHelper(this);

                    editId = (EditText) findViewById(R.id.editText_Id);
        	        editName = (EditText) findViewById(R.id.editText_name);
        	        editSurname = (EditText) findViewById(R.id.editText_surname);
        	        editPhone = (EditText) findViewById(R.id.editText_Phone);
        	        btnAddData = (Button) findViewById(R.id.button_add);

        	        AddData();

            }

        	    public void AddData(){
        	        btnAddData.setOnClickListener(new View.OnClickListener() {
        	            @Override
                        public void onClick(View v) {
                                boolean isInserted=myDb.insertData(editName.getText().toString(), editSurname.getText().toString(),
                                                editPhone.getText().toString());
                	                if(isInserted == true)
                                        Toast.makeText(AddCont.this,"Data Inserted",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(AddCont.this,"Data could not be Inserted", Toast.LENGTH_LONG).show();
                           }
	        });
            }
}



