package com.example.choits.saneapp.report;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.List;
import android.util.Log;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import com.example.choits.saneapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import java.util.ArrayList;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

/**
 * Created by choits on 15. 10. 29..
 */
public class Report_Activity extends FragmentActivity implements OnClickListener {

    //private Firebase myFire;
    private MyPageAdapter pageAdapter;
    private ViewPager mPager;
    private Context mContext;
/*
    private RadioButton rg_gender1;
    private RadioButton rg_gender2;
    private RadioButton rg_partner1;
    private RadioButton rg_partner2;*/


    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private Button button2;
    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_fragment);
       // Firebase.setAndroidContext(this);

        setLayout();

        /*mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();*/

        List<Fragment> fragments = getFragments();

        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);

        mPager = (ViewPager) findViewById(R.id.report_pager);
        mPager.setAdapter(pageAdapter);

//        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
//        mPager.setAdapter(new SlideAdapter(getApplicationContext()));

    }

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(Fragment_A.newInstance("Fragment 1"));
        fList.add(Fragment_B.newInstance("Fragment 2"));
        fList.add(Fragment_C.newInstance("Fragment 3"));

        return fList;
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

    /*
    private String gender = "";
    private String partgender = "";
    private String age = "";
    private String name = "";
*/


    private void setLayout() {
        editText1 = (EditText) findViewById(R.id.reportWhereWrite);
        editText2 = (EditText) findViewById(R.id.reportWhatWrite);
        button1 = (Button) findViewById(R.id.button_regcancel);
        button2 = (Button) findViewById(R.id.button_regsave);
        CalendarView cv = (CalendarView) this.findViewById(R.id.calendarView);

    }

    public void onClick(View v) {

    }

    private OnClickListener mPagerListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
          //  Account ac = new Account(gender, partgender, age, name);
         //   sendQueryToFirebase(ac);
            finish();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        //myFire = new Firebase("https://sarahsane.firebaseio.com/android");

    }

    @Override
    protected void onStop(){
       // mGoogleApiClient.disconnect();
        super.onStop();
    }
/*
    private void sendQueryToFirebase(Account account) {
        Firebase ref = myFire.child("account");
        ref.push().setValue(account);
    }
*/
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
/*
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


        @Override
        public Object instantiateItem(View pager, int position) {
            View v = null;

            if (position == 0) {
                v = mInflater.inflate(R.layout.rep1, null);

            } else if (position == 1) {
                v = mInflater.inflate(R.layout.rep2, null);

            } else {
                v = mInflater.inflate(R.layout.rep3, null);
                v.findViewById(R.id.report_not).setOnClickListener((new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }));
                v.findViewById(R.id.report_go).setOnClickListener(mPagerListener);

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

    }*/

}
