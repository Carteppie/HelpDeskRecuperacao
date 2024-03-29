package es.senac.br.helpdesk_danieloaski;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import es.senac.br.helpdesk.R;

public class TelaSolucao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_solucao);

        // estancia o botao logar
        final FloatingActionButton btnChamado = (FloatingActionButton)findViewById(R.id.floatingBtnChamado);

        btnChamado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // assim que logar chama a outra tela
                Intent trocaTela = new Intent(getApplicationContext(), TelaChamado.class);

                startActivity(trocaTela);


            }
        });


    }
}


