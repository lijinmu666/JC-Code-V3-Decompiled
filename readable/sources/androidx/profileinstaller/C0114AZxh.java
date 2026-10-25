package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.AbstractC0121wA;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p131o.AbstractC3071W3;
import p131o.AbstractC3940jIShy;
import p131o.C2223JGvOM;

/* renamed from: androidx.profileinstaller.AZxh */
/* loaded from: classes.dex */
public class C0114AZxh {

    /* renamed from: AZxh */
    public final Executor f1418AZxh;

    /* renamed from: Dt */
    public C2223JGvOM[] f1419Dt;

    /* renamed from: ETF */
    public byte[] f1420ETF;

    /* renamed from: JHa */
    public final String f1421JHa;

    /* renamed from: KLFTb */
    public final File f1422KLFTb;

    /* renamed from: lgHUyS */
    public final String f1424lgHUyS;

    /* renamed from: mjFkc */
    public final AssetManager f1425mjFkc;

    /* renamed from: wA */
    public final AbstractC0121wA.wA f1427wA;

    /* renamed from: xJ */
    public final String f1428xJ;

    /* renamed from: qdMbNW */
    public boolean f1426qdMbNW = false;

    /* renamed from: ZfxDd */
    public final byte[] f1423ZfxDd = m1113ZfxDd();

    public C0114AZxh(AssetManager assetManager, Executor executor, AbstractC0121wA.wA wAVar, String str, String str2, String str3, File file) {
        this.f1425mjFkc = assetManager;
        this.f1418AZxh = executor;
        this.f1427wA = wAVar;
        this.f1421JHa = str;
        this.f1428xJ = str2;
        this.f1424lgHUyS = str3;
        this.f1422KLFTb = file;
    }

    /* renamed from: ETF */
    public static boolean m1112ETF() {
        int i = Build.VERSION.SDK_INT;
        if (i > 33) {
            return false;
        }
        switch (i) {
        }
        return false;
    }

    /* renamed from: ZfxDd */
    public static byte[] m1113ZfxDd() {
        int i = Build.VERSION.SDK_INT;
        if (i > 33) {
            return null;
        }
        switch (i) {
        }
        return null;
    }

    /* renamed from: AZxh */
    public final C0114AZxh m1115AZxh(C2223JGvOM[] c2223JGvOMArr, byte[] bArr) throws IOException {
        InputStream inputStreamM1122lgHUyS;
        try {
            inputStreamM1122lgHUyS = m1122lgHUyS(this.f1425mjFkc, this.f1424lgHUyS);
        } catch (FileNotFoundException e) {
            this.f1427wA.mo1127AZxh(9, e);
        } catch (IOException e2) {
            this.f1427wA.mo1127AZxh(7, e2);
        } catch (IllegalStateException e3) {
            this.f1419Dt = null;
            this.f1427wA.mo1127AZxh(8, e3);
        }
        if (inputStreamM1122lgHUyS == null) {
            if (inputStreamM1122lgHUyS != null) {
                inputStreamM1122lgHUyS.close();
            }
            return null;
        }
        try {
            this.f1419Dt = AbstractC3071W3.m10790fehf(inputStreamM1122lgHUyS, AbstractC3071W3.m10799rkYL(inputStreamM1122lgHUyS, AbstractC3071W3.f11394AZxh), bArr, c2223JGvOMArr);
            inputStreamM1122lgHUyS.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamM1122lgHUyS.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: Dt */
    public final C2223JGvOM[] m1116Dt(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    try {
                        C2223JGvOM[] c2223JGvOMArrM10791huTpC = AbstractC3071W3.m10791huTpC(inputStream, AbstractC3071W3.m10799rkYL(inputStream, AbstractC3071W3.f11395mjFkc), this.f1421JHa);
                        try {
                            inputStream.close();
                            return c2223JGvOMArrM10791huTpC;
                        } catch (IOException e) {
                            this.f1427wA.mo1127AZxh(7, e);
                            return c2223JGvOMArrM10791huTpC;
                        }
                    } catch (IOException e2) {
                        this.f1427wA.mo1127AZxh(7, e2);
                        return null;
                    }
                } catch (IllegalStateException e3) {
                    this.f1427wA.mo1127AZxh(8, e3);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                this.f1427wA.mo1127AZxh(7, e4);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                this.f1427wA.mo1127AZxh(7, e5);
            }
            throw th;
        }
    }

