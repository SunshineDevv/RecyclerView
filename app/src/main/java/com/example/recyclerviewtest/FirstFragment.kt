package com.example.recyclerviewtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.recyclerviewtest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null

    private lateinit var userList: ArrayList<UserModel>

    private lateinit var adapter:UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        initial()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.addBtn?.setOnClickListener {
            addNewPerson()
        }
        binding?.nextFrgBtn?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun initial(){
        userList = ArrayList()
        adapter = UserAdapter(userList)
        binding?.rvFrg1?.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addNewPerson() {
        val name = binding?.editName?.text.toString()
        val surname = binding?.editSurname?.text.toString()
        userList.add(UserModel("Name: $name", "Surname: $surname"))
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}