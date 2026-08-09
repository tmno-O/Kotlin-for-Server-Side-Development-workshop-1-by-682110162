# AI Log — Workshop 1

Session with Claude Code. Course rules in `AGENTS.md`, session 1 = TUTOR MODE
(no solution code from AI, hints only).

## 1. Build command in VS Code

**Asked:** command to build project in VS Code.

**AI told:** Gradle project, use integrated terminal:
```bash
./gradlew build
./gradlew run
./gradlew build -x test
```

## 2. Gradle build failure — garbled error `26`

**Asked:** explain error, `BUILD FAILED`, `What went wrong: 26`.

**AI told:** default JVM was JDK 26, too new for Gradle 8.13 (daemon
incompatible), error message got corrupted as a side effect. Fix: point
Gradle at JDK 21 via `org.gradle.java.home` in `gradle.properties`.

**Where AI was wrong / iteration needed:** first fix attempt suggested
`export JAVA_HOME=$(/usr/libexec/java_home -v 21)` — didn't work because
Homebrew's `openjdk@21` is keg-only and not registered with
`/usr/libexec/java_home`. Had to find the actual Homebrew Cellar path
directly and hardcode it in `gradle.properties` instead of relying on
`java_home`.

## 3. Compile error — `Unresolved reference 'celsiusToFahrenheit'`

**Asked:** explain error after JDK fix.

**AI told:** function referenced in `WorkshopTest.kt` didn't exist yet in
`Workshop1.kt` — exercise placeholder (`🚨`) not filled in. Declined to
write the function (tutor mode), gave hint template with blanks instead.

**My mistake caught by AI:** first attempt pasted the hint template
literally, including the `___` placeholders, instead of replacing them.
AI caught it, explained the two bugs (invalid `___` token, and body using
`celsius` while the param was still named `___`), asked me to fix and
resubmit.

## 4. Same unresolved-reference error persisted after fixing the function

**Asked:** why still failing after function was correctly written.

**AI told:** real cause was a package mismatch — `Workshop1.kt` declared
`package org.example`, but `WorkshopTest.kt` had no package/import, so the
test couldn't see the function across packages. Gave two options (add
import, or drop the package declaration); I chose dropping `package
org.example` from both `Workshop1.kt` and `Workshop2.kt`.

## 5. Implemented Workshop 1 (unit converter)

Wrote (with hints from AI, not AI-authored per tutor mode):
- `when` block in `main()` routing menu choice to
  `convertCelsiusToFahrenheit()` / `convertKilometersToMiles()` / exit
- `kilometersToMiles` pure conversion function
- Null-safe input parsing in both `convert*` functions using
  `toDoubleOrNull() ?: run { println(...); return }`

AI reviewed the code, confirmed correctness, suggested an optional
simplification (`?: return println(...)` instead of `?: run {...}`), and
explained the code line-by-line on request (pure calc functions vs I/O
wrapper functions, `when` exhaustiveness, Elvis operator early-return
semantics).

## 6. Git workflow

**Asked:** commands for branch / commit / push (commands only, AI did not
execute).

**AI gave:**
```bash
git checkout -b Workshop-1
git status
git add src/main/kotlin/Workshop1.kt src/main/kotlin/Workshop2.kt gradle.properties
git commit -m "feat: implement workshop 1 unit converter"
git push -u origin Workshop-1
```
