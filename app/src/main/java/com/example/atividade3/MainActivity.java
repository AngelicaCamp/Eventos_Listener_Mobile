package com.example.atividade3;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private TextView txtMensagem;

    private EditText edtTexto;
    private SeekBar skbLetra;
    private TextView txtTamanho;
    private Button btnEnviar;

    private CheckBox chbNegrito;
    private CheckBox chbItalico;
    private CheckBox chbMaiusculas;

    private RadioGroup rdgCores;
    private RadioButton rdbVermelho;
    private RadioButton rdbVerde;
    private RadioButton rdbAzul;

    private String txtStore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensagem = findViewById(R.id.txtMensagem);
        edtTexto = findViewById(R.id.edtTexto);
        skbLetra = findViewById(R.id.skbLetra);
        txtTamanho = findViewById(R.id.txtTamanho);
        btnEnviar = findViewById(R.id.btnEnviar);
        chbNegrito = findViewById(R.id.chbNegrito);
        chbItalico = findViewById(R.id.chbItalico);
        chbMaiusculas = findViewById(R.id.chbMaiusculas);
        rdgCores = findViewById(R.id.rdgCores);
        rdbVermelho = findViewById(R.id.rdbVermelho);
        rdbVerde = findViewById(R.id.rdbVerde);
        rdbAzul = findViewById(R.id.rdbAzul);

        btnEnviar.setOnClickListener(this);
        skbLetra.setOnSeekBarChangeListener(this);

    }


    public void onClick(View view) {
        // ao clicar no botão Enviar, capturar texto digitado em EditText e enviar para TextView
        if (view.getId() == R.id.btnEnviar) {
            txtMensagem.setText(edtTexto.getText().toString());
            txtStore = edtTexto.getText().toString();
        }
    }


    public void definirEstilo(View view){

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.chbNegrito:
                if(checked){
                   txtMensagem.setTypeface(null,Typeface.BOLD);
                }
                break;
            case R.id.chbItalico:
                if(checked){
                    txtMensagem.setTypeface(null,Typeface.ITALIC);
                }
                break;
            case R.id.chbMaiusculas:
                if(checked){
                    txtMensagem.setText(txtMensagem.getText().toString().toUpperCase());
                } else {
                    txtMensagem.setText(txtStore);
                }
                break;
        }
    }


     public void alterarCorTexto(View view){

        // O botão está marcado agora?
        boolean checked = ((RadioButton) view).isChecked();

        // Verificar qual botão de rádio foi clicado
        switch (view.getId()) {

            case R.id.rdbVermelho:
                if(checked)
                    txtMensagem.setTextColor(Color.RED);
                break;

            case R.id.rdbVerde:
                if(checked)
                    txtMensagem.setTextColor(Color.GREEN);
                break;

            case R.id.rdbAzul:
                if(checked)
                    txtMensagem.setTextColor(Color.BLUE);
        }
    }

    
    // alterar o tamanho da letra
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar.getId() == R.id.skbLetra){
            txtMensagem.setTextSize(i);
            txtTamanho.setText(i + "sp");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
