package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.MultiBlockCipher;
import org.bouncycastle.p194crypto.SkippingStreamCipher;

/* loaded from: classes2.dex */
public interface CTRModeCipher extends MultiBlockCipher, SkippingStreamCipher {
    BlockCipher getUnderlyingCipher();
}
