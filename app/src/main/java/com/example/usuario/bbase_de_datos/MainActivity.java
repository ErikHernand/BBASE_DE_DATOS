package com.example.usuario.bbase_de_datos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class MainActivity extends ActionBarActivity {

    Button Ingresar;
    EditText Usuario, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario = (EditText) findViewById(R.id.Usuario);
        Password = (EditText) findViewById(R.id.Password);
        Ingresar = (Button) findViewById(R.id.btnIngresar);

    }


    public void login(View v) {

        if (Usuario.getText().toString().equals("erik") && Password.getText().toString().equals("123")) {

            Intent intent = new Intent(MainActivity.this, datos.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "Su password o el usuario es incorrecto", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

////codigo para la hora y la fecha
    //Programacion del DatePicker
    public void showDate(View v) {
        android.support.v4.app.DialogFragment newFragment = new Datep();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    //Programacion del TimePicker
    public void showTime(View v) {
        android.support.v4.app.DialogFragment newFragment = new Timep();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}


