package com.example.androidutils


import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidutils.base.BaseActivity
import com.example.androidutils.databinding.ActivityCircleViewBinding

class CircleViewActivity : BaseActivity<ActivityCircleViewBinding>() {
    override fun initViewBinding(): ActivityCircleViewBinding {
        return ActivityCircleViewBinding.inflate(layoutInflater)
    }

    override fun initView() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_circle_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun initData() {

    }
}