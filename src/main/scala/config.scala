package org.codeswarm.tpocs

import com.typesafe.{config => ts}
import ts.{ConfigValue, ConfigValueFactory}

package object config {

  val Config = ts.Config
  type Config = ts.Config

  def configValue(x: Any): ConfigValue = ConfigValueFactory.fromAnyRef(x)

  implicit class RichConfig(config: Config) {

    def :+(kv: (String, String)): Config = kv match { case (k, v) =>
      config.withValue(k, configValue(v))
    }

    def :+(kv: (String, Int)): Config = kv match { case (k, v) =>
      config.withValue(k, configValue(v))
    }

  }

}
