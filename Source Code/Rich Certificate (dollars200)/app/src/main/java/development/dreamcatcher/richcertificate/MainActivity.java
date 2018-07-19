package development.dreamcatcher.richcertificate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Intent intent;
    DisplayMetrics displayMetrics;
    String name;

    public static int screenHeight, screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Drawables.uploadImages(this);

        sharedPreferences = this.getSharedPreferences("userDetails", Context.MODE_PRIVATE);

        // To be removed (auto-reset)
        /*// -----
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        // -----*/

        // Screen height and width getting.
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        // Checking if the 'name' value has ever been defined - if no - ask for gender and name.
        name = sharedPreferences.getString("name", "NO NAME");

        if (name == "" || name == null  || name == "NO NAME")
            intent = new Intent(this, GenderChoice.class);
        else
            intent = new Intent(this, CertificateDisplay.class);

        startActivity(intent);
        finish();
    }
}
