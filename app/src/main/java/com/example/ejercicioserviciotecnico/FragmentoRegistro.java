package com.example.ejercicioserviciotecnico;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
@ -7,58 +12,261 @@ import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoRegistro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoRegistro extends Fragment {
    
    EditText editCodigo,editPatente,editDocvehiculo,editFecha,editHora;
    Button btnFecha,btnHora,btnGuardarRegistro;
    RadioButton rdDireccion,rdNoDireccion,rdFreno,rdNoFreno,rdNeumatico,rdNoNeumatico,rdSuspension,rdNoSuspension,rdAlineacion,rdNoAlineacion,rdSeguridad,rdNoSeguridad;
    RadioButton rdCinturon,rdNoCinturon,rdLuces,rdNoLuces,rdPuerta,rdNoPuerta,rdVidrio,rdNoVidrio,rdEscape,rdNoEscape,rdGases,rdNoGases;
    

    int dia, mes, anio, hora, minuto;
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_fragmento_registro, container, false);

        editCodigo = v.findViewById(R.id.editCodigo);
        editPatente = v.findViewById(R.id.editPatente);
        editDocvehiculo = v.findViewById(R.id.editDocVehiculo);
        editFecha = v.findViewById(R.id.editFecha);
        editHora = v.findViewById(R.id.editHora);

        rdDireccion = v.findViewById(R.id.rdDireccion);
        rdNoDireccion = v.findViewById(R.id.rdNoDireccion);
        rdFreno = v.findViewById(R.id.rdFreno);
        rdNoFreno = v.findViewById(R.id.rdNoFreno);
        rdNeumatico = v.findViewById(R.id.rdNeumatico);
        rdNoNeumatico = v.findViewById(R.id.rdNoNeumatico);
        rdSuspension = v.findViewById(R.id.rdSuspension);
        rdNoSuspension = v.findViewById(R.id.rdNoSuspension);
        rdAlineacion = v.findViewById(R.id.rdAlineacion);
        rdNoAlineacion = v.findViewById(R.id.rdNoAlineacion);
        rdSeguridad = v.findViewById(R.id.rdSeguridad);
        rdNoSeguridad = v.findViewById(R.id.rdNoSeguridad);
        rdCinturon = v.findViewById(R.id.rdCinturon);
        rdNoCinturon = v.findViewById(R.id.rdNoCinturon);
        rdLuces = v.findViewById(R.id.rdLuces);
        rdNoLuces = v.findViewById(R.id.rdNoLuces);
        rdPuerta = v.findViewById(R.id.rdPuerta);
        rdNoPuerta = v.findViewById(R.id.rdNoPuerta);
        rdVidrio = v.findViewById(R.id.rdVidrio);
        rdNoVidrio = v.findViewById(R.id.rdNoVidrio);
        rdEscape = v.findViewById(R.id.rdEscape);
        rdNoEscape = v.findViewById(R.id.rdNoEscape);
        rdGases = v.findViewById(R.id.rdGases);
        rdNoGases = v.findViewById(R.id.rdNoGases);


        btnGuardarRegistro = v.findViewById(R.id.btnGuardarRegistro);
        btnFecha = v.findViewById(R.id.btnFecha);
        btnHora = v.findViewById(R.id.btnHora);

        btnGuardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guardar();

                Toast.makeText(getContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarFecha();
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarHora();
            }
        });

        return v;
    }



    public void guardar (){

        ConexionBD conexion = new ConexionBD( getContext());
        SQLiteDatabase bd = conexion.getWritableDatabase();

        String codigo = editCodigo.getText().toString();
        String patente = editPatente.getText().toString();
        String docuVehiculo = editDocvehiculo.getText().toString();
        String fecha = editFecha.getText().toString();
        String hora = editHora.getText().toString();

        String direccion, frenos, neumatico, suspension, alineacion, seguridad, cinturon, luces, puertas, vidrios, escape, gases;

        ContentValues formulario = new ContentValues();
        formulario.put("codigo", codigo);
        formulario.put("patente", patente);
        formulario.put("docuVehiculo", docuVehiculo);
        formulario.put("fecha", fecha);
        formulario.put("hora", hora);

        if(rdDireccion.isChecked()){
            direccion = rdDireccion.getText().toString();
            formulario.put("direccion", direccion);
        }
        if(rdNoDireccion.isChecked()){
            direccion = rdNoDireccion.getText().toString();
            formulario.put("direccion", direccion);
        }
        if(rdFreno.isChecked()){
            frenos = rdFreno.getText().toString();
            formulario.put("frenos", frenos);
        }
        if(rdNoFreno.isChecked()){
            frenos = rdNoFreno.getText().toString();
            formulario.put("frenos", frenos);
        }
        if(rdNeumatico.isChecked()){
            neumatico = rdNeumatico.getText().toString();
            formulario.put("neumaticos", neumatico);
        }
        if(rdNoNeumatico.isChecked()){
            neumatico = rdNoNeumatico.getText().toString();
            formulario.put("neumaticos", neumatico);
        }
        if(rdSuspension.isChecked()){
            suspension = rdSuspension.getText().toString();
            formulario.put("suspension", suspension);
        }
        if(rdNoSuspension.isChecked()){
            suspension = rdNoSuspension.getText().toString();
            formulario.put("suspesion",suspension);
        }
        if(rdAlineacion.isChecked()){
            alineacion = rdAlineacion.getText().toString();
            formulario.put("alineacion", alineacion);
        }
        if(rdNoAlineacion.isChecked()){
            alineacion = rdNoAlineacion.getText().toString();
            formulario.put("alineacion", alineacion);
        }
        if(rdSeguridad.isChecked()){
            seguridad = rdSeguridad.getText().toString();
            formulario.put("seguridad", seguridad);
        }
        if(rdNoSeguridad.isChecked()){
            seguridad = rdNoSeguridad.getText().toString();
            formulario.put("seguridad", seguridad);
        }
        if(rdCinturon.isChecked()){
            cinturon = rdCinturon.getText().toString();
            formulario.put("cinturon", cinturon);
        }
        if(rdNoCinturon.isChecked()){
            cinturon = rdNoCinturon.getText().toString();
            formulario.put("cinturon", cinturon);
        }
        if(rdLuces.isChecked()){
            luces = rdLuces.getText().toString();
            formulario.put("luces", luces);
        }
        if(rdNoLuces.isChecked()){
            luces = rdNoLuces.getText().toString();
            formulario.put("luces", luces);
        }
        if(rdPuerta.isChecked()){
            puertas = rdPuerta.getText().toString();
            formulario.put("puerta", puertas);
        }
        if(rdNoPuerta.isChecked()){
            puertas = rdNoPuerta.getText().toString();
            formulario.put("puerta", puertas);
        }
        if(rdVidrio.isChecked()){
            vidrios = rdVidrio.getText().toString();
            formulario.put("vidrio", vidrios);
        }
        if(rdNoVidrio.isChecked()){
            vidrios = rdNoVidrio.getText().toString();
            formulario.put("vidrio", vidrios);
        }
        if(rdEscape.isChecked()){
            escape = rdEscape.getText().toString();
            formulario.put("tuboescape", escape);
        }
        if(rdNoEscape.isChecked()){
            escape = rdNoEscape.getText().toString();
            formulario.put("tuboescape", escape);
        }
        if(rdGases.isChecked()){
            gases = rdGases.getText().toString();
            formulario.put("gases", gases);
        }
        if(rdNoGases.isChecked()){
            gases = rdNoGases.getText().toString();
            formulario.put("gases", gases);
        }


        bd.insert("registro", null, formulario);
        bd.close();

        editCodigo.setText("");
        editFecha.setText("");
        editHora.setText("");
        editDocvehiculo.setText("");
        editPatente.setText("");



    }
    
     public void mostrarFecha(){
        Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        anio = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                editFecha.setText(i2 + "-" + (i1+1) + "-" + i);
            }
        }, anio, mes, dia);

        datePickerDialog.show();
    }

    public void mostrarHora(){
        Calendar c = Calendar.getInstance();
        hora = c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                editHora.setText(i + ":" + i1);
            }
        }, hora, minuto, true);

        timePickerDialog.show();
    }

}
