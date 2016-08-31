学习阿里巴巴Android 加速构建框架Freeline


Freeline是一个为实现Android应用快速构建和部署的工具。通过缓存可重用的class文件和资源索引，这个工具能够加速构建Android应用，优化部署更新到设备通过热交换。

这个工具由蚂蚁金服Android团队开发，Freeline在日常开发中很有效的节省了时间。受到Buck和Instant Run的启发，但是要比它们两个更快，Freeline可以完成在秒级内构建项目。在项目没有改变之前不需要一遍一遍的再编译、再安装，Freeline为Android带来了更好的开发体验。

## Freeline原理

Freeline在运行时将构建任务拆分成了几个小的任务。Freeline充分使用编译缓存文件去实现真正的加速构建，使用一些Buck的组件比如dx、DexMerger去加速构建任务。Freeline在设备上的子进程运行一个socket服务器，在开发者机器上通过构建工具进行沟通，这样是为了实现尽管主进程挂了，但部署不会受到影响。

Freeline使用拆分dex的方案实现加速dex热交换。一个深度优化过的aapt工具（FreelineAapt）实现生成增加的资源包，这个aapt工具要比原生的aapt工具快很多倍，并且增加的资源包小于1kb。来自Instant Run的MonkeyPatcher实现资源的热替换。

Freeline能够自动切换全部构建与增量构建。

Freeline同样也为热修复打下很好的基础。提交Freeline的增量输出，这个可以被打包进一个通常小于100kb的zip文件，这样对奔溃修复和其他问题产生影响并且能够动态替换资源。通过分析大量的案例表明会对99%的用户产生影响。说明一下OTA补丁分发系统不在这个项目的讨论范围内。


## 特性

- 加速构建使用多个module的Gradle Android项目
- 当前任务加速构建项目
- 主进程奔溃仍可热部署
- 构建增量dex和资源包
- 提供resource.arsc的缓存支持
- 可以运行于Windows, Linux and Mac

Freeline对不同文件类型的更改的支持情况：

![](http://ob35pbpax.bkt.clouddn.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202016-08-31%20%E4%B8%8B%E5%8D%883.23.17.png?e=1472631848&token=b_hRB7WBnNMHUhLIZNEP-DlJC_-17UnRgWlnj5VG:NPjD2R657c_RLoVsqbWjazpYPCk)

Freeline已经在API为17, 19, 22, 23的Android模拟器进行了测试，还有一台运行有Android M的Nexus 6p和运行Android Kitkat的锤子手机。如果你的Android设备版本为Android L或者更高的版本，增量资源补丁加载速度会更快。

## 添加依赖

1、在项目目录下
```gradle
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        /**
         * 第一步
         */
        classpath 'com.antfortune.freeline:gradle:0.5.4'
    }
}
```

2、在app/build.gradle中添加如下代码：
```gradle
/**
 * 第二步
 */
apply plugin: 'com.antfortune.freeline'
```

```gradle
/**
 * 第二步
 */
freeline {
    hack true
}
```

```gradle
/**
 * 第二步
 */
compile 'com.antfortune.freeline:runtime:0.5.4'
```

3、在app/src/java/XApplication.java中初始化

```gradle
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 第三步
         */
        FreelineCore.init(this);
    }
}
```
对于一个复杂的Android项目结构，可以使用freeline的的DSL自定义构建进程。

## 安装

1、Windows

```java
gradlew.bat initFreeline
```
2、Linux/Mac

```java
./gradlew initFreeline
```

下载freeline依赖有问题可以使用：

```java
gradle initFreeline -Pmirror
```

## 更新

在build.gradle文件中更新了freeline依赖，使用以下代码下载最新的freeline依赖

1、Windows

```java
gradlew.bat initFreeline
```
2、Linux/Mac

```java
./gradlew initFreeline
```

## 限制

- 第一次同步增量资源包到设备会有一些小慢
- 目前还不支持注解，比如ButterKnife、Dagger2等
- 移除res/values目前还不支持，因为这样会造成aapt异常


## [项目地址](https://github.com/alibaba/freeline)

## 参考文献

- [阿里Android平台上的秒级编译方案](http://www.yidianzixun.com/n/0EIMcX9W?s=9&appid=yidian&ver=3.6.8&utk=04lh3114)


