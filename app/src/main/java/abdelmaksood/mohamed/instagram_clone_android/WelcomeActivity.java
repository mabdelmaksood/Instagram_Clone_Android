package abdelmaksood.mohamed.instagram_clone_android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setTitle("Welcome");
        ActionBar myBar=getSupportActionBar();
        myBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(100,50,25)));
        setContentView(R.layout.activity_welcome);
        welcome=findViewById(R.id.imgWelcome);
        welcome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent myIntent=new Intent(WelcomeActivity.this,SignUpActivity.class);
        startActivity(myIntent);
    }
}
