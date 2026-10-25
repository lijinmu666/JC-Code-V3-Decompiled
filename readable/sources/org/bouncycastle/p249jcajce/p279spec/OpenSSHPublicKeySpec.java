package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.EncodedKeySpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class OpenSSHPublicKeySpec extends EncodedKeySpec {
    private static final String[] allowedTypes = {"ssh-rsa", "ssh-ed25519", "ssh-dss"};

    /* renamed from: type */
    private final String f21939type;

    public OpenSSHPublicKeySpec(byte[] bArr) {
        super(bArr);
        int i = 0;
        int i2 = (((bArr[0] & C1126UByte.MAX_VALUE) << 24) | ((bArr[1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[2] & C1126UByte.MAX_VALUE) << 8) | (bArr[3] & C1126UByte.MAX_VALUE)) + 4;
        if (i2 >= bArr.length) {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
        String strFromByteArray = C6250Strings.fromByteArray(C6238Arrays.copyOfRange(bArr, 4, i2));
        this.f21939type = strFromByteArray;
        if (strFromByteArray.startsWith("ecdsa")) {
            return;
        }
        while (true) {
            String[] strArr = allowedTypes;
            if (i >= strArr.length) {
                throw new IllegalArgumentException("unrecognised public key type " + this.f21939type);
            }
            if (strArr[i].equals(this.f21939type)) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "OpenSSH";
    }

    /* renamed from: getType */
    public String m16211getType() {
        return this.f21939type;
    }
}
