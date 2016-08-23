package br.com.alb.maromba;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {

    public Spinner tpCadastro;
    public Spinner academias;
    public TextView DescAcademias;
    public EditText Nome;
    public LinearLayout Dados;
    public LinearLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tpCadastro  = (Spinner)findViewById(R.id.tpCadastro);
        academias  = (Spinner)findViewById(R.id.academias);
        DescAcademias = (TextView)findViewById(R.id.descacademias);
        Nome = (EditText)findViewById(R.id.nome);

        Dados = (LinearLayout) findViewById(R.id.dados);

        params = (LinearLayout.LayoutParams)Dados.getLayoutParams();

        tpCadastro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        academias.setVisibility(View.INVISIBLE);
                        DescAcademias.setVisibility(View.INVISIBLE);

                        params.setMargins(0, 0, 0, 0);

                        Dados.setLayoutParams(params);
                        break;
                    case 1:
                        academias.setVisibility(View.VISIBLE);
                        DescAcademias.setVisibility(View.VISIBLE);

                        params.setMargins(0,20,0,0);

                        Dados.setLayoutParams(params);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
