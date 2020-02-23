package com.example.contact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchAct extends AppCompatActivity {

    DatabaseHelper myDb;
	    EditText  editName;
	    Button  btngetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        myDb = new DatabaseHelper(this);

        	        editName = (EditText) findViewById(R.id.editText_name);


        	        btngetData = (Button) findViewById(R.id.button_view);
        	        getData();

    }

    public void getData() {
        	        btngetData.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
                	                String name = editName.getText().toString();

                	                if(name.equals("")){
                                        editName.setError("Enter Name to get data");
                                        return;
                    	                }
                	                Cursor res = myDb.getData(name);
                	                String data = null;
                	                if (res.moveToFirst()) {

                    	                    data = "Id:"+res.getString(0)+"\n"+
                            	                            "Name :"+ res.getString(1)+"\n\n"+
                            	                            "Surname :"+ res.getString(2)+"\n\n"+
                            	                            "Marks :"+ res.getString(3)+"\n\n";
                    	                }
                	                showMessage("Data", data);
                	            }
	        });
            }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

