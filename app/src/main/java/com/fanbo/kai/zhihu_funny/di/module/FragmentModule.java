package com.fanbo.kai.zhihu_funny.di.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.fanbo.kai.zhihu_funny.di.annotation.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @PerFragment
    @Provides
    Context provideActivity() {
        return fragment.getActivity();
    }
}
