package org.bouncycastle.p133asn1.p143eac;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PackedDate {

    /* renamed from: time */
    private byte[] f18361time;

    public PackedDate(String str) {
        this.f18361time = m14601convert(str);
    }

    /* renamed from: convert */
    private byte[] m14601convert(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[6];
        for (int i = 0; i != 6; i++) {
            bArr[i] = (byte) (charArray[i] - '0');
        }
        return bArr;
    }

    /* renamed from: equals */
    public boolean m14602equals(Object obj) {
        if (obj instanceof PackedDate) {
            return C6238Arrays.areEqual(this.f18361time, ((PackedDate) obj).f18361time);
        }
        return false;
    }

    /* renamed from: getDate */
    public Date m14603getDate() {
        return new SimpleDateFormat("yyyyMMdd").parse("20" + toString());
    }

    public byte[] getEncoding() {
        return C6238Arrays.m18231clone(this.f18361time);
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f18361time);
    }

    public String toString() {
        int length = this.f18361time.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) ((this.f18361time[i] & C1126UByte.MAX_VALUE) + 48);
        }
        return new String(cArr);
    }

    public PackedDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f18361time = m14601convert(simpleDateFormat.format(date));
    }

    public PackedDate(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f18361time = m14601convert(simpleDateFormat.format(date));
    }

    public PackedDate(byte[] bArr) {
        this.f18361time = bArr;
    }
}
