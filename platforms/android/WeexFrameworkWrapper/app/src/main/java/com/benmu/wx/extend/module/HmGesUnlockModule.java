package com.benmu.wx.extend.module;

import android.content.Intent;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.benmu.wx.activity.CreateGestureActivity;
import com.benmu.wx.activity.GestureLoginActivity;
import com.benmu.wx.constant.Constant;
import com.benmu.wx.utils.ACache;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by liangshuai on 2018/3/5.
 * WeexFrameworkWrapper
 * com.weex.home.test.extend.module
 */

@WeexModule(name = "hmGesUnlock", lazyLoad = true)
public class HmGesUnlockModule extends WXModule {
    private ACache aCache;


    @JSMethod
    public void addGesturePage(final JSCallback callback) {
        Intent intent = new Intent(new Intent(mWXSDKInstance.getContext(), CreateGestureActivity.class));
        intent.putExtra(Constant.CREATE_GESTURE_CALLBACK, callback);
        mWXSDKInstance.getContext().startActivity(intent);
    }

    @JSMethod
    public void checkGesturePage(final JSCallback callback) {
        Intent intent = new Intent(new Intent(mWXSDKInstance.getContext(), GestureLoginActivity.class));
        intent.putExtra(Constant.CHECK_GESTURE_CALLBACK, callback);
        mWXSDKInstance.getContext().startActivity(intent);
    }

    @JSMethod
    public void removeGesturePassword(final JSCallback callback) {
        aCache = ACache.get(mWXSDKInstance.getContext());
        boolean removeSuccess = aCache.remove(Constant.GESTURE_PASSWORD);
        callback.invoke(removeSuccess ? "success" : "failed");
    }

}
