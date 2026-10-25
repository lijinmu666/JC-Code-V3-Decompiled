package org.bouncycastle.p226est;

/* loaded from: classes2.dex */
public interface ESTClientProvider {
    boolean isTrusted();

    ESTClient makeClient();
}
