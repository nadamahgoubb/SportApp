package com.example.sportapp.di

import android.content.Context
import androidx.room.Room
import com.example.sportapp.util.Constant
import com.example.sportapp.data.RunDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModul {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, RunDataBase::class.java,
        Constant.RUNING_DATABASE
    ).build()

    @Provides
    @Singleton
    fun provideDao(dp: RunDataBase) = dp.getDao()

}