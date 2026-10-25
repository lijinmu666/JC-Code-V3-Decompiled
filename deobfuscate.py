#!/usr/bin/env python3
"""Generate a separate Java reading tree; original Smali remains build input."""
from pathlib import Path
import hashlib
import json
import os
import shutil
import subprocess
import urllib.request
import zipfile

ROOT = Path(__file__).resolve().parent
def main():
    work = ROOT / '.build'
    work.mkdir(exist_ok=True)
    archive = work / 'jadx-1.5.3.zip'
    if not archive.exists():
        urllib.request.urlretrieve('https://github.com/skylot/jadx/releases/download/v1.5.3/jadx-1.5.3.zip', archive)
    if hashlib.sha256(archive.read_bytes()).hexdigest() != '8280f3799c0273fe797a2bcd90258c943e451fd195f13d05400de5e6451d15ec':
        raise RuntimeError('JADX checksum mismatch')
    tool = work / 'jadx-1.5.3'
    if not (tool / 'bin/jadx').exists():
        with zipfile.ZipFile(archive) as z:
            z.extractall(tool)
    executable = tool / 'bin/jadx'
    executable.chmod(0o755)
    subprocess.run(['python3', str(ROOT / 'build.py')], check=True)
    output = ROOT / 'readable'
    shutil.rmtree(output, ignore_errors=True)
    output.mkdir()
    command = [str(executable), '--deobf', '--deobf-min', '8',
               '--deobf-cfg-file', str(output / 'automatic.jobf'),
               '--deobf-cfg-file-mode', 'overwrite',
               '--mappings-path', str(ROOT / 'deobfuscation.tiny'),
               '--no-res', '--show-bad-code', '--comments-level', 'info',
               '-d', str(output), str(ROOT / 'out/JC-Code-V3-3.2.6-unsigned.apk')]
    with (output / 'jadx.log').open('w') as log:
        result = subprocess.run(command, stdout=log, stderr=subprocess.STDOUT)
    sources = list((output / 'sources').rglob('*.java'))
    if not sources:
        raise RuntimeError('JADX produced no sources; inspect readable/jadx.log')
    expected = ['LocalAdbBridge.java', 'AdbConnectionManager.java', 'CloudGateClient.java']
    names = {p.name for p in sources}
    if not set(expected) <= names:
        raise RuntimeError('Semantic class mappings were not applied')
    cloud = next(p for p in sources if p.name == 'CloudGateClient.java').read_text()
    if 'verifyStatusResponse' not in cloud or 'computeHmacSha256' not in cloud:
        raise RuntimeError('Semantic method mappings were not applied')
    report = {'java_files': len(sources), 'jadx_exit_code': result.returncode,
              'semantic_classes_verified': expected,
              'warning': 'Reading reference only. Inspect jadx.log for methods that failed decompilation. Original names and C/C++ source are not recovered.'}
    (output / 'report.json').write_text(json.dumps(report, indent=2) + '\n')
    shutil.copy2(ROOT / 'deobfuscation.tiny', output / 'semantic.tiny')
    print(json.dumps(report, indent=2))

if __name__ == '__main__':
    main()
