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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class datos extends ActionBarActivity {

    EditText matricula, nombre, apellidop, apellidom, email, carrera, semestre, grupo, maquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        matricula = (EditText) findViewById(R.id.matricula);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidop = (EditText) findViewById(R.id.apellidop);
        apellidom = (EditText) findViewById(R.id.apellidom);
        email = (EditText) findViewById(R.id.email);
        carrera = (EditText)findViewById(R.id.carrera);
        semestre = (EditText) findViewById(R.id.semestre);
        grupo =(EditText) findViewById(R.id.grupo);
        maquina = (EditText) findViewById(R.id.maquina);

    }

    public void alta (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumno", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Matricula = matricula.getText().toString();
        String Nombre = nombre.getText().toString();
        String Apellidop = apellidop.getText().toString();
        String Apellidom = apellidom.getText().toString();
        String Email = email.getText().toString();
        String Carrera = carrera.getText().toString();
        String Semestre = semestre.getText().toString();
        String Grupo = grupo.getText().toString();
        String Maquina = maquina.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("matricula", Matricula);
        registro.put("nombre", Nombre);
        registro.put("apellidop", Apellidop);
        registro.put("apellidom", Apellidom);
        registro.put("email", Email);
        registro.put("carrera", Carrera);
        registro.put("semestre", Semestre);
        registro.put("grupo", Grupo);
        registro.put("maquina", Maquina);

        bd.insert("alumno", null, registro);
        bd.close();

        matricula.setText("");
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        email.setText("");
        carrera.setText("");
        semestre.setText("");
        grupo.setText("");
        maquina.setText("");

        Toast.makeText(this, "Se agrego un nuevo usuario al registro", Toast.LENGTH_SHORT).show();
    }



    public void consulta (View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumno", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Matricula = matricula.getText().toString();

        Cursor fila = bd.rawQuery("select matricula, nombre, apellidop, apellidom, email, carrera, semestre, grupo, maquina from alumno where matricula=" + Matricula, null);
        if (fila.moveToFirst()){
            matricula.setText(fila.getString(0));
            nombre.setText(fila.getString(1));
            apellidop.setText(fila.getString(2));
            apellidom.setText(fila.getString(3));
            email.setText(fila.getString(4));
            carrera.setText(fila.getString(5));
            semestre.setText(fila.getString(6));
            grupo.setText(fila.getString(7));
            maquina.setText(fila.getString(8));
        }else {
            Toast.makeText(this, "No existe el registro", Toast.LENGTH_SHORT).show();
        }bd.close();
    }



    public void baja (View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumno", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Matricula = matricula.getText().toString();
        int cant = bd.delete("alumno", "matricula=" + Matricula, null);
        bd.close();

        matricula.setText("");
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        email.setText("");
        carrera.setText("");
        semestre.setText("");
        grupo.setText("");
        maquina.setText("");

        if (cant==1) {
            Toast.makeText(this, "Se elimino el registro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No existe el registro", Toast.LENGTH_SHORT).show();
        }
    }


    public void modificacion (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumno", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Matricula = matricula.getText().toString();
        String Nombre = nombre.getText().toString();
        String Apellidop = apellidop.getText().toString();
        String Apellidom = apellidom.getText().toString();
        String Email = email.getText().toString();
        String Carrera = carrera.getText().toString();
        String Semestre = semestre.getText().toString();
        String Grupo = grupo.getText().toString();
        String Maquina = maquina.getText().toString();

        ContentValues registro= new ContentValues();

        registro.put("matricula", Matricula);
        registro.put("nombre", Nombre);
        registro.put("apellidop", Apellidop);
        registro.put("apellidom", Apellidom);
        registro.put("email", Email);
        registro.put("carrera", Carrera);
        registro.put("semestre", Semestre);
        registro.put("grupo", Grupo);
        registro.put("maquina", Maquina);


        int cant = bd.update("alumno", registro, "matricula=" +  Matricula, null);
        bd.close();

        if (cant==1){
            Toast.makeText(this, "Se modifico el registro de la persona", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No existe el registro de la persona", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpia (View v) {

        matricula.setText("");
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        email.setText("");
        carrera.setText("");
        semestre.setText("");
        grupo.setText("");
        maquina.setText("");
    }

    public void lista (View v) {
        Intent lista = new Intent(datos.this, lista_bitacora.class);
        startActivity(lista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent abrir = new Intent(datos.this, Acercade.class);
            startActivity(abrir);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
