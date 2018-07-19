package development.dreamcatcher.richcertificate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NameChoice extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    RelativeLayout rl;
    SharedPreferences.Editor editor;
    Intent intent;
    RelativeLayout.LayoutParams lp;
    ImageButton imageButton;
    Typeface fontName;
    EditText inputField;
    String name;
    DateFormat df;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_choice);

        // Shared Preferences configuration.
        sharedPreferences = this.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Background drawable setting.
        rl = findViewById(R.id.RelativeLayoutName);
        rl.setBackground(Drawables.cert_name);

        // Setting proper font (input field).
        inputField = findViewById(R.id.editText);
        fontName = Typeface.createFromAsset(getAssets(), "fonts/Parisienne/Parisienne-Regular.ttf");
        inputField.setTypeface(fontName);

        // Setting button and input into their proper positions.
        imageButton = findViewById(R.id.imageButton);
        lp = (RelativeLayout.LayoutParams)imageButton.getLayoutParams();
        lp.topMargin = (int)(MainActivity.screenHeight * 0.555);
        imageButton.setLayoutParams(lp);

        lp = (RelativeLayout.LayoutParams)inputField.getLayoutParams();
        lp.topMargin = (int)(MainActivity.screenHeight * 0.445);
        inputField.setLayoutParams(lp);
    }

    public void goToDisplay(View v) {

        // Getting a current date to be saved and displayed on certificate.
        df = new SimpleDateFormat("dd.MM.yyyy");
        date = df.format(Calendar.getInstance().getTime());

        inputField = findViewById(R.id.editText);
        name = inputField.getText().toString();
        editor.putString("name", name);
        editor.putString("date", date);
        editor.apply();

        intent = new Intent(this, CertificateDisplay.class);
        startActivity(intent);
        finish();
    }
}
