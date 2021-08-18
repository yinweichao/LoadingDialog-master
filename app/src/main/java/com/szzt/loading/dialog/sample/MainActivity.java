package com.szzt.loading.dialog.sample;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
//import com.szzt.widget.loadingdialog.LoadingDialog;


public class MainActivity extends AppCompatActivity {
	
//	private LoadingDialog mDialog;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		mDialog = LoadingDialog.newInstance()
//				.setText("加载中")
//				.setLoadingColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
//
//		findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				mDialog.show(getSupportFragmentManager());
//			}
//		});
	}
	
}
