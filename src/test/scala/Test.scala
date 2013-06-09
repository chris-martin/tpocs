package org.codeswarm.tpocs

import config._
import org.scalatest._

class Test extends FeatureSpec {

  feature ("") {

    scenario("") {

/*
      import java.io.File
      case class Config(
        foo: Int = -1,
        out: File = new File("."),
        xyz: Boolean = false,
        libName: String = "",
        maxCount: Int = -1,
        verbose: Boolean = false,
        mode: String = "",
        files: Seq[File] = Seq()
      )
*/



      val parser = new scopt.OptionParser[Config]("scopt") {
        head("scopt", "3.x")
        opt[Int]('f', "foo") action { (x, c) =>
          ((c:RichConfig) :+ ("foo" -> x)):Config } text("foo is an integer property")
        opt[String]('o', "out") required() valueName("<file>") action { (x, c) =>
          c.withValue("foo", configValue(x)) } text("out is a required file property")
        opt[(String, Int)]("max") action { case ((k, v), c) =>
          c.withValue("lib name", configValue(k)).withValue("max count", configValue(v))
        } keyValueName("<libname>", "<max>") text("maximum count for <libname>")
        opt[Unit]("verbose") action { (_, c) =>
          c.withValue("verbose", configValue(true)) } text("verbose is a flag")
        note("\nsome notes.\n")
        help("help") text("prints this usage text")
        arg[String]("<file>...") unbounded() optional() action { (x, c) =>
          c.withValue("files", configValue(c.getList("files").unwrapped :+ x))
        } text("optional unbounded args")
        cmd("update") action { (_, c) =>
          c.copy(mode = "update") } text("update is a command.") children {
          opt[Boolean]("xyz") action { (x, c) =>
            c.copy(xyz = x) } text("xyz is a boolean property")
        }
      }
      // parser.parse returns Option[C]
      parser.parse(args, Config()) map { config =>
        // do stuff
      } getOrElse {
        // arguments are bad, usage message will have been displayed
      }

      val input = """
        |scopt 3.x
        |Usage: scopt [update] [options] [<file>...]
        |
        |  -f <value> | --foo <value>
        |        foo is an integer property
        |  -o <file> | --out <file>
        |        out is a required file property
        |  --max:<libname>=<max>
        |        maximum count for <libname>
        |  --verbose
        |        verbose is a flag
        |
        |some notes.
        |
        |  --help
        |        prints this usage text
        |  <file>...
        |        optional unbounded args
        |
        |Command: update
        |update is a command.
        |
        |  --xyz <value>
        |        xyz is a boolean property
        |
      """.stripMargin



    }

  }

}
