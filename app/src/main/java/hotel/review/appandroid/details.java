package hotel.review.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class details extends AppCompatActivity {
    Button b;
    EditText name,phone,qt,date,time;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        b=findViewById(R.id.button);
        date=findViewById(R.id.editTextDate);
        name=findViewById(R.id.editTextTextPersonName);
        phone=findViewById(R.id.editTextPhone);
        qt=findViewById(R.id.editTextTextPersonName2);
        time=findViewById(R.id.editTextTime);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d=date.getText().toString();
                String t=time.getText().toString();
                String n=name.getText().toString();
                String p=phone.getText().toString();
                String qtt=qt.getText().toString();
                int q = Integer.parseInt(qt.getText().toString());
                if(d.length()!=10)
                    Toast.makeText(getApplicationContext(),"Enter proper booking date",Toast.LENGTH_LONG).show();
                else if (p.length()!=10)
                    Toast.makeText(getApplicationContext(),"Enter proper mobile number",Toast.LENGTH_LONG).show();
                else if(q>50)
                    Toast.makeText(getApplicationContext(),"Only maximum of 50 allowed",Toast.LENGTH_LONG).show();
                else if(n.length()<1)
                    Toast.makeText(getApplicationContext(),"Fill in all fields",Toast.LENGTH_LONG).show();
                else
                {   s="ID"+qt.getText().toString()+name.getText().toString()+date.getText().toString()+":"+t;
                Toast.makeText(getApplicationContext(),"Successful booking",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),qrcode.class);
                i.putExtra("message_key",s);
                startActivity(i);
            }}
        });
    }

}