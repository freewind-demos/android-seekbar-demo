# android-seekbar-demo

## 简介

演示 SeekBar 滑块组件的使用，允许用户拖动选择数值。

## 基本原理

- SeekBar 是可拖动的滑块组件
- 类似于进度条，但用户可以手动拖动
- 通过 `OnSeekBarChangeListener` 监听进度变化

## 启动和使用

### 环境要求
- Android Studio 4.0+
- JDK 11+

### 安装和运行
1. 用 Android Studio 打开此项目
2. 拖动滑块观察数值变化
3. 观察状态提示的更新

## 教程

### SeekBar 基础

```xml
<SeekBar
    android:id="@+id/seekBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="0" />
```

### 监听进度变化

```kotlin
val seekBar = findViewById<SeekBar>(R.id.seekBar)

seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
    // 进度改变时调用
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        textView.text = "当前值: $progress"
    }

    // 开始拖动时调用
    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        // 开始拖动
    }

    // 结束拖动时调用
    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        // 结束拖动
    }
})
```

### fromUser 参数

`onProgressChanged` 中的 `fromUser` 参数表示：
- true: 用户手动拖动导致的进度变化
- false: 代码设置导致的进度变化

### 注意事项

- 可以设置 `android:progressTint` 改变进度条颜色
- 使用 `max` 设置可选择的最大值
- 记得在 Activity 销毁时清理资源
