package com.p038google.p061crypto.p062tink.p075subtle.p076prf;

import com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

/* renamed from: com.google.crypto.tink.subtle.prf.PrfImpl */
/* loaded from: classes.dex */
public class C0876PrfImpl implements InterfaceC0504Prf {
    private final StreamingPrf prfStreamer;

    private C0876PrfImpl(StreamingPrf streamingPrf) {
        this.prfStreamer = streamingPrf;
    }

    private static byte[] readBytesFromStream(InputStream inputStream, int i) throws GeneralSecurityException, IOException {
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 <= 0) {
                    throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                }
                i2 += i3;
            }
            return bArr;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    /* renamed from: wrap */
    public static C0876PrfImpl m4286wrap(StreamingPrf streamingPrf) {
        return new C0876PrfImpl(streamingPrf);
    }

    @Override // com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf
    /* renamed from: compute */
    public byte[] mo3552compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (bArr == null) {
            throw new GeneralSecurityException("Invalid input provided.");
        }
        if (i > 0) {
            return readBytesFromStream(this.prfStreamer.computePrf(bArr), i);
        }
        throw new GeneralSecurityException("Invalid outputLength specified.");
    }
}
