package com.example.computermanagement_324;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "Computer_Managements";
    public static final int DB_Version = 1;
    public static final String ID_CP = "id";
    public static final String NAME_CP = "name";
    public static final String CATEGORY_CP = "categoryId";
    public static final String ID_CR = "id";
    public static final String NAME_CR = "name";
    public static final String CATEGORY = "Category";
    public static final String INF_COMPUTER = "InfComputer";

    private String table_Category= "CREATE TABLE "  + CATEGORY + "(" + ID_CR + " int not null Primary key,"
            + NAME_CR + " varchar(200) not null )";

    private String table_InfComputer = "CREATE TABLE " + INF_COMPUTER + "("
            + ID_CP + " INT NOT NULL PRIMARY KEY," +
            NAME_CP + " VARCHAR(200) NOT NULL," +
            CATEGORY_CP + " INT NOT NULL)";

    private String insert_Category = "INSERT INTO " + CATEGORY + " VALUES (1,'DELL'),(2,'ACER'),(3,'ASUS')";
    private String insert_InfoComputer = "INSERT INTO " + INF_COMPUTER + " VALUES (12,'DELL NHA ',1),(13,'ACER NITRO',2),(14,'ASUS 2 PRO',3)";


    public DBHelper(Context context){
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(table_Category);
        sqLiteDatabase.execSQL(table_InfComputer);
        sqLiteDatabase.execSQL(insert_Category);
        sqLiteDatabase.execSQL(insert_InfoComputer);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS InfComputer";
        sqLiteDatabase.execSQL(sql);
        String sql2 = "DROP TABLE IF EXISTS Category";
        sqLiteDatabase.execSQL(sql2);
        onCreate(sqLiteDatabase);
    }
}
