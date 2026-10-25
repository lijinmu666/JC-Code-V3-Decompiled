package com.p038google.p061crypto.p062tink.p071mac;

/* loaded from: classes.dex */
public interface ChunkedMac {
    ChunkedMacComputation createComputation();

    ChunkedMacVerification createVerification(byte[] bArr);
}
