package br.com.alb.maromba;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Aristeu da Silva Filho on 12/09/2016.
 */
public class serverProfessores extends AsyncTask<String, Void, String[]> {

    public String URL =  R.string.URL + "professores"; // URL Servidor DEV

    public JSONArray retProfessores = null;

    protected String[] doInBackground(String... params) {

        try{

            switch (params[0])
            {
                case "Get":
                    getProfessores();
                    break;

                case "GetCadastro":
                    getProfessoresCadastros();
                    break;

                default:
                    break;
            }


        }
        catch (Exception exp){

        }

        return null;
    }

    private void getProfessoresCadastros() {

        try {
            String url = URL;
            String conteudo = HttpRequest.get(url).body();

            retProfessores = new JSONArray(conteudo);

        }
        catch (Exception exp)
        {

        }

    }

    private void getProfessores() {

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
