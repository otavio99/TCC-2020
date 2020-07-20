package com.example.bebedouro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.animal.dao.CadastrarAnimal;
import com.example.main.MainActivity;
import com.example.main.R;

public class CadastrarBebedouroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_bebedouro);

        findViewById(R.id.rbCircular).performClick();

        RadioGroup groupRadio= findViewById(R.id.groupRadio);
        EditText   comprimentoEditText= findViewById(R.id.edtComprimento);
        EditText  raioEditText= findViewById(R.id.edtRaio);
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
            findViewById(R.id.edtRaio).setVisibility(View.VISIBLE);
            findViewById(R.id.edtComprimento).setVisibility(View.GONE);
            findViewById(R.id.txtComprimento).setVisibility(View.GONE);
            findViewById(R.id.txtRaio).setVisibility(View.VISIBLE);
        }
        else if(checkedId==R.id.rbRetangular)
        {
            findViewById(R.id.edtComprimento).setVisibility(View.VISIBLE);
            findViewById(R.id.txtRaio).setVisibility(View.GONE);
            findViewById(R.id.edtRaio).setVisibility(View.GONE);
            findViewById(R.id.txtComprimento).setVisibility(View.VISIBLE);
        }
    }


}
