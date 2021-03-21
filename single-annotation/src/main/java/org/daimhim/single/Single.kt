package org.daimhim.single

/**
 *  author : Zhangx
 *  date : 2021/3/10 11:47
 *  description :
 *  alias 别名
 *  mode 生成那种单例
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class Single(val alias:String="",val mode : SingleMode = SingleMode.HUNGRY)


public enum class SingleMode{
    HUNGRY,
    LAZY
}