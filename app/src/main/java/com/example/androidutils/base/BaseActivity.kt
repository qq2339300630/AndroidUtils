package com.example.androidutils.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    lateinit var mBinding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = initViewBinding()
        setContentView(mBinding.root)
        initView()
        initData()
    }

    abstract fun initViewBinding(): VB
    abstract fun initView()
    abstract fun initData()
}