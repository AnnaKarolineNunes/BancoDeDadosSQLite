package com.cursoandroid.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //criando o banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE,null);

            // criar a tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            //bancoDados.execSQL("DROP TABLE pessoas");


            // inserir dados
            bancoDados.execSQL("INSERT INTO pessoas(nome,idade)VALUES ('Leticia','45')"); // a ordem importa
            //bancoDados.execSQL("INSERT INTO pessoas(nome,idade)VALUES ('Patricia','20')"); // a ordem importa

            // atualizar registros
            //bancoDados.execSQL("UPDATE pessoas SET nome  = 'Mariana Silva' WHERE id  = 2" );
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2 ");

            //recuperar a tabela pessoas
            String consulta = "SELECT * FROM pessoas WHERE 1=1 ";
            Cursor cursor =  bancoDados.rawQuery(consulta,null); // recupera todos registros

            // Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceId = cursor.getColumnIndex("id");

            cursor.moveToFirst(); // volta para o primeiro item da lista
            while(cursor != null){
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);
                Log.i("RESULTADO - id " , id + " / nome : " +   nome + " / idade: " + idade);
                cursor.moveToNext(); // move o cursor para o proximo registro
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
