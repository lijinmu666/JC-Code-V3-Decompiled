package com.flyfishxu.p028kadb;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p132okio.BufferedSource;
import p132okio.C5052Buffer;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, m4988d2 = {"readUntil", "Lokio/Buffer;", "Lokio/BufferedSource;", "endByte", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* renamed from: com.flyfishxu.kadb.KadbKt */
/* loaded from: classes.dex */
public final class C0188KadbKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C5052Buffer readUntil(BufferedSource bufferedSource, byte b) {
        byte b2;
        C5052Buffer c5052Buffer = new C5052Buffer();
        do {
            b2 = bufferedSource.readByte();
            c5052Buffer.writeByte((int) b2);
        } while (b2 != b);
        return c5052Buffer;
    }
}
