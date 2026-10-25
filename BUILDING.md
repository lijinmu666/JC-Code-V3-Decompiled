# JC Code V3 3.2.6 rebuild

This is a complete **Smali rebuild project**, not a recovered Java/Gradle project.
The original JADX Java output remains a reading reference, not the build input.

## Build

Install Python 3.9+ and JDK 17+. From the repository root run:

```sh
python3 build.py
```

On Windows use `py -3 build.py`. The first build downloads checksum-pinned
Apktool 2.12.1, extracts the two source archives into `decoded/`, and compiles
both Smali trees and Android resources. Subsequent builds use the editable
`decoded/` directory. Delete that directory only to restore the archived source.
`APKTOOL_JAR` can select an existing copy of the same pinned Apktool JAR.

Output: `out/JC-Code-V3-3.2.6-unsigned.apk`.

## Source layout

- `smali-source.zip`: all classes from both DEX files, with original obfuscated names.
- `resources-native.zip`: decoded manifest/resources, assets, original native
  libraries, Apktool metadata, and original archive metadata.
- `JC-Code-V3-3.2.6-decompiled.zip`: previous JADX Java reading reference.

No business logic, obfuscated names, cloud gate, certificate fingerprint,
HMAC validation, anti-hook checks, or native library logic has been changed.
The Smali route avoids inventing missing Java control flow.

## Signing and execution

Build success does not imply runtime acceptance. The output is deliberately
unsigned. The original app checks its signing certificate; signing with a new
key can cause it to reject itself. This project does not bypass or alter that
check. Reusing original META-INF files does not reproduce a valid signature.
The original developer private signing key is not included or available.

The native libraries remain compiled binaries, as in the uploaded APK; their
original C/C++ source was not recovered. No device runtime test was performed.
