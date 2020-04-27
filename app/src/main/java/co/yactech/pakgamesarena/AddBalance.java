package co.yactech.pakgamesarena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddBalance extends AppCompatActivity {

    Balance_Fragment1 fragment1;
    Balance_Fragment2 fragment2;
    Balance_Fragment3 fragment3;
    Button button;
    ImageView imageView;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        fragment1 = new Balance_Fragment1();
        fragment2=new Balance_Fragment2();
        fragment3=new Balance_Fragment3();
        button = findViewById(R.id.button);
        imageView=findViewById(R.id.image);

        setFragment(fragment1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count==0){
                    imageView.setImageResource(R.drawable.page2);
                    button.setText("Add To Account");
                    setFragment(fragment2);
                    count++;
                }else if (count==1){
                    imageView.setImageResource(R.drawable.page3);
                    button.setText("Finish");
                    setFragment(fragment3);
                    count++;
                }else if(count==2){
                    Intent i=new Intent(AddBalance.this,Profile.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                }



            }
        });


    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
