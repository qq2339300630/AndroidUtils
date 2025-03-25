package com.example.androidutils

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidutils.adapter.TypeAdapter
import com.example.androidutils.base.BaseActivity
import com.example.androidutils.databinding.ActivityMainBinding
import com.example.androidutils.model.Type

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        enableEdgeToEdge()
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mBinding.recycleView.layoutManager = LinearLayoutManager(this)
        val typeList = ArrayList<Type>()
        typeList.add(Type("CircleView", 0))
        val adapter = TypeAdapter()
        mBinding.recycleView.adapter = adapter
        adapter.addAll(typeList)
        adapter.setOnItemClickListener { _, _, position ->
            when (position) {
                0 -> {
                    startActivity(Intent(this, CircleViewActivity::class.java))
                }
            }
        }
    }

    override fun initData() {

    }
}