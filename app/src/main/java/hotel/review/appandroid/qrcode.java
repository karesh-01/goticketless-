package hotel.review.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrcode extends AppCompatActivity {
    ImageView ivOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        ivOutput = findViewById(R.id.iv_output);
        Intent i = getIntent();
        final String s = getIntent().getStringExtra("message_key");
        //get input value from edit text
        String sText = s;
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            //initialize bit matrix
            BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE, 350, 350);
            //initialize barcodde encoder
            BarcodeEncoder encoder = new BarcodeEncoder();
            //initialize bitmap
            Bitmap bitmap = encoder.createBitmap(matrix);
            //see bitmap on imageview
            ivOutput.setImageBitmap(bitmap);
            //initialize input manager
            InputMethodManager manager = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );
           // manager.hideSoftInputFromWindow(etInput.getApplicationWindowToken(), 0);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
    }