package com.example.jobportal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class editJob extends AppCompatActivity {
    private EditText edJobID, edJtitle, edJdescription, edJaddress;
    private Button btEditJob;
    private RequestQueue queue2;
    private ProgressBar progress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_job);


        edJobID = findViewById(R.id.edJobID);
        edJtitle = findViewById(R.id.edJtitle);
        edJdescription = findViewById(R.id.edJdescription);
        edJaddress = findViewById(R.id.edJaddress);

        btEditJob = findViewById(R.id.btEditJob);
        progress1 = findViewById(R.id.progress);

        queue2 = Volley.newRequestQueue(editJob.this);
        btEditJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  URLUPDATE="https://hassanzammar.000webhostapp.com/Project/editJob.php";
                progress1.setVisibility(View.VISIBLE);
                btEditJob.setEnabled(false);

                StringRequest request = new StringRequest(Request.Method.POST, URLUPDATE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(editJob.this, response, Toast.LENGTH_SHORT).show();
                        progress1.setVisibility(View.INVISIBLE);
                        btEditJob.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(editJob.this, error.toString(), Toast.LENGTH_SHORT).show();
                        progress1.setVisibility(View.INVISIBLE);
                        btEditJob.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("Jtitle", edJtitle.getText().toString());
                        params.put("Jdescription", edJdescription.getText().toString());
                        params.put("Jaddress", edJaddress.getText().toString());
                        params.put("C_ID", edJobID.getText().toString());
                        params.put("key", "cuBubcDE");
                        return params;
                    }
                };
                queue2.add(request);
            }
        });
    }

}