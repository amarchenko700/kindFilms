//package com.example.fragmentnotes.ui.recycler
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.View.OnLongClickListener
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.fragmentnotes.domain.NoteEntity
//import com.example.fragmentnotes.R
//
//class NoteViewHolder(
//    parent: ViewGroup?, clickListener: onItemClickListener,
//    contextClickListener: onItemContextClickListener
//) : RecyclerView.ViewHolder(
//    LayoutInflater.from(parent!!.context).inflate(R.layout.item_note, parent, false)
//) {
//    private val titleTextView = itemView.findViewById<TextView>(R.id.title_text_view)
//    private val detailTextView = itemView.findViewById<TextView>(R.id.detail_text_view)
//    private var note: NoteEntity? = null
//    fun bind(note: NoteEntity) {
//        this.note = note
//        titleTextView.setText(note.getTitle())
//        detailTextView.setText(note.getDescription())
//    }
//
//    init {
//        itemView.setOnClickListener { v: View? ->
//            clickListener.onItemClick(
//                note,
//                adapterPosition
//            )
//        }
//        itemView.setOnLongClickListener { v: View? ->
//            contextClickListener.onItemContextClick(
//                v,
//                note,
//                adapterPosition
//            )
//        }
//    }
//}