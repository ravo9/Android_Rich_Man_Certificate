package development.dreamcatcher.richcertificate;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

public class Drawables {

    public static Drawable background;
    public static Drawable cert_gender;
    public static Drawable cert_name;
    public static Drawable cert_mr;
    public static Drawable cert_ms;


    public static void uploadImages(Context game) {

        try {
            InputStream stream = game.getAssets().open("background.png");
            background = Drawable.createFromStream(stream, null);
            stream = game.getAssets().open("cert_gender.png");
            cert_gender = Drawable.createFromStream(stream, null);
            stream = game.getAssets().open("cert_name.png");
            cert_name = Drawable.createFromStream(stream, null);
            stream = game.getAssets().open("cert_mr.png");
            cert_mr = Drawable.createFromStream(stream, null);
            stream = game.getAssets().open("cert_ms.png");
            cert_ms = Drawable.createFromStream(stream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



