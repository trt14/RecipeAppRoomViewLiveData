package com.example.recipeapproom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipeapproom.data.DataDatabase
import com.example.recipeapproom.data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class myViewModel(application: Application): AndroidViewModel(application) {
    private val repository: DataRepository
    private val recipes: LiveData<List<Recipe>>

    init {
        val ob= DataDatabase.getinstant(application).DataDao()
        repository = DataRepository(ob)
        recipes = repository.getRecipes
    }

    fun getRec(): LiveData<List<Recipe>>{
        return recipes
    }

    fun addRec(x1: String,x2:String,x3: String,x4:String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addRecipe(Recipe(0, x1,x2,x3,x4))
        }
    }

    fun editRec(ID: Int,x1: String,x2:String,x3: String,x4:String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateRecipe(Recipe(ID, x1,x2,x3,x4))
        }
    }

    fun deleteRec(noteID: Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteRecipe(Recipe(noteID,"","","",""))
        }
    }
}