package com.afkoders.uptechackathon.di.components

import com.afkoders.uptechackathon.HackathonApplication
import com.afkoders.uptechackathon.data.mainRepository.RepositoryModule
import com.afkoders.uptechackathon.di.modules.ApplicationModule
import com.afkoders.uptechackathon.di.modules.NetworkingModule
import com.afkoders.uptechackathon.di.modules.RxModule
import com.afkoders.uptechackathon.di.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@ApplicationScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        RxModule::class,
        RepositoryModule::class,
        NetworkingModule::class]
)
interface ApplicationComponent : AndroidInjector<HackathonApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<HackathonApplication>()
}