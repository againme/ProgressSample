package com.againme.progresssample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    /** 다이얼로그 생성에서 프로그레시브바를 구분하기 위한 인자 */
	/*private static final int PROGRESSBAR_DLG_LARGE = 1;
	private static final int PROGRESSBAR_DLG_MID = 2;
	private static final int PROGRESSBAR_DLG_SMALL = 3;
	private static final int PROGRESSBAR_DLG_STATIC = 4;
	private static final int PROGRESSBAR_DLG_SPINNER = 5;*/

    private Button mBtnProgressDlg;
    private Button mBtnSpinner;
    private Button mBtnLarge;
    private Button mBtnMid;
    private Button mBtnSmall;
    private Button mBtnStick;
    private Button mBtnProgressHidden;

    private AsyncTask<Integer, String, Integer> mProgressDlg;
    private ProgressBar mProgressLarge;
    private ProgressBar mProgressMid;
    private ProgressBar mProgressSmall;
    private ProgressBar mProgressStick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String aaa = "";

        // 버튼 객체 설정
        mBtnProgressDlg = (Button) findViewById(R.id.btnProgressDialog);
        mBtnLarge = (Button)findViewById(R.id.btnProgressLarge);
        mBtnMid = (Button)findViewById(R.id.btnProgressMid);
        mBtnSmall = (Button)findViewById(R.id.btnProgressSmall);
        mBtnStick = (Button)findViewById(R.id.btnProgressStick);
        mBtnProgressHidden  = (Button)findViewById(R.id.btnProgressHidden);

        // 프로그레시브바 설정
        mProgressLarge = (ProgressBar) findViewById(R.id.progressBar1);
        mProgressMid = (ProgressBar) findViewById(R.id.progressBar2);
        mProgressSmall = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressStick = (ProgressBar) findViewById(R.id.progressBar4);

        // 클릭이벤트 설정
        mBtnProgressDlg.setOnClickListener(mClickListener);
        mBtnLarge.setOnClickListener(mClickListener); // 진행바 큰것
        mBtnMid.setOnClickListener(mClickListener); // 진행바 중간
        mBtnSmall.setOnClickListener(mClickListener);// 진행바 작은것
        mBtnStick.setOnClickListener(mClickListener); // 막대형 진행바
        mBtnProgressHidden.setOnClickListener(mClickListener); // 막대형 진행바

        // 진행바를 숨긴다
        mProgressLarge.setVisibility(ProgressBar.GONE);
        mProgressMid.setVisibility(ProgressBar.GONE); // 진행바 중간
        mProgressSmall.setVisibility(ProgressBar.GONE);// 진행바 작은것
        mProgressStick.setVisibility(ProgressBar.GONE); // 막대형 진행바
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnProgressDialog:
                    mProgressDlg = new ProgressDlgSample(MainActivity.this).execute(100);
                    break;

                case R.id.btnProgressLarge:
                    mProgressLarge.setVisibility(ProgressBar.VISIBLE);
                    mProgressLarge.setIndeterminate(true);
                    mProgressLarge.setMax(100);

                    break;

                case R.id.btnProgressMid:
                    mProgressMid.setVisibility(ProgressBar.VISIBLE);
                    mProgressMid.setIndeterminate(true);
                    mProgressMid.setMax(100);
                    break;

                case R.id.btnProgressSmall:
                    mProgressSmall.setVisibility(ProgressBar.VISIBLE);
                    mProgressSmall.setIndeterminate(true);
                    mProgressSmall.setMax(100);
                    break;

                case R.id.btnProgressStick:
                    mProgressStick.setVisibility(ProgressBar.VISIBLE);
                    mProgressStick.setIndeterminate(true);
                    mProgressStick.setMax(100);
                    break;

                case R.id.btnProgressHidden:
                    // 진행바를 숨긴다
                    mProgressLarge.setVisibility(ProgressBar.GONE);
                    mProgressMid.setVisibility(ProgressBar.GONE); // 진행바 중간
                    mProgressSmall.setVisibility(ProgressBar.GONE);// 진행바 작은것
                    mProgressStick.setVisibility(ProgressBar.GONE); // 막대형 진행바
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
