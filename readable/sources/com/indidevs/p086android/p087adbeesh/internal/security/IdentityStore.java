package com.indidevs.p086android.p087adbeesh.internal.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p131o.C1664B1;
import p131o.SharedPreferencesC4295ofUPN;

@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/security/IdentityStore;", BuildConfig.f24315FLAVOR, "Landroid/content/Context;", "context", BuildConfig.f24315FLAVOR, "id", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", "getOrInitializePrefs", "()Landroid/content/SharedPreferences;", "Lo/B1;", "masterKey", "createEncryptedPrefs", "(Lo/B1;)Landroid/content/SharedPreferences;", BuildConfig.f24315FLAVOR, "clearPersistentStorage", "()V", "Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", "load", "()Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", "keyPair", "save", "(Lcom/indidevs/android/adbeesh/internal/security/KeyPair;)V", "delete", "Landroid/content/Context;", "Ljava/lang/String;", "fileName", "cachedPrefs", "Landroid/content/SharedPreferences;", "cachedKeyPair", "Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nIdentityStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdentityStore.kt\ncom/indidevs/android/adbeesh/internal/security/IdentityStore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
/* loaded from: classes.dex */
public final class IdentityStore {
    private static final String CERT_TYPE = "X.509";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_ALGORITHM = "RSA";
    private static final String KEY_CERTIFICATE = "cert";
    private static final String KEY_PRIVATE_KEY = "priv_key";

    /* renamed from: TAG */
    private static final String f4150TAG = "ADBeesh:IdentityStore";
    private KeyPair cachedKeyPair;
    private SharedPreferences cachedPrefs;
    private final Context context;
    private final String fileName;
    private final String id;

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/security/IdentityStore$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "TAG", BuildConfig.f24315FLAVOR, "KEY_PRIVATE_KEY", "KEY_CERTIFICATE", "KEY_ALGORITHM", "CERT_TYPE", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public IdentityStore(Context context, String id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        this.context = context;
        this.id = id;
        this.fileName = "adbeesh_identity_" + id;
    }

    private final void clearPersistentStorage() {
        try {
            this.context.deleteSharedPreferences(this.fileName);
        } catch (Exception e) {
            Log.e(f4150TAG, '[' + this.id + "] Critical failure during identity store wipe", e);
        }
    }

    private final SharedPreferences createEncryptedPrefs(C1664B1 masterKey) {
        SharedPreferences sharedPreferencesM13005mjFkc = SharedPreferencesC4295ofUPN.m13005mjFkc(this.context, this.fileName, masterKey, SharedPreferencesC4295ofUPN.ZfxDd.AES256_SIV, SharedPreferencesC4295ofUPN.KLFTb.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(sharedPreferencesM13005mjFkc, "create(...)");
        return sharedPreferencesM13005mjFkc;
    }

    private final synchronized SharedPreferences getOrInitializePrefs() {
        SharedPreferences sharedPreferencesCreateEncryptedPrefs;
        SharedPreferences sharedPreferences = this.cachedPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        C1664B1 c1664b1M7649mjFkc = new C1664B1.AZxh(this.context).m7648AZxh(C1664B1.wA.AES256_GCM).m7650wA(this.context.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")).m7649mjFkc();
        Intrinsics.checkNotNullExpressionValue(c1664b1M7649mjFkc, "build(...)");
        try {
            sharedPreferencesCreateEncryptedPrefs = createEncryptedPrefs(c1664b1M7649mjFkc);
        } catch (Exception e) {
            Log.e(f4150TAG, '[' + this.id + "] Identity store corrupted, performing factory reset", e);
            clearPersistentStorage();
            sharedPreferencesCreateEncryptedPrefs = createEncryptedPrefs(c1664b1M7649mjFkc);
        }
        this.cachedPrefs = sharedPreferencesCreateEncryptedPrefs;
        return sharedPreferencesCreateEncryptedPrefs;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:6:0x000a, B:8:0x0010, B:10:0x0016, B:16:0x003a, B:15:0x001d), top: B:23:0x0002, inners: #0 }] */
    /* renamed from: delete */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void m4332delete() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorClear;
        this.cachedKeyPair = null;
        SharedPreferences sharedPreferences = this.cachedPrefs;
        this.cachedPrefs = null;
        if (sharedPreferences != null) {
            try {
                editorEdit = sharedPreferences.edit();
            } catch (Exception e) {
                Log.e(f4150TAG, '[' + this.id + "] Failed to clear cached prefs", e);
            }
            if (editorEdit == null || (editorClear = editorEdit.clear()) == null) {
                clearPersistentStorage();
            } else {
                editorClear.commit();
                clearPersistentStorage();
            }
        }
    }

    /* renamed from: load */
    public final synchronized KeyPair m4333load() {
        SharedPreferences orInitializePrefs;
        String string;
        KeyPair keyPair = this.cachedKeyPair;
        if (keyPair != null) {
            return keyPair;
        }
        KeyPair keyPair2 = null;
        try {
            orInitializePrefs = getOrInitializePrefs();
            string = orInitializePrefs.getString(KEY_PRIVATE_KEY, null);
        } catch (Exception e) {
            Log.e(f4150TAG, '[' + this.id + "] Failed to load identity", e);
        }
        if (string == null) {
            return null;
        }
        String string2 = orInitializePrefs.getString(KEY_CERTIFICATE, null);
        if (string2 == null) {
            return null;
        }
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(string, 0)));
        byte[] bArrDecode = Base64.decode(string2, 0);
        CertificateFactory certificateFactory = CertificateFactory.getInstance(CERT_TYPE);
        Intrinsics.checkNotNull(bArrDecode);
        Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream(bArrDecode));
        Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        Intrinsics.checkNotNull(privateKeyGeneratePrivate);
        KeyPair keyPair3 = new KeyPair(privateKeyGeneratePrivate, (X509Certificate) certificateGenerateCertificate);
        this.cachedKeyPair = keyPair3;
        keyPair2 = keyPair3;
        return keyPair2;
    }

    /* renamed from: save */
    public final synchronized void m4334save(KeyPair keyPair) {
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        try {
            getOrInitializePrefs().edit().putString(KEY_PRIVATE_KEY, Base64.encodeToString(keyPair.getPrivateKey().getEncoded(), 0)).putString(KEY_CERTIFICATE, Base64.encodeToString(keyPair.getCertificate().getEncoded(), 0)).apply();
            this.cachedKeyPair = keyPair;
        } catch (Exception e) {
            Log.e(f4150TAG, '[' + this.id + "] Failed to save identity", e);
        }
    }
}
