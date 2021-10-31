package com.example.recipeapproom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapproom.data.*
import com.example.recipeapproom.data.Recipe
import kotlinx.android.synthetic.main.item.view.*

class RecycleView(val activity: MainPage) : RecyclerView.Adapter<RecycleView.recyclerViewHolder>() {
    private var recipes = emptyList<Recipe>()

    class recyclerViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyclerViewHolder {
        return recyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: recyclerViewHolder, position: Int) {
        val recipe = recipes[position]

        holder.itemView.apply {

            tvtxt.text = "${recipe.title}\n${recipe.author}\n${recipe.ingredents}\n${recipe.instruction}\n"

            ibEditNote.setOnClickListener {
                activity.UpdateRec(recipe)
            }
            ibDeleteNote.setOnClickListener {
                activity.confirm(recipe)
            }
        }}


    override fun getItemCount()=recipes.size
    fun update(recipes: List<Recipe>){
        println("UPDATING DATA")
        this.recipes = recipes
        notifyDataSetChanged()
    }
}

