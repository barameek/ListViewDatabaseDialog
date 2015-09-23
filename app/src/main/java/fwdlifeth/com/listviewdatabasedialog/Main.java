package fwdlifeth.com.listviewdatabasedialog;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity {

    SQLiteDatabase mDb;
    Database mHelper;
    Cursor mCursor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mHelper = new Database(this);
        mDb = mHelper.getWritableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM "
                + Database.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();

        mCursor.moveToFirst();
        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex
                    (Database.COL_THNAME)));
            mCursor.moveToNext();
        }

        ListView listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(new ArrayAdapter(this
                , android.R.layout.simple_list_item_1, dirArray));
        listView1.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1
                    , int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                final Dialog dialog = new Dialog(Main.this);
                dialog.requestWindowFeature
                        (dialog.getWindow().FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_data);

                TextView textTHName =
                        (TextView)dialog.findViewById(R.id.textTHName);
                textTHName.setText("Name [TH] : "
                        + mCursor.getString(mCursor.getColumnIndex
                        (Database.COL_THNAME)));

                TextView textENName =
                        (TextView)dialog.findViewById(R.id.textENName);
                textENName.setText("Name [EN] : "
                        + mCursor.getString(mCursor.getColumnIndex
                        (Database.COL_ENNAME)));

                TextView textKingdom =
                        (TextView)dialog.findViewById(R.id.textKingdom);
                textKingdom.setText("Kingdom : "
                        + mCursor.getString(mCursor.getColumnIndex
                        (Database.COL_KINGDOM)));

                TextView textPhylum =
                        (TextView)dialog.findViewById(R.id.textPhylum);
                textPhylum.setText("Phylum : "
                        + mCursor.getString(mCursor.getColumnIndex
                        (Database.COL_PHYLUM)));

                TextView textClass =
                        (TextView)dialog.findViewById(R.id.textClass);
                textClass.setText("Class : "
                        + mCursor.getString(mCursor.getColumnIndex
                        (Database.COL_CLASS)));

                TextView textOrder =
                        (TextView)dialog.findViewById(R.id.textOrder);
                textOrder.setText("SOrder : "
                        + mCursor.getString(mCursor.getColumnIndex
                        (Database.COL_ORDER)));

                Button buttonOK =
                        (Button)dialog.findViewById(R.id.buttonOK);
                buttonOK.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
    }

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }
}
