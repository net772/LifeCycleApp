package com.example.lifecycleapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.lifecycleapp.databinding.ActivityMainBinding.inflate
import com.example.lifecycleapp.databinding.FragmentABinding

class FragmentA : Fragment() {
    private val TAG get() = this::class.java.simpleName
    private val fragmentC = FragmentC()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("로그","$TAG - onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("로그","$TAG - onCreateView")
        val binding = FragmentABinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            addFragment(R.id.frameLayout, fragmentC)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("로그","$TAG - onViewCreated")
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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("로그","$TAG - onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("로그","$TAG - onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("로그","$TAG - onDetach")
    }

    fun addFragment(containerViewId:Int, mFragment: Fragment, addBackStack: Boolean = true) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(containerViewId, mFragment).apply {
            if(addBackStack) addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
    }

    fun replaceFragment(@IdRes containerId: Int, fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.commitAllowingStateLoss()
    }

    /* Remove Fragment (Fragment() 프레그먼트 생성한거) */
    fun removeFragment(mFragment: Fragment) {
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.remove(mFragment)
        manager.popBackStack()
        transaction.commitAllowingStateLoss()
    }

}