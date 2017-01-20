package com.fanbo.kai.zhihu_funny.di.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

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

    public FragmentModule(Activity activity) {
        this.fragment = fragment;
    }

    @PerFragment
    @Provides
    public Context providesActivity() {
        return fragment.getActivity();
    }
}
