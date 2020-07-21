package com.example.bebedouro.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.animal.dao.CadastrarAnimal;
import com.example.main.MainActivity;
import com.example.main.R;

public class CadastrarBebedouroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_bebedouro);

        findViewById(R.id.txtRaio).setVisibility(View.VISIBLE);
        findViewById(R.id.edtRaio).setVisibility(View.VISIBLE);
        findViewById(R.id.txtAltura).setVisibility(View.VISIBLE);
        findViewById(R.id.edtAltura).setVisibility(View.VISIBLE);
        findViewById(R.id.txtVazao).setVisibility(View.VISIBLE);
        findViewById(R.id.edtVazao).setVisibility(View.VISIBLE);

        findViewById(R.id.edtComprimento).setVisibility(View.GONE);
        findViewById(R.id.txtComprimento).setVisibility(View.GONE);
        findViewById(R.id.edtLargura).setVisibility(View.GONE);
        findViewById(R.id.txtLargura).setVisibility(View.GONE);


        //get the spinner from the xml.
                Spinner dropdown = findViewById(R.id.spinner1);
        //create a list of items for the spinner.
                String[] items = new String[]{"BOM", "RUIM", "ÓTIMO"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        RadioGroup groupRadio= findViewById(R.id.groupRadio);
        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                conferirRadio(checkedId);
            }
        });



    }

    public void conferirRadio(int checkedId)
    {
        if(checkedId==R.id.rbCircular)
        {
            findViewById(R.id.txtRaio).setVisibility(View.VISIBLE);
            findViewById(R.id.edtRaio).setVisibility(View.VISIBLE);

            findViewById(R.id.txtAltura).setVisibility(View.VISIBLE);
            findViewById(R.id.edtAltura).setVisibility(View.VISIBLE);

            findViewById(R.id.txtVazao).setVisibility(View.VISIBLE);
            findViewById(R.id.edtVazao).setVisibility(View.VISIBLE);

            findViewById(R.id.edtComprimento).setVisibility(View.GONE);
            findViewById(R.id.txtComprimento).setVisibility(View.GONE);

            findViewById(R.id.edtLargura).setVisibility(View.GONE);
            findViewById(R.id.txtLargura).setVisibility(View.GONE);

        }
        else if(checkedId==R.id.rbRetangular)
        {
            findViewById(R.id.txtComprimento).setVisibility(View.VISIBLE);
            findViewById(R.id.edtComprimento).setVisibility(View.VISIBLE);

            findViewById(R.id.txtAltura).setVisibility(View.VISIBLE);
            findViewById(R.id.edtAltura).setVisibility(View.VISIBLE);

            findViewById(R.id.txtLargura).setVisibility(View.VISIBLE);
            findViewById(R.id.edtLargura).setVisibility(View.VISIBLE);

            findViewById(R.id.txtRaio).setVisibility(View.GONE);
            findViewById(R.id.edtRaio).setVisibility(View.GONE);


            findViewById(R.id.txtVazao).setVisibility(View.GONE);
            findViewById(R.id.edtVazao).setVisibility(View.GONE);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:



                /*Context contexto = getApplicationContext();
                String texto = "exemplo toast"+ position;
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto,duracao);
                toast.show();*/
                break;

            case 1:

                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
