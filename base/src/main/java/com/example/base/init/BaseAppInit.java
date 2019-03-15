package com.example.base.init;

import android.app.Application;
import android.util.Log;

public class BaseAppInit implements IAppInit {

    @Override
    public boolean onInitPre(Application application) {
        Log.e("TAG", "提前配置base库中的application=="+application);
        return false;
    }

    @Override
    public boolean onInitAfter(Application application) {
        Log.e("TAG", "落后配置base库中的application=="+application);
        return false;
    }
}
