package com.cn.myapplicationcao.slice;

import com.cn.myapplicationcao.ResourceTable;
import com.cn.myapplicationcao.utils.DoubleLineListItemFactory;
import com.cn.myapplicationcao.utils.RichTextFactory;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.agp.components.ScrollView;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ElementScatter;
import ohos.agp.text.RichText;
import ohos.bundle.AbilityInfo;
import ohos.global.configuration.Configuration;
import ohos.global.icu.util.VersionInfo;

/**
 * MainAbilitySlice
 */
public class MainAbilitySlice extends AbilitySlice {
    private static final int OVER_SCROLL_PERCENT = 20;
    private static final float OVER_SCROLL_RATE = 1.0f;
    private static final int REMAIN_VISIBLE_PERCENT = 20;
    private static final int ITEM_NUM = 3;

    private String[] mName = new String[]{"用户协议", "隐私条款", "社区规范", "去评分"};

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initScrollView();
        initItems();
        initAppBar();
        initVersion();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    private void initAppBar() {
        DirectionalLayout backButton = (DirectionalLayout)
                findComponentById(ResourceTable.Id_appBar_backButton_touchTarget);
        backButton.setClickedListener(component -> onBackPressed());
    }

    private void initScrollView() {
        ScrollView scrollView = (ScrollView) findComponentById(ResourceTable.Id_aboutPageScrollView);
        scrollView.setReboundEffectParams(OVER_SCROLL_PERCENT, OVER_SCROLL_RATE, REMAIN_VISIBLE_PERCENT);
        scrollView.setReboundEffect(true);
    }

    private void initVersion(){
        Text version = (Text) findComponentById(ResourceTable.Id_aboutPageTitleSecondary);
        version.setText("当前的版本号是");
    }

    private void initItems() {
        DoubleLineListItemFactory doubleLineListItemFactory = new DoubleLineListItemFactory(getContext());
        DirectionalLayout aboutPageList = (DirectionalLayout) findComponentById(ResourceTable.Id_aboutPageLowerPart);
        aboutPageList.removeAllComponents();
        // Add ITEM_NUM - 1 Components, manually hide the last component's divider
        for (int i = 0; i < mName.length; i++) {
            String name = mName[i];
            aboutPageList.addComponent(doubleLineListItemFactory
                    .getDoubleLineList(name, ""));
        }
    }
}
