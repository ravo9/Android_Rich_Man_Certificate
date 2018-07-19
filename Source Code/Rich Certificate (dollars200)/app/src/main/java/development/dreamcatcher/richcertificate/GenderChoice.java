package development.dreamcatcher.richcertificate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class GenderChoice extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    RelativeLayout rl;
    SharedPreferences.Editor editor;
    Intent intent;
    RelativeLayout.LayoutParams lp;
    RadioButton r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_choice);

        // Shared Preferences configuration.
        sharedPreferences = this.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Background drawable setting.
        rl = findViewById(R.id.RelativeLayoutGender);
        rl.setBackground(Drawables.cert_gender);

        // Getting buttons references.
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);

        // Setting buttons in their proper positions.
        lp = (RelativeLayout.LayoutParams)r1.getLayoutParams();
        lp.leftMargin = (int)(MainActivity.screenWidth * 0.29);
        lp.topMargin = (int)(MainActivity.screenHeight * 0.386);
        r1.setLayoutParams(lp);

        lp = (RelativeLayout.LayoutParams)r2.getLayoutParams();
        lp.leftMargin = (int)(MainActivity.screenWidth * 0.29);
        lp.topMargin = (int)(MainActivity.screenHeight * 0.49);
        r2.setLayoutParams(lp);
    }

    public void femaleChosen(View v) {

        editor.putString("gender", "female");
        editor.apply();

        intent = new Intent(this, NameChoice.class);
        startActivity(intent);
        finish();
    }

    public void maleChosen(View v) {

        editor.putString("gender", "male");
        editor.apply();

        intent = new Intent(this, NameChoice.class);
        startActivity(intent);
        finish();
    }
}
