package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p067hybrid.p068subtle.AeadOrDaead;

/* loaded from: classes.dex */
public interface EciesAeadHkdfDemHelper {
    AeadOrDaead getAeadOrDaead(byte[] bArr);

    int getSymmetricKeySizeInBytes();
}
