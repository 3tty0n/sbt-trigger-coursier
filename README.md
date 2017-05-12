# sbt-trigger-coursier

[![CircleCI](https://circleci.com/gh/3tty0n/sbt-trigger-coursier/tree/master.svg?style=svg)](https://circleci.com/gh/3tty0n/sbt-trigger-coursier/tree/master)

This can enable and disable sbt-cousier plugin in sbt shell.

## Usage

If you want to enable `coursier` in sbt shell, execute below.

```shell
$ sbt enableCoursier
```

Then, `project/coursier.sbt` is generated.

If you want to enable in sbt shell, execute as below and you should `reload`.

```
> enableCoursier
> reload
```

The contents of `project/coursier.sbt` is as below.

```
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC2")
```

If you want to disable `coursier`, execute below and never forget to `reload` if you disable in sbt shell.

```$xslt
$ sbt disableCoursier
```