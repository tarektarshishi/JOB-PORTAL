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

public class editCompany extends AppCompatActivity {
    private EditText edID, edNewCompanyName, edNewEmail, edNewPhone;
    private Button btEditCompany;
    private RequestQueue queue2;
    private ProgressBar progress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_company);

        edID = findViewById(R.id.CompanyID);
        edNewCompanyName = findViewById(R.id.edNewCompanyName);
        edNewEmail = findViewById(R.id.edNewEmail);
        edNewPhone = findViewById(R.id.edNewPhone);

        btEditCompany = findViewById(R.id.btEditCompany);
        progress1 = findViewById(R.id.progress);

        queue2 = Volley.newRequestQueue(editCompany.this);

        btEditCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  URLUPDATE="https://hassanzammar.000webhostapp.com/Project/editCompany.php";

                progress1.setVisibility(View.VISIBLE);
                btEditCompany.setEnabled(false);

                StringRequest request = new StringRequest(Request.Method.POST, URLUPDATE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(editCompany.this, response, Toast.LENGTH_SHORT).show();
                        progress1.setVisibility(View.INVISIBLE);
                        btEditCompany.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(editCompany.this, error.toString(), Toast.LENGTH_SHORT).show();
                        progress1.setVisibility(View.INVISIBLE);
                        btEditCompany.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                            params.put("CID", edID.getText().toString());
                            params.put("Cname", edNewCompanyName.getText().toString());
                            params.put("Email", edNewEmail.getText().toString());
                            params.put("Cphone", edNewPhone.getText().toString());
                            params.put("key", "cuBubcDE");
                            return params;
                    }
                };
                queue2.add(request);
            }
        });
    }

}