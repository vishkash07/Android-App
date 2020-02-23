package com.example.contact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewAct extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        myDb = new DatabaseHelper(this);

        btnviewAll = (Button) findViewById(R.id.button_viewAll);

        viewAll();
    }

    public void viewAll(){
                btnviewAll.setOnClickListener(new View.OnClickListener() {
	            @Override
                public void onClick(View v) {
	                Cursor res=myDb.getAllData();
	                if(res.getCount() == 0) {
	                    // show message
                        showMessage("Error","Nothing found");
                        return;
	                }
	                StringBuffer buffer=new StringBuffer();
	                while(res.moveToNext()){
	                    buffer.append("Id:"+res.getString(0)+"\n");
                        buffer.append("Name :"+ res.getString(1)+"\n\n");
                        buffer.append("Surname :"+ res.getString(2)+"\n\n");
                        buffer.append("Phone :"+ res.getString(3)+"\n\n");
	                }
	                showMessage("Data",buffer.toString());
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

