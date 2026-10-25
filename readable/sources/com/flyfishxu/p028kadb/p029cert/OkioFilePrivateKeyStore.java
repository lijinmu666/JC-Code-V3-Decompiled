package com.flyfishxu.p028kadb.p029cert;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1128UInt;
import p094kotlin.C1133Unit;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p110random.AbstractC1241Random;
import p094kotlin.p117text.UStringsKt;
import p132okio.BufferedSink;
import p132okio.BufferedSource;
import p132okio.C5053Okio;
import p132okio.C5055Path;
import p132okio.FileSystem;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/OkioFilePrivateKeyStore;", "Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", "privateKeyPath", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "<init>", "(Lokio/Path;Lokio/FileSystem;)V", "readPrivateKeyPem", BuildConfig.f24315FLAVOR, "writePrivateKeyPemAtomic", BuildConfig.f24315FLAVOR, "privateKeyPem", "clear", "readOrNull", "path", "writeAtomic", "payload", "deleteIfExists", "stageWrite", "commitStagedWrite", "tempPath", "cleanupTemp", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nOkioFilePrivateKeyStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioFilePrivateKeyStore.kt\ncom/flyfishxu/kadb/cert/OkioFilePrivateKeyStore\n+ 2 Okio.kt\nokio/Okio__OkioKt\n+ 3 FileSystem.kt\nokio/FileSystem\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n72#2:71\n58#2,4:73\n66#2,10:78\n62#2,3:88\n77#2,3:91\n58#2,4:97\n66#2,10:102\n62#2,18:112\n73#3:72\n74#3:77\n86#3:94\n191#3:95\n95#3:96\n96#3:101\n1#4:130\n*S KotlinDebug\n*F\n+ 1 OkioFilePrivateKeyStore.kt\ncom/flyfishxu/kadb/cert/OkioFilePrivateKeyStore\n*L\n27#1:71\n27#1:73,4\n27#1:78,10\n27#1:88,3\n27#1:91,3\n54#1:97,4\n54#1:102,10\n54#1:112,18\n27#1:72\n27#1:77\n54#1:94\n54#1:95\n54#1:96\n54#1:101\n*E\n"})
/* loaded from: classes.dex */
public final class OkioFilePrivateKeyStore implements KadbPrivateKeyStore {
    private final FileSystem fileSystem;
    private final C5055Path privateKeyPath;

    public OkioFilePrivateKeyStore(C5055Path privateKeyPath, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(privateKeyPath, "privateKeyPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.privateKeyPath = privateKeyPath;
        this.fileSystem = fileSystem;
    }

    private final void cleanupTemp(C5055Path path) {
        if (this.fileSystem.m14285exists(path)) {
            try {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                this.fileSystem.m14283delete(path);
                C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
            } catch (Throwable th) {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    private final void commitStagedWrite(C5055Path tempPath, C5055Path path) {
        this.fileSystem.atomicMove(tempPath, path);
    }

    private final void deleteIfExists(C5055Path path) {
        if (this.fileSystem.m14285exists(path)) {
            this.fileSystem.m14283delete(path);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    private final byte[] readOrNull(C5055Path path) {
        byte[] th = null;
        if (!this.fileSystem.m14285exists(path)) {
            return null;
        }
        BufferedSource bufferedSourceM14316buffer = C5053Okio.m14316buffer(this.fileSystem.mo14289source(path));
        try {
            byte[] byteArray = bufferedSourceM14316buffer.readByteArray();
            if (bufferedSourceM14316buffer != null) {
                try {
                    bufferedSourceM14316buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            byte[] bArr = th;
            th = byteArray;
            th = bArr;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedSourceM14316buffer != null) {
                try {
                    bufferedSourceM14316buffer.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                }
            }
        }
        if (th == 0) {
            return th;
        }
        throw th;
    }

    private final C5055Path stageWrite(C5055Path path, byte[] payload) throws Throwable {
        C5055Path c5055PathResolve$default;
        C5055Path c5055PathM14356parent = path.m14356parent();
        if (c5055PathM14356parent != null && !this.fileSystem.m14285exists(c5055PathM14356parent)) {
            this.fileSystem.createDirectories(c5055PathM14356parent);
        }
        String str = path.m14355name() + ".tmp-" + UStringsKt.m19822toStringV7xB4Y4(C1128UInt.m18641constructorimpl(AbstractC1241Random.INSTANCE.mo6435nextInt()), 16);
        Throwable th = null;
        if (c5055PathM14356parent == null || (c5055PathResolve$default = C5055Path.resolve$default(c5055PathM14356parent, str, false, 2, (Object) null)) == null) {
            c5055PathResolve$default = C5055Path.Companion.get$default(C5055Path.INSTANCE, str, false, 1, (Object) null);
        }
        BufferedSink bufferedSinkM14315buffer = C5053Okio.m14315buffer(this.fileSystem.mo14288sink(c5055PathResolve$default, false));
        try {
            bufferedSinkM14315buffer.mo14230write(payload);
            if (bufferedSinkM14315buffer != null) {
                try {
                    bufferedSinkM14315buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedSinkM14315buffer != null) {
                try {
                    bufferedSinkM14315buffer.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                }
            }
        }
        if (th == null) {
            return c5055PathResolve$default;
        }
        throw th;
    }

    private final void writeAtomic(C5055Path path, byte[] payload) throws Throwable {
        C5055Path c5055PathStageWrite = stageWrite(path, payload);
        try {
            commitStagedWrite(c5055PathStageWrite, path);
        } finally {
            cleanupTemp(c5055PathStageWrite);
        }
    }

    @Override // com.flyfishxu.p028kadb.p029cert.KadbPrivateKeyStore
    /* renamed from: clear */
    public void mo2180clear() {
        deleteIfExists(this.privateKeyPath);
    }

    @Override // com.flyfishxu.p028kadb.p029cert.KadbPrivateKeyStore
    public byte[] readPrivateKeyPem() {
        return readOrNull(this.privateKeyPath);
    }

    @Override // com.flyfishxu.p028kadb.p029cert.KadbPrivateKeyStore
    public void writePrivateKeyPemAtomic(byte[] privateKeyPem) throws Throwable {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        writeAtomic(this.privateKeyPath, privateKeyPem);
    }

    public /* synthetic */ OkioFilePrivateKeyStore(C5055Path c5055Path, FileSystem fileSystem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c5055Path, (i & 2) != 0 ? FileSystem.f17804SYSTEM : fileSystem);
    }
}
