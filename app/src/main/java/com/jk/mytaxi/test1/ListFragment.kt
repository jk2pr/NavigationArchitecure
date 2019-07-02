package com.jk.mytaxi.test1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jk.mytaxi.R
import com.jk.mytaxi.databinding.FragmentListBinding
import com.jk.mytaxi.test1.data.Item
import com.jk.mytaxi.test1.viewmodel.DataViewModel


class ListFragment : Fragment() {


    lateinit var binding: FragmentListBinding
   lateinit var dataViewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )
        return binding.root
    }



    private val changeObserver = Observer<Item> { value ->
        value?.let {
            binding.progressBar.visibility=View.GONE
            binding.recyclerView.visibility=View.VISIBLE
            dataViewModel.adapter.addItems(it.poiList)


        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataViewModel=ViewModelProviders.of(this).get(DataViewModel::class.java)
        binding.model = dataViewModel
        dataViewModel.liveData.observe(this, changeObserver)
        dataViewModel.getPoiList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        val b = DividerItemDecoration(
            view.context,
            DividerItemDecoration.VERTICAL
        )
        b.setDrawable(getDrawable(view.context, R.drawable.item_seprator)!!)
        binding.recyclerView.addItemDecoration(b)

    }


}
