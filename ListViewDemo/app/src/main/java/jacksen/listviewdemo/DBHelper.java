package jacksen.listviewdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 2016/6/24.
 */

public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "hero.db";

    private final static int DB_VERSION = 1;

    public static String TABLE_HERO = "hero_table";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table if not exists " + TABLE_HERO + " (id integer primary key, name varchar, intro varchar)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
