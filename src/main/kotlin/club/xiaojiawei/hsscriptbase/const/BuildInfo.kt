package club.xiaojiawei.hsscriptbase.const

import club.xiaojiawei.hsscriptbase.config.log
import java.util.Properties

/**
 * @author 肖嘉威 xjw580@qq.com
 * @date 2024/9/24 9:53
 */
object BuildInfo {

    val VERSION: String

    val ARTIFACT_ID: String

    init {
        val properties = Properties()
        try {
            BuildInfo::class.java.classLoader.getResourceAsStream("build.info").use { resourceStream ->
                if (resourceStream == null) {
                    log.error { "build.info file is not found in the classpath." }
                } else {
                    properties.load(resourceStream)

                }
            }
        } catch (e: Exception) {
            log.warn(e) { "无法读取版本号" }
        }
        VERSION = properties.getProperty("version", "UNKNOWN")
        ARTIFACT_ID = properties.getProperty("artifactId", "UNKNOWN")
    }


}