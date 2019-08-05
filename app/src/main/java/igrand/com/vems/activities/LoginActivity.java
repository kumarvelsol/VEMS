package igrand.com.vems.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.fragments.ForgotPasswordFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText mInputLoginScreenUserName,mInputLoginScreenPassword;
    TextView mLabelLoginScreenForgotPassword;
    Button mBtnLogin;
    ApplicationPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        initViews();
        if (!preferences.getUserName().isEmpty())
        {
            if (!preferences.getPassword().isEmpty())
            {
                performLogin(preferences.getUserName(),preferences.getPassword());
            }
        }
    }
    private void initViews(){
        mLabelLoginScreenForgotPassword=(TextView)findViewById(R.id.login_screen_forgot_password_label);
        mInputLoginScreenUserName=(TextInputEditText)findViewById(R.id.login_screen_user_name_iput);
        mInputLoginScreenPassword=(TextInputEditText)findViewById(R.id.login_screen_password_iput);
        mBtnLogin=(Button)findViewById(R.id.login_btn);
        mBtnLogin.setOnClickListener(this);
        mLabelLoginScreenForgotPassword.setOnClickListener(this);
        preferences=new ApplicationPreferences(this);
    }
    private boolean validateCredentials(String usernme,String password)
    {
        if (usernme.isEmpty())
        {
            mInputLoginScreenUserName.setError("User Name is Empty");
            mInputLoginScreenUserName.requestFocus();
            return true;
        }
        if (password.isEmpty())
        {
            mInputLoginScreenPassword.setError("Password Is Empty");
            mInputLoginScreenPassword.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.login_screen_forgot_password_label: {
                // Perform Forgot Password Operation Here
                ForgotPasswordFragment bottomSheetFragment = new ForgotPasswordFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
            }
            case R.id.login_btn:{
                if (!validateCredentials(mInputLoginScreenUserName.getText().toString().trim(),
                        mInputLoginScreenPassword.getText().toString().trim()))
                {
                    String user=mInputLoginScreenUserName.getText().toString().trim();
                    String pass=mInputLoginScreenPassword.getText().toString().trim();
                    performLogin(user,pass);
                }
            }
        }

    }

    private void performLogin(String user,String pass)
    {
        if (user.equals("principal"))
        {
            if (pass.equals("principal"))
            {
                saveUserPreferences(user,pass,ApplicationPreferences.PRINCIPAL_LOGIN);
                finish();
                startActivity(new Intent(this,PrincipalDashboardActivity.class));
            }
            else {
                Toast.makeText(this, "Password Invalid", Toast.LENGTH_SHORT).show();
            }
        }
        else if
        (user.equals("teacher")){
            if (pass.equals("teacher"))
            {
                saveUserPreferences(user,pass,ApplicationPreferences.TEACHER_LOGIN);
                finish();
                startActivity(new Intent(this,TeacherDashboardActivity.class));
            }
            else {
                Toast.makeText(this, "Password Invalid", Toast.LENGTH_SHORT).show();
            }
        }
        else if (user.equals("admin"))
        {
            if (user.equals("admin"))
            {
                saveUserPreferences(user,pass,ApplicationPreferences.ADMIN_LOGIN);
                finish();
                startActivity(new Intent(this,AdminDashboardActivity.class));
            }
            else {
                Toast.makeText(this, "Password Invalid", Toast.LENGTH_SHORT).show();
            }
        }
        else if (user.equals("parent"))
        {
            if (pass.equals("parent")){
                saveUserPreferences(user,pass,ApplicationPreferences.PARENT_LOGIN);
                finish();
                startActivity(new Intent(this,ParentDashboardActivity.class));
            }
            else {
                Toast.makeText(this, "Password Invalid", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Invalid USerName", Toast.LENGTH_SHORT).show();
        }
    }
    private void saveUserPreferences(String username,String password,String loginType)
    {
        preferences.saveUserName(username);
        preferences.savePassord(password);
        preferences.setLoginType(loginType);
    }
}
