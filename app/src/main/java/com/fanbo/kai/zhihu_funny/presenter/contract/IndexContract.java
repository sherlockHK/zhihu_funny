package com.fanbo.kai.zhihu_funny.presenter.contract;

import com.fanbo.kai.zhihu_funny.model.Sections;
import com.fanbo.kai.zhihu_funny.view.base.BaseView;

/**
 * Created by Kai on 2017/1/21.
 * Email: kaihu1989@gmail.com
 */

public interface IndexContract {
    interface View extends BaseView{

        void showSections(Sections sections);
    }

    interface Presenter{
        void initSections();
    }
}
