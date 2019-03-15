package com.example.base.init;

import android.app.Application;

public interface IAppInit  {
//    首先初始化的部分
    boolean onInitPre(Application application);
//    其次初始化的部分
    boolean onInitAfter(Application application);
}