    /* renamed from: JHa */
    public final InputStream m1117JHa(AssetManager assetManager) {
        try {
            return m1122lgHUyS(assetManager, this.f1428xJ);
        } catch (FileNotFoundException e) {
            this.f1427wA.mo1127AZxh(6, e);
            return null;
        } catch (IOException e2) {
            this.f1427wA.mo1127AZxh(7, e2);
            return null;
        }
    }

    /* renamed from: KLFTb */
    public boolean m1118KLFTb() {
        if (this.f1423ZfxDd == null) {
            m1120VA(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.f1422KLFTb.canWrite()) {
            this.f1426qdMbNW = true;
            return true;
        }
        m1120VA(4, null);
        return false;
    }

    /* renamed from: MiMN */
    public C0114AZxh m1119MiMN() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        C2223JGvOM[] c2223JGvOMArr = this.f1419Dt;
        byte[] bArr = this.f1423ZfxDd;
        if (c2223JGvOMArr != null && bArr != null) {
            m1124wA();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    AbstractC3071W3.m10794mByQ(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.f1427wA.mo1127AZxh(7, e);
            } catch (IllegalStateException e2) {
                this.f1427wA.mo1127AZxh(8, e2);
            }
            if (!AbstractC3071W3.m10766BAnRFn(byteArrayOutputStream, bArr, c2223JGvOMArr)) {
                this.f1427wA.mo1127AZxh(5, null);
                this.f1419Dt = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f1420ETF = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f1419Dt = null;
        }
        return this;
    }

    /* renamed from: VA */
    public final void m1120VA(final int i, final Object obj) {
        this.f1418AZxh.execute(new Runnable() { // from class: o.gYsXfP
            @Override // java.lang.Runnable
            public final void run() {
                this.f13732mjFkc.m1125xJ(i, obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: YoKzxo */
    public boolean m1121YoKzxo() {
        byte[] bArr = this.f1420ETF;
        if (bArr == null) {
            return false;
        }
        m1124wA();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f1422KLFTb);
                    try {
                        AbstractC3940jIShy.m12416VA(byteArrayInputStream, fileOutputStream);
                        m1120VA(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.f1420ETF = null;
                this.f1419Dt = null;
            }
        } catch (FileNotFoundException e) {
            m1120VA(6, e);
            return false;
        } catch (IOException e2) {
            m1120VA(7, e2);
            return false;
        }
    }

    /* renamed from: lgHUyS */
    public final InputStream m1122lgHUyS(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f1427wA.mo1128mjFkc(5, null);
            }
            return null;
        }
    }

    /* renamed from: qdMbNW */
    public C0114AZxh m1123qdMbNW() {
        C0114AZxh c0114AZxhM1115AZxh;
        m1124wA();
        if (this.f1423ZfxDd == null) {
            return this;
        }
        InputStream inputStreamM1117JHa = m1117JHa(this.f1425mjFkc);
        if (inputStreamM1117JHa != null) {
            this.f1419Dt = m1116Dt(inputStreamM1117JHa);
        }
        C2223JGvOM[] c2223JGvOMArr = this.f1419Dt;
        return (c2223JGvOMArr == null || !m1112ETF() || (c0114AZxhM1115AZxh = m1115AZxh(c2223JGvOMArr, this.f1423ZfxDd)) == null) ? this : c0114AZxhM1115AZxh;
    }

    /* renamed from: wA */
    public final void m1124wA() {
        if (!this.f1426qdMbNW) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    /* renamed from: xJ */
    public final /* synthetic */ void m1125xJ(int i, Object obj) {
        this.f1427wA.mo1127AZxh(i, obj);
    }
}
