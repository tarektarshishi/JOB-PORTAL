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

public class PostJobActivity extends AppCompatActivity {

    private EditText edCID, edCname, edEmail, edCphone, edJtitle, edJdescription, address;
    private ProgressBar prog2;
    private Button btAdd;
    private RequestQueue queue1;

    private final static String JOBURL = "https://hassanzammar.000webhostapp.com/Project/saveJob.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        edCID = findViewById(R.id.edCID);
        edCname = findViewById(R.id.edCname);
        edEmail = findViewById(R.id.edEmail);
        edCphone = findViewById(R.id.edCphone);
        edJtitle = findViewById(R.id.edJtitle);
        edJdescription = findViewById(R.id.edJdescription);
        address = findViewById(R.id.edJaddress);
        prog2 = findViewById(R.id.prog2);
        btAdd = findViewById(R.id.btAdd);

        queue1 = Volley.newRequestQueue(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog2.setVisibility(View.VISIBLE);
                btAdd.setEnabled(false);

                StringRequest request1 = new StringRequest(Request.Method.POST, JOBURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PostJobActivity.this, response, Toast.LENGTH_SHORT).show();
                        prog2.setVisibility(View.INVISIBLE);
                        btAdd.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PostJobActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        prog2.setVisibility(View.INVISIBLE);
                        btAdd.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params1 = new HashMap<>();
                        params1.put("CID", edCID.getText().toString());
                        params1.put("Cname", edCname.getText().toString());
                        params1.put("Email", edEmail.getText().toString());
                        params1.put("Cphone", edCphone.getText().toString());
                        params1.put("Jtitle ", edJtitle.getText().toString());
                        params1.put("Jdescription ", edJdescription.getText().toString());
                        params1.put("Jaddress ", address.getText().toString());
                        params1.put("C_ID ", edCID.getText().toString());
                        params1.put("key", "cuBubcDE");
                        return params1;
                    }
                };
                queue1.add(request1);
            }
        });
    }
}