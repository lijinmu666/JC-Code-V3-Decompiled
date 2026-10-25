package org.bouncycastle.p226est;

/* loaded from: classes2.dex */
public interface TLSUniqueProvider {
    byte[] getTLSUnique();

    boolean isTLSUniqueAvailable();
}
