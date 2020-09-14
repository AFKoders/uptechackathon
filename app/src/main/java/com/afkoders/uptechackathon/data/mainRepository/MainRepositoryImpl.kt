package com.afkoders.uptechackathon.data.mainRepository

import android.util.Log
import com.afkoders.uptechackathon.data.prefs.AppPrefs
import com.afkoders.uptechackathon.data.service.ApiService
import com.afkoders.uptechackathon.di.qualifiers.SchedulerIO
import com.afkoders.uptechackathon.di.qualifiers.SchedulerUI
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.reactivex.Scheduler
import io.reactivex.Single

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appPrefs: AppPrefs,
    @SchedulerUI private val schedulerUI: Scheduler,
    @SchedulerIO private val schedulerIO: Scheduler
) : MainRepository {

    private val db = Firebase.firestore

    val user = hashMapOf(
        "first" to "Ada",
        "last" to "Lovelace",
        "born" to 1815
    )

    override fun getTestData(): Single<List<String>> =
        Single.just(listOf("Fuck", "Fuck1", "FuckN")).map {
            db.collection("users").document("none")
                .set(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("AddedRecord", "DocumentSnapshot added with ID:")
                }
                .addOnFailureListener { e ->
                    Log.w("AddedRecord", "Error adding document", e)
                }
            it
        }
            .subscribeOn(schedulerIO)
            .observeOn(schedulerUI)

    override fun getTestDataFromNetwork(): Single<List<String>> =
        apiService.getTestDataFromNetwork()
            .map {
                appPrefs.putEmployees(it.data.toMutableList())
                it.data.map { it.employeeName }
            }
            .subscribeOn(schedulerIO)
            .observeOn(schedulerUI)

    override fun getTestDataFromDataStorage(): Single<List<String>> {
        val employees = appPrefs.employees
        return if (employees.isEmpty()) getTestDataFromNetwork() else Single.just(employees.map { it.employeeName })
    }
}