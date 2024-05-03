package com.example.detail_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.common_utlis.Navigator
import com.example.detail_presentation.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint


class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        fun launchActivity(activity: Activity, bundle: Bundle?) {
            val intent = Intent(activity, DetailActivity::class.java)
            bundle?.let { intent.putExtras(it) }
            activity.startActivityForResult(intent, 100)
        }
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val bundle = intent.extras
        // Check if bundle is not null
        bundle?.let {
            // Retrieve data from the bundle
            val name = it.getString("name")
            val stateProvince = it.getString("stateProvince")
            val alphaTwoCode = it.getString("alphaTwoCode")
            val country = it.getString("country")
            val webPage = it.getString("webPage")

            // Use the retrieved data as needed
            // For example, display it in a TextView
            binding.tvUniversity.text = name
            binding.tvState.text = stateProvince
            binding.tvCountry.text = country
            binding.tvCountryCode.text = alphaTwoCode
            binding.tvWebPage.text = webPage

        }

        binding.ivRefresh.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.ivRefresh -> {
                setResult(RESULT_OK)
                finish()
            }
        }
    }


}

object GoToDetailActivity : Navigator {
    override fun navigate(activity: Activity, bundle: Bundle?) {
        DetailActivity.launchActivity(activity, bundle)
    }
}
