package com.example.alecksjohanssen.myapplication;

/**
 * Created by AlecksJohanssen on 4/9/2016.
 */
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;
        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
public class DBController extends SQLiteOpenHelper {
    private static final String LOGCAT = null;
    public DBController(Context applicationcontext) {
        super(applicationcontext, "QuestionDB.db", null, 1);  // creating DATABASE
        Log.d(LOGCAT, "Created");
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE IF NOT EXISTS proinfo ( Id INTEGER PRIMARY KEY, Company TEXT,Name TEXT,Price TEXT)";
        database.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old,
                          int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS proinfo";
        database.execSQL(query);
        onCreate(database);
    }
    public ArrayList<Question> getAllProducts() {
        ArrayList<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT  * FROM proinfo";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPTA(cursor.getString(2));
                quest.setOPTB(cursor.getString(3));
                quest.setOPTC(cursor.getString(4));
                quest.setOPTD(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
}