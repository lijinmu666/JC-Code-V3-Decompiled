package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import org.bouncycastle.p194crypto.p201engines.ChaChaEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.C6102Tree;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.pqc.crypto.sphincs.Seed */
/* loaded from: classes2.dex */
class C6101Seed {
    public static void get_seed(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, C6102Tree.leafaddr leafaddrVar) {
        byte[] bArr3 = new byte[40];
        for (int i2 = 0; i2 < 32; i2++) {
            bArr3[i2] = bArr2[i2];
        }
        AbstractC6245Pack.longToLittleEndian((leafaddrVar.f23581subleaf << 59) | leafaddrVar.f23580level | (leafaddrVar.f23582subtree << 4), bArr3, 32);
        hashFunctions.varlen_hash(bArr, i, bArr3, 40);
    }

    /* renamed from: prg */
    public static void m17874prg(byte[] bArr, int i, long j, byte[] bArr2, int i2) {
        ChaChaEngine chaChaEngine = new ChaChaEngine(12);
        chaChaEngine.mo14993init(true, new ParametersWithIV(new KeyParameter(bArr2, i2, 32), new byte[8]));
        chaChaEngine.processBytes(bArr, i, (int) j, bArr, i);
    }
}
