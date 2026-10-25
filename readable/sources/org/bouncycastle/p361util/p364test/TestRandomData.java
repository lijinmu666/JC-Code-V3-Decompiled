package org.bouncycastle.p361util.p364test;

import org.bouncycastle.p361util.encoders.C6255Hex;
import org.bouncycastle.p361util.p364test.FixedSecureRandom;

/* loaded from: classes2.dex */
public class TestRandomData extends FixedSecureRandom {
    public TestRandomData(String str) {
        super(new FixedSecureRandom.C6259Source[]{new FixedSecureRandom.C6258Data(C6255Hex.m18338decode(str))});
    }

    public TestRandomData(byte[] bArr) {
        super(new FixedSecureRandom.C6259Source[]{new FixedSecureRandom.C6258Data(bArr)});
    }
}
