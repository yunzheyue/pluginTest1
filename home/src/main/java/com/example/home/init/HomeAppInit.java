package com.example.home.init;

import android.app.Application;
import android.util.Log;

import com.example.base.init.IAppInit;

public class HomeAppInit implements IAppInit {
    @Override
    public boolean onInitPre(Application application) {
        Log.e("TAG", "提前配置Home库中的application=="+application);
        return false;
    }

    @Override
    public boolean onInitAfter(Application application) {
        Log.e("TAG", "落后配置Home库中的application=="+application);
        return false;
    }
}
