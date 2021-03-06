package com.ks.library.smartscroll.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;


public class ScrollWebView extends WebView {

    private OnScrollChangedCallback mOnScrollChangedCallback;

    public ScrollWebView(Context context) {
        super(context);
    }

    public ScrollWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (mOnScrollChangedCallback != null) {
            mOnScrollChangedCallback.onScroll(l, t, l - oldl, t - oldt, canScrollVertically(1));
        }
    }

    public void setOnScrollChangedCallback(
            final OnScrollChangedCallback onScrollChangedCallback) {
        mOnScrollChangedCallback = onScrollChangedCallback;
    }

    /**
     * 如果想要监听WebView的Scroll状态，实现这个借口
     */
    public interface OnScrollChangedCallback {
        void onScroll(int left, int top, int dx, int dy, boolean canScrollUp);
    }
}

