package com.example.bebedouro.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.bebedouro.dao.Bebedouro;
import com.example.bebedouro.dao.BebedouroCircular;
import com.example.bebedouro.dao.BebedouroRetangular;
import com.example.main.R;
import com.example.main.ObjectBox;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CadastrarBebedouroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
     private int checked;
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



        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"BOM", "RUIM", "ÓTIMO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        Spinner dropdownLimpeza = findViewById(R.id.spinnerLimpeza);
        String[] itemsLimpeza = new String[]{"BOM", "RUIM", "ÓTIMO"};
        ArrayAdapter<String> adapterLimpeza = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsLimpeza);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        RadioGroup groupRadio= findViewById(R.id.groupRadio);
        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                conferirRadio(checkedId);
                checked=checkedId;
            }
        });


        BoxStore boxStore = ObjectBox.get();

        //animal box está funcionando para receber o animal da classe
        Box<BebedouroCircular> circularBox = boxStore.boxFor(BebedouroCircular.class);
        Box<BebedouroRetangular> retangularBox = boxStore.boxFor(BebedouroRetangular.class);

        Button salvar= (Button) findViewById(R.id.btSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             // int opcao = conferirRadio(checked);
              if ( findViewById(R.id.txtRaio).getVisibility()==v.VISIBLE){
                  //BEBEDOURO CIRCULAR
                  String[] items = new String[]{"BOM", "RUIM", "ÓTIMO"};

                  EditText raio = (EditText) findViewById(R.id.edtRaio);
                  EditText vazao = (EditText) findViewById(R.id.edtVazao);
                  BebedouroCircular bebedouroCircular = new BebedouroCircular(raio.getText().toString(),vazao.getText().toString());

                  EditText altura = (EditText) findViewById(R.id.edtAltura);
                  Spinner condicaoAcesso = findViewById(R.id.spinner1);
                  Spinner limpeza = findViewById(R.id.spinnerLimpeza);

                  Bebedouro bebedouro = new Bebedouro(Float.parseFloat(altura.getText().toString()), items[condicaoAcesso.getId()], items[limpeza.getId()]);
                  bebedouroCircular.bebedouroToOne.setTarget(bebedouro);
                  circularBox.put(bebedouroCircular);
              }
              else if (findViewById(R.id.txtRaio).getVisibility()==v.GONE) {
                  //BEBEDOURO RETANGULAR
              }
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
