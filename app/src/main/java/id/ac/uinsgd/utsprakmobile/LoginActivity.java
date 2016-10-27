package id.ac.uinsgd.utsprakmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    // Email, password edittext
    EditText txtUsername, txtPassword;
    // isi Shared Preferences
    private final String NAMA = "Belajar Sessions";
    private final String EMAIL = "email@gmail.com";
    // Username dan password
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    // login button
    Button btnLogin;
    // Session Manager Class
    SessionManager session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0)
                {
                    if(username.equals(USERNAME) && password.equals(PASSWORD)){

                        session.createLoginSession(NAMA, EMAIL);
                        Intent i = new Intent(getApplicationContext(),
                                MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{

                        Toast.makeText(getApplicationContext(), "Login Gagal..\n"
                                + "Username/Password anda salah", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login Gagal..\n" +
                            "Silahkan masukan username dan password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}