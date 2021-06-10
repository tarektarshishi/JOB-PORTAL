package com.example.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnViewJobs;
    private Button btnPostJob;
    private Button btnEditJob;
    private Button btnEditCompany;
    private Button btnDeleteJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewJobs=findViewById(R.id.btn_ViewJobs);
        btnPostJob=findViewById(R.id.btn_PostJob);
        btnEditCompany=findViewById(R.id.btn_EditCompany);
        btnEditJob=findViewById(R.id.btn_EditJob);
        btnDeleteJob=findViewById(R.id.btn_DeleteJob);

        btnViewJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewJobsActivity.class));

            }
        });

        btnPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));

            }
        });

        btnEditCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),editCompany.class));

            }
        });

        btnEditJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),editJob.class));

            }
        });

        btnDeleteJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),deleteJob.class));

            }
        });
    }
}