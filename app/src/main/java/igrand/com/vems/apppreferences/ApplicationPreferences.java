package igrand.com.vems.apppreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationPreferences
{
    private static ApplicationPreferences mInstance;
    private static Context mCtx;
    public static final String SHARED_PREF_NAME = "igrandvems";
    public  static final String USER_NAME="user_name";
    public static final String PASSWORD="password";
    public static final String LOGIN_TYPE="login_type";
    public static final String PRINCIPAL_LOGIN="principal";
    public static final String TEACHER_LOGIN="teacher";
    public static final String PARENT_LOGIN="parent";
    public static final String ADMIN_LOGIN="admin"
;
    public ApplicationPreferences(Context context) {
        mCtx = context;
    }

    public static synchronized ApplicationPreferences getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new ApplicationPreferences(context);
        }
        return mInstance;
    }


    public boolean saveUserName(String userName)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
        return true;
    }
    public String getUserName()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(USER_NAME, "");
    }
    public boolean savePassord(String password)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PASSWORD, password);
        editor.apply();
        return true;
    }
    public String getPassword()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(PASSWORD, "");
    }

    public boolean setLoginType(String loginType){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LOGIN_TYPE, loginType);
        editor.apply();
        return true;

    }
    public String getLoginTYpe()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(LOGIN_TYPE, "");
    }

}
