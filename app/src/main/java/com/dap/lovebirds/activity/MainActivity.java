package com.dap.lovebirds.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dap.lovebirds.R;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private CircleImageView ImageView;
    private TextView tvTextView, tvSkip;
    private Button btLogin;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;
    private TextInputEditText edName, edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        ImageView = findViewById(R.id.ic_logo);
        tvTextView = findViewById(R.id.ic_logo_text);
        btLogin = findViewById(R.id.bt_loginButton);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
        tvSkip = findViewById(R.id.tv_skip);
        edName = findViewById(R.id.ed_name);
        edPass = findViewById(R.id.ed_pass);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvTextView.setVisibility(GONE);
                loadingProgressBar.setVisibility(GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                ImageView.setImageResource(R.drawable.img);
                startAnimation();
            }
        }, 4000);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser();
            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SkipActivity.class );
                startActivity(intent);
            }
        });
    }


    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = ImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


    public void validateUser() {
        String usernameValue = edName.getText().toString();
        String passWordValue = edPass.getText().toString();
        boolean cancle = false;
        View focousview = null;

        if (TextUtils.isEmpty(usernameValue)) {
            focousview = edName;
            cancle = true;
            Toast.makeText(this, "Please enter your name then enter your Love Bird name", Toast.LENGTH_SHORT).show();
            return;

        } else if (!usernameValue.equalsIgnoreCase("user")) {
            focousview = edName;
            cancle = true;
            Toast.makeText(this, "Please enter correct your name then enter your Love Bird name", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(passWordValue)) {
            focousview = edPass;
            cancle = true;
            Toast.makeText(this, "password is  Relationship date in  dd/mm/yyyy", Toast.LENGTH_SHORT).show();
            return;

        } else if (!passWordValue.equalsIgnoreCase("123")) {
            focousview = edName;
            cancle = true;
            Toast.makeText(this, "password is  Relationship date in  dd/mm/yyyy", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cancle) {
            focousview.requestFocus();
        } else {
            Intent i = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(i);
            Toast.makeText(this, "Welcome to your Love life My love ", Toast.LENGTH_SHORT).show();
        }

    }

}
