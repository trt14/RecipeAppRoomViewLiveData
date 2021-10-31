package com.example.recipeapproom.data


import androidx.lifecycle.LiveData
import com.example.recipeapproom.data.Recipe
import com.example.recipeapproom.data.RecipeDao

class DataRepository(private val recDao: RecipeDao) {

    val getRecipes: LiveData<List<Recipe>> = recDao.getAllUserInfo()

    suspend fun addRecipe(rec: Recipe){
        recDao.insertrecipe(rec)
    }

    suspend fun updateRecipe(rec: Recipe){
        recDao.updaterecipe(rec)
    }

    suspend fun deleteRecipe(rec: Recipe){
        recDao.deleterecipe(rec)
    }

}