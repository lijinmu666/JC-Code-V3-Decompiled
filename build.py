#!/usr/bin/env python3
"""Build the preserved Smali source; requires Python 3 and JDK 17+."""
import hashlib
import os
from pathlib import Path
import shutil
import subprocess
import urllib.request
import zipfile

ROOT = Path(__file__).resolve().parent
WORK = ROOT / '.build'
SOURCES = {
    'smali-source.zip': '7c316ccf0506c9048c91bf385cdba53a80eac483502976cd3457d4905b859034',
    'resources-native.zip': '6a146bf1cadf806b0e23ffd65eab672cd278a386606c7718e8b30c206efd110f',
}
TOOL_SHA = '66cf4524a4a45a7f56567d08b2c9b6ec237bcdd78cee69fd4a59c8a0243aeafa'
TOOL_URL = 'https://github.com/iBotPeaches/Apktool/releases/download/v2.12.1/apktool_2.12.1.jar'

def verify(path, expected):
    if hashlib.sha256(path.read_bytes()).hexdigest() != expected:
        raise RuntimeError('SHA-256 mismatch: ' + str(path))

def main():
    if not shutil.which('java'):
        raise SystemExit('Install JDK 17+ and add java to PATH.')
    WORK.mkdir(exist_ok=True)
    tool = Path(os.environ.get('APKTOOL_JAR', str(WORK / 'apktool-2.12.1.jar')))
    if not tool.is_file():
        urllib.request.urlretrieve(TOOL_URL, tool)
    verify(tool, TOOL_SHA)
    decoded = ROOT / 'decoded'
    if not decoded.exists():
        stage = WORK / 'extract'
        shutil.rmtree(stage, ignore_errors=True)
        stage.mkdir()
        for name, sha in SOURCES.items():
            archive = ROOT / name
            verify(archive, sha)
            with zipfile.ZipFile(archive) as z:
                for item in z.infolist():
                    target = (stage / item.filename).resolve()
                    if not target.is_relative_to(stage.resolve()):
                        raise RuntimeError('Invalid archive path')
                z.extractall(stage)
        (stage / 'decoded').rename(decoded)
    out = ROOT / 'out'
    out.mkdir(exist_ok=True)
    subprocess.run(['java', '-jar', str(tool.resolve()), 'b', str(decoded), '-o',
                    str(out / 'JC-Code-V3-3.2.6-unsigned.apk')], check=True)
    print('Built:', out / 'JC-Code-V3-3.2.6-unsigned.apk')
    print('Unsigned APK. Original certificate verification remains unchanged.')

if __name__ == '__main__':
    main()
