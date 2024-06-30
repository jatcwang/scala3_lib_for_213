# Scala 3 library written to be used by Scala 2.13

This is an example repo of writing a Scala 3 library aiming to be useable also by Scala 2.

The basic setup in SBT is:

- Create your library module, set `scalaVersion` to a Scala 3 version
- Create a test module with `crossScalaVersions := Seq(scala2, scala3)` setup
    - Also add `scalacOptions ++= Seq("-Ytasty-reader")` to your test module when version is 2.13. (Don't worry you'll get a helpful error if you forgot)

After that, running `+test` in will run tests for both Scala 3 and 2.13 (both using the Scala 3 artifact)

## Caveat

Some unsupported Scala 3 features can be defined in the same scope as other which are used by 2.13
library and it won't lead to a compile error (as long as they aren't used by 2.13 directly).
Therefore, try to have all the tests using the user-facing APIs be run in both Scala versions.
