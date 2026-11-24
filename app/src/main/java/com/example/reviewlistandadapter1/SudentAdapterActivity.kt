package com.example.reviewlistandadapter1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class StudentAdapterViewAdapter(context: Context, private val students: List<Student>): ArrayAdapter<Student>(context, 0, students) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        var holder: ViewHolder
        if (itemView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.item_view_student, parent, false)
            holder = ViewHolder(itemView)
            itemView.tag = holder
        } else {
            holder = itemView.tag as ViewHolder
        }

        val currentStudent = getItem(position) ?: return itemView!!

        holder.imageView.setImageResource(currentStudent.image)
        holder.textViewName.text = currentStudent.name
        holder.textViewClass.text = currentStudent.stdClass

        return itemView
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.studentImage)
        val textViewName: TextView = view.findViewById(R.id.studentName)
        val textViewClass: TextView = view.findViewById(R.id.studentClass)
    }
}
