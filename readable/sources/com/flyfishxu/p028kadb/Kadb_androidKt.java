package com.flyfishxu.p028kadb;

import android.content.Context;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC3495cOuJ;

@Metadata(m4987d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a6\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0010\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004\u001a\u0012\u0010\u0010\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, m4988d2 = {"pull", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/Kadb;", "dst", "Landroidx/documentfile/provider/DocumentFile;", "remotePath", BuildConfig.f24315FLAVOR, "context", "Landroid/content/Context;", "push", "src", "mode", BuildConfig.f24315FLAVOR, "lastModifiedMs", BuildConfig.f24315FLAVOR, "install", "readMode", "file", "Ljava/io/File;", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class Kadb_androidKt {
    /* renamed from: install */
    public static final void m2173install(C0187Kadb c0187Kadb, AbstractC3495cOuJ src, Context context) {
        Intrinsics.checkNotNullParameter(c0187Kadb, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(context, "context");
        context.getContentResolver();
        throw null;
    }

    /* renamed from: pull */
    public static final void m2174pull(C0187Kadb c0187Kadb, AbstractC3495cOuJ dst, String remotePath, Context context) {
        Intrinsics.checkNotNullParameter(c0187Kadb, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        Intrinsics.checkNotNullParameter(context, "context");
        context.getContentResolver();
        throw null;
    }

    /* renamed from: push */
    public static final void m2175push(C0187Kadb c0187Kadb, AbstractC3495cOuJ src, String remotePath, Context context, int i, long j) {
        Intrinsics.checkNotNullParameter(c0187Kadb, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        Intrinsics.checkNotNullParameter(context, "context");
        context.getContentResolver();
        throw null;
    }

    public static /* synthetic */ void push$default(C0187Kadb c0187Kadb, AbstractC3495cOuJ abstractC3495cOuJ, String str, Context context, int i, long j, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = readMode(c0187Kadb, abstractC3495cOuJ);
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            throw null;
        }
        m2175push(c0187Kadb, abstractC3495cOuJ, str, context, i3, j);
    }

    public static final int readMode(C0187Kadb c0187Kadb, AbstractC3495cOuJ file) {
        Intrinsics.checkNotNullParameter(c0187Kadb, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        throw null;
    }

    public static final int readMode(C0187Kadb c0187Kadb, File file) {
        Intrinsics.checkNotNullParameter(c0187Kadb, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Object attribute = Files.getAttribute(file.toPath(), "unix:mode", new LinkOption[0]);
        Integer num = attribute instanceof Integer ? (Integer) attribute : null;
        if (num != null) {
            return num.intValue();
        }
        throw new RuntimeException("Unable to read file mode");
    }
}
