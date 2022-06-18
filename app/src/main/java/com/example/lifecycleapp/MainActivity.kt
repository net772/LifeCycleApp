package com.example.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.lifecycleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private val fragmentA = FragmentA()
    private val fragmentB = FragmentB()

    private val TAG get() = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("로그","$TAG - onCreate")
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addFalse.setOnClickListener {
            Log.d("로그","============================  $TAG - addFragment - backStack - false ============================ ")
            addFragment(R.id.frameLayout, fragmentA)
        }

        binding.addTrue.setOnClickListener {
            Log.d("로그","============================   $TAG - addFragment - backStack - true  ============================ ")
            addFragment(R.id.frameLayout, fragmentA, true)
        }

        binding.btnReplace.setOnClickListener {
            Log.d("로그","========================================= $TAG - replace ========================================== ")
            replaceFragment(R.id.frameLayout, fragmentB)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("로그","$TAG - onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("로그","$TAG - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("로그","$TAG - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("로그","$TAG - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("로그","$TAG - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("로그","$TAG - onDestroy")
    }

    fun addFragment(containerViewId:Int, mFragment: Fragment, addBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerViewId, mFragment).apply {
            if(addBackStack) addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
    }

    fun replaceFragment(@IdRes containerId: Int, fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.commitAllowingStateLoss()
    }

    /* Remove Fragment (Fragment() 프레그먼트 생성한거) */
    fun removeFragment(mFragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.remove(mFragment)
        manager.popBackStack()
        transaction.commitAllowingStateLoss()
    }

}
