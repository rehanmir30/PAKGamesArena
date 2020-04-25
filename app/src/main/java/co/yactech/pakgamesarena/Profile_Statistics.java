package co.yactech.pakgamesarena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Profile_Statistics extends AppCompatActivity {

    Button pubg_statistics;
    Button cod_statistics;
    Button fortnite_statistics;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__statistics);

        pubg_statistics=findViewById(R.id.pubg_statistics);
        cod_statistics=findViewById(R.id.cod_statistics);
        fortnite_statistics=findViewById(R.id.fortnite_statistics);

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Profile_Statistics.this, Profile.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        });


        pubg_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Profile_Statistics.this,Pubg_Statistics.class);
                startActivity(i);
            }
        });
        cod_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Profile_Statistics.this,COD_Statistics.class);
                startActivity(i);
            }
        });
        fortnite_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Profile_Statistics.this,Fortnite_Statistics.class);
                startActivity(i);
            }
        });
    }
}
