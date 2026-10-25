package p131o;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: o.W3 */
/* loaded from: classes.dex */
public abstract class AbstractC3071W3 {

    /* renamed from: mjFkc */
    public static final byte[] f11395mjFkc = {112, 114, 111, 0};

    /* renamed from: AZxh */
    public static final byte[] f11394AZxh = {112, 114, 109, 0};

    /* renamed from: AZxh */
    public static byte[] m10765AZxh(C2223JGvOM[] c2223JGvOMArr, byte[] bArr) throws IOException {
        int i = 0;
        int iM12411ETF = 0;
        for (C2223JGvOM c2223JGvOM : c2223JGvOMArr) {
            iM12411ETF += AbstractC3940jIShy.m12411ETF(m10768Dt(c2223JGvOM.f8906mjFkc, c2223JGvOM.f8901AZxh, bArr)) + 16 + (c2223JGvOM.f8903KLFTb * 2) + c2223JGvOM.f8902JHa + m10769ETF(c2223JGvOM.f8909xJ);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iM12411ETF);
        if (Arrays.equals(bArr, AbstractC3135X3.f11521wA)) {
            int length = c2223JGvOMArr.length;
            while (i < length) {
                C2223JGvOM c2223JGvOM2 = c2223JGvOMArr[i];
                m10778Ne(byteArrayOutputStream, c2223JGvOM2, m10768Dt(c2223JGvOM2.f8906mjFkc, c2223JGvOM2.f8901AZxh, bArr));
                m10779OjSQV(byteArrayOutputStream, c2223JGvOM2);
                i++;
            }
        } else {
            for (C2223JGvOM c2223JGvOM3 : c2223JGvOMArr) {
                m10778Ne(byteArrayOutputStream, c2223JGvOM3, m10768Dt(c2223JGvOM3.f8906mjFkc, c2223JGvOM3.f8901AZxh, bArr));
            }
            int length2 = c2223JGvOMArr.length;
            while (i < length2) {
                m10779OjSQV(byteArrayOutputStream, c2223JGvOMArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == iM12411ETF) {
            return byteArrayOutputStream.toByteArray();
        }
        throw AbstractC3940jIShy.m12425wA("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iM12411ETF);
    }

    /* renamed from: BAnRFn */
    public static boolean m10766BAnRFn(OutputStream outputStream, byte[] bArr, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        if (Arrays.equals(bArr, AbstractC3135X3.f11520mjFkc)) {
            m10783Vnb(outputStream, c2223JGvOMArr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC3135X3.f11516AZxh)) {
            m10798rWxwaT(outputStream, c2223JGvOMArr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC3135X3.f11519ZfxDd)) {
            m10805zvd(outputStream, c2223JGvOMArr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC3135X3.f11521wA)) {
            m10787cMLeY(outputStream, c2223JGvOMArr);
            return true;
        }
        if (!Arrays.equals(bArr, AbstractC3135X3.f11518KLFTb)) {
            return false;
        }
        m10775KLMXS(outputStream, c2223JGvOMArr);
        return true;
    }

    /* renamed from: CqaNbM */
    public static void m10767CqaNbM(OutputStream outputStream, C2223JGvOM c2223JGvOM) throws IOException {
        byte[] bArr = new byte[m10769ETF(c2223JGvOM.f8909xJ)];
        for (Map.Entry entry : c2223JGvOM.f8907qdMbNW.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                m10800vI(bArr, 2, iIntValue, c2223JGvOM);
            }
            if ((iIntValue2 & 4) != 0) {
                m10800vI(bArr, 4, iIntValue, c2223JGvOM);
            }
        }
        outputStream.write(bArr);
    }

    /* renamed from: Dt */
    public static String m10768Dt(String str, String str2, byte[] bArr) {
        String strM10884mjFkc = AbstractC3135X3.m10884mjFkc(bArr);
        if (str.length() <= 0) {
            return m10803xJ(str2, strM10884mjFkc);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return m10803xJ(str2, strM10884mjFkc);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + AbstractC3135X3.m10884mjFkc(bArr) + str2;
    }

    /* renamed from: ETF */
    public static int m10769ETF(int i) {
        return m10771HGpJ(i * 2) / 8;
    }

    /* renamed from: Gd */
    public static C2223JGvOM[] m10770Gd(InputStream inputStream, String str, int i) {
        if (inputStream.available() == 0) {
            return new C2223JGvOM[0];
        }
        C2223JGvOM[] c2223JGvOMArr = new C2223JGvOM[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iM12420lgHUyS = AbstractC3940jIShy.m12420lgHUyS(inputStream);
            int iM12420lgHUyS2 = AbstractC3940jIShy.m12420lgHUyS(inputStream);
            c2223JGvOMArr[i2] = new C2223JGvOM(str, AbstractC3940jIShy.m12413JHa(inputStream, iM12420lgHUyS), AbstractC3940jIShy.m12423qdMbNW(inputStream), 0L, iM12420lgHUyS2, (int) AbstractC3940jIShy.m12423qdMbNW(inputStream), (int) AbstractC3940jIShy.m12423qdMbNW(inputStream), new int[iM12420lgHUyS2], new TreeMap());
        }
        for (int i3 = 0; i3 < i; i3++) {
            C2223JGvOM c2223JGvOM = c2223JGvOMArr[i3];
            m10796qGY(inputStream, c2223JGvOM);
            c2223JGvOM.f8905lgHUyS = m10776MiMN(inputStream, c2223JGvOM.f8903KLFTb);
            m10781Ucbh(inputStream, c2223JGvOM);
        }
        return c2223JGvOMArr;
    }

    /* renamed from: HGpJ */
    public static int m10771HGpJ(int i) {
        return (i + 7) & (-8);
    }

    /* renamed from: IEE */
    public static C2223JGvOM[] m10772IEE(InputStream inputStream, byte[] bArr, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        if (!Arrays.equals(bArr, AbstractC3135X3.f11517JHa)) {
            throw AbstractC3940jIShy.m12425wA("Unsupported meta version");
        }
        int iM12410Dt = AbstractC3940jIShy.m12410Dt(inputStream);
        byte[] bArrM12414KLFTb = AbstractC3940jIShy.m12414KLFTb(inputStream, (int) AbstractC3940jIShy.m12423qdMbNW(inputStream), (int) AbstractC3940jIShy.m12423qdMbNW(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC3940jIShy.m12425wA("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM12414KLFTb);
        try {
            C2223JGvOM[] c2223JGvOMArrM10780Pq = m10780Pq(byteArrayInputStream, iM12410Dt, c2223JGvOMArr);
            byteArrayInputStream.close();
            return c2223JGvOMArrM10780Pq;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: JHa */
    public static byte[] m10773JHa(C2223JGvOM c2223JGvOM) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m10804xrEuO(byteArrayOutputStream, c2223JGvOM);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: KLFTb */
    public static byte[] m10774KLFTb(C2223JGvOM c2223JGvOM) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m10767CqaNbM(byteArrayOutputStream, c2223JGvOM);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: KLMXS */
    public static void m10775KLMXS(OutputStream outputStream, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        AbstractC3940jIShy.m12422qGY(outputStream, c2223JGvOMArr.length);
        for (C2223JGvOM c2223JGvOM : c2223JGvOMArr) {
            String strM10768Dt = m10768Dt(c2223JGvOM.f8906mjFkc, c2223JGvOM.f8901AZxh, AbstractC3135X3.f11518KLFTb);
            AbstractC3940jIShy.m12422qGY(outputStream, AbstractC3940jIShy.m12411ETF(strM10768Dt));
            AbstractC3940jIShy.m12422qGY(outputStream, c2223JGvOM.f8907qdMbNW.size());
            AbstractC3940jIShy.m12422qGY(outputStream, c2223JGvOM.f8905lgHUyS.length);
            AbstractC3940jIShy.m12419fehf(outputStream, c2223JGvOM.f8908wA);
            AbstractC3940jIShy.m12417YoKzxo(outputStream, strM10768Dt);
            Iterator it = c2223JGvOM.f8907qdMbNW.keySet().iterator();
            while (it.hasNext()) {
                AbstractC3940jIShy.m12422qGY(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i : c2223JGvOM.f8905lgHUyS) {
                AbstractC3940jIShy.m12422qGY(outputStream, i);
            }
        }
    }

    /* renamed from: MiMN */
    public static int[] m10776MiMN(InputStream inputStream, int i) {
        int[] iArr = new int[i];
        int iM12420lgHUyS = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iM12420lgHUyS += AbstractC3940jIShy.m12420lgHUyS(inputStream);
            iArr[i2] = iM12420lgHUyS;
        }
        return iArr;
    }

    /* renamed from: NPj */
    public static void m10777NPj(OutputStream outputStream, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(m10802wJVbdd(c2223JGvOMArr));
        arrayList.add(m10801wA(c2223JGvOMArr));
        arrayList.add(m10786ZfxDd(c2223JGvOMArr));
        long length2 = AbstractC3135X3.f11520mjFkc.length + f11395mjFkc.length + 4 + (arrayList.size() * 16);
        AbstractC3940jIShy.m12419fehf(outputStream, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            C1768Cb c1768Cb = (C1768Cb) arrayList.get(i);
            AbstractC3940jIShy.m12419fehf(outputStream, c1768Cb.f7638mjFkc.m13853lgHUyS());
            AbstractC3940jIShy.m12419fehf(outputStream, length2);
            if (c1768Cb.f7637ZfxDd) {
                byte[] bArr = c1768Cb.f7639wA;
                long length3 = bArr.length;
                byte[] bArrM12409AZxh = AbstractC3940jIShy.m12409AZxh(bArr);
                arrayList2.add(bArrM12409AZxh);
                AbstractC3940jIShy.m12419fehf(outputStream, bArrM12409AZxh.length);
                AbstractC3940jIShy.m12419fehf(outputStream, length3);
                length = bArrM12409AZxh.length;
            } else {
                arrayList2.add(c1768Cb.f7639wA);
                AbstractC3940jIShy.m12419fehf(outputStream, c1768Cb.f7639wA.length);
                AbstractC3940jIShy.m12419fehf(outputStream, 0L);
                length = c1768Cb.f7639wA.length;
            }
            length2 += length;
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            outputStream.write((byte[]) arrayList2.get(i2));
        }
    }

    /* renamed from: Ne */
    public static void m10778Ne(OutputStream outputStream, C2223JGvOM c2223JGvOM, String str) throws IOException {
        AbstractC3940jIShy.m12422qGY(outputStream, AbstractC3940jIShy.m12411ETF(str));
        AbstractC3940jIShy.m12422qGY(outputStream, c2223JGvOM.f8903KLFTb);
        AbstractC3940jIShy.m12419fehf(outputStream, c2223JGvOM.f8902JHa);
        AbstractC3940jIShy.m12419fehf(outputStream, c2223JGvOM.f8908wA);
        AbstractC3940jIShy.m12419fehf(outputStream, c2223JGvOM.f8909xJ);
        AbstractC3940jIShy.m12417YoKzxo(outputStream, str);
    }

    /* renamed from: OjSQV */
    public static void m10779OjSQV(OutputStream outputStream, C2223JGvOM c2223JGvOM) throws IOException {
        m10804xrEuO(outputStream, c2223JGvOM);
        m10792lB(outputStream, c2223JGvOM);
        m10767CqaNbM(outputStream, c2223JGvOM);
    }

    /* renamed from: Pq */
    public static C2223JGvOM[] m10780Pq(InputStream inputStream, int i, C2223JGvOM[] c2223JGvOMArr) {
        if (inputStream.available() == 0) {
            return new C2223JGvOM[0];
        }
        if (i != c2223JGvOMArr.length) {
            throw AbstractC3940jIShy.m12425wA("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iM12420lgHUyS = AbstractC3940jIShy.m12420lgHUyS(inputStream);
            iArr[i2] = AbstractC3940jIShy.m12420lgHUyS(inputStream);
            strArr[i2] = AbstractC3940jIShy.m12413JHa(inputStream, iM12420lgHUyS);
        }
        for (int i3 = 0; i3 < i; i3++) {
            C2223JGvOM c2223JGvOM = c2223JGvOMArr[i3];
            if (!c2223JGvOM.f8901AZxh.equals(strArr[i3])) {
                throw AbstractC3940jIShy.m12425wA("Order of dexfiles in metadata did not match baseline");
            }
            int i4 = iArr[i3];
            c2223JGvOM.f8903KLFTb = i4;
            c2223JGvOM.f8905lgHUyS = m10776MiMN(inputStream, i4);
        }
        return c2223JGvOMArr;
    }

    /* renamed from: Ucbh */
    public static void m10781Ucbh(InputStream inputStream, C2223JGvOM c2223JGvOM) {
        BitSet bitSetValueOf = BitSet.valueOf(AbstractC3940jIShy.m12418ZfxDd(inputStream, AbstractC3940jIShy.m12421mjFkc(c2223JGvOM.f8909xJ * 2)));
        int i = 0;
        while (true) {
            int i2 = c2223JGvOM.f8909xJ;
            if (i >= i2) {
                return;
            }
            int iM10785YoKzxo = m10785YoKzxo(bitSetValueOf, i, i2);
            if (iM10785YoKzxo != 0) {
                Integer num = (Integer) c2223JGvOM.f8907qdMbNW.get(Integer.valueOf(i));
                if (num == null) {
                    num = 0;
                }
                c2223JGvOM.f8907qdMbNW.put(Integer.valueOf(i), Integer.valueOf(iM10785YoKzxo | num.intValue()));
            }
            i++;
        }
    }

    /* renamed from: VA */
    public static int m10782VA(int i, int i2, int i3) {
        if (i == 1) {
            throw AbstractC3940jIShy.m12425wA("HOT methods are not stored in the bitmap");
        }
        if (i == 2) {
            return i2;
        }
        if (i == 4) {
            return i2 + i3;
        }
        throw AbstractC3940jIShy.m12425wA("Unexpected flag: " + i);
    }

    /* renamed from: Vnb */
    public static void m10783Vnb(OutputStream outputStream, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        m10777NPj(outputStream, c2223JGvOMArr);
    }

    /* renamed from: VocHEe */
    public static void m10784VocHEe(InputStream inputStream) {
        AbstractC3940jIShy.m12420lgHUyS(inputStream);
        int iM12410Dt = AbstractC3940jIShy.m12410Dt(inputStream);
        if (iM12410Dt == 6 || iM12410Dt == 7) {
            return;
        }
        while (iM12410Dt > 0) {
            AbstractC3940jIShy.m12410Dt(inputStream);
            for (int iM12410Dt2 = AbstractC3940jIShy.m12410Dt(inputStream); iM12410Dt2 > 0; iM12410Dt2--) {
                AbstractC3940jIShy.m12420lgHUyS(inputStream);
            }
            iM12410Dt--;
        }
    }

    /* renamed from: YoKzxo */
    public static int m10785YoKzxo(BitSet bitSet, int i, int i2) {
        int i3 = bitSet.get(m10782VA(2, i, i2)) ? 2 : 0;
        return bitSet.get(m10782VA(4, i, i2)) ? i3 | 4 : i3;
    }

    /* renamed from: ZfxDd */
    public static C1768Cb m10786ZfxDd(C2223JGvOM[] c2223JGvOMArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < c2223JGvOMArr.length; i2++) {
            try {
                C2223JGvOM c2223JGvOM = c2223JGvOMArr[i2];
                int iM10795mjFkc = m10795mjFkc(c2223JGvOM);
                byte[] bArrM10774KLFTb = m10774KLFTb(c2223JGvOM);
                byte[] bArrM10773JHa = m10773JHa(c2223JGvOM);
                AbstractC3940jIShy.m12422qGY(byteArrayOutputStream, i2);
                int length = bArrM10774KLFTb.length + 2 + bArrM10773JHa.length;
                AbstractC3940jIShy.m12419fehf(byteArrayOutputStream, length);
                AbstractC3940jIShy.m12422qGY(byteArrayOutputStream, iM10795mjFkc);
                byteArrayOutputStream.write(bArrM10774KLFTb);
                byteArrayOutputStream.write(bArrM10773JHa);
                i = i + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i == byteArray.length) {
            C1768Cb c1768Cb = new C1768Cb(EnumC4812wMV.METHODS, i, byteArray, true);
            byteArrayOutputStream.close();
            return c1768Cb;
        }
        throw AbstractC3940jIShy.m12425wA("Expected size " + i + ", does not match actual size " + byteArray.length);
    }

    /* renamed from: cMLeY */
    public static void m10787cMLeY(OutputStream outputStream, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        byte[] bArrM10765AZxh = m10765AZxh(c2223JGvOMArr, AbstractC3135X3.f11521wA);
        AbstractC3940jIShy.m12412IEE(outputStream, c2223JGvOMArr.length);
        AbstractC3940jIShy.m12415MiMN(outputStream, bArrM10765AZxh);
    }

    /* renamed from: diqgf */
    public static C2223JGvOM[] m10788diqgf(InputStream inputStream, byte[] bArr, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        int iM12420lgHUyS = AbstractC3940jIShy.m12420lgHUyS(inputStream);
        byte[] bArrM12414KLFTb = AbstractC3940jIShy.m12414KLFTb(inputStream, (int) AbstractC3940jIShy.m12423qdMbNW(inputStream), (int) AbstractC3940jIShy.m12423qdMbNW(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC3940jIShy.m12425wA("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM12414KLFTb);
        try {
            C2223JGvOM[] c2223JGvOMArrM10789eyqo = m10789eyqo(byteArrayInputStream, bArr, iM12420lgHUyS, c2223JGvOMArr);
            byteArrayInputStream.close();
            return c2223JGvOMArrM10789eyqo;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: eyqo */
    public static C2223JGvOM[] m10789eyqo(InputStream inputStream, byte[] bArr, int i, C2223JGvOM[] c2223JGvOMArr) {
        if (inputStream.available() == 0) {
            return new C2223JGvOM[0];
        }
        if (i != c2223JGvOMArr.length) {
            throw AbstractC3940jIShy.m12425wA("Mismatched number of dex files found in metadata");
        }
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC3940jIShy.m12420lgHUyS(inputStream);
            String strM12413JHa = AbstractC3940jIShy.m12413JHa(inputStream, AbstractC3940jIShy.m12420lgHUyS(inputStream));
            long jM12423qdMbNW = AbstractC3940jIShy.m12423qdMbNW(inputStream);
            int iM12420lgHUyS = AbstractC3940jIShy.m12420lgHUyS(inputStream);
            C2223JGvOM c2223JGvOMM10797qdMbNW = m10797qdMbNW(c2223JGvOMArr, strM12413JHa);
            if (c2223JGvOMM10797qdMbNW == null) {
                throw AbstractC3940jIShy.m12425wA("Missing profile key: " + strM12413JHa);
            }
            c2223JGvOMM10797qdMbNW.f8904ZfxDd = jM12423qdMbNW;
            int[] iArrM10776MiMN = m10776MiMN(inputStream, iM12420lgHUyS);
            if (Arrays.equals(bArr, AbstractC3135X3.f11518KLFTb)) {
                c2223JGvOMM10797qdMbNW.f8903KLFTb = iM12420lgHUyS;
                c2223JGvOMM10797qdMbNW.f8905lgHUyS = iArrM10776MiMN;
            }
        }
        return c2223JGvOMArr;
    }

    /* renamed from: fehf */
    public static C2223JGvOM[] m10790fehf(InputStream inputStream, byte[] bArr, byte[] bArr2, C2223JGvOM[] c2223JGvOMArr) {
        if (Arrays.equals(bArr, AbstractC3135X3.f11517JHa)) {
            if (Arrays.equals(AbstractC3135X3.f11520mjFkc, bArr2)) {
                throw AbstractC3940jIShy.m12425wA("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return m10772IEE(inputStream, bArr, c2223JGvOMArr);
        }
        if (Arrays.equals(bArr, AbstractC3135X3.f11522xJ)) {
            return m10788diqgf(inputStream, bArr2, c2223JGvOMArr);
        }
        throw AbstractC3940jIShy.m12425wA("Unsupported meta version");
    }

    /* renamed from: huTpC */
    public static C2223JGvOM[] m10791huTpC(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, AbstractC3135X3.f11516AZxh)) {
            throw AbstractC3940jIShy.m12425wA("Unsupported version");
        }
        int iM12410Dt = AbstractC3940jIShy.m12410Dt(inputStream);
        byte[] bArrM12414KLFTb = AbstractC3940jIShy.m12414KLFTb(inputStream, (int) AbstractC3940jIShy.m12423qdMbNW(inputStream), (int) AbstractC3940jIShy.m12423qdMbNW(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC3940jIShy.m12425wA("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM12414KLFTb);
        try {
            C2223JGvOM[] c2223JGvOMArrM10770Gd = m10770Gd(byteArrayInputStream, str, iM12410Dt);
            byteArrayInputStream.close();
            return c2223JGvOMArrM10770Gd;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: lB */
    public static void m10792lB(OutputStream outputStream, C2223JGvOM c2223JGvOM) throws IOException {
        int[] iArr = c2223JGvOM.f8905lgHUyS;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            AbstractC3940jIShy.m12422qGY(outputStream, i3 - i2);
            i++;
            i2 = i3;
        }
    }

    /* renamed from: lgHUyS */
    public static String m10793lgHUyS(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    /* renamed from: mByQ */
    public static void m10794mByQ(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f11395mjFkc);
        outputStream.write(bArr);
    }

    /* renamed from: mjFkc */
    public static int m10795mjFkc(C2223JGvOM c2223JGvOM) {
        Iterator it = c2223JGvOM.f8907qdMbNW.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    /* renamed from: qGY */
    public static void m10796qGY(InputStream inputStream, C2223JGvOM c2223JGvOM) {
        int iAvailable = inputStream.available() - c2223JGvOM.f8902JHa;
        int iM12420lgHUyS = 0;
        while (inputStream.available() > iAvailable) {
            iM12420lgHUyS += AbstractC3940jIShy.m12420lgHUyS(inputStream);
            c2223JGvOM.f8907qdMbNW.put(Integer.valueOf(iM12420lgHUyS), 1);
            for (int iM12420lgHUyS2 = AbstractC3940jIShy.m12420lgHUyS(inputStream); iM12420lgHUyS2 > 0; iM12420lgHUyS2--) {
                m10784VocHEe(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw AbstractC3940jIShy.m12425wA("Read too much data during profile line parse");
        }
    }

    /* renamed from: qdMbNW */
    public static C2223JGvOM m10797qdMbNW(C2223JGvOM[] c2223JGvOMArr, String str) {
        if (c2223JGvOMArr.length <= 0) {
            return null;
        }
        String strM10793lgHUyS = m10793lgHUyS(str);
        for (int i = 0; i < c2223JGvOMArr.length; i++) {
            if (c2223JGvOMArr[i].f8901AZxh.equals(strM10793lgHUyS)) {
                return c2223JGvOMArr[i];
            }
        }
        return null;
    }

    /* renamed from: rWxwaT */
    public static void m10798rWxwaT(OutputStream outputStream, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        byte[] bArrM10765AZxh = m10765AZxh(c2223JGvOMArr, AbstractC3135X3.f11516AZxh);
        AbstractC3940jIShy.m12412IEE(outputStream, c2223JGvOMArr.length);
        AbstractC3940jIShy.m12415MiMN(outputStream, bArrM10765AZxh);
    }

    /* renamed from: rkYL */
    public static byte[] m10799rkYL(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, AbstractC3940jIShy.m12418ZfxDd(inputStream, bArr.length))) {
            return AbstractC3940jIShy.m12418ZfxDd(inputStream, AbstractC3135X3.f11516AZxh.length);
        }
        throw AbstractC3940jIShy.m12425wA("Invalid magic");
    }

    /* renamed from: vI */
    public static void m10800vI(byte[] bArr, int i, int i2, C2223JGvOM c2223JGvOM) {
        int iM10782VA = m10782VA(i, i2, c2223JGvOM.f8909xJ);
        int i3 = iM10782VA / 8;
        bArr[i3] = (byte) ((1 << (iM10782VA % 8)) | bArr[i3]);
    }

    /* renamed from: wA */
    public static C1768Cb m10801wA(C2223JGvOM[] c2223JGvOMArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < c2223JGvOMArr.length; i2++) {
            try {
                C2223JGvOM c2223JGvOM = c2223JGvOMArr[i2];
                AbstractC3940jIShy.m12422qGY(byteArrayOutputStream, i2);
                AbstractC3940jIShy.m12422qGY(byteArrayOutputStream, c2223JGvOM.f8903KLFTb);
                i = i + 4 + (c2223JGvOM.f8903KLFTb * 2);
                m10792lB(byteArrayOutputStream, c2223JGvOM);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i == byteArray.length) {
            C1768Cb c1768Cb = new C1768Cb(EnumC4812wMV.CLASSES, i, byteArray, true);
            byteArrayOutputStream.close();
            return c1768Cb;
        }
        throw AbstractC3940jIShy.m12425wA("Expected size " + i + ", does not match actual size " + byteArray.length);
    }

    /* renamed from: wJVbdd */
    public static C1768Cb m10802wJVbdd(C2223JGvOM[] c2223JGvOMArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AbstractC3940jIShy.m12422qGY(byteArrayOutputStream, c2223JGvOMArr.length);
            int i = 2;
            for (C2223JGvOM c2223JGvOM : c2223JGvOMArr) {
                AbstractC3940jIShy.m12419fehf(byteArrayOutputStream, c2223JGvOM.f8908wA);
                AbstractC3940jIShy.m12419fehf(byteArrayOutputStream, c2223JGvOM.f8904ZfxDd);
                AbstractC3940jIShy.m12419fehf(byteArrayOutputStream, c2223JGvOM.f8909xJ);
                String strM10768Dt = m10768Dt(c2223JGvOM.f8906mjFkc, c2223JGvOM.f8901AZxh, AbstractC3135X3.f11520mjFkc);
                int iM12411ETF = AbstractC3940jIShy.m12411ETF(strM10768Dt);
                AbstractC3940jIShy.m12422qGY(byteArrayOutputStream, iM12411ETF);
                i = i + 14 + iM12411ETF;
                AbstractC3940jIShy.m12417YoKzxo(byteArrayOutputStream, strM10768Dt);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i == byteArray.length) {
                C1768Cb c1768Cb = new C1768Cb(EnumC4812wMV.DEX_FILES, i, byteArray, false);
                byteArrayOutputStream.close();
                return c1768Cb;
            }
            throw AbstractC3940jIShy.m12425wA("Expected size " + i + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: xJ */
    public static String m10803xJ(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    /* renamed from: xrEuO */
    public static void m10804xrEuO(OutputStream outputStream, C2223JGvOM c2223JGvOM) throws IOException {
        int i = 0;
        for (Map.Entry entry : c2223JGvOM.f8907qdMbNW.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                AbstractC3940jIShy.m12422qGY(outputStream, iIntValue - i);
                AbstractC3940jIShy.m12422qGY(outputStream, 0);
                i = iIntValue;
            }
        }
    }

    /* renamed from: zvd */
    public static void m10805zvd(OutputStream outputStream, C2223JGvOM[] c2223JGvOMArr) throws IOException {
        AbstractC3940jIShy.m12412IEE(outputStream, c2223JGvOMArr.length);
        for (C2223JGvOM c2223JGvOM : c2223JGvOMArr) {
            int size = c2223JGvOM.f8907qdMbNW.size() * 4;
            String strM10768Dt = m10768Dt(c2223JGvOM.f8906mjFkc, c2223JGvOM.f8901AZxh, AbstractC3135X3.f11519ZfxDd);
            AbstractC3940jIShy.m12422qGY(outputStream, AbstractC3940jIShy.m12411ETF(strM10768Dt));
            AbstractC3940jIShy.m12422qGY(outputStream, c2223JGvOM.f8905lgHUyS.length);
            AbstractC3940jIShy.m12419fehf(outputStream, size);
            AbstractC3940jIShy.m12419fehf(outputStream, c2223JGvOM.f8908wA);
            AbstractC3940jIShy.m12417YoKzxo(outputStream, strM10768Dt);
            Iterator it = c2223JGvOM.f8907qdMbNW.keySet().iterator();
            while (it.hasNext()) {
                AbstractC3940jIShy.m12422qGY(outputStream, ((Integer) it.next()).intValue());
                AbstractC3940jIShy.m12422qGY(outputStream, 0);
            }
            for (int i : c2223JGvOM.f8905lgHUyS) {
                AbstractC3940jIShy.m12422qGY(outputStream, i);
            }
        }
    }
}
