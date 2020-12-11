package com.example.united

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.united.entities.TodosReal
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(),UnitedAdapter.CallbackInterface {
    lateinit var mViewModel : UnitedViewModel
    lateinit var adapter : UnitedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(UnitedViewModel::class.java)
        adapter = UnitedAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = recycler
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = adapter


        mViewModel.exposeLiveDataFromDatabase().observe(viewLifecycleOwner, Observer {
            Log.d("VIEW",it.toString())
            adapter.updateAdapter(it)
        })

      //  Glide.with(this).load()
      //  view.findViewById<Button>(R.id.button_first).setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}
    }

    override fun passTheData(todosReal: TodosReal) {
        val bundle = Bundle()
        bundle.putString("id",todosReal.name)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
    }
}