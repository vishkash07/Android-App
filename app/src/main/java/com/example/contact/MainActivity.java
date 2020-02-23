package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddContacts(View view)
    {
        Intent intent = new Intent(this, AddCont.class);

        startActivity(intent);
    }


    public void ViewContacts(View view)
    {
        Intent intent = new Intent(this, ViewAct.class);

        startActivity(intent);
    }

    public void SrcContacts(View view)
    {
        Intent intent = new Intent(this, SearchAct.class);

        startActivity(intent);
    }

    public void DelContacts(View view)
    {
        Intent intent = new Intent(this, DeleteAct.class);

        startActivity(intent);
    }
}
