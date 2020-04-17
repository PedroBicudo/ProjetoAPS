package apps.learn.projetoaps.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class CriaBanco extends SQLiteOpenHelper {
    public static final String DB_NAME = "APS.db";
    public static final String CONTACTS_TABLE_NAME = "Respostas";
    public static final int DB_VERSION = 1;


    public CriaBanco(Context context){
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabelaQuest = "CREATE TABLE IF NOT EXISTS Questoes ("
        + "id integer primary key autoincrement,"
        + "Perguntas text"
        +")";

        String tabelaAlternativas = "CREATE TABLE IF NOT EXISTS Alternativas ("
        + "id integer primary key autoincrement,"
        + "A text,"
        + "B text,"
        + "C text,"
        + "D text"
        +")";

        try{
            db.execSQL(tabelaQuest);
            db.execSQL(tabelaAlternativas);
        }catch(SQLException e){
            System.err.println("Erro ao Criar a tabela Questoes ou Alternativas");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            System.out.println("Vou atualizar o banco!!");
            onCreate(db);
        }
    }

    public boolean inserirRespostas(String s, String s1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nome", s);
        contentValues.put("Resultado", s1);
        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }

    public int gerarNumAleatorio(){
        //função que gerara um numero aleatorio de 1 a 100 de acordo com a quantidades de Perguntas
        //do banco de dados
        Random random = new Random();
        int numero = random.nextInt(100);
        return numero;
    }

    public ArrayList gerarPergunta() {
        //Esse parametro vai ser usado para a geração de novas perguntas as querys serão feitas
        // a partir do ID
        int parametro = gerarNumAleatorio();

        SQLiteDatabase db = this.getReadableDatabase();

        //Aqui ja fazemoso a Query
        Cursor res = db.rawQuery( "select perguntas, A, B, C, D from Alternativas, Questoes where Alternativas.id = '"+parametro+"' AND Questoes.id ='"+parametro+"'" , null );
        //Criando o Array
        ArrayList<Integer> resultDB = new ArrayList<>();
        //Fazendo a indexação no array coluna por coluna
        resultDB.add(res.getColumnIndex("perguntas"));
        res.moveToNext();
        resultDB.add(res.getColumnIndex("A"));
        res.moveToNext();
        resultDB.add(res.getColumnIndex("B"));
        res.moveToNext();
        resultDB.add(res.getColumnIndex("C"));
        res.moveToNext();
        resultDB.add(res.getColumnIndex("D"));
        return resultDB;
    }

}


