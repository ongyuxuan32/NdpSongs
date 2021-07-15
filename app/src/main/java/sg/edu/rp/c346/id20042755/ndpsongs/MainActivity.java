package sg.edu.rp.c346.id20042755.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

    public class MainActivity extends AppCompatActivity {

        EditText etTitle, etSinger, etYear;
        Button btnInsert, btnShow;
        RadioGroup radioGroup;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etTitle = findViewById(R.id.etSong);
            etSinger = findViewById(R.id.etSinger);
            etYear = findViewById(R.id.etYear);
            btnInsert = findViewById(R.id.btnInsert);
            btnShow = findViewById(R.id.btnShow);
            radioGroup= findViewById(R.id.RadioGroup);

            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this,SongList.class);
                    startActivity(i);
                }
            });

            btnInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!etTitle.getText().toString().isEmpty() && !etSinger.getText().toString().isEmpty() && !etYear.getText().toString().isEmpty()){
                        int stars = 0;
                        int checkedRadioId = radioGroup.getCheckedRadioButtonId();
                        if(checkedRadioId == R.id.radioButton4){
                            stars = 1;
                        }else if(checkedRadioId == R.id.radioButton5){
                            stars = 2;
                        }else if(checkedRadioId == R.id.radioButton6){
                            stars = 3;
                        }else if(checkedRadioId == R.id.radioButton7){
                            stars = 4;
                        }else if(checkedRadioId == R.id.radioButton8){
                            stars = 5;
                        }
                        String title = etTitle.getText().toString();
                        String singer = etSinger.getText().toString();
                        int year = parseInt(etYear.getText().toString());

                        DBHelper dbh = new DBHelper(MainActivity.this);
                        long inserted_id = dbh.insertSong(title,singer,year,stars);
                        Toast.makeText(MainActivity.this, "Song Insert successfully!!!", Toast.LENGTH_SHORT).show();
                        etTitle.setText("");
                        etSinger.setText("");
                        etYear.setText("");
                        radioGroup.check(R.id.radioButton5);
                    }else{
                        Toast.makeText(MainActivity.this, "Please Fill in the blanks", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
