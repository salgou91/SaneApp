package com.example.choits.saneapp.qna;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Button;
import android.widget.RadioGroup.LayoutParams;

import com.example.choits.saneapp.R;

/**
 * Created by choits on 2015. 11. 13..
 */
public class QnaActivity extends Activity {
    private ViewPager mPager;
    private LinearLayout mLayout;
    private int score;
    private boolean isRed=false;
    private Context mContext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qna_layout);

        score=0;
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new PagerAdapterClass(getApplicationContext()));

    }

    private class PagerAdapterClass extends PagerAdapter {
        private LayoutInflater mInflater;

        public PagerAdapterClass(Context c){
            super();
            mInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public int getItemPosition(Object item) {
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(View pager, int position) {
            View v = null;

            if(position==0){
                v = mInflater.inflate(R.layout.qna1, null);
                AddSaveBtn(v);
                v.findViewById(R.id.rb1).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (score == 0) {
                            Toast.makeText(getApplicationContext(), "no more minus", Toast.LENGTH_SHORT).show();
                        } else {
                            score--;
                        }
                        Toast.makeText(getApplicationContext(), "" + score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb2).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), "" + score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb3).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (score == 0) {
                            Toast.makeText(getApplicationContext(), "no more minus", Toast.LENGTH_SHORT).show();
                        } else {
                            score--;
                        }
                        Toast.makeText(getApplicationContext(), "" + score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb4).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), "" + score, Toast.LENGTH_SHORT).show();
                    }
                });

            }
            else if(position==1){
                v = mInflater.inflate(R.layout.qna2, null);
                AddSaveBtn(v);
                v.findViewById(R.id.rb5).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(score==0){
                            Toast.makeText(getApplicationContext(), "no more minus", Toast.LENGTH_SHORT).show();
                        }else{
                            score--;
                        }                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb6).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb7).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(score==0){
                            Toast.makeText(getApplicationContext(), "no more minus", Toast.LENGTH_SHORT).show();
                        }else{
                            score--;
                        }                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb8).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), "" + score, Toast.LENGTH_SHORT).show();
                    }
                });

            }else{
                v = mInflater.inflate(R.layout.qna3, null);
                Log.d("TAG", "please" + isRed);
                AddSaveBtn(v);
                v.findViewById(R.id.rb9).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(score==0){
                            Toast.makeText(getApplicationContext(), "no more minus", Toast.LENGTH_SHORT).show();
                        }else{
                            score--;
                        }
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb10).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb11).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(score==0){
                            Toast.makeText(getApplicationContext(), "no more minus", Toast.LENGTH_SHORT).show();
                        }else{
                            score--;
                        }
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb12).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), "" + score, Toast.LENGTH_SHORT).show();
                    }
                });
                //점수 카운팅 하는거 함수로 빼는 거 해보기.
            }

            ((ViewPager)pager).addView(v, 0);
            v.invalidate();
            return v;
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager)pager).removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View pager, Object obj) {
            return pager == obj;
        }

        @Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
        @Override public Parcelable saveState() { return null; }
        @Override public void startUpdate(View arg0) {


        }
        @Override public void finishUpdate(View arg0) {
            if(score>=0 && score<2) {
                arg0.setBackgroundColor(Color.GREEN);
                isRed = false;
            }
            else if(score>=2 && score<4) {
                arg0.setBackgroundColor(Color.YELLOW);
                isRed = true;
            }
            else if(score>=4 && score<=6) {
                arg0.setBackgroundColor(Color.RED);
                isRed = true;
//                AddSaveBtn(arg0);
            }
        }

        private void AddSaveBtn(View arg0){
            if(isRed==true){
                mContext=getApplicationContext();
                LinearLayout li = new LinearLayout(mContext);
                Button btn = new Button(mContext);

                LayoutParams params = new LayoutParams(300, 150);
                btn.setLayoutParams(params);
                btn.setText("save");
                li.addView(btn, 0);
                li.invalidate();
                LinearLayout curView=(LinearLayout)arg0.findViewById(R.id.layout);
                curView.addView(li);
                curView.invalidate();
                Log.d("TAG", "btn.....");
            }
        }
    }
}
