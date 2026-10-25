package p131o;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* renamed from: o.B1 */
/* loaded from: classes.dex */
public final class C1664B1 {

    /* renamed from: AZxh */
    public final KeyGenParameterSpec f7422AZxh;

    /* renamed from: mjFkc */
    public final String f7423mjFkc;

    /* renamed from: o.B1$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public KeyGenParameterSpec f7424AZxh;

        /* renamed from: JHa */
        public boolean f7425JHa;

        /* renamed from: KLFTb */
        public int f7426KLFTb;

        /* renamed from: ZfxDd */
        public boolean f7427ZfxDd;

        /* renamed from: mjFkc */
        public final String f7428mjFkc;

        /* renamed from: wA */
        public wA f7429wA;

        /* renamed from: xJ */
        public final Context f7430xJ;

        /* renamed from: o.B1$AZxh$mjFkc */
        public static class mjFkc {

            /* renamed from: o.B1$AZxh$mjFkc$AZxh, reason: collision with other inner class name */
            public static class C6356AZxh {
                /* renamed from: mjFkc */
                public static void m7653mjFkc(KeyGenParameterSpec.Builder builder, int i, int i2) {
                    builder.setUserAuthenticationParameters(i, i2);
                }
            }

            /* renamed from: o.B1$AZxh$mjFkc$mjFkc, reason: collision with other inner class name */
            public static class C6357mjFkc {
                /* renamed from: mjFkc */
                public static void m7654mjFkc(KeyGenParameterSpec.Builder builder) {
                    builder.setIsStrongBoxBacked(true);
                }
            }

            /* renamed from: AZxh */
            public static String m7651AZxh(KeyGenParameterSpec keyGenParameterSpec) {
                return keyGenParameterSpec.getKeystoreAlias();
            }

            /* renamed from: mjFkc */
            public static C1664B1 m7652mjFkc(AZxh aZxh) {
                wA wAVar = aZxh.f7429wA;
                if (wAVar == null && aZxh.f7424AZxh == null) {
                    throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
                }
                if (wAVar == wA.AES256_GCM) {
                    KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(aZxh.f7428mjFkc, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
                    if (aZxh.f7427ZfxDd) {
                        keySize.setUserAuthenticationRequired(true);
                        if (Build.VERSION.SDK_INT >= 30) {
                            C6356AZxh.m7653mjFkc(keySize, aZxh.f7426KLFTb, 3);
                        } else {
                            keySize.setUserAuthenticationValidityDurationSeconds(aZxh.f7426KLFTb);
                        }
                    }
                    if (aZxh.f7425JHa && aZxh.f7430xJ.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                        C6357mjFkc.m7654mjFkc(keySize);
                    }
                    aZxh.f7424AZxh = keySize.build();
                }
                KeyGenParameterSpec keyGenParameterSpec = aZxh.f7424AZxh;
                if (keyGenParameterSpec != null) {
                    return new C1664B1(AbstractC1800D1.m7951wA(keyGenParameterSpec), aZxh.f7424AZxh);
                }
                throw new NullPointerException("KeyGenParameterSpec was null after build() check");
            }
        }

        public AZxh(Context context) {
            this(context, "_androidx_security_master_key_");
        }

        /* renamed from: AZxh */
        public AZxh m7648AZxh(wA wAVar) {
            if (mjFkc.f7431mjFkc[wAVar.ordinal()] == 1) {
                if (this.f7424AZxh != null) {
                    throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
                }
                this.f7429wA = wAVar;
                return this;
            }
            throw new IllegalArgumentException("Unsupported scheme: " + wAVar);
        }

        /* renamed from: mjFkc */
        public C1664B1 m7649mjFkc() {
            return mjFkc.m7652mjFkc(this);
        }

        /* renamed from: wA */
        public AZxh m7650wA(boolean z) {
            this.f7425JHa = z;
            return this;
        }

        public AZxh(Context context, String str) {
            this.f7430xJ = context.getApplicationContext();
            this.f7428mjFkc = str;
        }
    }

    /* renamed from: o.B1$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f7431mjFkc;

        static {
            int[] iArr = new int[wA.m7657values().length];
            f7431mjFkc = iArr;
            try {
                iArr[wA.AES256_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: o.B1$wA */
    public enum wA {
        AES256_GCM
    }

    public C1664B1(String str, Object obj) {
        this.f7423mjFkc = str;
        this.f7422AZxh = (KeyGenParameterSpec) obj;
    }

    /* renamed from: AZxh */
    public boolean m7646AZxh() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(this.f7423mjFkc);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    /* renamed from: mjFkc */
    public String m7647mjFkc() {
        return this.f7423mjFkc;
    }

    public String toString() {
        return "MasterKey{keyAlias=" + this.f7423mjFkc + ", isKeyStoreBacked=" + m7646AZxh() + "}";
    }
}
