package com.szzt.widget.loadingdialog;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/**
 * @author ywc
 * @date 2021/8/11
 */
public class LoadingDialog extends BaseDialog {
	
	private LinearLayout rootView;
	private ProgressBar progressBar;
	private TextView loadingTv;
	
	/***
	 * 文字
	 */
	private String loadingText;
	
	/***
	 * 默认大小 dp
	 */
	private int defaultSize = 80;
	/***
	 * 默认文字大小 sp
	 */
	private int defaultTextSize = 16;
	
	/***
	 * 字体大小
	 */
	private int textSize = defaultTextSize;
	/**
	 * 字体颜色
	 */
	private int textColor;
	/**
	 * 界面大小
	 */
	private int mSize = defaultSize;
	/***
	 * 转圈颜色
	 */
	private int progressBarColor;
	
	/**
	 * 点击外部取消
	 */
	private boolean mOutCancel = false;
	
	public static LoadingDialog newInstance(){
		LoadingDialog dialog = new LoadingDialog();
		
		return dialog;
	}
	
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(DialogFragment.STYLE_NO_TITLE, R.style.loading_dialog);
	}
	
	
	@Override
	public int setUpLayoutId() {
		return R.layout.loading_dialog_view;
	}
	
	@Override
	public void initView(View parent) {
		rootView = (LinearLayout) parent.findViewById(R.id.ll_root_view);
		progressBar = (ProgressBar) parent.findViewById(R.id.progress_bar);
		loadingTv = (TextView) parent.findViewById(R.id.loading_text);
	}
	
	@Override
	public void initData() {
		loadingTv.setTextSize(textSize);
		loadingTv.setTextColor(textColor == 0 ? ContextCompat.getColor(mContext,R.color.loading_dialog_text_color):textColor);

		if (!TextUtils.isEmpty(loadingText)){
			loadingTv.setVisibility(View.VISIBLE);
			loadingTv.setText(loadingText);
		}

		ViewGroup.LayoutParams loadingParams = rootView.getLayoutParams();
		loadingParams.height = dp2px(mContext,mSize);
		loadingParams.width = dp2px(mContext,mSize);
		
		
		progressBar.setIndeterminateTintList(ColorStateList.valueOf(progressBarColor == 0
				?ContextCompat.getColor(mContext,R.color.loading_dialog_progress_bar_color)
				:progressBarColor));
		progressBar.setIndeterminateTintMode(PorterDuff.Mode.SRC_ATOP);
		
		setCancelable(mOutCancel);
	}
	
	
	public LoadingDialog setText(CharSequence sequence){
		if (!TextUtils.isEmpty(sequence)){
			loadingText = sequence.toString();
		}
		
		return this;
	}
	
	/***
	 * 设置文字大小
	 * @param textSize 单位sp
	 * @return
	 */
	public LoadingDialog setTextSize(int textSize){
		if (textSize<0){
			return this;
		}
		this.textSize = textSize;
		return this;
	}
	
	/***
	 * 设置字体颜色
	 * @param color
	 * @return
	 */
	public LoadingDialog setTextColor(int color){
		this.textColor = color;
		return this;
	}
	
	/***
	 * 设置界面大小
	 * @param size unit dp
	 * @return
	 */
	public LoadingDialog setSize(int size){
		if (size <= defaultSize){
			return this;
		}
		mSize = size;
		return this;
	}
	
	/***
	 * 设置动画颜色
	 * @param color ContextCompact.getColor(Context,color)
	 * @return
	 */
	public LoadingDialog setLoadingColor(int color){
		progressBarColor = color;
		return this;
	}
	
	/***
	 * 显示对话框
	 * @param manager
	 */
	public void show(FragmentManager manager){
		super.show(manager,String.valueOf(LoadingDialog.class.getSimpleName()));
	}
}
