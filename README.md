# tpocs

Looking at the example usage of [scopt], it seems to me that the
help text it outputs is far more intelligible than the source code
that generated it. This is an exploration of the idea: Could you
just write the usage text, and generate an argument parser from that?
In this way, this project sort of seeks to accomplish the inverse of
part of what scopt does (hence, "tpocs" is "scopt" backwards).

Since the usage text doesn't really encode type information or value
validation, I can't do that - but I don't think I want to.
Option parsers become difficult to use when they try to do too many things.
Instead, the idea is for this library to always produce a [Config] object.

[scopt]: https://github.com/scopt/scopt
[Config]: https://github.com/typesafehub/config
