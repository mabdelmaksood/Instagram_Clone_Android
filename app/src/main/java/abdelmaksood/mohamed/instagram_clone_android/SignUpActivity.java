package abdelmaksood.mohamed.instagram_clone_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
import com.shashank.sony.fancytoastlib.FancyToast;
import com.parse.GetCallback;
import com.parse.ParseException;
*/

public class SignUpActivity extends AppCompatActivity {
    EditText edtUNSignUp;
    EditText edtPWSignUp;
    EditText  edtUNLogin;
    EditText  edtPWLogin;
    Button btnLogin;
    Button btnSignUp;
    ///ParseObject testObject=new ParseObject("TempTest");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUNSignUp=findViewById(R.id.edtUNSignup);
        edtPWSignUp=findViewById(R.id.edtPWSignup);
        edtUNLogin=findViewById(R.id.edtUNLogin);
        edtPWLogin=findViewById(R.id.edtPWLogin);
        btnSignUp=findViewById(R.id.btnSignup);
        btnLogin=findViewById(R.id.btnLogin);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(edtUNLogin.getText().toString(), edtPWLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user!=null && e==null){
                            FancyToast.makeText(getApplicationContext(),"Sign In Successful",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                        }else{
                            FancyToast.makeText(getApplicationContext(),e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                        }
                    }
                });
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser appUser= new ParseUser();
                appUser.setUsername(edtUNSignUp.getText().toString());
                appUser.setPassword(edtPWSignUp.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(getApplicationContext(),"SignUp Successful",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        }else{
                            FancyToast.makeText(getApplicationContext(),e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }

                    }
                });

            }
        });



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
