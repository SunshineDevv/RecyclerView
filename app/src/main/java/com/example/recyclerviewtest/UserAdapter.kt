package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.databinding.PersonItemLayoutBinding

class UserAdapter(private val userList: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserAdapter.PersonViewHolder>() {

    class PersonViewHolder(val binding: PersonItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.PersonViewHolder {
        val binding = PersonItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.PersonViewHolder, position: Int) {
        val userName = userList[position].name
        val userSurname = userList[position].surname
        holder.binding.tvName.text = userName
        holder.binding.tvSurname.text = userSurname
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}