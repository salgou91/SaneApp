package com.example.choits.saneapp.register;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.Firebase;

import com.example.choits.saneapp.R;

/**
 * Created by choits on 15. 10. 29..
 */
public class registerActivity extends Activity implements OnClickListener {

    private Firebase myFire;

    private ViewPager mPager;
    private Context mContext;

    private RadioButton rg_gender1;
    private RadioButton rg_gender2;
    private RadioButton rg_partner1;
    private RadioButton rg_partner2;
    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private Button button2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Firebase.setAndroidContext(this);

        setLayout();

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setAdapter(new SlideAdapter(getApplicationContext()));

    }

    private String gender = "";
    private String partgender = "";
    private String age = "";
    private String name = "";


    private void setLayout() {
        rg_gender1 = (RadioButton) findViewById(R.id.radioButton);
        rg_gender2 = (RadioButton) findViewById(R.id.radioButton2);
        rg_partner1 = (RadioButton) findViewById(R.id.radioButton3);
        rg_partner2 = (RadioButton) findViewById(R.id.radioButton4);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button_regcancel);
        button2 = (Button) findViewById(R.id.button_regsave);
    }

    public void onClick(View v) {

    }

    private OnClickListener mPagerListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Account ac = new Account(gender, partgender, age, name);
            sendQueryToFirebase(ac);
            finish();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        myFire = new Firebase("https://sarahsane.firebaseio.com/android");

    }

    private void sendQueryToFirebase(Account account) {
        Firebase ref = myFire.child("account");
        ref.push().setValue(account);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class SlideAdapter extends PagerAdapter {
        private LayoutInflater mInflater;

        public SlideAdapter(Context c) {
            super();
            mInflater = LayoutInflater.from(c);
        }

        public boolean isViewFromObject(View pager, Object obj) {
            return pager == obj;
        }

        public int getCount() {
            return 3;
        }

        private RadioButton rg_gender1;

        @Override
        public Object instantiateItem(View pager, int position) {
            View v = null;

            if (position == 0) {
                v = mInflater.inflate(R.layout.reg1, null);
                v.findViewById(R.id.radioButton).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gender = ((RadioButton) v).getText().toString();
                        Toast.makeText(getApplicationContext(), gender, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.radioButton2).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gender = ((RadioButton) v).getText().toString();
                        Toast.makeText(getApplicationContext(), gender, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.radioButton3).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        partgender = ((RadioButton) v).getText().toString();
                        Toast.makeText(getApplicationContext(), partgender, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.radioButton4).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        partgender = ((RadioButton) v).getText().toString();
                        Toast.makeText(getApplicationContext(), partgender, Toast.LENGTH_SHORT).show();
                    }
                });
            } else if (position == 1) {
                v = mInflater.inflate(R.layout.reg2, null);
                v.findViewById(R.id.editText).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            age = ((EditText) v).getText().toString();
                            Toast.makeText(getApplicationContext(), age, Toast.LENGTH_SHORT).show();
                        } else {
                            age = ((EditText) v).getText().toString();
                            Toast.makeText(getApplicationContext(), age, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                v.findViewById(R.id.editText2).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = ((EditText) v).getText().toString();
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                      //  Intent intent = new Intent(getApplicationContext(), ResponseActivity.class);
                      //  startActivity(intent);
                    }
                });

            } else {
                v = mInflater.inflate(R.layout.reg3, null);
                v.findViewById(R.id.button_regcancel).setOnClickListener((new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }));
                v.findViewById(R.id.button_regsave).setOnClickListener(mPagerListener);

            }

            ((ViewPager) pager).addView(v, 0);

            return v;
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager) pager).removeView((View) view);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }

        @Override
        public void finishUpdate(View arg0) {
        }

    }

}
