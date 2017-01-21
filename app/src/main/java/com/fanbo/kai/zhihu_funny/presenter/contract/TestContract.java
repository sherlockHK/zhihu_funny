package com.fanbo.kai.zhihu_funny.presenter.contract;

import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenterInterface;
import com.fanbo.kai.zhihu_funny.ui.base.BaseView;

/**
 * Created by Kai on 2017/1/21.
 * Email: kaihu1989@gmail.com
 */

public interface TestContract {
    interface View extends BaseView{
        void showTest(String str);
    }

    interface Presenter extends BasePresenterInterface<View> {
        void test(String str);
    }
}
