package com.cn.myapplicationcao;

import ohos.aafwk.ability.AbilityPackage;
import ohos.app.Context;
import ohos.mp.metadata.annotation.MetaDataApplication;
import ohos.mp.metadata.binding.MetaDataFramework;

@MetaDataApplication(requireData = true, exportData = false)
public class MyApplication extends AbilityPackage {
    private Context context;

    @Override
    public void onInitialize() {
        super.onInitialize();
        context = this.getContext();
        MetaDataFramework.init(this);
    }
}
