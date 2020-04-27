package co.yactech.pakgamesarena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Withdraw_Money extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw__money);

        Spinner spinner=findViewById(R.id.spinner);
        Button withdraw_button=findViewById(R.id.withdraw_button);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.spinner_values,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        withdraw_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Withdraw_Money.this,Finish_Transection.class);
                startActivity(i);
            }
        });

    }
}
