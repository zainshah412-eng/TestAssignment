package com.example.listing_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.common_utlis.Activities
import com.example.common_utlis.Navigator
import com.example.common_utlis.toast
import com.example.listing_domain.model.University
import com.example.listing_presentation.databinding.ActivityListingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class ListingActivity : AppCompatActivity(), OnItemClickListener {
    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, ListingActivity::class.java)
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var provider: Navigator.Provider

    private lateinit var binding: ActivityListingBinding
    private val listingViewModel: ListingViewModel by viewModels()
    private val adapter = ListingAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        setObservers()
    }

    private fun initView() {
        binding.rvUniversity.adapter = adapter
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            listingViewModel.listing.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@ListingActivity, it.error, Toast.LENGTH_LONG).show()
                    Log.wtf("Error", it.error)
                }
                it.data?.let {
                    if(it.isEmpty()){
                        toast("No Record Found")
                    }
                    binding.progressBar.visibility = View.GONE
                    adapter.setData(it)
                }
            }
        }

    }

    override fun onItemClicked(item: University) {
        //  Passing a bundle
        val bundle = Bundle().apply {
            putString("name", item.name)
            putString("stateProvince", item.stateProvince)
            putString("alphaTwoCode", item.alphaTwoCode)
            putString("country", item.country)
            putString("webPage", item.webPages)

        }
        provider.getActivities(Activities.DetailActivity).navigate(this, bundle)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            listingViewModel.getListing()
        }
    }
}

object GoToListingActivity : Navigator {
    override fun navigate(activity: Activity, bundle: Bundle?) {
        ListingActivity.launchActivity(activity)
    }
}
