package com.afkoders.uptechackathon.data.prefs

import android.content.Context
import com.afkoders.uptechackathon.data.models.EmployeeModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AppPrefs constructor(
    context: Context,
    private val gson: Gson
) {

    private val prefs = context.getSharedPreferences(EMPLOYEES_PREFS, Context.MODE_PRIVATE)

    fun addToEmployees(track: EmployeeModel) {
        val newList = employees
        newList.add(track)
        employees = newList
    }

    fun putEmployees(list: MutableList<EmployeeModel>) {
        employees = list
    }

    var employees: MutableList<EmployeeModel>
        set(value) = prefs.edit().putString(EMPLOYEES_LIST, gson.toJson(value)).apply()
        get() = gson.fromJson(
            prefs.getString(EMPLOYEES_LIST, ""),
            object : TypeToken<List<EmployeeModel>>() {}.type
        ) ?: mutableListOf()

    companion object {
        const val EMPLOYEES_LIST = "EMPLOYEES_LIST"
        const val EMPLOYEES_PREFS = "EMPLOYEES_PREFS"
    }

    /* private val dataStore: DataStore<Preferences> =
         context.createDataStore(name = "employee")

     private object EmployeePreferencesKeys {
         val EMPLOYEES_LIST = preferencesKey<String>("EMPLOYEES_LIST")
     }

     val getEmployeesList: Flow<List<EmployeeModel>> = dataStore.data
         .catch { exception ->
             // dataStore.data throws an IOException when an error is encountered when reading data
             if (exception is IOException) {
                 emit(emptyPreferences())
             } else {
                 throw exception
             }
         }
         .map { preferences ->
             // Get our show completed value, defaulting to false if not set:
             val showCompleted = preferences[EmployeePreferencesKeys.EMPLOYEES_LIST] ?: ""
             gson.fromJson(
                 showCompleted,
                 object : TypeToken<List<EmployeeModel>>() {}.type
             ) ?: mutableListOf<EmployeeModel>()
         }.

     fun updateEmployeesList(employeesList: MutableList<EmployeeModel>) {
         scope.launch {
             val serializedList = gson.toJson(employeesList)
             dataStore.edit { preferences ->
                 preferences[EMPLOYEES_LIST] = serializedList
             }
         }
     } */
}