package fwdlifeth.com.listviewdatabasedialog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "Animal";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "AnimalData";

    public static final String COL_THNAME = "c_name_th";
    public static final String COL_ENNAME = "c_name_en";
    public static final String COL_KINGDOM = "c_kingdom";
    public static final String COL_PHYLUM = "c_phylum";
    public static final String COL_CLASS = "c_class";
    public static final String COL_ORDER = "c_order";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME
                +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_THNAME + " TEXT, " + COL_ENNAME + " TEXT, "
                + COL_KINGDOM + " TEXT, " + COL_PHYLUM + " TEXT, "
                + COL_CLASS + " TEXT, " + COL_ORDER + " TEXT);");

        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('นกแก้ว', 'Parrots', 'Animalia', 'Chordata'"
                + ", 'Aves', 'Psittaciformes');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('สิงโต', 'Lion', 'Animalia', 'Chordata'"
                + ", 'Mammalia', 'Carnivora');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('ยีราฟ', 'Giraffe', 'Animalia', 'Chordata'"
                + ", 'Mammalia', 'Artiodactyla');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('ค้างคาว', 'Bat', 'Animalia', 'Chordata'"
                + ", 'Mammalia', 'Eutheria');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('จิงโจ้', 'Kangaroo', 'Animalia', 'Chordata'"
                + ", 'Mammalia', 'Diprotodontia');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('ซาลาแมนเดอร์', 'Salamanders', 'Animalia'"
                + ", 'Chordata', 'Amphibia', 'Caudata');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('กวาง', 'Deer', 'Animalia', 'Chordata'"
                + ", 'Mammalia', 'Artiodactyla');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('ปลาโลมา', 'Dolphin', 'Animalia', 'Chordata'"
                + ", 'Mammalia', 'Cetacea');");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COL_THNAME
                + ", " + COL_ENNAME + ", " + COL_KINGDOM + ", "
                + COL_PHYLUM + ", " + COL_CLASS + ", " + COL_ORDER
                + ") VALUES ('ม้าน้ำ', 'Seahorses', 'Animalia', 'Chordata'"
                + ", 'Actinopterygii', 'Syngnathiformes');");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion
            , int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
