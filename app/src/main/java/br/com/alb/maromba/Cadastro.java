package br.com.alb.maromba;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cadastro extends AppCompatActivity {

    public Spinner tpCadastro;
    public Spinner academias;
    public TextView DescAcademias;
    public EditText Nome;
    public LinearLayout Dados;
    public LinearLayout.LayoutParams params;
    private spnAcademias[] spnacademias;
    private JSONArray retorno;
    private spnAdapterAcademias adpAcademias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tpCadastro  = (Spinner)findViewById(R.id.tpCadastro);
        academias  = (Spinner)findViewById(R.id.academias);

        academias.setAdapter(serverAcademias.srvAdapterAcademias);

        DescAcademias = (TextView)findViewById(R.id.descacademias);
        Nome = (EditText)findViewById(R.id.nome);

        Dados = (LinearLayout) findViewById(R.id.dados);

        params = (LinearLayout.LayoutParams)Dados.getLayoutParams();

        tpCadastro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void CarregaAcademias() throws JSONException {

        String titulo = "Carregando Academias";
        String mensagem = "Aguarde por favor...";
        final Context context = this;

        final ProgressDialog dialog = ProgressDialog.show(this, titulo, mensagem, true, false);
        new Thread(new Runnable()
        {
            @Override
            public void run() {

                serverAcademias.context = context;
                new serverAcademias().execute("GetCadastro");

                while (retorno == null) {
                    retorno = serverAcademias.retAcademias;
                }

                spnacademias = new spnAcademias[retorno.length()];
                for(int i = 0; i < retorno.length(); i++)
                {
                    try {
                        JSONObject json = retorno.getJSONObject(i);

                        spnacademias[i] = new spnAcademias();

                        spnacademias[i].setId(json.getString("_id"));
                        spnacademias[i].setRazao(json.getString("razaosocial"));
                    }
                    catch (JSONException exp){

                    }
                }

                adpAcademias = new spnAdapterAcademias(context,android.R.layout.simple_spinner_dropdown_item, spnacademias);

                academias.setAdapter(adpAcademias);

                dialog.dismiss();

            }
        }).start();

    }

}
