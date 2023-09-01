package com.example.viewmodeltest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {
    private var users : List<User> = ArrayList()


    class UserHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name :TextView = itemView.findViewById(R.id.userName_tv)
        val description : TextView = itemView.findViewById(R.id.userDescr_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val userView = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserHolder(userView)
    }

    override fun getItemCount(): Int {
        return  users.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val itemUser = users[position]
        holder.name.text = itemUser.name
        holder.description.text = itemUser.description
    }
    fun reftreshUsers(users : List<User>){
        this.users = users
        notifyDataSetChanged()
    }
}