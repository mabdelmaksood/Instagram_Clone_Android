package abdelmaksood.mohamed.instagram_clone_android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;
/*
import android.widget.TextView;
import android.widget.Toast;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
*/

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtUNSignUp;
    EditText edtPWSignUp;
    EditText edtMailSignUp;
    EditText  edtUNLogin;
    EditText  edtPWLogin;
    Button btnLogin;
    Button btnSignUp;
    ActionBar myBar;
    ProgressDialog myDialog;
    ///ParseObject testObject=new ParseObject("TempTest");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBar=getSupportActionBar();
        myBar.setBackgroundDrawable(new ColorDrawable(Color.MAGENTA));
        setTitle("SignUp");
        setContentView(R.layout.activity_main);
        edtUNSignUp=findViewById(R.id.edtUNSignup);
        edtMailSignUp=findViewById(R.id.edtMailSignup);
        edtPWSignUp=findViewById(R.id.edtPWSignup);
        edtUNLogin=findViewById(R.id.edtUNLogin);
        edtUNLogin.setAlpha(0);
        edtUNLogin.setEnabled(false);
        edtPWLogin=findViewById(R.id.edtPWLogin);
        edtPWLogin.setAlpha(0);
        edtPWLogin.setEnabled(false);
        btnSignUp=findViewById(R.id.btnSignup);
        btnLogin=findViewById(R.id.btnLogin);
        myDialog=new ProgressDialog(SignUpActivity.this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        btnLogin.setOnClickListener(this);
        edtPWLogin.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode ==KeyEvent.KEYCODE_ENTER && event.getAction() ==KeyEvent.ACTION_DOWN){
                    onClick(v);
                }
                return false;
            }
        });
        btnSignUp.setOnClickListener(this);
        edtPWSignUp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode ==KeyEvent.KEYCODE_ENTER && event.getAction() ==KeyEvent.ACTION_DOWN){
                    onClick(v);
                }
                return false;
            }
        });



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnLogin){

            if(!edtUNLogin.isEnabled()&&  !edtPWLogin.isEnabled()) {
                edtUNLogin.animate().alpha(1).setDuration(700);
                edtUNLogin.setEnabled(true);
                edtPWLogin.animate().alpha(1).setDuration(700);
                edtPWLogin.setEnabled(true);
                edtUNSignUp.animate().alpha(0).setDuration(700);
                edtUNSignUp.setEnabled(false);
                edtPWSignUp.animate().alpha(0).setDuration(700);
                edtPWSignUp.setEnabled(false);
                edtMailSignUp.animate().alpha(0).setDuration(700);
                edtMailSignUp.setEnabled(false);
                setTitle("LogIn");
            }else{
                myDialog.setMessage("Loging In");
                myDialog.show();
                ParseUser.logInInBackground(edtUNLogin.getText().toString(), edtPWLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user!=null && e==null){
                            FancyToast.makeText(getApplicationContext(),"Sign In Successful",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                        }else{
                            FancyToast.makeText(getApplicationContext(),e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                        }
                        myDialog.dismiss();
                    }
                });
            }
        }else if (v.getId()==R.id.btnSignup){

            if(! edtUNSignUp.isEnabled()&& ! edtPWSignUp.isEnabled()){
                edtMailSignUp.animate().alpha(1).setDuration(700);
                edtMailSignUp.setEnabled(true);
                edtUNSignUp.animate().alpha(1).setDuration(700);
                edtUNSignUp.setEnabled(true);
                edtPWSignUp.animate().alpha(1).setDuration(700);
                edtPWSignUp.setEnabled(true);
                edtUNLogin.animate().alpha(0).setDuration(700);
                edtUNLogin.setEnabled(false);
                edtPWLogin.animate().alpha(0).setDuration(700);
                edtPWLogin.setEnabled(false);
                setTitle("SignUp");
            }else {
                myDialog.setMessage("Signing Up");
                myDialog.show();
                ParseUser appUser= new ParseUser();
                appUser.setUsername(edtUNSignUp.getText().toString());
                appUser.setPassword(edtPWSignUp.getText().toString());
                appUser.setEmail(edtMailSignUp.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(getApplicationContext(),"SignUp Successful",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        }else{
                            FancyToast.makeText(getApplicationContext(),e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }
                        myDialog.dismiss();

                    }
                });
            }
        }else{

        }
    }
    /*public void onclicktext(View V){

        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null) FancyToast.makeText(SignUpActivity.this,"Saved Successfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();


                else{
                    // Toast.makeText(SignUpActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    FancyToast.makeText(SignUpActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }
            }
        });

        ParseQuery<ParseObject> myQuery=ParseQuery.getQuery("TempTest");
        myQuery.getInBackground("301uDVKzFk", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e!=null){
                    FancyToast.makeText(SignUpActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }else if(object== null) {
                    FancyToast.makeText(SignUpActivity.this,"nothing returned",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                }else{

                }

            }
        });

    }*/
}
