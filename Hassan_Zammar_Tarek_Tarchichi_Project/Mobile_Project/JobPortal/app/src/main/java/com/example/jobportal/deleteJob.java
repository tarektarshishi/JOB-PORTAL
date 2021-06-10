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

public class deleteJob extends AppCompatActivity {

    private EditText edID;
    private Button btnDelete;
    private RequestQueue queue2;
    private ProgressBar progress1;

    private static final String URLREMOVE = "https://hassanzammar.000webhostapp.com/Project/removeJob.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_job);
        edID = findViewById(R.id.CID);
        btnDelete = findViewById(R.id.btDelete);
        progress1 = findViewById(R.id.progress);

        queue2 = Volley.newRequestQueue(deleteJob.this);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progress1.setVisibility(View.VISIBLE);
                btnDelete.setEnabled(false);

                StringRequest request = new StringRequest(Request.Method.POST, URLREMOVE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(deleteJob.this, response, Toast.LENGTH_SHORT).show();
                        progress1.setVisibility(View.INVISIBLE);
                        btnDelete.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(deleteJob.this, error.toString(), Toast.LENGTH_SHORT).show();
                        progress1.setVisibility(View.INVISIBLE);
                        btnDelete.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("CID", edID.getText().toString());
                        params.put("C_ID", edID.getText().toString());
                        params.put("key", "cuBubcDE");
                        return params;
                    }
                };

                queue2.add(request);
                edID.setText(null);
            }
        });
    }

}