package lazycoder21.droid.myapplication.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import lazycoder21.droid.myapplication.R
import lazycoder21.droid.myapplication.databinding.ActivityMainBinding
import lazycoder21.droid.myapplication.model.Images
import lazycoder21.droid.myapplication.presentation.adapter.ItemAdapter
import lazycoder21.droid.myapplication.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    private val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        loadData()
        initObserver()
    }

    private fun initView() {
        val lm = GridLayoutManager(this, 2).also {
            it.childCount
            it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if(position % 3 == 0) {
                        2
                    } else 1
                    //0,3,6,9
                }

            }
        }
        with(binding.recyclerView) {
            adapter = this@MainActivity.adapter
            layoutManager = lm
        }
    }

    private fun initObserver() {
        viewModel.items.observe(this){
            if(it != null) {
                adapter.addItems(
                    it.hits.map { Images(it.largeImageURL) }
                )
            } else {
                //error section
            }
        }
    }

    private fun loadData() {
        viewModel.getItems()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.items.removeObservers(this)
    }
}