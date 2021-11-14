//package com.example.fragmentnotes.ui.recycler
//
//import android.os.Parcel
//import android.os.Parcelable
//import android.os.Parcelable.Creator
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import android.os.Parcelable
//import com.example.fragmentnotes.ui.NoteListFragment
//import java.util.ArrayList
//
//class NotesAdapter : RecyclerView.Adapter<NoteViewHolder>, Parcelable {
//    private var data: List<NoteEntity> = ArrayList<NoteEntity>()
//    private var clickListener: onItemClickListener? = null
//    private var contextClickListener: onItemContextClickListener? = null
//
//    constructor() {}
//    constructor(`in`: Parcel) {
//        data = `in`.createTypedArrayList<NoteEntity>(NoteEntity.CREATOR)!!
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
//        return NoteViewHolder(parent, clickListener, contextClickListener)
//    }
//
//    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    private fun getItem(position: Int): NoteEntity {
//        return data[position]
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//
//    fun setData(data: List<NoteEntity>) {
//        this.data = data
//        notifyDataSetChanged()
//    }
//
//    fun setOnItemClickListener(listener: onItemClickListener?) {
//        clickListener = listener
//    }
//
//    fun setOnItemContextClickListener(contextListener: onItemContextClickListener?) {
//        contextClickListener = contextListener
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeTypedList(data)
//    }
//
//    interface onItemClickListener {
//        fun onItemClick(item: NoteEntity?, position: Int)
//    }
//
//    interface onItemContextClickListener {
//        fun onItemContextClick(v: View?, item: NoteEntity?, position: Int): Boolean
//    }
//
//    companion object {
//        val CREATOR: Creator<NotesAdapter> = object : Creator<NotesAdapter?> {
//            override fun createFromParcel(`in`: Parcel): NotesAdapter? {
//                return NotesAdapter(`in`)
//            }
//
//            override fun newArray(size: Int): Array<NotesAdapter?> {
//                return arrayOfNulls(size)
//            }
//        }
//    }
//}