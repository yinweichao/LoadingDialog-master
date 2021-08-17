package com.szzt.widget.loadingdialog;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

/**
 * @author ywc
 * @date 2021/8/11
 */
public abstract class BaseDialog extends AppCompatDialogFragment {
	@LayoutRes
	protected int mLayoutResId;
	
	public Context mContext;
	
	
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mContext = context;
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(DialogFragment.STYLE_NO_TITLE, R.style.loading_dialog);
		mLayoutResId = setUpLayoutId();
	}
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = LayoutInflater.from(mContext).inflate(mLayoutResId,null);
		initView(view);
		return view;
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initData();
	}
	
	/**
	 * 设置dialog布局
	 *
	 * @return
	 */
	public abstract int setUpLayoutId();
	
	/**
	 * 操作dialog布局
	 *
	 */
	public abstract void initView(View parent);
	
	public abstract void initData();
	
	
	public static int dp2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
}
