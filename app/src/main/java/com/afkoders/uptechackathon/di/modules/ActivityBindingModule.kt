package com.afkoders.uptechackathon.di.modules

import com.afkoders.uptechackathon.presentation.MainActivity
import com.afkoders.uptechackathon.di.scope.ActivityScope
import com.afkoders.uptechackathon.presentation.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivity(): MainActivity

}