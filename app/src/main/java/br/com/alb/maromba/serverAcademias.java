package br.com.alb.maromba;

import android.content.Context;
import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;

/**
 * Created by Aristeu da Silva Filho on 12/09/2016.
 */
public class serverAcademias extends AsyncTask<String, Void, String[]> {

    public String URL = "";
    public static JSONArray retAcademias;
    public static JSONArray retProfessores;
    public static Context context;
    public static spnAdapterAcademias srvAdapterAcademias;
    public static int Carregou = 0;

    protected String[] doInBackground(String... params) {

        try{

            URL = context.getResources().getString(R.string.URL) + "academias";

            switch (params[0])
            {
                case "Get":
                    getAcademias();
                    break;

                case "GetCadastro":
                    getAcademiasCadastro();
                    break;

                default:
                    break;
            }


        }
        catch (Exception exp){

        }

        return null;
    }

    private void getAcademiasCadastro() {

        try {
            String url = URL;
            String conteudo = HttpRequest.get(url).body();
            int Primeiro = 0;

            retAcademias = new JSONArray(conteudo);

            spnAcademias[] spnacademias = new spnAcademias[retAcademias.length()];
            for(int i = 0; i < retAcademias.length(); i++)
            {
                try {
                    JSONObject json = retAcademias.getJSONObject(i);

                    spnacademias[i] = new spnAcademias();

                    spnacademias[i].setId(json.getString("_id"));
                    spnacademias[i].setRazao(json.getString("razaosocial"));

                    if(i == 0){

                        //JSONArray professores =

                        String urlProfessores = context.getResources().getString(R.string.URL) +
                                                "/professores/" +
                                                json.getString("_id");

                        String professores = HttpRequest.put(urlProfessores).body();

                        retProfessores = new JSONArray(professores);

                        for (int ii = 0; ii < retProfessores.length(); i++)
                        {
                            JSONObject profObj = retProfessores.getJSONObject(ii);

                            
                        }

                    }
                }
                catch (JSONException exp){

                }
            }

            srvAdapterAcademias = new spnAdapterAcademias(context,android.R.layout.simple_spinner_dropdown_item, spnacademias);

        }
        catch (Exception exp)
        {

        }

    }

    private void getAcademias() {

        try {
            String url = URL;
            String conteudo = HttpRequest.get(url).body();

            JSONArray jsonArray = new JSONArray(conteudo);

            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject json = jsonArray.getJSONObject(i);


            }
        }
        catch (Exception exp)
        {

        }
    }
}
