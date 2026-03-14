package com.example.demo

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * SeekBar 演示 Activity
 * 展示如何在 Android 中使用滑块组件
 */
class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    private lateinit var textView: TextView
    private lateinit var textViewValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化组件
        seekBar = findViewById(R.id.seekBar)
        textView = findViewById(R.id.textView)
        textViewValue = findViewById(R.id.textViewValue)

        // 设置 SeekBar 的最大值为 100
        seekBar.max = 100

        // 设置初始值显示
        val progress = seekBar.progress
        textViewValue.text = "当前值: $progress"

        // 设置 SeekBar 的进度改变监听器
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // 当进度改变时调用
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewValue.text = "当前值: $progress"
            }

            // 当用户开始拖动滑块时调用
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                textView.text = "正在拖动..."
            }

            // 当用户停止拖动滑块时调用
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                textView.text = "拖动结束"
            }
        })
    }
}
