package com.example.app_fitnesstracker.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


open class BaseFragment<V : ViewBinding>(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    protected val binding: V
        get() = _binding!!

    private var _binding: V? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
            ?.also { _binding = provideViewBinding(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Suppress("UNCHECKED_CAST")
    protected open fun provideViewBinding(view: View): V {
        val bindingType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val bindingClass = bindingType as Class<V>
        val method = bindingClass.getMethod("bind", View::class.java)
        return method.invoke(null, view) as V
    }
//    var isOpened = false
//
//    open fun setListenerToRootView() {
//        val activityRootView: View =
//            netscape.javascript.JSObject.getWindow().getDecorView().findViewById(
//                R.id.content
//            )
//        activityRootView.viewTreeObserver.addOnGlobalLayoutListener {
//            val heightDiff = activityRootView.rootView.height - activityRootView.height
//            if (heightDiff > 100) { // 99% of the time the height diff will be due to a keyboard.
//                Toast.makeText(
//                    ApplicationProvider.getApplicationContext<Context>(),
//                    "Gotcha!!! softKeyboardup",
//                    0
//                ).show()
//                if (isOpened == false) {
//                    //Do two things, make the view top visible and the editText smaller
//                }
//                isOpened = true
//            } else if (isOpened == true) {
//                Toast.makeText(
//                    ApplicationProvider.getApplicationContext<Context>(),
//                    "softkeyborad Down!!!",
//                    0
//                ).show()
//                isOpened = false
//            }
//        }
//    }
//    TODO: Появление клавиатуры(нужно фиксить)
//    var isOpened = false
//    fun setListenerToRootView() {
//        val activityRootView: View = getWindow().getDecorView().findViewById(R.id.content)
//        activityRootView.getViewTreeObserver()
//            .addOnGlobalLayoutListener(object : onGlobalLayoutListener() {
//                fun onGlobalLayout() {
//                    val heightDiff: Int =
//                        activityRootView.getRootView().getHeight() - activityRootView.getHeight()
//                    if (heightDiff > 100) { //99% of the time the height diff will be due to a keyboard
//                        Toast.makeText(getApplicationContext(), "Gotha!!! softKeyboardup", 0).show()
//                        if (isOpened == false) {
//                            //Do two things, make the view top visible and the editText smaller
//                        }
//                        isOpened = true
//                    } else if (isOpened == true) {
//                        Toast.makeText(getApplicationContext(), "softkeyboard Down!!!", 0).show()
//                        isOpened = false
//                    }
//                }
//            })
//    }
}