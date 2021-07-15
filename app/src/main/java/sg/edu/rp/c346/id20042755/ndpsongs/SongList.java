package sg.edu.rp.c346.id20042755.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {

    ArrayList<Song> al;
    ListView lv;
    Button btnStar;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        btnStar = findViewById(R.id.radioButton8);

        DBHelper dbh = new DBHelper(SongList.this);
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(SongList.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SongList.this);
                al.clear();
                aa.notifyDataSetChanged();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(SongList.this);
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(SongList.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

    }
}
