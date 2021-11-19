package com.free.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.free.models.Pacotes
import com.free.testeconstraint.R
import kotlinx.android.synthetic.main.item_pacote.view.*


class PacoteAdapter(private val context: Context, private val dataSource: List<Pacotes>): Adapter<PacoteAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image :ImageView
        val title :TextView
        val description :TextView
        val value :TextView

        init {
            // Define click listener for the ViewHolder's View.
            image = view.item_background
            title = view.item_title
            description = view.item_description
            value = view.item_value
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pacote, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val pac : Pacotes = dataSource.get(position)

        val resources = context.resources
        val identifier = resources.getIdentifier(pac.image, null, context.packageName)
        val drawable = resources.getDrawable(identifier)

        viewHolder.let {
            it.title.text = pac.title
            it.description.text = pac.description
            it.value.text = pac.value
            it.image.setImageDrawable(drawable)
        }
    }


    override fun getItemId(position: Int) = 0L



    override fun getItemCount() =  dataSource.size


}