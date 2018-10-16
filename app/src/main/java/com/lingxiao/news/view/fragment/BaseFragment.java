package com.lingxiao.news.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lingxiao.news.MainActivity;
import com.lingxiao.news.http.listener.LifeCycleListener;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lingxiao on 17-11-30.
 */

public abstract class BaseFragment extends RxFragment{
    public MainActivity mActivity;
    private boolean mIsVisibleToUser;
    private Unbinder mRootUnbinder;
    private static final String TAG = BaseFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layId = getContentLayoutId();
        View root = inflater.inflate(layId,container,false);
        initWidget(root);
        mActivity = (MainActivity) getActivity();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mIsVisibleToUser){
            Bundle bundle = getArguments();
            initData(bundle);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.mIsVisibleToUser = isVisibleToUser;
        Log.d(TAG, "setUserVisibleHint: 用户可见");
    }

    public abstract int getContentLayoutId();
    public abstract void initData(Bundle bundle);

    protected void initWidget(View view){
        mRootUnbinder = ButterKnife.bind(this,view);
    }
    /**
     * 回调函数
     */
    public LifeCycleListener mListener;

    public void setOnLifeCycleListener(LifeCycleListener listener) {
        mListener = listener;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //移除view绑定
        if (mRootUnbinder != null) {
            mRootUnbinder.unbind();
        }
    }
}
