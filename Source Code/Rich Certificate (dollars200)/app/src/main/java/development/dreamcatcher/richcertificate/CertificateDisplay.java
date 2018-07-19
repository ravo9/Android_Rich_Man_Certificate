package development.dreamcatcher.richcertificate;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CertificateDisplay extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    RelativeLayout rl;
    RelativeLayout.LayoutParams lp;
    TextView nameField, dateField;
    ImageView stamp;
    Typeface fontName, fontDate;
    String name, gender, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate_display);

        // Shared Preferences configuration.
        sharedPreferences = this.getSharedPreferences("userDetails", Context.MODE_PRIVATE);

        // Getting data from Shared Preferences.
        name = sharedPreferences.getString("name", "ERROR");
        gender = sharedPreferences.getString("gender", "ERROR");
        date = sharedPreferences.getString("date", "ERROR");

        // Background drawable setting.
        rl = findViewById(R.id.RelativeLayoutDisplay);
        if (gender.equals("male"))
            rl.setBackground(Drawables.cert_mr);
        else if (gender.equals("female"))
            rl.setBackground(Drawables.cert_ms);

        // Proper fonts setting.
        nameField = findViewById(R.id.name);
        nameField.setText(" " + name + " ");
        fontName = Typeface.createFromAsset(getAssets(), "fonts/Parisienne/Parisienne-Regular.ttf");
        nameField.setTypeface(fontName);

        dateField = findViewById(R.id.date);
        dateField.setText(date);
        fontDate = Typeface.createFromAsset(getAssets(), "fonts/Playfair_Display_SC/PlayfairDisplaySC-Italic.ttf");
        dateField.setTypeface(fontDate);

        // Setting text fields and stamp image in their proper positions.
        lp = (RelativeLayout.LayoutParams)nameField.getLayoutParams();
        lp.leftMargin = (int)(MainActivity.screenWidth * 0.465);
        lp.topMargin = (int)(MainActivity.screenHeight * 0.325);
        nameField.setLayoutParams(lp);

        lp = (RelativeLayout.LayoutParams)dateField.getLayoutParams();
        lp.leftMargin = (int)(MainActivity.screenWidth * 0.215);
        lp.topMargin = (int)(MainActivity.screenHeight * 0.704);
        dateField.setLayoutParams(lp);

        stamp = findViewById(R.id.stamp);
        lp = (RelativeLayout.LayoutParams)stamp.getLayoutParams();
        lp.width = (int)(MainActivity.screenWidth * 0.3);
        lp.height = (int)(MainActivity.screenWidth * 0.3);
        lp.leftMargin = (int)(MainActivity.screenWidth * 0.585);
        lp.topMargin = (int)(MainActivity.screenHeight * 0.705);
        stamp.setLayoutParams(lp);
    }
}
