package com.free.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.free.models.Pacotes
import com.free.testeconstraint.R


class PacoteAdapter(private val context: Context,
                    private val dataSource: List<Pacotes>): BaseAdapter() {




    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.item_pacote, parent, false)

        val pac : Pacotes = dataSource.get(position)
        val image = rowView.findViewById<ImageView>(R.id.item_background)
        val title = rowView.findViewById<TextView>(R.id.item_title)
        val description = rowView.findViewById<TextView>(R.id.item_description)
        val value = rowView.findViewById<TextView>(R.id.item_value)
        title.text = pac.title
        description.text = pac.description
        value.text = pac.value

        val resources = context.resources
        val identifier = resources.getIdentifier(pac.image, null, context.packageName)
        val drawable = resources.getDrawable(identifier)
        image.setImageDrawable(drawable)
        return rowView
    }
}