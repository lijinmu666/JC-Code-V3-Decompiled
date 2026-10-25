package com.flyfishxu.p028kadb.exception;

import java.io.IOException;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m4988d2 = {"Lcom/flyfishxu/kadb/exception/AdbPairAuthException;", "Ljava/io/IOException;", "<init>", "()V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbPairAuthException extends IOException {
    public AdbPairAuthException() {
        super("Pairing required or trust missing");
    }
}
