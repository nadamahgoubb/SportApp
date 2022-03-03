package com.example.sportapp.data.repositorty

import com.example.sportapp.data.entitiy.Run
import com.example.sportapp.data.RunDAO
import javax.inject.Inject

class Repository @Inject constructor(val runDao: RunDAO) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)
    suspend fun deldteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRuns() = runDao.getTotalDistance()
    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()
    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()
    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()
    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()
    fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()

    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()
    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

}