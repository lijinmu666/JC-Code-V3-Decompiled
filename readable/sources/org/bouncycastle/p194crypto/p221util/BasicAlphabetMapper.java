package org.bouncycastle.p194crypto.p221util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.AlphabetMapper;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class BasicAlphabetMapper implements AlphabetMapper {

    /* renamed from: charMap */
    private Map<Integer, Character> f21111charMap;
    private Map<Character, Integer> indexMap;

    public BasicAlphabetMapper(String str) {
        this(str.toCharArray());
    }

    @Override // org.bouncycastle.p194crypto.AlphabetMapper
    public char[] convertToChars(byte[] bArr) {
        char[] cArr;
        int i = 0;
        if (this.f21111charMap.size() <= 256) {
            cArr = new char[bArr.length];
            while (i != bArr.length) {
                cArr[i] = this.f21111charMap.get(Integer.valueOf(bArr[i] & C1126UByte.MAX_VALUE)).charValue();
                i++;
            }
        } else {
            if ((bArr.length & 1) != 0) {
                throw new IllegalArgumentException("two byte radix and input string odd length");
            }
            cArr = new char[bArr.length / 2];
            while (i != bArr.length) {
                cArr[i / 2] = this.f21111charMap.get(Integer.valueOf(((bArr[i] << 8) & 65280) | (bArr[i + 1] & C1126UByte.MAX_VALUE))).charValue();
                i += 2;
            }
        }
        return cArr;
    }

    @Override // org.bouncycastle.p194crypto.AlphabetMapper
    public byte[] convertToIndexes(char[] cArr) {
        byte[] bArr;
        int i = 0;
        if (this.indexMap.size() <= 256) {
            bArr = new byte[cArr.length];
            while (i != cArr.length) {
                bArr[i] = this.indexMap.get(Character.valueOf(cArr[i])).byteValue();
                i++;
            }
        } else {
            bArr = new byte[cArr.length * 2];
            while (i != cArr.length) {
                int iIntValue = this.indexMap.get(Character.valueOf(cArr[i])).intValue();
                int i2 = i * 2;
                bArr[i2] = (byte) ((iIntValue >> 8) & 255);
                bArr[i2 + 1] = (byte) (iIntValue & 255);
                i++;
            }
        }
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.AlphabetMapper
    public int getRadix() {
        return this.indexMap.size();
    }

    public BasicAlphabetMapper(char[] cArr) {
        this.indexMap = new HashMap();
        this.f21111charMap = new HashMap();
        for (int i = 0; i != cArr.length; i++) {
            if (this.indexMap.containsKey(Character.valueOf(cArr[i]))) {
                throw new IllegalArgumentException("duplicate key detected in alphabet: " + cArr[i]);
            }
            this.indexMap.put(Character.valueOf(cArr[i]), Integer.valueOf(i));
            this.f21111charMap.put(Integer.valueOf(i), Character.valueOf(cArr[i]));
        }
    }
}
