package org.bouncycastle.p177cert.p180crmf;

/* loaded from: classes2.dex */
public interface EncryptedValuePadder {
    byte[] getPaddedData(byte[] bArr);

    byte[] getUnpaddedData(byte[] bArr);
}
