package org.daimhim.single

import com.google.auto.service.AutoService
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.*
import javax.lang.model.util.Elements

@SupportedAnnotationTypes("org.daimhim.single.Single")
@AutoService(Processor::class)
class SingleProcessor : AbstractProcessor() {
    /**
     * 元素相关
     */
    private lateinit var elementUtils: Elements
    override fun getSupportedOptions(): MutableSet<String> {
        return super.getSupportedOptions()
    }

    /**
     * 必须重写
     */
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        val mutableSetOf = mutableSetOf<String>()
        mutableSetOf.add(Single::class.java.canonicalName)
        return mutableSetOf //将要支持的注解放入其中
    }

    /**
     * 必须重写
     */
    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported() // 表示支持最新的Java版本
    }

    override fun init(p0: ProcessingEnvironment?) {
        super.init(p0)
        p0?.filer //文件管理工具类，在后面生成java文件时会用到
        p0?.typeUtils //类型处理工具类，本例不会用到
        elementUtils = p0?.elementUtils!! //Element处理工具类,后面获取包名时会用到
        Log.initLog(p0?.messager!!)
    }

    /**
     * set 参数是要处理的注解的类型集合
     * roundEnv表示运行环境，可以通过这个参数获得被注解标注的代码块
     */
    override fun process(p0: MutableSet<out TypeElement>, p1: RoundEnvironment): Boolean {
        if (p0.isEmpty()){
            return false
        }
        val elementsAnnotatedWith = p1.getElementsAnnotatedWith(Single::class.java)
//        println("222 process ${p1?.rootElements?.size}")
        Log.o("-----------------------------------")
//        elementsAnnotatedWith.
        p0.forEach { teIt->
            Log.n(teIt.qualifiedName.toString())
            Log.n(elementUtils.getBinaryName(teIt).toString())
            teIt.getAnnotation(Single::class.java).alias
            elementUtils
        }
        Log.o("-----------------------------------")
        return false
    }


}