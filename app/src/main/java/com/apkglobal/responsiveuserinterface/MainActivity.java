package com.apkglobal.responsiveuserinterface;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.Button;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener

{
    Button home,about,career,admision,contact,technology,enquiry,call;
    int id=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home=(Button) findViewById(R.id.home);
       about=(Button) findViewById(R.id.about);
       career=(Button) findViewById(R.id.career);
        admision=(Button) findViewById(R.id.admission);
        contact=(Button) findViewById(R.id.contactus);
        technology=(Button) findViewById(R.id.technology);
        enquiry=(Button) findViewById(R.id.enquiry);
        call=(Button) findViewById(R.id.callus);


         home.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent home= new Intent(MainActivity.this,HomeActivity.class);
               startActivity(home);
             }
         });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent about= new Intent(MainActivity.this,AboutActivity.class);
                startActivity(about);
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent tech= new Intent(MainActivity.this,TechnologyActivity.class);
                startActivity(tech);
            }
        });
       career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent career= new Intent(MainActivity.this,CareerActivity.class);
                startActivity(career);
            }
        });
      // click on button with code optimisation

        contact.setOnClickListener(this);

        Toast.makeText(this, "create", Toast.LENGTH_LONG).show();

        contact.setOnClickListener(this);
        admision.setOnClickListener(this);
        enquiry.setOnClickListener(this);
        call.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "resume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "pause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destroy", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onClick(View view)
    {
        int id= view.getId();
        switch (id)

        {
            case R.id.contactus:
             /*   Intent contact= new Intent(MainActivity.this,AboutActivity.class);
                startActivity(contact);*/
               callruntime();
            break;

            case R.id.admission:
                Intent admission= new Intent(MainActivity.this,AboutActivity.class);
                startActivity(admission);
                break;

            case R.id.callus:
                Intent call= new Intent(Intent.ACTION_CALL);
                 call.setData(Uri.parse("tel:7891092840"));
                 startActivity(call);
                break;

            case R.id.enquiry:
                Intent enquiry = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(enquiry);
                break;

        }
    }

    private void callruntime() {

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},id);


        }

        
       else
        {
            Intent call= new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:7891092840"));
            startActivity(call);


        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode== id)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callruntime();
            }
        }


    }
}


