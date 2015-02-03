package com.example.guilhermeforj.exemplodiretorio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity {

    private static final String LOG_TAG = "EXTERNO" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("EXTERNO", "Iniciando gravacao");
        try {

            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput( "NovoArquivo", Context.MODE_APPEND));
                outputStreamWriter.write("Adicionando linha no arquivo \r\n");
                outputStreamWriter.close();

                FileInputStream in = openFileInput("NovoArquivo");
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;

                while ( (line = bufferedReader.readLine()) != null  ) {
                    Log.d("EXTERNO", line);
                }

            } catch (Exception ex) {
                Log.d("EXTERNO", "De exception " + ex.getMessage());
            }
        } catch (Exception e) {
            Log.d("EXTERNO", "Deu  exception no segundo catch " + e.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
