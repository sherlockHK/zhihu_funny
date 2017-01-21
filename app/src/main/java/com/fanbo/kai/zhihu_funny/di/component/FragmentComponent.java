package com.fanbo.kai.zhihu_funny.di.component;

import com.fanbo.kai.zhihu_funny.di.annotation.PerFragment;
import com.fanbo.kai.zhihu_funny.di.module.FragmentModule;

import dagger.Component;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
}
