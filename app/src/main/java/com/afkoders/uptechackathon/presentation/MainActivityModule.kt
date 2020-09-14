package com.afkoders.uptechackathon.presentation

import android.content.Context
import com.afkoders.uptechackathon.di.qualifiers.ActivityContext
import com.afkoders.uptechackathon.di.scope.FragmentScope
import com.afkoders.uptechackathon.presentation.main.MainFragment
import com.afkoders.uptechackathon.presentation.main.MainFragmentAgreement
import com.afkoders.uptechackathon.presentation.main.MainFragmentPresenter

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun mainFragment(): MainFragment?

    @Binds
    fun testPresenter(mainPresenter: MainFragmentPresenter): MainFragmentAgreement.Presenter

    @ActivityContext
    @Binds
    fun bindActivityContext(mainActivity: MainActivity): Context
}